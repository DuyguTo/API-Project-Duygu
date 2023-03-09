package com.qatester.ex03odev.controllers;

import com.qatester.ex03odev.beans.Yazar;
import com.qatester.ex03odev.repostories.YazarRepostories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class YazarController {

    @Autowired//dependency injection yapar
    YazarRepostories yazarRepostories;

    @GetMapping
    public List<Yazar> getAllYazar() {
        return yazarRepostories.findAll();

    }

    @GetMapping("/{id}")
    public Yazar getYazarById(@PathVariable Long id){
        return yazarRepostories.findById(id).get();

    }

    @PostMapping(consumes = "application/json")//postla bir kayit ekleniyor
    public List<Yazar> addYazar(@RequestBody Yazar yazar){
        yazarRepostories.save(yazar);
        return yazarRepostories.findAll();
    }

    @PutMapping(consumes = "application/json")//butun datayi silip yeni datalari ekler
    public List<Yazar> replaceYazarList(@RequestBody List<Yazar> yazarList){
        yazarRepostories.deleteAll();
        yazarRepostories.saveAll(yazarList);
        return yazarRepostories.findAll();
    }

    @PutMapping(value = "/{id}",consumes ="application/json" )//sadece bir kayit silip yerine teni kayit koyuyoruz
    public List<Yazar> replaceYazar(@PathVariable Long id,@RequestBody Yazar yazar){//request body:sana gelecek bilginin tamami
        yazarRepostories.deleteById(id);
        yazarRepostories.save(yazar);
        return yazarRepostories.findAll();
    }

    @PatchMapping(value = "/{id}",consumes ="application/json" )//Bir kaydin ozelliklerini degistirdik
    public List<Yazar> updateYazar(@PathVariable Long id,@RequestBody Yazar yeniYazar){//request body:sana gelecek bilginin tamami
      Yazar eskiYazar = yazarRepostories.findById(id).get();//ilk once gidip degistirmek istedigim kitabi buldum

      eskiYazar.setYazarAdiSoyadi(yeniYazar.getYazarAdiSoyadi());//eski yazarin yazar adini yeno gelen yazarin yazar adi ile degistir
      eskiYazar.setYazarUlkesi(yeniYazar.getYazarUlkesi());
      yazarRepostories.save(eskiYazar);
      return yazarRepostories.findAll();

    }

    @DeleteMapping(value = "/{id}")
    public List<Yazar> deleteYazar(@PathVariable Long id){
        yazarRepostories.deleteById(id);
        return yazarRepostories.findAll();
    }

    @DeleteMapping()
    public List<Yazar> deleteAllYazar(){
        yazarRepostories.deleteAll();
        return yazarRepostories.findAll();
    }



}
