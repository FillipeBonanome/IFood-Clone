create table menu_items (

    id bigint not null auto_increment,
    name varchar(100) not null,
    price decimal(10, 2) not null,
    description varchar(255) not null,
    menu_id bigint not null,

    primary key(id),
    constraint fk_menu_items_menu_id foreign key(menu_id) references menus(id)

);