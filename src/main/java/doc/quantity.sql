create table QUANTITY
(
	ID INTEGER not null comment 'id',
	CUSTOMER_ID INTEGER null comment '客户ID',
	PRODUCT_ID INTEGER null comment '货物ID',
	QUANTITY INTEGER null comment '数量',
	STOCK INTEGER default 1 null comment '库存'
)
comment '客户货物关系';

create unique index QUANTITY_ID_uindex
	on QUANTITY (ID);

alter table QUANTITY
	add constraint QUANTITY_pk
		primary key (ID);

