package com.hansreidan.store.devtiroTutorial.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Libro {

    private String isbn;
    private String titolo;
    private Long autoreId;

}
