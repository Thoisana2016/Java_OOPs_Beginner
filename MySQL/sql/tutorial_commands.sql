use sakila;
show tables;

-- CRUD 
-- create 

-- we have insert new entries in our Film Table
-- Insert into table-name (col names seperate by commas) Values("","",), Values("","",),Values("","",); 
insert into film (title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features)
values ('The dark knight', 'Batman fights the Joker', 2008, 1, 3, 4.99,152,19.99, 'PG-13', 'Trailers');

INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) 
VALUES ('The Dark Knight', 'Batman fights the Joker', 2008, 1, 3, 4.99, 152, 19.99, 'PG-13', 'Trailers'),
       ('The Dark Knight Rises', 'Batman fights Bane', 2012, 1, 3, 4.99, 165, 19.99, 'PG-13', 'Trailers'),
       ('The Dark Knight Returns', 'Batman fights Superman', 2016, 1, 3, 4.99, 152, 19.99, 'PG-13', 'Trailers');
       
SELECT * FROM film order by film_id desc;

show tables;

-- create table
CREATE TABLE students(
	id INT AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    dateOfBirth DATE NOT NULL,
    enrolmentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    psp DECIMAL(3,2) CHECK (psp BETWEEN 0.00 AND 100.00),
    batchId INT,
    isActive BOOLEAN DEFAULT TRUE,
    PRIMARY KEY(id)
    );
    
    
    CREATE TABLE batches(
		batch_id INT PRIMARY KEY,
        batch_name VARCHAR(50) NOT NULL
	);
    
    -- INSERT SOME DUMMY DATA IN BATCH TABLE
    INSERT INTO batches( batch_id, batch_name)
    VALUES 
    (1, 'BATCH A'),
    (2, 'BATCH B'),
    (3, 'BATCH C');
    
    
    DROP table students;
    
    create table students (
		student_id INT AUTO_INCREMENT PRIMARY KEY,
        first_name VARCHAR(50) NOT NULL,
        last_name VARCHAR(50) NOT NULL,
        batch_id INT,
        FOREIGN KEY(batch_id) REFERENCES batches(batch_id)
    );
    
    -- insert some dummy data in students table
    insert into students (first_name, last_name, batch_id) 
    values 
    ('Malem', 'Khuman', 1),
    ('Soma', 'Laishram',1),
    ('Amarjit','MC', 2),
    ('Domba', 'Angom',3),
    ('Amar', 'Thok', 2);
    
DELETE FROM batches where batch_id = 1;
-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`sakila`.`students`, CONSTRAINT `students_ibfk_1` FOREIGN KEY (`batch_id`) REFERENCES `batches` (`batch_id`))
-- (do what we did) in table foreign key contains we need to defined what needs to be done when update or delete happens 

UPDATE batches set batch_id = 4 where batch_id = 1;
-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`sakila`.`students`, CONSTRAINT `students_ibfk_1` FOREIGN KEY (`batch_id`) REFERENCES `batches` (`batch_id`))


ALTER TABLE students
DROP FOREIGN KEY batch_id;

ALTER TABLE students
DROP FOREIGN KEY students_ibfk_1 ,
ADD FOREIGN KEY (batch_id) REFERENCES batches(batch_id) ON DELETE CASCADE ON UPDATE CASCADE;
-- Error Code: 1091. Can't DROP 'batch_id'; check that column/key exists
-- batch_id(COL NAME) shouldn't be use instead use the key generated for the foreign key by the MYSQL

desc students;

DELETE FROM batches where batch_id = 1;

UPDATE batches set batch_id = 4 where batch_id = 2;
 select * from students;
 
 
 
 -- CURD (READ = SELECT)
 
SELECT * FROM film;
select title, description, release_year from film;
-- case insensitive 
select title, deScription, releAse_Year from film;

select title as Film_Name, deScription, releAse_Year from film;


select rating from film;

select distinct rating from film;
-- distinct with multiple column, yes possible. the combination i distnct 
select distinct rating, release_year from film;



Select "hello world";

select title, "hello world", "good movies" from film;

-- operations on cloumn
-- title, length in films table

