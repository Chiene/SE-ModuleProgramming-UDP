package Stub;

import Interface.IDOM;

public class DOMStub implements IDOM{
	public DOMStub() {
		// TODO Auto-generated constructor stub
	}

	public void addVirtualCharacter(String msg) {
		System.out.println("addVirtualCharacter " + msg);
	}

	public void addItem(String msg) {
		System.out.println("addItem " + msg);
	}

	public void updateVirtualCharacter(String msg) {
		System.out.println("updateVirtualCharacter " + msg);
	}

	public void updateItem(String msg) {
		System.out.println("updateItem " + msg);
	}

}
