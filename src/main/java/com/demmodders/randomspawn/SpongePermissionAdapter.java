package com.demmodders.randomspawn;
import org.spongepowered.api.entity.living.player.Player;
public class SpongePermissionAdapter {
    public static boolean spPChk(Player a, String b){
        try{
            return a.hasPermission(b);
        }catch (Throwable c){com.demmodders.randomspawn.Util.LOGGER.error("Sponge permission adapter error(granted by default): ");c.printStackTrace();return true;}
    }
}