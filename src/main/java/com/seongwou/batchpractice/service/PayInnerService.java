package com.seongwou.batchpractice.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class PayInnerService {

    @Transactional
    public void transactionInner() throws IOException {
        throw new IOException();
    }

}
