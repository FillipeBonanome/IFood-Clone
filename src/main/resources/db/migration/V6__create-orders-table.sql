create table orders(

    id bigint not null auto_increment,
    owner_id bigint not null,
    order_status varchar(100) not null,

    primary key(id),
    constraint fk_order_owner_id foreign key(owner_id) references users(id)

);