CREATE TABLE IF NOT EXISTS students (
                                        student_id SERIAL PRIMARY KEY ,
                                        student_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone_number VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS instructors (
    instructor_id SERIAL PRIMARY KEY ,
    instructor_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS courses (
    course_id SERIAL PRIMARY KEY ,
    course_name VARCHAR(255) NOT NULL,
    instructor_id INT NOT NULL,
    CONSTRAINT fk_instructor
        FOREIGN KEY(instructor_id)
        REFERENCES instructors(instructor_id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS students_course (
    id SERIAL PRIMARY KEY,
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    CONSTRAINT fk_student
        FOREIGN KEY(student_id)
        REFERENCES students(student_id),
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
        REFERENCES courses(course_id)

);

ALTER TABLE courses ADD COLUMN description VARCHAR(255);

ALTER TABLE courses DROP CONSTRAINT fk_instructor;

-- Step 2: Add a new foreign key constraint with CASCADE options
ALTER TABLE courses
    ADD CONSTRAINT fk_instructor
        FOREIGN KEY (instructor_id)
            REFERENCES instructors (instructor_id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

-- Step 1: Drop the existing foreign key constraints
ALTER TABLE students_course DROP CONSTRAINT fk_student;
ALTER TABLE students_course DROP CONSTRAINT fk_course;

-- Step 2: Add new foreign key constraints with CASCADE options
ALTER TABLE students_course
    ADD CONSTRAINT fk_student
        FOREIGN KEY (student_id)
            REFERENCES students(student_id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE students_course
    ADD CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES courses(course_id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;