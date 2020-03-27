create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table post (
    id bigint not null,
    body varchar(2048) not null,
    filename varchar(255),
    tag varchar(255),
    title varchar(255),
    user_id bigint,
    primary key (id)
) engine=InnoDB;

create table user (
    id bigint not null,
    activation_code varchar(255),
    active bit,
    email varchar(255) not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
) engine=InnoDB;

create table user_role (
    user_id bigint not null,
    roles varchar(255)
) engine=InnoDB;

alter table post
    add constraint post_user_fk
    foreign key (user_id) references user (id);

alter table user_role
    add constraint user_role_user_fk
    foreign key (user_id) references user (id);