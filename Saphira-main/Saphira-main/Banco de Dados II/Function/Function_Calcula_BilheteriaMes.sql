create or replace function calcularBilheteriaMes(mes integer, ano integer)
returns numeric
as 
$body$
declare 
	resultado numeric := 0;
	v vendas%rowtype;
	i ingresso%rowtype;
begin 
	for i in (select *from ingresso) loop
		declare
			conta integer := 0;
		begin
			select count(*) into conta 
				from vendas ven 
				where extract(month from ven.datven) = mes 
				and extract(year from ven.datven) = ano 
				and i.coding = ven.coding;
			resultado := resultado + conta * i.preing;
		end;
	end loop;
	return resultado;
end
$body$
language plpgsql;

select calcularBilheteriaMes(7,2023);

