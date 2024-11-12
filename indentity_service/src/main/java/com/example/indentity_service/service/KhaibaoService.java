package com.example.indentity_service.service;


import com.example.indentity_service.dto.request.SinhvienRequestDTO;
import com.example.indentity_service.dto.request.TotnghiepRequestDTO;
import com.example.indentity_service.entity.*;
import com.example.indentity_service.repository.NganhRepository;
import com.example.indentity_service.repository.SinhvienRepository;
import com.example.indentity_service.repository.TotnghiepRepository;
import com.example.indentity_service.repository.TruongRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
public class KhaibaoService {

    SinhvienRepository sinhvienRepository;
    TruongRepository truongRepository;
    NganhRepository nganhRepository;

    @Transactional
    public Sinhvien saveKhaibao(SinhvienRequestDTO sinhvienRequestDTO) {

        Sinhvien sinhvien = Sinhvien.builder()
                .socmnd(sinhvienRequestDTO.getSocmnd())
                .email(sinhvienRequestDTO.getEmail())
                .hoten(sinhvienRequestDTO.getHoten())
                .sodt(sinhvienRequestDTO.getSodt())
                .build();


        List<Tot_Nghiep> totNghieps = new ArrayList<>();

        for (TotnghiepRequestDTO totnghiepRequestDTO: sinhvienRequestDTO.getTotNghieps()) {

            Truong truong = truongRepository.findById(totnghiepRequestDTO.getMatruong())
                    .orElseThrow(() -> new RuntimeException("Trường không tồn tại"));
            Nganh nganh = nganhRepository.findById(totnghiepRequestDTO.getManganh())
                    .orElseThrow(() -> new RuntimeException("Ngành không tồn tại"));

            Tot_Nghiep totNghiep = Tot_Nghiep.builder()
                    .hetn(totnghiepRequestDTO.getHetn())
                    .loaitn(totnghiepRequestDTO.getLoaitn())
                    .ngaytn(totnghiepRequestDTO.getNgaytn())
                    .truong(truong)
                    .nganh(nganh)
                    .sinhvien(sinhvien)
                    .build();

            totNghieps.add(totNghiep);

        }

        sinhvien.setTotNghieps(totNghieps);

        return sinhvienRepository.save(sinhvien);

    }

}

/*
*
*
*
* // Tạo đối tượng Sinhvien từ DTO
        Sinhvien sinhvien = new Sinhvien();
        sinhvien.setSoCMND(sinhvienRequestDTO.getSoCMND());
        sinhvien.setHoTen(sinhvienRequestDTO.getHoTen());
        sinhvien.setEmail(sinhvienRequestDTO.getEmail());
        sinhvien.setSoDT(sinhvienRequestDTO.getSoDT());
        sinhvien.setDiaChi(sinhvienRequestDTO.getDiaChi());

        // Tạo danh sách các bản ghi tốt nghiệp từ DTO
        List<Tot_Nghiep> totNghieps = new ArrayList<>();
        for (TotNghiepRequestDTO totNghiepDTO : sinhvienRequestDTO.getTotNghieps()) {
            Tot_Nghiep totNghiep = new Tot_Nghiep();
            totNghiep.setHeTN(totNghiepDTO.getHeTN());
            totNghiep.setNgayTN(totNghiepDTO.getNgayTN());
            totNghiep.setLoaiTN(totNghiepDTO.getLoaiTN());
            totNghiep.setSinhvien(sinhvien); // Liên kết Tot_Nghiep với Sinhvien

            // Tìm và thiết lập đối tượng Truong và Nganh từ cơ sở dữ liệu
            Truong truong = truongRepository.findById(totNghiepDTO.getMaTruong())
                .orElseThrow(() -> new RuntimeException("Trường không tồn tại"));
            Nganh nganh = nganhRepository.findById(totNghiepDTO.getMaNganh())
                .orElseThrow(() -> new RuntimeException("Ngành không tồn tại"));

            totNghiep.setTruong(truong);
            totNghiep.setNganh(nganh);

            totNghieps.add(totNghiep);
        }

        // Thiết lập danh sách tốt nghiệp cho sinh viên
        sinhvien.setTotNghieps(totNghieps);

        // Lưu sinh viên cùng các bản ghi tốt nghiệp vào cơ sở dữ liệu
        return sinhvienRepository.save(sinhvien);
*
*
*
*
*
* */
