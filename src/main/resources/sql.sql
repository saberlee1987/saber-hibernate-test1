create table instructor_detail
(
    id              int(11) not null primary key auto_increment,
    youtube_channel varchar(128) default null,
    hobby           varchar(50)  default null

) engine = InnoDB;

create table instructor
(
    id                   int(11) not null primary key auto_increment,
    first_name           varchar(70) default null,
    last_name            varchar(85) default null,
    email                varchar(50) default null,
    instructor_detail_id int(11)     default null,
    constraint instructor_detail_id_fk foreign key (instructor_detail_id)
        references instructor_detail (id)
) engine = InnoDB;

create table course
(
    id            int(11) not null primary key auto_increment,
    title         varchar(128) default null,
    instructor_id int(11)      default null,
    unique key title_unique (title),
    constraint instructor_id_fk foreign key (instructor_id)
        references instructor (id)
        on delete no action on update no action
) engine = InnoDB;
create table review
(
    id        int(11) not null primary key auto_increment,
    comment   varchar(256) default null,
    course_id int          default null,
    constraint course_id_fk foreign key (course_id)
        references course (id)
        on delete no action on update no action

) engine = InnoDB;