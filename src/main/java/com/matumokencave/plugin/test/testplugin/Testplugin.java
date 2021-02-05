package com.matumokencave.plugin.test.testplugin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Testplugin extends JavaPlugin {

  // 起動時処理
  @Override
  public void onEnable() {
    // Plugin startup logic
    getLogger().info("プラグインが開始しました");
  }

  // コマンド実行処理
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    // test コマンドの処理
    if (cmd.getName().equalsIgnoreCase("present")) {
      // 取りあえずログ出力して終わる
      Date date = new Date();
      DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
      String formattedDate = dateFormat.format(date);
      getLogger().info("present");
      getServer().broadcastMessage(formattedDate);
    }
    // 該当するコマンド無し
    return false;
  }

  // 終了時処理
  @Override
  public void onDisable() {
    // Plugin shutdown logic
    getLogger().info("プラグインが停止しました");
  }
}
