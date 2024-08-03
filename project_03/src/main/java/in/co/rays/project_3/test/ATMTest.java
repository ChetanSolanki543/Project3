package in.co.rays.project_3.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.AtmDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.model.AtmModelHibImp;
import in.co.rays.project_3.model.AtmModelInt;


public class ATMTest {
	public static void main(String[] args) throws Exception {
		
		AtmModelInt model = new AtmModelHibImp();

		
		//testAdd();
		searchTest();
	}
	
	private static void searchTest() throws ApplicationException {
		// TODO Auto-generated method stub
		AtmDTO dto = new AtmDTO();
		dto.setId(1L);
//		 dto.setFirstName("Mayankshi");
//		 dto.setLastName("agrawal");
//		 dto.setLogin("login");
//		 dto.setPassword("123");
//		 dto.setMobileNO("989");
//		 dto.setRoleId(1);
//		 dto.setUnSuccessfullLogin(1);

		AtmModelInt model = new AtmModelHibImp();

		ArrayList<AtmDTO> a = (ArrayList<AtmDTO>) model.search(dto);

		for (AtmDTO udto1 : a) {
			System.out.println(udto1.getId() + "\t" + udto1.getLocation() + "\t" + udto1.getRemark() + "\t"
					+ udto1.getCash_available() + "\t" + udto1.getLast_restocked_date() );
		}
	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		
		AtmDTO dto = new AtmDTO();
		
		dto.setLocation("Indore");
		dto.setCash_available(123456789);
		dto.setRemark("Insufficient funds for withdrawal");
       dto.setLast_restocked_date(sdf.parse("12-12-2012"));		
		
       AtmModelInt model = new AtmModelHibImp();
       
		model.add(dto);
		
		System.out.println("Data ADDED");
		
	}

}