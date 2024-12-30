select * from estados where id = 25;
select * from cidades;

insert into cidades (nome, area, estado_id)
values('Campinas', 795, 25);

insert into cidades (nome, area, estado_id)
values('Niterói', 133.9, 19);

insert into cidades (
    nome, 
    area, 
    estado_id)
values(
    'Caruaru', 
    920.6, 
    (select id from estados where sigla = 'PE'));

insert into cidades (
    nome, 
    area, 
    estado_id)
values(
    'Juazeiro do Norte', 
    248.2, 
    (select id from estados where sigla = 'CE'));

delete from `cidades` where id >= 1;

