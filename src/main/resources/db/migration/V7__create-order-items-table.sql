create table order_items (

    id bigint not null auto_increment,
    quantity bigint,
    menu_item_id bigint not null,
    order_id bigint not null,

    primary key(id),
    constraint fk_order_items_order_id foreign key(order_id) references orders(id),
    constraint fk_order_items_menu_item_id foreign key(menu_item_id) references menu_items(id)
);