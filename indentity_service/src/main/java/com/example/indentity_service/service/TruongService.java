package com.example.indentity_service.service;

import com.example.indentity_service.dto.request.UserCreationRequest;
import com.example.indentity_service.dto.response.NganhResponse;
import com.example.indentity_service.dto.response.TruongResponse;
import com.example.indentity_service.entity.User;
import com.example.indentity_service.mapper.Mapper;
import com.example.indentity_service.mapper.UserMapper;
import com.example.indentity_service.repository.NganhRepository;
import com.example.indentity_service.repository.TruongRepository;
import com.example.indentity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
public class TruongService {

    TruongRepository truongRepository;
    Mapper mapper;

    public List<TruongResponse> getTruongs(){

        return mapper.toTruongResponse(truongRepository.findAll());

    }


}
