-- Index para chaves secundárias
create index idx_nomeClassicacao_sk
	on ClassificacaoIdade(nomclafil);

create index idx_nomeCompanhia_sk
	on Companhia(nomcom);

create index idx_nomeCliente_sk
on Cliente(nomcli);

create index idx_nomeFilme_sk
on Filme(nomfil);

create index idx_nomeFuncionario_sk
on Funcionario(nomfun);

create index idx_nomeGenero
on GeneroDoFilme(nomgenfil);