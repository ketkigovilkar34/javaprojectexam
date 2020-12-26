import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete
{
	int del;
	
	
	public static void main(String [] args) throws ClassNotFoundException,SQLException
	{
		int del;
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Registered Successfully...");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/basic","root","root");
		System.out.println("Connection made Successfully");
		
		PreparedStatement ps=con.prepareStatement("delete from emp where id=?");
		Scanner s=new Scanner(System.in);
		
		System.out.println("\nTable Details are");
		ResultSet  rs1=ps.executeQuery("select * from emp");
		while(rs1.next())
		{
			System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getInt(3) + " "+ rs1.getString(4));
		}
			
			System.out.println("Enter the roll no. that you want to delete:");
			del=s.nextInt();
		
		ps.setInt(1,del);
		int i=ps.executeUpdate();
		
		if(i>0)
		{
			System.out.println("Succefully Query done");
		}
		else
			System.out.println("Fail to execute");
		ResultSet  rs=ps.executeQuery("select * from emp");
		
		System.out.println("\nTable Details are");
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " "+ rs.getString(4));
		}

	
	}
}
