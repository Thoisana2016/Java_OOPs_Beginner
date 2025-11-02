use  youtubePractice;


# WINDOWS FUNCTION :
# PACTICE FOR WINDOWS FUNCTION - ROW_NUMBER(), OVER(), PARTITION, RANK(), DENSE_RANK()

CREATE TABLE baby_names(
	Gender VARCHAR(10),
    Name VARCHAR(50),
    Total INT
);


INSERT INTO baby_names(Gender, Name, Total) 
VALUES
('Girl', 'Ava', 95),
('Girl', 'Emma', 106),
('Boy', 'Ethan', 115),
('Girl', 'Isabella', 100),
('Boy', 'Jacob', 101),
('Boy', 'Liam', 84),
('Boy', 'Logan', 73),
('Boy', 'Noah', 120),
('Girl', 'Olivia', 100),
('Girl', 'Sophia', 88);


-- 1. view the table
SELECT * FROM baby_names;

-- 2. order by popularity
SELECT * FROM baby_names
ORDER BY Total DESC;

-- 3. Add a popularity column 
SELECT Gender, Name, Total,
ROW_NUMBER() OVER(ORDER BY Total DESC) AS Popularity
FROM baby_names;

-- 4. try different function RANK(), DENSE_RANK()
SELECT 
Gender, Name, Total,
ROW_NUMBER() OVER(ORDER BY Total DESC) AS Popularity,
RANK() OVER(ORDER BY Total DESC) AS Popularity_R,
DENSE_RANK() OVER(ORDER BY Total DESC) AS Popularity_DR
FROM baby_names;

-- 5. try different windows function PARTITION 
SELECT 
Gender, Name, Total,
ROW_NUMBER() OVER(PARTITION BY Gender ORDER BY Total DESC) AS Popularity
FROM baby_names;

-- 6. What are the top 3 most popular name in  both the genders 

SELECT * FROM 
(
SELECT Gender, Name, Total, 
ROW_NUMBER() OVER(PARTITION BY Gender ORDER BY Total DESC) AS Popularity
FROM baby_names
) AS POP
WHERE Popularity <= 3;


--
-- TRY OTHER FUNCTIONS LIKE {FIRST_VALUE, NTH_VALUE, LEAD, LAG, AVG, PERCENT_RANK, CUME_DIST, NTILE, PERCENTILE_COUNT, PERCENTILE_DISC)
--  




# THE BIG-6 IN SQL 
/*
SELECT 
FROM 
WHERE 
GROUP BY
HAVING 
ORDER BY
*/



--
-- Table structure for table `students`
--

CREATE TABLE students (
    id INT PRIMARY KEY,
    student_name VARCHAR(50),
    grade_level INT,
    gpa DECIMAL(2, 1),
    school_lunch VARCHAR(3),
    birthday DATE,
    email VARCHAR(100)
);

--
-- Table structure for table `student_grades`
--

CREATE TABLE student_grades (
    semester_id CHAR(8),
    class_id INT,
    department VARCHAR(50),
    class_name VARCHAR(100),
    student_id INT,
    final_grade INT,
    PRIMARY KEY (semester_id, class_id, student_id)
);

--
-- Insert data into table `students`
--

INSERT INTO students (id, student_name,  grade_level, gpa, school_lunch, birthday, email) VALUES
(1, 'Abby Johnson', 10, 3.1, 'Yes', '2008-05-14', 'abby.johnson@mavenhighschool.com'),
(2, 'Bob Smith', 11, 3.1, 'No', '2007-09-30', 'bob.smith@mavenhighschool.com'),
(3, 'Catherine Davis', 12, 3.6, 'Yes', '2006-11-21', 'catherine.davis@mavenhighschool.com'),
(4, 'Daniel Brown', 9, 3.5, 'Yes', '2009-03-10', 'daniel.brown@mavenhighschool.com'),
(5, 'Eva Martinez', 10, 2.7, 'No', '2008-02-05', 'eva.martinez@mavenhighschool.com'),
(6, 'Frank Wilson', 11, 3.2, 'No', '2007-07-17', 'frank.wilson@mavenhighschool.com'),
(7, 'Grace Lee', 12, 3.0, 'Yes', '2006-12-02', 'grace.lee@mavenhighschool.com'),
(8, 'Henry Taylor', 9, 3.0, 'Yes', '2009-06-08', 'henry.taylor@mavenhighschool.com'),
(9, 'Isabella Moore', 10, 2.8, 'Yes', '2008-01-19', 'isabella.moore@mavenhighschool.com'),
(10, 'Jack Thompson', 11, 2.9, 'Yes', '2007-04-25', 'jack.thompson@mavenhighschool.com'),
(11, 'Karen White', 9, 3.4, 'No', '2009-09-10', 'karen.white@mavenhighschool.com'),
(12, 'Liam Green', 10, 4.0, 'Yes', '2008-08-03', 'liam.green@mavenhighschool.com'),
(13, 'Mia Harris', 11, 3.0, 'No', '2007-02-28', 'mia.harris@mavenhighschool.com'),
(14, 'Noah Scott', 12, NULL, 'No', '2006-10-15', 'noah.scott@mavenparkdistrict.com'),
(15, 'Olivia Adams', 9, 3.7, 'Yes', '2009-12-11', 'olivia.adams@mavenhighschool.com'),
(16, 'Peter Park', 12, 2.9, 'Yes', '2006-02-11', 'peter.park@mavenhighschool.com');

