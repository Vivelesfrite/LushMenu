package antoine.vivelesfrites.lushMenu;

import antoine.vivelesfrites.lushMenu.menu.MondeMenu;

import antoine.vivelesfrites.lushMenu.menu.MondeMenuCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;


public final class LushMenu extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        MondeMenu menu = new MondeMenu();
        getServer().getPluginManager().registerEvents(menu, this);

        this.getCommand("rtp").setExecutor(new MondeMenuCommand(menu));


        getLogger().info(" _               _    ___  ___                 ");
        getLogger().info("| |             | |   |  \\/  |                 ");
        getLogger().info("| |    _   _ ___| |__ | .  . | ___ _ __  _   _ ");
        getLogger().info("| |   | | | / __| '_ \\| |\\/| |/ _ \\ '_ \\| | | |");
        getLogger().info("| |___| |_| \\__ \\ | | | |  | |  __/ | | | |_| |");
        getLogger().info("\\_____/\\__,_|___/_| |_\\_|  |_/\\___|_| |_|\\__,_|");
        getLogger().info("Plugin activée");

    }

    @EventHandler


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
