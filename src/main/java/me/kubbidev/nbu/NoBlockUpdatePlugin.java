package me.kubbidev.nbu;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("CommentedOutCode")
public final class NoBlockUpdatePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Successfully registered!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    // risky cancels

    @EventHandler(priority = EventPriority.HIGH)
    public void a(NotePlayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(EntityBlockFormEvent e) {
        e.setCancelled(true);
    }

//    @EventHandler(priority = EventPriority.HIGH)
//    public void a(CauldronLevelChangeEvent e) {
//        e.setCancelled(true);
//    }

    // world events

    @EventHandler(priority = EventPriority.HIGH)
    public void a(WeatherChangeEvent e) {
//        if (e.getCause() != WeatherChangeEvent.Cause.COMMAND) {
        e.setCancelled(true);
//        }
    }

    // block events

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockBurnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockFadeEvent e) {
        e.setCancelled(true);
    }

//    @EventHandler(priority = EventPriority.HIGH)
//    public void a(BlockFertilizeEvent e) {
//        e.setCancelled(true);
//    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockFormEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockFromToEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockGrowEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockIgniteEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockPhysicsEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockPistonExtendEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockPistonRetractEvent e) {
        e.setCancelled(true);
    }

//    @EventHandler(priority = EventPriority.HIGH)
//    public void a(BlockReceiveGameEvent e) {
//        e.setCancelled(true);
//    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(BlockSpreadEvent e) {
        e.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(LeavesDecayEvent e) {
        e.setCancelled(true);
    }

//    @EventHandler(priority = EventPriority.HIGH)
//    public void a(MoistureChangeEvent e) {
//        e.setCancelled(true);
//    }

//    @EventHandler(priority = EventPriority.HIGH)
//    public void a(SculkBloomEvent e) {
//        e.setCancelled(true);
//    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(SignChangeEvent e) {
        e.setCancelled(true);
    }

//    @EventHandler(priority = EventPriority.HIGH)
//    public void a(SpongeAbsorbEvent e) {
//        e.setCancelled(true);
//    }

    // entity events

//    @EventHandler(priority = EventPriority.HIGH)
//    public void a(PreCreatureSpawnEvent e) {
//        handleCreatureSpawn(e.getType() == EntityType.PLAYER, e.getReason(), e);
//    }

    @EventHandler(priority = EventPriority.HIGH)
    public void a(CreatureSpawnEvent e) {
        handleCreatureSpawn(e.getEntity() instanceof Player, e.getSpawnReason(), e);
    }

    private void handleCreatureSpawn(
            boolean isPlayer,
            SpawnReason reason,
            Cancellable cancel
    ) {
        if (isPlayer) return;
        if (reason != SpawnReason.CUSTOM) {
            cancel.setCancelled(true);
        }
    }
}
