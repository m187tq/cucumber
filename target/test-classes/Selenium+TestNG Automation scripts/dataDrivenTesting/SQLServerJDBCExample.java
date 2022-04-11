package dataDrivenTesting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerJDBCExample {

	public static void main(String[] args) throws SQLException
	{
		//step1: create connection to the database
		Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;port=1534;user=sa;password=Welcome123;database=HR;");

		//Step2: create statement/query
		Statement stmt = con.createStatement();
		
		//Step3: Execute statement
		
		 String insertquery = "INSERT INTO EMPLOYEE(EMPLOYEE_ID,Last_Name,FIRST_NAME)VALUES(2222,'SARAN','KUMAR')";
		// String updatequery ="UPDATE EMPLOYEE SET FIRST_NAME='kumar' WHERE EMPLOYEE_ID=2222";
		//String deletequery = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID=2222";

		stmt.executeQuery(insertquery);
		// stmt.executeQuery(updatequery);
		//stmt.executeQuery(deletequery);
		
		//step4: close connection
		con.close();
		System.out.println(" program is completed");

	}
}