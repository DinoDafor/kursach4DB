delete from don;
delete from consiglieri;
delete from city;
delete from family;
delete from sphere_of_influence;
delete from families_influences;
delete from soldier;
delete from lawyer;
delete from families_relationship;
delete from "order";

insert into don (name) values ('Vito Corleone');
insert into consiglieri (name) values ('Tom Haggen');
insert into city (name) values ('New York');
insert into family (name, don, budget, consiglieri, city) values ('Corleone', 1, 10, 1, 'New York');
update don set family='Corleone' where id=1;
update consiglieri set family='Corleone' where id=1;
insert into sphere_of_influence (name, city, daily_income) values ('Corruption','New York',300);
insert into families_influences (family, sphere_of_influence) values ('Corleone', 1);
insert into soldier (name, family) values ('Luca Brasi','Corleone');
insert into lawyer (name, family) values ('Fredo Corleone','Corleone');
insert into don (name) values ('Philip Tattalgia');
insert into consiglieri (name) values ('Virgil Sollozzo');
insert into family (name, don, consiglieri, city) values ('Tattalgia', 2, 2, 'New York');
update don set family='Tattalgia' where id=2;
update consiglieri set family='Tattalgia' where id=2;
insert into sphere_of_influence (name, city, daily_income) values ('Drug dealing','New York',500);
insert into families_influences (family, sphere_of_influence) values ('Tattalgia', 2);
insert into soldier (name, family) values ('Bruno Tattalgia', 'Tattalgia');
insert into families_relationship (first_family, second_family) values ('Corleone', 'Tattalgia');
insert into "order" (don, cost, income, soldiers_number, lawyers_number, sphere_of_influence) values (1, 1,2,1,1,1);
insert into soldier(name) VALUES ('Lucky Stranger');