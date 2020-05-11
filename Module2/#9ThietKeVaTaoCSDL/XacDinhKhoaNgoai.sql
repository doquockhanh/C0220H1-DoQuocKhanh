CREATE DATABASE bank;

USE bank;

-- ----------------------------------------------------------------

CREATE TABLE accounts(
so_tai_khoan int PRIMARY KEY AUTO_INCREMENT,
kieu_tai_khoan VARCHAR(10),
ngay_mo_tai_khoan DATE,
so_du INT
);

CREATE TABLE customer(
IDcustomer INT PRIMARY KEY AUTO_INCREMENT,
full_name VARCHAR(40),
dia_chi VARCHAR(60),
email VARCHAR(50),
so_dien_thoai VARCHAR(10),
so_tai_khoan int,
FOREIGN KEY (so_tai_khoan) REFERENCES accounts (so_tai_khoan)
);

CREATE TABLE transactions(
ma_giao_dich VARCHAR(20),
so_TK_giao_dich INT,
thoi_gian_giao_dich DATE,
so_tien_giao_dich INT,
mo_ta_giao_dich VARCHAR(100),
so_tai_khoan int,
FOREIGN KEY (so_tai_khoan) REFERENCES accounts (so_tai_khoan)
);