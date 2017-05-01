package ajcs;

import java.util.Date;

public class CompanyMember extends Member {

	public CompanyMember(String id, Date goodTill, String name, String postal) {
		super(id, goodTill, name, postal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate(String id) {
		if(id.length()!= 8) return false;
		else{
			char[] idArray = id.toCharArray(); 
			int sum = 0;
			for(int i = 0 ; i < idArray.length ; i++){
				sum  += Character.getNumericValue(idArray[i]);
			}
			
			if( (sum % 8) == 0) 
				return true;
			else 
				return false;
			
		}
	}

}
