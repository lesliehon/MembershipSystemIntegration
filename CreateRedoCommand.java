

public class CreateRedoCommand implements CommandFactory{

	@Override
	public Command createCommand(XMembership system) {
		return new RedoCommand(system);
	}

}

