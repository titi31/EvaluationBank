package co.simplon.entities;

public class Operation {
	private int NumOp;
	private int Amount;
	private int NumCt ;
	public Operation(int NumOp, int Amount, int NumCt) {
		this.NumOp = NumOp;
		this.Amount = Amount;
		this.NumCt = NumCt;
	}

	@Override
	public String toString() {
		return "Operations [NumOp=" + NumOp + ", Amount=" + Amount + ", NumCt=" + NumCt + "]";
	}

	public int getNumOp() {
		return NumOp;
	}

	public void setNumOp(int NumOp) {
		this.NumOp = NumOp;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int Amount) {
		this.Amount = Amount;
	}

	public int getNumCt() {
		return NumCt;
	}

	public void setNumCt(int NumCt) {
		this.NumCt = NumCt;
} 
}
