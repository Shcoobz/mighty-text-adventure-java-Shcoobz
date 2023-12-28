package com.codecool.mightytextadventure.data;

import java.util.*;

/**
 * Represents an area in a text-based adventure game.
 * An area is defined by its name, description, and connections to other areas.
 */
public class Area {
  private AreaName areaName;
  private final String description;
  private final Map<String, Area> connectedAreas;

  public static final String LEAVE = "[Leave]";
  public static final String NORTH = "[Go North]";
  public static final String EAST = "[Go East]";
  public static final String SOUTH = "[Go South]";
  public static final String WEST = "[Go West]";

  /**
   * Gets the name of the area.
   * @return The name of the area.
   */
  public AreaName getAreaName() {
    return this.areaName;
  }

  /**
   * Constructor for creating an area with only a description.
   * @param description The description of the area.
   */
  public Area(String description) {
    this.description = description;
    this.connectedAreas = new HashMap<>();
  }

  /**
   * Constructor for creating an area with a name and a description.
   * @param areaName The name of the area.
   * @param description The description of the area.
   */
  public Area(AreaName areaName, String description) {
    this.areaName = areaName;
    this.description = description;
    this.connectedAreas = new HashMap<>();
  }

  /**
   * Gets the description of the area.
   * @return The description of the area.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Adds a connection from this area to another area.
   * @param action The action that leads to the destination area.
   * @param destination The area to connect to.
   */
  public void addConnection(String action, Area destination) {
    connectedAreas.put(action, destination);
  }

  /**
   * Gets the area associated with a given action.
   * @param action The action to get the area for.
   * @return The area associated with the given action.
   */
  public Area getAreaForAction(String action) {
    return connectedAreas.get(action);
  }

  /**
   * Gets a list of available actions in this area.
   * @return A list of actions.
   */
  public List<String> getAvailableActions() {
    return new ArrayList<>(connectedAreas.keySet());
  }

