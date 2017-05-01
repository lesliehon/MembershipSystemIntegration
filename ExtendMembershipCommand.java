

import java.util.Calendar;
import java.util.Enumeration;
import java.util.Scanner;

import wlts.Client;


public class ExtendMembershipCommand implements Command {
	Client client;
	XMembership system;
	
	public ExtendMembershipCommand(XMembership system){
		this.system = system;
	}
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter ID:");
		String id = sc.nextLine();		
		//Search the member ID
		Enumeration<Client> member = system.client.elements();
		while(member.hasMoreElements()){
			Client c = member.nextElement();
			if(c.getCid() == Integer.parseInt(id)){
				client = c;
				system.caretaker.saveClient(c); //Save the account to caretaker
				//Update the membership
				Calendar cal = Calendar.getInstance();
				cal.setTime(client.getExpiryDate());
				cal.add(Calendar.YEAR, 1); //Extend one year
				client.setExpiryDate(cal.getTime());
				
				System.out.println("Membership extended");
				system.cmd.push(this);
				return;
			}
		}
		System.out.println("Member not found");
		return;
	}

	public void undo() {
		system.caretaker.saveClientBeforeUndo(client);
		system.caretaker.undo();
	}
	
	public void redo(){
		system.caretaker.saveClient(client);
		system.caretaker.redo();
	}
	
	public String toString(){
		return "Membership "+client.getCid()+" extended.";
	}
}
