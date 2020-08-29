package com.demmodders.randomspawn;
import org.spongepowered.api.entity.living.player.Player;
public class SpongePermissionAdapter {
    public static boolean spPChk(Player a, String b){
        try{
            return a.hasPermission(b);
        }catch (Throwable c){System.out.println("Sponge permission adapter error: ");c.printStackTrace();return false;}
    }
}