  /**
   * Loads all predefined areas into the provided map.
   * @param areas The map to load the areas into.
   */
  public static void loadAllAreas(Map<AreaName, Area> areas) {
    areas.put(AreaName.STARTING_AREA, new Area("""
        On the muddy path, Hagrid's rustic hut stands prominently, its patchwork roof contrasting the overcast sky. Rain gently
        mists your face, carrying scents of damp earth and woodsmoke, suggesting a fire within. A dim light shines from a
        window, causing raindrops to shimmer. To your left, the Forbidden Forest displays muted autumn hues, punctuated by
        occasional owl hoots and rustlings of unseen creatures.
        """));

    areas.put(AreaName.SA_KNOCK, new Area("""
        You knock on Hagrid's door, the sound contrasting the steady rain. Silence ensues; no footsteps, no reply.
        """));

    areas.put(AreaName.SA_LEAVE, new Area("""
        Unsure, you turn from the hut, wrapping your cloak tighter. The path leads to Hogwarts Castle's silhouette. Its windows
        glow like distant stars, guiding you. The rhythmic rain accompanies you, invoking memories of the castle's warm
        corridors. Soon, Hogwarts stands tall, its walls filled with magical tales. You wonder about future adventures
        within.
        """));

    areas.put(AreaName.SA_KNOCK_AGAIN, new Area("""
        With renewed determination, you knock again, louder this time. The sound contrasts with the gentle rain, but soon
        silence ensues. No sign of activity from within, the door stays still.
        """));

    areas.put(AreaName.SA_CALL_NAME, new Area("""
        "Hagrid?" you call out, your voice raised against the rain. Inside, there's rustling, a clink of metal, and a deep
        muffled voice. A shadow quickly moves past a lit window.
        """));

    areas.put(AreaName.HUT_INSIDE, new Area("""
        'Hagrid, it's me!'
                
        After a pause, Hagrid's tear-filled face appears.
                
        's that you?'
                
        he asks, voice filled with emotion.
                
        As he opens the door wider, the warmth of the hut contrasts with his visible distress.
        """));

    areas.put(AreaName.HI_ENTER, new Area("""
        Inside Hagrid's warm hut, magical trinkets adorn the walls, gleaming in the fireplace's light. A distressed Hagrid sits,
        his sobs breaking the room's quiet.
        """));

    areas.put(AreaName.HI_LOOK_AROUND, new Area("Glancing around, you note Fang's noticeable absence, with only a chew toy indicating his usual spot."));

    areas.put(AreaName.HI_MAKE_TEA, new Area("""
        Deciding to make tea, you head to the kitchen. The comforting sounds of the kettle and teacups create a momentary
        respite.
        """));

    areas.put(AreaName.HI_ASK, new Area("""
        You approach Hagrid with concern.
                
        'Hagrid, what's happened?'
                
        His eyes, red from tears, meet yours, but he struggles to find words.
        """));

    areas.put(AreaName.HI_SHARE_TEA, new Area("""
        Offering Hagrid a cup of tea, he manages a small smile. As you sit in silence, the warm tea fosters a bond between you.
        After a few sips, you gently ask,
                
        'What's happened?'
                
        He looks at you, his emotions raw and evident.
        """));

    areas.put(AreaName.HI_DRINK_ALONE, new Area("""
        You sip your tea in a corner, giving Hagrid space. After moments of quiet, Hagrid speaks:
                
        'I think it's best if you leave for now.'
        """));

    areas.put(AreaName.HI_HAGRID_ANSWERS, new Area("""
        Hagrid struggles with his words.
                
        'Yesterday, Fang ran into the Forbidden Forest.
        I can't follow because Dumbledore's set up a barrier, I don't know how it exactly works.'
        """));

    areas.put(AreaName.HI_OPTION_KID, new Area("""
        'Hagrid, I wish I could help, but I'm just a kid.'
        
        He understands, appreciating your presence.
        """));

    areas.put(AreaName.HI_OPTION_TEACHER, new Area("You suggest finding a teacher, but Hagrid informs you they're away for a conference."));

    areas.put(AreaName.HI_OPTION_GO_ALONE, new Area("""
        Bravely, you offer to enter the forest. Hagrid protests, fearing for your safety.
        But you have made up your mind and leave.
        """));

    areas.put(AreaName.WAY_TO_FORREST, new Area("""
        Approaching the Forbidden Forest, it feels foreboding, with ancient runes marking its entrance. The dark interior
        beckons, with pathways leading left and right.
        """));

    areas.put(AreaName.FORREST_ENTER, new Area("""
    You venture into the dense forest. The environment is both magical and eerie. As you tread deeper, the responsibility of
    finding Fang weighs heavily.
    """));

    areas.put(AreaName.FIND_FANG, new Area(AreaName.FIND_FANG, """
        In the depths of the Forbidden Forest, where the trees were ancient and the sunlight scarce, you heard a faint
        whimper. Following the sound, you discovered a small sunlit clearing where Fang lay, bruised and muddied but mostly
        unharmed. As you approached, his tail wagged weakly, eyes full of relief. After a brief check and reassuring words, you and
        Fang began your journey back to Hagrid, the forest now feeling less daunting with the loyal dog by your side.

        Hagrid could not believe his eyes and was beaming with joy!
        """));

    areas.put(AreaName.GAME_OVER, new Area(AreaName.GAME_OVER, """
        Your journey has reached an unexpected crossroads.
        
        Whether by fate's hand or a twist of destiny, this path has ended.
        
        But every end is a new beginning...
        """));

    Map<AreaName, String[]> forestDescriptions = new HashMap<>();

    areas.put(AreaName.F_NORTH, new Area(AreaName.F_NORTH, getRandomDescription(forestDescriptions, AreaName.F_NORTH)));
    areas.put(AreaName.F_EAST, new Area(AreaName.F_EAST, getRandomDescription(forestDescriptions, AreaName.F_EAST)));
    areas.put(AreaName.F_SOUTH, new Area(AreaName.F_SOUTH, getRandomDescription(forestDescriptions, AreaName.F_SOUTH)));
    areas.put(AreaName.F_WEST, new Area(AreaName.F_WEST, getRandomDescription(forestDescriptions, AreaName.F_WEST)));

    forestDescriptions.put(AreaName.F_NORTH, new String[]{
        "Towering trees and thick vines envelop the area. Ahead, the land seems to rise.",
        "A clear stream crosses your path, with birdsong adding to the serenity.",
        "A mossy clearing showcases large stones arranged in a pattern, hinting at ancient magic."
    });

    forestDescriptions.put(AreaName.F_EAST, new String[]{
        "The eastern forest has patches of sky visible, with flowers that emit a soft glow.",
        "Brambles, thorns, and dewy spider webs impede your path, with fluttering wings suggesting company.",
        "Moving east, barren trees emerge and a chilling mist obscures your way"
    });

    forestDescriptions.put(AreaName.F_SOUTH, new String[]{
        "Dense underbrush fills the southern path, with a waterfall's distant echo.",
        "Ferns and glowing berries light the trail, suggesting enchantment.",
        "Venturing further south, shifting shadows and faint whispers create an eerie atmosphere."
    });

    forestDescriptions.put(AreaName.F_WEST, new String[]{
        "The western terrain becomes marshy, with audible amphibian calls.",
        "Weeping willows with drooping branches unveil hidden groves.",
        "Heading west, the scent of pine grows, with the ground hinting at foothills and rustling leaves implying hidden\n" +
            "inhabitants."
    });
  }

