package mc.rellox.spawnerlegacyapi.spawner.type;

import java.util.Locale;

public enum StackingType {

    INFINITE,
    FINITE;

    public static StackingType of(String name, StackingType fallback) {
        try {
            return valueOf(name.toUpperCase(Locale.ROOT));
        } catch(Exception ignored) {}
        return fallback;
    }

}
