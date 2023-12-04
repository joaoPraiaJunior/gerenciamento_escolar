create table disciplina(

    id bigint not null auto_increment,
    disciplina varchar(100) not null,
    carga_horaria int not null,
    ativo tinyint(1) not null default 1,

    primary key(id)
);