CREATE TABLE Cinema (
	codcin    SERIAL NOT NULL, 
	cnpcin    numeric(14, 0) NOT NULL UNIQUE, 
	nomfancin varchar(60) NOT NULL, 
	endcin    varchar(60) NOT NULL, 
	telcin    numeric(11, 0) NOT NULL, 
	PRIMARY KEY (codcin));

COMMENT ON COLUMN Cinema.codcin IS 'Código do cinema';
COMMENT ON COLUMN Cinema.cnpcin IS 'Cnpj da empresa';
COMMENT ON COLUMN Cinema.nomfancin IS 'Nome fantasia do cinema';
COMMENT ON COLUMN Cinema.endcin IS 'Endereço do cinema';
COMMENT ON COLUMN Cinema.telcin IS 'Telefone do cinema com DDD: exemplo - (49) 9****-****';

CREATE TABLE ClassificacaoIdade (
	codclafil SERIAL NOT NULL, 
	nomclafil varchar(40) NOT NULL, 
	PRIMARY KEY (codclafil));

COMMENT ON COLUMN ClassificacaoIdade.codclafil IS 'Código da classificação do filme';
COMMENT ON COLUMN ClassificacaoIdade.nomclafil IS 'Nome da classificação do filme';

CREATE TABLE Cliente (
	nomcli varchar(40) NOT NULL, 
	codcli SERIAL NOT NULL, 
	cpfcli numeric(11, 0) NOT NULL UNIQUE, 
	PRIMARY KEY (codcli));
COMMENT ON COLUMN Cliente.nomcli IS 'Nome cliente';
COMMENT ON COLUMN Cliente.codcli IS 'Código do cliente';
COMMENT ON COLUMN Cliente.cpfcli IS 'CPF do cliente';


CREATE TABLE Companhia (
	codcom SERIAL NOT NULL, 
	nomcom varchar(40) NOT NULL, 
	PRIMARY KEY (codcom));

COMMENT ON COLUMN Companhia.codcom IS 'Código da Companhia do Filme';
COMMENT ON COLUMN Companhia.nomcom IS 'Nome da Companhia do Filme';


CREATE TABLE Filme (
  codfil    SERIAL NOT NULL, 
  nomfil    varchar(100) NOT NULL, 
  genfil    varchar(50) NOT NULL, 
  temdurfil int4 NOT NULL, 
  codclafil int4 NOT NULL, 
  codavacli numeric(3, 0) NOT NULL, 
  codgenfil int4 NOT NULL, 
  codcom    int4 NOT NULL, 
  datlanfil date NOT NULL, 
  PRIMARY KEY (codfil));
COMMENT ON COLUMN Filme.codfil IS 'Código do Filme';
COMMENT ON COLUMN Filme.nomfil IS 'Nome do filme';
COMMENT ON COLUMN Filme.genfil IS 'Gênero do Filme';
COMMENT ON COLUMN Filme.temdurfil IS 'Tempo de duração do filme';
COMMENT ON COLUMN Filme.datlanfil IS 'Data de lançamento do filme';


CREATE TABLE Funcionario (
	codfun    SERIAL NOT NULL, 
	nomfun    varchar(40) NOT NULL, 
	datnasfun date NOT NULL, 
	datadifun date NOT NULL, 
	cpffun    numeric(11, 0) NOT NULL UNIQUE, 
	telfun    numeric(11, 0), 
	carhorfun int4 NOT NULL, 
	codcin    int4 NOT NULL, 
	PRIMARY KEY (codfun));


COMMENT ON COLUMN Funcionario.codfun IS 'Código do Funcionário';
COMMENT ON COLUMN Funcionario.nomfun IS 'Nome do Funcionário';
COMMENT ON COLUMN Funcionario.datnasfun IS 'Data de nascimento do funcionário';
COMMENT ON COLUMN Funcionario.datadifun IS 'Data de adimissão do funcionário';
COMMENT ON COLUMN Funcionario.cpffun IS 'CPF do funcionário';
COMMENT ON COLUMN Funcionario.telfun IS 'Telefone do funcionário';
COMMENT ON COLUMN Funcionario.carhorfun IS 'Carga horária  do funcionário';

