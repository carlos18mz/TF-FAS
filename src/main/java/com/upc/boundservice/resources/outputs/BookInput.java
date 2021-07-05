package com.upc.boundservice.resources.outputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookInput {
    private String name;
    private String author;
    private Integer pages;

}
