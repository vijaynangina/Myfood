package MyFood_Package;

import java.util.*;
import java.sql.*;

public class MyFood {
	
	static Scanner sc = new Scanner(System.in);
	static String url="jdbc:mysql://localhost:3306/myfood";
	static String user="root";
	static String pass="123456";
	public static void main(String[] args) {
		System.out.println("===================================");
		System.out.println("         Welcome to MY FOOD");
		System.out.println("===================================");
		System.out.println("For SignUp press 1");
		System.out.println("For LogIn press 2");
		int n=sc.nextInt();
		if(n==1) signin();
		if(n==2) login();
		
	}
	public static void signin() {
		try {		
			System.out.print("Enter fullname without spaces:");
			 String Full_Name=sc.next();
			System.out.print("Enter username :");
			 String Username=sc.next();
			 System.out.print("Enter Email :");
			 String Email=sc.next();
			 if(!Email.matches("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$")) throw new Exception("Invalid Email ");			
			 System.out.print("set password :");
			 String Password=sc.next();
			 if(!Password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) throw new Exception("Invalid Password");
			 
			
			Class.forName("com.mysql.cj.jdbc.Driver");				
			Connection con = DriverManager.getConnection(url,user,pass);	
			
			
			PreparedStatement stm =con.prepareStatement("insert into user(Username,Password,Email,Full_Name)values(?,?,?,?)");
			
			stm.setString(1, Username);
			stm.setString(2, Password);
			stm.setString(3, Email);
			stm.setString(4, Full_Name);
			
			
			
			int x=stm.executeUpdate();
			
			if(x>0) {
				System.out.println("Account created Successfully");
				System.out.println("click 1 for menu");
				int m=sc.nextInt();
				if(m==1) items();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.print("press y/n :");
			char choice = sc.next().charAt(0);
			if(choice == 'y') signin();
			else System.out.print("cencelled ssignup");
		}
	}
	
	public static void login() {
		
		try {
			System.out.print("Enter your email :");
			String Email=sc.next();
			if(!Email.matches("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$")) throw new Exception("Invalid Email ");
			System.out.print("Enter your Password :");
			String Password=sc.next();
			if(!Password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) throw new Exception("Invalid Password");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,user,pass);
			
			PreparedStatement stm=con.prepareStatement("select * from user where Email=?");
			stm.setString(1,Email);		
			ResultSet res=stm.executeQuery();
			
			if(res.next()) {
				if(Password.equals(res.getString("Password"))) {
					System.out.println("Login Successfull");
					System.out.println("click 1 for menu");
					int m=sc.nextInt();
					if(m==1) items();
				}
				else System.out.print("Incorrect Login Details");
			}		
			
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
	}
	public static void items() {
		System.out.println();
		System.out.println("   Choose ur fav Food Item");
		System.out.println("===============================");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement stm=con.prepareStatement("select * from fooditems");
			
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("ID");
				String name = rs.getString("Item_name");
                String category = rs.getString("category");
                double price = rs.getDouble("price");
                boolean isavailable = rs.getBoolean("is_available");

                printCard(id,name, category, price, isavailable);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		choice();
		
		
	}
	public static void printCard(int id ,String name, String category, double price, boolean available) {
	    String line = "+----------------------------------------+";
	    System.out.println(line);
	    System.out.printf("| Item ID:   %-28s |\n",id);
	    System.out.printf("| Dish: %-33s |\n", name);
	    System.out.printf("| Category: %-29s |\n", category);
	    System.out.printf("| Price: ₹%-31.2f |\n", price);
	    System.out.printf("| Available: %-28s |\n", available ? "Yes" : "No");
	    System.out.println(line);
	}
	public static void choice() {
		System.out.println("Enter your Item id Number");
		int n=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,pass);
			PreparedStatement st=con.prepareStatement("select * from fooditems where id =?");
			st.setInt(1,n);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("ID");
				String name = rs.getString("Item_name");
                String category = rs.getString("category");
                double price = rs.getDouble("price");
                boolean isavailable = rs.getBoolean("is_available");

                printCard(id,name, category, price, isavailable);
                System.out.println("You ordered "+name+" at Rs."+price);
                System.out.println("You ordered is on the way !!!");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}
