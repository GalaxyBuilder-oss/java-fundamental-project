# Security Policy

## 🧭 Project: Project PUB System

Aplikasi ini dibangun dengan [Spring Boot 3](https://spring.io/projects/spring-boot), menggunakan modul:
- Web MVC
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL Connector

---

## 📢 Melaporkan Kerentanan

Jika kamu menemukan bug/celah keamanan, mohon **jangan** langsung membuat issue publik.

### Kirim laporan ke:
📧 **galaxybuilder.oss@gmail.com**  
Subjek email: `[SECURITY] Laporan Kerentanan PUB System`

Harap sertakan:
- Penjelasan celah
- Langkah reproduksi
- PoC (jika memungkinkan)
- Screenshot / log pendukung

🕒 Kami akan membalas dalam waktu **1–3 hari kerja**.

---

## 🧱 Komponen Keamanan

### ✅ Autentikasi
- Menggunakan **Spring Security**
- Form-based login + session management
- Proteksi terhadap CSRF diaktifkan

### 🧑‍💻 Otorisasi
- Role-based access menggunakan anotasi seperti `@PreAuthorize`, `@Secured`, dll.
- Validasi endpoint API hanya dapat diakses oleh role tertentu

### 🔐 Penyimpanan Data
- Password pengguna disimpan dalam bentuk **hash**, bukan plaintext (gunakan `BCryptPasswordEncoder`)
- Koneksi database dikonfigurasi lewat environment variable atau secrets, **jangan hardcoded**

### 🛡️ Proteksi Tambahan
- CSRF protection aktif pada semua form
- XSS protection dengan escape otomatis dari Thymeleaf
- Session timeout dan session invalidation diatur di konfigurasi Spring Security

---

## 🧪 Testing & Audit

Pengujian keamanan dilakukan dengan:
- `spring-boot-starter-test` untuk unit & integration test
- Manual testing endpoint REST (dengan Postman/Insomnia)
- Audit kode (code review internal)

---

## 🤝 Kontribusi Aman

Kalau kamu ingin berkontribusi:
- Jangan commit password, token, atau credential apa pun.
- Gunakan `@Valid` dan `@NotNull` untuk validasi input
- Jangan bypass filter/security handler

---

## 🔒 Policy Patch

Setiap patch keamanan:
- Akan diberi label `[security]`
- Dirilis secepatnya sebagai patch version
- Didokumentasikan di `CHANGELOG.md`

---

## ⚠️ Known Risks

Berikut beberapa hal yang **belum** diterapkan secara default (harus diimplementasi manual):
- Rate limiting login (hindari brute force)
- Audit trail user activity
- Secure logout handler

---

## 📅 Rencana Audit Keamanan

Audit dilakukan setiap:
- Ada penambahan fitur baru
- Migrasi dependency besar (Spring Boot, DB Driver, dsb)
- Setiap 3 bulan sekali minimal (jika tidak ada perubahan besar)

---

Kami percaya bahwa keamanan adalah hasil kolaborasi. Terima kasih atas kontribusimu! 💪
