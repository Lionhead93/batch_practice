package com.seongwou.batchpractice.service;

import com.seongwou.batchpractice.model.Pay;
import com.seongwou.batchpractice.model.PayRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayService {

    private final PayRepository payRepository;
    private final PayInnerService payInnerService;

    @Transactional(noRollbackFor = Exception.class)
    public void transactionOuter() {
        try {
            Pay pay = new Pay(1000L, "txTest", LocalDateTime.now());
            payRepository.save(pay);
            payInnerService.transactionInner();
        } catch (Exception e) {
            log.error("[transactionOuter error]", e);
        }
    }

}
