\c test

create table Classrooms(
	number integer primary key,
	capacity integer not null
);

create table Courses(
	id serial primary key,
	name varchar(45) not null,
	type varchar(45) not null,
	times_per_week smallint not null,
	year varchar(4) not null
);

create table Lessons(
	id serial primary key,
	course_id integer not null references Courses on delete cascade,
	classroom_num integer references Classrooms on delete set null,
	start_time timestamp not null
);

create table Students(
	id serial primary key,
	name varchar(45) not null,
	surname varchar(45) not null,
	patronymic varchar(45),
	year smallint check(year > 0 and year < 7),
	student_group integer,
	stream smallint check(stream > 0 and stream < 10)
);

create table Professors(
	id serial primary key,
	name varchar(45) not null,
	surname varchar(45) not null,
	patronymic varchar(45)	
);

create table StudentsCourses(
	student_id integer not null references Students on delete cascade,
	course_id integer not null references Courses on delete cascade,
	primary key(student_id, course_id)
);


create table ProfessorsCourses(
	professor_id integer not null references Professors on delete cascade,
	course_id integer not null references Courses on delete cascade,
	primary key(professor_id, course_id)
);


GRANT ALL ON ALL TABLES IN SCHEMA public TO andrew;
GRANT ALL ON ALL SEQUENCES IN SCHEMA public TO andrew;
