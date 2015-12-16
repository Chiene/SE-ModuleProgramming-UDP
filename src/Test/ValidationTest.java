package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import UDPModule.Enum.ServerActionType;
import UDPModule.Enum.SpriteType;
import UDPModule.Tool.Validation;

public class ValidationTest {

	@Test
	public void testAddItemValidation() {
		String addItem = ServerActionType.ADD.toString() + " " + SpriteType.ITEM.toString() + " " + "User2 2 2";
		assertTrue(Validation.validateUpdateMsg(addItem));

	}

	@Test
	public void testAddVCValidation() {
		String addVC = ServerActionType.ADD.toString() + " " + SpriteType.VIRTUALCHARACTER.toString() + " "
				+ "User2 2 2";
		assertTrue(Validation.validateUpdateMsg(addVC));

	}

	@Test
	public void testUpdateItemValidation() {
		String updateItem = ServerActionType.UPDATE.toString() + " " + SpriteType.ITEM.toString() + " " + "User2 2 2";
		assertTrue(Validation.validateUpdateMsg(updateItem));

	}

	@Test
	public void testUpdateVcValidation() {
		String UpdateVC = ServerActionType.UPDATE.toString() + " " + SpriteType.VIRTUALCHARACTER.toString() + " "
				+ "User2 2 2";
		assertTrue(Validation.validateUpdateMsg(UpdateVC));
	}
}
