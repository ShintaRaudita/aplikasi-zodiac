# API Ramalan Zodiak ♎

Proyek Back End RESTful API sederhana yang dirancang untuk mengelola data ramalan zodiak (CRUD). Proyek ini berfokus murni pada pengembangan sisi **Back End** dan dikembangkan sebagai bagian dari **Digital Skill Fair 43.0 - Faculty of IT: Back End**.

---

## Deskripsi Proyek
**API Ramalan Zodiak** adalah layanan backend berbasis Java Spring Boot yang menyediakan antarmuka REST API untuk menyimpan, membaca, memperbarui, dan menghapus data ramalan zodiak. Aplikasi ini menyimpan data langsung ke database relasional (MySQL) dan menyediakan endpoint terstandarisasi untuk diuji menggunakan **Postman** maupun melalui dokumentasi **Swagger/OpenAPI**.

---

## Teknologi yang Digunakan
- **Bahasa Pemrograman**: Java (JDK 21 atau yang kompatibel)
- **Framework**: Spring Boot
- **Database**: MySQL
- **API Documentation**: OpenAPI 3 / Swagger UI (`springdoc-openapi`)
- **API Testing**: Postman

---

## Skema Database
Tabel yang digunakan dalam database memiliki struktur field sebagai berikut:

| Nama Kolom | Tipe Data | Keterangan |
| :--- | :--- | :--- |
| `id` | `BIGINT(10)` | Primary Key, Auto Increment |
| `nama_zodiak` | `VARCHAR(100)` | Nama zodiak (misal: Aries, Libra, dll.) |
| `berita_baik` | `VARCHAR(255)` | Ramalan/berita baik zodiak terkait |
| `berita_buruk` | `VARCHAR(255)` | Ramalan/berita buruk zodiak terkait |

---

## Endpoint API

Base URL: `http://localhost:8080`

| Method | Endpoint | Deskripsi |
| :--- | :--- | :--- |
| **GET** | `/api/zodiacs` | Mengambil semua daftar data zodiak |
| **GET** | `/api/zodiacs/{id}` | Mengambil data zodiak berdasarkan ID |
| **POST** | `/api/zodiacs` | Menambahkan data zodiak baru |
| **PUT** | `/api/zodiacs/{id}` | Memperbarui data zodiak berdasarkan ID |
| **DELETE** | `/api/zodiacs/{id}` | Menghapus data zodiak berdasarkan ID |

---

## Step-by-Step Menjalankan Aplikasi

### 1. Persiapan Database
1. Pastikan **XAMPP / MySQL Service** sudah aktif.
2. Buka **phpMyAdmin** (`http://localhost/phpmyadmin`).
3. Buat database baru bernama `zodiac_db`.
4. Buat tabel dan kolom sesuai dengan skema di atas. *(Catatan: Karena konfigurasi `ddl-auto` diset ke `validate`, tabel dan struktur kolom wajib dibuat manual terlebih dahulu di phpMyAdmin agar aplikasi tidak mengalami error saat startup)*.

### 2. Konfigurasi Database di Proyek
Konfigurasi database pada `src/main/resources/application.properties` sudah disetel sebagai berikut:
```properties
spring.application.name=aplikasi-zodiac

spring.datasource.url=jdbc:mysql://localhost:3306/zodiac_db
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=validate
```

### 3. Menjalankan Aplikasi
Buka terminal / Command Prompt di folder proyek, lalu jalankan perintah berikut:

- **Windows:**
  ```cmd
  mvnw.cmd spring-boot:run
  ```
- **Linux / macOS:**
  ```bash
  ./mvnw spring-boot:run
  ```

Tunggu hingga muncul log:
```text
Started AplikasiZodiacApplication in ... seconds
```
Aplikasi kini berjalan di `http://localhost:8080`.

---

## Pengujian API Menggunakan Postman

### 1. Mengambil Semua Data (GET)
- **Method:** `GET`
- **URL:** `http://localhost:8080/api/zodiacs`
- Klik **Send**.

### 2. Menambahkan Data Baru (POST)
- **Method:** `POST`
- **URL:** `http://localhost:8080/api/zodiacs`
- Pilih tab **Body** > **raw** > pilih tipe **JSON**.
- Masukkan payload JSON:
  ```json
  {
    "nama_zodiak": "Scorpio",
    "berita_baik": "Finansial akan meningkat drastis minggu ini.",
    "berita_buruk": "Hindari membuat keputusan terburu-buru saat emosi."
  }
  ```
- Klik **Send**.

### 3. Mengambil Data Berdasarkan ID (GET by ID)
- **Method:** `GET`
- **URL:** `http://localhost:8080/api/zodiacs/1`
- Klik **Send**.

### 4. Mengubah / Update Data (PUT)
- **Method:** `PUT`
- **URL:** `http://localhost:8080/api/zodiacs/1`
- Pilih tab **Body** > **raw** > **JSON**, lalu masukkan perubahan:
  ```json
  {
    "nama_zodiak": "Scorpio",
    "berita_baik": "Proyek baru berjalan sukses dan lancar.",
    "berita_buruk": "Jaga kesehatan fisik dan jangan begadang."
  }
  ```
- Klik **Send**.

### 5. Menghapus Data (DELETE)
- **Method:** `DELETE`
- **URL:** `http://localhost:8080/api/zodiacs/1`
- Klik **Send**.

---

## Dokumentasi Swagger UI
Selain menggunakan Postman, dokumentasi interaktif endpoint juga dapat diakses melalui browser:
```text
http://localhost:8080/swagger-ui.html
```
