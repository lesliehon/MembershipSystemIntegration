

import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Scanner;

import wlts.*;


public class ShowMemberCommand implements Command {
	XMembership system;
	
	public ShowMemberCommand(XMembership system){
		this.system = system;
	}
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		Enumeration<Client> clientList = system.client.elements();
		
		//Ask the user input the ID
		System.out.println("Please Enter the id:");
		String id = sc.next().trim();
		SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
		if(id.equals("*999")){
			//get All information
			System.out.println("Member List:");
			System.out.println("Expire Date\tID\t\tType\t\tName\t\tAddress");
			while(clientList.hasMoreElements()){
				Client tmpc = clientList.nextElement();
				String expireDate = dFormat.format(tmpc.getExpiryDate());
				String ID = String.valueOf(tmpc.getCid());
				String Type = tmpc.getClass().getName();
				String Name = tmpc.getName();
				String Address = tmpc.getAddress();
				System.out.println(expireDate+",\t"+ID+",\t"+Type+",\t"+Name+",\t"+Address);
			}
		}else{
			while(clientList.hasMoreElements()){
				Client tmpc = clientList.nextElement();
				if(tmpc.getCid() == Integer.parseInt(id)){
					System.out.println("Member information");
					System.out.println("ID: "+tmpc.getCid());
					System.out.println("Type: "+ tmpc.getClass().getName());
					System.out.println("Name: "+tmpc.getName());
					System.out.println("Address: "+tmpc.getAddress()+" Expire date (DD-MM-YYYY): "+dFormat.format(tmpc.getExpiryDate()));
					return;
				}
			}
			
			System.out.println("No Member found");
			
		}
		

		
		
		
	}

	@Override
	public void undo() {
		//No need for List
	}

	@Override
	public void redo() {
		//No need for List
	}

}
