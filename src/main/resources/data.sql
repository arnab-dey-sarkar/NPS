INSERT INTO Survey (id, topic, TEAM_ID) VALUES (1, 'Communication','Arrow')
INSERT INTO Survey (id, topic, TEAM_ID) VALUES (2, 'Performance','Arrow')

INSERT INTO QUESTION  (QUESTION_ID, DESCRIPTION) VALUES (1, 'Communication')
INSERT INTO QUESTION  (QUESTION_ID, DESCRIPTION) VALUES (2, 'Performance')

INSERT INTO Accounts(User_Name,Password,Active,User_Role) VALUES ('Suman','123456',1,'CLIENT')
INSERT INTO REGISTER_TEAM(ID,TMANAGERNAME,TMEMBERNAME,TNAME,TPROJECTID) VALUES(1,'Suman','Arka,Arnab','Arrow',119056879)