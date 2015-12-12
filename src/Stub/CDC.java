package Stub;

import java.util.Vector;

import Entity.Sprite;
import Entity.Item;
import Entity.VirtualCharacter;
import Enum.ServerAction;
import Enum.VirtualCharacterDirection;

public class CDC {
	Vector<Sprite> data;
	
	public CDC()
	{
		data = new Vector<Sprite>();
		//Add two users and items to data;
		data.add(new VirtualCharacter("1","user1",VirtualCharacterDirection.EAST.toString(),"1", "0", "0"));
		data.add(new Item("1", "item1",true));
		data.add(new VirtualCharacter("2","user2",VirtualCharacterDirection.WEST.toString(),"1", "0", "0"));
		data.add(new Item("2", "item2",false));
		//Update other user and item;
		data.add(new VirtualCharacter("2","user2",VirtualCharacterDirection.EAST.toString(),"2", "1", "1"));
		data.add(new Item("2", "item2",true));
		
	}
	
	public void startUpdatingThread()
	{
		
	}
	
	public Vector<String> getUpdateInfo()
	{
		Vector<String> updateInfo = new Vector<String>();
		for(int i = 0 ; i < data.size() ;i++) 
		{
			if(i >= 3) 
			{
				updateInfo.add(ServerAction.ADD.toString() + " " +data.get(i).getType() +" " +data.get(i).toString());
			}
			else 
			{
				updateInfo.add(ServerAction.UPDATE.toString() + " " +data.get(i).getType() +" " +data.get(i).toString());
			}		
		}
		return updateInfo;
	}
	
}
