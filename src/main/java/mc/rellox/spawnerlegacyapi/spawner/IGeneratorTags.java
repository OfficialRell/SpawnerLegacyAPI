package mc.rellox.spawnerlegacyapi.spawner;

import java.util.stream.Stream;

/**
 * This interface allows to apply permanent and temporary tags to a {@link IGenerator}.<br>
 * <b>Permanent</b> tags will be saved on the spawner, even after server restart.<br>
 * <b>Temporary</b> tags will only exist while the spawner is loaded, once it gets unloaded (by server, by chunks or removed)
 * the tags will no longer be present on the spawner.
 */

public interface IGeneratorTags {

	/**
	 * Returns the tags this generator has.<br>
	 * If permanent is {@code false} then it will return only temporary tags.
	 * 
	 * @param permanent - permanent
	 * @return Permanent or temporary tags
	 */
	
	int tags(boolean permanent);
	
	/**
	 * @return Permanent tags
	 */
	
	default int tags() {
		return tags(true);
	}
	
	/**
	 * @return Array of only permanent tags
	 */
	
	default Tag[] array() {
		return array(true);
	}
	
	/**
	 * @param permanent - permanent
	 * @return Array of permanent or temporary tags
	 */
	
	default Tag[] array(boolean permanent) {
		return Tag.of(tags(permanent));
	}
	
	/**
	 * Append the tag to this generator and saves it.<br>
	 * If permanent is {@code false} then the tag will be set temporarily,
	 * and will not be saved on the spawner.<br>
	 * This will not update the generator.
	 * 
	 * @param tag - tag
	 * @param permanent - permanent
	 */
	
	void tag(Tag tag, boolean permanent);

	/**
	 * Append the tag to this generator as permanent and saves it.<br>
	 * This will not update the generator.
	 * 
	 * @param tag - tag
	 */
	
	default void tag(Tag tag) {
		tag(tag, true);
	}
	
	/**
	 * Remove the tag from this generator and saves it.<br>
	 * If permanent is {@code false} then the temporary tag will be removed.
	 * 
	 * @param tag - tag
	 * @param permanent - permanent
	 */
	
	void untag(Tag tag, boolean permanent);
	
	/**
	 * Remove permanent tag from this generator and saves it.
	 * 
	 * @param tag - tag
	 */
	
	default void untag(Tag tag) {
		untag(tag, true);
	}
	
	/**
	 * @param tag - tag
	 * @param permanent - permanent
	 * @return {@code true} if the tag matches
	 */
	
	default boolean tagged(Tag tag, boolean permanent) {
		return (tags(permanent) & tag.index()) != 0;
	}
	
	/**
	 * @param tag - tag
	 * @return {@code true} if and only if the permanent tag matches
	 */
	
	default boolean tagged(Tag tag) {
		return tagged(tag, true);
	}
	
	/**
	 * @param tag - tag
	 * @return {@code true} if the permanent or temporary tag matches
	 */
	
	default boolean match(Tag tag) {
		return tagged(tag, true) || tagged(tag, false);
	}
	
	/**
	 * Tag enum class.
	 * Constant count should not surpass 32.
	 */
	
	enum Tag {
		
		/**
		 * Will not reduce spawner ticks, making the spawner unable to spawn entities
		 * and reduce spawner ticks.
		 */
		TICKING_DISABLE,
		/**
		 * Will not allow the spawner to spawn entities.
		 */
		SPAWNING_DISABLE,
		/**
		 * Disables access to spawner upgrades GUI.
		 */
		UPGRADES_DISABLE,
		/**
		 * Disables spawner upgrade purchasing.
		 */
		UPGRADES_UPGRADE_DISABLE,
		/**
		 * Disables spawner switching (on and off).
		 */
		UPGRADES_SWITCHING_DISABLE,
		/**
		 * Disables charge purchasing.
		 */
		UPGRADES_CHARGES_DISABLE,
		/**
		 * Will not use spawner charges.<br>
		 * This will also allow spawners to spawn without charges.
		 */
		CHARGES_USE_DISABLE,
		/**
		 * Will not reduce spawnable amount.
		 */
		SPAWNABLE_USE_DISABLE,
		/**
		 * Will not require players to be nearby to spawn.
		 */
		PLAYER_REQUIREMENT_DISABLE,
		/**
		 * Disables owner online requirement.
		 */
		ONLINE_REQUIREMENT_DISABLE,
		/**
		 * Disables nearby entity limit requirement.
		 */
		NEARBY_LIMIT_REQUIREMENT_DISABLE,
		/**
		 * Disables chunk entity limit requirement.
		 */
		CHUCK_LIMIT_REQUIREMENT_DISABLE,
		/**
		 * Disables spawner warning particles.
		 */
		WARNING_PARTICLES_DISABLE,
		/**
		 * Disables identity hologram.
		 */
		HOLOGRAM_IDENTITY_DISABLE,
		/**
		 * Disables warning hologram.
		 */
		HOLOGRAM_WARNINGS_DISABLE,
		/**
		 * Disables countdown hologram.
		 */
		HOLOGRAM_COUNTDOWN_DISABLE,
		/**
		 * Ignores light level requirement.
		 */
		LIGHT_REQUIREMENT_IGNORE,
		/**
		 * Ignores ground material requirement.
		 */
		GROUND_REQUIREMENT_IGNORE;
		
		/**
		 * @return The index of the tag
		 */
		
		public int index() {
			return 1 << ordinal();
		}
		
		/**
		 * @param tags - tags
		 * @return {@code true} it this tag matches the specified tags
		 */
		
		public boolean match(int tags) {
			return (index() & tags) != 0;
		}
		
		public static Tag[] of(int tags) {
			return Stream.of(values())
					.filter(tag -> tag.match(tags))
					.toArray(Tag[]::new);
		}
		
	}

}
