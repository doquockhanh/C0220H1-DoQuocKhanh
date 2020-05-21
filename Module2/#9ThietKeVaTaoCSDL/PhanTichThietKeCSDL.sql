CREATE DATABASE test;

USE test;

-- ---------------------------------------------------

CREATE TABLE loai_san_pham(
IDloai_san_pham int PRIMARY KEY AUTO_INCREMENT, 
mo_ta VARCHAR(200)
);

CREATE TABLE san_pham(
IDsan_pham INT PRIMARY KEY AUTO_INCREMENT,
IDloai_san_pham INT,
FOREIGN KEY (IDloai_san_pham) REFERENCES loai_san_pham (IDloai_san_pham),
ten_san_pham VARCHAR(50),
nha_cung_cap VARCHAR(50),
so_luong_con INT,
gia_nhap INT,
gia_ban INT
);

CREATE TABLE van_phong(
IDvan_phong INT PRIMARY KEY AUTO_INCREMENT,
dia_chi VARCHAR(60),
dien_thoai VARCHAR(11),
quoc_gia VARCHAR(30)
);

CREATE TABLE nhan_vien(
IDnhan_vien INT PRIMARY KEY AUTO_INCREMENT,
ten_nhan_vien VARCHAR(40),
email VARCHAR(50),
ten_cong_viec VARCHAR(40),
quan_li INT,
FOREIGN KEY (quan_li) REFERENCES nhan_vien (IDnhan_vien),
IDvan_phong INT,
FOREIGN KEY (IDvan_phong) REFERENCES van_phong (IDvan_phong)
);

CREATE TABLE khach_hang(
ma_khach_hang int PRIMARY KEY AUTO_INCREMENT,
ten_khach_hang VARCHAR(40),
so_dien_thoai VARCHAR(11),
dia_chi VARCHAR(60),
IDnhan_vien INT,
FOREIGN KEY (IDnhan_vien) REFERENCES nhan_vien (IDnhan_vien)
);

CREATE TABLE don_hang(
IDdon_hang INT PRIMARY KEY AUTO_INCREMENT,
ma_khach_hang INT,
FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang (ma_khach_hang),
ngay_mua DATE,
ngay_giao_hang_yeu_cau DATE,
ngay_giao_thuc_te DATE,
so_luong_dat INT,
don_gia INT
);

CREATE TABLE don_hang_san_pham(
IDdon_hang INT,
IDsan_pham INT,
PRIMARY KEY (IDdon_hang, IDsan_pham),
FOREIGN KEY (IDdon_hang) REFERENCES don_hang (IDdon_hang),
FOREIGN KEY (IDsan_pham) REFERENCES san_pham (IDsan_pham)
);

CREATE TABLE thanh_toan(
IDthanh_toan INT PRIMARY KEY AUTO_INCREMENT,
ma_khach_hang INT,
FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang (ma_khach_hang),
ngay_thanh_toan DATE,
so_tien INT
);

-- ---------------------------------------------------------------------
