package co.simplon.entities;
import java.sql.Date;
public class Counts {
	private int NumCt;
	private Date DateCreation;
	private int Balance;
	private int IdCust;
	public Counts(int NumCt, Date DateCreation,int Balance, int IdCust) {
		this.NumCt = NumCt;
		this.DateCreation = DateCreation;
		this.Balance=Balance;
		this.IdCust = IdCust;
	}

	@Override
	public String toString() {
		return "Counts [NumCt=" + NumCt + ", DateCreation=" + DateCreation + ",Balance="+Balance+" IdCust=" + IdCust + "]";
	}

	public int getIdCust() {
		return IdCust;
	}

	public void setIdCust(int IdCust) {
		this.IdCust = IdCust;
	}

	public Date getDateCreation() {
		return DateCreation;
	}

	public void setDateCreation(Date DateCreation) {
		this.DateCreation = DateCreation;
	}

	public int getNumCt() {
		return NumCt;
	}

	public void setNumCt(int NumCt) {
		this.NumCt = NumCt;
} 
	public int getBalance() {
		return Balance;
	}

	public void setBalance(int Balance) {
		this.Balance = Balance;
	}


}
