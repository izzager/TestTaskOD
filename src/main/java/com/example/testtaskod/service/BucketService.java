package com.example.testtaskod.service;

import com.example.testtaskod.model.Bucket;
import com.example.testtaskod.model.CountedBucket;

public interface BucketService {
    CountedBucket countBucket(Bucket bucket);
}
