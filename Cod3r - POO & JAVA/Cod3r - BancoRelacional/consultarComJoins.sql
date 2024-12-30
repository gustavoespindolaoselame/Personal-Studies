select * from prefeitos;
select * from cidades;

-- INNER JOIN
select 
c.nome as 'Cidade', 
c.id as 'ID (cidade)', 
p.nome as 'Prefeito', 
p.cidade_id as 'ID (prefeito)' 
from cidades c inner join prefeitos p 
on c.id = p.cidade_id;

-- LEFT JOIN
select 
c.nome as 'Cidade', 
c.id as 'ID (cidade)', 
p.nome as 'Prefeito', 
p.cidade_id as 'ID (prefeito)' 
from cidades c left join prefeitos p 
on c.id = p.cidade_id;

-- RIGHT JOIN
select 
c.nome as 'Cidade', 
c.id as 'ID (cidade)', 
p.nome as 'Prefeito', 
p.cidade_id as 'ID (prefeito)' 
from cidades c right join prefeitos p 
on c.id = p.cidade_id;

-- FULL JOIN
select 
c.nome as 'Cidade', 
c.id as 'ID (cidade)', 
p.nome as 'Prefeito', 
p.cidade_id as 'ID (prefeito)' 
from cidades c left join prefeitos p 
on c.id = p.cidade_id
union
select 
c.nome as 'Cidade', 
c.id as 'ID (cidade)', 
p.nome as 'Prefeito', 
p.cidade_id as 'ID (prefeito)' 
from cidades c right join prefeitos p 
on c.id = p.cidade_id;