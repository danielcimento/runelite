package net.runelite.client.plugins.loottracker;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum LootEvent
{
	BARROWS("Barrows"),
	BRIMSTONE_CHEST("Brimstone Chest"),
	CHAMBERS_OF_XERIC("Chambers of Xeric"),
	CLUE_SCROLL_BEGINNER("Clue Scroll (Beginner)"),
	CLUE_SCROLL_EASY("Clue Scroll (Easy)"),
	CLUE_SCROLL_MEDIUM("Clue Scroll (Medium)"),
	CLUE_SCROLL_HARD("Clue Scroll (Hard)"),
	CLUE_SCROLL_ELITE("Clue Scroll (Elite)"),
	CLUE_SCROLL_MASTER("Clue Scroll (Master)"),
	CRYSTAL_CHEST("Crystal Chest"),
	ELVEN_CRYSTAL_CHEST("Elven Crystal Chest"),
	FISHING_TRAWLER("Fishing Trawler"),
	GAUNTLET("The Gauntlet"),
	HESPORI("Hespori"),
	HERBIBOAR("Herbiboar"),
	KINGDOM_OF_MISCELLANIA("Kingdom of Miscellania"),
	LARRANS_CHEST_BIG("Larran's big chest"),
	LARRANS_CHEST_SMALL("Larran's small chest"),
	THEATRE_OF_BLOOD("Theatre of Blood");

	final String asText;

	static final Map<Integer, LootEvent> CHEST_EVENT_LOOKUP_TABLE = ImmutableMap.of(
		5179, LootEvent.BRIMSTONE_CHEST,
		11573, LootEvent.CRYSTAL_CHEST,
		12093, LootEvent.LARRANS_CHEST_BIG,
		13113, LootEvent.LARRANS_CHEST_SMALL,
		13151, LootEvent.ELVEN_CRYSTAL_CHEST
	);

	static final List<String> COMBAT_EVENTS = ImmutableList.of(
		BARROWS, CHAMBERS_OF_XERIC, GAUNTLET, HESPORI, THEATRE_OF_BLOOD
	).stream().map(lootEvent -> lootEvent.asText).collect(Collectors.toList());

	static final List<LootEvent> DIRECT_TO_INVENTORY_EVENTS = ImmutableList.<LootEvent>builder()
		.add(HERBIBOAR, HESPORI, GAUNTLET)
		.addAll(CHEST_EVENT_LOOKUP_TABLE.values())
		.build();

	static final Map<String, LootEvent> CLUE_SCROLL_LOOKUP_TABLE = ImmutableMap.<String, LootEvent>builder()
		.put("beginner", CLUE_SCROLL_BEGINNER)
		.put("easy", CLUE_SCROLL_EASY)
		.put("medium", CLUE_SCROLL_MEDIUM)
		.put("hard", CLUE_SCROLL_HARD)
		.put("elite", CLUE_SCROLL_ELITE)
		.put("master", CLUE_SCROLL_MASTER)
		.build();

	LootEvent(String asText)
	{
		this.asText = asText;
	}
}
