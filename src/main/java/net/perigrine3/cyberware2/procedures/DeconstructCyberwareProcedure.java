package net.perigrine3.cyberware2.procedures;

import net.perigrine3.cyberware2.item.SalvagedNightVisionItem;
import net.perigrine3.cyberware2.item.SalvagedLiquidRefractionCalibratorItem;
import net.perigrine3.cyberware2.item.SalvagedHudjackItem;
import net.perigrine3.cyberware2.item.SalvagedCybereyesItem;
import net.perigrine3.cyberware2.item.NightVisionItem;
import net.perigrine3.cyberware2.item.LiquidRefractionCalibratorItem;
import net.perigrine3.cyberware2.item.HudjackItem;
import net.perigrine3.cyberware2.item.CybereyesItem;
import net.perigrine3.cyberware2.item.ComponentSyntheticNervesItem;
import net.perigrine3.cyberware2.item.ComponentSolidStateCircuitryItem;
import net.perigrine3.cyberware2.item.ComponentFullereneMicrostructuresItem;
import net.perigrine3.cyberware2.item.ComponentFiberOpticsItem;
import net.perigrine3.cyberware2.item.ComponentChromePlatingItem;
import net.perigrine3.cyberware2.Cyberware2ModElements;
import net.perigrine3.cyberware2.Cyberware2Mod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@Cyberware2ModElements.ModElement.Tag
public class DeconstructCyberwareProcedure extends Cyberware2ModElements.ModElement {
	public DeconstructCyberwareProcedure(Cyberware2ModElements instance) {
		super(instance, 194);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				Cyberware2Mod.LOGGER.warn("Failed to load dependency entity for procedure DeconstructCyberware!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedCybereyesItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(CybereyesItem.block, (int) (1)).getItem()))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(SalvagedCybereyesItem.block, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(SalvagedCybereyesItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(CybereyesItem.block, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(CybereyesItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentSyntheticNervesItem.block, (int) (1));
					_setstack.setCount((int) 2);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentFiberOpticsItem.block, (int) (1));
					_setstack.setCount((int) 2);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(SalvagedNightVisionItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(NightVisionItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentSyntheticNervesItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentFiberOpticsItem.block, (int) (1));
					_setstack.setCount((int) 2);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedLiquidRefractionCalibratorItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(LiquidRefractionCalibratorItem.block, (int) (1)).getItem()))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(SalvagedNightVisionItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(NightVisionItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentFiberOpticsItem.block, (int) (1));
					_setstack.setCount((int) 2);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentSyntheticNervesItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedHudjackItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(HudjackItem.block, (int) (1)).getItem()))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(SalvagedNightVisionItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem())) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(NightVisionItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentSolidStateCircuitryItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentFiberOpticsItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentFullereneMicrostructuresItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentSyntheticNervesItem.block, (int) (1));
					_setstack.setCount((int) 2);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		} else if (((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(SalvagedNightVisionItem.block, (int) (1)).getItem())
				|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(NightVisionItem.block, (int) (1)).getItem()))) {
			if ((Math.random() < 0.7)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ComponentChromePlatingItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		}
	}
}
