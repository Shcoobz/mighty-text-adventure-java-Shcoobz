package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.logic.Player;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// TODO: add guit game condition for game over
// TODO: add teleport to woods, keyword "woods"
// TODO: implement back option
// TODO: add finding fang -> game win

public class Application {
  public static void main(String[] args) {
    Display display = new Display();
    Input input = new Input();

    display.printMessage("\nStarting Mighty Text Adventure by >>> Master JAVA <<<!");
    display.printMessage("\nType 'h' for a help message.");

    Map<AreaName, Area> areas = loadAreas();
    setupAreaConnections(areas);
    Player player = new Player(input.getNameFromUser(), areas.get(AreaName.STARTING_AREA));
    Game game = new Game(areas, input, display, player);
    game.run();

    display.printMessage("\nExiting from Mighty Text Adventure!");

  }

  // get random description for area in the woods
  private static String getRandomDescription(Map<AreaName, String[]> descriptions, AreaName direction) {
    Random rand = new Random();
    String[] descriptionArray = descriptions.get(direction);
    return descriptionArray[rand.nextInt(descriptionArray.length)];
  }

  // description of areas
  private static Map<AreaName, Area> loadAreas() {
    Map<AreaName, Area> areas = new HashMap<>();
    Map<AreaName, String[]> forestDescriptions = new HashMap<>();

    // ========== STARTING AREA ==========
    areas.put(AreaName.STARTING_AREA, new Area("On the muddy path, Hagrid's rustic hut stands prominently, its patchwork roof contrasting the overcast sky. Rain gently\n" +
        "mists your face, carrying scents of damp earth and woodsmoke, suggesting a fire within. A dim light shines from a\n" +
        "window, causing raindrops to shimmer. To your left, the Forbidden Forest displays muted autumn hues, punctuated by\n" +
        "occasional owl hoots and rustlings of unseen creatures."));

    // ========== SA_KNOCKING ==========
    areas.put(AreaName.SA_KNOCK, new Area("You knock on Hagrid's door, the sound contrasting the steady rain. Silence ensues; no footsteps, no reply."));

    // ========== SA_LEAVING ==========
    areas.put(AreaName.SA_LEAVE, new Area("Unsure, you turn from the hut, wrapping your cloak tighter. The path leads to Hogwarts Castle's silhouette. Its windows\n" +
        "glow like distant stars, guiding you. The rhythmic rain accompanies you, invoking memories of the castle's warm\n" +
        "corridors. Soon, Hogwarts stands tall, its walls filled with magical tales. You wonder about future adventures\n" +
        "within."));

    // ========== SA_KNOCK_AGAIN ==========
    areas.put(AreaName.SA_KNOCK_AGAIN, new Area("With renewed determination, you knock again, louder this time. The sound contrasts with the gentle rain, but soon\n" +
        "silence ensues. No sign of activity from within, the door stays still.\n"));

    // ========== SA_CALL_NAME ==========
    areas.put(AreaName.SA_CALL_NAME, new Area("\"Hagrid?\" you call out, your voice raised against the rain. Inside, there's rustling, a clink of metal, and a deep\n" +
        "muffled voice. A shadow quickly moves past a lit window."));

    // TODO: add players name
    // ========== HUT_INSIDE ==========
    areas.put(AreaName.HUT_INSIDE, new Area("'Hagrid, it's me, {add player name}!' \n" +
        "\n" +
        "After a pause, Hagrid's tear-filled face appears. \n" +
        "\n" +
        "'s that you, {insert player name}?'\n" +
        "\n" +
        "he asks, voice filled with emotion.\n" +
        "\n" +
        "As he opens the door wider, the warmth of the hut contrasts with his visible distress."));

    // ========== HI_ENTER ==========
    areas.put(AreaName.HI_ENTER, new Area("Inside Hagrid's warm hut, magical trinkets adorn the walls, gleaming in the fireplace's light. A distressed Hagrid sits,\n" +
        "his sobs breaking the room's quiet."));

    // ========== HI_LOOK_AROUND ==========
    areas.put(AreaName.HI_LOOK_AROUND, new Area("Glancing around, you note Fang's noticeable absence, with only a chew toy indicating his usual spot."));

    // ========== HI_MAKE_TEA ==========
    areas.put(AreaName.HI_MAKE_TEA, new Area("Deciding to make tea, you head to the kitchen. The comforting sounds of the kettle and teacups create a momentary\n" +
        "respite."));

    // ========== HI_ASK ==========
    areas.put(AreaName.HI_ASK, new Area("You approach Hagrid with concern. \n" +
        "\n" +
        "'Hagrid, what's happened?' \n" +
        "\n" +
        "His eyes, red from tears, meet yours, but he struggles to find words."));

    // ========== HI_SHARE_TEA ==========
    areas.put(AreaName.HI_SHARE_TEA, new Area("Offering Hagrid a cup of tea, he manages a small smile. As you sit in silence, the warm tea fosters a bond between you.\n" +
        "After a few sips, you gently ask, \n" +
        "\n" +
        "'What's happened?' \n" +
        "\n" +
        "He looks at you, his emotions raw and evident."));

    // ========== HI_DRINK_ALONE ==========
    areas.put(AreaName.HI_DRINK_ALONE, new Area("You sip your tea in a corner, giving Hagrid space. After moments of quiet, Hagrid speaks:\n" +
        "\n" +
        "'I think it's best if you leave for now.'"));

    // ========== HI_HAGRID_ANSWERS ==========
    areas.put(AreaName.HI_HAGRID_ANSWERS, new Area("Hagrid struggles with his words.\n" +
        "\n" +
        "'Yesterday, Fang ran into the Forbidden Forest. \n" +
        "I can't follow because Dumbledore's set up a barrier, I don't know how it exactly works.'"));

    // ========== HI_OPTION_KID ==========
    areas.put(AreaName.HI_OPTION_KID, new Area("'Hagrid, I wish I could help, but I'm just a kid.' \n" +
        "\n" +
        "He understands, appreciating your presence.\n"));

    // ========== HI_OPTION_TEACHER ==========
    areas.put(AreaName.HI_OPTION_TEACHER, new Area("You suggest finding a teacher, but Hagrid informs you they're away for a conference."));

    // ========== HI_OPTION_GO_ALONE ==========
    areas.put(AreaName.HI_OPTION_GO_ALONE, new Area("Bravely, you offer to enter the forest. Hagrid protests, fearing for your safety.\n" +
        "But you have made up your mind and leave."));

    // ========== SA_LEAVING ==========
    areas.put(AreaName.WAY_TO_FORREST, new Area("Approaching the Forbidden Forest, it feels foreboding, with ancient runes marking its entrance. The dark interior\n" +
        "beckons, with pathways leading left and right."));

    // ========== FORREST_ENTER ==========
    areas.put(AreaName.FORREST_ENTER, new Area("You venture into the dense forest. The environment is both magical and eerie. As you tread deeper, the responsibility of\n" +
        "finding Fang weighs heavily."));

    // ========== forestDescriptions for F_DIRECTIONS ==========

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

    // ========== F_DIRECTIONS ==========
    areas.put(AreaName.F_NORTH, new Area(getRandomDescription(forestDescriptions, AreaName.F_NORTH)));
    areas.put(AreaName.F_EAST, new Area(getRandomDescription(forestDescriptions, AreaName.F_EAST)));
    areas.put(AreaName.F_SOUTH, new Area(getRandomDescription(forestDescriptions, AreaName.F_SOUTH)));
    areas.put(AreaName.F_WEST, new Area(getRandomDescription(forestDescriptions, AreaName.F_WEST)));

    // ========== FIND_FANG ==========
    areas.put(AreaName.FIND_FANG, new Area(AreaName.FIND_FANG, "In the depths of the Forbidden Forest, where the trees were ancient and the sunlight scarce, you heard a faint whimper.\n" +
        "Following the sound, you discovered a small sunlit clearing where Fang lay, bruised and muddied but mostly unharmed. As\n" +
        "you approached, his tail wagged weakly, eyes full of relief. After a brief check and reassuring words, you and Fang\n" +
        "began your journey back to Hagrid, the forest now feeling less daunting with the loyal dog by your side."));

    // ========== GAME_OVER ==========
    areas.put(AreaName.GAME_OVER, new Area(AreaName.GAME_OVER, "Your journey has reached an unexpected crossroads. \n" +
        "\n" +
        "Whether by fate's hand or a twist of destiny, this path has ended.\n" +
        "\n" +
        "But every end is a new beginning..."));

    /* areas.put(AreaName.INFRONT_HUT, new Area("")); */

    return areas;
  }

