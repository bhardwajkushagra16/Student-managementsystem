📘 Student Management System (Java Swing)

A modern, GUI-based Student Management System (SMS) built using Java Swing, featuring an Admin Dashboard, Student Dashboard, database-like file storage, and reusable UI components.
This project demonstrates core Java concepts, OOP, event-driven programming, UI/UX in Swing, and basic data persistence.

🚀 Features
👨‍💼 Admin Dashboard

Add new students

Update student details

Remove students

View full student list

Search students by name, email, or department

Manage course & department details

Clean, modern GUI with gradient panels and styled buttons

🎓 Student Dashboard

Students can log in

View personal profile

View enrolled course details

Check semester & GPA

Minimal, easy-to-use interface

🗂 Database Manager

Uses file-based storage (serialization) to store student data

Automatically loads/saves students list

Ensures no data loss when the application closes

🎨 Advanced UI Components

GradientPanel.java → Custom gradient background

ModernButton.java → Hover-enabled buttons with animations

System-style Look & Feel

📦 Core Classes

Student.java → Student model class

Course.java → Course details model

DatabaseManager.java → Data persistence

LoginFrame.java → Login page

AdminDashboard.java

StudentDashboard.java

StudentManagementSystem.java → Main entry point

📁 Project Structure
/Guvi/KushagrGuvi/
│
└── new/
    ├── StudentManagementSystem.java
    ├── AdminDashboard.class
    ├── StudentDashboard.class
    ├── LoginFrame.class
    ├── DatabaseManager.class
    ├── Student.class
    ├── Course.class
    ├── GradientPanel.class
    ├── ModernButton.class

🔧 Technologies Used
Component	Technology
Programming Language	Java (JDK 8+)
Framework	Java Swing
Build Type	Standalone Desktop Application
Data Storage	Serialized file handling (custom DatabaseManager)
▶️ How to Run
1. Compile the Source Code
javac *.java

2. Run the Application
java StudentManagementSystem

3. Requirements

JDK 8 or above

Any Java-supported OS (Windows, Linux, MacOS)

📚 How Data is Stored

The system uses a custom DatabaseManager class

Student data is stored as serialized objects (like a mini-database)

On startup → Data loads

On shutdown → Data is saved automatically

This ensures zero dependency, maximum portability, and easy deployment.

🏗 Architecture Overview
MVC-inspired structure

Model → Student, Course

View → Swing components, dashboards

Controller → Event listeners in Dashboards & LoginFrame

Persistence → DatabaseManager

This separation makes the project easier to extend.

🧩 Future Improvements (Optional for GitHub)

Replace file storage with MySQL / SQLite

Add course enrollment system

Add attendance management

Add PDF export for student reports

Implement Admin roles & permissions

Use JavaFX for modern UI

🤝 Contributing

Pull requests are welcome!
Feel free to propose enhancements or file issues.

📜 License

This project is open-source.
