package fr.mimedev.automaximize.neoforge;

import com.mojang.logging.LogUtils;
import fr.mimedev.automaximize.AutoMaximize;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.TitleScreen;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;

public class NeoForgeWindowMaximizer implements AutoMaximize.WindowMaximizer {
    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public boolean isTitleScreen(Object screen) {
        return screen instanceof TitleScreen;
    }

    @Override
    public void maximizeWindow() {
        GLFW.glfwMaximizeWindow(Minecraft.getInstance().getWindow().getWindow());
    }

    @Override
    public void logInfo(String message) {
        LOGGER.info(message);
    }
}
