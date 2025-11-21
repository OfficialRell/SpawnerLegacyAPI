package mc.rellox.spawnerlegacyapi.item;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mc.rellox.spawnerlegacyapi.configuration.IFile;
import mc.rellox.spawnerlegacyapi.text.Text;
import mc.rellox.spawnerlegacyapi.text.content.ContentParser;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

@SuppressWarnings("deprecation")
public final class ItemMatcher {
	
	public static final ItemMatcher DEFAULT = new ItemMatcher(Material.GOLD_INGOT);
	
	public static void parse(ItemStack item, IFile file, String path) {
		if(item == null) return;
		file.set(path + ".material", item.getType().name());
		ItemMeta meta = item.getItemMeta();
		if(meta != null) {
			if(meta.hasDisplayName()) file.set(path + ".name", meta.getDisplayName());
			if(meta.hasCustomModelData()) file.set(path + ".model", meta.getCustomModelData());
		}
	}
	
	public static ItemMatcher from(IFile file, String path) {
		if(file == null) return DEFAULT;
		Material material = file.getMaterial(path + ".material");
		if(material == null) return DEFAULT;
		ItemMatcher matcher = new ItemMatcher(material);
		String name = file.getString(path + ".name");
		if(name != null && !name.isEmpty()) 
			matcher.name(ContentParser.parse(name));
		List<String> lore = file.getStrings(path + ".lore");
		if(lore != null && !lore.isEmpty())
			matcher.lore(ContentParser.parse(lore));
		int model = file.getInteger(path + ".model");
		if(model > 0) matcher.model(model);
		return matcher;
	}
	
	private final Material material;
	private final List<MatchData> matchers;
	
	protected ItemMatcher(Material material) {
		this.material = material;
		this.matchers = new LinkedList<>();
	}
	
	private ItemMatcher match(MatchData m) {
		matchers.add(m);
		return this;
	}
	
	protected ItemMatcher model(final int m) {
		match(new MatchData() {
			@Override
			public boolean match(ItemMeta meta) {
				return meta.getCustomModelData() == m;
			}
			@Override
			public void modify(ItemMeta meta) {
				meta.setCustomModelData(m);
			}
		});
		return this;
	}
	
	protected ItemMatcher name(IContent name) {
		match(new MatchData() {
			String s = ChatColor.stripColor(name.text());
			@Override
			public boolean match(ItemMeta meta) {
				String in = meta.getDisplayName();
				return ChatColor.stripColor(in).equals(s);
			}
			@Override
			public void modify(ItemMeta meta) {
				meta.setDisplayName(name.text());
			}
		});
		return this;
	}
	
	protected ItemMatcher lore(List<IContent> lore) {
		match(new MatchData() {
			List<String> ss = lore.stream()
					.map(IContent::text)
					.map(ChatColor::stripColor)
					.toList();
			@Override
			public boolean match(ItemMeta meta) {
				List<String> list = meta.getLore();
				if(list == null || list.isEmpty()
						|| list.size() != lore.size()) return false;
				return IntStream.range(0, ss.size())
						.allMatch(i -> ChatColor.stripColor(list.get(i)).equals(ss.get(i)));
			}
			@Override
			public void modify(ItemMeta meta) {
				meta.setLore(Text.toText(lore));
			}
		});
		return this;
	}
	
	public boolean match(ItemStack item) {
		if(item == null || item.getType() != material) return false;
		ItemMeta meta = item.getItemMeta();
		return meta == null ? false : matchers.stream().allMatch(m -> m.match(meta));
	}
	
	public ItemStack refund() {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		if(meta == null) return item;
		matchers.forEach(m -> m.modify(meta));
		item.setItemMeta(meta);
		return item;
	}
	
	protected interface MatchData {
		
		boolean match(ItemMeta meta);
		
		void modify(ItemMeta meta);
		
	}

}
