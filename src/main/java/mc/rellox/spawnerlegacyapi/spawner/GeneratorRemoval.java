package mc.rellox.spawnerlegacyapi.spawner;

public enum GeneratorRemoval {

    /**
     * Remove the generator from the cache only.
     */
    CACHE,
    /**
     * Remove the generator from the cache, remove the spawner block from the world (set to air),
     * and remove it from files.
     */
    ALL;

    /**
     * @param removal removal type to compare with
     * @return {@code true} if this removal type is equal to or more severe than the given removal type
     */

    public boolean is(GeneratorRemoval removal) {
        return ordinal() >= removal.ordinal();
    }

}
