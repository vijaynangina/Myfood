╔══════════════════════════════════════════════════════════════════╗
║                                                                  ║
║                  🍕  MyFood – README  🍕                         ║
║                                                                  ║
║      A tiny console app to sign-up, log-in & order food          ║
║             backed by MySQL and pure JDBC magic                  ║
║                                                                  ║
╚══════════════════════════════════════════════════════════════════╝


🌟  FEATURES
├─ Beautiful ASCII greeting & menu cards
├─ Regex-validated e-mail & password
├─ Secure user storage in MySQL
└─ One-click order confirmation

────────────────────────────────────────
🚀  5-MINUTE START
1.  Create the database once
    mysql>  CREATE DATABASE myfood;
    mysql>  USE myfood;
    mysql>  ┌─ run the SQL below ─┐

    CREATE TABLE user (
        Username  VARCHAR(30) PRIMARY KEY,
        Password  VARCHAR(64) NOT NULL,
        Email     VARCHAR(64) UNIQUE,
        Full_Name VARCHAR(40)
    );

    CREATE TABLE fooditems (
        ID           INT AUTO_INCREMENT PRIMARY KEY,
        Item_name    VARCHAR(40),
        category     VARCHAR(20),
        price        DOUBLE,
        is_available BOOLEAN
    );

    INSERT INTO fooditems VALUES
    (1,'Margherita','Pizza',249,true),
    (2,'Veg Burger','Burger',129,true),
    (3,'Masala Dosa','South Indian',99,true);

2.  Compile & run
    $ javac -cp ".;mysql-connector-j-8.x.x.jar" MyFood.java
    $ java  -cp ".;mysql-connector-j-8.x.x.jar" MyFood

   (Linux/Mac: use “:” instead of “;”)

────────────────────────────────────────
⚙️  CONFIG
File: MyFood.java (top lines)
┌────────────────────────────┐
│ url  = jdbc:mysql://...    │
│ user = root                │
│ pass = 123456              │
└────────────────────────────┘
Change to match your setup.

────────────────────────────────────────
🛡️  VALIDATION RULES
• E-mail:  name@domain.tld
• Password: ≥8 chars, 1 upper, 1 lower, 1 digit, 1 special (@#$%^&+=)

────────────────────────────────────────
🧩  EXTEND IT
• Add order-history table
• CRUD for fooditems
• Switch to Swing/JavaFX

────────────────────────────────────────
📂  PROJECT TREE
MyFood_Package/
├─ MyFood.java
└─ README.md   ← you are here

────────────────────────────────────────
💬  Enjoy coding… and bon appétit! 🥗
