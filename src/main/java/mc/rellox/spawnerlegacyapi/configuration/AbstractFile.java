package mc.rellox.spawnerlegacyapi.configuration;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class AbstractFile implements IFile {

    public static AbstractFile of(File yaml) {
        return new AbstractFileImpl(yaml);
    }

    public static AbstractFile of(String name) {
        return new AbstractFileImpl(name);
    }

    public static AbstractFile of(File file, String name) {
        return new AbstractFileImpl(file, name);
    }

    private final File parent;
    private final String name;

    protected File io;
    protected FileConfiguration file;

    private boolean newly;

    public AbstractFile(String name) {
        this(SLAPI.plugin().getDataFolder(), name);
    }

    public AbstractFile(File yaml) {
        this(yaml.getParentFile(), yaml.getName().replace(".yml", ""));
    }

    public AbstractFile(File parent, String name) {
        this.parent = parent;
        this.name = name;
        if(parent == null || name == null || name.isEmpty())
            throw new NullPointerException("cannot initialize abstract file, null parameters");
    }

    @Override
    public IMemory parent() {
        return null;
    }

    public boolean exists() {
        return new File(parent, name + ".yml").exists();
    }

    @Override
    public final void create() {
        newly = false;
        io = new File(parent, name + ".yml");
        if(!io.getParentFile().exists()) io.getParentFile().mkdirs();
        if(!io.exists()) {
            try {
                newly = true;
                io.createNewFile();
            } catch(IOException e) {
                RF.debug(e);
            }
        }
        file = YamlConfiguration.loadConfiguration(io);
    }

    public void load() {
        create();
        file.options().copyDefaults(true);
        initialize();
    }

    /**
     * Initialize the file after creation or loading.<br>
     * Used to set default values or to read values.
     */

    protected abstract void initialize();

    @Override
    public final FileConfiguration file() {
        return file;
    }

    @Override
    public final String name() {
        return name;
    }

    @Override
    public final boolean newly() {
        return newly;
    }

    @Override
    public final void save() {
        try {
            file.save(io);
        } catch(IOException e) {
            RF.debug(e);
        }
    }

    @Override
    public void free() {
        io = null;
        file = null;
    }

    public static class AbstractFileImpl extends AbstractFile {

        public AbstractFileImpl(File yaml) {
            super(yaml);
        }

        public AbstractFileImpl(String name) {
            super(name);
        }

        public AbstractFileImpl(File parent, String name) {
            super(parent, name);
        }

        @Override
        protected void initialize() {}

    }

}
