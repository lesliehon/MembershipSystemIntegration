

public class CreateExtendMembershipCommand implements CommandFactory {

	@Override
	public Command createCommand(XMembership system) {	
		return new ExtendMembershipCommand(system);
	}

}
