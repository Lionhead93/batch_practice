package com.seongwou.batchpractice;

import com.seongwou.batchpractice.model.Pay;
import com.seongwou.batchpractice.model.PayRepository;
import com.seongwou.batchpractice.service.PayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("mysql")
@SpringBootTest
public class RollbackTest {

    @Autowired
    PayRepository payRepository;

    @Autowired
    PayService payService;

    @Test
    void transactionRollback() {

        payService.transactionOuter();
    }
}
