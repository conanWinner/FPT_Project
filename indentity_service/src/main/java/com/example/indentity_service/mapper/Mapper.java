package com.example.indentity_service.mapper;

import com.example.indentity_service.dto.request.UserCreationRequest;
import com.example.indentity_service.dto.response.NganhResponse;
import com.example.indentity_service.dto.response.SinhvienResponse;
import com.example.indentity_service.dto.response.TruongResponse;
import com.example.indentity_service.entity.Nganh;
import com.example.indentity_service.entity.Sinhvien;
import com.example.indentity_service.entity.Truong;
import com.example.indentity_service.entity.User;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    List<NganhResponse> toNganhResponse(List<Nganh> nganh);

    List<TruongResponse> toTruongResponse(List<Truong> truong);

    SinhvienResponse toSinhvienResponse(Sinhvien sinhvien);

}
