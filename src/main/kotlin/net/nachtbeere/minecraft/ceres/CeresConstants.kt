package net.nachtbeere.minecraft.ceres

import org.bukkit.Material
import org.bukkit.block.Biome

class Constants() {
    companion object {
        public val KNOWN_CROPS = arrayListOf<Material>(
            Material.WHEAT,
            Material.BEETROOTS,
            Material.CARROTS,
            Material.POTATOES,
            Material.MELON_STEM,
            Material.PUMPKIN_STEM,
            Material.BAMBOO_SAPLING,
            Material.BAMBOO,
            Material.COCOA,
            Material.SUGAR_CANE,
            Material.SWEET_BERRY_BUSH,
            Material.CACTUS
            )

        public const val GROWRATE_MIN = 0
        public const val GROWRATE_MAX = 100

        public val BIOME_POLAR = arrayListOf(
            Biome.SNOWY_MOUNTAINS,
            Biome.SNOWY_TUNDRA
        )

        public val BIOME_SUBARCTIC = arrayListOf(
            Biome.MOUNTAINS,
            Biome.TAIGA,
            Biome.TAIGA_HILLS,
            Biome.TAIGA_MOUNTAINS,
            Biome.GIANT_TREE_TAIGA,
            Biome.GIANT_TREE_TAIGA_HILLS,
            Biome.GIANT_SPRUCE_TAIGA,
            Biome.GIANT_SPRUCE_TAIGA_HILLS,
            Biome.BIRCH_FOREST,
            Biome.BIRCH_FOREST_HILLS,
            Biome.TALL_BIRCH_FOREST,
            Biome.TALL_BIRCH_HILLS,
            Biome.SNOWY_TAIGA,
            Biome.SNOWY_TAIGA_MOUNTAINS
        )

        public val BIOME_TEMPERATE = arrayListOf(
            Biome.RIVER,
            Biome.PLAINS,
            Biome.SUNFLOWER_PLAINS,
            Biome.FOREST,
            Biome.FLOWER_FOREST,
            Biome.WOODED_HILLS
        )

        public val BIOME_SUBTROPIC = arrayListOf(
            Biome.BAMBOO_JUNGLE,
            Biome.BAMBOO_JUNGLE_HILLS
        )

        public val BIOME_TROPIC = arrayListOf(
            Biome.JUNGLE,
            Biome.JUNGLE_HILLS
        )

        public val BIOME_ARID = arrayListOf(
            Biome.DESERT,
            Biome.DESERT_HILLS,
            Biome.DESERT_LAKES
        )

        public val BIOME_OCEAN = arrayListOf(
            Biome.BEACH,
            Biome.OCEAN,
            Biome.WARM_OCEAN,
            Biome.LUKEWARM_OCEAN,
            Biome.COLD_OCEAN,
            Biome.FROZEN_OCEAN,
            Biome.DEEP_COLD_OCEAN,
            Biome.DEEP_FROZEN_OCEAN,
            Biome.DEEP_LUKEWARM_OCEAN,
            Biome.DEEP_WARM_OCEAN
        )
    }
}