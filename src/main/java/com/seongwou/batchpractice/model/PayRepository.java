package com.seongwou.batchpractice.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PayRepository extends JpaRepository<Pay, Long> {

    @Transactional
    @Modifying
    @Query("update Pay p set p.amount = :amounts where p.id in :ids")
    void updateAmountsByIdInQuery(@Param("ids") List<Long> ids, @Param("amounts") Long amounts);

}
