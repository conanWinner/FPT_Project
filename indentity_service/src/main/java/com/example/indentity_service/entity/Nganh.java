package com.example.indentity_service.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data

public class Nganh {

    @Id
    String manganh;
    String tennganh;
    String loainganh;

    @OneToMany (mappedBy = "nganh", cascade = CascadeType.ALL, orphanRemoval = true)
    List <Cong_Viec> congViecs;

    @OneToMany (mappedBy = "nganh", cascade = CascadeType.ALL, orphanRemoval = true)
    List <Tot_Nghiep> totNghieps;

}
