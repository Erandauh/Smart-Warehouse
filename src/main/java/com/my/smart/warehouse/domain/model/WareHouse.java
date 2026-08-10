package com.my.smart.warehouse.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "WARE_HOUSE")
@Slf4j
public class WareHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID", updatable = false, nullable = false, columnDefinition = "UUID", unique = true)
    private UUID id;

    @Column(name= "NAME")
    private String name;

    @Column(name= "LOC")
    private String location;
}
