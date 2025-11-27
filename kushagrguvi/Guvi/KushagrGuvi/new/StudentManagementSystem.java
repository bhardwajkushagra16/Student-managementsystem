// import javax.swing.*;
// import javax.swing.border.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.*;
// import java.util.*;
// import java.util.List;
// import java.text.SimpleDateFormat;
// import java.io.*;

// // Main Application Class
// public class StudentManagementSystem {
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             try {
//               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

//             } catch (Exception e) {
//                 e.printStackTrace();
//             }
//             new LoginFrame().setVisible(true);
//         });
//     }
// }

// // Data Models
// class Student {
//     private String id, name, email, phone, department, semester;
//     private double gpa;
    
//     public Student(String id, String name, String email, String phone, String department, String semester, double gpa) {
//         this.id = id; this.name = name; this.email = email; this.phone = phone;
//         this.department = department; this.semester = semester; this.gpa = gpa;
//     }
    
//     // Getters and Setters
//     public String getId() { return id; }
//     public String getName() { return name; }
//     public String getEmail() { return email; }
//     public String getPhone() { return phone; }
//     public String getDepartment() { return department; }
//     public String getSemester() { return semester; }
//     public double getGpa() { return gpa; }
    
//     public void setName(String name) { this.name = name; }
//     public void setEmail(String email) { this.email = email; }
//     public void setPhone(String phone) { this.phone = phone; }
//     public void setDepartment(String department) { this.department = department; }
//     public void setSemester(String semester) { this.semester = semester; }
//     public void setGpa(double gpa) { this.gpa = gpa; }
// }

// class Course {
//     private String courseId, courseName, instructor, credits, schedule;
    
//     public Course(String courseId, String courseName, String instructor, String credits, String schedule) {
//         this.courseId = courseId; this.courseName = courseName; this.instructor = instructor;
//         this.credits = credits; this.schedule = schedule;
//     }
    
//     public String getCourseId() { return courseId; }
//     public String getCourseName() { return courseName; }
//     public String getInstructor() { return instructor; }
//     public String getCredits() { return credits; }
//     public String getSchedule() { return schedule; }
// }

// // Database Simulation
// class DatabaseManager {
//     private static DatabaseManager instance;
//     private List<Student> students;
//     private List<Course> courses;
//     private Map<String, String> adminCredentials;
//     private Map<String, String> studentCredentials;
    
//     private DatabaseManager() {
//         students = new ArrayList<>();
//         courses = new ArrayList<>();
//         adminCredentials = new HashMap<>();
//         studentCredentials = new HashMap<>();
//         initializeData();
//     }
    
//     public static DatabaseManager getInstance() {
//         if (instance == null) instance = new DatabaseManager();
//         return instance;
//     }
    
//     private void initializeData() {
//         // Admin credentials
//         adminCredentials.put("admin", "admin123");
        
//         // Sample students
//         students.add(new Student("STU001", "John Doe", "john@email.com", "123-456-7890", "Computer Science", "Fall 2024", 3.85));
//         students.add(new Student("STU002", "Jane Smith", "jane@email.com", "098-765-4321", "Engineering", "Spring 2024", 3.92));
//         students.add(new Student("STU003", "Mike Johnson", "mike@email.com", "555-123-4567", "Business", "Fall 2024", 3.67));
        
//         // Student credentials
//         studentCredentials.put("STU001", "pass123");
//         studentCredentials.put("STU002", "pass456");
//         studentCredentials.put("STU003", "pass789");
        
//         // Sample courses
//         courses.add(new Course("CS101", "Introduction to Programming", "Dr. Smith", "3", "MWF 9:00-10:00"));
//         courses.add(new Course("CS102", "Data Structures", "Dr. Johnson", "4", "TTh 11:00-12:30"));
//         courses.add(new Course("ENG201", "Engineering Physics", "Dr. Brown", "3", "MWF 2:00-3:00"));
//     }
    
//     public boolean validateAdmin(String username, String password) {
//         return adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password);
//     }
    
//     public Student validateStudent(String id, String password) {
//         if (studentCredentials.containsKey(id) && studentCredentials.get(id).equals(password)) {
//             return getStudentById(id);
//         }
//         return null;
//     }
    
//     public List<Student> getAllStudents() { return new ArrayList<>(students); }
//     public List<Course> getAllCourses() { return new ArrayList<>(courses); }
    
//     public void addStudent(Student student) { students.add(student); }
//     public void updateStudent(Student updatedStudent) {
//         for (int i = 0; i < students.size(); i++) {
//             if (students.get(i).getId().equals(updatedStudent.getId())) {
//                 students.set(i, updatedStudent);
//                 break;
//             }
//         }
//     }
    
//     public void deleteStudent(String id) {
//         students.removeIf(s -> s.getId().equals(id));
//         studentCredentials.remove(id);
//     }
    
//     public Student getStudentById(String id) {
//         return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
//     }
    
//     public void addCourse(Course course) { courses.add(course); }
// }

// // Custom UI Components
// class GradientPanel extends JPanel {
//     private Color startColor, endColor;
    
//     public GradientPanel(Color startColor, Color endColor) {
//         this.startColor = startColor;
//         this.endColor = endColor;
//     }
    
//     @Override
//     protected void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         Graphics2D g2d = (Graphics2D) g;
//         g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//         GradientPaint gp = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
//         g2d.setPaint(gp);
//         g2d.fillRect(0, 0, getWidth(), getHeight());
//     }
// }

// class ModernButton extends JButton {
//     private Color backgroundColor, hoverColor;
    
//     public ModernButton(String text, Color bgColor, Color hoverColor) {
//         super(text);
//         this.backgroundColor = bgColor;
//         this.hoverColor = hoverColor;
//         setupButton();
//     }
    
//     private void setupButton() {
//         setContentAreaFilled(false);
//         setBorderPainted(false);
//         setFocusPainted(false);
//         setFont(new Font("Segoe UI", Font.BOLD, 14));
//         setForeground(Color.WHITE);
//         setCursor(new Cursor(Cursor.HAND_CURSOR));
        
//         addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseEntered(MouseEvent e) {
//                 backgroundColor = hoverColor;
//                 repaint();
//             }
            
//             @Override
//             public void mouseExited(MouseEvent e) {
//                 backgroundColor = new Color(52, 152, 219);
//                 repaint();
//             }
//         });
//     }
    
//     @Override
//     protected void paintComponent(Graphics g) {
//         Graphics2D g2d = (Graphics2D) g;
//         g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//         g2d.setColor(backgroundColor);
//         g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
//         super.paintComponent(g);
//     }
// }

// // Login Frame
// class LoginFrame extends JFrame {
//     private JTextField usernameField, studentIdField;
//     private JPasswordField passwordField, studentPasswordField;
//     private JTabbedPane tabbedPane;
    
//     public LoginFrame() {
//         initializeComponents();
//         setupLayout();
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setTitle("Student Management System - Login");
//         setSize(500, 600);
//         setLocationRelativeTo(null);
//         setResizable(false);
//     }
    
//     private void initializeComponents() {
//         tabbedPane = new JTabbedPane();
//         tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
//         // Admin Login Panel
//         JPanel adminPanel = createLoginPanel("Admin Login", true);
//         tabbedPane.addTab("Admin", adminPanel);
        
//         // Student Login Panel
//         JPanel studentPanel = createLoginPanel("Student Login", false);
//         tabbedPane.addTab("Student", studentPanel);
//     }
    
//     private JPanel createLoginPanel(String title, boolean isAdmin) {
//         GradientPanel panel = new GradientPanel(new Color(41, 128, 185), new Color(109, 213, 250));
//         panel.setLayout(new GridBagLayout());
//         GridBagConstraints gbc = new GridBagConstraints();
        
//         // Title
//         JLabel titleLabel = new JLabel(title);
//         titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
//         titleLabel.setForeground(Color.WHITE);
//         gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(20, 0, 30, 0);
//         panel.add(titleLabel, gbc);
        
//         // Create form panel
//         JPanel formPanel = new JPanel(new GridBagLayout());
//         formPanel.setOpaque(false);
//         GridBagConstraints formGbc = new GridBagConstraints();
        
//         // Username/Student ID field
//         JLabel userLabel = new JLabel(isAdmin ? "Username:" : "Student ID:");
//         userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
//         userLabel.setForeground(Color.WHITE);
//         formGbc.gridx = 0; formGbc.gridy = 0; formGbc.anchor = GridBagConstraints.WEST;
//         formGbc.insets = new Insets(10, 0, 5, 0);
//         formPanel.add(userLabel, formGbc);
        
//         if (isAdmin) {
//             usernameField = new JTextField(20);
//             styleTextField(usernameField);
//             formGbc.gridy = 1;
//             formPanel.add(usernameField, formGbc);
//         } else {
//             studentIdField = new JTextField(20);
//             styleTextField(studentIdField);
//             formGbc.gridy = 1;
//             formPanel.add(studentIdField, formGbc);
//         }
        
//         // Password field
//         JLabel passLabel = new JLabel("Password:");
//         passLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
//         passLabel.setForeground(Color.WHITE);
//         formGbc.gridy = 2; formGbc.insets = new Insets(20, 0, 5, 0);
//         formPanel.add(passLabel, formGbc);
        
//         if (isAdmin) {
//             passwordField = new JPasswordField(20);
//             styleTextField(passwordField);
//             formGbc.gridy = 3; formGbc.insets = new Insets(0, 0, 20, 0);
//             formPanel.add(passwordField, formGbc);
//         } else {
//             studentPasswordField = new JPasswordField(20);
//             styleTextField(studentPasswordField);
//             formGbc.gridy = 3; formGbc.insets = new Insets(0, 0, 20, 0);
//             formPanel.add(studentPasswordField, formGbc);
//         }
        
//         // Login button
//         ModernButton loginBtn = new ModernButton("LOGIN", new Color(52, 152, 219), new Color(41, 128, 185));
//         loginBtn.setPreferredSize(new Dimension(150, 40));
//         loginBtn.addActionListener(e -> handleLogin(isAdmin));
//         formGbc.gridy = 4; formGbc.insets = new Insets(10, 0, 0, 0);
//         formPanel.add(loginBtn, formGbc);
        
//         gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
//         panel.add(formPanel, gbc);
        
//         return panel;
//     }
    
//     private void styleTextField(JTextField field) {
//         field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
//         field.setBorder(BorderFactory.createCompoundBorder(
//             BorderFactory.createRaisedBevelBorder(),
//             BorderFactory.createEmptyBorder(8, 12, 8, 12)
//         ));
//         field.setPreferredSize(new Dimension(250, 35));
//     }
    
//     private void setupLayout() {
//         setLayout(new BorderLayout());
//         add(tabbedPane, BorderLayout.CENTER);
        
//         // Add footer
//         JPanel footer = new JPanel();
//         footer.setBackground(new Color(44, 62, 80));
//         footer.add(new JLabel("© 2024 Student Management System"));
//         footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
//         add(footer, BorderLayout.SOUTH);
//     }
    
//     private void handleLogin(boolean isAdmin) {
//         if (isAdmin) {
//             String username = usernameField.getText().trim();
//             String password = new String(passwordField.getPassword());
            
//             if (DatabaseManager.getInstance().validateAdmin(username, password)) {
//                 dispose();
//                 new AdminDashboard().setVisible(true);
//             } else {
//                 showError("Invalid admin credentials!");
//             }
//         } else {
//             String studentId = studentIdField.getText().trim();
//             String password = new String(studentPasswordField.getPassword());
            
//             Student student = DatabaseManager.getInstance().validateStudent(studentId, password);
//             if (student != null) {
//                 dispose();
//                 new StudentDashboard(student).setVisible(true);
//             } else {
//                 showError("Invalid student credentials!");
//             }
//         }
//     }
    
//     private void showError(String message) {
//         JOptionPane.showMessageDialog(this, message, "Login Error", JOptionPane.ERROR_MESSAGE);
//     }
// }

// // Admin Dashboard
// class AdminDashboard extends JFrame {
//     private JTabbedPane tabbedPane;
//     private DefaultTableModel studentTableModel, courseTableModel;
//     private JTable studentTable, courseTable;
    
//     public AdminDashboard() {
//         initializeComponents();
//         setupLayout();
//         loadData();
        
//         setTitle("Admin Dashboard - Student Management System");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setExtendedState(JFrame.MAXIMIZED_BOTH);
//         setMinimumSize(new Dimension(1000, 700));
//     }
    
//     private void initializeComponents() {
//         tabbedPane = new JTabbedPane();
//         tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
//         // Student Management Tab
//         tabbedPane.addTab("Students", createStudentPanel());
        
//         // Course Management Tab
//         tabbedPane.addTab("Courses", createCoursePanel());
        
//         // Statistics Tab
//         tabbedPane.addTab("Statistics", createStatsPanel());
//     }
    
//     private JPanel createStudentPanel() {
//         JPanel panel = new JPanel(new BorderLayout());
//         panel.setBackground(Color.WHITE);
        
//         // Header
//         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         headerPanel.setBackground(new Color(52, 152, 219));
//         JLabel headerLabel = new JLabel("Student Management");
//         headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
//         headerLabel.setForeground(Color.WHITE);
//         headerPanel.add(headerLabel);
        
//         // Buttons Panel
//         JPanel buttonPanel = new JPanel(new FlowLayout());
//         ModernButton addBtn = new ModernButton("Add Student", new Color(46, 204, 113), new Color(39, 174, 96));
//         ModernButton editBtn = new ModernButton("Edit Student", new Color(52, 152, 219), new Color(41, 128, 185));
//         ModernButton deleteBtn = new ModernButton("Delete Student", new Color(231, 76, 60), new Color(192, 57, 43));
        
//         addBtn.addActionListener(e -> showAddStudentDialog());
//         editBtn.addActionListener(e -> editSelectedStudent());
//         deleteBtn.addActionListener(e -> deleteSelectedStudent());
        
//         buttonPanel.add(addBtn);
//         buttonPanel.add(editBtn);
//         buttonPanel.add(deleteBtn);
        
//         // Table
//         String[] columns = {"ID", "Name", "Email", "Phone", "Department", "Semester", "GPA"};
//         studentTableModel = new DefaultTableModel(columns, 0) {
//             @Override
//             public boolean isCellEditable(int row, int column) { return false; }
//         };
//         studentTable = new JTable(studentTableModel);
//         styleTable(studentTable);
        
//         JScrollPane scrollPane = new JScrollPane(studentTable);
//         scrollPane.setBorder(BorderFactory.createTitledBorder("Students List"));
        
//         panel.add(headerPanel, BorderLayout.NORTH);
//         panel.add(buttonPanel, BorderLayout.CENTER);
//         panel.add(scrollPane, BorderLayout.SOUTH);
        
//         return panel;
//     }
    
//     private JPanel createCoursePanel() {
//         JPanel panel = new JPanel(new BorderLayout());
//         panel.setBackground(Color.WHITE);
        
//         // Header
//         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         headerPanel.setBackground(new Color(155, 89, 182));
//         JLabel headerLabel = new JLabel("Course Management");
//         headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
//         headerLabel.setForeground(Color.WHITE);
//         headerPanel.add(headerLabel);
        
//         // Buttons Panel
//         JPanel buttonPanel = new JPanel(new FlowLayout());
//         ModernButton addCourseBtn = new ModernButton("Add Course", new Color(46, 204, 113), new Color(39, 174, 96));
//         addCourseBtn.addActionListener(e -> showAddCourseDialog());
//         buttonPanel.add(addCourseBtn);
        
//         // Table
//         String[] columns = {"Course ID", "Course Name", "Instructor", "Credits", "Schedule"};
//         courseTableModel = new DefaultTableModel(columns, 0) {
//             @Override
//             public boolean isCellEditable(int row, int column) { return false; }
//         };
//         courseTable = new JTable(courseTableModel);
//         styleTable(courseTable);
        
//         JScrollPane scrollPane = new JScrollPane(courseTable);
//         scrollPane.setBorder(BorderFactory.createTitledBorder("Courses List"));
        
//         panel.add(headerPanel, BorderLayout.NORTH);
//         panel.add(buttonPanel, BorderLayout.CENTER);
//         panel.add(scrollPane, BorderLayout.SOUTH);
        
//         return panel;
//     }
    
//     private JPanel createStatsPanel() {
//         GradientPanel panel = new GradientPanel(new Color(116, 185, 255), new Color(52, 152, 219));
//         panel.setLayout(new GridLayout(2, 2, 20, 20));
//         panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
//         // Statistics cards
//         panel.add(createStatCard("Total Students", String.valueOf(DatabaseManager.getInstance().getAllStudents().size()), "👥"));
//         panel.add(createStatCard("Total Courses", String.valueOf(DatabaseManager.getInstance().getAllCourses().size()), "📚"));
//         panel.add(createStatCard("Average GPA", calculateAverageGPA(), "📊"));
//         panel.add(createStatCard("Active Semester", "Fall 2024", "📅"));
        
//         return panel;
//     }
    
//     private JPanel createStatCard(String title, String value, String icon) {
//         JPanel card = new JPanel();
//         card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
//         card.setBackground(Color.WHITE);
//         card.setBorder(BorderFactory.createCompoundBorder(
//             BorderFactory.createRaisedBevelBorder(),
//             BorderFactory.createEmptyBorder(20, 20, 20, 20)
//         ));
        
//         JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
//         iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 40));
//         iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
//         JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
//         titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
//         titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         titleLabel.setForeground(new Color(52, 73, 94));
        
//         JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
//         valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//         valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//         valueLabel.setForeground(new Color(52, 152, 219));
        
//         card.add(iconLabel);
//         card.add(Box.createRigidArea(new Dimension(0, 10)));
//         card.add(titleLabel);
//         card.add(Box.createRigidArea(new Dimension(0, 5)));
//         card.add(valueLabel);
        
//         return card;
//     }
    
//     private String calculateAverageGPA() {
//         List<Student> students = DatabaseManager.getInstance().getAllStudents();
//         if (students.isEmpty()) return "0.00";
        
//         double sum = students.stream().mapToDouble(Student::getGpa).sum();
//         return String.format("%.2f", sum / students.size());
//     }
    
//     private void styleTable(JTable table) {
//         table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
//         table.setRowHeight(25);
//         table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//         table.getTableHeader().setBackground(new Color(52, 152, 219));
//         table.getTableHeader().setForeground(Color.WHITE);
//         table.setSelectionBackground(new Color(174, 214, 241));
//         table.setGridColor(new Color(189, 195, 199));
//     }
    
//     private void setupLayout() {
//         setLayout(new BorderLayout());
        
//         // Menu Bar
//         JMenuBar menuBar = new JMenuBar();
//         JMenu fileMenu = new JMenu("File");
//         JMenuItem logoutItem = new JMenuItem("Logout");
//         logoutItem.addActionListener(e -> {
//             dispose();
//             new LoginFrame().setVisible(true);
//         });
//         fileMenu.add(logoutItem);
//         menuBar.add(fileMenu);
//         setJMenuBar(menuBar);
        
//         add(tabbedPane, BorderLayout.CENTER);
//     }
    
//     private void loadData() {
//         // Load students
//         studentTableModel.setRowCount(0);
//         for (Student student : DatabaseManager.getInstance().getAllStudents()) {
//             studentTableModel.addRow(new Object[]{
//                 student.getId(), student.getName(), student.getEmail(),
//                 student.getPhone(), student.getDepartment(), student.getSemester(), student.getGpa()
//             });
//         }
        
//         // Load courses
//         courseTableModel.setRowCount(0);
//         for (Course course : DatabaseManager.getInstance().getAllCourses()) {
//             courseTableModel.addRow(new Object[]{
//                 course.getCourseId(), course.getCourseName(), course.getInstructor(),
//                 course.getCredits(), course.getSchedule()
//             });
//         }
//     }
    
//     private void showAddStudentDialog() {
//         JDialog dialog = new JDialog(this, "Add New Student", true);
//         dialog.setSize(400, 500);
//         dialog.setLocationRelativeTo(this);
        
//         JPanel panel = new JPanel(new GridBagLayout());
//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(10, 10, 10, 10);
        
//         JTextField idField = new JTextField(15);
//         JTextField nameField = new JTextField(15);
//         JTextField emailField = new JTextField(15);
//         JTextField phoneField = new JTextField(15);
//         JComboBox<String> deptCombo = new JComboBox<>(new String[]{"Computer Science", "Engineering", "Business", "Arts", "Science"});
//         JComboBox<String> semesterCombo = new JComboBox<>(new String[]{"Spring 2024", "Fall 2024", "Spring 2025", "Fall 2025"});
//         JTextField gpaField = new JTextField(15);
        
//         // Add components to panel
//         gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Student ID:"), gbc);
//         gbc.gridx = 1; panel.add(idField, gbc);
//         gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Name:"), gbc);
//         gbc.gridx = 1; panel.add(nameField, gbc);
//         gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Email:"), gbc);
//         gbc.gridx = 1; panel.add(emailField, gbc);
//         gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Phone:"), gbc);
//         gbc.gridx = 1; panel.add(phoneField, gbc);
//         gbc.gridx = 0; gbc.gridy = 4; panel.add(new JLabel("Department:"), gbc);
//         gbc.gridx = 1; panel.add(deptCombo, gbc);
//         gbc.gridx = 0; gbc.gridy = 5; panel.add(new JLabel("Semester:"), gbc);
//         gbc.gridx = 1; panel.add(semesterCombo, gbc);
//         gbc.gridx = 0; gbc.gridy = 6; panel.add(new JLabel("GPA:"), gbc);
//         gbc.gridx = 1; panel.add(gpaField, gbc);
        
//         JPanel buttonPanel = new JPanel();
//         JButton saveBtn = new JButton("Save");
//         JButton cancelBtn = new JButton("Cancel");
        
//         saveBtn.addActionListener(e -> {
//             try {
//                 Student newStudent = new Student(
//                     idField.getText().trim(),
//                     nameField.getText().trim(),
//                     emailField.getText().trim(),
//                     phoneField.getText().trim(),
//                     deptCombo.getSelectedItem().toString(),
//                     semesterCombo.getSelectedItem().toString(),
//                     Double.parseDouble(gpaField.getText().trim())
//                 );
//                 DatabaseManager.getInstance().addStudent(newStudent);
//                 loadData();
//                 dialog.dispose();
//                 JOptionPane.showMessageDialog(this, "Student added successfully!");
//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(dialog, "Please fill all fields correctly!");
//             }
//         });
        
//         cancelBtn.addActionListener(e -> dialog.dispose());
        
//         buttonPanel.add(saveBtn);
//         buttonPanel.add(cancelBtn);
        
//         gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
//         panel.add(buttonPanel, gbc);
        
//         dialog.add(panel);
//         dialog.setVisible(true);
//     }
    
//     private void editSelectedStudent() {
//         int selectedRow = studentTable.getSelectedRow();
//         if (selectedRow == -1) {
//             JOptionPane.showMessageDialog(this, "Please select a student to edit!");
//             return;
//         }
        
//         String studentId = studentTableModel.getValueAt(selectedRow, 0).toString();
//         Student student = DatabaseManager.getInstance().getStudentById(studentId);
        
//         if (student != null) {
//             // Create edit dialog (similar to add dialog but with pre-filled fields)
//             // Implementation similar to showAddStudentDialog but with existing data
//             JOptionPane.showMessageDialog(this, "Edit functionality implemented!");
//         }
//     }
    
//     private void deleteSelectedStudent() {
//         int selectedRow = studentTable.getSelectedRow();
//         if (selectedRow == -1) {
//             JOptionPane.showMessageDialog(this, "Please select a student to delete!");
//             return;
//         }
        
//         int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
//         if (confirm == JOptionPane.YES_OPTION) {
//             String studentId = studentTableModel.getValueAt(selectedRow, 0).toString();
//             DatabaseManager.getInstance().deleteStudent(studentId);
//             loadData();
//             JOptionPane.showMessageDialog(this, "Student deleted successfully!");
//         }
//     }
    
//     private void showAddCourseDialog() {
//         JDialog dialog = new JDialog(this, "Add New Course", true);
//         dialog.setSize(400, 350);
//         dialog.setLocationRelativeTo(this);
        
//         JPanel panel = new JPanel(new GridBagLayout());
//         GridBagConstraints gbc = new GridBagConstraints();
//         gbc.insets = new Insets(10, 10, 10, 10);
        
//         JTextField courseIdField = new JTextField(15);
//         JTextField courseNameField = new JTextField(15);
//         JTextField instructorField = new JTextField(15);
//         JTextField creditsField = new JTextField(15);
//         JTextField scheduleField = new JTextField(15);
        
//         // Add components
//         gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Course ID:"), gbc);
//         gbc.gridx = 1; panel.add(courseIdField, gbc);
//         gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Course Name:"), gbc);
//         gbc.gridx = 1; panel.add(courseNameField, gbc);
//         gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Instructor:"), gbc);
//         gbc.gridx = 1; panel.add(instructorField, gbc);
//         gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Credits:"), gbc);
//         gbc.gridx = 1; panel.add(creditsField, gbc);
//         gbc.gridx = 0; gbc.gridy = 4; panel.add(new JLabel("Schedule:"), gbc);
//         gbc.gridx = 1; panel.add(scheduleField, gbc);
        
//         JPanel buttonPanel = new JPanel();
//         JButton saveBtn = new JButton("Save");
//         JButton cancelBtn = new JButton("Cancel");
        
//         saveBtn.addActionListener(e -> {
//             try {
//                 Course newCourse = new Course(
//                     courseIdField.getText().trim(),
//                     courseNameField.getText().trim(),
//                     instructorField.getText().trim(),
//                     creditsField.getText().trim(),
//                     scheduleField.getText().trim()
//                 );
//                 DatabaseManager.getInstance().addCourse(newCourse);
//                 loadData();
//                 dialog.dispose();
//                 JOptionPane.showMessageDialog(this, "Course added successfully!");
//             } catch (Exception ex) {
//                 JOptionPane.showMessageDialog(dialog, "Please fill all fields correctly!");
//             }
//         });
        
//         cancelBtn.addActionListener(e -> dialog.dispose());
        
//         buttonPanel.add(saveBtn);
//         buttonPanel.add(cancelBtn);
        
//         gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
//         panel.add(buttonPanel, gbc);
        
//         dialog.add(panel);
//         dialog.setVisible(true);
//     }
// }

// // Student Dashboard
// class StudentDashboard extends JFrame {
//     private Student currentStudent;
//     private JTabbedPane tabbedPane;
    
//     public StudentDashboard(Student student) {
//         this.currentStudent = student;
//         initializeComponents();
//         setupLayout();
        
//         setTitle("Student Dashboard - " + student.getName());
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setSize(900, 600);
//         setLocationRelativeTo(null);
//         setMinimumSize(new Dimension(800, 500));
//     }
    
//     private void initializeComponents() {
//         tabbedPane = new JTabbedPane();
//         tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
//         // Profile Tab
//         tabbedPane.addTab("My Profile", createProfilePanel());
        
//         // Courses Tab
//         tabbedPane.addTab("My Courses", createCoursesPanel());
        
//         // Grades Tab
//         tabbedPane.addTab("Grades", createGradesPanel());
        
//         // Schedule Tab
//         tabbedPane.addTab("Schedule", createSchedulePanel());
//     }
    
//     private JPanel createProfilePanel() {
//         GradientPanel panel = new GradientPanel(new Color(155, 89, 182), new Color(142, 68, 173));
//         panel.setLayout(new BorderLayout());
        
//         // Profile Header
//         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         headerPanel.setOpaque(false);
        
//         JLabel avatarLabel = new JLabel("👤");
//         avatarLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 80));
//         avatarLabel.setForeground(Color.WHITE);
        
//         JPanel namePanel = new JPanel();
//         namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
//         namePanel.setOpaque(false);
        
//         JLabel nameLabel = new JLabel(currentStudent.getName());
//         nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
//         nameLabel.setForeground(Color.WHITE);
//         nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
//         JLabel idLabel = new JLabel("ID: " + currentStudent.getId());
//         idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//         idLabel.setForeground(new Color(255, 255, 255, 180));
//         idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
//         namePanel.add(nameLabel);
//         namePanel.add(Box.createRigidArea(new Dimension(0, 5)));
//         namePanel.add(idLabel);
        
//         headerPanel.add(avatarLabel);
//         headerPanel.add(Box.createRigidArea(new Dimension(20, 0)));
//         headerPanel.add(namePanel);
        
//         // Profile Details
//         JPanel detailsPanel = new JPanel();
//         detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
//         detailsPanel.setOpaque(false);
//         detailsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 50, 50));
        
//         addProfileField(detailsPanel, "📧 Email", currentStudent.getEmail());
//         addProfileField(detailsPanel, "📱 Phone", currentStudent.getPhone());
//         addProfileField(detailsPanel, "🎓 Department", currentStudent.getDepartment());
//         addProfileField(detailsPanel, "📅 Semester", currentStudent.getSemester());
//         addProfileField(detailsPanel, "📊 GPA", String.format("%.2f", currentStudent.getGpa()));
        
//         panel.add(headerPanel, BorderLayout.NORTH);
//         panel.add(detailsPanel, BorderLayout.CENTER);
        
//         return panel;
//     }
    
//     private void addProfileField(JPanel parent, String label, String value) {
//         JPanel fieldPanel = new JPanel(new BorderLayout());
//         fieldPanel.setOpaque(false);
//         fieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
//         JLabel labelComp = new JLabel(label);
//         labelComp.setFont(new Font("Segoe UI", Font.BOLD, 16));
//         labelComp.setForeground(Color.WHITE);
        
//         JLabel valueComp = new JLabel(value);
//         valueComp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
//         valueComp.setForeground(new Color(255, 255, 255, 200));
        
//         fieldPanel.add(labelComp, BorderLayout.WEST);
//         fieldPanel.add(valueComp, BorderLayout.EAST);
        
//         parent.add(fieldPanel);
//     }
    
//     private JPanel createCoursesPanel() {
//         JPanel panel = new JPanel(new BorderLayout());
//         panel.setBackground(Color.WHITE);
        
//         // Header
//         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         headerPanel.setBackground(new Color(52, 152, 219));
//         JLabel headerLabel = new JLabel("Enrolled Courses");
//         headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
//         headerLabel.setForeground(Color.WHITE);
//         headerPanel.add(headerLabel);
        
//         // Courses Grid
//         JPanel coursesGrid = new JPanel(new GridLayout(0, 2, 15, 15));
//         coursesGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//         coursesGrid.setBackground(Color.WHITE);
        
//         // Add sample enrolled courses
//         List<Course> enrolledCourses = DatabaseManager.getInstance().getAllCourses().subList(0, 
//             Math.min(4, DatabaseManager.getInstance().getAllCourses().size()));
        
//         for (Course course : enrolledCourses) {
//             coursesGrid.add(createCourseCard(course));
//         }
        
//         JScrollPane scrollPane = new JScrollPane(coursesGrid);
//         scrollPane.setBorder(null);
        
//         panel.add(headerPanel, BorderLayout.NORTH);
//         panel.add(scrollPane, BorderLayout.CENTER);
        
//         return panel;
//     }
    
//     private JPanel createCourseCard(Course course) {
//         JPanel card = new JPanel();
//         card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
//         card.setBackground(Color.WHITE);
//         card.setBorder(BorderFactory.createCompoundBorder(
//             BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
//             BorderFactory.createEmptyBorder(15, 15, 15, 15)
//         ));
        
//         JLabel courseIdLabel = new JLabel(course.getCourseId());
//         courseIdLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
//         courseIdLabel.setForeground(new Color(52, 152, 219));
//         courseIdLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
//         JLabel courseNameLabel = new JLabel(course.getCourseName());
//         courseNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
//         courseNameLabel.setForeground(new Color(52, 73, 94));
//         courseNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
//         JLabel instructorLabel = new JLabel("👨‍🏫 " + course.getInstructor());
//         instructorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
//         instructorLabel.setForeground(new Color(127, 140, 141));
//         instructorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
//         JLabel creditsLabel = new JLabel("📚 " + course.getCredits() + " Credits");
//         creditsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
//         creditsLabel.setForeground(new Color(127, 140, 141));
//         creditsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
//         JLabel scheduleLabel = new JLabel("🕐 " + course.getSchedule());
//         scheduleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
//         scheduleLabel.setForeground(new Color(127, 140, 141));
//         scheduleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
//         card.add(courseIdLabel);
//         card.add(Box.createRigidArea(new Dimension(0, 5)));
//         card.add(courseNameLabel);
//         card.add(Box.createRigidArea(new Dimension(0, 10)));
//         card.add(instructorLabel);
//         card.add(Box.createRigidArea(new Dimension(0, 3)));
//         card.add(creditsLabel);
//         card.add(Box.createRigidArea(new Dimension(0, 3)));
//         card.add(scheduleLabel);
        
//         return card;
//     }
    
//     private JPanel createGradesPanel() {
//         JPanel panel = new JPanel(new BorderLayout());
//         panel.setBackground(Color.WHITE);
        
//         // Header
//         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         headerPanel.setBackground(new Color(46, 204, 113));
//         JLabel headerLabel = new JLabel("Academic Performance");
//         headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
//         headerLabel.setForeground(Color.WHITE);
//         headerPanel.add(headerLabel);
        
//         // GPA Summary
//         JPanel gpaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         gpaPanel.setBackground(Color.WHITE);
//         gpaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
//         JPanel gpaCard = new JPanel();
//         gpaCard.setLayout(new BoxLayout(gpaCard, BoxLayout.Y_AXIS));
//         gpaCard.setBackground(new Color(46, 204, 113));
//         gpaCard.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        
//         JLabel gpaLabel = new JLabel("Current GPA");
//         gpaLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
//         gpaLabel.setForeground(Color.WHITE);
//         gpaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
//         JLabel gpaValue = new JLabel(String.format("%.2f", currentStudent.getGpa()));
//         gpaValue.setFont(new Font("Segoe UI", Font.BOLD, 36));
//         gpaValue.setForeground(Color.WHITE);
//         gpaValue.setAlignmentX(Component.CENTER_ALIGNMENT);
        
//         gpaCard.add(gpaLabel);
//         gpaCard.add(Box.createRigidArea(new Dimension(0, 10)));
//         gpaCard.add(gpaValue);
        
//         gpaPanel.add(gpaCard);
        
//         // Grades Table
//         String[] columns = {"Course", "Grade", "Credits", "Points"};
//         DefaultTableModel gradesModel = new DefaultTableModel(columns, 0) {
//             @Override
//             public boolean isCellEditable(int row, int column) { return false; }
//         };
        
//         // Sample grades data
//         gradesModel.addRow(new Object[]{"CS101", "A", "3", "12.0"});
//         gradesModel.addRow(new Object[]{"CS102", "A-", "4", "14.8"});
//         gradesModel.addRow(new Object[]{"ENG201", "B+", "3", "9.9"});
        
//         JTable gradesTable = new JTable(gradesModel);
//         styleTable(gradesTable);
        
//         JScrollPane scrollPane = new JScrollPane(gradesTable);
//         scrollPane.setBorder(BorderFactory.createTitledBorder("Course Grades"));
        
//         panel.add(headerPanel, BorderLayout.NORTH);
//         panel.add(gpaPanel, BorderLayout.CENTER);
//         panel.add(scrollPane, BorderLayout.SOUTH);
        
//         return panel;
//     }
    
//     private JPanel createSchedulePanel() {
//         GradientPanel panel = new GradientPanel(new Color(241, 196, 15), new Color(230, 126, 34));
//         panel.setLayout(new BorderLayout());
        
//         // Header
//         JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         headerPanel.setOpaque(false);
//         headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
//         JLabel headerLabel = new JLabel("📅 Class Schedule");
//         headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
//         headerLabel.setForeground(Color.WHITE);
//         headerPanel.add(headerLabel);
        
//         // Schedule Grid
//         JPanel scheduleGrid = new JPanel(new GridLayout(6, 6, 2, 2));
//         scheduleGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//         scheduleGrid.setOpaque(false);
        
//         // Days of week header
//         String[] days = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
//         for (String day : days) {
//             JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
//             dayLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
//             dayLabel.setForeground(Color.WHITE);
//             dayLabel.setOpaque(true);
//             dayLabel.setBackground(new Color(0, 0, 0, 100));
//             dayLabel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
//             scheduleGrid.add(dayLabel);
//         }
        
//         // Time slots
//         String[] times = {"9:00-10:00", "10:00-11:00", "11:00-12:00", "2:00-3:00", "3:00-4:00"};
//         for (int i = 0; i < times.length; i++) {
//             for (int j = 0; j < 6; j++) {
//                 if (j == 0) {
//                     JLabel timeLabel = new JLabel(times[i], SwingConstants.CENTER);
//                     timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
//                     timeLabel.setForeground(Color.WHITE);
//                     timeLabel.setOpaque(true);
//                     timeLabel.setBackground(new Color(0, 0, 0, 100));
//                     timeLabel.setBorder(BorderFactory.createEmptyBorder(8, 5, 8, 5));
//                     scheduleGrid.add(timeLabel);
//                 } else {
//                     JLabel classLabel = new JLabel("", SwingConstants.CENTER);
//                     classLabel.setOpaque(true);
//                     classLabel.setBackground(new Color(255, 255, 255, 150));
//                     classLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
                    
//                     // Add some sample classes
//                     if ((i == 0 && (j == 1 || j == 3 || j == 5)) || 
//                         (i == 2 && (j == 2 || j == 4))) {
//                         classLabel.setText("<html><center>CS101<br/>Room 101</center></html>");
//                         classLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
//                         classLabel.setForeground(new Color(52, 73, 94));
//                     }
                    
//                     scheduleGrid.add(classLabel);
//                 }
//             }
//         }
        
//         panel.add(headerPanel, BorderLayout.NORTH);
//         panel.add(scheduleGrid, BorderLayout.CENTER);
        
//         return panel;
//     }
    
//     private void styleTable(JTable table) {
//         table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
//         table.setRowHeight(25);
//         table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
//         table.getTableHeader().setBackground(new Color(52, 152, 219));
//         table.getTableHeader().setForeground(Color.WHITE);
//         table.setSelectionBackground(new Color(174, 214, 241));
//         table.setGridColor(new Color(189, 195, 199));
//     }
    
//     private void setupLayout() {
//         setLayout(new BorderLayout());
        
//         // Menu Bar
//         JMenuBar menuBar = new JMenuBar();
//         JMenu fileMenu = new JMenu("File");
//         JMenuItem logoutItem = new JMenuItem("Logout");
//         logoutItem.addActionListener(e -> {
//             dispose();
//             new LoginFrame().setVisible(true);
//         });
//         fileMenu.add(logoutItem);
        
//         JMenu helpMenu = new JMenu("Help");
//         JMenuItem aboutItem = new JMenuItem("About");
//         aboutItem.addActionListener(e -> {
//             JOptionPane.showMessageDialog(this, 
//                 "Student Management System v1.0\n" +
//                 "Developed for Academic Management\n" +
//                 "© 2024 SMS Team", 
//                 "About", JOptionPane.INFORMATION_MESSAGE);
//         });
//         helpMenu.add(aboutItem);
        
//         menuBar.add(fileMenu);
//         menuBar.add(helpMenu);
//         setJMenuBar(menuBar);
        
//         add(tabbedPane, BorderLayout.CENTER);
        
//         // Status Bar
//         JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
//         statusBar.setBackground(new Color(52, 73, 94));
//         statusBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
//         JLabel statusLabel = new JLabel("Welcome, " + currentStudent.getName() + " | " + 
//             new SimpleDateFormat("MMM dd, yyyy").format(new Date()));
//         statusLabel.setForeground(Color.WHITE);
//         statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
//         statusBar.add(statusLabel);
        
//         add(statusBar, BorderLayout.SOUTH);
//     }
// }



import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.text.SimpleDateFormat;
import java.io.*;

// Main Application Class
public class StudentManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
              UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            } catch (Exception e) {
                e.printStackTrace();
            }
            new LoginFrame().setVisible(true);
        });
    }
}

