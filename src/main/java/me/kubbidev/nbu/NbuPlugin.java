package me.kubbidev.nbu;

import com.destroystokyo.paper.event.entity.PreCreatureSpawnEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NbuPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getLogger().info("Successfully registered!");
        this.getServer().getPluginManager()
                .registerEvents(this, this);
    }

    // risky cancels

    @EventHandler
    public void a(NotePlayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(EntityBlockFormEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(CauldronLevelChangeEvent e) {
        e.setCancelled(true);
    }

    // world events

    @EventHandler
    public void a(WeatherChangeEvent e) {
        if (e.getCause() != WeatherChangeEvent.Cause.COMMAND) {
            e.setCancelled(true);
        }
    }

    // block events

    @EventHandler
    public void a(BlockBurnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockFadeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockFertilizeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockFormEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockFromToEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockGrowEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockIgniteEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockPhysicsEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockPistonExtendEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockPistonRetractEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockReceiveGameEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(BlockSpreadEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(MoistureChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(SculkBloomEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(SignChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void a(SpongeAbsorbEvent e) {
        e.setCancelled(true);
    }

    // entity events

    @EventHandler
    public void a(CreatureSpawnEvent e) {
        a(e.getEntity() instanceof Player, e.getSpawnReason(), e);
    }

    @EventHandler
    public void a(PreCreatureSpawnEvent e) {
        a(e.getType() == EntityType.PLAYER, e.getReason(), e);
    }

    private void a(boolean isPlayer,
                   SpawnReason reason,
                   Cancellable cancel
    ) {

        if (isPlayer) return;
        if (reason != SpawnReason.CUSTOM) {
            cancel.setCancelled(true);
        }
    }
}
