

import java.util.Enumeration;
import java.util.Scanner;

import wlts.*;


public class ChangeAddressCommand implements Command {
	Client client;
	XMembership system;
	
	public ChangeAddressCommand(XMembership system){
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
				//Update the address
				System.out.println("Input new address:");
				c.setAddress(sc.nextLine());
				System.out.println("Address Changed");
				system.cmd.push(this);
				return;
			}
		}
		System.out.println("Member not found");
		return;
	}

	@Override
	public void undo() {
		system.caretaker.saveClientBeforeUndo(client);
		system.caretaker.undo();
	}
	
	public void redo(){
		system.caretaker.saveClient(client);
		system.caretaker.redo();
	}

	public String toString(){
		return client.getCid()+" address changed";
	}
}