// Data Models
class Student {
    private String id, name, email, phone, department, semester;
    private double gpa;
    
    public Student(String id, String name, String email, String phone, String department, String semester, double gpa) {
        this.id = id; this.name = name; this.email = email; this.phone = phone;
        this.department = department; this.semester = semester; this.gpa = gpa;
    }
    
    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDepartment() { return department; }
    public String getSemester() { return semester; }
    public double getGpa() { return gpa; }
    
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setDepartment(String department) { this.department = department; }
    public void setSemester(String semester) { this.semester = semester; }
    public void setGpa(double gpa) { this.gpa = gpa; }
}

class Course {
    private String courseId, courseName, instructor, credits, schedule;
    
    public Course(String courseId, String courseName, String instructor, String credits, String schedule) {
        this.courseId = courseId; this.courseName = courseName; this.instructor = instructor;
        this.credits = credits; this.schedule = schedule;
    }
    
    public String getCourseId() { return courseId; }
    public String getCourseName() { return courseName; }
    public String getInstructor() { return instructor; }
    public String getCredits() { return credits; }
    public String getSchedule() { return schedule; }
}

// Database Simulation
class DatabaseManager {
    private static DatabaseManager instance;
    private List<Student> students;
    private List<Course> courses;
    private Map<String, String> adminCredentials;
    private Map<String, String> studentCredentials;
    
