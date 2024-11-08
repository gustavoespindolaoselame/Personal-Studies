insert into prefeitos
    (nome, cidade_id)
values
    ('Rodrigo Neves', (select id from `cidades` where nome = 'Niterói')),
    ('Raquel Zyra', (select id from `cidades` where nome = 'Caruaru')),
    ('Zenaldo Coutinho', null);

insert into prefeitos
    (nome, cidade_id)
values
    ('Rafael Greca', null);

select * from cidades;
select * from prefeitos;
select cidades.nome as Cidade, prefeitos.nome as Prefeito from cidades, prefeitos where cidades.id = prefeitos.cidade_id;