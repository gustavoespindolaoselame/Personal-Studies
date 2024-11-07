SELECT * FROM estados;

SELECT nome, sigla as 'Nome do Estado' from estados WHERE regiao = 'sul';

SELECT nome, regiao, populacao from estados where populacao >= 10 order by populacao desc;