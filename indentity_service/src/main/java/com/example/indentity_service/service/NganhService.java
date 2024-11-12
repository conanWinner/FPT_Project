package com.example.indentity_service.service;

import com.example.indentity_service.dto.response.NganhResponse;
import com.example.indentity_service.entity.Nganh;
import com.example.indentity_service.mapper.Mapper;
import com.example.indentity_service.repository.NganhRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
public class NganhService {

    NganhRepository nganhRepository;
    Mapper mapper;

    public List<NganhResponse> getNganhs(){

        return mapper.toNganhResponse(nganhRepository.findAll());

    }


}
