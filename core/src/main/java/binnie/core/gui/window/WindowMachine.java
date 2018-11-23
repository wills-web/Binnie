package binnie.core.gui.window;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import binnie.core.gui.minecraft.Window;

public abstract class WindowMachine extends Window {
	public WindowMachine(int width, int height, EntityPlayer player, @Nullable IInventory inventory, Side side) {
		super(width, height, player, inventory, side);
	}

	public abstract String getTitle();

	@Override
	@SideOnly(Side.CLIENT)
	public void initialiseClient() {
		this.setTitle(this.getTitle());
	}
}
