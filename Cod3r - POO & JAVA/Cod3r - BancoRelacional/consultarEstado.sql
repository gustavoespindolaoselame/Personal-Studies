SELECT * FROM estados;

SELECT nome as 'Nome do Estado', sigla  from estados WHERE regiao = 'sul';

SELECT nome, regiao, populacao from estados where populacao >= 10 order by populacao desc;