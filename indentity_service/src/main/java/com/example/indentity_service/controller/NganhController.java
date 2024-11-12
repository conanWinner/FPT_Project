package com.example.indentity_service.controller;

import com.example.indentity_service.dto.response.NganhResponse;
import com.example.indentity_service.service.NganhService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/api/nganh")
@RequiredArgsConstructor
@CrossOrigin

public class NganhController {

    NganhService nganhService;

    @GetMapping
    public List<NganhResponse> getNganhs(){
        return nganhService.getNganhs();
    }

}
