package net.nachtbeere.minecraft.ceres

import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.block.data.Ageable

fun getCurrentLightFromWorld(world: World): Int {
    var currentLight = 15
    val currentTime = world.time
    if (currentTime >= 12000) {
        var lightByTime = ((currentTime - 12000) / 135)
        if (lightByTime > 10) {
            lightByTime = 10
        }
        currentLight = (15 - lightByTime).toInt()
    }
    if (world.hasStorm() && currentLight >= 8) {
        currentLight -= 3
    }
    return currentLight
}

class GrowChanceCalculator(private val cropType: Material,
                           private val currentBiome: Biome,
                           private val isStorm: Boolean) {
    val magicNumber = (Constants.GROWRATE_MIN..Constants.GROWRATE_MAX).random()

    private fun growChanceByCrop(): Int {
        return when (cropType) {
            Material.WHEAT_SEEDS -> this.wheatGrowChance()
            Material.BEETROOTS -> this.beetrootsGrowChance()
            Material.CARROTS -> this.carrotsGrowChance()
            Material.POTATOES -> this.potatoesGrowChance()
            Material.MELON_STEM -> this.melonGrowChance()
            Material.PUMPKIN_STEM -> this.pumpkinGrowChance()
            Material.BAMBOO_SAPLING -> this.bambooGrowChance()
            Material.BAMBOO -> this.bambooGrowChance()
            Material.COCOA -> this.cocoaGrowChance()
            Material.SUGAR_CANE -> this.sugarCaneGrowChance()
            Material.SWEET_BERRY_BUSH -> this.sweetBerriesGrowChance()
            Material.CACTUS -> this.cactusGrowChance()
            // Currently unused.
            Material.KELP -> this.kelpGrowChance()
            else -> this.commonGrowChance()
        }
    }

    private fun growRate(rate: Int): Int {
        return (Constants.GROWRATE_MIN..rate).random()
    }

    private fun isAtari(chance: Int): Boolean {
        if (this.isStorm) {
            return magicNumber + 10 <= chance
        }
        return magicNumber <= chance
    }

    private fun commonGrowChance(): Int {
        return Constants.GROWRATE_MAX
    }

    private fun wheatGrowChance(): Int {
        return if (Constants.BIOME_TEMPERATE.contains(this.currentBiome) ||
                   Constants.BIOME_SUBARCTIC.contains(this.currentBiome) ||
                   Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_TROPIC.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            this.growRate((Constants.GROWRATE_MAX/100))
        }
    }

    private fun beetrootsGrowChance(): Int {
        return if (Constants.BIOME_TEMPERATE.contains(this.currentBiome) ||
                   Constants.BIOME_SUBARCTIC.contains(this.currentBiome) ||
                   Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_TROPIC.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            this.growRate((Constants.GROWRATE_MAX/100))
        }
    }

    private fun carrotsGrowChance(): Int {
        return if (Constants.BIOME_TEMPERATE.contains(this.currentBiome) ||
                   Constants.BIOME_SUBARCTIC.contains(this.currentBiome) ||
                   Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_TROPIC.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            this.growRate((Constants.GROWRATE_MAX/100))
        }
    }

    private fun potatoesGrowChance(): Int {
        return if (Constants.BIOME_TEMPERATE.contains(this.currentBiome) ||
                   Constants.BIOME_SUBARCTIC.contains(this.currentBiome) ||
                   Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_TROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_ARID.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            this.growRate((Constants.GROWRATE_MAX/100))
        }
    }

    private fun melonGrowChance(): Int {
        return if (Constants.BIOME_TEMPERATE.contains(this.currentBiome) ||
                   Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_TROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_ARID.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            if (Constants.BIOME_SUBARCTIC.contains(this.currentBiome)) {
                this.growRate((Constants.GROWRATE_MAX/20))
            } else {
                this.growRate((Constants.GROWRATE_MAX/100))
            }
        }
    }

    private fun pumpkinGrowChance(): Int {
        return if (Constants.BIOME_TEMPERATE.contains(this.currentBiome) ||
                   Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_TROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_SUBARCTIC.contains(this.currentBiome) ||
                   Constants.BIOME_ARID.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            this.growRate((Constants.GROWRATE_MAX/100))
        }
    }

    private fun bambooGrowChance(): Int {
        return if (Constants.BIOME_TEMPERATE.contains(this.currentBiome) ||
            Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
            Constants.BIOME_TROPIC.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            if (Constants.BIOME_SUBARCTIC.contains(this.currentBiome)) {
                this.growRate((Constants.GROWRATE_MAX/20))
            } else {
                this.growRate((Constants.GROWRATE_MAX/100))
            }
        }
    }

    private fun cocoaGrowChance(): Int {
        return if (Constants.BIOME_TROPIC.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            this.growRate((Constants.GROWRATE_MAX/100))
        }
    }

    private fun sugarCaneGrowChance(): Int {
        return if (Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_TROPIC.contains(this.currentBiome) ||
                   Constants.BIOME_ARID.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            if (Constants.BIOME_TEMPERATE.contains(this.currentBiome) ||
                Constants.BIOME_SUBARCTIC.contains(this.currentBiome)) {
                this.growRate((Constants.GROWRATE_MAX/20))
            } else {
                this.growRate((Constants.GROWRATE_MAX/100))
            }
        }
    }

    private fun sweetBerriesGrowChance(): Int {
        return if (Constants.BIOME_SUBARCTIC.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            if (Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
                Constants.BIOME_TEMPERATE.contains(this.currentBiome)) {
                this.growRate((Constants.GROWRATE_MAX/20))
            } else {
                this.growRate((Constants.GROWRATE_MAX/100))
            }
        }
    }

    private fun cactusGrowChance(): Int {
        return if (Constants.BIOME_ARID.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            if (Constants.BIOME_TEMPERATE.contains(this.currentBiome) ||
                Constants.BIOME_SUBTROPIC.contains(this.currentBiome) ||
                Constants.BIOME_TROPIC.contains(this.currentBiome)) {
                this.growRate((Constants.GROWRATE_MAX/20))
            } else {
                this.growRate((Constants.GROWRATE_MAX/100))
            }
        }
    }

    private fun kelpGrowChance(): Int {
        return if (Constants.BIOME_OCEAN.contains(this.currentBiome)) {
            this.growRate(Constants.GROWRATE_MAX)
        } else {
            this.growRate((Constants.GROWRATE_MAX/20))
        }
    }

    fun isGrowable(): Boolean {
        val growChance = this.growChanceByCrop()
        return this.isAtari(growChance)
    }
}

