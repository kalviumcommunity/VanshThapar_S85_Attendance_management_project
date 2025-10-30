# School Attendance System
This is a 10-part code-along project to build a console-based school attendance system in Java.

## Session 1: Introduction and Orientation
- Verified Java and Git setup.
- Initialized Git repository for the project.
- Created basic project structure with Main.java.
- Compiled and ran the initial "Welcome" program.
- Pushed initial setup to a part-01 branch on GitHub and created a PR.

### How to Run
1. Navigate to the project root directory (AttendanceSystem).
2. Compile: javac src/com/school/Main.java
3. Run: java -cp src com.school.Main

## Session 2: Core Domain Modelling
- Defined `Student` class with `studentId`, `name`, `setDetails()`, and `displayDetails()` method.
- Defined `Course` class with `courseId`, `courseName`, `setDetails()`, and `displayDetails()` method.
- Utilized arrays of objects in `Main.java` to manage and display multiple students and courses.
- Introduced basic usage of `this` keyword.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`

## Part 3: Constructor Initialization & Auto-ID Generation
- Implemented parameterized constructors in `Student` and `Course` classes for object initialization.
- Utilized `private static` member variables for automatic and unique ID generation.
- Demonstrated the use of the `this` keyword to distinguish instance variables from constructor parameters.
- Changed `Course`'s `courseId` to `int` for simpler auto-generation and updated its display.
- Updated `Main.java` to use constructors and show ID progression.

### How to Run (ensure this is up-to-date)
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`

## Part 4: Data Encapsulation & Attendance Recording Validation
- Applied encapsulation to Student and Course classes by making fields private and adding public getters.
- Introduced a new AttendanceRecord class with private fields, a constructor, and getters to store attendance data.
- Implemented basic validation in the AttendanceRecord constructor for the attendance status (allowing only "Present" or "Absent").
- Used an ArrayList in Main.java to store and display AttendanceRecord objects.
- Demonstrated retrieving IDs using getters (e.g., student1.getStudentId()) when creating records.

### How to Run
1. Navigate to the project root directory.
2. Compile: javac src/com/school/*.java (or list individual files including AttendanceRecord.java)
3. Run: java -cp src com.school.Main

## Part 5: Establishing Students, Teaching & Non-Teaching Staff hierarchy
- Created a base class `Person.java` with common attributes (`id`, `name`), a universal auto-ID generator, and a `displayDetails()` method.
- Modified `Student.java` to inherit from `Person`, using `super()` to call the parent constructor and overriding `displayDetails()` to add student-specific info (e.g., grade level).
- Created `Teacher.java` extending `Person`, adding a `subjectTaught` attribute and its own `displayDetails()`.
- Created `Staff.java` extending `Person`, adding a `role` attribute and its own `displayDetails()`.
- Demonstrated creation and display of `Student`, `Teacher`, and `Staff` objects in `Main.java`.
- Updated `AttendanceRecord` creation to use the inherited `getId()` method.

## Part 6: Interface-Driven Persistence with Storage
- Defined a `Storable` interface with a `toDataString()` method.
- Modified `Student`, `Course`, and `AttendanceRecord` classes to implement the `Storable` interface and provide their specific `toDataString()` implementations (CSV format).
- Created a `FileStorageService` class with a `saveData(List<? extends Storable> items, String filename)` method to write `Storable` objects to a text file.
- Utilized `try-with-resources` for safe file handling (`PrintWriter`, `FileWriter`).
- Demonstrated in `Main.java` how to save lists of students, courses, and attendance records to separate files (`students.txt`, `courses.txt`, `attendance_log.txt`).
- Discussed the flexibility provided by interfaces for handling different types of storable objects uniformly.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check the generated files: `students.txt`, `courses.txt`, `attendance_log.txt`.


## Part 7: Polymorphic Behaviour in Attendance and Displaying Reports
- Modified `AttendanceRecord` to hold `Student` and `Course` objects instead of just their IDs, enhancing its object-oriented nature and how records are displayed. The `toDataString()` method still uses IDs for simpler file storage.
- Created a `displaySchoolDirectory(List<Person> people)` method in `Main.java` to demonstrate polymorphism. This method iterates through a list of `Person` objects (containing `Student`, `Teacher`, `Staff` instances) and calls `person.displayDetails()`. The correct overridden method for each specific object type is executed at runtime.
- Populated a `List<Person>` in `main` and used it with `displaySchoolDirectory`.
- Updated `Main.java` to use `instanceof` and casting when preparing the list of students for saving, as `Person` itself does not implement `Storable`.
- Discussed how polymorphism allows for flexible and extensible code by treating different object types uniformly through a common interface or base class reference.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`


## Part 8: Overloaded Commands: Multiple Ways to Mark and Query Attendance
- Created an `AttendanceService.java` class to encapsulate attendance logic and manage the list of `AttendanceRecord` objects.
- Implemented overloaded `markAttendance` methods in `AttendanceService`:
    - `markAttendance(Student student, Course course, String status)`
    - `markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses)` (performs lookups)
- Implemented overloaded `displayAttendanceLog` methods in `AttendanceService`:
    - `displayAttendanceLog()` (shows all records)
    - `displayAttendanceLog(Student student)` (filters by student)
    - `displayAttendanceLog(Course course)` (filters by course)
- Utilized Java Streams for filtering records in the specific display methods.
- `AttendanceService` now uses `FileStorageService` to save its `attendanceLog`.
- Demonstrated the use of these overloaded methods in `Main.java`, showing how different method signatures allow for flexible ways to call the same conceptual operation.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check `attendance_log.txt` for saved records.


## Part 9: SOLID Service Layer: RegistrationService & AttendanceService Separation
- Applied the Single Responsibility Principle (SRP) by creating dedicated service classes.
- Created `RegistrationService.java` to handle the registration, management (lists, lookups), and saving of `Student`, `Teacher`, `Staff`, and `Course` entities.
- Modified `Teacher.java` and `Staff.java` to implement `Storable` for file persistence.
- Refactored `AttendanceService.java`:
  - It now depends on `RegistrationService` for looking up students/courses by ID.
  - Removed internal lookup helper methods, delegating this to `RegistrationService`.
  - Its primary focus is now solely on managing attendance records.
- Updated `Main.java` to act as an orchestrator, instantiating and using these services. Direct entity list management was removed from `Main`.
- Demonstrated improved code organization and clearer separation of concerns.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check for `students.txt`, `teachers.txt`, `staff.txt`, `courses.txt`, and `attendance_log.txt`.

## Part 10: Capacity Management & SOLID Principles Reflection
- Added a `capacity` feature to the `Course` class, along with an internal list of `enrolledStudents`.
- Updated `Course.displayDetails()` to show capacity and enrollment count, and `Course.toDataString()` to save capacity.
- Modified `RegistrationService`:
    - `createCourse` method now accepts a capacity parameter.
    - Added `enrollStudentInCourse(Student student, Course course)` method to handle enrollment logic, checking against course capacity.
- Updated `Main.java` to demonstrate course creation with capacity, student enrollment attempts (including exceeding capacity), and displaying updated course information.
- Discussed how other SOLID principles (like Open-Closed and Dependency Inversion) could be applied for further enhancements and flexibility.
- Concluded the 10-part project, having built a foundational console-based attendance system.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check `courses.txt` for the capacity field and other files for their respective data.
