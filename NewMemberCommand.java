

import java.util.Scanner;

import wlts.Client;
import wlts.ClientCare;


public class NewMemberCommand implements Command{
	Client c;
	XMembership system;
	
	public NewMemberCommand(XMembership system){
		this.system = system;
	}
	
	@Override
	public void execute() {
		system.caretaker.saveMemberList(system.client);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Company Code (ajcs/wlts):");
		String company = sc.next().toLowerCase().trim();
		try{
			ClientCare cc = system.system.get(company);
			c = cc.createClient();
			if(c != null){
				system.client.add(c);
				system.cmd.push(this);
				System.out.println("New Member Record Created");
			}
		}catch(Exception e){
			System.out.println("Error in create client");
		}
		
	}

	@Override
	public void undo() {
		system.caretaker.saveMemberListBeforeUndo(system.client);
		system.caretaker.undo();
	}

	@Override
	public void redo() {
		system.caretaker.saveMemberList(system.client);
		system.caretaker.redo();
	}
	
	public String toString(){
		return "Member Created: "+c.getCid();
	}
}