--
-- Insert data into table `student_grades`
--

INSERT INTO student_grades (semester_id, class_id, department, class_name, student_id, final_grade) VALUES
('SPR_2024', 101, 'Math', 'Algebra', 4, 85),
('SPR_2024', 101, 'Math', 'Algebra', 8, 76),
('SPR_2024', 101, 'Math', 'Algebra', 11, 90),
('SPR_2024', 101, 'Math', 'Algebra', 15, 97),
('SPR_2024', 102, 'Math', 'Geometry', 1, 93),
('SPR_2024', 102, 'Math', 'Geometry', 5, 80),
('SPR_2024', 102, 'Math', 'Geometry', 9, 72),
('SPR_2024', 103, 'Math', 'Statistics', 2, 88),
('SPR_2024', 103, 'Math', 'Statistics', 6, 90),
('SPR_2024', 103, 'Math', 'Statistics', 10, 82),
('SPR_2024', 103, 'Math', 'Statistics', 12, 99),
('SPR_2024', 103, 'Math', 'Statistics', 13, 85),
('SPR_2024', 104, 'Math', 'Calculus', 3, 98),
('SPR_2024', 104, 'Math', 'Calculus', 7, 86),
('SPR_2024', 104, 'Math', 'Calculus', 16, 71),
('SPR_2024', 201, 'Science', 'Biology', 4, 82),
('SPR_2024', 201, 'Science', 'Biology', 8, 72),
('SPR_2024', 201, 'Science', 'Biology', 11, 87),
('SPR_2024', 201, 'Science', 'Biology', 15, 96),
('SPR_2024', 202, 'Science', 'Chemistry', 1, 94),
('SPR_2024', 202, 'Science', 'Chemistry', 2, 87),
('SPR_2024', 202, 'Science', 'Chemistry', 5, 74),
('SPR_2024', 202, 'Science', 'Chemistry', 6, 98),
('SPR_2024', 202, 'Science', 'Chemistry', 9, 76),
('SPR_2024', 203, 'Science', 'Physics', 3, 95),
('SPR_2024', 203, 'Science', 'Physics', 7, 82),
('SPR_2024', 203, 'Science', 'Physics', 10, 77),
('SPR_2024', 203, 'Science', 'Physics', 12, 96),
('SPR_2024', 203, 'Science', 'Physics', 13, 86),
('SPR_2024', 203, 'Science', 'Physics', 16, 74),
('SPR_2024', 301, 'Humanities', 'English', 1, 82),
('SPR_2024', 301, 'Humanities', 'English', 4, 75),
('SPR_2024', 301, 'Humanities', 'English', 5, 87),
('SPR_2024', 301, 'Humanities', 'English', 8, 80),
('SPR_2024', 301, 'Humanities', 'English', 9, 84),
('SPR_2024', 301, 'Humanities', 'English', 11, 98),
('SPR_2024', 301, 'Humanities', 'English', 15, 99),
('SPR_2024', 302, 'Humanities', 'World History', 2, 75),
('SPR_2024', 302, 'Humanities', 'World History', 3, 92),
('SPR_2024', 302, 'Humanities', 'World History', 6, 95),
('SPR_2024', 302, 'Humanities', 'World History', 7, 94),
('SPR_2024', 302, 'Humanities', 'World History', 10, 84),
('SPR_2024', 302, 'Humanities', 'World History', 12, 98),
('SPR_2024', 302, 'Humanities', 'World History', 13, 82),
('SPR_2024', 302, 'Humanities', 'World History', 16, 86),
('SPR_2024', 401, 'General', 'Physical Education', 1, 85),
('SPR_2024', 401, 'General', 'Physical Education', 2, 80),
('SPR_2024', 401, 'General', 'Physical Education', 4, 95),
('SPR_2024', 401, 'General', 'Physical Education', 5, 85),
('SPR_2024', 401, 'General', 'Physical Education', 6, 95),
('SPR_2024', 401, 'General', 'Physical Education', 8, 90),
('SPR_2024', 401, 'General', 'Physical Education', 9, 90),
('SPR_2024', 401, 'General', 'Physical Education', 10, 85),
('SPR_2024', 401, 'General', 'Physical Education', 11, 95),
('SPR_2024', 401, 'General', 'Physical Education', 12, 95),
('SPR_2024', 401, 'General', 'Physical Education', 13, 90),
('SPR_2024', 401, 'General', 'Physical Education', 15, 95),
('SPR_2024', 404, 'General', 'Senior Seminar', 3, 100),
('SPR_2024', 404, 'General', 'Senior Seminar', 7, 98),
('SPR_2024', 404, 'General', 'Senior Seminar', 16, 95),
('SPR_2024', 404, 'General', 'Senior Seminar', 17, NULL),
('SPR_2024', 404, 'General', 'Senior Seminar', 18, NULL);

