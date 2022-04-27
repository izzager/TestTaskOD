package com.example.testtaskod.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Bucket {

    private List<Good> goods;

    private AdditionalData additionalData;

}
