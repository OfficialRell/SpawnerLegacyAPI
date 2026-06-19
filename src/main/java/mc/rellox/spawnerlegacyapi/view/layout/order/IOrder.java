package mc.rellox.spawnerlegacyapi.view.layout.order;

import mc.rellox.spawnerlegacyapi.text.content.IContent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public interface IOrder {
	
	IOrder empty = new IOrder() {
		@Override
		public void submit(String type, Supplier<List<IContent>> supplier) {}
		@Override
		public void named(List<IContent> overflow) {}
		@Override
		public List<IContent> build() {return new ArrayList<>();}
	};
	
	/**
	 * Adds the content supplier to the lore line.
	 * 
	 * @param type lore type
	 * @param supplier supplier
	 */
	
	void submit(String type, Supplier<List<IContent>> supplier);
	
	/**
	 * Builds and returns the formatted lore.
	 * 
	 * @return Formatted lore
	 */
	
	List<IContent> build();
	
	/**
	 * Adds the excess name content to the lore, below the name.
	 * 
	 * @param overflow excess name content
	 */
	
	void named(List<IContent> overflow);

}
