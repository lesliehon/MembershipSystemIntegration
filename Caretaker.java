

import java.util.Stack;
import java.util.Vector;

import wlts.*;

public class Caretaker {
	Stack <AbstractMemento> undoList;
	Stack <AbstractMemento> redoList;
	
	public Caretaker(){
		//Create the undolist and redo list
		undoList = new Stack<AbstractMemento> ();
		redoList = new Stack<AbstractMemento> ();
	}
	
	public void saveMemberList(Vector list){
		//Backup the object and put the memento to undoList for Undo
		undoList.push(new MemberListMemento(list));
	}
	
	public void saveClient(Client c){
		//Backup the object and put the memento to undoList for Undo
		undoList.push(new ClientMemento(c));
	}
	
	public void saveMemberListBeforeUndo(Vector list){
		//Backup the object before undo and put the memento into redoList for redo action
		redoList.push(new MemberListMemento(list));
	}
	
	public void saveClientBeforeUndo(Client c){
		//Backup the object before undo and put the memento into redoList for redo action
		redoList.push(new ClientMemento(c));
	}
	
	public void undo(){
		//Undo action
		if(!undoList.isEmpty()){
			AbstractMemento tmp = undoList.pop();
			tmp.restore();
		}
	}
	
	public void redo(){
		//Redo action
		if(!redoList.isEmpty()){
			AbstractMemento tmp = redoList.pop();
			tmp.restore();
		}
	}
}
