package wlts;

import java.util.Date;

import wlts.*;

import ajcs.*;



public class MembershipAdapter extends Client{
	//An Object Adapter for convert Ajas Member to wtls Client
	
	Member member;
	
	public MembershipAdapter(int cid, Date expiryDate, String fullName,
			String homeAddress) {
		super(cid, expiryDate, fullName, homeAddress);
		// TODO Auto-generated constructor stub
	}
	
	public MembershipAdapter(Member m){
		this(0, null, null, null);
		this.member = m;
	}

@Override
	
	public int getCid(){ return Integer.parseInt(member.getId()); }

@Override
	public void setCid(int cid){ member.setId(String.valueOf(cid)); }
	
@Override
	public Date getExpiryDate(){ return member.getGoodTill(); }
	
@Override
	public void setExpiryDate(Date ex){ member.setGoodTill(ex); }
	
@Override
	public String getName(){ return member.getName(); }

@Override
	public void setName(String name){ member.setName(name); }
	
@Override
	public String getAddress(){ return member.getPostal(); }

@Override
	public void setAddress(String ha){ member.setPostal(ha); }
	
@Override
	public boolean validate(int cid) { return member.validate(String.valueOf(cid) ); }
	

}