select title, length/60 from film; -- conversion of length of film in minutes t0 hrs 
select title, ROUND(length/60) from film;
select title, ROUND(length/60) AS length_in_hrs from film;


-- insert data from another table 
-- copy film table to film_copy table (or insert data to this table ) 
-- need to create a table call film_copy same as film table
-- insert into film_copy(col_names)
-- values (); => select title, description ..... from film 

show create table film;
# Table, Create Table
 CREATE TABLE `film_copy` (
  `film_id` smallint unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `description` text,
  `release_year` year DEFAULT NULL,
  `language_id` tinyint unsigned NOT NULL,
  `original_language_id` tinyint unsigned DEFAULT NULL,
  `rental_duration` tinyint unsigned NOT NULL DEFAULT '3',
  `rental_rate` decimal(4,2) NOT NULL DEFAULT '4.99',
  `length` smallint unsigned DEFAULT NULL,
  `replacement_cost` decimal(5,2) NOT NULL DEFAULT '19.99',
  `rating` enum('G','PG','PG-13','R','NC-17') DEFAULT 'G',
  `special_features` set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes') DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(film_id)
);

select * from film_copy;

-- copying data from film to film_cpoy
insert into film_copy (film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, 
replacement_cost, rating, special_features, last_update) 
(select film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, 
replacement_cost, rating, special_features, last_update from film);



-- CURD CONTINUE 
USE sakila;

select distinct rating, release_year from film 
where rating = 'PG-13';


SELECT * FROM film WHERE RATING = 'PG-13' AND RELEASE_YEAR = 2006;

SELECT * FROM film WHERE (RATING = 'PG-13' AND RELEASE_YEAR = 2006 
)or length > 100;


SELECT * FROM film WHERE (RATING = 'PG-13' AND RELEASE_YEAR = 2006 
)or length <> 100;

select * from film 
where rating IN('PG-13', 'G');

select * from film 
where release_year >= 2005 AND release_year <= 2010;
-- the avobe query cqn be executed using between, inclusve of 2005 and 2010
select * from film
where release_year between 2005 and 2010;


select * from film 
where release_year between 2006 and 2010;

select distinct release_year from film;
select * from film 
where release_year > 2010;

select * from film 
where (rating = 'PG-13' and release_year = 2006) or length <> 100;
 
 
 select * from film
 where rating in ('PG-13','G');
 
 select * from film 
 where release_year between 2008 and 2010 or rating = 'R';
 
 select * from film where title like '%love';
  select * from film where title like '%love%';
  
  
select * from film where title is null;
select * from film where title is not null;


select null = null;
select 1 = 1;


select * from sql_store.customers where birth_date is null;

-- is null and phone != '7005614625';
-- is null or phone != '7005614625'

-- ORDER BY
select * from film order by title; -- by default ascending order 
select * from film order by title desc;

select * from film order by description;

select * from film order by title, release_year; -- sorted order title first and then release_year
select * from film order by release_year, length;
select * from film order by release_year desc, length;



select distinct title from film order by release_year;

select * from film limit 10;
select * from film order by title desc offset 10; -- error
select * from film limit 10 offset 10;


delete from film where film_id = 1; -- can't delete due to foreign key constrain 

update film set title = 'Dark Does Not Rise' where title = 'The Dark Night rises';
select title from film order by film_id desc;

update film set title = 'Dark Does Not Rise' where title = 'The Dark Knight Rises';


select * from students;
delete from students where first_name = 'Domba';
delete from students where last_name = "Angom";
delete from students where student_id = 4;
truncate students;
select * from students;

insert into students (first_name, last_name, batch_id)
values
('Mrinalini', "Ningthoujam", 3),
('Martina', 'Chanu', 3);
select * from students;

drop table students;

-- join 
select * from film;
select * from language;

select f.title, l.name 
from film f
join language l
On f.language_id = l.language_id;





select * from film
where original_language_id is not null;


select f.title, l1.name, l2.name
from film f
join language l1 
on f.language_id = l1.language_id
Join language l2 
ON f.original_language_id = l2.language_id;

select f.title, l1.name, l2.name
from film f
join language l1 
on f.language_id = l1.language_id
Join language l2 
ON f.original_language_id = l2.language_id;


