package com.upc.boundservice.resources.inputs;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookOutput {
    private Integer id;
    private String name;
    private String author;
    private Integer pages;

}
