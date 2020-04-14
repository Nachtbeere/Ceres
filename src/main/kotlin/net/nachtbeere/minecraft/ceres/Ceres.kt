package net.nachtbeere.minecraft.ceres

import java.util.logging.Logger
import org.bukkit.plugin.java.JavaPlugin

class Ceres : JavaPlugin() {
    val consolLogger = Logger.getLogger("Minecraft")
    var listener: CeresListener? = null

    override fun onEnable() {
        listener = CeresListener(this)
    }

    override fun onDisable() {
        listener = null
    }

    fun log(msg: String) {
        consolLogger.info("[${description.name}] $msg")
    }
}
