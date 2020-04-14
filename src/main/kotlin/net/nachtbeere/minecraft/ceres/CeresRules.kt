package net.nachtbeere.minecraft.ceres

import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Biome
import org.bukkit.event.block.BlockGrowEvent

class FarmingRationalizer(event: BlockGrowEvent, pluginInstance: Ceres) {
    private val currentEvent: BlockGrowEvent = event
    private val instance: Ceres = pluginInstance

    private fun isKnownCrops(): Boolean {
        return this.currentEvent.block.type in Constants.KNOWN_CROPS
    }

    private fun isGrowFromSunlight(): Boolean {
        val skyLightLevel = this.currentEvent.block.lightFromSky.toInt() // NOT current world's skylight level. return possible skylight level from current location.
        val realLightLevel = getCurrentLightFromWorld(this.currentEvent.block.world)
        val lightLevel = this.currentEvent.block.lightLevel.toInt()
//        instance.log("real light level is ${realLightLevel}. and block light level is ${lightLevel}/${skyLightLevel}")
        if (realLightLevel == skyLightLevel) {
            return realLightLevel == lightLevel
        } else {
            if (realLightLevel < skyLightLevel) {
                return realLightLevel == lightLevel
            }
            return false
        }
    }

    private fun isStorm(): Boolean {
        return this.currentEvent.block.world.hasStorm()
    }

    private fun cancelGrow() {
        this.currentEvent.isCancelled = true
    }

    fun rationalize() {
        if (this.isKnownCrops()) {
            if (this.isGrowFromSunlight()) {
                val calculator = GrowChanceCalculator(
                    cropType = this.currentEvent.block.type,
                    currentBiome = this.currentEvent.block.biome,
                    isStorm = this.isStorm()
                )
                if (!calculator.isGrowable()) {
                    this.cancelGrow()
                }
            } else {
                this.cancelGrow()
            }
        }
    }
}