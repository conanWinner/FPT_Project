package com.example.indentity_service.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Search2Response {

    String socmnd;
    String hoten;
    String manganh;
    String matruong;
    String tencongty;
    String thoigianlamviec;

}
