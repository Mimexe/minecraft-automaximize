package fr.mimedev.automaximize;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;

@Mod(Automaximize.MODID)
public class Automaximize {

    public static final String MODID = "automaximize";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static boolean firstRun = true;

    public Automaximize() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onScreenOpen(ScreenEvent.Opening event) {
            if (event.getNewScreen() instanceof TitleScreen) {
                if (!firstRun) {
                    return;
                }
                LOGGER.info("Maximizing window");
                LOGGER.info("Thanks for installing AutoMaximize");
                GLFW.glfwMaximizeWindow(Minecraft.getInstance().getWindow().getWindow());
                firstRun = false;
            }
        }
    }
}
