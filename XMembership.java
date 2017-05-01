/*
 * Topics: MembershipSystemIntegration
 * Name: Leslie Hon
 * Date: 2012-12-04 
 */


import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

import wlts.*;
import ajcs.*;


public class XMembership {
	Vector <Client> client; //A Vector to store the client
	Caretaker caretaker; //Caretaker for undo and redo
	HashMap<String, ClientCare> system; //A Vector to store the different type of System
	HashMap<String,String> cmdList;
	HashMap<String, String> typeList;
	Stack<Command> cmd;
	Stack<Command> redoCmd;
	final String[] cmdKey = {"c","s","a","e","u","r","l","X"};
	final String[] cmdValue = {	"CreateNewMemberCommand", "CreateShowMemberCommand", 
										"CreateChangeAddressCommand", "CreateExtendMembershipCommand",
										"CreateUndoCommand", "CreateRedoCommand", 
										"CreateUndoRedoListCommand", "CreateExitCommand"};
	
	public XMembership(){
		//Declare the system elements
		client = new Vector<Client>();
		caretaker =  new Caretaker();
		system = new HashMap<String, ClientCare>();
		cmd = new Stack<Command> ();
		redoCmd = new Stack<Command>();
		system.put("wlts", new ClientCare());
		system.put("ajcs", new SystemAdapter( new AdvancedMem()) );
		cmdList = new HashMap<String,String>();
		for(int i = 0 ; i < cmdKey.length ; i++){
			//Create the command Hashmap
			cmdList.put(cmdKey[i], cmdValue[i]);
		}
	}
		
	public void run(){
		Scanner sc = new Scanner(System.in);
		//Starting the program
		while(true){
			System.out.println("X Mem Management System");
			System.out.println("Please Enter Command: [c | s | a | e | u | r | l | X]");
			System.out.println("c = create membership, s = show membership details, a = update address, e = extend membership, u"+
			"= undo, r = redo, l = list undo/redo");
			
			try{
				CommandFactory userCommandF = (CommandFactory) Class.forName(cmdList.get(sc.next().trim())).newInstance(); //Create the command Factory
				Command userCommand = userCommandF.createCommand(this); //Create new command by command factory
				userCommand.execute(); //Run the command
				System.out.println("\n\n");
			}catch(ClassNotFoundException e){
				//If the command not found, throw this exception
				System.out.println("Command not found, please try again");
				continue;
			}catch(Exception e){
				System.out.println("Command not found, please try again");
			}
		}
	}
	
	
	public static void main(String args[]){
		XMembership memSystem = new XMembership();
		memSystem.run();
	}
	
}
