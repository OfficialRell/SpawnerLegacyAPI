package mc.rellox.spawnerlegacyapi.view.layout;

import mc.rellox.spawnerlegacyapi.SLAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public interface IViewMeta<T> {

    Map<String, IViewMeta<?>> VALUES = new HashMap<>();

    IViewMeta<Byte> BYTE = a("BYTE", IViewMeta::parseByte);
    IViewMeta<Short> SHORT = a("SHORT", IViewMeta::parseShort);
    IViewMeta<Integer> INTEGER = a("INTEGER", IViewMeta::parseInteger);
    IViewMeta<Long> LONG = a("LONG", IViewMeta::parseLong);
    IViewMeta<Float> FLOAT = a("FLOAT", IViewMeta::parseFloat);
    IViewMeta<Double> DOUBLE = a("DOUBLE", IViewMeta::parseDouble);
    IViewMeta<String> STRING = a("STRING", o -> o == null ? null : o.toString());
    IViewMeta<byte[]> BYTE_ARRAY = a("BYTE_ARRAY", o -> {
        List<Byte> list = toParsed(o, IViewMeta::parseByte);
        if(list.isEmpty()) return null;
        byte[] is = new byte[list.size()];
        for(int i = 0; i < is.length; i++) is[i] = list.get(i);
        return is;
    });
    IViewMeta<int[]> INTEGER_ARRAY = a("INTEGER_ARRAY", o -> {
        List<Integer> list = toParsed(o, IViewMeta::parseInteger);
        if(list.isEmpty()) return null;
        int[] is = new int[list.size()];
        for(int i = 0; i < is.length; i++) is[i] = list.get(i);
        return is;
    });
    IViewMeta<short[]> SHORT_ARRAY = a("SHORT_ARRAY", o -> {
        List<Short> list = toParsed(o, IViewMeta::parseShort);
        if(list.isEmpty()) return null;
        short[] is = new short[list.size()];
        for(int i = 0; i < is.length; i++) is[i] = list.get(i);
        return is;
    });
    IViewMeta<long[]> LONG_ARRAY = a("LONG_ARRAY", o -> {
        List<Long> list = toParsed(o, IViewMeta::parseLong);
        if(list.isEmpty()) return null;
        long[] is = new long[list.size()];
        for(int i = 0; i < is.length; i++) is[i] = list.get(i);
        return is;
    });
    IViewMeta<float[]> FLOAT_ARRAY = a("FLOAT_ARRAY", o -> {
        List<Float> list = toParsed(o, IViewMeta::parseFloat);
        if(list.isEmpty()) return null;
        float[] is = new float[list.size()];
        for(int i = 0; i < is.length; i++) is[i] = list.get(i);
        return is;
    });
    IViewMeta<double[]> DOUBLE_ARRAY = a("DOUBLE_ARRAY", o -> {
        List<Double> list = toParsed(o, IViewMeta::parseDouble);
        if(list.isEmpty()) return null;
        double[] is = new double[list.size()];
        for(int i = 0; i < is.length; i++) is[i] = list.get(i);
        return is;
    });
    IViewMeta<String[]> STRING_ARRAY = a("STRING_ARRAY", o -> {
        if(o instanceof String s) return new String[] {s};
        if(o instanceof List<?> l) return l.stream()
                .map(Object::toString)
                .toArray(String[]::new);
        return null;
    });
    IViewMeta<IViewItem> ITEM = a("ITEM", o -> {
        if(o instanceof String s) return SLAPI.layouts().item(s);
        return null;
    });

    private static <T> IViewMeta<T> a(String name, IViewMeta<T> type) {
        VALUES.put(name, type);
        return type;
    }

    /**
     * Parses the given object.
     * The object can be a regular object, a list or any primitive wrapper.
     *
     * @param object - object
     * @return Parsed data
     */

    T parse(Object object);

    /**
     * Converts the input value to a valid savable value.
     *
     * @param value - value to save
     * @return Converted value
     */

    default Object savable(T value) {
        if(value instanceof Object[] array) return List.of(array);
        if(value instanceof IViewItem item) return item.id();
        return value;
    }

    /**
     * @return Name of this view meta constant
     */

    default String name() {
        return VALUES.entrySet().stream()
                .filter(e -> e.getValue().equals(this))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private static <R> List<R> toParsed(Object object, Function<Object, R> f) {
        Stream<?> stream;
        if(object instanceof List<?> list) stream = list.stream();
        else stream = Stream.of(object);
        return stream
                .map(f)
                .filter(Objects::nonNull)
                .toList();
    }

    private static Byte parseByte(Object o) {
        if(o instanceof Number n) return n.byteValue();
        try {
            return Byte.parseByte(o.toString());
        } catch(Exception ignored) {}
        return null;
    }

    private static Short parseShort(Object o) {
        if(o instanceof Number n) return n.shortValue();
        try {
            return Short.parseShort(o.toString());
        } catch(Exception ignored) {}
        return null;
    }

    private static Integer parseInteger(Object o) {
        if(o instanceof Number n) return n.intValue();
        try {
            return Integer.parseInt(o.toString());
        } catch(Exception ignored) {}
        return null;
    }

    private static Long parseLong(Object o) {
        if(o instanceof Number n) return n.longValue();
        try {
            return Long.parseLong(o.toString());
        } catch(Exception ignored) {}
        return null;
    }

    private static Float parseFloat(Object o) {
        if(o instanceof Number n) return n.floatValue();
        try {
            return Float.parseFloat(o.toString());
        } catch(Exception ignored) {}
        return null;
    }

    private static Double parseDouble(Object o) {
        if(o instanceof Number n) return n.doubleValue();
        try {
            return Double.parseDouble(o.toString());
        } catch(Exception ignored) {}
        return null;
    }

}
