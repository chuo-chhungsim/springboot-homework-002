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
        REFERENCES instructors(instructor_id)
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