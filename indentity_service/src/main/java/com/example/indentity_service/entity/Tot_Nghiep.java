package com.example.indentity_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@IdClass(TotNghiepId.class)
@Builder
@AllArgsConstructor
public class Tot_Nghiep {

    String hetn;
    LocalDate ngaytn;
    String loaitn;

    @Id @ManyToOne @JoinColumn (name = "socmnd")
    Sinhvien sinhvien;
    @Id @ManyToOne @JoinColumn (name = "matruong")
    Truong truong;
    @Id @ManyToOne @JoinColumn (name = "manganh")
    Nganh nganh;


    public Tot_Nghiep() {

    }
}


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class TotNghiepId implements Serializable {

    String sinhvien;
    String truong;
    String nganh;



    // equals và hashCode để đảm bảo tính toàn vẹn của khóa phức hợp
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotNghiepId that = (TotNghiepId) o;
        return Objects.equals(sinhvien, that.sinhvien) &&
                Objects.equals(truong, that.truong) &&
                Objects.equals(nganh, that.nganh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sinhvien, truong, nganh);
    }
}

