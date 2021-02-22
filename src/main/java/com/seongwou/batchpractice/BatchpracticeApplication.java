package com.seongwou.batchpractice;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing // 배치기능 활성화
@SpringBootApplication
public class BatchpracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchpracticeApplication.class, args);
    }

}
