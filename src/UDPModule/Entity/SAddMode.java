package UDPModule.Entity;

import Enum.SpriteType;
import Stub.DOM;
import UDPModule.Factory.SpriteCategoryFactory;

public class SAddMode extends SActionMode{

	@Override
	public void update(DOM dom,String spriteType,String msg) {
		// TODO Auto-generated method stub
		SpriteCategory spriteCategory = SpriteCategoryFactory.getSpriteCategory(spriteType);
		spriteCategory.add(dom,msg);
	}

}
