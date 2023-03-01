create table Species
(
    species_id identity primary key,
    name varchar(50) not null
);

create table Pet
(
    pet_id identity primary key,
    name varchar(50) not null,
    pet_species_id int not null

);

alter table Pet
add foreign key (pet_species_id) references Species(species_id);