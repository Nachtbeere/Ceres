package net.nachtbeere.minecraft.ceres

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockGrowEvent

class CeresListener(pluginInstance: Ceres) : Listener {
    init {
        pluginInstance.server.pluginManager.registerEvents(this, pluginInstance)
    }
    private val instance = pluginInstance

    @EventHandler(priority = EventPriority.NORMAL)
    fun onCropsGrown(event: BlockGrowEvent) {
        val farmingRationalizer = FarmingRationalizer(event, instance)
        farmingRationalizer.rationalize()
    }
}