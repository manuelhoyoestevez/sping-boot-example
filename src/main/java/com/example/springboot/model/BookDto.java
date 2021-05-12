package com.example.springboot.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BookDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-05-12T13:28:31.884901+02:00[Europe/Madrid]")
public class BookDto   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("author")
  private String author;

  public BookDto id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BookDto title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  */
  @ApiModelProperty(example = "Oathbringer", value = "")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BookDto author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
  */
  @ApiModelProperty(example = "Brandon Sanderson", value = "")


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookDto book = (BookDto) o;
    return Objects.equals(this.id, book.id) &&
        Objects.equals(this.title, book.title) &&
        Objects.equals(this.author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BookDto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

