package com.inditex.retail.pricing.prices.infrastructure.rest.spring;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.retail.pricing.prices.core.model.Price;
import com.inditex.retail.pricing.prices.infrastructure.entity.PriceEntity;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.dto.PriceDto;
import com.inditex.retail.pricing.prices.infrastructure.rest.spring.mapper.PriceMapperTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
public class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper;

	private final List<Price> prices;

	public ApplicationTests() throws IOException {
		objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
		File resource = ResourceUtils.getFile("classpath:data.json");
		String data = new String(Files.readAllBytes(resource.toPath()));
		prices = new ArrayList<>(objectMapper.readValue(data, new TypeReference<List<PriceEntity>>() {}));
	}

	@Test
	public void getPricesOk() throws Exception {
		MockHttpServletRequestBuilder request = get("/prices").contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		List<PriceDto> priceDtos = new ArrayList<>(objectMapper.readValue(result, new TypeReference<List<PriceDto>>() {}));
		assertEquals(prices.size(), priceDtos.size());

		for (int i = 0; i < prices.size(); i++) {
			PriceMapperTest.assertPriceAndPriceDto(prices.get(i), priceDtos.get(i));
		}
	}

	@Test
	void findPrices0() throws Exception {
		MockHttpServletRequestBuilder request = get("/prices/2/2?date=2017-07-21T17:32:28Z").contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).andExpect(status().isNotFound()).andReturn();
	}

	@Test
	void findPrices1() throws Exception {
		MockHttpServletRequestBuilder request = get("/prices/1/35455?date=2020-06-14T10:00:00Z").contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		PriceDto priceDto = objectMapper.readValue(result, new TypeReference<>() {});
		assertEquals(1, priceDto.getId());
	}

	@Test
	void findPrices2() throws Exception {
		MockHttpServletRequestBuilder request = get("/prices/1/35455?date=2020-06-14T16:00:00Z").contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		PriceDto priceDto = objectMapper.readValue(result, new TypeReference<>() {});
		assertEquals(2, priceDto.getId());
	}

	@Test
	void findPrices3() throws Exception {
		MockHttpServletRequestBuilder request = get("/prices/1/35455?date=2020-06-14T21:00:00Z").contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		PriceDto priceDto = objectMapper.readValue(result, new TypeReference<>() {});
		assertEquals(1, priceDto.getId());
	}

	@Test
	void findPrices4() throws Exception {
		MockHttpServletRequestBuilder request = get("/prices/1/35455?date=2020-06-15T10:00:00Z").contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		PriceDto priceDto = objectMapper.readValue(result, new TypeReference<>() {});
		assertEquals(3, priceDto.getId());
	}

	@Test
	void findPrices5() throws Exception {
		MockHttpServletRequestBuilder request = get("/prices/1/35455?date=2020-06-16T21:00:00Z").contentType(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		PriceDto priceDto = objectMapper.readValue(result, new TypeReference<>() {});
		assertEquals(4, priceDto.getId());
	}
}
