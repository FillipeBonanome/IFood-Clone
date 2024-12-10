create table restaurants(

    id bigint not null auto_increment,
    owner_id bigint not null,
    name varchar(32) not null,
    phone_number varchar(32) not null,
    number varchar(4) not null,
    street varchar(100) not null,
    district varchar(100) not null,
    city varchar(100) not null,
    state varchar(100) not null,
    code varchar(8) not null,
    category varchar(100) not null,
    description TEXT not null,
    cnpj varchar(14) not null,

    primary key(id),
    constraint fk_restaurant_owner_id foreign key(owner_id) references users(id)

);