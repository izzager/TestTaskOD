package com.example.testtaskod.helper;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Component
@NoArgsConstructor
public class PriceRetriever {

    public Map<Integer, Float> retrievePricesByGoodsIds(List<Integer> ids) {
        Map<Integer, Float> prices = new HashMap<>();
        ids.forEach(id -> prices.put(id, retrievePriceByGoodId(id)));
        return prices;
    }

    private float retrievePriceByGoodId(int id) {
        return new Random().nextFloat() * id;
    }

}
