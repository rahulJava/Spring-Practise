insert into user (id,birth_date,name)
values(10001,sysdate(),'AB'),(10002,sysdate(),'Jack'),(10003,sysdate(),'Jill');
insert into post (id,description,user_id)
values(11001,'my first post',10001),(11002,'my second post',10002);
