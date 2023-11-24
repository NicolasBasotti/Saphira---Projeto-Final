select *from cinema;
select *from ClassificacaoIdade
select *from GeneroDoFilme
select *from cliente;
select *from filme;
select *from funcionario;
select *from ingresso ;
select *from sala;
select *from  sessao;
select *from vendas;
select  *from companhia;

delete from funcionario;
delete from vendas;
delete from cliente;
delete from ingresso ;
delete from sessao;
delete from sala;
delete from cinema;
delete from filme;
delete from companhia;
delete from GeneroDoFilme;
delete from ClassificacaoIdade


--1) Relação do nome do filme, tempo de
--duração e o gênero de todos os filmes.
--Ordene o relatório do filme mais
--longo(tempo) para o filme mais curto;
create view vw_listaFilmes as
select
	f.nomfil "Nome do filme",
	f.temdurfil "Tempo de duração",
	g.nomgenfil "Genero"
from
	filme f
inner join  GeneroDoFilme g on
	f.codgenfil = g.codgenfil
order by
	f.temdurfil desc;

--2) Relação do nome do filme e o nome
--da sala para todos os filmes. Filtre
--somente filmes com duração mínima
--de 90 minutos. Ordene o relatório de
--forma descendente pelo nome da sala;

create view vw_filmeSala as
select
	fil.nomfil "Nome do filme",
	sal.nomsal "Nome da sala"
from
	filme fil
inner join sessao ses on
	ses.codfil = fil.codfil
inner join sala sal on
	sal.codsal = ses.codsal
where
	fil.temdurfil >= 90
order by
	sal.nomsal desc;



--Relação com o código do filme,
--nome do filme, mês da bilheteria,
--quantidade total de ingressos vendidos
--no mês para meses entre anos de
--2020 e 2021. Ordene o relatório do
--filme com mais vendas(em termos de
--quantidade de ingressos) para o
--produto com menos vendas
create view vw_bilheteriaFilmes2020e2021 as
select
	f.codfil "Código do filme" ,
	f.nomfil "Nome do filme",
	extract(month
from
	v.datven)"Mês da bilheteria",
	count(*) "Quantidade de ingressos vendidos"
from
	filme f
inner join sessao s on
	s.codfil = f.codfil
inner join ingresso i on
	i.codses = s.codses
inner join vendas v on
	v.coding = i.coding
where
	extract(year
from
	v.datven) between 2020 and 2021
group by
	f.codfil,
	f.nomfil,
	extract(month
from
	v.datven)
order by
	count(*) desc;

-- 4) Relação com o código do filme,
--nome do filme e o total de
--bilheteria(valores). Filtrar somente
--filmes, excetuando-se dramas,
--lançados a partir de 2018 e com
--restrição de idade para maiores de 12
--anos. Ordene o relatório do filme com
--mais bilheteria para o filme com menos
--bilheteria

create view vw_bilheteriaFilmeDrama as
SELECT
  f.codfil "Código do Filme",
  f.nomfil "Nome do Filme",
  SUM(i.preing) "Total de Bilheteria"
FROM
  Filme f
  JOIN ClassificacaoIdade ci ON f.codclafil = ci.codclafil
  JOIN Sessao s ON f.codfil = s.codfil
  JOIN Ingresso i ON s.codses = i.codses
  JOIN Vendas v ON i.coding = v.coding
WHERE
  f.codgenfil = 2 
  AND EXTRACT (YEAR FROM f.datlanfil) >= 2018 
  AND ci.codclafil  >= 3
GROUP BY
  f.codfil, f.nomfil
ORDER by
  "Total de Bilheteria" DESC; 

