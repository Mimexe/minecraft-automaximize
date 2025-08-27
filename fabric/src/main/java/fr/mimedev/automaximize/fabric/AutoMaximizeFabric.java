package fr.mimedev.automaximize.fabric;

import fr.mimedev.automaximize.AutoMaximize;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;

public class AutoMaximizeFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutoMaximize.setWindowMaximizer(new FabricWindowMaximizer());

        ScreenEvents.AFTER_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            AutoMaximize.onScreenOpen(screen);
        });
    }
}
