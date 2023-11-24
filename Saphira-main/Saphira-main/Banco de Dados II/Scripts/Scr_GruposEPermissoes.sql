create group gr_Gerente;

create group gr_Rh;

create group gr_Bilheteria;

create group gr_Financeiro;

Grant insert, select, delete on filme, sessao to gr_Gerente;

grant insert, select, delete on funcionario to gr_Rh;

grant select on filme, ingresso, sessao to gr_Bilheteria;

grant insert, select, delete on cliente, ingresso, vendas to gr_Financeiro;
