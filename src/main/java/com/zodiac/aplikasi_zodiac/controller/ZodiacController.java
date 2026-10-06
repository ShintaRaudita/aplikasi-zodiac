package com.zodiac.aplikasi_zodiac.controller;

import com.zodiac.aplikasi_zodiac.model.Zodiac;
import com.zodiac.aplikasi_zodiac.repository.ZodiacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Menandakan kelas ini adalah Controller untuk REST API
@RequestMapping("/api/zodiacs") // Base URL untuk semua endpoint di controller ini
public class ZodiacController {
    // Meminta Spring untuk menyediakan object ZodiacRepository secara otomatis
    @Autowired
    private ZodiacRepository zodiacRepository;

    /**
     * CREATE: Endpoint untuk membuat data zodiak baru
     * Method: POST
     * URL: http://localhost:8080/api/zodiacs
     */
    @PostMapping
    public Zodiac createZodiac(@RequestBody Zodiac zodiac) {
        return zodiacRepository.save(zodiac);
    }

    /**
     * READ: Endpoint untuk mengambil semua data zodiak
     * Method: GET
     * URL: http://localhost:8080/api/zodiacs
     */
    @GetMapping
    public List<Zodiac> getAllZodiacs() {
        return zodiacRepository.findAll();
    }

    /**
     * READ: Endpoint untuk mengambil satu data zodiak berdasarkan ID.
     * Method: GET
     * URL: http://localhost:8080/api/zodiacs/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Zodiac> getZodiacById(@PathVariable Long id) {
        Optional<Zodiac> zodiac = zodiacRepository.findById(id);
        // Jika data ditemukan, kembalikan data dengan status 200 OK.
        // Jika tidak, kembalikan status 404 Not Found.
        return zodiac.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * UPDATE: Endpoint untuk memperbarui data zodiak berdasarkan ID.
     * Method: PUT
     * URL: http://localhost:8080/api/zodiacs/{id}
     * Body: JSON data zodiak yang baru
     */
    @PutMapping("/{id}")
    public ResponseEntity<Zodiac> updateZodiac(@PathVariable Long id, @RequestBody Zodiac zodiacDetails) {
        Optional<Zodiac> optionalZodiac = zodiacRepository.findById(id);

        if (optionalZodiac.isPresent()) {
            Zodiac existingZodiac = optionalZodiac.get();
            existingZodiac.setName(zodiacDetails.getName());
            existingZodiac.setBeritaBaik(zodiacDetails.getBeritaBaik());
            existingZodiac.setBeritaBuruk(zodiacDetails.getBeritaBuruk());

            // Simpan perubahan ke database
            Zodiac updatedZodiac = zodiacRepository.save(existingZodiac);
            return ResponseEntity.ok(updatedZodiac);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE: Endpoint untuk menghapus data zodiak berdasarkan ID.
     * Method: DELETE
     * URL: http://localhost:8080/api/zodiacs/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZodiac(@PathVariable Long id) {
        if (zodiacRepository.existsById(id)) {
            zodiacRepository.deleteById(id);
            // Kembalikan status 204 No Content yang menandakan sukses tanpa body.
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} //end public class ZodiacController