CREATE TABLE GeneroDoFilme (
	codgenfil SERIAL NOT NULL, 
	nomgenfil varchar(40) NOT NULL, 
	PRIMARY KEY (codgenfil));
	

COMMENT ON COLUMN GeneroDoFilme.codgenfil IS 'Código do gênero do filme';
CREATE TABLE Ingresso (
	  coding SERIAL NOT NULL, 
	  preing numeric(5, 2) NOT NULL, 
	  codses int4 NOT NULL, 
	  PRIMARY KEY (coding));
	 
COMMENT ON COLUMN Ingresso.coding IS 'Código do ingresso';
COMMENT ON COLUMN Ingresso.preing IS 'Preço do ingresso';
CREATE TABLE Sala (
	  codsal SERIAL NOT NULL, 
	  nomsal char(2) NOT NULL, 
	  capsal int4 NOT NULL, 
	  codcin int4 NOT NULL, 
	  PRIMARY KEY (codsal));
	 
COMMENT ON COLUMN Sala.codsal IS 'Código da Sala do Cinema';
COMMENT ON COLUMN Sala.nomsal IS 'Nome da Sala. Exemplo: A1, A2..B1,B2..';
COMMENT ON COLUMN Sala.capsal IS 'Capacidade da Sala';

CREATE TABLE Sessao (
	  codses SERIAL NOT NULL, 
	  horses date NOT NULL, 
	  codfil int4 NOT NULL, 
	  codsal int4 NOT NULL, 
	  PRIMARY KEY (codses));
	 
COMMENT ON COLUMN Sessao.codses IS 'Código da sessão';
COMMENT ON COLUMN Sessao.horses IS 'Horário da sessão';

CREATE TABLE Vendas (
	  codven SERIAL NOT NULL, 
	  datven date NOT NULL, 
	  coding int4 NOT NULL, 
	  codcli int4 NOT NULL, 
	  PRIMARY KEY (codven));
	 
COMMENT ON COLUMN Vendas.codven IS 'Código da venda';
COMMENT ON COLUMN Vendas.datven IS 'Data da venda do ingresso';

ALTER TABLE Funcionario ADD CONSTRAINT FKFuncionari406856 FOREIGN KEY (codcin) REFERENCES cinema (codcin);
ALTER TABLE Sala ADD CONSTRAINT FKSala116829 FOREIGN KEY (codcin) REFERENCES cinema (codcin);
ALTER TABLE Ingresso ADD CONSTRAINT FKIngresso379185 FOREIGN KEY (codses) REFERENCES sessao (codses);
ALTER TABLE Filme ADD CONSTRAINT FKFilme171404 FOREIGN KEY (codcom) REFERENCES companhia (codcom);
ALTER TABLE Filme ADD CONSTRAINT FKFilme434784 FOREIGN KEY (codgenfil) REFERENCES GeneroDoFilme (codgenfil);
ALTER TABLE Filme ADD CONSTRAINT FKFilme554609 FOREIGN KEY (codclafil) REFERENCES ClassificacaoIdade (codclafil);
ALTER TABLE Vendas ADD CONSTRAINT FKVendas155232 FOREIGN KEY (codcli) REFERENCES cliente (codcli);
ALTER TABLE Vendas ADD CONSTRAINT FKVendas84672 FOREIGN KEY (coding) REFERENCES ingresso (coding);
ALTER TABLE Sessao ADD CONSTRAINT FKSessao551739 FOREIGN KEY (codsal) REFERENCES sala (codsal);
ALTER TABLE Sessao ADD CONSTRAINT FKSessao263686 FOREIGN KEY (codfil) REFERENCES filme (codfil);





