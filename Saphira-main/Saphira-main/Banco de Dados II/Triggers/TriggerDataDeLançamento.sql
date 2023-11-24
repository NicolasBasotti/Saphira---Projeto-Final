CREATE OR REPLACE FUNCTION verifica_data_lancamento() 
RETURNS TRIGGER AS 
'
BEGIN
    IF NEW.horses < (SELECT datlanfil FROM Filme WHERE codfil = NEW.codfil) THEN
        RAISE EXCEPTION ''A data da sessão é anterior à data de lançamento do filme!'';
    END IF;

    RETURN new;
end;
'
LANGUAGE plpgsql;

create trigger controle_data_lancamento
before insert on sessao
for each row
execute function verifica_data_lancamento();
