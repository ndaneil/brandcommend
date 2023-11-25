create table brand
(
  id    int     primary key not null auto_increment,
  brand_name  varchar(50)   not null,
  logo_path   varchar(400)  not null,
  category_id int,
  constraint fk_brand_category FOREIGN KEY(category_id) REFERENCES category(id)
);