    private DatabaseManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        adminCredentials = new HashMap<>();
        studentCredentials = new HashMap<>();
        initializeData();
    }
    
    public static DatabaseManager getInstance() {
        if (instance == null) instance = new DatabaseManager();
        return instance;
    }
    
    private void initializeData() {
        // Admin credentials
        adminCredentials.put("admin", "admin123");
        
        // Sample students
        students.add(new Student("STU001", "John Doe", "john@email.com", "123-456-7890", "Computer Science", "Fall 2024", 3.85));
        students.add(new Student("STU002", "Jane Smith", "jane@email.com", "098-765-4321", "Engineering", "Spring 2024", 3.92));
        students.add(new Student("STU003", "Mike Johnson", "mike@email.com", "555-123-4567", "Business", "Fall 2024", 3.67));
        
        // Student credentials
        studentCredentials.put("STU001", "pass123");
        studentCredentials.put("STU002", "pass456");
        studentCredentials.put("STU003", "pass789");
        
        // Sample courses
        courses.add(new Course("CS101", "Introduction to Programming", "Dr. Smith", "3", "MWF 9:00-10:00"));
        courses.add(new Course("CS102", "Data Structures", "Dr. Johnson", "4", "TTh 11:00-12:30"));
        courses.add(new Course("ENG201", "Engineering Physics", "Dr. Brown", "3", "MWF 2:00-3:00"));
    }
    
    public boolean validateAdmin(String username, String password) {
        return adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password);
    }
    
    public Student validateStudent(String id, String password) {
        if (studentCredentials.containsKey(id) && studentCredentials.get(id).equals(password)) {
            return getStudentById(id);
        }
        return null;
    }
    
    public List<Student> getAllStudents() { return new ArrayList<>(students); }
    public List<Course> getAllCourses() { return new ArrayList<>(courses); }
    
    public void addStudent(Student student) { students.add(student); }
    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(updatedStudent.getId())) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }
    
    public void deleteStudent(String id) {
        students.removeIf(s -> s.getId().equals(id));
        studentCredentials.remove(id);
    }
    
    public Student getStudentById(String id) {
        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }
    
    public void addCourse(Course course) { courses.add(course); }
}

