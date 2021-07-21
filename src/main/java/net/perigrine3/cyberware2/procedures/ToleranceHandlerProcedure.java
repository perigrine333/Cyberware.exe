package net.perigrine3.cyberware2.procedures;

import net.perigrine3.cyberware2.Cyberware2ModVariables;
import net.perigrine3.cyberware2.Cyberware2ModElements;
import net.perigrine3.cyberware2.Cyberware2Mod;

import net.minecraft.entity.Entity;

import java.util.Map;

@Cyberware2ModElements.ModElement.Tag
public class ToleranceHandlerProcedure extends Cyberware2ModElements.ModElement {
	public ToleranceHandlerProcedure(Cyberware2ModElements instance) {
		super(instance, 145);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency entity for procedure ToleranceHandler!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).QuickdrawFlywheelsInstalled) == (true))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 3);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).QuickdrawFlywheelsInstalled) == (false))
				&& (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) < 97))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) + 3);
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
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) - 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CitrateEnhancementInstalled) == (false))
				&& (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) < 95))) {
			{
				double _setval = (double) (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) + 5);
				entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerTolerance = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
