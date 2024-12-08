create table users(

    id bigint not null auto_increment,
    name varchar(32) not null,
    email varchar(64) not null,
    CPF varchar(11) not null,
    phone_number varchar(11) not null,
    birthday DATE not null,
    number varchar(4) not null,
    street varchar(100) not null,
    district varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    code varchar(8) not null,
    usertype varchar(32) not null,
    password varchar(100) not null,

    primary key(id)

);

insert into users values(
    null, "Augusto da Silva", "augusto@gmail.com", "04694050079", "11912345678", "1985-08-15",
    "333", "Rua das Flores", "Parque dos Jardins", "Cidade Verde", "São Paulo", "13555666", "CLIENT", "123456");

insert into users values(
    null, "Joseph Pharaoh", "pharaoh@gmail.com", "04694050079", "11912345678", "1985-08-15",
    "333", "Rua das Flores", "Parque dos Jardins", "Cidade Verde", "São Paulo", "13555666", "CLIENT", "123456");