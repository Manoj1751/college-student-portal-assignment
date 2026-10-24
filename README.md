# College Student Portal — Web Technology Assignment II

This project is organized into three parts matching the assignment:
- `frontend/` — HTML5, CSS3, JavaScript registration form and client-side validation.
- `php-crud/` — PHP + MySQL CRUD, secure uploads, file metadata, and student profile view.
- `servlet-portal/` — Java Servlet + JSP + JDBC portal with login/session handling and streamed files.
- `database/schema.sql` — shared MySQL schema.

## Requirements
- PHP 8+ and MySQL/MariaDB for `php-crud`.
- JDK 11+ and Apache Tomcat 9 for `servlet-portal` (`javax.servlet`).
- MySQL Connector/J for the servlet project.
- Configure credentials in `php-crud/config.php` and `servlet-portal/src/main/java/com/college/DB.java`.

## Run the frontend
Open `frontend/index.html` in a browser or VS Code Live Server.

## Run PHP + MySQL
1. Copy `php-crud/` to `htdocs/student-portal-php/`.
2. Import `database/schema.sql` using phpMyAdmin.
3. Check the credentials in `php-crud/config.php`.
4. Ensure `php-crud/uploads/` is writable.
5. Open `http://localhost/student-portal-php/`.

## Run Servlet/JSP
1. Use JDK 11+ and Tomcat 9.
2. Configure MySQL credentials in `DB.java` and the upload directory in `WEB-INF/web.xml`.
3. Add MySQL Connector/J to the classpath.
4. Import `database/schema.sql` and deploy the web app to Tomcat.
5. Demo login: `admin` / `ChangeMe123!` (classroom demonstration only; change before real use).

## Security and testing
Uploads use extension/MIME checks, size limits, randomized filenames, and prepared statements where applicable. This is an educational sample, not production-ready authentication. Test all CRUD and upload flows locally and take genuine screenshots for your report.