package mc.rellox.spawnerlegacyapi.version;

import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;
import org.bukkit.Bukkit;

public final class Version {

    public static final String server;

    public static final VersionType TYPE;
    public static final IVersion INSTANCE;

    static {
        String s = Bukkit.getServer().getClass().getPackage().getName();
        server = s.substring(s.lastIndexOf('.') + 1);
        String bukkit = Bukkit.getBukkitVersion();

        if(bukkit.startsWith("26.3")) TYPE = VersionType.v_26_3;
        else if(bukkit.startsWith("26.2")) TYPE = VersionType.v_26_2;
        else if(bukkit.startsWith("26.1.2")
                || bukkit.startsWith("26.1.1")
                || bukkit.startsWith("26.1")) TYPE = VersionType.v_26_1;
        else if(server.contains("v1_21_R7")
                || bukkit.startsWith("1.21.11-R0.1")) TYPE = VersionType.v_21_7;
        else if(server.contains("v1_21_R6")
                || bukkit.startsWith("1.21.9-R0.1")
                || bukkit.startsWith("1.21.10-R0.1")) TYPE = VersionType.v_21_6;
        else if(server.contains("v1_21_R5")
                || bukkit.startsWith("1.21.6-R0.1")
                || bukkit.startsWith("1.21.7-R0.1")
                || bukkit.startsWith("1.21.8-R0.1")) TYPE = VersionType.v_21_5;
        else if(server.contains("v1_21_R4")
                || bukkit.startsWith("1.21.5-R0.1")) TYPE = VersionType.v_21_4;
        else if(server.contains("v1_21_R3")
                || bukkit.startsWith("1.21.4-R0.1")) TYPE = VersionType.v_21_3;
        else if(server.contains("v1_21_R2")
                || bukkit.startsWith("1.21.3-R0.1")) TYPE = VersionType.v_21_2;
        else if(server.contains("v1_21_R1")
                || bukkit.startsWith("1.21-R0.1")
                || bukkit.startsWith("1.21.1-R0.1")) TYPE = VersionType.v_21_1;
        else if(server.contains("v1_20_R4")
                || bukkit.startsWith("1.20.6-R0.1")) TYPE = VersionType.v_20_4;
        else TYPE = null;

        if(TYPE == null) {
            INSTANCE = new NullVersion(last());
            Bukkit.getLogger().warning("[SpawnerLegacy] Missing NMS classes, "
                    + "holograms and version specific features will not work!");
        } else
            INSTANCE = TYPE.build();
    }

    private static VersionType last() {
        VersionType[] values = VersionType.values();
        return values[values.length - 1];
    }

    public static IVersion latest() {
        return last().build();
    }

    public static boolean atLeast(VersionType type) {
        return TYPE != null && TYPE.atLeast(type);
    }

    public enum VersionType {

        @Deprecated(since = "4.0.0", forRemoval = true)
        v_20_1,
        @Deprecated(since = "4.0.0", forRemoval = true)
        v_20_2,
        @Deprecated(since = "4.0.0", forRemoval = true)
        v_20_3,
        v_20_4,
        v_21_1, v_21_2, v_21_3, v_21_4, v_21_5, v_21_6, v_21_7,
        v_26_1, v_26_2, v_26_3;

        public boolean atLeast(VersionType type) {
            return ordinal() >= type.ordinal();
        }

        private IVersion build() {
            String clazz;
            if(atLeast(v_26_1)) clazz = "IVersion26";
            else clazz = "IVersion1" + name().substring(1);
            return RF.build("mc.rellox.spawnerlegacy.version." + clazz)
                    .as(IVersion.class)
                    .instance();
        }

    }

}
