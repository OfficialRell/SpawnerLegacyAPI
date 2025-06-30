package mc.rellox.spawnerlegacyapi.view.layout;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface ISlot extends ISave {
	
	/**
	 * @return Slot field
	 */
	
	SlotField field();
	
	/**
	 * @return Layout field of this slot
	 */
	
	ItemBuilder[] items();
	
	/**
	 * @return Indecees of this slot
	 */
	
	int[] slots();
	
	/**
	 * @param slot - slot index
	 * @return {@code true} if this slot has this index
	 */
	
	boolean is(int slot);
}
