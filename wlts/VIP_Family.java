package wlts;

import java.util.Date;

public class VIP_Family extends Client {

	public VIP_Family(int cid, Date expiryDate, String fullName,
			String homeAddress) {
		super(cid, expiryDate, fullName, homeAddress);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate(int cid) {
		String id = String.valueOf(cid);
		if(id.length()!= 9) return false;
		else{
			if(id.substring(0,3).equals("303")){
				char[] idArray = id.toCharArray(); 
				int sum = 0;
				for(int i = 0 ; i < idArray.length ; i++){
					sum  += Character.getNumericValue(idArray[i]);
				}
				
				if( (sum % 6) == 0) 
					return true;
				else 
					return false;
			}else{
				return false;
			}
		}
	}

}
