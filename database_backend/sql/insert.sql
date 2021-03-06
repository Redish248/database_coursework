-- alter sequence users_uid_seq restart with 1;
-- alter sequence feed_uid_seq restart with 1;
-- alter sequence objects_uid_seq restart with 1;
-- alter sequence user_type_uid_seq restart with 1;
-- alter sequence staff_uid_seq restart with 1;
-- alter sequence position_uid_seq restart with 1;

-- roles
insert into user_type(name, description)
values ('ADMIN', 'администатор проюта');
insert into user_type(name, description)
values ('MANAGER', 'управляет животными');
insert into user_type(name, description)
values ('READER', 'зарегистрированный пользователь');

-- positions
insert into position("name", "description")
values ('генеральный директор', 'отвечает за координацию между отделами, сделки по контрактам');

insert into position("name", "description")
values ('ветеринар', 'лечит животных');

insert into position("name", "description")
values ('юрист', 'сопровождает все сделки компании');

insert into position("name", "description")
values ('главный бухгалтер', 'занимается вопросами налогообложения, зар.платами сотрудников');

insert into position("name", "description")
values ('бухгалтер', 'помогает главному бухгалтеру');

insert into position("name", "description")
values ('волонтер', 'проводит время с животными');

insert into position("name", "description")
values ('кормилец', 'ответственный за кормление животных');

insert into position("name", "description")
values ('кормилец опасных животных', 'к числу опасных относятся животных диких пород, а также новоприбывшие животные');

insert into position("name", "description")
values ('маркетолог', 'отвечает за все рекламные компании, а также за проведение благотворительных меропряитий');

-- staff
insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Илья', 'Сидоров', 'Владимирович', '1982-05-10', 'мужской', 2, 120000, 15, '2020-02-10');

insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Юлия', 'Прокатьева', 'Ивановна', '1970-01-18', 'женский', 3, 90000, 30, '2019-11-01');
insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Илона', 'Кузьмина', 'Руслановна', '1995-07-01', 'женский', 3, 65000, 4, '2021-05-19');

insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Ульяна', 'Васильева', 'Игоревна', '1995-08-10', 'женский', 4, 98000, 7, '2021-01-15');

insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Марьяна', 'Петрова', 'Евдокомовна', '1979-09-20', 'женский', 5, 105000, 19, '2019-12-31');

insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Олег', 'Песков', 'Александрович', '2000-06-19', 'мужской', 6, 90000, 3, '2021-10-10');

insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Евгений', 'Окатьев', 'Алексеевич', '1997-04-01', 'мужской', 7, 30000, 3, '2020-07-01');
insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Александр', 'Культов', 'Ильич', '1999-08-15', 'мужской', 7, 30000, 2, '2020-07-01');
insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Игорь', 'Михайлов', 'Дмитриевич', '1996-09-01', 'мужской', 7, 30000, 5, '2020-07-01');

insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Иван', 'Прокофьев', 'Олегович', '1999-10-01', 'мужской', 8, 27000, 5, '2021-07-23');
insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Владислав', 'Бобченко', 'Дмитриевич', '1989-09-01', 'мужской', 8, 31000, 15, '2022-01-19');

insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Артем', 'Спиридонов', 'Михайлович', '1989-09-15', 'мужской', 9, 37000, 16, '2021-12-19');

insert into staff(name, surname, patronymic, date_of_birth, gender, position, salary, experience, first_work_date)
values ('Мария', 'Васильева', 'Юрьевна', '1990-09-15', 'мужской', 10, 89000, 10, '2019-01-19');

-- objects
-- objects
insert into objects(name, description, price, amount)
values ('коврик для котов и собак', 'мягкий пушистый не линяющий коврик для четвероногих животных', 300, 50);

insert into objects(name, description, price, amount)
values ('миска тяжелая', 'большая тяжелая миска для корма для крупных животных', 450, 10);

insert into objects(name, description, price, amount)
values ('миска для воды', 'глубокая миска для воды', 310, 19);

insert into objects(name, description, price, amount)
values ('лоток для котов', 'закрытый кошачий лоток', 800, 20);

insert into objects(name, description, price, amount)
values ('маленький лоток для котов', 'открытый лоток для котов', 600, 50);

insert into objects(name, description, price, amount)
values ('когтеточка обыкновенная', 'напольная когтеточка', 800, 15);

insert into objects(name, description, price, amount)
values ('когтеточка средняя', 'сборная когтеточка - напольная или настенная', 1500, 5);

insert into objects(name, description, price, amount)
values ('игрушки', 'резиновые игрушки для собак', 350, 60);

insert into objects(name, description, price, amount)
values ('клетка для пернатых животных', 'просторная клетка для одного пернатого животного', 2000, 10);

insert into objects(name, description, price, amount)
values ('клетка для грызунов', 'просторная клетка для грызунов от 1 до 3 штук', 1900, 5);

-- feed
insert into feed (name, description, price, amount)
values ('корм для котят', 'Purina Pro Plan для котят 1кг', 900, 10);

insert into feed (name, description, price, amount)
values ('корм для взрослых котов', 'Purina Pro Plan для взрослых особей 1кг', 120, 20);

insert into feed (name, description, price, amount)
values ('корм для взрослых стерилизованных кошек', 'Purina Pro Plan для стерилизованных кошек 3кг', 1300, 15);

insert into feed (name, description, price, amount)
values ('корм для пернатых', 'Смесь 1.5кг', 2000, 5);

insert into feed (name, description, price, amount)
values ('корм для грызунов', 'Смесь 1кг', 1800, 4);
