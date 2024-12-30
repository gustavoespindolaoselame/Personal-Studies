select 
e.nome as Estado, 
c.nome as Cidade, 
regiao as Regiao 
from 
estados e, cidades c 
where e.id = estado_id;

select 
e.nome as Cidades, 
ec.nome as Estado, 
regiao as Regiao 
from estados e 
inner join `cidades` c on e.id = estado_id