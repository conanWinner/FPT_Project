package com.example.indentity_service.repository;

import com.example.indentity_service.entity.Tot_Nghiep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotnghiepRepository extends JpaRepository<Tot_Nghiep, String> {
}
