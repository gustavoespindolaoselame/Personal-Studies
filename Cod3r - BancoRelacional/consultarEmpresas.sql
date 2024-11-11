desc empresas;
select * from empresas;
desc cidades;
select * from cidades;
desc empresas_unidades;
select * from empresas_unidades;

select e.nome as 'Empresa', c.nome as 'Cidade'
from empresas e, empresas_unidades eu, cidades c
where e.id = eu.empresa_id and c.id = eu.cidade_id;