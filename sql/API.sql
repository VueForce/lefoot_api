create table Cliente(

cliente_id serial  primary key,
cliente_Nome varchar (100) NOT NULL,
cliente_Sobrenome varchar (100) NOT NULL,
cliente_idade numeric(12,2),
cliente_Email varchar (100),
cliente_sexo char (1) default '?' check (cliente_sexo in( '?', 'M', 'F')),
cliente_cpf char(15) NOT NULL,
cliente_endereço varchar(252) NOT NULL, 
cliente_Municipio varchar(252) NOT NULL,
cliente_Estado varchar(252) NOT NULL
);


Create Table Produto(
Pro_Nome varchar(100) NOT NULL,
Pro_Descrição varchar(100) NOT NULL,
Pro_id serial primary key, 
Pro_categoria varchar (100) NOT NULL,
Pro_tipo varchar (100) NOT NULL,
Pro_valor numeric (15) NOT NULL,
Pro_quantidade numeric (15) NOT NULL
);

Create table Categoria(
cat_nome varchar(100) NOT NULL,
Pro_id integer not null,
CONSTRAINT FK_Pro_id Create table venda(
cli_id number(4) constraint fk_cli_id references Cliente (cli_id),
Pro_id number(4) constraint fk_Pro_id references Produto (Pro_id)
); (Pro_id)
		REFERENCES Produto(Pro_id),
CONSTRAINT PK_cat_nome PRIMARY KEY (cat_nome)
); 


Create table Tipo_produto(
Tip_pro_Nome varchar (100) NOT NULL,
Tip_pro_Descrição varchar (252),
cat_nome varchar (100) NOT NULL,
CONSTRAINT FK_cat_nome FOREIGN KEY (cat_nome) REFERENCES categoria(cat_nome),
Pro_id integer not null,
CONSTRAINT FK_Pro_id FOREIGN KEY (Pro_id) REFERENCES Produto(Pro_id)
);

Create table Venda(
cliente_id integer not null,
pro_id integer not null,
 CONSTRAINT FK_clente_id FOREIGN KEY (cliente_id)
        REFERENCES cliente(cliente_id),
CONSTRAINT FK_pro_id FOREIGN KEY (pro_id)
        REFERENCES produto(pro_id)

);

Alter table cliente ADD COLUMN cli_cep numeric(11,2) NOT NULL;
Alter table cliente ADD COLUMN cli_data_nascimento date;
Alter table cliente ADD COLUMN cli_numero numeric(11,2) NOT NULL;

