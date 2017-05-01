

public class UndoCommand implements Command{
	XMembership system;
	
	public UndoCommand(XMembership system){
		this.system = system;
	}
	
	@Override
	public void execute() {
		if(!system.cmd.isEmpty()){
			Command cmd = system.cmd.pop();
			cmd.undo();
			system.redoCmd.push(cmd);
		}
		System.out.println("Command Undo");
	}

	@Override
	public void undo() {
		//No redo
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}
	
}
