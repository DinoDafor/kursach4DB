drop table if exists don cascade;
drop table if exists consiglieri cascade;
drop table if exists city cascade;
drop table if exists family cascade;
drop table if exists sphere_of_influence cascade;
drop table if exists families_influences cascade;
drop table if exists soldier cascade;
drop table if exists lawyer cascade ;
drop table if exists families_relationship cascade;
CREATE TABLE IF NOT EXISTS don
(
  id serial PRIMARY KEY,
  name text UNIQUE NOT NULL,
  age int,
  family text
);
CREATE TABLE IF NOT EXISTS consiglieri
(
  id serial PRIMARY KEY,
  name text NOT NULL,
  age int,
  current_order int,
  remaining_resting_days interval,
  family text
);
CREATE TABLE IF NOT EXISTS city
(
  name text PRIMARY KEY,
  description text
);
CREATE TABLE IF NOT EXISTS family
(
  name text PRIMARY KEY,
  don int NOT NULL references don (id),
  consiglieri int NOT NULL references consiglieri (id),
  budget int,
  city text NOT NULL references city (name),
  war_id int
);
CREATE TABLE IF NOT EXISTS war
(
  id serial PRIMARY KEY,
  duration interval NOT NULL,
  first_family text NOT NULL references family (name),
  second_family text NOT NULL references family (name)
);
ALTER TABLE don ADD FOREIGN KEY (family) REFERENCES family (name);
ALTER TABLE consiglieri ADD FOREIGN KEY (family) REFERENCES family (name);
ALTER TABLE family ADD FOREIGN KEY (war_id) REFERENCES war (id);
CREATE TABLE IF NOT EXISTS sphere_of_influence
(
  id serial PRIMARY KEY,
  name text,
  city text NOT NULL references city (name),
  daily_income int NOT NULL
);
CREATE TABLE IF NOT EXISTS families_relationship
(
  first_family text NOT NULL references family (name),
  second_family text NOT NULL references family (name),
  relationship varchar(1) NOT NULL default 'N',
  check (first_family!=second_family),
  unique (first_family, second_family),
  constraint proper_relationship check ( relationship in ('G', 'N', 'B') )
);
CREATE TABLE IF NOT EXISTS families_influences
(
  family text NOT NULL references family (name),
  sphere_of_influence int NOT NULL references sphere_of_influence (id)
);
CREATE TABLE IF NOT EXISTS lawyer
(
  id serial PRIMARY KEY,
  name text NOT NULL,
  age int,
  is_busy boolean NOT NULL default false,
  family text REFERENCES family(name)
);
CREATE TABLE IF NOT EXISTS soldier
(
  id serial PRIMARY KEY,
  name text NOT NULL,
  age int,
  is_busy boolean NOT NULL default false,
  family text REFERENCES family (name)
);
CREATE TABLE IF NOT EXISTS recruitment
(
  id serial PRIMARY KEY,
  soldier_id int NOT NULL REFERENCES soldier (id),
  cost int NOT NULL,
  don int NOT NULL REFERENCES don (id)
);
CREATE TABLE IF NOT EXISTS "order"
(
  id serial PRIMARY KEY,
  don int NOT NULL references don (id),
  cost int NOT NULL,
  income int NOT NULL,
  soldiers_number int NOT NULL,
  lawyers_number int NOT NULL,
  sphere_of_influence int NOT NULL references sphere_of_influence (id),
  description text,
  check ( cost <= income )
);
