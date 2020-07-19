package fr.minemobs.projects.init;

import fr.minemobs.projects.ProjectMain;
import fr.minemobs.projects.world.biomes.ProjectBiome;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.Biome.RainType;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, ProjectMain.MOD_ID);
	
			public static final RegistryObject<Biome> PROJECT_BIOME = BIOMES.register("project_biome",
					() -> new ProjectBiome(new Biome.Builder().precipitation(RainType.SNOW).scale(1.2f).temperature(0.5f)
							.waterColor(16724639).waterFogColor(16762304)
							.surfaceBuilder(SurfaceBuilder.DEFAULT,
									new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
											Blocks.DIRT.getDefaultState(),
											Blocks.STONE.getDefaultState()))
							.category(Category.PLAINS).downfall(0.3f).depth(0.18f).parent(null)));

			public static void registerBiomes() {
				registerBiome(PROJECT_BIOME.get(), Type.PLAINS, Type.OVERWORLD);
			}

			private static void registerBiome(Biome biome, Type... types) {
				BiomeManager.addBiome(BiomeType.COOL, new BiomeEntry(biome, 100));
				BiomeDictionary.addTypes(biome, types);
				BiomeManager.addSpawnBiome(biome);
			}
	
}
