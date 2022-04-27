package com.example.testtaskod.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CountedBucket {

    private List<CountedGood> goods = new ArrayList<>();

    private float total = 0;

}
