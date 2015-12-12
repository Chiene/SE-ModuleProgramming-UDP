package Entity;

public class VirtualCharacter extends Sprite {
	String direction ;
	String speed = "0";
	
	public VirtualCharacter(String _id,String _name,String _dir,String _speed,String _x,String _y) {
		// TODO Auto-generated constructor stub
		id = _id;
		name = _name;
		direction = _dir;
		speed = _speed;
		x = _x;
		y = _y;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + name + " " + direction +" " + speed + " " + x + " " + y;
	}
	
}
