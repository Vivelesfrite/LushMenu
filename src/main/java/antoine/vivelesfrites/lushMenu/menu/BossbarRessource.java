package antoine.vivelesfrites.lushMenu.menu;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import net.kyori.adventure.text.Component;

public class BossbarRessource {

    private final Plugin plugin;

    public BossbarRessource(Plugin plugin) {
        this.plugin = plugin;
    }

    public void start() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                World world = player.getWorld();
                if (world.getName().equalsIgnoreCase("ressource")) {
                    player.sendActionBar(Component.text("🪓 Vous êtes dans le monde ressource !", NamedTextColor.RED));
                } else {
                    player.sendActionBar(Component.empty());
                }
            }
        }, 0L, 40L);
    }
}