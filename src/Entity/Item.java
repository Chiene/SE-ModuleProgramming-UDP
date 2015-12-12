package Entity;

public class Item extends Sprite {

	boolean isShared ;
	public Item(String _id,String _name,boolean _isShared) {
		// TODO Auto-generated constructor stub
		id = _id;
		name = _name;
		isShared = _isShared;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + name + " " + String.valueOf(isShared);
	}

}
