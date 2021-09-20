insert into sales (sale_id, date_from, date_to, percentage, text, user_id) values (1, '2002-02-02', '2222-11-11', 10, 'Sale',1)

insert into articles(id,article_description,article_mark,article_name,path,deleted,user_id) values(1,'Kroasan 7days', 5, 'Kroasan', 'Putanja1',0,1)
insert into articles(id,article_description,article_mark,article_name,path,deleted,user_id) values(2,'Najlepse zelje cokolada', 5, 'Cokolada', 'Putanja2',0,2)
insert into articles(id,article_description,article_mark,article_name,path,deleted,user_id) values(3,'7up', 5, 'Gazirani sok', 'Putanja3',0,1)
insert into articles(id,article_description,article_mark,article_name,path,deleted,user_id) values(4,'Pepsi', 5, 'Pepsi', 'Putanja4',0,2)
insert into articles(id,article_description,article_mark,article_name,path,deleted,user_id) values(5,'Gud kikiriki', 5, 'Kikiriki', 'Putanja5',0,1)
insert into articles(id,article_description,article_mark,article_name,path,deleted,user_id) values(6,'Wellness sa grozdjem', 5, 'Wellness', 'Putanja6',0,2)
insert into articles(id,article_description,article_mark,article_name,path,deleted,user_id) values(7,'Stark stapici', 5, 'Stapici', 'Putanja7',0,2)
insert into articles(id,article_description,article_mark,article_name,path,deleted,user_id) values(8,'Belo meso', 5, 'Meso', 'Putanja8',0,2)

insert into articles_sales values (1,1)

insert into users(dtype, user_id, firstname, lastname, password, user_type, blocked,  username, address, date_from,email, name) values ('Seller',1, 'Ivan', 'Ivan', 'Ivan', 1, 0, 'a', 'a', '2023-04-04', 'Ivan','Ivan')
insert into users(dtype, user_id, firstname, lastname, password, user_type, blocked,  username, address, date_from,email, name) values ('Seller',2, 'Milan', 'Milan', 'Milan', 2, 0, 'a1', 'a1', '2024-05-05', 'Milan','Milan')