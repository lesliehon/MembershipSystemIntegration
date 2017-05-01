

public class RedoCommand implements Command {
	XMembership system;
	
	public RedoCommand(XMembership system){
		this.system = system;
	}
	@Override
	public void execute() {
		if(!system.redoCmd.isEmpty()){
			Command cmd = system.redoCmd.pop();
			cmd.redo();
			system.cmd.push(cmd);
		}
		System.out.println("Command Redo");
	}

	@Override
	public void undo() {
		//No Redomethod
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
