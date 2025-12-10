package mc.rellox.spawnerlegacyapi.text.content.variable;

import java.util.function.UnaryOperator;

public record VariableMapped(String key, UnaryOperator<String> mapper) implements IVariable {
	
	@Override
	public String map(String text) {
		return mapper.apply(text);
	}
	
}
