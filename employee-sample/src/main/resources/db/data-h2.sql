DELETE FROM `e_employee`;
INSERT INTO `e_employee`(`id`, `name`, `age`, `email`) VALUES (1, 'Jone', 18, 'test1@baomidou.com');
INSERT INTO `e_employee`(`id`, `name`, `age`, `email`) VALUES (2, 'Jack', 20, 'test2@baomidou.com');
INSERT INTO `e_employee`(`id`, `name`, `age`, `email`) VALUES (3, 'Tom', 28, 'test3@baomidou.com');
INSERT INTO `e_employee`(`id`, `name`, `age`, `email`) VALUES (4, 'Sandy', 21, 'test4@baomidou.com');
INSERT INTO `e_employee`(`id`, `name`, `age`, `email`) VALUES (5, 'Billie', 24, 'test5@baomidou.com');

DELETE FROM `e_skill`;
INSERT INTO `e_skill`(`id`, `category`, `name`) VALUES (1, 'develop', 'Java');
INSERT INTO `e_skill`(`id`, `category`, `name`) VALUES (2, 'develop', 'Python');
INSERT INTO `e_skill`(`id`, `category`, `name`) VALUES (3, 'develop', 'Go');
INSERT INTO `e_skill`(`id`, `category`, `name`) VALUES (4, 'office', 'excel');

DELETE FROM `e_skill_level`;
INSERT INTO `e_skill_level`(`id`, `skill_id`, `name`, `requirement`) VALUES (1, 1, '初级', '0-1年');
INSERT INTO `e_skill_level`(`id`, `skill_id`, `name`, `requirement`) VALUES (2, 1, '中级', '1-3年');
INSERT INTO `e_skill_level`(`id`, `skill_id`, `name`, `requirement`) VALUES (3, 1, '高级', '3-5年');
INSERT INTO `e_skill_level`(`id`, `skill_id`, `name`, `requirement`) VALUES (4, 1, '资深', '5-8年');
INSERT INTO `e_skill_level`(`id`, `skill_id`, `name`, `requirement`) VALUES (5, 4, '初级', '基本使用');
INSERT INTO `e_skill_level`(`id`, `skill_id`, `name`, `requirement`) VALUES (6, 4, '中级', '基本函数');
INSERT INTO `e_skill_level`(`id`, `skill_id`, `name`, `requirement`) VALUES (7, 4, '高级', '函数及制图');

DELETE FROM `e_employee_skill`;
INSERT INTO `e_employee_skill`(`id`, `employee_id`, `skill_id`, `skill_level_id`) VALUES (1, 1, 1, 2);
INSERT INTO `e_employee_skill`(`id`, `employee_id`, `skill_id`, `skill_level_id`) VALUES (2, 2, 1, 3);
INSERT INTO `e_employee_skill`(`id`, `employee_id`, `skill_id`, `skill_level_id`) VALUES (3, 2, 4, 1);

