# Aplikasi Zodiac API ♎

Backend RESTful API service yang dirancang untuk mengelola dan menyajikan data zodiak (seperti nama zodiak, berita baik, dan berita buruk). Proyek ini dikembangkan sebagai bagian dari **Digital Skill Fair 43.0 - Faculty of IT: Back End**.

---

## Deskripsi Proyek
**Aplikasi Zodiac API** adalah layanan backend berbasis Java Spring Boot yang menyediakan antarmuka terstruktur bagi aplikasi klien untuk mengakses informasi zodiak. Aplikasi ini mengimplementasikan arsitektur *clean layered* (Controller-Repository-Model) untuk menjamin pemisahan tanggung jawab (*separation of concerns*), skalabilitas, serta kemudahan *maintenance*. Selain itu, proyek ini dilengkapi dengan dokumentasi OpenAPI/Swagger interaktif guna mempermudah eksplorasi dan pengujian endpoint secara langsung oleh developer.

---

## Fitur Utama
- **Zodiac Data Retrieval**: Menyediakan endpoint untuk mengambil daftar lengkap zodiak beserta rincian atributnya (karakteristik, rentang tanggal lahir, elemen, dll.).
- **Zodiac Lookup / Query**: Endpoint khusus untuk melakukan pencarian atau *filtering* zodiak berdasarkan parameter tertentu (misal: ID atau tanggal).
- **Interactive API Documentation (Swagger/OpenAPI)**: Tersedianya antarmuka Swagger UI untuk eksplorasi spesifikasi API, pengujian *request/response*, dan integrasi frontend tanpa perlu membaca kode sumber secara manual.
- **RESTful Response Standards**: Mengembalikan respon data berformat JSON yang konsisten dengan kode status HTTP standar.

---

## Teknologi yang Digunakan
- **Bahasa Pemrograman**: Java
- **Framework Utama**: Spring Boot
- **Data Access & Persistence**: Spring Data JPA / Repository Pattern
- **API Documentation**: OpenAPI 3 / Swagger UI (`springdoc-openapi`)
- **Build & Dependency Management**: Apache Maven (Maven Wrapper `mvnw`)
- **Testing**: JUnit & Spring Boot Test

---

## Arsitektur & Alur Kerja (Workflow)
Aplikasi ini mengadopsi arsitektur berlapis (*multi-tier architecture*):
1. **Client / Consumer**: Mengirimkan HTTP request melalui browser, Postman, atau Swagger UI.
2. **Controller Layer (`ZodiacController`)**: Menangani routing endpoint, memvalidasi parameter input, dan memetakan respon HTTP.
3. **Repository Layer (`ZodiacRepository`)**: Mengabstraksi komunikasi data dan operasi query terhadap entitas domain.
4. **Model Layer (`Zodiac`)**: Mendefinisikan struktur skema dan representasi objek data zodiak.
5. **JSON Response**: Data yang diproses diserialisasi menjadi format JSON dan dikirimkan kembali ke klien.

---
