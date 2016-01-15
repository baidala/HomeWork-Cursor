# HomeWork-Cursor
HomeWork-Cursor


Домашка на каникулы.
Адрес сервера - http://cityfinder.esy.es/javaapi.php
На сервере лежат данные о сотрудниках с записями: "id","name", "job", "age", "sex", "salary". Для
каждого студента подготовил таблицу в базе данных с одинаковой структурой. Запросы
производятся с помощью GET метода.
Пользователи сервера:
1. baydala
2. bezginsky
3. gorodetsky
4. harlamov
5. ilchenko
6. korniyuk
7. ostrovsky
8. petrushov
9. serpak
10. vdovinec
11. zayceva
Возможные запросы:
1. login – возвращает 1 если пользователь с таким логином/паролем есть, 0 – если нет, на
вход (переменные в запросе) – type=login – константа типа запроса, user – имя
пользователя, password – пароль.
Формат - http://cityfinder.esy.es/javaapi.php?type=login&user=baydala&password=11111
2. change – замена пароля, возвращает 1 – если пользователь с id найден и пароль поменян,
иначе – 0, на вход - type=change – константа типа запроса, user – имя пользователя,
password – новый пароль, id – id пользователя.
Формат -
http://cityfinder.esy.es/javaapi.php?type=change&user=baydala&password=0000&id=1
3. query – возвращает все данные с таблицы, на вход - type=get – константа типа запроса, user
– имя пользователя. Если записей нету возвращает 0. Формат возвращаемых записей,
каждый сотрудник разделен символом #, между данными о сортуднике символ ;
Формат -
http://cityfinder.esy.es/javaapi.php?type=get&user=baydala
4. insert – позволяет вставить в таблицу нового сотрудника, возвращает 1 если успех, 0 – если
ошибка. На вход - type=insert – константа типа запроса, name, job, age, sex, salary – данные
о сотруднике, user – имя пользователя.
Формат -
http://cityfinder.esy.es/javaapi.php?type=insert&name=Tom&job=It&age=45&sex=M&salary=3
000&user=baydala
5. update – редактирование записи о сотруднике, возвращает 1 если успех, 0 – если ошибка.
На вход - type=update – константа типа запроса, id, name, job, age, sex, salary – данные о
сотруднике, user – имя пользователя.
Формат -
http://cityfinder.esy.es/javaapi.php?type=update&id=1&name=Tom&job=It&age=45&sex=M&s
alary=3000&user=baydala
6. delete – удаление записи о сотруднике, возвращает 1 если успех, 0 – если ошибка. На вход
- type=delete – константа типа запроса, id – id сотрудника, user – имя пользователя
Формат -
http://cityfinder.esy.es/javaapi.php?type=delete&id=1&user=baydala
Задание – разработать проект консольного доступа к базе данных сотрудников, используя сервер.
Пользователь должен логинится и ему должны быть доступны все возможности редактирования
БД.