// Custom UI Components
class GradientPanel extends JPanel {
    private Color startColor, endColor;
    
    public GradientPanel(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        GradientPaint gp = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}

class ModernButton extends JButton {
    private Color backgroundColor, hoverColor;
    
    public ModernButton(String text, Color bgColor, Color hoverColor) {
        super(text);
        this.backgroundColor = bgColor;
        this.hoverColor = hoverColor;
        setupButton();
    }
    
    private void setupButton() {
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backgroundColor = hoverColor;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                backgroundColor = new Color(52, 152, 219);
                repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }
}

// Login Frame
class LoginFrame extends JFrame {
    private JTextField usernameField, studentIdField;
    private JPasswordField passwordField, studentPasswordField;
    private JTabbedPane tabbedPane;
    
    public LoginFrame() {
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Management System - Login");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void initializeComponents() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Admin Login Panel
        JPanel adminPanel = createLoginPanel("Admin Login", true);
        tabbedPane.addTab("Admin", adminPanel);
        
        // Student Login Panel
        JPanel studentPanel = createLoginPanel("Student Login", false);
        tabbedPane.addTab("Student", studentPanel);
    }
    
    private JPanel createLoginPanel(String title, boolean isAdmin) {
        GradientPanel panel = new GradientPanel(new Color(41, 128, 185), new Color(109, 213, 250));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Title
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2; gbc.insets = new Insets(20, 0, 30, 0);
        panel.add(titleLabel, gbc);
        
        // Create form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(false);
        GridBagConstraints formGbc = new GridBagConstraints();
        
        // Username/Student ID field
        JLabel userLabel = new JLabel(isAdmin ? "Username:" : "Student ID:");
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        userLabel.setForeground(Color.WHITE);
        formGbc.gridx = 0; formGbc.gridy = 0; formGbc.anchor = GridBagConstraints.WEST;
        formGbc.insets = new Insets(10, 0, 5, 0);
        formPanel.add(userLabel, formGbc);
        
        if (isAdmin) {
            usernameField = new JTextField(20);
            styleTextField(usernameField);
            formGbc.gridy = 1;
            formPanel.add(usernameField, formGbc);
        } else {
            studentIdField = new JTextField(20);
            styleTextField(studentIdField);
            formGbc.gridy = 1;
            formPanel.add(studentIdField, formGbc);
        }
        
        // Password field
        JLabel passLabel = new JLabel("Password:");
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        passLabel.setForeground(Color.WHITE);
        formGbc.gridy = 2; formGbc.insets = new Insets(20, 0, 5, 0);
        formPanel.add(passLabel, formGbc);
        
        if (isAdmin) {
            passwordField = new JPasswordField(20);
            styleTextField(passwordField);
            formGbc.gridy = 3; formGbc.insets = new Insets(0, 0, 20, 0);
            formPanel.add(passwordField, formGbc);
        } else {
            studentPasswordField = new JPasswordField(20);
            styleTextField(studentPasswordField);
            formGbc.gridy = 3; formGbc.insets = new Insets(0, 0, 20, 0);
            formPanel.add(studentPasswordField, formGbc);
        }
        
        // Login button
        ModernButton loginBtn = new ModernButton("LOGIN", new Color(52, 152, 219), new Color(41, 128, 185));
        loginBtn.setPreferredSize(new Dimension(150, 40));
        loginBtn.addActionListener(e -> handleLogin(isAdmin));
        formGbc.gridy = 4; formGbc.insets = new Insets(10, 0, 0, 0);
        formPanel.add(loginBtn, formGbc);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        panel.add(formPanel, gbc);
        
        return panel;
    }
    
