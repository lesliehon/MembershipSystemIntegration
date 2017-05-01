package ajcs;

import java.util.Date;

public abstract class Member {
	private String id;
	private Date goodTill;
	private String name;
	private String postal;
	
	public Member(String id , Date goodTill, String name, String postal){
		this.id = id;
		this.goodTill = goodTill;
		this.name = name;
		this.postal = postal;
	}
	
	public abstract boolean validate(String id);
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		if(validate(id))
			this.id = id;
	}
	
	public Date getGoodTill(){
		return goodTill;
	}
	
	public void setGoodTill(Date goodTill){
		this.goodTill = goodTill;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getPostal(){
		return postal;
	}
	
	public void setPostal(String postalAddress){
		this.postal = postalAddress;
	}
}
