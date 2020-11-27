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
