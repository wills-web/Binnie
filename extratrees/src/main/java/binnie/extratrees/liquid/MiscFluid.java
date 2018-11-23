package binnie.extratrees.liquid;

import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fluids.FluidStack;

import binnie.core.Constants;
import binnie.core.features.FeatureProvider;
import binnie.core.liquid.FluidContainerType;
import binnie.core.liquid.FluidType;
import binnie.core.liquid.IFluidDefinition;
import binnie.core.modules.ExtraTreesModuleUIDs;
import binnie.extratrees.ExtraTrees;
import binnie.extratrees.alcohol.ICocktailLiquid;

@FeatureProvider(containerId = Constants.EXTRA_TREES_MOD_ID, moduleID = ExtraTreesModuleUIDs.CORE)
public enum MiscFluid implements IFluidDefinition, ICocktailLiquid {
	CarbonatedWater("water.carbonated", 13421823, 0.10000000149011612),
	TonicWater("water.tonic", 13421823, 0.10000000149011612),
	Cream("cream", 15395550, 2.0),
	GingerAle("gingerAle", 16777215, 0.6000000238418579),
	Coffee("coffee", 5910789, 0.30000001192092896),
	SugarSyrup("syrup.simple", 16120049, 0.10000000149011612),
	AgaveNectar("syrup.agave", 13598245, 0.699999988079071),
	GrenadineSyrup("syrup.grenadine", 16009573, 0.800000011920929);

	private final FluidType type;

	MiscFluid(String ident, int color, double transparency) {
		type = ExtraTrees.instance.registry(ExtraTreesModuleUIDs.CORE).createFluid(ident, String.format("%s.fluid.%s.%s", ExtraTrees.instance.getModId(), "MiscFluid", this.name()), color)
			.setTransparency(transparency)
			.setTextures(new ResourceLocation(Constants.EXTRA_TREES_MOD_ID, "blocks/liquids/liquid"))
			.setShowHandler((type) -> type == FluidContainerType.GLASS);
	}

	@Override
	public String toString() {
		return type.toString();
	}

	@Override
	public String getDisplayName() {
		return type.getDisplayName();
	}

	@Override
	public String getIdentifier() {
		return type.getIdentifier();
	}

	@Override
	public int getColor() {
		return type.getColor();
	}

	@Override
	public FluidStack get(int amount) {
		return type.stack(amount);
	}

	@Override
	public int getTransparency() {
		return type.getTransparency();
	}

	@Override
	public String getTooltip(int ratio) {
		return ratio + " Part" + ((ratio > 1) ? "s " : " ") + this.getDisplayName();
	}

	@Override
	public float getABV() {
		return 0.0f;
	}

	@Override
	public FluidType getType() {
		return type;
	}
}
