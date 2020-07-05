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

-- ----------------------------------------------------
-- YÊU CẦU 1 : THEM THONG TIN CHO TAT CA CAC BANG

-- THEM THONG TIN BANG BO PHAN
INSERT INTO `furama_resort`.`bo_phan` (`IDbo_phan`, `ten_bo_phan`) VALUES ('1', 'FM-CSKH');
INSERT INTO `furama_resort`.`bo_phan` (`IDbo_phan`, `ten_bo_phan`) VALUES ('2', 'FM-QLCS');

-- THEM THONG TIN BANG TRINH DO
INSERT INTO `furama_resort`.`trinh_do` (`IDtrinh_do`, `trinh_do`) VALUES ('1', 'dai hoc');
INSERT INTO `furama_resort`.`trinh_do` (`IDtrinh_do`, `trinh_do`) VALUES ('2', 'cao dang');
INSERT INTO `furama_resort`.`trinh_do` (`IDtrinh_do`, `trinh_do`) VALUES ('3', 'trung cap');

-- THEM THONG TIN BANG VI TRI
INSERT INTO `furama_resort`.`vi_tri` (`IDvi_tri`, `Ten_vi_tri`) VALUES ('1', 'quan li');
INSERT INTO `furama_resort`.`vi_tri` (`IDvi_tri`, `Ten_vi_tri`) VALUES ('2', 'nhan vien');


