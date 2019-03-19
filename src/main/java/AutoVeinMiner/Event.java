package AutoVeinMiner;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

import static AutoVeinMiner.KeyBinding.ActivateTool;

public class Event {

	@SubscribeEvent
	public void keyPressed(InputEvent.KeyInputEvent e) {

		if (ActivateTool.isPressed()) {
			if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {

				Block blockAimedAt = Minecraft.getMinecraft().world.getBlockState(Minecraft.getMinecraft().objectMouseOver.getBlockPos()).getBlock();

				Util.addBlock(Util.getBlockType(blockAimedAt), blockAimedAt);
			} else {

				Item itemInHand = Minecraft.getMinecraft().player.getHeldItemMainhand().getItem();

				Util.addTool(Util.getToolType(itemInHand), itemInHand);
			}
		}
	}

}
