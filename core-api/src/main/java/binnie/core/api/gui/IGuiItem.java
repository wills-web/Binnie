package binnie.core.api.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IGuiItem {
	void openGui(ItemStack itemStack, World world, EntityPlayer player);
}
