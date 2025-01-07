create database ecommerce_db;
use ecommerce_db;

create table san_pham (
    id int auto_increment primary key,
    ten_san_pham varchar(100) not null,
    gia decimal(10, 2) not null,
    muc_giam_gia decimal(5, 2),
    ton_kho int not null
);

create table nhan_vien (
    id int auto_increment primary key,
    ten_nhan_vien varchar(100) not null,
    ngay_sinh date,
    dia_chi varchar(255)
);

create table khach_hang (
    id int auto_increment primary key,
    ten_khach_hang varchar(100) not null,
    ngay_sinh date,
    dien_thoai varchar(20),
    dia_chi varchar(255),
    email varchar(100)
);

create table don_hang (
    id int auto_increment primary key,
    phuong_thuc_thanh_toan varchar(50) not null,
    san_pham_id int,
    khach_hang_id int,
    nhan_vien_id int,
    ngay_dat_hang date not null,
    ngay_giao_hang date,
    dia_chi_giao_hang varchar(255),
    foreign key (khach_hang_id) references khach_hang(id),
    foreign key (nhan_vien_id) references nhan_vien(id)
);

CREATE TABLE chi_tiet_don_hang (
    id INT AUTO_INCREMENT PRIMARY KEY,
    don_hang_id INT NOT NULL,
    san_pham_id INT NOT NULL,
    so_luong INT NOT NULL,
    gia DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (don_hang_id) REFERENCES don_hang(id) ON DELETE CASCADE,
    FOREIGN KEY (san_pham_id) REFERENCES san_pham(id) ON DELETE CASCADE
);

insert into san_pham (ten_san_pham, gia, muc_giam_gia, ton_kho) values
('San pham 1', 100000, 10, 50),
('San pham 2', 200000, 15, 30),
('San pham 3', 150000, 5, 20),
('San pham 4', 300000, 20, 10),
('San pham 5', 50000, 0, 100),
('San pham 6', 120000, 8, 60),
('San pham 7', 250000, 12, 40),
('San pham 8', 180000, 10, 70),
('San pham 9', 220000, 18, 25),
('San pham 10', 90000, 7, 90);

insert into nhan_vien (ten_nhan_vien, ngay_sinh, dia_chi) values
('Nguyen Van A', '1990-05-20', 'Ha Noi'),
('Tran Thi B', '1985-03-15', 'Hai Phong'),
('Le Van C', '1992-07-10', 'Da Nang'),
('Pham Thi D', '1998-09-25', 'Can Tho'),
('Hoang Van E', '1995-11-12', 'Hue'),
('Bui Thi F', '1993-02-08', 'Vinh'),
('Dang Van G', '2000-04-30', 'Quang Ninh'),
('Do Thi H', '1988-06-18', 'Bac Ninh'),
('Nguyen Thi I', '1996-01-05', 'Thanh Hoa'),
('Pham Van K', '1994-12-22', 'Nam Dinh');

insert into khach_hang (ten_khach_hang, ngay_sinh, dien_thoai, dia_chi, email) values
('Nguyen Van X', '1987-09-14', '0123456789', 'Ha Noi', 'x@gmail.com'),
('Tran Thi Y', '1991-03-22', '0987654321', 'Hai Phong', 'y@gmail.com'),
('Le Van Z', '1980-07-05', '0111222333', 'Da Nang', 'z@gmail.com'),
('Pham Thi M', '1995-01-30', '0999888777', 'Can Tho', 'm@gmail.com'),
('Hoang Van N', '1983-12-11', '0777666555', 'Hue', 'n@gmail.com'),
('Bui Thi Q', '1990-04-18', '0666555444', 'Vinh', 'q@gmail.com'),
('Dang Van L', '1989-06-09', '0222333444', 'Quang Ninh', 'l@gmail.com'),
('Do Thi P', '1993-02-28', '0111999888', 'Bac Ninh', 'p@gmail.com'),
('Nguyen Thi T', '1985-11-03', '0333444555', 'Thanh Hoa', 't@gmail.com'),
('Pham Van U', '1997-08-16', '0555666777', 'Nam Dinh', 'u@gmail.com');

insert into don_hang (phuong_thuc_thanh_toan, khach_hang_id, nhan_vien_id, ngay_dat_hang, ngay_giao_hang, dia_chi_giao_hang) values
('Thanh toan truc tuyen', 1, 1, '2025-01-01', '2025-01-05', 'Ha Noi'),
('Thanh toan khi nhan hang', 2, 2, '2025-01-02', '2025-01-06', 'Hai Phong'),
('Chuyen khoan', 3, 3, '2025-01-03', '2025-01-07', 'Da Nang'),
('Tien mat', 4, 4, '2025-01-04', '2025-01-08', 'Can Tho'),
('Thanh toan truc tuyen', 5, 5, '2025-01-05', '2025-01-09', 'Hue'),
('Chuyen khoan', 6, 6, '2025-01-06', '2025-01-10', 'Vinh'),
('Tien mat', 7, 7, '2025-01-07', '2025-01-11', 'Quang Ninh'),
('Thanh toan khi nhan hang', 8, 8, '2025-01-08', '2025-01-12', 'Bac Ninh'),
('Thanh toan truc tuyen', 9, 9, '2025-01-09', '2025-01-13', 'Thanh Hoa'),
('Chuyen khoan', 10, 10, '2025-01-10', '2025-01-14', 'Nam Dinh');

INSERT INTO chi_tiet_don_hang (don_hang_id, san_pham_id, so_luong, gia) VALUES
(1, 1, 3, 100000), -- Đơn hàng 1, Sản phẩm 1
(1, 5, 2, 50000),  -- Đơn hàng 1, Sản phẩm 5
(2, 2, 1, 200000), -- Đơn hàng 2, Sản phẩm 2
(2, 6, 4, 120000), -- Đơn hàng 2, Sản phẩm 6
(3, 3, 5, 150000), -- Đơn hàng 3, Sản phẩm 3
(3, 7, 1, 250000), -- Đơn hàng 3, Sản phẩm 7
(4, 4, 2, 300000), -- Đơn hàng 4, Sản phẩm 4
(4, 8, 3, 180000), -- Đơn hàng 4, Sản phẩm 8
(5, 9, 2, 220000), -- Đơn hàng 5, Sản phẩm 9
(5, 10, 6, 90000); -- Đơn hàng 5, Sản phẩm 10

