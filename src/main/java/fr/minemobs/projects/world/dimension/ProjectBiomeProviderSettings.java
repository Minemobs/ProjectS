package fr.minemobs.projects.world.dimension;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.IBiomeProviderSettings;
import net.minecraft.world.storage.WorldInfo;

public class ProjectBiomeProviderSettings implements IBiomeProviderSettings {

    private final long seed;
    private final WorldType worldType;
    private ProjectGenSettings generatorSettings = new ProjectGenSettings();

    public ProjectBiomeProviderSettings(WorldInfo info) {
        this.seed = info.getSeed();
        this.worldType = info.getGenerator();
    }

    public ProjectBiomeProviderSettings setGeneratorSettings(ProjectGenSettings settings) {
        this.generatorSettings = settings;
        return this;
    }

    public long getSeed() {
        return this.seed;
    }

    public WorldType getWorldType() {
        return this.worldType;
    }

    public ProjectGenSettings getGeneratorSettings() {
        return this.generatorSettings;
    }

}
