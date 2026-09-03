package mc.rellox.spawnerlegacyapi.price;

import java.util.Locale;

public enum PriceType {

    EXPERIENCE,
    LEVELS,
    MATERIAL,
    ECONOMY,
    FLARE_TOKENS,
    DEFINED_ITEM;

    public String key() {
        return name().replace('_', '-').toLowerCase(Locale.ROOT);
    }

    @Override
    public String toString() {
        return name();
    }

    public static PriceType of(String name) {
        try {
            if(name.equalsIgnoreCase("MONEY")) return ECONOMY;
            if(name.equalsIgnoreCase("ITEM")) return MATERIAL;
            return valueOf(name.toUpperCase(Locale.ROOT));
        } catch(Exception ignored) {}
        return null;
    }

}