  // action of areas
  private static void setupAreaConnections(Map<AreaName, Area> areas) {

    // ========== STARTING AREA ==========
    areas.get(AreaName.STARTING_AREA).addConnection("[Knock]", areas.get(AreaName.SA_KNOCK));
    areas.get(AreaName.STARTING_AREA).addConnection("[Leave]", areas.get(AreaName.GAME_OVER));

    // ========== SA_KNOCKING ==========
    areas.get(AreaName.SA_KNOCK).addConnection("[Knock again]", areas.get(AreaName.SA_KNOCK_AGAIN));
    areas.get(AreaName.SA_KNOCK).addConnection("[Call his name]", areas.get(AreaName.SA_CALL_NAME));
    areas.get(AreaName.SA_KNOCK).addConnection("[Leave]", areas.get(AreaName.GAME_OVER));

    // ========== SA_KNOCK_AGAIN ==========
    areas.get(AreaName.SA_KNOCK_AGAIN).addConnection("[Knock yet again]", areas.get(AreaName.SA_KNOCK));
    areas.get(AreaName.SA_KNOCK_AGAIN).addConnection("[Leave]", areas.get(AreaName.GAME_OVER));

    // ========== SA_CALL_NAME ==========
    areas.get(AreaName.SA_CALL_NAME).addConnection("[Knock yet again]", areas.get(AreaName.SA_KNOCK));

    // some mistake in next line
    areas.get(AreaName.SA_CALL_NAME).addConnection("[Reassure him]", areas.get(AreaName.HUT_INSIDE));
    areas.get(AreaName.SA_CALL_NAME).addConnection("[Leave]", areas.get(AreaName.GAME_OVER));

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
    areas.get(AreaName.HI_OPTION_GO_ALONE).addConnection("[Enter]", areas.get(AreaName.FORREST_ENTER));
    areas.get(AreaName.HI_OPTION_GO_ALONE).addConnection("[Run away in fear]", areas.get(AreaName.GAME_OVER));

    // ========== FORREST_ENTER ==========
    areas.get(AreaName.FORREST_ENTER).addConnection("[Go North]", areas.get(AreaName.F_NORTH));
    areas.get(AreaName.FORREST_ENTER).addConnection("[Go East]", areas.get(AreaName.F_EAST));
    areas.get(AreaName.FORREST_ENTER).addConnection("[Go South]", areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.FORREST_ENTER).addConnection("[Go West]", areas.get(AreaName.F_WEST));

    // ========== F_NORTH ==========
    areas.get(AreaName.F_NORTH).addConnection("[Go East]", areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_NORTH).addConnection("[Go South]", areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_NORTH).addConnection("[Go West]", areas.get(AreaName.F_WEST));

    // ========== F_EAST ==========
    areas.get(AreaName.F_EAST).addConnection("[Go North]", areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_EAST).addConnection("[Go South]", areas.get(AreaName.F_SOUTH));
    areas.get(AreaName.F_EAST).addConnection("[Go West]", areas.get(AreaName.F_WEST));

    // ========== F_SOUTH ==========
    areas.get(AreaName.F_SOUTH).addConnection("[Go North]", areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_SOUTH).addConnection("[Go East]", areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_SOUTH).addConnection("[Go West]", areas.get(AreaName.F_WEST));

    // ========== F_WEST ==========
    areas.get(AreaName.F_WEST).addConnection("[Go North]", areas.get(AreaName.F_NORTH));
    areas.get(AreaName.F_WEST).addConnection("[Go East]", areas.get(AreaName.F_EAST));
    areas.get(AreaName.F_WEST).addConnection("[Go South]", areas.get(AreaName.F_SOUTH));

    // ========== FINDING_FANG ==========

    /* areas.get(AreaName.).addConnection("[]", areas.get(AreaName.)); */

  }

}
