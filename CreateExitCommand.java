

public class CreateExitCommand implements CommandFactory {

	@Override
	public Command createCommand(XMembership system) {
		return new ExitCommand();
	}
}
