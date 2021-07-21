package net.perigrine3.cyberware2.procedures;

import net.perigrine3.cyberware2.item.SalvagedWiredReflexesItem;
import net.perigrine3.cyberware2.item.SalvagedUltradenseCapacitorItem;
import net.perigrine3.cyberware2.item.SalvagedThreatMatrixCalculatorItem;
import net.perigrine3.cyberware2.item.SalvagedTargetingOverlayItem;
import net.perigrine3.cyberware2.item.SalvagedTargetedImmunosuppressantItem;
import net.perigrine3.cyberware2.item.SalvagedSyntheticSkinItem;
import net.perigrine3.cyberware2.item.SalvagedSyntheticChromatophoresItem;
import net.perigrine3.cyberware2.item.SalvagedSubdermalSpikesItem;
import net.perigrine3.cyberware2.item.SalvagedStemCellSynthesizerItem;
import net.perigrine3.cyberware2.item.SalvagedSolarskinItem;
import net.perigrine3.cyberware2.item.SalvagedRightCyberlegItem;
import net.perigrine3.cyberware2.item.SalvagedRightCyberarmItem;
import net.perigrine3.cyberware2.item.SalvagedRetractableClawsItem;
import net.perigrine3.cyberware2.item.SalvagedReinforcedFistItem;
import net.perigrine3.cyberware2.item.SalvagedQuickdrawFlywheelsItem;
import net.perigrine3.cyberware2.item.SalvagedPlateletDispatcherItem;
import net.perigrine3.cyberware2.item.SalvagedNeuralContextualizerItem;
import net.perigrine3.cyberware2.item.SalvagedMyomerMuscleReplacementItem;
import net.perigrine3.cyberware2.item.SalvagedMetabolicGeneratorItem;
import net.perigrine3.cyberware2.item.SalvagedMarrowBatteryItem;
import net.perigrine3.cyberware2.item.SalvagedLiverFilterItem;
import net.perigrine3.cyberware2.item.SalvagedLiquidRefractionCalibratorItem;
import net.perigrine3.cyberware2.item.SalvagedLinearActuatorsItem;
import net.perigrine3.cyberware2.item.SalvagedLeftCyberlegItem;
import net.perigrine3.cyberware2.item.SalvagedLeftCyberarmItem;
import net.perigrine3.cyberware2.item.SalvagedIsothermicSkinItem;
import net.perigrine3.cyberware2.item.SalvagedInternalDefibrillatorItem;
import net.perigrine3.cyberware2.item.SalvagedInternalBatteryItem;
import net.perigrine3.cyberware2.item.SalvagedImplantedSpursItem;
import net.perigrine3.cyberware2.item.SalvagedHyperoxygenationBoostItem;
import net.perigrine3.cyberware2.item.SalvagedHudlensItem;
import net.perigrine3.cyberware2.item.SalvagedHudjackItem;
import net.perigrine3.cyberware2.item.SalvagedFineManipulatorsItem;
import net.perigrine3.cyberware2.item.SalvagedFallBracersItem;
import net.perigrine3.cyberware2.item.SalvagedEnderJammerItem;
import net.perigrine3.cyberware2.item.SalvagedDistanceEnhancerItem;
import net.perigrine3.cyberware2.item.SalvagedDeployableWheelsItem;
import net.perigrine3.cyberware2.item.SalvagedCybereyesItem;
import net.perigrine3.cyberware2.item.SalvagedConsciousnessTransmitterItem;
import net.perigrine3.cyberware2.item.SalvagedCompressedOxygenImplantItem;
import net.perigrine3.cyberware2.item.SalvagedCitrateEnhancementItem;
import net.perigrine3.cyberware2.item.SalvagedCardiovascularCouplerItem;
import net.perigrine3.cyberware2.item.SalvagedCardiomechanicPumpItem;
import net.perigrine3.cyberware2.item.SalvagedBonelacingItem;
import net.perigrine3.cyberware2.item.SalvagedAquaticPropulsionSystemItem;
import net.perigrine3.cyberware2.item.SalvagedAdrenalinePumpItem;
import net.perigrine3.cyberware2.item.CorticalStackCapsuleItem;
import net.perigrine3.cyberware2.Cyberware2ModVariables;
import net.perigrine3.cyberware2.Cyberware2ModElements;
import net.perigrine3.cyberware2.Cyberware2Mod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@Cyberware2ModElements.ModElement.Tag
public class PlayerDeathHandlerProcedure extends Cyberware2ModElements.ModElement {
	public PlayerDeathHandlerProcedure(Cyberware2ModElements instance) {
		super(instance, 131);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency entity for procedure PlayerDeathHandler!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency x for procedure PlayerDeathHandler!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency y for procedure PlayerDeathHandler!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency z for procedure PlayerDeathHandler!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency world for procedure PlayerDeathHandler!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).SolarSkinInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedSolarskinItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SolarSkinInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MetabolicGeneratorInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMetabolicGeneratorItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MetabolicGeneratorInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CardiovascularCouplerInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedCardiovascularCouplerItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CardiovascularCouplerInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).QuickdrawFlywheelsInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedQuickdrawFlywheelsItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.QuickdrawFlywheelsInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CitrateEnhancementInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedCitrateEnhancementItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CitrateEnhancementInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).AdrenalinePumpInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedAdrenalinePumpItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AdrenalinePumpInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).AquaticPropulsionSystemInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
						new ItemStack(SalvagedAquaticPropulsionSystemItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AquaticPropulsionSystemInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CardiomechanicPumpInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedCardiomechanicPumpItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CardiomechanicPumpInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).ConsiousnessTransmitterInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
						new ItemStack(SalvagedConsciousnessTransmitterItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ConsiousnessTransmitterInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CorticalStackInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(CorticalStackCapsuleItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CorticalStackInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CybereyesInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedCybereyesItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CybereyesInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).DeployableWheelsInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedDeployableWheelsItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DeployableWheelsInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).DistanceEnhancerInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedDistanceEnhancerItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DistanceEnhancerInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).EnderJammerInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedEnderJammerItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EnderJammerInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).FallBracersInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedFallBracersItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FallBracersInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).FineManipulatorsInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedFineManipulatorsItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.FineManipulatorsInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HudjackInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedHudjackItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HudjackInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HudlensInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedHudlensItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HudlensInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).ImplantedSpursInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedImplantedSpursItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ImplantedSpursInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalDefibrillatorInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalDefibrillatorItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InternalDefibrillatorInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).IsothermicSkinInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedIsothermicSkinItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsothermicSkinInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).LeftCyberarmInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedLeftCyberarmItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LeftCyberarmInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).RightCyberarmInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedRightCyberarmItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RightCyberarmInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).LeftCyberlegInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedLeftCyberlegItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LeftCyberlegInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).RightCyberlegInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedRightCyberlegItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RightCyberlegInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((Cyberware2ModVariables.MapVariables.get(world).LiquidRefractionCalibratorInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
						new ItemStack(SalvagedLiquidRefractionCalibratorItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			Cyberware2ModVariables.MapVariables.get(world).LiquidRefractionCalibratorInstalled = (boolean) (false);
			Cyberware2ModVariables.MapVariables.get(world).syncData(world);
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).LinearActuatorsInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedLinearActuatorsItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LinearActuatorsInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).LiverFilterInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedLiverFilterItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LiverFilterInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MyomerMuscleReplacementInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
						new ItemStack(SalvagedMyomerMuscleReplacementItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MyomerMuscleReplacementInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).NeuralContextualizerInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedNeuralContextualizerItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NeuralContextualizerInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).NightVisionInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMetabolicGeneratorItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NightVisionInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).PlateletDispatcherInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedPlateletDispatcherItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlateletDispatcherInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).ReinforcedFistInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedReinforcedFistItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ReinforcedFistInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).RetractableClawsInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedRetractableClawsItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RetractableClawsInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).StemCellSynthesizerInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedStemCellSynthesizerItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.StemCellSynthesizerInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).SubdermalSpikesInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedSubdermalSpikesItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SubdermalSpikesInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).SyntheticChromatophoresInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
						new ItemStack(SalvagedSyntheticChromatophoresItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SyntheticChromatophoresInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).TargetedImmunosuppressantInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
						new ItemStack(SalvagedTargetedImmunosuppressantItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TargetedImmunosuppressantInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).TargetingOverlayInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedTargetingOverlayItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TargetingOverlayInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).ThreatMatrixCalculatorInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedThreatMatrixCalculatorItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ThreatMatrixCalculatorInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CompressedOxygenImplantInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
						new ItemStack(SalvagedCompressedOxygenImplantItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CompressedOxygenImplantInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).UltradenseCapacitorInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedUltradenseCapacitorItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.UltradenseCapacitorInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).SyntheticSkinInstalled) == (true))) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedSyntheticSkinItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SyntheticSkinInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MarrowBatteryInstalled) == 1)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MarrowBatteryInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MarrowBatteryInstalled) == 2)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MarrowBatteryInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MarrowBatteryInstalled) == 3)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MarrowBatteryInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MarrowBatteryInstalled) == 4)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedMarrowBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MarrowBatteryInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 1)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BonelacingInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 2)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BonelacingInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 3)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BonelacingInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 4)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BonelacingInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 5)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedBonelacingItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BonelacingInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HyperoxygenationBoostInstalled) == 1)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedHyperoxygenationBoostItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HyperoxygenationBoostInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HyperoxygenationBoostInstalled) == 2)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedHyperoxygenationBoostItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedHyperoxygenationBoostItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HyperoxygenationBoostInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HyperoxygenationBoostInstalled) == 3)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedHyperoxygenationBoostItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedHyperoxygenationBoostItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedHyperoxygenationBoostItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HyperoxygenationBoostInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalBatteryInstalled) == 1)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InternalBatteryInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalBatteryInstalled) == 2)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InternalBatteryInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalBatteryInstalled) == 3)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InternalBatteryInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalBatteryInstalled) == 4)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedInternalBatteryItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.InternalBatteryInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).WiredReflexesInstalled) == 1)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedWiredReflexesItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.WiredReflexesInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).WiredReflexesInstalled) == 2)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedWiredReflexesItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedWiredReflexesItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.WiredReflexesInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).WiredReflexesInstalled) == 3)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedWiredReflexesItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedWiredReflexesItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SalvagedWiredReflexesItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			{
				double _setval = (double) 0;
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.WiredReflexesInstalled = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
