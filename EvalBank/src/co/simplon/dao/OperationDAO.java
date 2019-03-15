package co.simplon.dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.entities.Counts;
import co.simplon.entities.Operation;
public class OperationDAO extends DAO<Operation>{
	public Operation find(int id) {	
		String str = "select * from T_Operations where NumOp=?";
		PreparedStatement ps;
		Operation operation = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){				
				operation = new Operation(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3));
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		}		
		return operation;						
	}

	@Override
	public boolean create(Operation operation) {
		String str = "INSERT INTO T_Operations (NumOp,Amount,NumCt) VALUES (?, ? ,?);";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, operation.getNumOp());
			ps.setInt(2,operation.getAmount());
			ps.setInt(3,operation.getNumCt());
			ps.executeQuery();
			ok = true;

		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Operation operation) {
		String str = " update T_Operations set Amount=? where NumOp=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,operation.getAmount());
			ps.setInt(2,operation.getNumOp());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		return ok;
	}

	@Override
	public boolean delete(Operation operation) { 
		String str = "delete from T_Operations where NumOp=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,operation.getNumOp());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}
