CREATE SEQUENCE REAL_ESTATE_ID_SEQUENCE start with 10000;

CREATE TABLE REAL_ESTATE (
	REAL_ESTATE_ID number(19,0) not null,
	DESCRIPTION varchar2(40),
  REAL_ESTATE_TYPE varchar2(40) not null,
  SQUARE_METERS number(5,0),
  CITY varchar2(40),
  REGION varchar2(40),
  ADDRESS varchar2(100),
  PRICE number(19,0)
);

alter table REAL_ESTATE add (
  constraint PK_REAL_ESTATE primary key (REAL_ESTATE_ID),
  constraint REAL_ESTATE_TYPE_CHECK
    check ( REAL_ESTATE_TYPE in ('APARTMENT', 'HOUSE', 'VILLA', 'ROOM', 'GARAGE', 'OFFICE_SPACE', 'AGRICULTURAL_FIELD', 'GROUND'))
);
