package ajcs;

import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class AdvancedMem {
	private Vector <Member> members;
	private HashMap <String, String> memberType;
	private Scanner sc;
	
	public AdvancedMem(){
		members = new Vector<Member>();
		memberType = new HashMap<String, String>();
		memberType.put("com", "CompanyMember");
		memberType.put("pri", "PrimaryMember");
		sc  = new Scanner(System.in);
	}
	
	public Member createMem(){
		//info Example: 22345673, Com, SW Dve, Flat 1101, Tower X, 38 Busy Rd.
		System.out.print("Enter id, type, name and address:");
		String info = sc.nextLine();
		//Ask user input the information
		
		Member c = null;
		String [] infoArray = info.split(",");
		if(infoArray.length >= 4){
			String id = infoArray[0].trim();
			String type	= infoArray[1].trim().toLowerCase();
			String name = infoArray[2].trim();
			String address ="";
			for(int i = 3 ; i < infoArray.length ; i++){
				address += infoArray[i];
				if(i != infoArray.length -1){
					address+=",";
				}
		}
		try {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, 1);
			c =(Member) Class.forName("ajcs."+memberType.get(type))
							 .getConstructor(String.class, Date.class, String.class, String.class)
							 .newInstance(id,cal.getTime(),name,address);
			if(c.validate(id)){
				members.add(c);
				return c;
			}else{
				System.out.println("User id is not validate.");
				return null;
			}
		} catch (Exception e) {
			System.out.println("Error Information");
		}
			
		}else{
			System.out.println("Error Argument.");
		}	
		return null;	
	}
	
	public Member searchMem(String id){
		//List all members
		Enumeration <Member> memberList = members.elements();
		
		while(memberList.hasMoreElements()){
			Member member = memberList.nextElement();
			if(member.getId().equals(id)){
				System.out.println("Member found.");
				return member;
			}
		}

		return null;
		
	}
	
	public void updateAddress(String id){
		Enumeration <Member> memberList = members.elements();
		while(memberList.hasMoreElements()){
			Member member = memberList.nextElement();
			if(member.getId().equals(id)){
				System.out.print("Please enter new address: ");
				member.setPostal(sc.nextLine());
			}
		}
	}
	
	public void extendGoodTill(String id){
		Enumeration <Member> memberList = members.elements();
		while(memberList.hasMoreElements()){
			Member member = memberList.nextElement();
			if(member.getId().equals(id)){
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.YEAR, 1);
				member.setGoodTill(cal.getTime());
			}
		}
	}
	
	public boolean stillGood(String id){
		Enumeration <Member> memberList = members.elements();
		while(memberList.hasMoreElements()){
			Member member = memberList.nextElement();
			if(member.getId().equals(id)){
				Date md = member.getGoodTill();
				Date now = new Date();
				if(now.before(md)){
					return true;
				}
			}
		}
		return false;
	}
	
}
