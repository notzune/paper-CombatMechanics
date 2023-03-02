package tk.airshipcraft.papercombatmechanics;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class CombatMechanics extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new DamageListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        // seems like there should be a better way of doing this...
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (!(entity instanceof Player)) {
                    entity.remove();
                    // Used to prevent outdated entities
                }
            }
        }
    }
}
