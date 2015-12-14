package Stub;

import java.util.Vector;

import Entity.Sprite;
import Entity.Item;
import Entity.VirtualCharacter;
import Enum.ServerActionType;
import Enum.VirtualCharacterDirection;

public class CDC {
	Vector<String> data;
	
	public CDC()
	{
		data = new Vector<String>();
		//Add two users and items to data;
	}
	
	public void startUpdatingThread()
	{
		
	}
	
	//Use for testing
	
	public void insertData(String msg) {
		data.add(msg);
	}
	
	public void clearData() {
		data.clear();
	}
	
	//
	public Vector<String> getUpdateInfo()
	{
		Vector<String> updateInfo = data;
		return updateInfo;
	}
	
}
