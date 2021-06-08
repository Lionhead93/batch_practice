package com.seongwou.batchpractice.service;

import com.seongwou.batchpractice.model.Pay;
import com.seongwou.batchpractice.model.PayRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayService {

    private final PayRepository payRepository;
    private final PayInnerService payInnerService;
    private final EntityManager entityManager;
    private final NewTransactionWrapper newTransactionWrapper;

    @Transactional(rollbackFor = Exception.class)
    public void transactionOuter() {

        List<Pay> payList = Arrays.asList(new Pay(1000L, "test", LocalDateTime.now()),
                new Pay(900L, "test", LocalDateTime.now()),
                new Pay(1000L, "test", LocalDateTime.now()));

        int successCount = 0;
        int failCount = 0;
        for (Pay pay : payList) {
            try {
                newTransactionWrapper.savePay(pay);
                successCount++;
            } catch (Exception e) {
                failCount++;
                log.error(e.getMessage(), e);
                throw e;
            }
        }
        System.out.println(successCount +"/////"+ failCount);
        throw new RuntimeException("ggg");
    }

    @Transactional
    public void testSaveAll() {
        List<Pay> payList = Arrays.asList(new Pay(1000L, "test", LocalDateTime.now()),
                new Pay(1000L, "test", LocalDateTime.now()),
                new Pay(1000L, "test", LocalDateTime.now()));

        List<Pay> saveAll = payRepository.saveAll(payList);

        System.out.println(saveAll);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(Pay pay) {
        payRepository.save(new Pay(null, null, null));
    }

    @Transactional
    public void flushTest() {

        Optional<Pay> byId = payRepository.findById(1L);
        Pay pay = byId.get();
        log.info("{}", byId.get());
        pay.setAmount(900L);
        payRepository.flush();
        Optional<Pay> byId2 = payRepository.findById(1L);
        log.info("{}", byId2.get());

    }

    @Transactional
    public void detachTest() {
        Pay byId = payRepository.findById(1L).get();
        byId.setAmount(1000L);
        payRepository.save(byId);
        Pay byId2 = payRepository.findById(1L).get();
    }

}
