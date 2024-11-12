package com.example.indentity_service.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SinhvienRequestDTO {

    private String socmnd;
    private String hoten;
    private String email;
    private String sodt;
    private String diachi;
    private List<TotnghiepRequestDTO> totNghieps;

}
