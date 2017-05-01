

public class CreateUndoRedoListCommand implements CommandFactory{

	@Override
	public Command createCommand(XMembership system) {
		return new UndoRedoListCommand(system);
	}

}
