package binnie.core.gui;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;

import binnie.core.gui.fieldkit.WindowFieldKit;
import binnie.core.gui.genesis.WindowGenesis;
import binnie.core.gui.minecraft.Window;
import binnie.core.machines.storage.WindowCompartment;

public enum BinnieCoreGUI implements IBinnieGUID {
	COMPARTMENT,
	FIELD_KIT,
	GENESIS;

	public Window getWindow(EntityPlayer player, @Nullable IInventory object, Side side) {
		switch (this) {
			case COMPARTMENT: {
				return new WindowCompartment(player, object, side);
			}
			case FIELD_KIT: {
				return new WindowFieldKit(player, null, side);
			}
			case GENESIS: {
				return new WindowGenesis(player, null, side);
			}
			default: {
				throw new IllegalArgumentException("Unknown GUI type: " + this);
			}
		}
	}

	@Override
	public Window getWindow(EntityPlayer player, World world, int x, int y, int z, Side side) {
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
		IInventory object = null;
		if (tileEntity instanceof IInventory) {
			object = (IInventory) tileEntity;
		}

		return this.getWindow(player, object, side);
	}
}
