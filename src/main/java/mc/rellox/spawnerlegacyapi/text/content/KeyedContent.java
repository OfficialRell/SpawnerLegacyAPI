package mc.rellox.spawnerlegacyapi.text.content;

public record KeyedContent(String key, IContent content) implements IContent {

	@Override
	public String text(Variables variables) {
		return content.text(variables);
	}

}
