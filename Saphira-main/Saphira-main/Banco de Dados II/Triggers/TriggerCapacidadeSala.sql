create or replace function verifica_capacidade()
returns trigger 
as 
'
declare 
	capacidadeAtual integer;
	capacidadeMaxima integer;
begin 
	select capsal into capacidadeAtual from sala where codsal = new.codsal;
	select count(*) into capacidadeMaxima from ingresso where codses = new.codses;
	
	if capacidadeMaxima = capacidadeAtual then
	raise exception ''capacidade da sala atingida!'';
    elsif capacidadeMaxima > capacidadeAtual then 
    	raise exception ''capacidade da sala excedida!'';
    end if;
   return new;
end;
'
language plpgsql;


create trigger controle_capacidade
before insert on vendas
for each row
execute function verifica_capacidade();