package wlts;

import wlts.*;
import ajcs.*;


public class SystemAdapter extends ClientCare {
	AdvancedMem advmem;
	
	public SystemAdapter(AdvancedMem sys){
		advmem = sys;
	}
	
	public Client createClient(){
		Member tmp = advmem.createMem();
		if (tmp !=null)
			return new MembershipAdapter(tmp);
		else
			return null;
	}
	
	public Client foundClient(int cid){
		Member tmp = advmem.searchMem(String.valueOf(cid));
		if (tmp !=null)
			return new MembershipAdapter(tmp);
		else
			return null;
	}
	
	public void admendAddress(int cid){
		advmem.updateAddress(String.valueOf(cid));
	}
	
	public void extendExpiryDate(int cid){
		advmem.extendGoodTill(String.valueOf(cid));
	}
	
	public boolean isExpired(int cid){
		return advmem.stillGood(String.valueOf(cid));
	}
}
