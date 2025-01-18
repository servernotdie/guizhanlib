package net.guizhanss.guizhanlib.slimefun.addon;

import com.google.common.base.Preconditions;
import com.tcoded.folialib.FoliaLib;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * A class for scheduling tasks.
 * Modified from InfinityLib
 *
 * @author Mooy1
 * @author ybw0014
 */
@ParametersAreNonnullByDefault
@SuppressWarnings("ConstantConditions")
public final class Scheduler {

    private final FoliaLib foliaLib;

    public Scheduler(@Nonnull JavaPlugin plugin) {
        Preconditions.checkArgument(plugin != null, "Plugin instance cannot be null");

        this.foliaLib = new FoliaLib(plugin);
    }

    public void run(@Nonnull Runnable runnable) {
        foliaLib.getScheduler().runNextTick(wrappedTask -> runnable.run());
    }

    public void runAsync(@Nonnull Runnable runnable) {
        foliaLib.getScheduler().runAsync(wrappedTask -> runnable.run());
    }

    public void run(int delayTicks, @Nonnull Runnable runnable) {
        foliaLib.getScheduler().runLater(runnable, delayTicks);
    }

    public void runAsync(int delayTicks, @Nonnull Runnable runnable) {
        foliaLib.getScheduler().runLaterAsync(runnable, delayTicks);
    }

    public void repeat(int intervalTicks, @Nonnull Runnable runnable) {
        repeat(intervalTicks, 1, runnable);
    }

    public void repeatAsync(int intervalTicks, @Nonnull Runnable runnable) {
        repeatAsync(intervalTicks, 1, runnable);
    }

    public void repeat(int intervalTicks, int delayTicks, @Nonnull Runnable runnable) {
        foliaLib.getScheduler().runTimer(runnable, delayTicks, Math.max(1, intervalTicks));
    }

    public void repeatAsync(int intervalTicks, int delayTicks, @Nonnull Runnable runnable) {
        foliaLib.getScheduler().runTimerAsync(runnable, delayTicks, Math.max(1, intervalTicks));
    }
}
