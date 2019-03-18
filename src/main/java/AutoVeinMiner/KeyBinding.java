package AutoVeinMiner;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

class KeyBinding {

	static net.minecraft.client.settings.KeyBinding ActivateTool;

	static void register() {
		ActivateTool = new net.minecraft.client.settings.KeyBinding("Show Stats", Keyboard.KEY_F12, "Get all the stats");
		ClientRegistry.registerKeyBinding(ActivateTool);
	}

}
