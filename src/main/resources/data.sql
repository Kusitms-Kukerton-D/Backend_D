INSERT INTO member(id, nickname, auth_id, level, start_time, end_time)
values (1, 'leesangmin', 1234, 4, '2024-03-01 00:00', '2024-03-03 00:00');

INSERT INTO task(id,content,category,title,hour,minute) values (1,'새로운 운동을 시도해요. 클라이밍 도전!','운동','클라이밍하기','0','30');
INSERT INTO task(id,content,category,title,hour,minute) values (2,'마음의 양식을 채워보아요.','자기계발','독서하기','1','0');
INSERT INTO task(id,content,category,title,hour,minute) values (3,'오늘은 캐릭터에게 휴식을 주세요~','게임','게임하기','0','30');
-- INSERT INTO task(id,content,category,title,hour,minute) values (4,'야식2','야식','야식','1','0');
-- INSERT INTO task(id,content,category,title,hour,minute) values (5,'배달음식1`','음식','수영','0','30');
-- INSERT INTO task(id,content,category,title,hour,minute) values (6,'배달음식2','음식','수영','1','0');
-- INSERT INTO task(id,content,category,title,hour,minute) values (7,'게임1','게임','게임쓰','0','30');
-- INSERT INTO task(id,content,category,title,hour,minute) values (8,'게임2','게임','게임쓰','1','0');

INSERT INTO store(id,name,category,is_opened,end_time,task_id) values (1,'더 클라임 신린점','운동',true,'22:00',1);

INSERT INTO certification(id, img_url, task_title, user_title, review, local_date, is_cleared,member_id,content)
values (1, null, '새로운 운동을 시도해요. 클라이밍 도전!', null, null, '2024-12-12', false, 1,'클라이밍하기');

INSERT INTO certification(id, img_url, task_title, user_title, review, local_date, is_cleared,member_id,content)
values (2, null, '마음의 양식을 채워보아요:)', null, null, '2024-12-12', false, 1,'독서하기');

INSERT INTO certification(id, img_url, task_title, user_title, review, local_date, is_cleared,member_id,content)
values (3, null, '오늘은 캐릭터에게 휴식을 주세요~', null, null, '2024-12-12', false, 1,'게임 그만하기');

INSERT INTO coupon (id, content, end_date, member_id, store_id)
values (1, '더클라임 신린점 15% 할인', '2024-04-08', 1, 1);

INSERT INTO coupon (id, content, end_date, member_id, store_id)
values (2, '영풍문고 10% 할인', '2024-04-08', 1, null);

INSERT INTO coupon (id, content, end_date, member_id, store_id)
values (3, '낭만모로코 15% 할인', '2024-04-08', 1, null);