package com.example.testtaskod.controller;

import com.example.testtaskod.model.Bucket;
import com.example.testtaskod.model.CountedBucket;
import com.example.testtaskod.service.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BucketController {

    private final BucketService bucketService;

    @GetMapping("/counted-bucket")
    public CountedBucket getCountedBucket(@RequestBody Bucket bucket) {
        return bucketService.countBucket(bucket);
    }

}
