

public class CreateNewMemberCommand implements CommandFactory{
	public Command createCommand(XMembership system){
		Command cmd = new NewMemberCommand(system);
		return cmd;
	}
}
