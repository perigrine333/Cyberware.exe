package net.perigrine3.cyberware2.procedures;

import net.perigrine3.cyberware2.item.CorticalStackCapsuleItem;
import net.perigrine3.cyberware2.Cyberware2ModElements;
import net.perigrine3.cyberware2.Cyberware2Mod;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@Cyberware2ModElements.ModElement.Tag
public class CorticalStackCapsuleOpenedProcedure extends Cyberware2ModElements.ModElement {
	public CorticalStackCapsuleOpenedProcedure(Cyberware2ModElements instance) {
		super(instance, 132);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency entity for procedure CorticalStackCapsuleOpened!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _stktoremove = new ItemStack(CorticalStackCapsuleItem.block, (int) (1));
			((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
					((PlayerEntity) entity).container.func_234641_j_());
		}
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel((int) 14);
	}
}
