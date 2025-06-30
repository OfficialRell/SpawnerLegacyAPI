package mc.rellox.spawnerlegacyapi.view.layout.order;

import java.util.List;

public interface IOrderKeys {
	
	/**
	 * @return List of lore order
	 */
	
	List<String> keys();
	
	/**
	 * @return New lore orderer
	 */
	
	IOrder oderer();

}
