
CREATE TABLE REAL_ESTATE (
	REAL_ESTATE_ID number(19,0) not null,
	DESCRIPTION varchar2(40),
);

alter table REAL_ESTATE add (
    constraint PK_REGISTRATION primary key (DIGITAL_ID)
);