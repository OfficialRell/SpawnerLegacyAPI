package mc.rellox.spawnerlegacyapi.view.layout;

import java.util.List;
import java.util.function.Consumer;

import org.bukkit.inventory.Inventory;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.text.content.IContent;
import mc.rellox.spawnerlegacyapi.utility.ISave;

public interface ILayout extends ISave {
	
	/**
	 * @param slot - slot
	 */
	
	void set(ISlot slot);
	
	/**
	 * @param slot - inventory slot
	 * @param field - layout field
	 * @return {@code true} if this slot is defined by this layout field
	 */
	
	boolean is(int slot, SlotField field);
	
	/**
	 * @return All defined slots
	 */
	
	List<ISlot> all();
	
	/**
	 * @param field - layout field
	 * @return Slot of this layout field or {@code null}
	 */
	
	ISlot get(SlotField field);
	
	/**
	 * @return Rows of this layout
	 */
	
	int rows();
	
	/**
	 * @param field - layout field
	 * @return All slots occupied by this layout field or {@code null}
	 */
	
	int[] slots(SlotField field);
	
	/**
	 * Fills all slots with this item stack.
	 * 
	 * @param inventory - inventory
	 * @param field - layout field
	 * @param modifier - item modifier
	 */
	
	void fill(Inventory inventory, SlotField field, Consumer<ItemBuilder> modifier);
	
	/**
	 * Fills all slots with this item stack with an amount.
	 * 
	 * @param inventory - inventory
	 * @param field - layout field
	 * @param modifier - item modifier
	 * @param a - amount
	 */
	
	void fill(Inventory inventory, SlotField field, Consumer<ItemBuilder> modifier, int a);
	
	/**
	 * @param field - layout field
	 * @return {@code true} if this layout field is defined
	 */
	
	boolean defined(SlotField field);
	
	/**
	 * @return Slot data of the background
	 */
	
	IBackground background();
	
	/**
	 * Fills in all background slots.
	 */
	
	void fill(Inventory inventory);
	
	/**
	 * @param name - name of the inventory
	 * @return Newly created inventory
	 */
	
	Inventory create(IContent name);
	
	/**
	 * Gets the meta data of this layout.
	 * 
	 * @param <T> - data type
	 * @param key - data key
	 * @param type - parser
	 * @return Meta data object or {@code null}
	 */
	
	<T> T meta(String key, IViewMeta<T> type);
	
	/**
	 * Sets meta data to this layout.
	 * 
	 * @param <T> - data type
	 * @param key - data key
	 * @param type - parser
	 * @param value - meta value
	 */
	
	<T> void meta(String key, IViewMeta<T> type, T value);

}
