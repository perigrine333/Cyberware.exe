package net.perigrine3.cyberware2.procedures;

import net.perigrine3.cyberware2.Cyberware2ModVariables;
import net.perigrine3.cyberware2.Cyberware2ModElements;
import net.perigrine3.cyberware2.Cyberware2Mod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

@Cyberware2ModElements.ModElement.Tag
public class CyberwareInstalledHandlerProcedure extends Cyberware2ModElements.ModElement {
	public CyberwareInstalledHandlerProcedure(Cyberware2ModElements instance) {
		super(instance, 129);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency entity for procedure CyberwareInstalledHandler!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency world for procedure CyberwareInstalledHandler!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).SolarSkinInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 12);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerPower) + 4);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerPower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MetabolicGeneratorInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 8);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerPower) + 25);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerPower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CardiovascularCouplerInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerPower) + 6);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerPower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).QuickdrawFlywheelsInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CitrateEnhancementInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 0);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).AdrenalinePumpInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).AquaticPropulsionSystemInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 2);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CardiomechanicPumpInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).ConsiousnessTransmitterInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 2);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CorticalStackInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 3);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CybereyesInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 8);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).DeployableWheelsInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 3);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).DistanceEnhancerInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 1);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).EnderJammerInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 10);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).FallBracersInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 1);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).FineManipulatorsInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 2);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HudjackInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 1);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HudlensInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 1);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).ImplantedSpursInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 1);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalDefibrillatorInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 10);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).IsothermicSkinInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 12);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).LeftCyberarmInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).RightCyberarmInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).LeftCyberlegInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).RightCyberlegInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (((Cyberware2ModVariables.MapVariables.get(world).LiquidRefractionCalibratorInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 1);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).LinearActuatorsInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 3);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).LiverFilterInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MyomerMuscleReplacementInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).NeuralContextualizerInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 2);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).NightVisionInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 2);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).PlateletDispatcherInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).ReinforcedFistInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 1);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).RetractableClawsInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 2);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).StemCellSynthesizerInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).SubdermalSpikesInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 12);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).SyntheticChromatophoresInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 18);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).TargetedImmunosuppressantInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) + 25);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).TargetingOverlayInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 1);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).ThreatMatrixCalculatorInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 8);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CompressedOxygenImplantInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).UltradenseCapacitorInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).SyntheticSkinInstalled) == (true))) {
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MarrowBatteryInstalled) == 1)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 2);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MarrowBatteryInstalled) == 2)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 3);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MarrowBatteryInstalled) == 3)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 4);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).MarrowBatteryInstalled) == 4)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 1)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 3);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 2)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 6);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 3)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 9);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 4)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 12);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).BonelacingInstalled) == 5)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 15);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HyperoxygenationBoostInstalled) == 1)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 2);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HyperoxygenationBoostInstalled) == 2)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 4);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).HyperoxygenationBoostInstalled) == 3)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalBatteryInstalled) == 1)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalBatteryInstalled) == 2)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 7);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalBatteryInstalled) == 3)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 9);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).InternalBatteryInstalled) == 4)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 11);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).WiredReflexesInstalled) == 1)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 9);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).WiredReflexesInstalled) == 2)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 9);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).WiredReflexesInstalled) == 3)) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 9);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
