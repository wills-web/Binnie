package binnie.core.circuits;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import forestry.api.circuits.ChipsetManager;
import forestry.api.circuits.ICircuit;
import forestry.api.circuits.ICircuitLayout;

public class BinnieCircuit implements ICircuit {
	private final String uid;
	private final List<String> tooltips;

	public BinnieCircuit(String uid, ICircuitLayout layout, ItemStack itemStack) {
		this.tooltips = new ArrayList<>();
		this.uid = "for.binnie.circuit." + uid;
		ChipsetManager.circuitRegistry.registerCircuit(this);
		if (!itemStack.isEmpty()) {
			ChipsetManager.solderManager.addRecipe(layout, itemStack, this);
		}
	}

	public void addTooltipString(String string) {
		this.tooltips.add(string);
	}

	@Override
	public String getUID() {
		return this.uid;
	}

	@Override
	public String getUnlocalizedName() {
		return this.uid;
	}

	@Override
	public void addTooltip(List<String> list) {
		for (String string : this.tooltips) {
			list.add(" - " + string);
		}
	}

	@Override
	public boolean isCircuitable(Object arg0) {
		return false;
	}

	@Override
	public void onInsertion(int arg0, Object arg1) {
	}

	@Override
	public void onLoad(int arg0, Object arg1) {
	}

	@Override
	public void onRemoval(int arg0, Object arg1) {
	}

	@Override
	public void onTick(int arg0, Object arg1) {
	}
}
