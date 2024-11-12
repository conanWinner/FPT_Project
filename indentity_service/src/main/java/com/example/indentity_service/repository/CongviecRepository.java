package com.example.indentity_service.repository;

import com.example.indentity_service.entity.Cong_Viec;
import com.example.indentity_service.entity.Nganh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongviecRepository extends JpaRepository<Cong_Viec, String> {
}
