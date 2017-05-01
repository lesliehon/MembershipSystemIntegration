

public class UndoRedoListCommand implements Command {
	XMembership system;
	
	public UndoRedoListCommand(XMembership system){
		this.system = system;
	}
	
	@Override
	public void execute() {
		//Fetch Undo List
		System.out.println("Undo List:");
		Object[] cmdStack = system.cmd.toArray();
		for(int i = 0 ; i < cmdStack.length ; i++){
			System.out.println(cmdStack[i].toString());
		}
		
		//Fetch Redo List
		System.out.println("Redo List:");
		Object[] redoStack = system.redoCmd.toArray();
		for(int i = 0 ; i < redoStack.length ; i++){
			System.out.println(redoStack[i].toString());
		}
	}

	@Override
	public void undo() {
		//No Redo command
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
