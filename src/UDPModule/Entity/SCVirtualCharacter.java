package UDPModule.Entity;

import Stub.DOM;

public class SCVirtualCharacter extends SpriteCategory{


	@Override
	public void add(DOM dom,String msg) {
		// TODO Auto-generated method stub
		dom.addVirtualCharacter(msg);
	}

	@Override
	public void update(DOM dom,String msg) {
		// TODO Auto-generated method stub
		dom.updateVirtualCharacter(msg);
	}

}
