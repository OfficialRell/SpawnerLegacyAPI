package mc.rellox.spawnerlegacyapi.modifier.effect.parameter;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface IParameterBuilder<T> {

    IParameterBuilder<T> key(String key);

    IParameterBuilder<T> type(IParameterType<T> type);

    IParameterBuilder<T> parse(Function<String, T> parse);

    IParameterBuilder<T> valid(Predicate<Object> valid);

    IParameterBuilder<T> list(List<String> list);

    IParameterBuilder<T> replace(BiConsumer<ItemBuilder, Object> replace);

    IParameter<T> build();

}

