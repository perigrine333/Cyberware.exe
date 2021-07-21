
package net.perigrine3.cyberware2.item;

import net.perigrine3.cyberware2.itemgroup.ComponentsTabItemGroup;
import net.perigrine3.cyberware2.Cyberware2ModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@Cyberware2ModElements.ModElement.Tag
public class ComponentMicroelectricCellsItem extends Cyberware2ModElements.ModElement {
	@ObjectHolder("cyberware2:component_microelectric_cells")
	public static final Item block = null;
	public ComponentMicroelectricCellsItem(Cyberware2ModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ComponentsTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("component_microelectric_cells");
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
	}
}
