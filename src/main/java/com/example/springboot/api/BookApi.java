/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.springboot.api;

import com.example.springboot.model.BookDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-12T13:28:31.884901+02:00[Europe/Madrid]")
@Validated
@Api(value = "book", description = "the book API")
public interface BookApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /book : Add a Book
     *
     * @param book Book to be added in shop (required)
     * @return Book Added (status code 200)
     */
    @ApiOperation(value = "Add a Book", nickname = "addBook", notes = "", response = String.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Book Added", response = String.class) })
    @PostMapping(
        value = "/book",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<String> _addBook(@ApiParam(value = "Book to be added in shop" ,required=true )  @Valid @RequestBody BookDto book) {
        return addBook(book);
    }

    // Override this method
    default  ResponseEntity<String> addBook(BookDto book) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /book : Get Books
     *
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "Get Books", nickname = "getBooks", notes = "", response = BookDto.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = BookDto.class, responseContainer = "List") })
    @GetMapping(
        value = "/book",
        produces = { "application/json" }
    )
    default ResponseEntity<List<BookDto>> _getBooks() {
        return getBooks();
    }

    // Override this method
    default  ResponseEntity<List<BookDto>> getBooks() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"author\" : \"Brandon Sanderson\", \"id\" : 0, \"title\" : \"Oathbringer\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}