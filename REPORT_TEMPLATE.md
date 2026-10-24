# Web Technology Assignment II — Report

**Student name:** [Your name]  
**Register number:** [Your register number]  
**Course:** U21CS501 Web Technology  
**Assignment:** II — Student Admission and Profile Portal  
**GitHub repository:** https://github.com/Manoj1751/college-student-portal-assignment

## Question 1 — HTML, CSS and JavaScript (8 marks)
The registration form includes name, roll number, email, course, password and optional admission document fields. CSS provides a responsive layout, focus states and error styling. JavaScript validates required fields, email format, password strength and file type/size. The front-end demo does not persist registration data.

## Question 2 — PHP, MySQL CRUD and file handling (16 marks)
The PHP application implements Add, View, Edit and Delete operations using PDO prepared statements. Student details are stored in `students`; uploaded-file metadata is stored in `student_files` and linked by a foreign key. Uploads are limited to PDF/JPG/PNG, capped at 5 MB per file, MIME-checked, and renamed to avoid overwriting.

## Question 3 — Servlet, JDBC and JSP (16 marks)
The Java web application uses JDBC prepared statements to retrieve student records and file metadata. JSP renders student profiles. The file servlet streams stored files, and session filtering protects selected endpoints. The sample login is for classroom demonstration only and should be replaced with stronger authentication before real deployment.

## Database
Import `database/schema.sql`. It creates `student_portal`, `students`, `student_files`, and an optional `users` table.

## Testing checklist
- [ ] Invalid registration fields show errors.
- [ ] Add, edit, view and delete student records.
- [ ] Upload a valid image/PDF and check preview/download.
- [ ] Reject unsupported files and oversized uploads.
- [ ] Test Servlet login, protected pages and logout.
- [ ] Add genuine screenshots after testing locally.

## Conclusion
This assignment demonstrates front-end validation using HTML, CSS and JavaScript, database-backed student record management with PHP and MySQL, and dynamic profile rendering using Java Servlets, JSP and JDBC. Prepared statements and server-side upload validation help reduce common input and file-handling risks. Complete local testing and add screenshots before submission.
