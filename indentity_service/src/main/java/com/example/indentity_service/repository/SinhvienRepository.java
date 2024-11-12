package com.example.indentity_service.repository;

import com.example.indentity_service.dto.response.Search2Response;
import com.example.indentity_service.dto.response.SinhvienResponse;
import com.example.indentity_service.entity.Sinhvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinhvienRepository extends JpaRepository<Sinhvien, String> {

    @Query("SELECT new com.example.indentity_service.dto.response.SinhvienResponse(s.socmnd, s.hoten, s.sodt, s.email, s.diachi) FROM Sinhvien s WHERE s.hoten = :value OR s.email = :value OR s.sodt = :value OR s.socmnd = :value")
    List<SinhvienResponse> findSinhvienByHotenOrEmailOrSodt(@Param("value") String value);

    @Query("SELECT new com.example.indentity_service.dto.response.Search2Response(sv.socmnd, sv.hoten, ng.manganh, tn.truong.matruong, cv.tencongty, cv.thoigianlamviec) FROM Cong_Viec as cv\n" +
            "    join cv.sinhvien as sv \n" +
            "    join cv.nganh as ng " +
            "    join sv.totNghieps as tn " +
            " WHERE sv.hoten = :value or sv.sodt = :value")
    List<Search2Response> findCongviec(@Param("value") String value);



}
