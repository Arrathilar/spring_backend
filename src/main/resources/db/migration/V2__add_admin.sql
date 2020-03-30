insert into user (id, username, password, email, active)
    values (1, 'admin', '$2a$08$ghqp4Qp3ULffRzsc5c7i4OMqbYHVifPVN8mg/9nYhdfk2CciH5.x.', 'admin@mail.com', true);

insert into user_role (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');