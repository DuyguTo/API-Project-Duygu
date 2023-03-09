package com.qatester.ex03odev.repostories;

import com.qatester.ex03odev.beans.Yazar;
import org.springframework.data.jpa.repository.JpaRepository;//hibernate in interfacei

public interface YazarRepostories extends JpaRepository<Yazar,Long> {
}