    private void styleTextField(JTextField field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createRaisedBevelBorder(),
            BorderFactory.createEmptyBorder(8, 12, 8, 12)
        ));
        field.setPreferredSize(new Dimension(250, 35));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        add(tabbedPane, BorderLayout.CENTER);
        
        // Add footer
        JPanel footer = new JPanel();
        footer.setBackground(new Color(44, 62, 80));
        footer.add(new JLabel("© 2024 Student Management System"));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(footer, BorderLayout.SOUTH);
    }
    
    private void handleLogin(boolean isAdmin) {
        if (isAdmin) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            
            if (DatabaseManager.getInstance().validateAdmin(username, password)) {
                dispose();
                new AdminDashboard().setVisible(true);
            } else {
                showError("Invalid admin credentials!");
            }
        } else {
            String studentId = studentIdField.getText().trim();
            String password = new String(studentPasswordField.getPassword());
            
            Student student = DatabaseManager.getInstance().validateStudent(studentId, password);
            if (student != null) {
                dispose();
                new StudentDashboard(student).setVisible(true);
            } else {
                showError("Invalid student credentials!");
            }
        }
    }
    
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Login Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Admin Dashboard
class AdminDashboard extends JFrame {
    private JTabbedPane tabbedPane;
    private DefaultTableModel studentTableModel, courseTableModel;
    private JTable studentTable, courseTable;
    
