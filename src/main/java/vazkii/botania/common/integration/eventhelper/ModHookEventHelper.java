package vazkii.botania.common.integration.eventhelper;

import com.gamerforea.eventhelper.util.EventUtils;
import cpw.mods.fml.common.Loader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import vazkii.botania.common.Botania;

import javax.annotation.Nonnull;

public class ModHookEventHelper {

   public static boolean initialized = false;

   public static void initialize() {
      initialized = Loader.isModLoaded(getModID());
      if(initialized) {
         Botania.logger.info("[FCEventHelper DirectInjection] - EventHelper has been enabled on Botania!");
      }
   }

   public static String getModID() {
      return "EventHelper";
   }

   public static boolean cantBreak(@Nonnull EntityPlayer player, double x, double y, double z){
      if (initialized){
         return EventUtils.cantBreak(player,x,y,z);
      }
      return false;
   }

   public static boolean cantAttack(@Nonnull Entity attacker, @Nonnull Entity victim){
      if (initialized){
         return EventUtils.cantDamage(attacker,victim);
      }
      return false;
   }


}
