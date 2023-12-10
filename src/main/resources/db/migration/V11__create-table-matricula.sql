create table matricula(

    id bigint not null auto_increment,
    aluno_id bigint not null,
    professor_id bigint not null,
    disciplina_id bigint not null,
    data datetime not null,
    motivo_cancelamento varchar(100),

    primary key(id),
    constraint fk_matricula_aluno_id foreign key(aluno_id) references aluno(id),
    constraint fk_matricula_professor_id foreign key(professor_id) references professor(id),
    constraint fk_matricula_disciplina_id foreign key(disciplina_id) references disciplina(id)
);