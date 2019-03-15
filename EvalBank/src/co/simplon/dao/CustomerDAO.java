package co.simplon.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.entities.Customer;

public class CustomerDAO extends DAO<Customer>{
	@Override
	public Customer find(int id) {	
		String str = "select * from T_Customers where IdCust=?";
		PreparedStatement ps;
		Customer customer = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			
			
			
			if(resultSet.next()){				
				customer = new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
			}
		} catch (SQLException e) {
			System.out.println("customer not exists !");
			//e.printStackTrace();
		}		
		return customer;						
	}

	@Override
	public boolean create(Customer customer) {
		String str = "INSERT INTO T_Customers (IdCust,Name, FirstName) VALUES (?, ? ,? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, customer.getIdCust());
			ps.setString(2,customer.getName());
			ps.setString(3,customer.getFirstName());
			ps.executeQuery();
			ok = true;

		} catch (SQLException e) {
			return ok;
			//e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Customer customer) {
		String str = " update T_Customers set Name=?,FirstName=? where IdCust=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setString(1,customer.getName());
			ps.setString(2,customer.getFirstName());
			ps.setInt(3,customer.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		return ok;
	}

	@Override
	public boolean delete(Customer customer) { 
		String str = "delete from T_Customers where IdCust=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,customer.getIdCust());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}