  /**
   * Randomly selects a description for a given direction.
   * @param descriptions The map containing descriptions.
   * @param direction The direction for which to get a description.
   * @return A randomly selected description.
   */
  private static String getRandomDescription(Map<AreaName, String[]> descriptions, AreaName direction) {
    String[] descArray = descriptions.get(direction);
    Random rand = new Random();
    return descArray[rand.nextInt(descArray.length)];
  }

  /**
   * Sets up connections between all predefined areas.
   * @param areas The map containing all areas.
   */
  public static void setupAreaConnections(Map<AreaName, Area> areas) {
    // ========== STARTING AREA ==========
    areas.get(AreaName.STARTING_AREA).addConnection("[Knock]", areas.get(AreaName.SA_KNOCK));
    areas.get(AreaName.STARTING_AREA).addConnection(LEAVE, areas.get(AreaName.GAME_OVER));

    // ========== SA_KNOCKING ==========
    areas.get(AreaName.SA_KNOCK).addConnection("[Knock again]", areas.get(AreaName.SA_KNOCK_AGAIN));
    areas.get(AreaName.SA_KNOCK).addConnection("[Call his name]", areas.get(AreaName.SA_CALL_NAME));
    areas.get(AreaName.SA_KNOCK).addConnection(LEAVE, areas.get(AreaName.GAME_OVER));

    // ========== SA_KNOCK_AGAIN ==========
    areas.get(AreaName.SA_KNOCK_AGAIN).addConnection("[Knock yet again]", areas.get(AreaName.SA_KNOCK));
    areas.get(AreaName.SA_KNOCK_AGAIN).addConnection(LEAVE, areas.get(AreaName.GAME_OVER));

    // ========== SA_CALL_NAME ==========
    areas.get(AreaName.SA_CALL_NAME).addConnection("[Knock yet again]", areas.get(AreaName.SA_KNOCK));
    areas.get(AreaName.SA_CALL_NAME).addConnection("[Reassure him]", areas.get(AreaName.HUT_INSIDE));
    areas.get(AreaName.SA_CALL_NAME).addConnection(LEAVE, areas.get(AreaName.GAME_OVER));

    // ========== HUT_INSIDE ==========
    areas.get(AreaName.HUT_INSIDE).addConnection("[Enter]", areas.get(AreaName.HI_ENTER));

    // ========== HI_ENTER ==========
    areas.get(AreaName.HI_ENTER).addConnection("[Look around]", areas.get(AreaName.HI_LOOK_AROUND));
    areas.get(AreaName.HI_ENTER).addConnection("[Make Tea]", areas.get(AreaName.HI_MAKE_TEA));

    // ========== HI_LOOK_AROUND ==========
    areas.get(AreaName.HI_LOOK_AROUND).addConnection("[Ask what happened]", areas.get(AreaName.HI_ASK));

    // ========== HI_MAKE_TEA ==========
    areas.get(AreaName.HI_MAKE_TEA).addConnection("[Share tea]", areas.get(AreaName.HI_SHARE_TEA));
    areas.get(AreaName.HI_MAKE_TEA).addConnection("[Drink tea alone]", areas.get(AreaName.HI_DRINK_ALONE));

    // ========== HI_ASK ==========
    areas.get(AreaName.HI_ASK).addConnection("[Listen]", areas.get(AreaName.HI_HAGRID_ANSWERS));

    // ========== HI_SHARE_TEA ==========
    areas.get(AreaName.HI_SHARE_TEA).addConnection("[Smile reassuringly]", areas.get(AreaName.HI_HAGRID_ANSWERS));

    // ========== HI_HAGRID_ANSWERS ==========
    areas.get(AreaName.HI_HAGRID_ANSWERS).addConnection("[Say that you can't help]", areas.get(AreaName.GAME_OVER));
    areas.get(AreaName.HI_HAGRID_ANSWERS).addConnection("[Offer to find a teacher]", areas.get(AreaName.HI_OPTION_TEACHER));
    areas.get(AreaName.HI_HAGRID_ANSWERS).addConnection("[Offer to look for Fang yourself]", areas.get(AreaName.HI_OPTION_GO_ALONE));

    // ========== HI_OPTION_TEACHER ==========
    areas.get(AreaName.HI_OPTION_TEACHER).addConnection("[You're just a kid, what can you do]", areas.get(AreaName.GAME_OVER));
    areas.get(AreaName.HI_OPTION_TEACHER).addConnection("[You will go look for Fang yourself]", areas.get(AreaName.HI_OPTION_KID));

    // ========== HI_OPTION_GO_ALONE ==========
    areas.get(AreaName.HI_OPTION_GO_ALONE).addConnection("[Continue]", areas.get(AreaName.WAY_TO_FORREST));
    areas.get(AreaName.HI_OPTION_GO_ALONE).addConnection("[Run away in fear]", areas.get(AreaName.GAME_OVER));

    areas.get(AreaName.WAY_TO_FORREST).addConnection("[Enter]", areas.get(AreaName.FORREST_ENTER));
    areas.get(AreaName.WAY_TO_FORREST).addConnection("[Run away in fear]", areas.get(AreaName.GAME_OVER));

    areas.get(AreaName.FORREST_ENTER).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.FORREST_ENTER).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.FORREST_ENTER).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.FORREST_ENTER).addConnection(WEST, areas.get(AreaName.F_WEST));

    // ========== F_NORTH ==========
    areas.get(AreaName.F_NORTH).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_NORTH).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_NORTH).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_NORTH).addConnection(WEST, areas.get(AreaName.F_WEST));

    // ========== F_EAST ==========
    areas.get(AreaName.F_EAST).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_EAST).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_EAST).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_EAST).addConnection(WEST, areas.get(AreaName.F_WEST));

    // ========== F_SOUTH ==========
    areas.get(AreaName.F_SOUTH).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_SOUTH).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_SOUTH).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_SOUTH).addConnection(WEST, areas.get(AreaName.F_WEST));

    // ========== F_WEST ==========
    areas.get(AreaName.F_WEST).addConnection(NORTH, areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_WEST).addConnection(EAST, areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_WEST).addConnection(SOUTH, areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_WEST).addConnection(WEST, areas.get(AreaName.F_WEST));
  }
}