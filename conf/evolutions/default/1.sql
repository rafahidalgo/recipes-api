# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table category (
  category_id                   bigint auto_increment not null,
  category_name                 varchar(255),
  constraint pk_category primary key (category_id)
);

create table ingredient (
  ingredient_id                 bigint auto_increment not null,
  ingredient_name               varchar(255),
  units                         varchar(255),
  constraint pk_ingredient primary key (ingredient_id)
);

create table recipe (
  recipe_id                     bigint auto_increment not null,
  title                         varchar(255),
  steps                         varchar(255),
  time                          varchar(255),
  difficulty                    varchar(11),
  category_category_id          bigint,
  constraint ck_recipe_difficulty check ( difficulty in ('Fácil','Muy fácil','Difícil','Muy difícil','Intermedia')),
  constraint pk_recipe primary key (recipe_id)
);

create table recipe_ingredient (
  recipe_recipe_id              bigint not null,
  ingredient_ingredient_id      bigint not null,
  constraint pk_recipe_ingredient primary key (recipe_recipe_id,ingredient_ingredient_id)
);

alter table recipe add constraint fk_recipe_category_category_id foreign key (category_category_id) references category (category_id) on delete restrict on update restrict;
create index ix_recipe_category_category_id on recipe (category_category_id);

alter table recipe_ingredient add constraint fk_recipe_ingredient_recipe foreign key (recipe_recipe_id) references recipe (recipe_id) on delete restrict on update restrict;
create index ix_recipe_ingredient_recipe on recipe_ingredient (recipe_recipe_id);

alter table recipe_ingredient add constraint fk_recipe_ingredient_ingredient foreign key (ingredient_ingredient_id) references ingredient (ingredient_id) on delete restrict on update restrict;
create index ix_recipe_ingredient_ingredient on recipe_ingredient (ingredient_ingredient_id);


# --- !Downs

alter table recipe drop constraint if exists fk_recipe_category_category_id;
drop index if exists ix_recipe_category_category_id;

alter table recipe_ingredient drop constraint if exists fk_recipe_ingredient_recipe;
drop index if exists ix_recipe_ingredient_recipe;

alter table recipe_ingredient drop constraint if exists fk_recipe_ingredient_ingredient;
drop index if exists ix_recipe_ingredient_ingredient;

drop table if exists category;

drop table if exists ingredient;

drop table if exists recipe;

drop table if exists recipe_ingredient;

