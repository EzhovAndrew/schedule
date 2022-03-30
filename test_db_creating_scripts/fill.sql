\c test

insert into Classrooms(number, capacity)
values
(1, 8),
(2, 12),
(3, 26);

insert into Courses(name, type, times_per_week, year)
values
('matan', 'group', 1, '2001'),
('linal', 'special', 2, '2011'),
('oki', 'stream', 3, '2021');


insert into Lessons(classroom_num, course_id, start_time)
values
(1, 1, '2011-01-01 12:12:12'),
(2, 2, '2021-01-01 12:12:12'),
(3, 3, '2021-01-12 12:12:12');



insert into Students(name, surname, patronymic, year, student_group, stream)
values
('Andrew', 'Ezhov', 'Vladimirovich', 1, 2, 1),
('Pivovarov', 'Sergey', 'Aleksandrovich', 6, 1, 9);


insert into Professors(name, surname, patronymic)
values
('Cheptsov', 'Vitalii', 'Anatolievich'),
('Arhipenko', 'Konstantin', 'Vladimirovich'); 


insert into ProfessorsCourses(professor_id, course_id)
values
(1, 1),
(1, 2),
(2, 1);

insert into StudentsCourses(student_id, course_id)
values
(1, 1),
(1, 2),
(2, 1);
