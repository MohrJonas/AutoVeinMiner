package AutoVeinMiner;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "avm", version = "1.0", name = "AutoVeinMiner")
public class Init {

	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
		KeyBinding.register();
		MinecraftForge.EVENT_BUS.register(new Event());
	}

}
