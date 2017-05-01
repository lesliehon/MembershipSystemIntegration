import java.util.Vector;

import wlts.Client;

public class MemberListMemento implements AbstractMemento {
	private Vector _list = null;
	private Vector backupList = null;
	
	public MemberListMemento(Vector list){
		_list = list;
		backupList =  (Vector) list.clone();
	}
	
	public void restore(){
		_list = backupList;
	}
}