# 🍽️ MyFood Java App

**MyFood** is a simple Java-based console application for food ordering. It allows users to register, log in, browse available food items, and place orders — all connected to a MySQL database.

---

## 📌 Features

- 🔐 User SignUp and Login with validation
- ✅ Email and strong password pattern checks
- 🍔 View food items in a clean card-style format
- 🛒 Order food by selecting item ID
- 💾 MySQL database integration via JDBC

---

## 🛠️ Tech Stack

- Java (Core + JDBC)
- MySQL
- Console-Based UI
- MySQL Connector/J (JDBC Driver)

---

## 🗃️ Database Setup

### 🔹 Table: `user`

```sql
CREATE TABLE user (
  Username VARCHAR(50),
  Password VARCHAR(100),
  Email VARCHAR(100) PRIMARY KEY,
  Full_Name VARCHAR(100)
);
📋 Input Validations
Email: Must follow standard format like abc@example.com

Password: Must match the pattern:

At least 8 characters

Includes uppercase, lowercase, number, and special character

No spaces

🚀 How to Run
✅ Prerequisites
Java (JDK 8 or later)

MySQL Server

MySQL Connector/J (JDBC Driver)

🔧 Steps
Clone or download this repository.

Set up your MySQL database and run the schema above.

Update DB credentials in MyFood.java:

static String url = "jdbc:mysql://localhost:3306/myfood";
static String user = "root";
static String pass = "your_password";
Compile and run:

javac MyFood.java
java MyFood
📷 Sample Output

===================================
         Welcome to MY FOOD
===================================
For SignUp press 1
For LogIn press 2

+----------------------------------------+
| Item ID:   101                         |
| Dish:      Veg Biryani                 |
| Category:  Main Course                 |
| Price:     ₹150.00                     |
| Available: Yes                         |
+----------------------------------------+
🤝 Contributing
Contributions are welcome! You can:

Fork the repo

Submit pull requests

Suggest ideas in Issues

🧑‍💻 Author
Vijay Nangina