class DeathOrWeedCalculator(private val cropData: Block) {
    val magicNumber = (Constants.GROWRATE_MIN..Constants.GROWRATE_MAX).random()

    private fun deathChanceByCrop(): DeathOrWeedResult {
        return when (cropData.type) {
            Material.WHEAT_SEEDS -> this.sproutCrop()
            Material.BEETROOTS -> this.sproutCrop()
            Material.CARROTS -> this.sproutCrop()
            Material.POTATOES -> this.sproutCrop()
            Material.MELON_STEM -> this.sproutCrop()
            Material.PUMPKIN_STEM -> this.sproutCrop()
            Material.BAMBOO_SAPLING -> this.sproutCrop()
            Material.BAMBOO -> this.nonSproutCrop()
            Material.COCOA -> this.nonSproutCrop()
            Material.SUGAR_CANE -> this.nonSproutCrop()
            Material.SWEET_BERRY_BUSH -> this.sproutCrop()
            Material.CACTUS -> this.nonSproutCrop()
            // Currently unused.
            Material.KELP -> this.nonSproutCrop()
            else -> this.nonSproutCrop()
        }
    }

    private fun castAsAgeable(): Ageable? {
        return cropData.blockData as? Ageable
    }

    private fun sproutCrop(): DeathOrWeedResult {
        val ageableCrop = this.castAsAgeable()
        return if (ageableCrop != null) {
            if (ageableCrop.age < (ageableCrop.maximumAge % 2)) {
                if (magicNumber <= deathRate()) {
                    DeathOrWeedResult.PASS
                } else {
                    when((0..1).random()) {
                        0 -> DeathOrWeedResult.DEATH
                        else -> DeathOrWeedResult.WEED
                    }
                }
            } else {
                DeathOrWeedResult.PASS
            }
        } else {
            DeathOrWeedResult.PASS
        }
    }

    private fun nonSproutCrop(): DeathOrWeedResult {
        return DeathOrWeedResult.PASS
    }

    private fun deathRate(): Int {
        return (Constants.GROWRATE_MIN..50).random()
    }

    fun calculate(): DeathOrWeedResult {
        return deathChanceByCrop()
    }
}
