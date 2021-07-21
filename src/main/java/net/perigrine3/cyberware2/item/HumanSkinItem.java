
package net.perigrine3.cyberware2.item;

import net.perigrine3.cyberware2.itemgroup.OrganicMatterTabItemGroup;
import net.perigrine3.cyberware2.Cyberware2ModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

@Cyberware2ModElements.ModElement.Tag
public class HumanSkinItem extends Cyberware2ModElements.ModElement {
	@ObjectHolder("cyberware2:human_skin")
	public static final Item block = null;
	public HumanSkinItem(Cyberware2ModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(OrganicMatterTabItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("human_skin");
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
