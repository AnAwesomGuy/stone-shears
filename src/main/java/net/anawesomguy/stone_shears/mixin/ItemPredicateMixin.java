/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * Some changes have been made:
 * changing it to add my item, not Botania's
 * and renaming the class and method.
 */

package net.anawesomguy.stone_shears.mixin;

import com.google.common.collect.ImmutableSet;
import net.anawesomguy.stone_shears.StoneShears;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.item.ItemPredicate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.HashSet;
import java.util.Set;

@Mixin(ItemPredicate.class)
@SuppressWarnings("unused")
public abstract class ItemPredicateMixin {
    @ModifyVariable(at = @At("HEAD"), method = "<init>(Lnet/minecraft/registry/tag/TagKey;Ljava/util/Set;Lnet/minecraft/predicate/NumberRange$IntRange;Lnet/minecraft/predicate/NumberRange$IntRange;[Lnet/minecraft/predicate/item/EnchantmentPredicate;[Lnet/minecraft/predicate/item/EnchantmentPredicate;Lnet/minecraft/potion/Potion;Lnet/minecraft/predicate/NbtPredicate;)V")
    private static Set<Item> isShears(Set<Item> set) {
        if (set != null && set.contains(Items.SHEARS)) {
            set = new HashSet<>(set);
            set.add(StoneShears.STONE_SHEARS);
            set = ImmutableSet.copyOf(set);
        }
        return set;
    }
}
