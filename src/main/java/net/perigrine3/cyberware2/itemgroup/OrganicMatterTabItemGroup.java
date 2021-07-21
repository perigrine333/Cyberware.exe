
package net.perigrine3.cyberware2.itemgroup;

import net.perigrine3.cyberware2.item.HumanEyeballsItem;
import net.perigrine3.cyberware2.Cyberware2ModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@Cyberware2ModElements.ModElement.Tag
public class OrganicMatterTabItemGroup extends Cyberware2ModElements.ModElement {
	public OrganicMatterTabItemGroup(Cyberware2ModElements instance) {
		super(instance, 123);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("taborganic_matter_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(HumanEyeballsItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
