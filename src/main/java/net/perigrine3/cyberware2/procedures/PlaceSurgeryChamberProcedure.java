package net.perigrine3.cyberware2.procedures;

import net.perigrine3.cyberware2.block.OpenSurgeryChamberTopBlock;
import net.perigrine3.cyberware2.Cyberware2ModElements;
import net.perigrine3.cyberware2.Cyberware2Mod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import java.util.Map;

@Cyberware2ModElements.ModElement.Tag
public class PlaceSurgeryChamberProcedure extends Cyberware2ModElements.ModElement {
	public PlaceSurgeryChamberProcedure(Cyberware2ModElements instance) {
		super(instance, 141);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency x for procedure PlaceSurgeryChamber!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency y for procedure PlaceSurgeryChamber!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency z for procedure PlaceSurgeryChamber!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency world for procedure PlaceSurgeryChamber!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double generator_distance = 0;
		world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), OpenSurgeryChamberTopBlock.block.getDefaultState(), 3);
		try {
			BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z));
			DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (_property != null) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), _bs.with(_property, (new Object() {
					public Direction getDirection(BlockPos pos) {
						try {
							BlockState _bs = world.getBlockState(pos);
							DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
							if (property != null)
								return _bs.get(property);
							return Direction.getFacingFromAxisDirection(
									_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
									Direction.AxisDirection.POSITIVE);
						} catch (Exception e) {
							return Direction.NORTH;
						}
					}
				}.getDirection(new BlockPos((int) x, (int) y, (int) z)))), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z),
						_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), (new Object() {
							public Direction getDirection(BlockPos pos) {
								try {
									BlockState _bs = world.getBlockState(pos);
									DirectionProperty property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
									if (property != null)
										return _bs.get(property);
									return Direction.getFacingFromAxisDirection(
											_bs.get((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis")),
											Direction.AxisDirection.POSITIVE);
								} catch (Exception e) {
									return Direction.NORTH;
								}
							}
						}.getDirection(new BlockPos((int) x, (int) y, (int) z))).getAxis()), 3);
			}
		} catch (Exception e) {
		}
	}
}
