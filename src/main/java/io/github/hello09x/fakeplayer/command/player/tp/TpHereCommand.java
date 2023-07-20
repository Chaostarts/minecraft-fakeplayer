package io.github.hello09x.fakeplayer.command.player.tp;

import io.github.hello09x.fakeplayer.command.MessageException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.RED;

public class TpHereCommand extends AbstractTpCommand {

    public final static TpHereCommand instance = new TpHereCommand(
            "传送假人到身边",
            "/fp tphere [假人名称]",
            "fakeplayer.tp"
    );

    public TpHereCommand(
            @NotNull String description,
            @NotNull String usage,
            @Nullable String permission
    ) {
        super(description, usage, permission);
    }

    @Override
    protected boolean execute(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String[] args
    ) {
        if (!(sender instanceof Player creator)) {
            sender.sendMessage(text("你不是玩家...", RED));
            return true;
        }

        var target = getTarget(creator, args);
        if (target == null) {
            return false;
        }

        super.teleport(target, creator);
        return true;
    }


}
