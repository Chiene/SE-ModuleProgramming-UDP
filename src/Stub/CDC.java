package Stub;

import java.util.Vector;

import Entity.Sprite;
import Entity.Item;
import Entity.VirtualCharacter;
import Enum.VirtualCharacterDirection;

public class CDC {
	Vector<Sprite> data;
	
	public CDC()
	{
		data = new Vector<Sprite>();
		data.add(new VirtualCharacter("1","user1",VirtualCharacterDirection.EAST.toString(),"1", "0", "0"));
		data.add(new Item("1", "item1",false));
	}
	
	public void startUpdatingThread()
	{
		
	}
	
	public Vector<Sprite> getUpdateInfo()
	{
		return data;
	}
	
}
