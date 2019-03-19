package AutoVeinMiner;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;

import java.util.Objects;

class Util {

	public enum Tools {NONE, PICKAXE, AXE, SHOVEL, SHEARS}

	public enum Blocks {NONE, WOOD, STONE, DIRT}

	static Tools getToolType(Item item) {
		String i = (String.valueOf(Item.REGISTRY.getNameForObject(item))).toLowerCase();
		if (i.contains("pickaxe")) return Tools.PICKAXE;
		else if ((i.contains("axe") || i.contains("hatchet")) && !i.contains("pickaxe")) return Tools.AXE;
		else if (i.contains("shovel") || i.contains("spade")) return Tools.SHOVEL;
		else if (i.contains("shear")) return Tools.SHEARS;
		return Tools.NONE;
	}

	static Blocks getBlockType(Block block) {
		String i = String.valueOf(block.getHarvestTool(block.getDefaultState())).toLowerCase();
		System.out.println(i);
		if (i.contains("pickaxe")) {
			return Blocks.STONE;
		} else if (i.contains("axe")) {
			return Blocks.WOOD;
		} else if (i.contains("shovel")) {
			return Blocks.DIRT;
		}
		return Blocks.NONE;
	}

	static void addTool(Tools tools, Item item) {
		switch (tools) {
			case NONE:
				return;
			case PICKAXE:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247e" + "Pickaxe -> " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(item)).toString()));
				Minecraft.getMinecraft().player.sendChatMessage("/veinminer toollist pickaxe add " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(item)).toString());
				break;
			case AXE:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247b" + "Axe -> " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(item)).toString()));
				Minecraft.getMinecraft().player.sendChatMessage("/veinminer toollist axe add " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(item)).toString());
				break;
			case SHOVEL:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247a" + "Shovel -> " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(item)).toString()));
				Minecraft.getMinecraft().player.sendChatMessage("/veinminer toollist shovel add " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(item)).toString());
				break;
			case SHEARS:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247c" + "Shear -> " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(item)).toString()));
				Minecraft.getMinecraft().player.sendChatMessage("/veinminer toollist shears add " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(item)).toString());
				break;
		}
		Minecraft.getMinecraft().player.sendChatMessage("/veinminer saveconfig");
	}

	static void addBlock(Blocks blocks, Block block) {
		switch (blocks) {
			case NONE:
				return;
			case STONE:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247d" + "Stone-like -> " + Objects.requireNonNull(Block.REGISTRY.getNameForObject(block)).toString()));
				Minecraft.getMinecraft().player.sendChatMessage("/veinminer blocklist pickaxe add " + Objects.requireNonNull(Block.REGISTRY.getNameForObject(block)).toString());
				break;
			case WOOD:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\2473" + "Wood-like -> " + Objects.requireNonNull(Block.REGISTRY.getNameForObject(block)).toString()));
				Minecraft.getMinecraft().player.sendChatMessage("/veinminer blocklist axe add " + Objects.requireNonNull(Block.REGISTRY.getNameForObject(block)).toString());
				break;
			case DIRT:
				Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\2476" + "Dirt-like -> " + Objects.requireNonNull(Block.REGISTRY.getNameForObject(block)).toString()));
				Minecraft.getMinecraft().player.sendChatMessage("/veinminer blocklist shovel add " + Objects.requireNonNull(Block.REGISTRY.getNameForObject(block)).toString());
				break;

		}
		Minecraft.getMinecraft().player.sendChatMessage("/veinminer saveconfig");
	}

}
