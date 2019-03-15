import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) {
		try {
		Class.forName("org.mariadb.jdbc.Driver");
		System.out.println("Driver O.K.");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Bank", "root", "darkorbit");
		Statement state = conn.createStatement();
		//ResultSet result=state.executeQuery("INSERT INTO T_Customers(Name,FirstName) VALUES ('keita','alseny');");
		//ResultSet result=state.executeQuery("UPDATE T_Customers SET Name='Etienne',FirstName='Alexy' WHERE IdCust=3;");
		//ResultSet result=state.executeQuery("DELETE FROM T_Customers WHERE IdCust=3;");
		ResultSet result = state.executeQuery("SELECT * FROM T_Customers INNER JOIN T_Counts ON T_Customers.IdCust=T_Counts.IdCust WHERE T_Customers.IdCust=1;");
		result=state.executeQuery("select * from T_Counts inner join T_Operations ON T_Counts.NumCt=T_Operations.NumCt WHERE T_Counts.NumCt=1;");
		ResultSetMetaData resulBank=result.getMetaData();
		while(result.next()) {
			//System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getInt(4)+" "+result.getDate(5)+" "+result.getInt(6));
			System.out.println(result.getInt(1)+" "+result.getDate(2)+" "+result.getInt(3)+" "+result.getInt(4)+" "+result.getInt(5)+" "+result.getInt(6));
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
