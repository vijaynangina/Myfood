MyFood – Mini Food-Ordering Console App
A tiny Java console program that lets you sign-up, log-in and order food from a MySQL-backed menu.
Built with core-JDBC, no external frameworks.
What it does
• Greets the user and offers two choices: Sign-Up or Log-In
• Validates e-mail & password against simple regex rules
• Persists new users into table user (MySQL)
• After successful log-in presents a menu fetched from table fooditems
• Lets the customer pick an item by ID and prints an “order confirmed” card
Tech stack
• Java 8+
• MySQL 8.x
• JDBC driver mysql-connector-j (place it on the class-path)
Quick start
Clone / copy the project directory.
Create database & tables once:
sql
Copy
CREATE DATABASE IF NOT EXISTS myfood;
USE myfood;

CREATE TABLE user (
    Username   VARCHAR(30) PRIMARY KEY,
    Password   VARCHAR(64) NOT NULL,
    Email      VARCHAR(64) NOT NULL UNIQUE,
    Full_Name  VARCHAR(40) NOT NULL
);

CREATE TABLE fooditems (
    ID          INT AUTO_INCREMENT PRIMARY KEY,
    Item_name   VARCHAR(40),
    category    VARCHAR(20),
    price       DOUBLE,
    is_available BOOLEAN
);

-- sample rows
INSERT INTO fooditems VALUES
(1,'Margherita Pizza','Pizza',249.00,true),
(2,'Veg Burger','Burger',129.00,true),
(3,'Masala Dosa','South Indian',99.00,true);
Compile & run
bash
Copy
javac -cp ".;mysql-connector-j-8.x.x.jar" MyFood.java
java  -cp ".;mysql-connector-j-8.x.x.jar" MyFood
(use : instead of ; on Linux/macOS)
Folder layout (minimal)
MyFood_Package/
├─ MyFood.java
└─ README.md   ← this file
Configuration
The JDBC URL, user and password are hard-coded at the top of the class:
java
Copy
static String url  = "jdbc:mysql://localhost:3306/myfood";
static String user = "root";
static String pass = "123456";
Change them as needed.
Password / e-mail rules
• E-mail must look like name@domain.tld
• Password ≥ 8 chars, must contain at least one upper-case, one lower-case, one digit and one special symbol among @#$%^&+=
Extending the project
• Add more CRUD in fooditems (insert, update availability, delete)
• Introduce an order history table that records user + item + timestamp
• Replace console with a simple Swing/JavaFX GUI
Troubleshooting
• “ClassNotFoundException: com.mysql.cj.jdbc.Driver” → driver JAR is not on the class-path.
• “Access denied for user” → check MySQL credentials or create a dedicated user.
• Regex errors → ensure password really contains all required character classes.
Enjoy your meal!