-- THEM THONG TIN BANG NHAN VIEN 
INSERT INTO `furama_resort`.`nhan_vien` (`ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `IDtrinh_do`, `IDbo_phan`, `IDvi_tri`) VALUES ('Đỗ Quốc Khánh', '2001-09-02', '12345678', '10000000', '123581321', 'khanhquocdo.qt', 'da nang', '1', '1', '1');
INSERT INTO `furama_resort`.`nhan_vien` (`ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `IDtrinh_do`, `IDbo_phan`, `IDvi_tri`) VALUES ('Đỗ Quốc Huy', '1999-09-16', '87654321', '10000000', '133555567', 'huy16905', 'quang tri', '1', '1', '2');
INSERT INTO `furama_resort`.`nhan_vien` (`ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `IDtrinh_do`, `IDbo_phan`, `IDvi_tri`) VALUES ('Nguyễn Ngọc Luân', '1969-01-01', '43125678', '20000000', '244466666', 'luan1169', 'quang nam', '2', '2', '1');
INSERT INTO `furama_resort`.`nhan_vien` (`ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `IDtrinh_do`, `IDbo_phan`, `IDvi_tri`) VALUES ('Nguyễn Hoàng Đại Nghĩa', '1999-09-06', '56748231', '15000000', '472874351', 'nghia6999', 'da nang', '3', '2', '2');
INSERT INTO `furama_resort`.`nhan_vien` (`ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `IDtrinh_do`, `IDbo_phan`, `IDvi_tri`) VALUES ('Trần Quang Đức', '1990-09-06', '56724781', '15000000', '276498162', 'duc0609', 'da nang', '3', '2', '2');

-- THEM THONG TIN LOAI KHACH HANG
INSERT INTO `furama_resort`.`loai_khach` (`IDloai_khach`, `ten_loai_khach`) VALUES ('1', 'SLIVER');
INSERT INTO `furama_resort`.`loai_khach` (`IDloai_khach`, `ten_loai_khach`) VALUES ('2', 'GOLD');
INSERT INTO `furama_resort`.`loai_khach` (`IDloai_khach`, `ten_loai_khach`) VALUES ('3', 'PLASTINUM');
INSERT INTO `furama_resort`.`loai_khach` (`IDloai_khach`, `ten_loai_khach`) VALUES ('4', 'DIAMOND');

-- THEM THONG TIN KHACH HANG 
INSERT INTO `furama_resort`.`khach_hang` (`IDkhach_hang`, `IDloai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES ('1', '4', 'Lê Hữu Ái', '1990-03-05', '22447733', '12563653472', 'aile05031990', 'Quảng Ngãi');
INSERT INTO `furama_resort`.`khach_hang` (`IDkhach_hang`, `IDloai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES ('2', '3', 'Lê Việt Nhật ', '1969-08-12', '57483942', '75647387459', 'vietnhat1208', 'Quảng Trị');
INSERT INTO `furama_resort`.`khach_hang` (`IDkhach_hang`, `IDloai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES ('3', '2', 'Đỗ Quốc Khánh', '2001-09-02', '45634587', '39252343472', 'khanhquocdo.qt', 'Đà Nẵng');
INSERT INTO `furama_resort`.`khach_hang` (`IDkhach_hang`, `IDloai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES ('4', '4', 'Đại Nghĩa', '1994-07-30', '47293624', '23746254673', 'dainghia3007', 'Vinh');
INSERT INTO `furama_resort`.`khach_hang` (`IDkhach_hang`, `IDloai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES ('5', '1', 'Nguyễn Văn Tân', '2003-07-01', '48535724', '2973682073', 'vantan0107', 'Hà Nội');
INSERT INTO `furama_resort`.`khach_hang` (`IDkhach_hang`, `IDloai_khach`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `so_dien_thoai`, `email`, `dia_chi`) VALUES ('6', '1', 'Nguyễn Văn Tân', '2003-07-01', '48535724', '2973682073', 'vantan0107', 'Hà Nội');

-- THEM THONG TIN DICH VU DI KEM 
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`IDdich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) VALUES ('1', 'Massage', '1000000', '1', 'available');
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`IDdich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) VALUES ('2', 'Karaoke', '700000', '1', 'available');
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`IDdich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) VALUES ('3', 'Thức ăn', '200000', '1', 'available');
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`IDdich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) VALUES ('4', 'Nước uống', '100000', '1', 'available');
INSERT INTO `furama_resort`.`dich_vu_di_kem` (`IDdich_vu_di_kem`, `ten_dich_vu_di_kem`, `gia`, `don_vi`, `trang_thai_kha_dung`) VALUES ('5', 'Tham quan Resort', '200000', '1', 'available');

-- THEM THONG TIN KIEU THUE 
INSERT INTO `furama_resort`.`kieu_thue` (`IDkieu_thue`, `ten_kieu_thue`, `gia`) VALUES ('1', 'Kieu1 ', '1000000 ');
INSERT INTO `furama_resort`.`kieu_thue` (`IDkieu_thue`, `ten_kieu_thue`, `gia`) VALUES ('2', 'Kieu2', '5000000');
INSERT INTO `furama_resort`.`kieu_thue` (`IDkieu_thue`, `ten_kieu_thue`, `gia`) VALUES ('3', 'Kieu3', '10000000');

-- THEM THONG TIN LOAI DICH VU
INSERT INTO `furama_resort`.`loai_dich_vu` (`IDloai_dich_vu`, `ten_loai_dich_vu`) VALUES ('1', 'Villa');
INSERT INTO `furama_resort`.`loai_dich_vu` (`IDloai_dich_vu`, `ten_loai_dich_vu`) VALUES ('2', 'House');
INSERT INTO `furama_resort`.`loai_dich_vu` (`IDloai_dich_vu`, `ten_loai_dich_vu`) VALUES ('3', 'Room');

-- THEM THONG TIN DICH VU 
INSERT INTO `furama_resort`.`dich_vu` (`IDdich_vu`, `ten_dich_vu`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `IDkieu_thue`, `IDloai_dich_vu`, `trang_thai`) VALUES ('1', 'VL-001', '5', '10', '10000000', '1', '1', 'available');
INSERT INTO `furama_resort`.`dich_vu` (`IDdich_vu`, `ten_dich_vu`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `IDkieu_thue`, `IDloai_dich_vu`, `trang_thai`) VALUES ('2', 'VL-002', '2', '6', '6000000', '2', '1', 'available');
INSERT INTO `furama_resort`.`dich_vu` (`IDdich_vu`, `ten_dich_vu`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `IDkieu_thue`, `IDloai_dich_vu`, `trang_thai`) VALUES ('3', 'HO-001', '1', '4', '1000000', '3', '2', 'available');
INSERT INTO `furama_resort`.`dich_vu` (`IDdich_vu`, `ten_dich_vu`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `IDkieu_thue`, `IDloai_dich_vu`, `trang_thai`) VALUES ('4', 'HO-002', '3', '10', '2000000', '3', '2', 'available');
INSERT INTO `furama_resort`.`dich_vu` (`IDdich_vu`, `ten_dich_vu`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `IDkieu_thue`, `IDloai_dich_vu`, `trang_thai`) VALUES ('5', 'RO-001', '1', '2', '500000', '3', '3', 'available');
INSERT INTO `furama_resort`.`dich_vu` (`IDdich_vu`, `ten_dich_vu`, `so_tang`, `so_nguoi_toi_da`, `chi_phi_thue`, `IDkieu_thue`, `IDloai_dich_vu`, `trang_thai`) VALUES ('6', 'RO-002', '1', '4', '700000', '3', '3', 'available');

-- THEM THONG TIN HOP DONG
INSERT INTO `furama_resort`.`hop_dong` (`IDhop_dong`, `IDnhan_vien`, `IDkhach_hang`, `IDdich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES ('1', '2', '5', '6', '2020-05-15', '2020-05-20', '500000', '5000000');
INSERT INTO `furama_resort`.`hop_dong` (`IDhop_dong`, `IDnhan_vien`, `IDkhach_hang`, `IDdich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES ('2', '1', '1', '1', '2020-05-10', '2020-05-13', '5000000', '33000000');
INSERT INTO `furama_resort`.`hop_dong` (`IDhop_dong`, `IDnhan_vien`, `IDkhach_hang`, `IDdich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES ('3', '3', '2', '5', '2020-05-05', '2020-05-13', '500000', '5900000');
INSERT INTO `furama_resort`.`hop_dong` (`IDhop_dong`, `IDnhan_vien`, `IDkhach_hang`, `IDdich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES ('4', '4', '4', '4', '2020-04-10', '2020-04-13', '1000000', '8000000');
INSERT INTO `furama_resort`.`hop_dong` (`IDhop_dong`, `IDnhan_vien`, `IDkhach_hang`, `IDdich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES ('5', '1', '1', '1', '2020-01-15', '2020-01-20', '10000000', '51000000');
INSERT INTO `furama_resort`.`hop_dong` (`IDhop_dong`, `IDnhan_vien`, `IDkhach_hang`, `IDdich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`, `tong_tien`) VALUES ('6', '1', '1', '1', '2020-05-10', '2020-05-13', '5000000', '33000000');

-- THEM THONG TIN HOP DONG CHI TIET
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`IDhop_dong_chi_tiet`, `IDhop_dong`, `IDdich_vu_di_kem`, `so_luong`) VALUES ('1', '1', '1', '1');
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`IDhop_dong_chi_tiet`, `IDhop_dong`, `IDdich_vu_di_kem`, `so_luong`) VALUES ('2', '2', '1', '1');
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`IDhop_dong_chi_tiet`, `IDhop_dong`, `IDdich_vu_di_kem`, `so_luong`) VALUES ('3', '3', '2', '2');
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`IDhop_dong_chi_tiet`, `IDhop_dong`, `IDdich_vu_di_kem`, `so_luong`) VALUES ('4', '4', '3', '5');
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`IDhop_dong_chi_tiet`, `IDhop_dong`, `IDdich_vu_di_kem`, `so_luong`) VALUES ('5', '5', '1', '1');
INSERT INTO `furama_resort`.`hop_dong_chi_tiet` (`IDhop_dong_chi_tiet`, `IDhop_dong`, `IDdich_vu_di_kem`, `so_luong`) VALUES ('6', '1', '2', '1');

-- SUA 1 SO THONG TIN
UPDATE `furama_resort`.`dich_vu` SET `IDkieu_thue` = '1' WHERE (`IDdich_vu` = '6');
UPDATE `furama_resort`.`dich_vu` SET `IDkieu_thue` = '3' WHERE (`IDdich_vu` = '2');
UPDATE `furama_resort`.`dich_vu` SET `IDkieu_thue` = '2' WHERE (`IDdich_vu` = '4');
UPDATE `furama_resort`.`dich_vu` SET `IDkieu_thue` = '1' WHERE (`IDdich_vu` = '5');
UPDATE `furama_resort`.`dich_vu` SET `IDkieu_thue` = '2' WHERE (`IDdich_vu` = '3');
UPDATE `furama_resort`.`dich_vu` SET `IDkieu_thue` = '3' WHERE (`IDdich_vu` = '1');

UPDATE `furama_resort`.`kieu_thue` SET `gia` = '1000000' WHERE (`IDkieu_thue` = '2');
UPDATE `furama_resort`.`kieu_thue` SET `gia` = '2000000' WHERE (`IDkieu_thue` = '3');
UPDATE `furama_resort`.`kieu_thue` SET `gia` = '500000' WHERE (`IDkieu_thue` = '1');

-- ----------------------------------------------------------------------------------
-- YÊU CẦU 2 : 

SELECT* FROM furama_resort.nhan_vien
WHERE char_length(nhan_vien.ho_ten) < 15 
AND (nhan_vien.ho_ten LIKE 'H%'
OR nhan_vien.ho_ten LIKE 'K%'
OR nhan_vien.ho_ten LIKE 'T%');

-- ----------------------------------------------------------------------------------
-- YÊU CẦU 3 : hiển thị khách hàng 18 - 50 tuổi đến từ Đà Nẵng và Quảng trị

SELECT* FROM furama_resort.khach_hang
WHERE khach_hang.dia_chi = 'Đà Nẵng' OR khach_hang.dia_chi = 'Quảng Trị'
AND
year(now()) - year(khach_hang.ngay_sinh) > 17 AND year(now()) - year(khach_hang.ngay_sinh) < 51;

-- xac dinh tuoi khac hang theo ngay
-- SELECT* FROM furama_resort.khach_hang
-- WHERE to_days(now()) - to_days(khach_hang.ngay_sinh) > 18*365  AND to_days(now()) - to_days(khach_hang.ngay_sinh) < 50*365

-- ---------------------------------------------------------------------------------
-- YÊU CẦU 4: hiển thị số lần đặt phòng của khách hàng diamond

SELECT ho_ten 'Họ Tên', count(ho_ten) 'Số lần đặt phòng'
FROM furama_resort.hop_dong
JOIN furama_resort.khach_hang
ON hop_dong.IDkhach_hang = khach_hang.IDkhach_hang AND khach_hang.IDloai_khach = 4
GROUP BY(ho_ten)
ORDER BY count(ho_ten);

-- ---------------------------------------------------------------------------------
-- YÊU CẦU 5: hiển thị thông tin hợp đồng của khách hàng

SELECT khach_hang.IDkhach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach , IDhop_dong,
ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien
FROM khach_hang
LEFT JOIN hop_dong ON khach_hang.IDkhach_hang = hop_dong.IDkhach_hang
LEFT JOIN loai_khach ON khach_hang.IDloai_khach = loai_khach.IDloai_khach
LEFT JOIN dich_vu ON hop_dong.IDdich_vu = dich_vu.IDdich_vu;

-- -----------------------------------------------------------------------------------------
-- YÊU CẦU 6:

SELECT DISTINCT dich_vu.IDdich_vu , dich_vu.ten_dich_vu, dich_vu.chi_phi_thue, dich_vu.ten_dich_vu
FROM dich_vu
INNER JOIN
(SELECT hop_dong.IDdich_vu ID
FROM hop_dong
WHERE hop_dong.ngay_lam_hop_dong > '2020-05-10'
Or hop_dong.ngay_lam_hop_dong < '2020-01-01') TB
ON TB.ID = dich_vu.IDdich_vu;

-- 6	2020-05-15
-- 1	2020-05-10
-- 5	2020-05-05
-- 4	2020-04-10
-- 1	2020-01-15 
-- 1	2020-05-10
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các 
-- loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

-- ----------------------------------------------------------------------------------------
-- YÊU CẦU 7: hiển thị thông tin của dịch vụ được đặt từ t1 -> t4 nhưng chưa được đặt trong t5 năm 2020

SELECT hop_dong.IDdich_vu, dich_vu.ten_dich_vu, dich_vu.so_nguoi_toi_da, dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
FROM hop_dong
INNER JOIN dich_vu
ON hop_dong.IDdich_vu = dich_vu.IDdich_vu
INNER JOIN loai_dich_vu
ON dich_vu.IDloai_dich_vu = loai_dich_vu.IDloai_dich_vu
WHERE (month(hop_dong.ngay_lam_hop_dong) >= 01 AND month(hop_dong.ngay_lam_hop_dong) >= 04)
AND year(hop_dong.ngay_lam_hop_dong) = 2020
AND hop_dong.IDdich_vu NOT IN
(
SELECT hop_dong.IDdich_vu
FROM hop_dong
WHERE month(hop_dong.ngay_lam_hop_dong) = 05
AND year(hop_dong.ngay_lam_hop_dong) = 2020
);
-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, 
-- TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong
-- năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
-- -----------------------------------------------------------------------------------------
-- YÊU CẦU 8:

SELECT DISTINCT ho_ten
FROM khach_hang;

SELECT khach_hang.ho_ten
FROM khach_hang
GROUP BY (khach_hang.ho_ten);

SELECT DISTINCTROW ho_ten
FROM khach_hang;

-- ----------------------------------------------------------------------------
-- YÊU CẦU 9: số khách đặt phòng theo tháng

SELECT month(hop_dong.ngay_lam_hop_dong) 'Tháng',
count(hop_dong.IDhop_dong) 'Số khách đặt phòng' 
FROM furama_resort.hop_dong 
WHERE year(hop_dong.ngay_lam_hop_dong) = '2020'
GROUP BY month(hop_dong.ngay_lam_hop_dong);

-- -------------------------------------------------------------------------------------
-- YÊU CẦU 10: số dịch vụ đi kèm mỗi hợp đồng

SELECT hop_dong.IDhop_dong 'Mã hợp đồng', count(hop_dong_chi_tiet.IDhop_dong) 'Số lượng dịch vụ đi kèm'
FROM hop_dong
INNER JOIN hop_dong_chi_tiet
ON hop_dong.IDhop_dong = hop_dong_chi_tiet.IDhop_dong
GROUP BY hop_dong.IDhop_dong;

-- --------------------------------------------------------------------------------------
-- YÊU CẦU 11: thông tin dịch vụ đi kèm đã được sử dụng

SELECT* FROM dich_vu_di_kem
WHERE IDdich_vu_di_kem IN
(
SELECT DISTINCT hop_dong_chi_tiet.IDdich_vu_di_kem
FROM hop_dong_chi_tiet
WHERE hop_dong_chi_tiet.IDhop_dong IN
(
SELECT hop_dong.IDhop_dong
FROM hop_dong
WHERE hop_dong.IDkhach_hang IN 
(
SELECT khach_hang.IDkhach_hang 
FROM khach_hang
INNER JOIN loai_khach
ON khach_hang.IDloai_khach = loai_khach.IDloai_khach
WHERE loai_khach.IDloai_khach = 4 
AND khach_hang.dia_chi = 'Vinh' OR khach_hang.dia_chi = 'Quảng Ngãi'
)
)
) ;

-- --------------------------------------------------------------------------------------
-- YÊU CẦU 12: 

SELECT DISTINCT hop_dong.IDdich_vu, nhan_vien.ho_ten 'Tên nhân viên', khach_hang.ho_ten 'Tên khách hàng', khach_hang.so_dien_thoai,
dich_vu.ten_dich_vu, count(hop_dong_chi_tiet.IDhop_dong) 'Số lượng DVDK', hop_dong.tien_dat_coc
FROM hop_dong
INNER JOIN nhan_vien
ON hop_dong.IDnhan_vien = nhan_vien.IDnhan_vien
INNER JOIN khach_hang
ON hop_dong.IDkhach_hang = khach_hang.IDkhach_hang
INNER JOIN dich_vu
ON hop_dong.IDdich_vu = dich_vu.IDdich_vu
INNER JOIN hop_dong_chi_tiet
ON hop_dong.IDhop_dong = hop_dong_chi_tiet.IDhop_dong
WHERE month(hop_dong.ngay_lam_hop_dong) >= 05
AND year(hop_dong.ngay_lam_hop_dong) = 2020
AND hop_dong.IDdich_vu not in
(
SELECT DISTINCT hop_dong.IDdich_vu
FROM hop_dong
WHERE month(hop_dong.ngay_lam_hop_dong) BETWEEN 01 and 04
AND year(hop_dong.ngay_lam_hop_dong) = 2020
)
GROUP BY hop_dong_chi_tiet.IDhop_dong;

-- chọn ra dịch vụ được sử dụng trong tháng 5 nhưng không được sử dụng trước đó từ tháng 1 đến 4

-- 6	2020-05-15
-- 1	2020-05-10
-- 5	2020-05-05
-- 4	2020-04-10
-- 1	2020-01-15
-- 1	2020-05-10

-- --------------------------------------------------------------------------------------
-- YÊU CẦU 13 : Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng

SELECT *
FROM dich_vu_di_kem
JOIN
(
SELECT hop_dong_chi_tiet.IDdich_vu_di_kem 'ID', count(hop_dong_chi_tiet.IDdich_vu_di_kem) 'solandung'
FROM hop_dong_chi_tiet
GROUP BY hop_dong_chi_tiet.IDdich_vu_di_kem
) tb
ON dich_vu_di_kem.IDdich_vu_di_kem = tb.ID
HAVING solandung = max(solandung);

-- ---------------------------------------------------------------------------------------
-- YÊU CẦU 14 : Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.

SELECT*
FROM dich_vu_di_kem
WHERE dich_vu_di_kem.IDdich_vu_di_kem IN(
SELECT IDdich_vu_di_kem
FROM hop_dong_chi_tiet
GROUP BY hop_dong_chi_tiet.IDdich_vu_di_kem
HAVING count(hop_dong_chi_tiet.IDdich_vu_di_kem) = 1
);

-- ---------------------------------------------------------------------------------------------
-- YÊU CẦU 15 : Hiển thi thông tin của tất cả nhân viên mới chỉ lập được tối đa 3 hợp đồng trong năm 2020

SELECT nhan_vien.IDnhan_vien, nhan_vien.ho_ten, trinh_do.trinh_do,
bo_phan.ten_bo_phan, nhan_vien.so_dien_thoai, nhan_vien.dia_chi
FROM nhan_vien
INNER JOIN bo_phan
ON nhan_vien.IDbo_phan = bo_phan.IDbo_phan
INNER JOIN trinh_do
ON nhan_vien.IDtrinh_do = trinh_do.IDtrinh_do
WHERE nhan_vien.IDnhan_vien IN
(
SELECT hop_dong.IDnhan_vien
FROM hop_dong
WHERE year(hop_dong.ngay_lam_hop_dong) = 2020
GROUP BY hop_dong.IDnhan_vien
HAVING count(hop_dong.IDnhan_vien) BETWEEN 1 and 3
);

-- ------------------------------------------------------------------------------------
-- YÊU CẦU 16 : chưa xử lí được

ALTER TABLE furama_resort.hop_dong
DROP FOREIGN KEY `hop_dong_ibfk_1` ;

ALTER TABLE furama_resort.nhan_vien
DROP FOREIGN KEY `nhan_vien_ibfk_1` ;

ALTER TABLE furama_resort.nhan_vien
DROP FOREIGN KEY `nhan_vien_ibfk_2` ;

ALTER TABLE furama_resort.nhan_vien
DROP FOREIGN KEY `nhan_vien_ibfk_3` ;

DELETE FROM furama_resort.nhan_vien
WHERE nhan_vien.IDnhan_vien NOT IN
(
SELECT DISTINCT nhan_vien.IDnhan_vien
FROM hop_dong
INNER JOIN nhan_vien
ON hop_dong.IDnhan_vien = nhan_vien.IDnhan_vien
);

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

-- ------------------------------------------------------------------------------------
-- YÊU CẦU 17 : 

UPDATE furama_resort.khach_hang
JOIN
(
SELECT hop_dong.IDkhach_hang 'ID'
FROM hop_dong
INNER JOIN khach_hang
ON hop_dong.IDkhach_hang = khach_hang.IDkhach_hang
WHERE khach_hang.IDloai_khach = 3
AND hop_dong.tong_tien > 5000000
AND year(hop_dong.ngay_lam_hop_dong) = 2020
) AS TB
ON khach_hang.IDkhach_hang = TB.ID
SET IDloai_khach = 4
WHERE TB.ID = 2;

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ 
-- Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt 
-- phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

-- -----------------------------------------------------------------------------------
-- YÊU CẦU 18 :

delete khachhang,hopdong,hopdongchitiet from khachhang inner join hopdong on khachhang.IdKhachHang = hopdong.IdKhachHang
inner join hopdongchitiet on hopdong.IdHopDong = hopdongchitiet.IdHopDong where not exists
(select hopdong.IdHopDong where year(hopdong.ngayLamHopDong) > '2016' and khachhang.IdKhachHang = hopdong.IdKhachHang);

-- xóa khách hàng có hợp đồng trước 2016 

-- -----------------------------------------------------------------------------------
-- YÊU CẦU 19 : tăng giá dịch vụ đi kèm sử dụng trong năm 2020 trên 3 lần lên gấp đôi

UPDATE dich_vu_di_kem
JOIN
(SELECT IDdich_vu_di_kem 'IDDVDK' , count(IDdich_vu_di_kem) 'solanSD'
FROM hop_dong_chi_tiet
INNER JOIN hop_dong
ON hop_dong.IDhop_dong = hop_dong_chi_tiet.IDhop_dong
WHERE year(hop_dong.ngay_lam_hop_dong) = 2020
GROUP BY IDdich_vu_di_kem
) AS table_ID
ON dich_vu_di_kem.IDdich_vu_di_kem = table_ID.IDDVDK
SET dich_vu_di_kem.gia = (dich_vu_di_kem.gia*2)
WHERE solanSD >= 3;

-- ------------------------------------------------------------------------------------
-- YÊU CẦU 20 :

SELECT nhan_vien.IDnhan_vien, nhan_vien.ho_ten, nhan_vien.email, nhan_vien.so_dien_thoai,
nhan_vien.ngay_sinh, nhan_vien.dia_chi
FROM nhan_vien;

SELECT khach_hang.IDkhach_hang, khach_hang.ho_ten, khach_hang.email, khach_hang.so_dien_thoai,
khach_hang.ngay_sinh, khach_hang.dia_chi
FROM khach_hang;

-- END -----

