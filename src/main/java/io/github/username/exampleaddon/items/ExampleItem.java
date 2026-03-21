package io.github.username.exampleaddon.items;

import io.github.pylonmc.rebar.item.RebarItem;
import io.github.pylonmc.rebar.item.base.RebarInteractor;
import org.bukkit.block.Block;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jspecify.annotations.NonNull;


public class ExampleItem extends RebarItem implements RebarInteractor {

    // Items need one constructor with takes an ItemStack
    public ExampleItem(@NonNull ItemStack stack) {
        super(stack);
    }

    // Called every time to player clicks a block
    @Override
    public void onUsedToClick(@NonNull PlayerInteractEvent event, @NonNull EventPriority priority) {
        if (!event.getAction().isRightClick()) {
            return;
        }

        Block block = event.getClickedBlock();
        if (block != null) {
            block.getWorld().strikeLightning(block.getLocation());
        }
    }
}
