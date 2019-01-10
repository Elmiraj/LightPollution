create table CUSTOMER
(
	ID LONG not null comment 'id',
	CUSTOMER_NAME VARCHAR(50) not null comment '客户姓名',
	IS_PAID INTEGER null comment '是否付款'
)
comment '客户表';

create unique index CUSTOMER_ID_uindex
	on CUSTOMER (ID);

alter table CUSTOMER
	add constraint CUSTOMER_pk
		primary key (ID);

		alter table CUSTOMER
	add TOTAL_TOTAL_PRICE INTEGER(50) null comment '应付金额';

alter table CUSTOMER
	add PAID_MONEY INTEGER(50) null comment '已付金额';

	alter table CUSTOMER
	add ADDRESS_ID BIGINT(20) null comment '地址id';
	create unique index CUSTOMER_ID_uindex
	on CUSTOMER (ID);

alter table CUSTOMER
	add constraint CUSTOMER_pk
		primary key (ID);

alter table ADDRESS modify ID INTEGER(20) not null comment '地址id';

create unique index ADDRESS_ID_uindex
	on ADDRESS (ID);

alter table ADDRESS
	add constraint ADDRESS_pk
		primary key (ID);

create table ADDRESS
(
	ID INTEGER(20) not null comment '地址id',
	ADDRESS_NAME VARCHAR(50) null comment '地址名称'
)

alter table ADDRESS modify ID bigint auto_increment;
alter table CUSTOMER modify ID int(20) auto_increment comment 'id';
alter table PRODUCT modify ID bigint auto_increment;



