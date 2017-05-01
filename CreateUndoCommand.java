

public class CreateUndoCommand implements CommandFactory{

	@Override
	public Command createCommand(XMembership system) {
		// TODO Auto-generated method stub
		return new UndoCommand(system);
	}

}
