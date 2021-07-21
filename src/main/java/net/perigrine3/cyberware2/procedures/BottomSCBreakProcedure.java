package net.perigrine3.cyberware2.procedures;

import net.perigrine3.cyberware2.Cyberware2ModElements;
import net.perigrine3.cyberware2.Cyberware2Mod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import java.util.Map;

@Cyberware2ModElements.ModElement.Tag
public class BottomSCBreakProcedure extends Cyberware2ModElements.ModElement {
	public BottomSCBreakProcedure(Cyberware2ModElements instance) {
		super(instance, 142);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency x for procedure BottomSCBreak!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency y for procedure BottomSCBreak!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency z for procedure BottomSCBreak!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency world for procedure BottomSCBreak!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.AIR.getDefaultState(), 3);
	}
}
