package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import UDPModule.Enum.ServerCommandType;
import UDPModule.Enum.SpriteType;
import UDPModule.Tool.Validation;

public class ValidationTest {

	@Test
	public void testAddItemValidation() {
		String addItem = ServerCommandType.ADD.toString() + " " + SpriteType.ITEM.toString() + " " + "User2 2 2";
		assertTrue(Validation.validateUpdateMsg(addItem));

	}

	@Test
	public void testAddVCValidation() {
		String addVC = ServerCommandType.ADD.toString() + " " + SpriteType.VIRTUALCHARACTER.toString() + " "
				+ "User2 2 2";
		assertTrue(Validation.validateUpdateMsg(addVC));

	}

	@Test
	public void testUpdateItemValidation() {
		String updateItem = ServerCommandType.UPDATE.toString() + " " + SpriteType.ITEM.toString() + " " + "User2 2 2";
		assertTrue(Validation.validateUpdateMsg(updateItem));

	}

	@Test
	public void testUpdateVcValidation() {
		String UpdateVC = ServerCommandType.UPDATE.toString() + " " + SpriteType.VIRTUALCHARACTER.toString() + " "
				+ "User2 2 2";
		assertTrue(Validation.validateUpdateMsg(UpdateVC));
	}
}
