package mc.rellox.spawnerlegacyapi.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import mc.rellox.spawnerlegacyapi.SLAPI;
import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;

public abstract class AbstractFile implements IFile {
	
	public static AbstractFile of(File yaml) {
		return new AbstractFile(yaml) {
			@Override
			protected void initialize() {}
		};
	}
	
	public static AbstractFile of(String name) {
		return new AbstractFile(name) {
			@Override
			protected void initialize() {}
		};
	}
	
	private final File parent;
	private final String name;
	
	private File f;
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
	
	public boolean exists() {
		return new File(parent, name + ".yml").exists();
	}
	
	@Override
	public final void create() {
		newly = false;
		f = new File(parent, name + ".yml");
		if(!f.getParentFile().exists()) f.getParentFile().mkdirs();
		if(!f.exists()) {
			try {
				newly = true;
				f.createNewFile();
			} catch(IOException e) {
				RF.debug(e);
			}
		}
		file = YamlConfiguration.loadConfiguration(f);
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
			file.save(f);
		} catch(IOException e) {
			RF.debug(e);
		}
	}
	
	@Override
	public void free() {
		f = null; file = null;
	}

}
