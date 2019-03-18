package AutoVeinMiner;

import net.minecraft.item.Item;

class Util {

	public enum Tools {NONE, PICKAXE, AXE, SHOVEL, SHEARS}

	static Tools getToolType(Item item) {
		String i = (String.valueOf(Item.REGISTRY.getNameForObject(item)));
		System.out.println(Item.REGISTRY.getNameForObject(item));
		if (i.contains("pickaxe")) return Tools.PICKAXE;
		else if ((i.contains("axe") || i.contains("hatchet")) && !i.contains("pickaxe")) return Tools.AXE;
		else if (i.contains("shovel") || i.contains("spade")) return Tools.SHOVEL;
		else if (i.contains("shear")) return Tools.SHEARS;
		else return Tools.NONE;
	}

}
