CREATE DATABASE furama_resort;

USE furama_resort;

-- --------------------------------------------------------------------------

-- NHAN VIEN

CREATE TABLE vi_tri(
IDvi_tri int PRIMARY KEY AUTO_INCREMENT,
Ten_vi_tri VARCHAR(45) 
);

CREATE TABLE trinh_do(
IDtrinh_do INT PRIMARY KEY AUTO_INCREMENT,
trinh_do VARCHAR(45)
);

CREATE TABLE bo_phan(
IDbo_phan int PRIMARY KEY AUTO_INCREMENT,
ten_bo_phan VARCHAR(45)
);

CREATE TABLE nhan_vien(
IDnhan_vien int PRIMARY KEY AUTO_INCREMENT,
ho_ten VARCHAR(45),
ngay_sinh DATE,
so_cmnd VARCHAR(10),
luong VARCHAR(45),
so_dien_thoai VARCHAR(45),
email VARCHAR(45),
dia_chi VARCHAR(45),
IDtrinh_do INT,
FOREIGN KEY (IDtrinh_do) REFERENCES trinh_do (IDtrinh_do),
IDbo_phan INT,
FOREIGN KEY (IDbo_phan) REFERENCES bo_phan (IDbo_phan),
IDvi_tri int,
FOREIGN KEY (IDvi_tri) REFERENCES vi_tri (IDvi_tri)
);

-- -------------------------------------------------------------------------

-- KHACH HANG 

CREATE TABLE loai_khach(
IDloai_khach INT PRIMARY KEY AUTO_INCREMENT,
ten_loai_khach VARCHAR(45)
);

CREATE TABLE khach_hang(
IDkhach_hang INT PRIMARY KEY AUTO_INCREMENT,
IDloai_khach INT,
FOREIGN KEY (IDloai_khach) REFERENCES loai_khach (IDloai_khach),
ho_ten VARCHAR(45),
ngay_sinh DATE,
so_cmnd VARCHAR(45),
so_dien_thoai VARCHAR(45),
email VARCHAR(45),
dia_chi VARCHAR(45)
);

-- ------------------------------------------------------------------------

-- DICH VU 

CREATE TABLE loai_dich_vu(
IDloai_dich_vu int PRIMARY KEY AUTO_INCREMENT,
ten_loai_dich_vu VARCHAR(45)
);

CREATE TABLE kieu_thue(
IDkieu_thue int PRIMARY KEY AUTO_INCREMENT,
ten_kieu_thue VARCHAR(45),
gia INT
);

CREATE TABLE dich_vu(
IDdich_vu INT PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu VARCHAR(45),
so_tang int,
so_nguoi_toi_da VARCHAR(45),
chi_phi_thue VARCHAR(45),
IDkieu_thue INT,
FOREIGN KEY (IDkieu_thue) REFERENCES kieu_thue (IDkieu_thue),
IDloai_dich_vu INT,
FOREIGN KEY (IDloai_dich_vu) REFERENCES loai_dich_vu (IDloai_dich_vu),
trang_thai VARCHAR(45)
);

CREATE TABLE dich_vu_di_kem(
IDdich_vu_di_kem int PRIMARY KEY AUTO_INCREMENT,
ten_dich_vu_di_kem VARCHAR(45),
gia INT,
don_vi INT,
trang_thai_kha_dung VARCHAR(45)
);

-- ------------------------------------------------------------------

-- HOP DONG

CREATE TABLE hop_dong(
IDhop_dong INT PRIMARY KEY AUTO_INCREMENT,
IDnhan_vien INT,
FOREIGN KEY (IDnhan_vien) REFERENCES nhan_vien (IDnhan_vien),
IDkhach_hang INT,
FOREIGN KEY (IDkhach_hang) REFERENCES khach_hang (IDkhach_hang),
IDdich_vu INT,
FOREIGN KEY (IDdich_vu) REFERENCES dich_vu (IDdich_vu),
ngay_lam_hop_dong DATE,
ngay_ket_thuc DATE,
tien_dat_coc INT,
tong_tien INT
);

CREATE TABLE hop_dong_chi_tiet(
IDhop_dong_chi_tiet INT PRIMARY KEY AUTO_INCREMENT,
IDhop_dong INT , 
FOREIGN KEY (IDhop_dong) REFERENCES hop_dong (IDhop_dong),
IDdich_vu_di_kem INT,
FOREIGN KEY (IDdich_vu_di_kem) REFERENCES dich_vu_di_kem (IDdich_vu_di_kem),
so_luong INT
); 