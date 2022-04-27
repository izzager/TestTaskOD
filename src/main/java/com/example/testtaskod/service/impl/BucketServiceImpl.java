package com.example.testtaskod.service.impl;

import com.example.testtaskod.model.Bucket;
import com.example.testtaskod.model.CountedBucket;
import com.example.testtaskod.model.CountedGood;
import com.example.testtaskod.model.Good;
import com.example.testtaskod.repository.impl.PriceRepositoryImpl;
import com.example.testtaskod.service.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BucketServiceImpl implements BucketService {

    private final PriceRepositoryImpl priceRepository;

    @Override
    public CountedBucket countBucket(Bucket bucket) {
        List<Integer> ids = getGoodsIds(bucket);
        Map<Integer, Float> prices = priceRepository.retrievePricesByGoodsIds(ids);
        return getCountedBucket(bucket, prices);
    }

    private List<Integer> getGoodsIds(Bucket bucket) {
        List<Integer> ids = new ArrayList<>();
        bucket.getGoods().forEach(good -> ids.add(good.getId()));
        return ids;
    }

    private CountedBucket getCountedBucket(Bucket bucket, Map<Integer, Float> prices) {
        CountedBucket countedBucket = new CountedBucket();
        float total = 0;
        for (Good good : bucket.getGoods()) {
            CountedGood countedGood = getCountedGood(good, prices.get(good.getId()));
            countedBucket.getGoods().add(countedGood);
            total += countedGood.getSum();
        }
        countedBucket.setTotal(total);
        return countedBucket;
    }

    private CountedGood getCountedGood(Good good, float price) {
        CountedGood countedGood = new CountedGood();
        countedGood.setId(good.getId());
        countedGood.setCount(good.getCount());
        countedGood.setSum(good.getCount() * price);
        return countedGood;
    }

}
