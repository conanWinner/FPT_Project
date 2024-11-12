package com.example.indentity_service.controller;

import com.example.indentity_service.dto.request.SinhvienRequestDTO;
import com.example.indentity_service.dto.response.SinhvienResponse;
import com.example.indentity_service.entity.Sinhvien;
import com.example.indentity_service.mapper.Mapper;
import com.example.indentity_service.service.KhaibaoService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sinhvien")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin
public class KhaibaoController {

    KhaibaoService khaibaoService;
    Mapper mapper;

    @PostMapping("/add")
    public SinhvienResponse addSinhvien(@RequestBody SinhvienRequestDTO sinhvienRequestDTO) {
        return mapper.toSinhvienResponse(khaibaoService.saveKhaibao(sinhvienRequestDTO));
    }

}
