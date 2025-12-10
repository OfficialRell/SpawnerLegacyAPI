package mc.rellox.spawnerlegacyapi.text.content.variable;

public record VariableImpl(String key) implements IVariable {
	
	@Override
	public String map(String text) {
		return text;
	}

}
