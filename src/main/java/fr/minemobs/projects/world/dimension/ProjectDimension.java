package fr.minemobs.projects.world.dimension;

import net.minecraft.client.audio.MusicTicker.MusicType;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

import java.util.function.Supplier;

import fr.minemobs.projects.ProjectMain;

public class ProjectDimension extends Dimension {

    public ProjectDimension(World world, DimensionType type) {
        super(world, type , 0.0f);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator() {
        return new ProjectChunkGenerator(world,
                new ProjectBiomeProvider(new ProjectBiomeProviderSettings(this.world.getWorldInfo())),
                new ProjectGenSettings());
    }

    @Override
    public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
        return null;
    }

    @Override
    public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
        return null;
    }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) {
        int j = 6000;
        float f1 = (j + partialTicks) / 24000.0f - 0.25f;
        if (f1 < 0.0f) {
            f1 += 1.0f;
        }

        if (f1 > 1.0f) {
            f1 -= 1.0f;
        }

        float f2 = f1;
        f1 = 1.0f - (float) ((Math.cos(f1 * Math.PI) + 1.0d) / 2.0d);
        f1 = f2 + (f1 - f2) / 3.0f;
        return f1;
    }

    @Override
    public boolean isSurfaceWorld() {
        return false;
    }

    @Override
    public Vec3d getFogColor(float celestialAngle, float partialTicks) {
        return Vec3d.ZERO;
    }
    
    @Override
    public boolean isSkyColored() {
    	return true;
    }
    
    @Override
    public MusicType getMusicType() {
    	return MusicType.GAME;
    }
    
    @Override
    public boolean canRespawnHere() {
        return true;
    }

    @Override
    public boolean doesXZShowFog(int x, int z) {
        return false;
    }

    @Override
    public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
        player.sendMessage(new TranslationTextComponent("message." + ProjectMain.MOD_ID + ".kaboom"));
        return SleepResult.BED_EXPLODES;
    }

    @Override
    public boolean hasSkyLight() {
        return true;
    }

    @Override
    public int getActualHeight() {
        return 256;
    }
}
