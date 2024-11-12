package com.example.indentity_service.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
public class Sinhvien {

    @Id
    String socmnd;
    String hoten;
    String email;
    String sodt;
    String diachi;

    @OneToMany (mappedBy = "sinhvien", cascade = CascadeType.ALL)
    List <Tot_Nghiep> totNghieps;
    @OneToMany (mappedBy = "sinhvien", cascade = CascadeType.ALL)
    List <Cong_Viec> congViecs;

    public Sinhvien() {

    }
}
