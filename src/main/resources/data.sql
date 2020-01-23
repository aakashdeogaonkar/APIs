/* create table person(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);
*/
INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTH_DATE) VALUES
(100, 'Aakash', 'Boston', sysdate());
INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTH_DATE) VALUES
(101, 'Diksha', 'Buffalo', sysdate());
INSERT INTO PERSON
(ID, NAME, LOCATION, BIRTH_DATE) VALUES
(102, 'Ta', 'New York', sysdate());