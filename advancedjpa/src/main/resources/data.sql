insert into course (id,name,created_date,last_updated_date, is_deleted) values (6225, 'Cloud Computing', sysdate(), sysdate(), false);
insert into course (id,name,created_date,last_updated_date, is_deleted) values (5100, 'AED', sysdate(), sysdate(), false);
insert into course (id,name,created_date,last_updated_date, is_deleted) values (6250, 'Web Tools and Methods', sysdate(), sysdate(), false);

insert into passport (id, number) values (40001, 'A123456');
insert into passport (id, number) values (40002, 'B123456');
insert into passport (id, number) values (40003, 'C123456');

insert into student (id, name, passport_id) values (20001, 'John', 40001);
insert into student (id, name, passport_id) values (20002, 'Mike', 40002);
insert into student (id, name, passport_id) values (20003, 'Joe',  40003);

insert into review (id, rating, description, course_id) values (50001, 'FIVE', 'Great Course', 6225);
insert into review (id, rating, description, course_id) values (50002, 'TWO', 'Needs Improvement', 6225);
insert into review (id, rating, description, course_id) values (50003, 'FOUR', 'Good', 6250);

insert into student_course (student_id, course_id) values (20001, 6225);
insert into student_course (student_id, course_id) values (20002, 6225);
insert into student_course (student_id, course_id) values (20003, 6225);
insert into student_course (student_id, course_id) values (20001, 6250);