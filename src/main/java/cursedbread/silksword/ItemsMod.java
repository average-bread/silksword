package cursedbread.silksword;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;


public class ItemsMod implements ModInitializer, GameStartEntrypoint {
    public static final String MOD_ID = "silksword";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("SilkSword initialized!");
    }

	public static int itemId;

	static {
		Properties prop = new Properties();
		prop.setProperty("starting_item_id", "17800");
		ConfigHandler config = new ConfigHandler(MOD_ID, prop);

		itemId = config.getInt("starting_item_id");

		config.updateConfig();
	}

	public static Item mobSoul;

	@Override
	public void beforeGameStart() {
		mobSoul = new ItemBuilder(MOD_ID)
		    .setIcon("silksword:item/soul")
		    .build(new Item("soul", itemId++));
	}

	@Override
	public void afterGameStart() {

	}
}
