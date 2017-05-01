

public class CreateShowMemberCommand implements CommandFactory{
	public Command createCommand(XMembership system){
		return new ShowMemberCommand(system);
	}
}
