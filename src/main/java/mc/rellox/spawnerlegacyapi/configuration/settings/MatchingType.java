package mc.rellox.spawnerlegacyapi.configuration.settings;

import java.util.Collection;
import java.util.function.Predicate;

public enum MatchingType {

    /**
     * Any should match.
     */
    ANY {
        @Override
        public <T> boolean matches(Collection<T> collection, Predicate<T> filter) {
            return collection.stream().anyMatch(filter);
        }
    },
    /**
     * All should match.
     */
    ALL {
        @Override
        public <T> boolean matches(Collection<T> collection, Predicate<T> filter) {
            return collection.stream().allMatch(filter);
        }
    },
    /**
     * None should match.
     */
    NONE {
        @Override
        public <T> boolean matches(Collection<T> collection, Predicate<T> filter) {
            return collection.stream().noneMatch(filter);
        }
    };

    /**
     * Applies the filter to each value in the collection according to the matching type.
     *
     * @param collection collection
     * @param filter filter
     * @return Whether the collection matches the filter
     * @param <T> type of the collection
     */
    public abstract <T> boolean matches(Collection<T> collection, Predicate<T> filter);

}
