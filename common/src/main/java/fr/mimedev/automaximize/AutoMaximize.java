package fr.mimedev.automaximize;

public class AutoMaximize {
    public static final String MODID = "automaximize";
    private static boolean firstRun = true;
    private static WindowMaximizer windowMaximizer;

    public static void setWindowMaximizer(WindowMaximizer maximizer) {
        windowMaximizer = maximizer;
    }

    public static void onScreenOpen(Object screen) {
        if (windowMaximizer != null && windowMaximizer.isTitleScreen(screen) && firstRun) {
            maximize();
        }
    }

    public static void maximize() {
        windowMaximizer.logInfo("Maximizing window (AutoMaximize)");
        windowMaximizer.maximizeWindow();
        firstRun = false;
    }

    public interface WindowMaximizer {
        boolean isTitleScreen(Object screen);

        void maximizeWindow();

        void logInfo(String message);
    }
}
