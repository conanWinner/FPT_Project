package com.example.indentity_service.controller;


import com.example.indentity_service.dto.request.SearchRequest;
import com.example.indentity_service.dto.request.SinhvienRequestDTO;
import com.example.indentity_service.dto.response.NganhResponse;
import com.example.indentity_service.dto.response.Search2Response;
import com.example.indentity_service.dto.response.SinhvienResponse;
import com.example.indentity_service.service.SinhvienService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/sinhvien")
@RequiredArgsConstructor
@CrossOrigin
public class SinhvienController {

    SinhvienService sinhvienService;

    @PostMapping("/find")
    public List<SinhvienResponse> searchSinhvien(@RequestBody SearchRequest value) {
        return sinhvienService.searchSinhvien(value.getValue());
    }

    @PostMapping("/find2")
    public List<Search2Response> searchCongviec(@RequestBody SearchRequest value) {
        return sinhvienService.searchCongviec(value.getValue());
    }

}
