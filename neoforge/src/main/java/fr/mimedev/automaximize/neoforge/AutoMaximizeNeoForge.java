package fr.mimedev.automaximize.neoforge;

import fr.mimedev.automaximize.AutoMaximize;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(AutoMaximize.MODID)
public class AutoMaximizeNeoForge {
    public AutoMaximizeNeoForge() {
    }

    @EventBusSubscriber(modid = AutoMaximize.MODID, value = Dist.CLIENT)
    public static class ModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            AutoMaximize.setWindowMaximizer(new NeoForgeWindowMaximizer());
            AutoMaximize.maximize();
        }
    }

//    @EventBusSubscriber(modid = AutoMaximize.MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
//    public static class ClientEvents {
//        @SubscribeEvent
//        public static void onScreenOpen(ScreenEvent.Opening event) {
//            AutoMaximize.onScreenOpen(event.getNewScreen());
//        }
//    }
}
