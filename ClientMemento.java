

import java.util.Date;

import wlts.Client;



public class ClientMemento implements AbstractMemento{
	Client _client;
	
	private int id;
	private Date goodTill;
	private String name;
	private String postal;
	
	
	public ClientMemento(Client client){
		this._client = client;
		id = _client.getCid();
		goodTill = _client.getExpiryDate();
		name = _client.getName();
		postal = _client.getAddress();
	}
	
	public void restore(){
		this._client.setCid(id);
		this._client.setName(name);
		this._client.setExpiryDate(goodTill);
		this._client.setAddress(postal);
	}
}
