select regiao as 'Região', 
sum(populacao) as Total from `estados`
GROUP BY regiao
order by Total desc

select sum(populacao) as Total
from estados

select min(populacao) as Total
from estados

select nome, populacao as populacao
from estados order by populacao desc