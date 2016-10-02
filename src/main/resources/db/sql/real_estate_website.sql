CREATE sequence REAL_ESTATE_ID_SEQUENCE start with 10000;
CREATE sequence USER_ROLE_ID_SEQUENCE start with 1;

CREATE TABLE PORTAL_USER (
  USER_NAME VARCHAR(45) NOT NULL,
  PASSWORD VARCHAR(60) NOT NULL,
  ENABLED number(1,0) DEFAULT 1,
  EMAIL VARCHAR(30) NOT NULL,
  PHONE_NUMBER VARCHAR(15) NOT NULL
);

alter TABLE PORTAL_USER add (
  constraint PK_PORTAL_USER primary key (USER_NAME)
);

CREATE TABLE PORTAL_USER_ROLES (
  USER_ROLE_ID number(11,0) NOT NULL,
  USER_NAME varchar(45) NOT NULL,
  ROLE varchar(45) NOT NULL
);

alter TABLE PORTAL_USER_ROLES add (
  constraint PK_PORTAL_USER_ROLES primary key (USER_ROLE_ID),
  constraint FK_PORTAL_USER foreign key (USER_NAME) references PORTAL_USER(USER_NAME),
  constraint ROLE_USER unique (USER_ROLE_ID, USER_NAME)
);

CREATE TABLE REAL_ESTATE (

  ID number(19,0) not null,

  -- all real estate properties
	DESCRIPTION varchar2(200),
  REAL_ESTATE_TYPE varchar2(40) not null,
  SQUARE_METERS number(5,0),
  CITY varchar2(40) not null,
  ADDRESS varchar2(100),
  PRICE number(19,0),
  IMAGE_TYPE varchar2(20),
  ADVERTISEMENT_TYPE varchar2(10),
  CREATED_ON timestamp,

  -- house, apartment and office space common properties
  YEAR_OF_CONSTRUCTION number(4,0),
  CENTRAL_HEATING_INCLUDED number(1,0),
  AIR_CONDITIONED number(1,0),

  -- house properties
  NUMBER_OF_FLOORS number(1,0),
  YARD_INCLUDED number(1,0),
  GARAGE_INCLUDED number(1,0),
  POOL_INCLUDED number(1,0),

  -- apartment properties
  FLOOR_NUMBER number(3,0),
  NUMBER_OF_ROOMS number(3,0),
  PARKING_INCLUDED number(1,0),
  ELEVATOR_INCLUDED number(1,0),

  -- room properties
  NUMBER_OF_BEDS number(3,0),

  -- office space properties
  NUMBER_OF_OFFICES number(3,0),

  USER_NAME VARCHAR(45) NOT NULL
);

alter TABLE REAL_ESTATE add (
  constraint PK_REAL_ESTATE primary key (ID),
  constraint REAL_ESTATE_TYPE_CHECK
    check ( REAL_ESTATE_TYPE in ('APARTMENT', 'HOUSE', 'ROOM', 'GARAGE', 'OFFICE_SPACE', 'AGRICULTURAL_FIELD', 'GROUND')),
  constraint ADVERTISEMENT_TYPE_CHECK check ( ADVERTISEMENT_TYPE in ('SALE', 'RENT')),
  constraint CENTRAL_HEATING_CHECK check ( CENTRAL_HEATING_INCLUDED in (0, 1)),
  constraint AIR_CONDITIONED_CHECK check ( AIR_CONDITIONED in (0, 1)),
  constraint YARD_INCLUDED_CHECK check ( YARD_INCLUDED in (0, 1)),
  constraint GARAGE_INCLUDED_CHECK check ( GARAGE_INCLUDED in (0, 1)),
  constraint POOL_INCLUDED_CHECK check ( POOL_INCLUDED in (0, 1)),
  constraint PARKING_INCLUDED_CHECK check ( PARKING_INCLUDED in (0, 1)),
  constraint ELEVATOR_INCLUDED_CHECK check ( ELEVATOR_INCLUDED in (0, 1)),
  constraint FK_REAL_ESTATE_PORTAL_USER foreign key (USER_NAME) references PORTAL_USER(USER_NAME)
);