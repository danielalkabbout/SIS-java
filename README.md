# Student Information System (SIS)

A console-based Student Information System written in plain Java (no external
dependencies). It models a small university: students, instructors, and
courses, with enrollment, grading, attendance, and tuition-fee tracking, all
driven from a single interactive text menu.

This project was built as a Java course assignment and uses only the JDK
standard library (`java.util`, `java.text`).

## Features

- **Two login modes** from one entry screen:
  - **Admin** (type `admin`) — full management console.
  - **Student** (type a student ID) — self-service menu.
- **Course management** — create, list, inspect, and delete courses; assign
  or change an instructor; auto-generated course IDs (e.g. `INTR_1001`,
  derived from the course name).
- **Student management** — register students (with up to two majors),
  list/inspect/remove students, enroll/withdraw from courses.
- **Instructor management** — hire, list, inspect, fire instructors; assign
  an instructor to a course.
- **Grading** — enter quiz, midterm, and final grades per student per
  course; final grade computed as `quiz*0.2 + midterm*0.3 + final*0.5`;
  eligibility for the next course is set when the final grade exceeds 60.
- **GPA** — computed as a credit-weighted average of a student's course
  grades.
- **Attendance** — take attendance per course session; a student is
  automatically withdrawn from a course after 9 recorded absences.
- **Tuition fees** — cost is calculated per credit; a GPA-based discount
  (10%–100%) is applied on a sliding scale from 3.3 to 4.0, with the total
  split into 3 monthly installments.
- **Auto-generated IDs** — student, instructor, and course IDs are assigned
  automatically on creation (no manual ID entry).

## Project structure

```
codes/
  SIS.java          Entry point — menu loop and all user interaction
  Person.java       Abstract base class for Student and Instructor
  Student.java      Student data, majors, GPA, course roster
  Instructor.java   Instructor data and assigned courses
  Course.java       Course roster, grading, attendance, instructor assignment
  Grade.java        Quiz / midterm / final grade breakdown for one student
  Attendance.java   Per-student absence tracking for a course
  TuitionFees.java  Tuition calculation and GPA-based discount logic
  read write files not completed/
                    Early, unfinished attempt at CSV persistence (not wired
                    into the app — kept for reference only)
SIS UML diagrame.drawio   UML class diagram of the system (open with draw.io)
SIS.iml                   IntelliJ IDEA module file
out/                       Compiled .class output (IntelliJ build output)
```

### Class overview

- `Person` (abstract) — shared fields for first/father's/last name, age,
  address, auto-generated email, and ID; `Student` and `Instructor` both
  extend it.
- `Student` — holds enrolled `Course`s, majors, GPA, and a `TuitionFees`
  instance; can enroll/withdraw from courses and view its own grades.
- `Instructor` — holds the list of courses they teach.
- `Course` — owns fixed-size arrays of enrolled students, their `Grade`s,
  and their `Attendance` records; handles enrollment capacity, grading, and
  attendance-based auto-withdrawal.
- `Grade` — stores quiz/midterm/final scores and derives the final grade
  and next-course eligibility.
- `Attendance` — tracks a student's absence count within one course.
- `TuitionFees` — computes full payment, monthly installment, and discount
  from GPA and enrolled credits.

> Note: this is a study project, not production-grade — data lives only in
> memory for the duration of a run (nothing is persisted to disk or a
> database) and input validation is minimal in places.

## Requirements

- JDK 8 or later (no external libraries or build tool required).

## Running the program

### From the command line

```bash
cd codes
javac *.java -d ../out/production/SIS
java -cp ../out/production/SIS SIS
```

### From IntelliJ IDEA

Open the project folder (the `.iml` module is already configured with
`codes` as the source root), then run `SIS.java`.

## Usage

On launch you're prompted to "type anything to continue":

- Type **`admin`** to enter the administrator console, which exposes the
  full set of management options (list/create/inspect courses, students,
  and instructors; enroll/withdraw students; take attendance; enter
  grades; hire/fire instructors; etc.).
- Type a **student ID** (shown when you list/register students, e.g.
  `20230001`) to log in as that student and access a self-service menu:
  view courses, enroll in a course, check tuition/payment status, or
  withdraw from a course.
- Type **`Terminate`** at the initial prompt to exit the program.

Most admin actions that operate on a specific course, student, or
instructor are best performed from that entity's own detail menu (e.g.
enroll a student from inside "Check a Course" or "Check a Student") — the
top-level menu options for these actions point you to the right submenu.

## Known limitations

- No data persistence — all data (students, instructors, courses) is lost
  when the program exits. A CSV read/write layer was started but never
  finished (see `codes/read write files not completed/`).
- No authentication beyond typing `admin` or a numeric student ID (no
  passwords).
- Course capacity is capped at a maximum of 20 students, credit weight
  must be 1 or 3, and a student may declare at most 2 majors — these are
  fixed business rules baked into the menu prompts.
