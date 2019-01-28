create table roles(
	role_name VARCHAR(20) primary key
);

create table users (
	id serial primary key,
	first_name VARCHAR(20) not null,
	last_name VARCHAR(40) not null,
	email VARCHAR(40) not null unique,
	password varchar(20) not null
);

create table user_roles(
	user_id int4 not null references users(id),
	role_name varchar(20) not null references roles(role_name),
	primary key(user_id, role_name)
);

insert into roles (role_name) values ('Manager'), ('Employee');
insert into users(first_name, last_name, email, password) values ('August', 'Duet', 'august.duet@revature.com', 'password123');
insert into user_roles(user_id, role_name) values (1, 'Manager');

select id, first_name, last_name, email, password, role_name from users
	join user_roles
	on users.id = user_roles.user_id
	group by users.email, users.id, user_roles.user_id, user_roles.role_name
	having email = 'august.duet@revature.com';