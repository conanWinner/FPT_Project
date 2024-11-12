package com.example.indentity_service.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TotnghiepRequestDTO {

    String socmnd;
    String hetn;
    LocalDate ngaytn;
    String loaitn;
    String matruong;
    String manganh;

}
