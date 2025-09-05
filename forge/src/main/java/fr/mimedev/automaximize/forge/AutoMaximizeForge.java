package fr.mimedev.automaximize.forge;

import fr.mimedev.automaximize.AutoMaximize;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(AutoMaximize.MODID)
public class AutoMaximizeForge {
    public AutoMaximizeForge() {
    }

    @Mod.EventBusSubscriber(modid = AutoMaximize.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            AutoMaximize.setWindowMaximizer(new ForgeWindowMaximizer());
            AutoMaximize.maximize();
        }
    }

//    @Mod.EventBusSubscriber(modid = AutoMaximize.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
//    public static class ClientEvents {
//        @SubscribeEvent
//        public static void onScreenOpen(ScreenEvent.Opening event) {
//            AutoMaximize.onScreenOpen(event.getNewScreen());
//        }
//    }
}
