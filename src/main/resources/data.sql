INSERT INTO member(id,nickname,auth_id,level,start_time,end_time)
values (1, 'lee',null,null,null,null);

INSERT INTO certification(id,img_url,task_title,user_title,review,local_date,is_cleared,member_id)
values (1,null,'task-title1',null,null,'2024-12-12',false,1);

INSERT INTO certification(id,img_url,task_title,user_title,review,local_date,is_cleared,member_id)
values (2,null,'task-title2',null,null,'2024-12-12',false,1);