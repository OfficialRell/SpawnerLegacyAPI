package mc.rellox.spawnerlegacyapi.configuration.settings;

import mc.rellox.spawnerlegacyapi.configuration.filter.IFilterContext;

public interface IValueHeld<J> extends IValue<IHeldValue<J>> {

	default J get(IFilterContext context, HolderType holder) {
		return get(context).get(holder);
	}
	
}
