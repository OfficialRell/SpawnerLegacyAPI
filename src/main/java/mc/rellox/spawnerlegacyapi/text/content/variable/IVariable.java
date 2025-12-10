package mc.rellox.spawnerlegacyapi.text.content.variable;

import java.util.function.UnaryOperator;

import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.utility.Calculate;

public interface IVariable {
	
	static IVariable of(String input) {
		if(!input.contains(":")) return new VariableImpl(input);
		
		try {
			var split = input.split(":");
			String key = split[0], suffix = split[1];
			
			// map value as an integer
			if(suffix.equalsIgnoreCase("i")) {
				return IVariable.of(key, text -> {
					var ii = Calculate.toDouble(text);
					if(ii.invalid()) return text;
					return Math.round(ii.get()) + "";
				});
			}
			// map value as a roman numeral
			if(suffix.equalsIgnoreCase("r")) {
				return IVariable.of(key, text -> {
					var ii = Calculate.toDouble(text);
					if(ii.invalid()) return text;
					return Text.roman((int) Math.round(ii.get()));
				});
			}
			// map value as a double
			if(suffix.charAt(0) == '.' && suffix.charAt(1) >= '1' && suffix.charAt(1) <= '9') {
				int i = Integer.parseInt(suffix.charAt(1) + "");
				return IVariable.of(key, text -> {
					var ii = Calculate.toDouble(text);
					if(ii.invalid()) return text;
					return String.format("%." + i + "f", ii.get());
				});
			}
		} catch (Exception e) {}
		throw new NullPointerException("unable to parse variable: " + input);
	}
	
	static IVariable of(String key, UnaryOperator<String> mapper) {
		return new VariableMapped(key, mapper);
	}
	
	/**
	 * @return Variable text key
	 */
	
	String key();
	
	/**
	 * @param text - input text
	 * @return Mapped text
	 */
	
	String map(String text);

}
