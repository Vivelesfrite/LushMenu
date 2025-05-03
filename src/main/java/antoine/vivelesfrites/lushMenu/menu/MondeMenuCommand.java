package antoine.vivelesfrites.lushMenu.menu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MondeMenuCommand implements CommandExecutor {

    private final MondeMenu menu;

    public MondeMenuCommand(MondeMenu menu) {
        this.menu = menu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seuls les joueurs peuvent exécuter cette commande !");
            return true;
        }

        Player player = (Player) sender;
        menu.openMenu(player);
        return true;
    }
}