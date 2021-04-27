package com.seongwou.batchpractice.service;

import com.seongwou.batchpractice.model.Pay;
import com.seongwou.batchpractice.model.PayRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewTransactionWrapper {

    private final PayRepository payRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Pay savePay(Pay pay) {
        return payRepository.save(pay);
    }
}
