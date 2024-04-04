package cursedbread.silksword;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemHelper;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class ItemsMod implements ModInitializer, GameStartEntrypoint {
    public static final String MOD_ID = "silksword";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("A");
    }

	public static int itemId;

	static {
		Properties prop = new Properties();
		prop.setProperty("starting_item_id", "17000");
		ConfigHandler config = new ConfigHandler(MOD_ID, prop);

		itemId = config.getInt("starting_item_id");

		config.updateConfig();
	}

	public static Item mobSoul;

	@Override
	public void beforeGameStart() {
		mobSoul = ItemHelper.createItem(MOD_ID, new Item("soul", itemId++), "soul.png");
	}

	@Override
	public void afterGameStart() {

	}
}
