create table secretario(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    cargo_secretario varchar(100) not null,
    nome_mae varchar(100),
    nome_pai varchar(100),
    data_nascimento date not null,
    nacionalidade varchar(100) not null,
    naturalidade varchar(100) not null,
    genero char(1) not null,
    estado_civil varchar(100) not null,
    cpf varchar(16) not null unique,
    rg varchar(20) not null unique,
    orgao_emissor varchar(20) not null,
    data_emissao date not null,
    email varchar(100) not null unique,
    telefone varchar(20) not null,
    logradouro varchar(100) not null,
    cidade varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    estado char(2) not null,
    complemento varchar(100),
    numero varchar(20) not null,
    ativo tinyint(1) not null default 1,

    primary key(id)
);
