package wlts;

import java.util.Date;

public abstract class Client {
	private int cid;
	private Date expiryDate;
	private String fullName;
	private String homeAddress;
	
	public abstract boolean validate(int cid);
	
	public Client(int cid , Date expiryDate , String fullName, String homeAddress){
		this.cid = cid;
		this.expiryDate = expiryDate;
		this.fullName = fullName;
		this.homeAddress = homeAddress;
	}
	
	public int getCid(){
		return cid;
	}
	
	public void setCid(int cid){
		if(validate(cid))
			this.cid = cid;
	}
	
	public Date getExpiryDate(){
		return expiryDate;
	}
	
	public void setExpiryDate(Date ex){
		this.expiryDate = ex;
	}
	
	public String getName(){
		return fullName;
	}
	
	public void setName(String name){
		this.fullName = name;
	}
	
	public String getAddress(){
		return homeAddress;
	}
	
	public void setAddress(String ha){
		this.homeAddress = ha;
	}
	
}
