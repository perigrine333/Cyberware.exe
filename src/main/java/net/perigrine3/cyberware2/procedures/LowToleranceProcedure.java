package net.perigrine3.cyberware2.procedures;

import net.perigrine3.cyberware2.Cyberware2ModVariables;
import net.perigrine3.cyberware2.Cyberware2ModElements;
import net.perigrine3.cyberware2.Cyberware2Mod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.HashMap;

@Cyberware2ModElements.ModElement.Tag
public class LowToleranceProcedure extends Cyberware2ModElements.ModElement {
	public LowToleranceProcedure(Cyberware2ModElements instance) {
		super(instance, 144);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency entity for procedure LowTolerance!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) <= 25)) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
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
