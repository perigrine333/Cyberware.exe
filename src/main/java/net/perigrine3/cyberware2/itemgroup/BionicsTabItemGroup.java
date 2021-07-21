
package net.perigrine3.cyberware2.itemgroup;

import net.perigrine3.cyberware2.item.CybereyesItem;
import net.perigrine3.cyberware2.Cyberware2ModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Cyberware2ModElements.ModElement.Tag
public class BionicsTabItemGroup extends Cyberware2ModElements.ModElement {
	public BionicsTabItemGroup(Cyberware2ModElements instance) {
		super(instance, 124);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbionics_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CybereyesItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
