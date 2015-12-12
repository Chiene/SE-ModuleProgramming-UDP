package Stub;

import java.util.Vector;

import Entity.BaseObject;
import Entity.Item;
import Entity.User;

public class CDC {
	Vector<BaseObject> data;
	
	public CDC()
	{
		data = new Vector<BaseObject>();
		data.add(new User("1", "user1", "0", "0"));
		data.add(new Item("1", "item1", "0", "0"));
	}
	
	public void startUpdatingThread()
	{
		
	}
	
	public Vector<BaseObject> getUpdateInfo()
	{
		return data;
	}
	
}
