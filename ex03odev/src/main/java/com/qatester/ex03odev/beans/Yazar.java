package com.qatester.ex03odev.beans;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor//hangisine onnull dediysek oyle bir constracutor olusturacak.
@Builder//hersey icin ayri ayri constructor olusturmaya gerek yok
@Entity
public class Yazar {

    @Id//buraya id oldugunu belirtmemiz gerekir
    @GeneratedValue(strategy = GenerationType.IDENTITY)//bunu ekleyince her ekleme yapinca id otomatik artaca
    private Long yazarID;

    @NonNull
    private String yazarAdiSoyadi;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)//tarihin formatini belirtmeliyiz
    private LocalDate dogumTarihi;

    private String yazarUlkesi;


}
