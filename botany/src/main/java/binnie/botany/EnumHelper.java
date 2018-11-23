package binnie.botany;

import net.minecraft.util.text.TextFormatting;

import binnie.botany.api.IBotanyColored;
import binnie.botany.api.gardening.EnumAcidity;
import binnie.botany.api.gardening.EnumMoisture;
import binnie.botany.api.gardening.EnumSoilType;
import binnie.botany.api.genetics.EnumFlowerColor;
import binnie.core.ModId;
import binnie.core.util.I18N;

public class EnumHelper {
	public static String getLocalisedName(IBotanyColored enumClass, boolean withColor) {
		String localisedName = I18N.localise(ModId.BOTANY, getKeyGroup(enumClass) + '.' + enumClass.getName());
		TextFormatting color = enumClass.getColor();
		if (withColor && color != null) {
			localisedName = color + localisedName;
		}
		return localisedName;
	}

	private static String getKeyGroup(IBotanyColored enumClass) {
		if (enumClass instanceof EnumAcidity) {
			return "ph";
		} else if (enumClass instanceof EnumMoisture) {
			return "moisture";
		} else if (enumClass instanceof EnumSoilType) {
			return "soil";
		} else if (enumClass instanceof EnumFlowerColor) {
			return "color";
		}
		return "unknown";
	}
}
