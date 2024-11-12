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

public class Truong {

    @Id
    String matruong;
    String tentruong;
    String diachi;
    String sodt;

    @OneToMany (mappedBy = "truong", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Tot_Nghiep> totNghieps;

}
