

public class ExitCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Exit System");
		System.exit(0);
	}

	@Override
	public void undo() {
		//Needed for interface only, this command cannot redo
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
