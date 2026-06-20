package mc.rellox.spawnerlegacyapi.metadata.entity.trait.type;

import mc.rellox.spawnerlegacyapi.metadata.entity.trait.ITrait;
import org.bukkit.potion.PotionEffectType;

public interface ITraitEffect extends ITrait {

    /**
     * @return Type of the potion effect
     */

    PotionEffectType potion();

    /**
     * @return Duration of the potion effect in ticks
     */

    int duration();

    /**
     * @return Amplifier of the potion effect
     */

    int amplifier();

    /**
     * @return Whether the potion effect is ambient
     */

    boolean ambient();

    /**
     * @return Whether the potion effect has particles
     */

    boolean particles();

    /**
     * @return Whether the potion effect has an icon
     */

    boolean icon();

}