-- 1. view table (select and from)

SELECT * FROM students; 
SELECT * FROM student_grades;

-- 2. show students who got school_lunch (where)

SELECT 
student_name, grade_level, gpa, school_lunch
FROM students
WHERE school_lunch ='Yes';

-- 3. sort the student by gpa (order by)

SELECT 
student_name, grade_level, gpa
FROM students 
ORDER BY gpa DESC;

-- 4. show average gpa for each grade level (group by)

SELECT 
grade_level, AVG(gpa) AS avg_gpa
FROM students 
GROUP BY grade_level
ORDER BY avg_gpa DESC;

-- 5. show the grade levels with an average gpa below 3.3 (having)

SELECT 
grade_level, AVG(gpa) AS avg_gpa
FROM students 
GROUP BY grade_level
HAVING avg_gpa < 3.3
ORDER BY avg_gpa DESC;

-- 6. Special Keyword | LIMIT | COUNT | DISTINCT |
-- LIMIT
SELECT 
student_name, grade_level, gpa 
FROM students 
LIMIT 5;

-- COUNT 
SELECT 
COUNT(*) 
FROM students 
WHERE gpa > 3.3;

-- DISTINCT 
SELECT 
DISTINCT gpa
FROM 
students
ORDER BY gpa DESC;

-- 7. show the final grade for each student | LEFT JOIN | 

SELECT * FROM students;
SELECT * FROM student_grades;


SELECT 
students.id, students.student_name, students.grade_level,
student_grades.class_name, student_grades.final_grade
FROM students 
LEFT JOIN student_grades
ON students.id = student_grades.student_id; 


###############################
# 12 Advance concept in SQL 
# use database youtubePractice 
# use table 
/*
✔ UNION
✔ UNION ALL
✔ Subqueries
✔ LEFT JOIN
✔ INNER JOIN
✔ CTEs
✔ Recursive CTEs
✔ Date Expressions
✔ CAST
✔ COALESCE
✔ ROUND
✔ Window Functions
*/

# data set to be use 

-- create a sales table
CREATE TABLE sales (
    dt DATE,
    num_sales INT
);

-- insert sales data into the table
INSERT INTO sales (dt, num_sales)
VALUES
    ('2025-01-01', 61),
    ('2025-01-02', 72),
    ('2025-01-04', 84),
    ('2025-01-05', 95),
    ('2025-01-07', 77);
    
-- create a final sales table
CREATE TABLE final_sales (
    dt DATE,
    num_sales INT
);

-- insert final sales data into the table
INSERT INTO final_sales (dt, num_sales)
VALUES
    ('2025-01-01', 61),
    ('2025-01-02', 72),
    ('2025-01-03', 78),
    ('2025-01-04', 84),
    ('2025-01-05', 95),
    ('2025-01-06', 86),
    ('2025-01-07', 77);




-- 1. view tables (note the missing dates)

SELECT * FROM sales;

-- 2. preview the final results 

SELECT * FROM final_sales;

-- 3. generate a seires of dates [UNION, UNION ALL]
#UNION
SELECT '2025-01-01'
UNION 
SELECT '2025-01-02'
UNION
SELECT '2025-01-03';

#UNION WITH DUPICATE 
SELECT '2025-01-01'
UNION 
SELECT '2025-01-02'
UNION
SELECT '2025-01-02';

#UNION ALL
SELECT '2025-01-01'
UNION ALL
SELECT '2025-01-02'
UNION ALL
SELECT '2025-01-03';

#UNION WITH DUPLICATE DATA 
SELECT '2025-01-01'
UNION ALL 
SELECT '2025-01-02'
UNION ALL
SELECT '2025-01-02';

