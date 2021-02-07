package com.matumokencave.plugin.test.testplugin;

import java.util.Optional;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
// import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class RideAnimal implements Listener {

  public RideAnimal(Plugin plugin) {
    // ここで登録している
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  // public void playerentityclicke(PlayerInteractAtEntityEvent e, EntityTargetLivingEntityEvent en) {
  public void playerentityclicke(PlayerInteractAtEntityEvent e) {
    // クリックしたエンティティ取得
    Entity entity = e.getRightClicked();
    // エンティティをクリックしたプレイヤー
    Player player = e.getPlayer();
    // Entity entity2 = en.getTarget();
    // if (entity == entity2 ){
      // 棒を持っているときのみ
      ItemStack mainHand = player.getInventory().getItemInMainHand();
      if (mainHand.getType() == Material.STICK) {
        // 乗るぜ
        Optional.ofNullable(player.getVehicle()).ifPresent(p -> p.removePassenger(player));
        entity.addPassenger(player);
        // entity.getEquipment().setItemInHand(Material.SADDLE);
      }
    // }
  }

  /**
   * イベントの登録を解除します
   */
  public void unregister() {
    // 以下の様に、イベントクラス側から解除する事も可能
    PlayerInteractAtEntityEvent.getHandlerList().unregister(this);
    HandlerList.unregisterAll(this);
  }
}
