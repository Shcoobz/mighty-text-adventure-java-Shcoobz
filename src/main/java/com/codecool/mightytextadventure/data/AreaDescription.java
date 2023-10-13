package com.codecool.mightytextadventure.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AreaDescription {

  // get random description for area in the woods
  private static String getRandomDescription(Map<AreaName, String[]> descriptions, AreaName direction) {
    Random rand = new Random();
    String[] descriptionArray = descriptions.get(direction);
    return descriptionArray[rand.nextInt(descriptionArray.length)];
  }

  // starting area rooms
  private static void loadStartingArea(Map<AreaName, Area> areas) {
    areas.put(AreaName.STARTING_AREA, new Area("On the muddy path, Hagrid's rustic hut stands prominently, its patchwork roof contrasting the overcast sky. Rain gently\n" +
        "mists your face, carrying scents of damp earth and woodsmoke, suggesting a fire within. A dim light shines from a\n" +
        "window, causing raindrops to shimmer. To your left, the Forbidden Forest displays muted autumn hues, punctuated by\n" +
        "occasional owl hoots and rustlings of unseen creatures."));
  }

  private static void loadSAKnocking(Map<AreaName, Area> areas) {
    areas.put(AreaName.SA_KNOCK, new Area("You knock on Hagrid's door, the sound contrasting the steady rain. Silence ensues; no footsteps, no reply."));
  }

  private static void loadSALeaving(Map<AreaName, Area> areas) {
    areas.put(AreaName.SA_LEAVE, new Area("Unsure, you turn from the hut, wrapping your cloak tighter. The path leads to Hogwarts Castle's silhouette. Its windows\n" +
        "glow like distant stars, guiding you. The rhythmic rain accompanies you, invoking memories of the castle's warm\n" +
        "corridors. Soon, Hogwarts stands tall, its walls filled with magical tales. You wonder about future adventures\n" +
        "within."));
  }

  private static void loadSAKnockAgain(Map<AreaName, Area> areas) {
    areas.put(AreaName.SA_KNOCK_AGAIN, new Area("With renewed determination, you knock again, louder this time. The sound contrasts with the gentle rain, but soon\n" +
        "silence ensues. No sign of activity from within, the door stays still.\n"));
  }

  private static void loadSACallName(Map<AreaName, Area> areas) {
    areas.put(AreaName.SA_CALL_NAME, new Area("\"Hagrid?\" you call out, your voice raised against the rain. Inside, there's rustling, a clink of metal, and a deep\n" +
        "muffled voice. A shadow quickly moves past a lit window."));
  }

  // hut inside rooms
  private static void loadHutInsideRoom(Map<AreaName, Area> areas) {
    areas.put(AreaName.HUT_INSIDE, new Area("'Hagrid, it's me!' \n" +
        "\n" +
        "After a pause, Hagrid's tear-filled face appears. \n" +
        "\n" +
        "'s that you?'\n" +
        "\n" +
        "he asks, voice filled with emotion.\n" +
        "\n" +
        "As he opens the door wider, the warmth of the hut contrasts with his visible distress."));
  }

  private static void loadHIEnter(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_ENTER, new Area("Inside Hagrid's warm hut, magical trinkets adorn the walls, gleaming in the fireplace's light. A distressed Hagrid sits,\n" +
        "his sobs breaking the room's quiet."));
  }

  private static void loadHILookAround(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_LOOK_AROUND, new Area("Glancing around, you note Fang's noticeable absence, with only a chew toy indicating his usual spot."));
  }

  private static void loadHIMakeTea(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_MAKE_TEA, new Area("Deciding to make tea, you head to the kitchen. The comforting sounds of the kettle and teacups create a momentary\n" +
        "respite."));
  }

  private static void loadHIAsk(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_ASK, new Area("You approach Hagrid with concern. \n" +
        "\n" +
        "'Hagrid, what's happened?' \n" +
        "\n" +
        "His eyes, red from tears, meet yours, but he struggles to find words."));
  }

  private static void loadHIShareTea(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_SHARE_TEA, new Area("Offering Hagrid a cup of tea, he manages a small smile. As you sit in silence, the warm tea fosters a bond between you.\n" +
        "After a few sips, you gently ask, \n" +
        "\n" +
        "'What's happened?' \n" +
        "\n" +
        "He looks at you, his emotions raw and evident."));
  }

  private static void loadHIDrinkAlone(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_DRINK_ALONE, new Area("You sip your tea in a corner, giving Hagrid space. After moments of quiet, Hagrid speaks:\n" +
        "\n" +
        "'I think it's best if you leave for now.'"));
  }

  private static void loadHIHagridAnswers(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_HAGRID_ANSWERS, new Area("Hagrid struggles with his words.\n" +
        "\n" +
        "'Yesterday, Fang ran into the Forbidden Forest. \n" +
        "I can't follow because Dumbledore's set up a barrier, I don't know how it exactly works.'"));
  }

  private static void loadHIOptionKid(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_OPTION_KID, new Area("'Hagrid, I wish I could help, but I'm just a kid.' \n" +
        "\n" +
        "He understands, appreciating your presence.\n"));
  }

  private static void loadHIOptionTeacher(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_OPTION_TEACHER, new Area("You suggest finding a teacher, but Hagrid informs you they're away for a conference."));
  }

  private static void loadHIOptionGoAlone(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_OPTION_GO_ALONE, new Area("Bravely, you offer to enter the forest. Hagrid protests, fearing for your safety.\n" +
        "But you have made up your mind and leave."));
  }

  /*  private static void loadSACallName(Map<AreaName, Area> areas) {} */

  // load areas
  public static void loadStart(Map<AreaName, Area> areas) {
    loadStartingArea(areas);
    loadSAKnocking(areas);
    loadSALeaving(areas);
    loadSAKnockAgain(areas);
    loadSACallName(areas);
  }

  public static void loadHutInside(Map<AreaName, Area> areas) {
    loadHutInsideRoom(areas);
    loadHIEnter(areas);
    loadHILookAround(areas);
    loadHIMakeTea(areas);
    loadHIAsk(areas);
    loadHIShareTea(areas);
    loadHIDrinkAlone(areas);
    loadHIHagridAnswers(areas);
    loadHIOptionKid(areas);
    loadHIOptionTeacher(areas);
    loadHIOptionGoAlone(areas);
  }

  public static void loadWayToForrest(Map<AreaName, Area> areas) {
    // ========== WAY_TO_FORREST ==========
    areas.put(AreaName.WAY_TO_FORREST, new Area("Approaching the Forbidden Forest, it feels foreboding, with ancient runes marking its entrance. The dark interior\n" +
        "beckons, with pathways leading left and right."));
  }

  public static void loadForrestEnter(Map<AreaName, Area> areas) {
    // ========== FORREST_ENTER ==========
    areas.put(AreaName.FORREST_ENTER, new Area("You venture into the dense forest. The environment is both magical and eerie. As you tread deeper, the responsibility of\n" +
        "finding Fang weighs heavily."));
  }

  public static void loadForrestDirections(Map<AreaName, Area> areas) {
    Map<AreaName, String[]> forestDescriptions = new HashMap<>();

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
    areas.put(AreaName.F_NORTH, new Area(AreaName.F_NORTH, getRandomDescription(forestDescriptions, AreaName.F_NORTH)));
    areas.put(AreaName.F_EAST, new Area(AreaName.F_EAST, getRandomDescription(forestDescriptions, AreaName.F_EAST)));
    areas.put(AreaName.F_SOUTH, new Area(AreaName.F_SOUTH, getRandomDescription(forestDescriptions, AreaName.F_SOUTH)));
    areas.put(AreaName.F_WEST, new Area(AreaName.F_WEST, getRandomDescription(forestDescriptions, AreaName.F_WEST)));
  }

  public static void loadFindFang(Map<AreaName, Area> areas) {
    // ========== FIND_FANG ==========
    areas.put(AreaName.FIND_FANG, new Area(AreaName.FIND_FANG, "In the depths of the Forbidden Forest, where the trees were ancient and the sunlight scarce, you heard a faint\n" +
        "whimper. Following the sound, you discovered a small sunlit clearing where Fang lay, bruised and muddied but mostly\n" +
        "unharmed. As you approached, his tail wagged weakly, eyes full of relief. After a brief check and reassuring words, you and\n" +
        "Fang began your journey back to Hagrid, the forest now feeling less daunting with the loyal dog by your side.\n" +
        "\n" +
        "Hagrid could not believe his eyes and was beaming with joy!"));
  }

  public static void loadGameOver(Map<AreaName, Area> areas) {
    // ========== GAME_OVER ==========
    areas.put(AreaName.GAME_OVER, new Area(AreaName.GAME_OVER, "Your journey has reached an unexpected crossroads. \n" +
        "\n" +
        "Whether by fate's hand or a twist of destiny, this path has ended.\n" +
        "\n" +
        "But every end is a new beginning..."));
  }
}