-- 4. join with our original table [Subquery, Left Join, Inner Join]
# SUB-QUERY
SELECT * FROM 
(
SELECT '2025-01-01'
UNION 
SELECT '2025-01-02'
UNION
SELECT '2025-01-03'
) AS sq;

#LEFT-JOIN
SELECT sq.dt, sales.num_sales FROM 
(
SELECT '2025-01-01' AS dt
UNION 
SELECT '2025-01-02'
UNION
SELECT '2025-01-03'
UNION
SELECT '2025-01-04' 
UNION 
SELECT '2025-01-05'
UNION
SELECT '2025-01-06'
UNION
SELECT '2025-01-07'
) AS sq
LEFT JOIN sales
ON sq.dt = sales.dt;

#INNER-JOIN

SELECT * FROM 
(
SELECT '2025-01-01' AS dt
UNION 
SELECT '2025-01-02'
UNION
SELECT '2025-01-03'
UNION
SELECT '2025-01-04' 
UNION 
SELECT '2025-01-05'
UNION
SELECT '2025-01-06'
UNION
SELECT '2025-01-07'
) AS sq
INNER JOIN sales
ON sq.dt = sales.dt;

-- 5. rewrite subquery as a CTE [CTE] 

WITH sq AS (
	SELECT '2025-01-01' AS dt
    UNION
    SELECT '2025-01-02'
    UNION 
    SELECT '2025-01-03'
    UNION
    SELECT '2025-01-04'
    UNION 
    SELECT '2025-01-05'
    UNION
    SELECT '2025-01-06'
    UNION 
    SELECT '2025-01-07'
) 
-- SELECT * from sq;
SELECT 
sq.dt, sales.num_sales
FROM sq 
LEFT JOIN sales ON sq.dt = sales.dt;

-- 6. rewrite CTE as recursive CTE [Recursice CTE, Data Expression, Data Functions]

WITH cte AS (
	SELECT '2025-01-01' AS dt
    UNION ALL
    SELECT dt + INTERVAL 1 DAY 
    FROM cte 
    WHERE dt < '2025-01-07'
)
;

-- 7. fill in  null values [Null Function, Numeric Function]

-- 8. introduce Windows functions [Window Functions]

-- 9. add on two window functions [Final Query]




# Advance CTE


CREATE TABLE menu_items (
  menu_item_id SMALLINT NOT NULL,
  item_name VARCHAR(45),
  category VARCHAR(45),
  price DECIMAL(5,2),
  PRIMARY KEY (menu_item_id)
);
INSERT INTO menu_items VALUES (101, 'Hamburger', 'American', 12.95),
(102, 'Cheeseburger', 'American', 13.95),
(103, 'Hot Dog', 'American', 9),
(104, 'Veggie Burger', 'American', 10.5),
(105, 'Mac & Cheese', 'American', 7),
(106, 'French Fries', 'American', 7),
(107, 'Orange Chicken', 'Asian', 16.5),
(108, 'Tofu Pad Thai', 'Asian', 14.5),
(109, 'Korean Beef Bowl', 'Asian', 17.95),
(110, 'Pork Ramen', 'Asian', 17.95),
(111, 'California Roll', 'Asian', 11.95),
(112, 'Salmon Roll', 'Asian', 14.95),
(113, 'Edamame', 'Asian', 5),
(114, 'Potstickers', 'Asian', 9),
(115, 'Chicken Tacos', 'Mexican', 11.95),
(116, 'Steak Tacos', 'Mexican', 13.95),
(117, 'Chicken Burrito', 'Mexican', 12.95),
(118, 'Steak Burrito', 'Mexican', 14.95),
(119, 'Chicken Torta', 'Mexican', 11.95),
(120, 'Steak Torta', 'Mexican', 13.95),
(121, 'Cheese Quesadillas', 'Mexican', 10.5),
(122, 'Chips & Salsa', 'Mexican', 7),
(123, 'Chips & Guacamole', 'Mexican', 9),
(124, 'Spaghetti', 'Italian', 14.5),
(125, 'Spaghetti & Meatballs', 'Italian', 17.95),
(126, 'Fettuccine Alfredo', 'Italian', 14.5),
(127, 'Meat Lasagna', 'Italian', 17.95),
(128, 'Cheese Lasagna', 'Italian', 15.5),
(129, 'Mushroom Ravioli', 'Italian', 15.5),
(130, 'Shrimp Scampi', 'Italian', 19.95),
(131, 'Chicken Parmesan', 'Italian', 17.95),
(132, 'Eggplant Parmesan', 'Italian', 16.95);


