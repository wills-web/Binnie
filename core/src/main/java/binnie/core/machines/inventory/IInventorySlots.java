package binnie.core.machines.inventory;

import javax.annotation.Nullable;

public interface IInventorySlots {
	@Nullable
	InventorySlot getSlot(int index);
}
