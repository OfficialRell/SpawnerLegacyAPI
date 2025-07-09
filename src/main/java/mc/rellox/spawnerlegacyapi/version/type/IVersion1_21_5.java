package mc.rellox.spawnerlegacyapi.version.type;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import mc.rellox.spawnerlegacyapi.utility.reflect.Reflect.RF;
import mc.rellox.spawnerlegacyapi.utility.reflect.type.Accessor;
import mc.rellox.spawnerlegacyapi.utility.reflect.type.Construct;
import mc.rellox.spawnerlegacyapi.utility.reflect.type.Invoker;
import mc.rellox.spawnerlegacyapi.version.IVersion;

public class IVersion1_21_5 implements IVersion {
	
	private static final Class<?> _entity = RF.get("net.minecraft.world.entity.Entity");
	
	private static final Invoker<?> _player = RF.order(RF.craft_player(), "getHandle");
	private static final Accessor<?> _connection = RF.access(_player.returns(), "g");
	private static final Invoker<?> _send = RF.order(_connection.type(), "b",
			RF.get("net.minecraft.network.protocol.Packet"));

	@Override
	public void send(Collection<? extends Player> players, Object... os) {
		boolean single = os.length == 1;
		players.forEach(player -> {
			Object handle = _player.objected(player);
			Object connection = _connection.objected(handle);
			if(single == true) _send.objected(connection, os[0]);
			else Stream.of(os).forEach(packet -> _send.objected(connection, packet));
		});
	}

	@Override
	public Object spawn(Object entity) {
		
		Class<?> a = RF.get("net.minecraft.network.protocol.game.PacketPlayOutSpawnEntity");
		
		Class<?> b = RF.get("net.minecraft.world.entity.Entity");
		
		Class<?> c = RF.get("net.minecraft.core.BlockPosition");
		
		Object d = RF.fetch(c, "c"); // empty block position
		
		Object m = RF.build(a, b, int.class, c).instance(entity, 0, d);
		
		double x = RF.direct(entity, "dC", double.class);
		RF.access(m, "g", double.class).set(x);
		double y = RF.direct(entity, "dE", double.class);
		RF.access(m, "h", double.class).set(y);
		double z = RF.direct(entity, "dI", double.class);
		RF.access(m, "i", double.class).set(z);
		
		return m;
	}
	
	private static final Invoker<Entity> _bukkit_entity = RF.order(_entity, "getBukkitEntity").as(Entity.class);
	private static final Invoker<?> _datawatcher = RF.order(_entity, "au");
	private static final Invoker<?> _datawatcher_items = RF.order(_datawatcher.returns(), "c");
	private static final Construct<?> _metadata = RF.build(RF.get("net.minecraft.network.protocol.game.PacketPlayOutEntityMetadata"),
			int.class, List.class);

	@Override
	public Object meta(Object entity) {
		Entity bukkit = _bukkit_entity.objected(entity);
		int id = bukkit.getEntityId();
		Object datawatcher = _datawatcher.objected(entity);
		Object items = _datawatcher_items.objected(datawatcher);
		Object packet = _metadata.instance(id, items);
		return packet;
	}

	@Override
	public Object destroy(Object entity) {

		Class<?> a = RF.get("net.minecraft.network.protocol.game.PacketPlayOutEntityDestroy");

		Entity bukkit = RF.direct(entity, "getBukkitEntity", Entity.class);
		int b = bukkit.getEntityId();
		
		Object c = RF.build(a, int[].class).instance(new int[] {b});
		
		return c;
	}

	@Override
	public Object hologram(Location l, String name) {
		
		Class<?> a = RF.get("net.minecraft.world.level.World");
		
		Object b = RF.direct(l.getWorld(), "getHandle");
		
		Class<?> c = RF.get("net.minecraft.world.entity.decoration.EntityArmorStand");
		
		Object d = RF.build(c, a, double.class, double.class, double.class)
				.instance(b, l.getX(), l.getY(), l.getZ());
		
		RF.order(d, "v", boolean.class).invoke(true); // marker
		RF.order(d, "l", boolean.class).invoke(true); // invisible
		name(d, name);
		RF.order(d, "p", boolean.class).invoke(true); // set custom name visible
		
		return d;
	}
	private static final Invoker<?> _component = RF.order(RF.craft("util.CraftChatMessage"),
			"fromStringOrNull", String.class);
	private static final Invoker<?> _rename = RF.order(_entity,
			"b", RF.get("net.minecraft.network.chat.IChatBaseComponent"));
	
	@Override
	public void name(Object entity, String name) {
		_rename.objected(entity, _component.invoke(name));
	}

}
