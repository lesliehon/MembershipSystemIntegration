package wlts;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import ajcs.Member;

public class ClientCare {
	private Vector <Client> client;
	private HashMap <String, String> memberType;
	private Scanner sc;
	
	public ClientCare(){
		client = new Vector<Client>();
		memberType = new HashMap<String, String>();
		memberType.put("vip", "VIP");
		memberType.put("vipf", "VIP_Family");
		sc  = new Scanner(System.in);
	}
	
	public Client createClient(){
		//info Example:
			//22345673, Com, SW Dve, Flat 1101, Tower X, 38 Busy Rd.
			System.out.print("Enter id, type, name and address:");
			String info = sc.nextLine();
			//Ask user input the information
			
			Client c = null;
			String [] infoArray = info.split(",");
			if(infoArray.length >= 4){
				int id = Integer.parseInt(infoArray[0].trim());
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
				c =(Client) Class.forName("wlts."+memberType.get(type))
								.getConstructor(int.class , Date.class, String.class, String.class)
								.newInstance(id,cal.getTime(),name,address);
				if(c.validate(id)){
					client.add(c);
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
			
	public Client foundClient(int cid){
		Enumeration <Client> memberList = client.elements();
		while(memberList.hasMoreElements()){
			Client member = memberList.nextElement();
			if(member.getCid()== cid){
				return member;
			}
		}
		return null;
	}
	
	public void amendAddress(int cid){
		Enumeration <Client> memberList = client.elements();
		while(memberList.hasMoreElements()){
			Client member = memberList.nextElement();
			if(member.getCid()== cid){
				System.out.print("Please enter new address: ");
				member.setAddress(sc.nextLine());
			}
		}
	}
	
	public void extendExpiryDate(int cid){
		Enumeration <Client> memberList = client.elements();
		while(memberList.hasMoreElements()){
			Client member = memberList.nextElement();
			if(member.getCid()== cid){
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.YEAR, 1);
				member.setExpiryDate(cal.getTime());
			}
		}
	}
	
	public boolean isExpired(int cid){
		Enumeration <Client> memberList = client.elements();
		while(memberList.hasMoreElements()){
			Client member = memberList.nextElement();
			if(member.getCid()== cid){
				Date md = member.getExpiryDate();
				Date now = new Date();
				if(now.before(md)){
					return true;
				}
			}
		}
		return false;
	}
	
}
