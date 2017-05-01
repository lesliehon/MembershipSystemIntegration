

public class CreateChangeAddressCommand implements CommandFactory{

	public Command createCommand(XMembership system) {
		Command cmd =  new ChangeAddressCommand(system);
		return cmd;
	}

}
