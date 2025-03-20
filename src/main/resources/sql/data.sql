select * from students;


INSERT INTO students (student_name, email, phone_number)
VALUES
    ('Sokun Chanthy', 'sokun@example.com', '096 123 456'),
    ('Vannak Sreymom', 'vannak@example.com', '097 234 567'),
    ('Pisey Hong', 'pisey@example.com', '098 345 678'),
    ('Thy Sovan', 'thy@example.com', '099 456 789'),
    ('Ling Vannak', 'ling@example.com', '010 567 890');
INSERT INTO instructors (instructor_name, email)
VALUES
    ('Dr. Khmer Tech', 'khmertech@example.com'),
    ('Prof. Language Arts', 'languagearts@example.com'),
    ('Mr. Science Expert', 'scienceexpert@example.com'),
    ('Ms. Art Master', 'artmaster@example.com'),
    ('Mr. Math Genius', 'mathgenius@example.com');
INSERT INTO courses (course_name, description, instructor_id)
VALUES
    ('កុំព្យូទ័រ 101', 'Introduction to Computer Science', 1),
    ('សិល្បៈ 201', 'Advanced Painting Techniques', 4),
    ('វិទ្យាសាស្ត្រ 150', 'Fundamentals of Physics', 3),
    ('ប្រព័ន្ធប្រឹក្សាសិទ្ធិ', 'Information Systems Management', 1),
    ('គណីតវិទ្យា ១០២', 'Calculus for Engineers', 5);
INSERT INTO students_course (student_id, course_id)
VALUES
    (1, 1),
    (1, 3),
    (2, 2),
    (2, 4),
    (3, 1),
    (3, 5),
    (4, 3),
    (4, 4),
    (5, 2),
    (5, 5);