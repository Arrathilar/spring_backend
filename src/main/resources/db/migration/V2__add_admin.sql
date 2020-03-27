insert into user (id, username, password, email, active)
    values (1, 'admin', 'admin', 'admin@mail.com', true);

insert into user_role (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');