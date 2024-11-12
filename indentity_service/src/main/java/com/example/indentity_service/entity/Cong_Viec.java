package com.example.indentity_service.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@IdClass(Cong_Viec_Id.class)


public class Cong_Viec {

    @Id
    LocalDate ngayvaocongty;
    String tencongviec;
    String tencongty;
    String diachicongty;
    String thoigianlamviec;

    @Id @ManyToOne @JoinColumn ( name = "socmnd")
    Sinhvien sinhvien;
    @ManyToOne @JoinColumn ( name = "manganh")
    Nganh nganh;

}

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
class Cong_Viec_Id implements Serializable {

    String sinhvien;
    LocalDate ngayvaocongty;

    // equals và hashCode để đảm bảo tính toàn vẹn của khóa phức hợp
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cong_Viec_Id that = (Cong_Viec_Id) o;
        return Objects.equals(sinhvien, that.sinhvien) &&
                Objects.equals(ngayvaocongty, that.ngayvaocongty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sinhvien, ngayvaocongty);
    }
}


