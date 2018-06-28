create table adminUser (id bigint not null, password varchar(255) not null, username varchar(255) not null, primary key (id)) engine=MyISAM
create table course (id bigint not null, description varchar(255) not null, name varchar(255) not null, primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
insert into hibernate_sequence values ( 1 )
create table student (id bigint not null, name varchar(255) not null, roll varchar(255) not null, course_id bigint, primary key (id)) engine=MyISAM
alter table adminUser add constraint UK_gfn44sntic2k93auag97juyij unique (username)
alter table student add constraint FKdfypyqt0stgfc0aij9kcxm99s foreign key (course_id) references course (id)
