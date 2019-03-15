package co.simplon.testdao;
import java.util.Date;

import co.simplon.dao.CountDAO;
import co.simplon.entities.Counts;
import java.util.Calendar;
public class TestDaoCount {
	public static void lancerTests() {
		// le principe de base d'un programme de tests, 
		// c'est qu'on doit passer par tous les chemins pour valider 
		// Comment faire ici ?
		
		CountDAO cd = new CountDAO();		
		Calendar cal = Calendar.getInstance();
		int year  = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day   = cal.get(Calendar.DAY_OF_MONTH);
		cal.clear();
		cal.set(year, month, day);
		java.sql.Date today = new java.sql.Date(cal.getTimeInMillis());
		Counts c1 = new Counts(5,today,3000,1);
		
		if(cd.create(c1))	System.out.println("insertion ok de " + c1);
		else System.out.println("insertion impossible, client avec cet id existe déjà ");
				
		Counts c2 = cd.find(c1.getNumCt()); 		
		if(c2 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + c2);
		
		c1.setBalance(35000);
		if(cd.update(c1)) System.out.println("ok mise à jour " + c1);
		else System.out.println("mise à jour impossible ");
		
		if(cd.delete(c1))	System.out.println("delete ok " + c1);
		else System.out.println("delete impossible ");	
		//test faux
		c1.setNumCt(4);
		if(cd.create(c1)) {
			System.out.println("insertion ok de "+c1);
		}else {
			System.out.println("insertion impossible, client avec cet id existe deja ");
		}
		c1.setNumCt(6);
		Counts c3= cd.find(c1.getNumCt());
		if(c3 == null)	System.out.println("ce client n'est pas contenu en base ");
		else System.out.println("client trouvé en base : " + c3);
		
		if(cd.update(c1)) System.out.println("ok mise à jour " + c1);
		else System.out.println("mise à jour impossible ");
		
		if(cd.delete(c1))	System.out.println("delete ok " + c1);
		else System.out.println("delete impossible ");
		
}
}
