package com.example.indentity_service.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CongviecResponse {
    String socmnd;
    LocalDate ngayvaocongty;
    String manganh;
    String tencongviec;
    String tencongty;
    String diachicongty;
    String thoigianlamviec;
}
