
-- unique é usado para adicionar apenas 1 valor 
create table jogadores(
	id integer identity primary key,
	nome varchar(255) not null,
	email varchar(255) not null,
	password varchar(255) not null,
	datecriacao Date not null
)

insert into jogadores (nome, email, password, datecriacao, vocacao, administrador) values 
('Aspiraboo', 'f@f.com', 'admin', DATE '2017-06-03', 1, true)

-- sql usado para o login
select count (email) from jogadores where email = 'f@f.com' and password = 'admin'


create table contato(
	id integer identity primary key,
	nome varchar(255) not null,
	endereco varchar(255) not null,
	email varchar(255) not null,
	residencial integer not null,
	celular1 integer not null,
	celular2 integer
)
