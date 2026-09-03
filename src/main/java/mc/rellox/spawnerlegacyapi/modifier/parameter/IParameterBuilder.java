package mc.rellox.spawnerlegacyapi.modifier.parameter;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;

import java.util.function.Function;
import java.util.function.Predicate;

public interface IParameterBuilder<T> {

    /**
     * Sets the default values for the parameter.
     *
     * @param defaults default values
     * @return This builder
     */

    IParameterBuilder<T> defaults(String... defaults);

    /**
     * Sets the parser function for the parameter.
     *
     * @param parser parser function
     * @return This builder
     */

    IParameterBuilder<T> parser(Function<String, T> parser);

    /**
     * Sets the validator predicate for the parameter.
     *
     * @param validator validator predicate
     * @return This builder
     */

    IParameterBuilder<T> validator(Predicate<Object> validator);

    /**
     * Sets the item placeholder replacer for the parameter.
     *
     * @param replacer replacer
     * @return This builder
     */

    IParameterBuilder<T> replacer(IParameterReplacer replacer);

    /**
     * Sets the fallback value for the parameter.
     *
     * @param fallback fallback value
     * @return This builder
     */

    IParameterBuilder<T> fallback(T fallback);

    /**
     * Builds the parameter.
     *
     * @return The built parameter
     */

    IParameter<T> build();

    interface IParameterReplacer {

        void replace(ItemBuilder builder, String id, Object value);

    }

}
