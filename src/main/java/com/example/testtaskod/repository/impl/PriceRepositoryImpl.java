package com.example.testtaskod.repository.impl;

import com.example.testtaskod.helper.PriceRetriever;
import com.example.testtaskod.repository.PriceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceRetriever priceRetriever;
    private Map<Integer, Float> priceInfoCache;

    public PriceRepositoryImpl(PriceRetriever priceRetriever) {
        this.priceRetriever = priceRetriever;
        this.priceInfoCache = new HashMap<>();
    }

    @Override
    public Map<Integer, Float> retrievePricesByGoodsIds(List<Integer> ids) {
        Map<Integer, Float> prices = new HashMap<>();
        List<Integer> notInCacheIds = new ArrayList<>();

        ids.forEach(id -> {
            if (priceInfoCache.containsKey(id)) {
                prices.put(id, priceInfoCache.get(id));
            } else {
                notInCacheIds.add(id);
            }
        });

        Map<Integer, Float> retrievedPrices = priceRetriever.retrievePricesByGoodsIds(notInCacheIds);
        priceInfoCache.putAll(retrievedPrices);
        prices.putAll(retrievedPrices);

        return prices;
    }

}
