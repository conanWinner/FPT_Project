package com.example.indentity_service.service;

import com.example.indentity_service.dto.response.Search2Response;
import com.example.indentity_service.dto.response.SinhvienResponse;
import com.example.indentity_service.repository.SinhvienRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
public class SinhvienService {

    SinhvienRepository sinhvienRepository;

    public List<SinhvienResponse> searchSinhvien (String value) {
        return sinhvienRepository.findSinhvienByHotenOrEmailOrSodt(value);
    }

    public List<Search2Response> searchCongviec (String value) {
        return sinhvienRepository.findCongviec(value);
    }

}
