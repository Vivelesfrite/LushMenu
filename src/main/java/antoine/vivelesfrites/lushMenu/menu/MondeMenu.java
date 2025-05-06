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
        Inventory menu = Bukkit.createInventory(null, 27, "Mondes");

        ItemStack fill = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillMeta = fill.getItemMeta();
        if (fillMeta != null) {
            fillMeta.setDisplayName(" ");
            fill.setItemMeta(fillMeta);
        }

        for (int i = 0; i < 27; i++) {
            menu.setItem(i, fill);
        }

        ItemStack ironPickaxe = new ItemStack(Material.IRON_PICKAXE);
        ItemMeta pickaxeMeta = ironPickaxe.getItemMeta();
        if (pickaxeMeta != null) {
            pickaxeMeta.setDisplayName("§6Monde Ressource 🪓");
            ironPickaxe.setItemMeta(pickaxeMeta);
        }
        menu.setItem(14, ironPickaxe);

        ItemStack grassBlock = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta grassMeta = grassBlock.getItemMeta();
        if (grassMeta != null) {
            grassMeta.setDisplayName("§6Monde Normal \uD83C\uDF32");
            grassBlock.setItemMeta(grassMeta);
        }
        menu.setItem(12, grassBlock);

        ItemStack leaveBlock = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta leaveMeta = leaveBlock.getItemMeta();
        if (leaveMeta != null) {
            leaveMeta.setDisplayName("§cFermé");
            leaveBlock.setItemMeta(leaveMeta);
        }
        menu.setItem(26, leaveBlock);


        player.openInventory(menu);
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Mondes")) {
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
                        "betterrtp:rtp player " + player.getName() + " Ressource"
                );
            } else if (clickedItem.getType() == Material.GRASS_BLOCK) {
                player.closeInventory();
                Bukkit.dispatchCommand(
                        Bukkit.getConsoleSender(),
                        "betterrtp:rtp player " + player.getName() + " world"
                );
            }
            if (clickedItem.getType() == Material.RED_STAINED_GLASS_PANE) {
                player.closeInventory();
            }
        //player.closeInventory();
        }
    }
}