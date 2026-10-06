package com.zodiac.aplikasi_zodiac.repository;

import com.zodiac.aplikasi_zodiac.model.Zodiac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Menandakan ini adalah sebuah Spring Bean untuk akses data
public interface ZodiacRepository extends JpaRepository<Zodiac, Long> {
}
