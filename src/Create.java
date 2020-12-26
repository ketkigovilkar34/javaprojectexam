import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Create 
{
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Found Successfully");
		
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/basic","root","root");
		System.out.println("Connection Made successfully");
		Scanner s=new Scanner(System.in);
		
		PreparedStatement ps=con.prepareStatement("Create table student(name varchar(20),Roll_No varchar(20),Avg_Marks varchar(20))");
		int i=ps.executeUpdate();
		
		if(i==0)
			System.out.println("Table Created Successfully");
		else
			System.out.println("Fail to create the table");
		
		PreparedStatement sp=con.prepareStatement("insert into student values(?,?,?)");
		System.out.println("\nEnter name : ");
		String name=s.nextLine();
		System.out.println("\nEnter the roll Number ");
		int roll=s.nextInt();
		System.out.println("\nEnter Average marks : ");
		
		float avg_marks=s.nextFloat();
		sp.setString(1,name);
		sp.setInt(2,roll);
		sp.setFloat(3,avg_marks);
		int j=sp.executeUpdate();;
		
		System.out.println("j=" + j);
		if(j==0)
		System.out.println("\nvalues inserted Successfully");
		else 
			System.out.println("\nFalied to insert the values");
		
		System.out.println("\nTable Details are");
		ResultSet  rs1=ps.executeQuery("select * from student");
		System.out.println("Name \t\t Roll No. \t Average Marks");
		
		while(rs1.next())
		{
			
			System.out.println(rs1.getString(1) + "\t   " + rs1.getInt(2) + "\t\t   " + rs1.getFloat(3));
		}
			
		
	}
}