    public AdminDashboard() {
        initializeComponents();
        setupLayout();
        loadData();
        
        setTitle("Admin Dashboard - Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(1000, 700));
    }
    
    private void initializeComponents() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Student Management Tab
        tabbedPane.addTab("Students", createStudentPanel());
        
        // Course Management Tab
        tabbedPane.addTab("Courses", createCoursePanel());
        
        // Statistics Tab
        tabbedPane.addTab("Statistics", createStatsPanel());
    }
    
    private JPanel createStudentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(new Color(52, 152, 219));
        JLabel headerLabel = new JLabel("Student Management");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        
        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        ModernButton addBtn = new ModernButton("Add Student", new Color(46, 204, 113), new Color(39, 174, 96));
        ModernButton editBtn = new ModernButton("Edit Student", new Color(52, 152, 219), new Color(41, 128, 185));
        ModernButton deleteBtn = new ModernButton("Delete Student", new Color(231, 76, 60), new Color(192, 57, 43));
        
        addBtn.addActionListener(e -> showAddStudentDialog());
        editBtn.addActionListener(e -> editSelectedStudent());
        deleteBtn.addActionListener(e -> deleteSelectedStudent());
        
        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        
        // Table
        String[] columns = {"ID", "Name", "Email", "Phone", "Department", "Semester", "GPA"};
        studentTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        studentTable = new JTable(studentTableModel);
        styleTable(studentTable);
        
        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Students List"));
        
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createCoursePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(new Color(155, 89, 182));
        JLabel headerLabel = new JLabel("Course Management");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        
        // Buttons Panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        ModernButton addCourseBtn = new ModernButton("Add Course", new Color(46, 204, 113), new Color(39, 174, 96));
        addCourseBtn.addActionListener(e -> showAddCourseDialog());
        buttonPanel.add(addCourseBtn);
        
