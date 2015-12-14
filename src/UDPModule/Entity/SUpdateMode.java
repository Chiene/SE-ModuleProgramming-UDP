package UDPModule.Entity;

import Stub.DOMStub;
import UDPModule.Factory.SpriteCategoryFactory;

public class SUpdateMode extends SActionMode {

	@Override
	public void update(DOMStub dom,String spriteType,String msg) {
		// TODO Auto-generated method stub
		SpriteCategory spriteCategory = SpriteCategoryFactory.getSpriteCategory(spriteType);
		spriteCategory.update(dom, msg);
	}

}
