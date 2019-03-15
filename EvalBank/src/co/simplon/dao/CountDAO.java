package co.simplon.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import co.simplon.entities.Counts;
import co.simplon.entities.Customer;

public class CountDAO extends DAO<Counts>{
	public Counts find(int id) {	
		String str = "select * from T_Counts where NumCt=?";
		PreparedStatement ps;
		Counts count = null;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,id);
			ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){				
				count = new Counts(resultSet.getInt(1),resultSet.getDate(2),resultSet.getInt(3),resultSet.getInt(4));
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
		}		
		return count;						
	}

	@Override
	public boolean create(Counts count) {
		String str = "INSERT INTO T_Counts (NumCt,DateCreation,Balance,IdCust) VALUES (?, ? ,?,? );";
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1, count.getNumCt());
			ps.setDate(2,(Date) count.getDateCreation());
			ps.setInt(3,count.getBalance());
			ps.setInt(4,count.getIdCust());
			ps.executeQuery();
			ok = true;

		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return ok;
	}

	@Override
	public boolean update(Counts count) {
		String str = " update T_Counts set Balance=? where NumCt=?;";		
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,count.getBalance());
			ps.setInt(2,count.getNumCt());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		} 		
		return ok;
	}

	@Override
	public boolean delete(Counts count) { 
		String str = "delete from T_Counts where NumCt=?;";	
		PreparedStatement ps;
		boolean ok = false;
		try {
			ps = connection.prepareStatement(str);
			ps.setInt(1,count.getNumCt());
			int row = ps.executeUpdate();
			if(row > 0)	ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
}
