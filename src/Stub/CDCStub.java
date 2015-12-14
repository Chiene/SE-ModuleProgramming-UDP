package Stub;

import java.util.Vector;

import Entity.Sprite;
import Entity.Item;
import Entity.VirtualCharacter;
import Enum.ServerActionType;
import Enum.VirtualCharacterDirection;

public class CDCStub {
	Vector<String> data;

	public CDCStub() {
		data = new Vector<String>();
		// Add two users and items to data;
	}

	// Use for testing
	public void insertData(String msg) {
		data.add(msg);
	}

	public void clearData() {
		data.clear();
	}

	//
	public Vector<String> getUpdateInfo() {
		Vector<String> updateInfo = data;
		return updateInfo;
	}

}
