INSERT INTO member(id, nickname, auth_id, level, start_time, end_time)
values (1, 'leesangmin', 1234, 4, '2024-03-01 00:00', '2024-03-03 00:00');

INSERT INTO task(id,content,category,title,hour,minute) values (1,'2km 뛰기','운동','뛰기','0','30');
INSERT INTO task(id,content,category,title,hour,minute) values (2,'수영하기','운동','수영','1','0');
INSERT INTO task(id,content,category,title,hour,minute) values (3,'야식1','야식','야식','0','30');
INSERT INTO task(id,content,category,title,hour,minute) values (4,'야식2','야식','야식','1','0');
INSERT INTO task(id,content,category,title,hour,minute) values (5,'배달음식1`','음식','수영','0','30');
INSERT INTO task(id,content,category,title,hour,minute) values (6,'배달음식2','음식','수영','1','0');
INSERT INTO task(id,content,category,title,hour,minute) values (7,'게임1','게임','게임쓰','0','30');
INSERT INTO task(id,content,category,title,hour,minute) values (8,'게임2','게임','게임쓰','1','0');

INSERT INTO store(id,name,category,is_opened,end_time,task_id) values (1,'더 클라임 서울','운동',true,'22:00',1);

INSERT INTO certification(id, img_url, task_title, user_title, review, local_date, is_cleared,member_id)
values (1, null, 'task-title1', null, null, '2024-12-12', false, 1);

INSERT INTO certification(id, img_url, task_title, user_title, review, local_date, is_cleared,member_id)
values (2, null, 'task-title2', null, null, '2024-12-12', false, 1);

INSERT INTO coupon (id, content, end_date, member_id, store_id)
values (1, 'coupon1', '2024-12-01', 1, 1);

INSERT INTO coupon (id, content, end_date, member_id, store_id)
values (2, 'coupon2', '2023-12-01', 1, 1);