insert into course (id,name,created_date,last_updated_date) values (6225, 'Cloud Computing', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (5100, 'AED', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (6250, 'Web Tools and Methods', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1001, 'Test1', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1002, 'Test2', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1003, 'Test3', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1004, 'Test4', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1005, 'Test5', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1006, 'Test6', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1007, 'Test7', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1008, 'Test8', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1009, 'Test9', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1010, 'Test10', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1011, 'Test11', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1012, 'Test12', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1013, 'Test13', sysdate(), sysdate());
insert into course (id,name,created_date,last_updated_date) values (1014, 'Test14', sysdate(), sysdate());

insert into passport (id, number) values (40001, 'A123456');
insert into passport (id, number) values (40002, 'B123456');
insert into passport (id, number) values (40003, 'C123456');

insert into student (id, name, passport_id) values (20001, 'John', 40001);
insert into student (id, name, passport_id) values (20002, 'Mike', 40002);
insert into student (id, name, passport_id) values (20003, 'Joe',  40003);

insert into review (id, rating, description, course_id) values (50001, '5', 'Great Course', 6225);
insert into review (id, rating, description, course_id) values (50002, '2', 'Needs Improvement', 6225);
insert into review (id, rating, description, course_id) values (50003, '4', 'Good', 6250);

insert into student_course (student_id, course_id) values (20001, 6225);
insert into student_course (student_id, course_id) values (20002, 6225);
insert into student_course (student_id, course_id) values (20003, 6225);
insert into student_course (student_id, course_id) values (20001, 6250);