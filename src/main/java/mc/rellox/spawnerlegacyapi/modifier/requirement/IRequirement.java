package mc.rellox.spawnerlegacyapi.modifier.requirement;

import mc.rellox.spawnerlegacyapi.item.builder.ItemBuilder;
import mc.rellox.spawnerlegacyapi.text.content.IContent;

import java.util.List;

public interface IRequirement {

    /**
     * Checks if a modifier can be applied to the generator.
     *
     * @param context context
     * @return {@code true} if the requirement is allowed
     */

    boolean allow(IRequirementContext context);

    /**
     * Replaces any placeholders in the item builder with the values of the requirement.
     *
     * @param builder item builder
     */

    default void replace(ItemBuilder builder) {}

    /**
     * @param context context
     * @return List of warning messages to be displayed to the player if the requirement is not met
     */

    default List<IContent> warning(IRequirementContext context) {
        return List.of();
    }

}
