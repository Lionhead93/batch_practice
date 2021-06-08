package com.seongwou.batchpractice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Receipts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vat;

    private Long fee;

}