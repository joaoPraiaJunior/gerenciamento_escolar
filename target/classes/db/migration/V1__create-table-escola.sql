create table escola(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(20) not null,
    cnpj varchar(14) not null unique,
    logradouro varchar(100) not null,
    cidade varchar(100) not null,
    bairro varchar(100) not null,
    cep varchar(9) not null,
    estado char(2) not null,
    complemento varchar(100),
    numero varchar(20) not null,
    instagram varchar(100),
    youtube varchar(100),
    ativo tinyint(1) not null default 1,

    primary key(id)
);