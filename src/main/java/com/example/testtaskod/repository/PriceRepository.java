package com.example.testtaskod.repository;

import java.util.List;
import java.util.Map;

public interface PriceRepository {
    Map<Integer, Float> retrievePricesByGoodsIds(List<Integer> ids);
}
