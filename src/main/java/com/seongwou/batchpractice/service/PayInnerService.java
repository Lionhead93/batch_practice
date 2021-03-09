package com.seongwou.batchpractice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayInnerService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void transactionInner() {
        throw new RuntimeException("inner Exception!");
    }

}
