
package net.perigrine3.cyberware2.item;

import net.perigrine3.cyberware2.itemgroup.SalvagedBionicsTabItemGroup;
import net.perigrine3.cyberware2.Cyberware2ModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.List;

@Cyberware2ModElements.ModElement.Tag
public class SalvagedAquaticPropulsionSystemItem extends Cyberware2ModElements.ModElement {
	@ObjectHolder("cyberware2:salvaged_aquatic_propulsion_system")
	public static final Item block = null;
	public SalvagedAquaticPropulsionSystemItem(Cyberware2ModElements instance) {
		super(instance, 72);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SalvagedBionicsTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("salvaged_aquatic_propulsion_system");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Swim faster"));
			list.add(new StringTextComponent("More powerful with two Cyberlegs"));
			list.add(new StringTextComponent("Requires -1pow/s when in use"));
			list.add(new StringTextComponent("Tolerance Cost: 3"));
			list.add(new StringTextComponent("REQUIRES LEFT OR RIGHT CYBERLEG"));
		}
	}
}