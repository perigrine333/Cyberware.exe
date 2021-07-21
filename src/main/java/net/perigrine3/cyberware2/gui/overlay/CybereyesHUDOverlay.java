
package net.perigrine3.cyberware2.gui.overlay;

import net.perigrine3.cyberware2.Cyberware2ModVariables;
import net.perigrine3.cyberware2.Cyberware2ModElements;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

@Cyberware2ModElements.ModElement.Tag
public class CybereyesHUDOverlay extends Cyberware2ModElements.ModElement {
	public CybereyesHUDOverlay(Cyberware2ModElements instance) {
		super(instance, 134);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (true) {
				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"POWER: " + (int) ((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerPower) + "",
								posX + -210, posY + -114, -16711936);
				Minecraft.getInstance().fontRenderer
						.drawString(event.getMatrixStack(),
								"TOLERANCE: " + (int) ((entity.getCapability(Cyberware2ModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new Cyberware2ModVariables.PlayerVariables())).PlayerTolerance) + "",
								posX + -209, posY + -101, -3407668);
			}
		}
	}
}
