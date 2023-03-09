package com.qatester.ex03odev.bootstraps;

import com.qatester.ex03odev.beans.Yazar;
import com.qatester.ex03odev.repostories.YazarRepostories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component//sinifin turunu belitmemiz gereklidir.yoksa calismaz
public class YazarBootstrap implements CommandLineRunner {

    @Autowired
    YazarRepostories yazarRepostories;//bu repostory benim hibernate frameworkum

    @Override
    public void run(String... args) throws Exception {
        Yazar yazar = new Yazar();
        yazar.setYazarAdiSoyadi("Ahmet Bulut");
        yazar.setYazarUlkesi("Turkiye");
        yazar.setDogumTarihi(LocalDate.parse("1960-01-01"));

        yazarRepostories.save(yazar);

        yazarRepostories.save(Yazar.builder().yazarAdiSoyadi("Mehmet Ay").yazarUlkesi("Turkiye").dogumTarihi(LocalDate.parse("1985-01-01")).build());
        yazarRepostories.save(new Yazar(0L,"Ayse Sasa",LocalDate.parse("1952-01-01"),"Turkiye"));
        yazarRepostories.save(new Yazar("Mustafa Ulusoy"));
    }

}
