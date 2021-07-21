package net.perigrine3.cyberware2.procedures;

import net.perigrine3.cyberware2.Cyberware2ModVariables;
import net.perigrine3.cyberware2.Cyberware2ModElements;
import net.perigrine3.cyberware2.Cyberware2Mod;

import net.minecraft.entity.Entity;

import java.util.Map;

@Cyberware2ModElements.ModElement.Tag
public class HUDOverlayDependenciesProcedure extends Cyberware2ModElements.ModElement {
	public HUDOverlayDependenciesProcedure(Cyberware2ModElements instance) {
		super(instance, 135);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency entity for procedure HUDOverlayDependencies!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).CybereyesInstalled) == (true))
				&& (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).HudjackInstalled) == (true)))
				|| (((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new Cyberware2ModVariables.PlayerVariables())).HudlensInstalled) == (true)))) {
			return (true);
		}
		return (false);
	}
}
