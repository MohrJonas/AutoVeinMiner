package AutoVeinMiner;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import java.util.Objects;

import static AutoVeinMiner.KeyBinding.ActivateTool;

public class Event {

	@SubscribeEvent
	public void keyPressed(InputEvent.KeyInputEvent e) {

		if (ActivateTool.isPressed()) {

			//Get the current item held in the player's hand
			Item currentItem = Minecraft.getMinecraft().player.getHeldItemMainhand().getItem();
			System.out.println(Util.getToolType(currentItem));
			//Decide on the kind of tool and execute its appropritate command
			switch (Util.getToolType(currentItem)) {
				case NONE:
					return;
				case PICKAXE:
					Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247e" + "Pickaxe -> " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(currentItem)).toString()));
					Minecraft.getMinecraft().player.sendChatMessage("/veinminer toollist pickaxe add " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(currentItem)).toString());
					Minecraft.getMinecraft().player.sendChatMessage("/veinminer saveconfig");
					return;
				case AXE:
					Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247b" + "Axe -> " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(currentItem)).toString()));
					Minecraft.getMinecraft().player.sendChatMessage("/veinminer toollist axe add " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(currentItem)).toString());
					Minecraft.getMinecraft().player.sendChatMessage("/veinminer saveconfig");
					return;
				case SHOVEL:
					Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247a" + "Shovel -> " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(currentItem)).toString()));
					Minecraft.getMinecraft().player.sendChatMessage("/veinminer toollist shovel add " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(currentItem)).toString());
					Minecraft.getMinecraft().player.sendChatMessage("/veinminer saveconfig");
					return;
				case SHEARS:
					Minecraft.getMinecraft().player.sendMessage(new TextComponentString("\247c" + "Shear -> " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(currentItem)).toString()));
					Minecraft.getMinecraft().player.sendChatMessage("/veinminer toollist shears add " + Objects.requireNonNull(Item.REGISTRY.getNameForObject(currentItem)).toString());
					Minecraft.getMinecraft().player.sendChatMessage("/veinminer saveconfig");
					return;
			}


		}
	}

}
