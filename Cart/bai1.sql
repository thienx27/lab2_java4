Create database QlDienThoai
use QlDienThoai

if OBJECT_ID('CUSTOMER') is not null
drop table CUSTOMER
go
CREATE TABLE CUSTOMER(
id int not null,
TenThueBao nvarchar(50) null,
SoDT nvarchar(50) null,
Diachi nvarchar(50) null,
Constraint PK_CUSTOMER PRIMARY KEY(id)
)
delete CUSTOMER
insert into CUSTOMER values('1',N'Le Van Phung',N'01683314129',N'p.13')
insert into CUSTOMER values('2',N'Nguyen thi Tuong Vy',N'0903936117',N'Ninh Thuan')
insert into CUSTOMER values('3',N'Le Quang Trung',N'09037829999',N'Phan Rang')
insert into CUSTOMER values('4',N'Le Thi Hong Hanh',N'0167788889',N'Quan 12')
select * from CUSTOMER