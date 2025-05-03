package antoine.vivelesfrites.lushMenu.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MondeMenu implements Listener {

    public void openMenu(Player player) {
        Inventory menu = Bukkit.createInventory(null, 27, "Menu des Mondes");


        ItemStack dirt = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta dirtMeta = dirt.getItemMeta();
        if (dirtMeta != null) {
            dirtMeta.setDisplayName(" ");
            dirt.setItemMeta(dirtMeta);
        }


        for (int i = 0; i < 27; i++) {
            menu.setItem(i, dirt);
        }


        ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta pickaxeMeta = ironPickaxe.getItemMeta();
        if (pickaxeMeta != null) {
            pickaxeMeta.setDisplayName("§6Minage");
            ironPickaxe.setItemMeta(pickaxeMeta);
        }
        menu.setItem(12, ironPickaxe);


        ItemStack grassBlock = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta grassMeta = grassBlock.getItemMeta();
        if (grassMeta != null) {
            grassMeta.setDisplayName("§aMonde Normal");
            grassBlock.setItemMeta(grassMeta);
        }
        menu.setItem(14, grassBlock);


        player.openInventory(menu);
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Menu des Mondes")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null || clickedItem.getItemMeta() == null) {
                return;
            }


            if (clickedItem.getType() == Material.IRON_PICKAXE) {
                player.closeInventory();
                Bukkit.dispatchCommand(
                        Bukkit.getConsoleSender(),
                        "tpmonde " + player.getName() + " Ressource"
                );
                Bukkit.dispatchCommand(
                        Bukkit.getConsoleSender(),
                        "betterrtp:rtp player " + player.getName()
                );
            } else if (clickedItem.getType() == Material.GRASS_BLOCK) {
                player.closeInventory();
                Bukkit.dispatchCommand(
                        Bukkit.getConsoleSender(),
                        "tpmonde " + player.getName() + " world"
                );
                Bukkit.dispatchCommand(
                        Bukkit.getConsoleSender(),
                        "betterrtp:rtp player " + player.getName()
                );
            }
        player.closeInventory();
        }
    }
}