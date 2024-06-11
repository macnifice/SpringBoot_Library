package com.library.library_rest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private long id;

    private String title;

    private String author;

    private String isbn;
}
