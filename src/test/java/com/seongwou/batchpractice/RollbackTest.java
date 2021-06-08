package com.seongwou.batchpractice;

import com.seongwou.batchpractice.model.Pay;
import com.seongwou.batchpractice.model.PayRepository;
import com.seongwou.batchpractice.service.PayInnerService;
import com.seongwou.batchpractice.service.PayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

@ActiveProfiles("mysql")
@SpringBootTest
public class RollbackTest {

    @Autowired
    PayRepository payRepository;
    @Autowired
    PayInnerService payInnerService;
    @Autowired
    PayService payService;

    @Test
    void transactionRollback() {
        payService.transactionOuter();
    }
    @Test
    void flushTest() {
        payService.flushTest();
    }

    @Test
    void detachTest() {
        payService.detachTest();
    }

    @Test
    void saveAllTest() {
        payService.testSaveAll();
    }

    @Test
    void delete() {
        payRepository.deleteAll();
    }
    @Test
    void deleteBatch() {
        payRepository.deleteAllInBatch();
    }

    @Test
    void update() {

        //given
        List<Long> ids = Arrays.asList(29L, 30L, 31L);

        //when
        payRepository.updateAmountsByIdInQuery(ids, 300L);
        //then

    }

    @Test
    void aopTest() {

        payInnerService.transactionInner();

    }

    @Test
    void reflection() {

        Class c = null;

        c = PayService.class;

        Constructor[] declaredConstructors = c.getDeclaredConstructors();

        Arrays.stream(declaredConstructors).forEach(
                System.out::println
        );

    }
}