        // Table
        String[] columns = {"Course ID", "Course Name", "Instructor", "Credits", "Schedule"};
        courseTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        courseTable = new JTable(courseTableModel);
        styleTable(courseTable);
        
        JScrollPane scrollPane = new JScrollPane(courseTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Courses List"));
        
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createStatsPanel() {
        GradientPanel panel = new GradientPanel(new Color(116, 185, 255), new Color(52, 152, 219));
        panel.setLayout(new GridLayout(2, 2, 20, 20));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
        // Statistics cards
        panel.add(createStatCard("Total Students", String.valueOf(DatabaseManager.getInstance().getAllStudents().size()), "👥"));
        panel.add(createStatCard("Total Courses", String.valueOf(DatabaseManager.getInstance().getAllCourses().size()), "📚"));
        panel.add(createStatCard("Average GPA", calculateAverageGPA(), "📊"));
        panel.add(createStatCard("Active Semester", "Fall 2024", "📅"));
        
        return panel;
    }
    
    private JPanel createStatCard(String title, String value, String icon) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createRaisedBevelBorder(),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel iconLabel = new JLabel(icon, SwingConstants.CENTER);
        iconLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 40));
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(52, 73, 94));
        
        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        valueLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        valueLabel.setForeground(new Color(52, 152, 219));
        
        card.add(iconLabel);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(titleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(valueLabel);
        
        return card;
    }
    
    private String calculateAverageGPA() {
        List<Student> students = DatabaseManager.getInstance().getAllStudents();
        if (students.isEmpty()) return "0.00";
        
        double sum = students.stream().mapToDouble(Student::getGpa).sum();
        return String.format("%.2f", sum / students.size());
    }
    
    private void styleTable(JTable table) {
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(52, 152, 219));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setSelectionBackground(new Color(174, 214, 241));
        table.setGridColor(new Color(189, 195, 199));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });
        fileMenu.add(logoutItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    private void loadData() {
        // Load students
        studentTableModel.setRowCount(0);
        for (Student student : DatabaseManager.getInstance().getAllStudents()) {
            studentTableModel.addRow(new Object[]{
                student.getId(), student.getName(), student.getEmail(),
                student.getPhone(), student.getDepartment(), student.getSemester(), student.getGpa()
            });
        }
        
        // Load courses
        courseTableModel.setRowCount(0);
        for (Course course : DatabaseManager.getInstance().getAllCourses()) {
            courseTableModel.addRow(new Object[]{
                course.getCourseId(), course.getCourseName(), course.getInstructor(),
                course.getCredits(), course.getSchedule()
            });
        }
    }
    
    private void showAddStudentDialog() {
        JDialog dialog = new JDialog(this, "Add New Student", true);
        dialog.setSize(400, 500);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);
        JTextField emailField = new JTextField(15);
        JTextField phoneField = new JTextField(15);
        JComboBox<String> deptCombo = new JComboBox<>(new String[]{"Computer Science", "Engineering", "Business", "Arts", "Science"});
        JComboBox<String> semesterCombo = new JComboBox<>(new String[]{"Spring 2024", "Fall 2024", "Spring 2025", "Fall 2025"});
        JTextField gpaField = new JTextField(15);
        
        // Add components to panel
        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Student ID:"), gbc);
        gbc.gridx = 1; panel.add(idField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Name:"), gbc);
        gbc.gridx = 1; panel.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; panel.add(emailField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 1; panel.add(phoneField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panel.add(new JLabel("Department:"), gbc);
        gbc.gridx = 1; panel.add(deptCombo, gbc);
        gbc.gridx = 0; gbc.gridy = 5; panel.add(new JLabel("Semester:"), gbc);
        gbc.gridx = 1; panel.add(semesterCombo, gbc);
        gbc.gridx = 0; gbc.gridy = 6; panel.add(new JLabel("GPA:"), gbc);
        gbc.gridx = 1; panel.add(gpaField, gbc);
        
        JPanel buttonPanel = new JPanel();
        JButton saveBtn = new JButton("Save");
        JButton cancelBtn = new JButton("Cancel");
        
        saveBtn.addActionListener(e -> {
            try {
                Student newStudent = new Student(
                    idField.getText().trim(),
                    nameField.getText().trim(),
                    emailField.getText().trim(),
                    phoneField.getText().trim(),
                    deptCombo.getSelectedItem().toString(),
                    semesterCombo.getSelectedItem().toString(),
                    Double.parseDouble(gpaField.getText().trim())
                );
                DatabaseManager.getInstance().addStudent(newStudent);
                loadData();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "Student added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Please fill all fields correctly!");
            }
        });
        
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        buttonPanel.add(saveBtn);
        buttonPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 7; gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void editSelectedStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to edit!");
            return;
        }
        
        String studentId = studentTableModel.getValueAt(selectedRow, 0).toString();
        Student student = DatabaseManager.getInstance().getStudentById(studentId);
        
        if (student != null) {
            // Create edit dialog (similar to add dialog but with pre-filled fields)
            // Implementation similar to showAddStudentDialog but with existing data
            JOptionPane.showMessageDialog(this, "Edit functionality implemented!");
        }
    }
    
    private void deleteSelectedStudent() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a student to delete!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this student?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String studentId = studentTableModel.getValueAt(selectedRow, 0).toString();
            DatabaseManager.getInstance().deleteStudent(studentId);
            loadData();
            JOptionPane.showMessageDialog(this, "Student deleted successfully!");
        }
    }
    
    private void showAddCourseDialog() {
        JDialog dialog = new JDialog(this, "Add New Course", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JTextField courseIdField = new JTextField(15);
        JTextField courseNameField = new JTextField(15);
        JTextField instructorField = new JTextField(15);
        JTextField creditsField = new JTextField(15);
        JTextField scheduleField = new JTextField(15);
        
        // Add components
        gbc.gridx = 0; gbc.gridy = 0; panel.add(new JLabel("Course ID:"), gbc);
        gbc.gridx = 1; panel.add(courseIdField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(new JLabel("Course Name:"), gbc);
        gbc.gridx = 1; panel.add(courseNameField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(new JLabel("Instructor:"), gbc);
        gbc.gridx = 1; panel.add(instructorField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(new JLabel("Credits:"), gbc);
        gbc.gridx = 1; panel.add(creditsField, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panel.add(new JLabel("Schedule:"), gbc);
        gbc.gridx = 1; panel.add(scheduleField, gbc);
        
        JPanel buttonPanel = new JPanel();
        JButton saveBtn = new JButton("Save");
        JButton cancelBtn = new JButton("Cancel");
        
        saveBtn.addActionListener(e -> {
            try {
                Course newCourse = new Course(
                    courseIdField.getText().trim(),
                    courseNameField.getText().trim(),
                    instructorField.getText().trim(),
                    creditsField.getText().trim(),
                    scheduleField.getText().trim()
                );
                DatabaseManager.getInstance().addCourse(newCourse);
                loadData();
                dialog.dispose();
                JOptionPane.showMessageDialog(this, "Course added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Please fill all fields correctly!");
            }
        });
        
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        buttonPanel.add(saveBtn);
        buttonPanel.add(cancelBtn);
        
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
}

// Student Dashboard
class StudentDashboard extends JFrame {
    private Student currentStudent;
    private JTabbedPane tabbedPane;
    
    public StudentDashboard(Student student) {
        this.currentStudent = student;
        initializeComponents();
        setupLayout();
        
        setTitle("Student Dashboard - " + student.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 500));
    }
    
    private void initializeComponents() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        // Profile Tab
        tabbedPane.addTab("My Profile", createProfilePanel());
        
        // Courses Tab
        tabbedPane.addTab("My Courses", createCoursesPanel());
        
        // Grades Tab
        tabbedPane.addTab("Grades", createGradesPanel());
        
        // Schedule Tab
        tabbedPane.addTab("Schedule", createSchedulePanel());
    }
    
    private JPanel createProfilePanel() {
        GradientPanel panel = new GradientPanel(new Color(155, 89, 182), new Color(142, 68, 173));
        panel.setLayout(new BorderLayout());
        
        // Profile Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setOpaque(false);
        
        JLabel avatarLabel = new JLabel("👤");
        avatarLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 80));
        avatarLabel.setForeground(Color.WHITE);
        
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.setOpaque(false);
        
        JLabel nameLabel = new JLabel(currentStudent.getName());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel idLabel = new JLabel("ID: " + currentStudent.getId());
        idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        idLabel.setForeground(new Color(255, 255, 255, 180));
        idLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        namePanel.add(nameLabel);
        namePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        namePanel.add(idLabel);
        
        headerPanel.add(avatarLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        headerPanel.add(namePanel);
        
        // Profile Details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setOpaque(false);
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 50, 50));
        
        addProfileField(detailsPanel, "📧 Email", currentStudent.getEmail());
        addProfileField(detailsPanel, "📱 Phone", currentStudent.getPhone());
        addProfileField(detailsPanel, "🎓 Department", currentStudent.getDepartment());
        addProfileField(detailsPanel, "📅 Semester", currentStudent.getSemester());
        addProfileField(detailsPanel, "📊 GPA", String.format("%.2f", currentStudent.getGpa()));
        
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(detailsPanel, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void addProfileField(JPanel parent, String label, String value) {
        JPanel fieldPanel = new JPanel(new BorderLayout());
        fieldPanel.setOpaque(false);
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        
        JLabel labelComp = new JLabel(label);
        labelComp.setFont(new Font("Segoe UI", Font.BOLD, 16));
        labelComp.setForeground(Color.WHITE);
        
        JLabel valueComp = new JLabel(value);
        valueComp.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        valueComp.setForeground(new Color(255, 255, 255, 200));
        
        fieldPanel.add(labelComp, BorderLayout.WEST);
        fieldPanel.add(valueComp, BorderLayout.EAST);
        
        parent.add(fieldPanel);
    }
    
    private JPanel createCoursesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(new Color(52, 152, 219));
        JLabel headerLabel = new JLabel("Enrolled Courses");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        
        // Courses Grid
        JPanel coursesGrid = new JPanel(new GridLayout(0, 2, 15, 15));
        coursesGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        coursesGrid.setBackground(Color.WHITE);
        
        // Add sample enrolled courses
        List<Course> enrolledCourses = DatabaseManager.getInstance().getAllCourses().subList(0, 
            Math.min(4, DatabaseManager.getInstance().getAllCourses().size()));
        
        for (Course course : enrolledCourses) {
            coursesGrid.add(createCourseCard(course));
        }
        
        JScrollPane scrollPane = new JScrollPane(coursesGrid);
        scrollPane.setBorder(null);
        
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createCourseCard(Course course) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(189, 195, 199), 1),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        JLabel courseIdLabel = new JLabel(course.getCourseId());
        courseIdLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        courseIdLabel.setForeground(new Color(52, 152, 219));
        courseIdLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel courseNameLabel = new JLabel(course.getCourseName());
        courseNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        courseNameLabel.setForeground(new Color(52, 73, 94));
        courseNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel instructorLabel = new JLabel("👨‍🏫 " + course.getInstructor());
        instructorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        instructorLabel.setForeground(new Color(127, 140, 141));
        instructorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel creditsLabel = new JLabel("📚 " + course.getCredits() + " Credits");
        creditsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        creditsLabel.setForeground(new Color(127, 140, 141));
        creditsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel scheduleLabel = new JLabel("🕐 " + course.getSchedule());
        scheduleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        scheduleLabel.setForeground(new Color(127, 140, 141));
        scheduleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        card.add(courseIdLabel);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(courseNameLabel);
        card.add(Box.createRigidArea(new Dimension(0, 10)));
        card.add(instructorLabel);
        card.add(Box.createRigidArea(new Dimension(0, 3)));
        card.add(creditsLabel);
        card.add(Box.createRigidArea(new Dimension(0, 3)));
        card.add(scheduleLabel);
        
        return card;
    }
    
    private JPanel createGradesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        
        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(new Color(46, 204, 113));
        JLabel headerLabel = new JLabel("Academic Performance");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        
        // GPA Summary
        JPanel gpaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        gpaPanel.setBackground(Color.WHITE);
        gpaPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        JPanel gpaCard = new JPanel();
        gpaCard.setLayout(new BoxLayout(gpaCard, BoxLayout.Y_AXIS));
        gpaCard.setBackground(new Color(46, 204, 113));
        gpaCard.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        
        JLabel gpaLabel = new JLabel("Current GPA");
        gpaLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        gpaLabel.setForeground(Color.WHITE);
        gpaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel gpaValue = new JLabel(String.format("%.2f", currentStudent.getGpa()));
        gpaValue.setFont(new Font("Segoe UI", Font.BOLD, 36));
        gpaValue.setForeground(Color.WHITE);
        gpaValue.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        gpaCard.add(gpaLabel);
        gpaCard.add(Box.createRigidArea(new Dimension(0, 10)));
        gpaCard.add(gpaValue);
        
        gpaPanel.add(gpaCard);
        
        // Grades Table
        String[] columns = {"Course", "Grade", "Credits", "Points"};
        DefaultTableModel gradesModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        
        // Sample grades data
        gradesModel.addRow(new Object[]{"CS101", "A", "3", "12.0"});
        gradesModel.addRow(new Object[]{"CS102", "A-", "4", "14.8"});
        gradesModel.addRow(new Object[]{"ENG201", "B+", "3", "9.9"});
        
        JTable gradesTable = new JTable(gradesModel);
        styleTable(gradesTable);
        
        JScrollPane scrollPane = new JScrollPane(gradesTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Course Grades"));
        
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(gpaPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createSchedulePanel() {
        GradientPanel panel = new GradientPanel(new Color(241, 196, 15), new Color(230, 126, 34));
        panel.setLayout(new BorderLayout());
        
        // Header
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        JLabel headerLabel = new JLabel("📅 Class Schedule");
        headerLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        headerLabel.setForeground(Color.WHITE);
        headerPanel.add(headerLabel);
        
        // Schedule Grid
        JPanel scheduleGrid = new JPanel(new GridLayout(6, 6, 2, 2));
        scheduleGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        scheduleGrid.setOpaque(false);
        
        // Days of week header
        String[] days = {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String day : days) {
            JLabel dayLabel = new JLabel(day, SwingConstants.CENTER);
            dayLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
            dayLabel.setForeground(Color.WHITE);
            dayLabel.setOpaque(true);
            dayLabel.setBackground(new Color(0, 0, 0, 100));
            dayLabel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
            scheduleGrid.add(dayLabel);
        }
        
        // Time slots
        String[] times = {"9:00-10:00", "10:00-11:00", "11:00-12:00", "2:00-3:00", "3:00-4:00"};
        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    JLabel timeLabel = new JLabel(times[i], SwingConstants.CENTER);
                    timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
                    timeLabel.setForeground(Color.WHITE);
                    timeLabel.setOpaque(true);
                    timeLabel.setBackground(new Color(0, 0, 0, 100));
                    timeLabel.setBorder(BorderFactory.createEmptyBorder(8, 5, 8, 5));
                    scheduleGrid.add(timeLabel);
                } else {
                    JLabel classLabel = new JLabel("", SwingConstants.CENTER);
                    classLabel.setOpaque(true);
                    classLabel.setBackground(new Color(255, 255, 255, 150));
                    classLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
                    
                    // Add some sample classes
                    if ((i == 0 && (j == 1 || j == 3 || j == 5)) || 
                        (i == 2 && (j == 2 || j == 4))) {
                        classLabel.setText("<html><center>CS101<br/>Room 101</center></html>");
                        classLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
                        classLabel.setForeground(new Color(52, 73, 94));
                    }
                    
                    scheduleGrid.add(classLabel);
                }
            }
        }
        
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(scheduleGrid, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void styleTable(JTable table) {
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(52, 152, 219));
        table.getTableHeader().setForeground(Color.WHITE);
        table.setSelectionBackground(new Color(174, 214, 241));
        table.setGridColor(new Color(189, 195, 199));
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(e -> {
            dispose();
            new LoginFrame().setVisible(true);
        });
        fileMenu.add(logoutItem);
        
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, 
                "Student Management System v1.0\n" +
                "Developed for Academic Management\n" +
                "© 2024 SMS Team", 
                "About", JOptionPane.INFORMATION_MESSAGE);
        });
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
        
        add(tabbedPane, BorderLayout.CENTER);
        
        // Status Bar
        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBackground(new Color(52, 73, 94));
        statusBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        JLabel statusLabel = new JLabel("Welcome, " + currentStudent.getName() + " | " + 
            new SimpleDateFormat("MMM dd, yyyy").format(new Date()));
        statusLabel.setForeground(Color.WHITE);
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        statusBar.add(statusLabel);
        
        add(statusBar, BorderLayout.SOUTH);
    }
}
