package com.matumokencave.plugin.test.testplugin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class BlockPlace implements Listener {

  public BlockPlace(Plugin plugin) {
    // ここで登録している
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public void playerblockset(BlockPlaceEvent e) {
    Block block = e.getBlock(); // 設置したブロックを取得
    if (block.getType() == Material.BEDROCK) {
      block.setType(Material.AIR);
    }
  }

  /**
   * イベントの登録を解除します
   */
  public void unregister() {
    // 以下の様に、イベントクラス側から解除する事も可能
    BlockPlaceEvent.getHandlerList().unregister(this);
    HandlerList.unregisterAll(this);
  }
}