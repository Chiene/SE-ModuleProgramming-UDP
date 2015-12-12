package Entity;

public class Item extends BaseObject {

	public Item(String _id,String _name,String _x,String _y) {
		// TODO Auto-generated constructor stub
		id = _id;
		name = _name;
		x = _x;
		y = _y;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + name + " " + x + " " + y;
	}

}
