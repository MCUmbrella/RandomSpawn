package com.demmodders.randomspawn.events;

import com.demmodders.randomspawn.RandomSpawn;
import com.demmodders.randomspawn.Util;
import com.demmodders.randomspawn.config.RandomSpawnConfig;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.spongepowered.api.entity.living.player.Player;

@Mod.EventBusSubscriber(modid = RandomSpawn.MODID)
public class spawnWatcher {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void playerJoin(PlayerEvent.PlayerLoggedInEvent e){
        //Spawn players in random location on first join
        if (RandomSpawnConfig.randomSpawnOnFirstJoin && Util.getPlayer(e.player.getUniqueID()) == null){
            Util.teleportPlayer((EntityPlayerMP) e.player, true);
            //Trying to fix incompatibility with sponge
            try{
                Player p=(Player)e.player;
                Util.LOGGER.info("Spawn "+p.getName()+" twice because of the sponge problem");
                Util.teleportPlayer((EntityPlayerMP) e.player, true);
            }catch (Throwable ignored){}
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void playerRespawn(PlayerEvent.PlayerRespawnEvent e){
        if (!e.isEndConquered() && e.player.getBedLocation(e.player.dimension) == null) {
            Util.teleportPlayer((EntityPlayerMP) e.player ,false);
        }
    }
}
