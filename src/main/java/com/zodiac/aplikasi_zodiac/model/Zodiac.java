package com.zodiac.aplikasi_zodiac.model;

import jakarta.persistence.*;
@Entity // Menandakan kelas ini adalah sebuah tabel di database
@Table(name = "zodiac") // Nama tabel di database nanti
public class Zodiac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_zodiak", nullable = false, unique = true)
    private String name;

    @Column(name = "berita_baik")
    private String beritaBaik;

    @Column(name = "berita_buruk")
    private String beritaBuruk;

    public Zodiac() {
    }

    // Getter dan Setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBeritaBaik() {
        return beritaBaik;
    }
    public void setBeritaBaik(String beritaBaik) {
        this.beritaBaik = beritaBaik;
    }
    public String getBeritaBuruk() {
        return beritaBuruk;
    }
    public void setBeritaBuruk(String beritaBuruk) {
        this.beritaBuruk = beritaBuruk;
    }


} //end public class Zodiac
