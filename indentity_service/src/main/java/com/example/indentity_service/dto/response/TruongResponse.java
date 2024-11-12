package com.example.indentity_service.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TruongResponse {
    String matruong;
    String tentruong;
    String diachi;
    String sodt;
}
