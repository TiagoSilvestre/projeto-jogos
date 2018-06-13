create table jogadores(
	id integer identity primary key,
	nome varchar(255) not null,
	email varchar(255) not null,
	password varchar(255) not null,
	datecriacao Date not null,
)

