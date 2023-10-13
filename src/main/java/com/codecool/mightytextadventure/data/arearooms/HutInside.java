package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import java.util.Map;

public class HutInside {

  public static void loadHutInsideRoom(Map<AreaName, Area> areas) {
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

  public static void loadHIEnter(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_ENTER, new Area("Inside Hagrid's warm hut, magical trinkets adorn the walls, gleaming in the fireplace's light. A distressed Hagrid sits,\n" +
        "his sobs breaking the room's quiet."));
  }

  public static void loadHILookAround(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_LOOK_AROUND, new Area("Glancing around, you note Fang's noticeable absence, with only a chew toy indicating his usual spot."));
  }

  public static void loadHIMakeTea(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_MAKE_TEA, new Area("Deciding to make tea, you head to the kitchen. The comforting sounds of the kettle and teacups create a momentary\n" +
        "respite."));
  }

  public static void loadHIAsk(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_ASK, new Area("You approach Hagrid with concern. \n" +
        "\n" +
        "'Hagrid, what's happened?' \n" +
        "\n" +
        "His eyes, red from tears, meet yours, but he struggles to find words."));
  }

  public static void loadHIShareTea(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_SHARE_TEA, new Area("Offering Hagrid a cup of tea, he manages a small smile. As you sit in silence, the warm tea fosters a bond between you.\n" +
        "After a few sips, you gently ask, \n" +
        "\n" +
        "'What's happened?' \n" +
        "\n" +
        "He looks at you, his emotions raw and evident."));
  }

  public static void loadHIDrinkAlone(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_DRINK_ALONE, new Area("You sip your tea in a corner, giving Hagrid space. After moments of quiet, Hagrid speaks:\n" +
        "\n" +
        "'I think it's best if you leave for now.'"));
  }

  public static void loadHIHagridAnswers(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_HAGRID_ANSWERS, new Area("Hagrid struggles with his words.\n" +
        "\n" +
        "'Yesterday, Fang ran into the Forbidden Forest. \n" +
        "I can't follow because Dumbledore's set up a barrier, I don't know how it exactly works.'"));
  }

  public static void loadHIOptionKid(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_OPTION_KID, new Area("'Hagrid, I wish I could help, but I'm just a kid.' \n" +
        "\n" +
        "He understands, appreciating your presence.\n"));
  }

  public static void loadHIOptionTeacher(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_OPTION_TEACHER, new Area("You suggest finding a teacher, but Hagrid informs you they're away for a conference."));
  }

  public static void loadHIOptionGoAlone(Map<AreaName, Area> areas) {
    areas.put(AreaName.HI_OPTION_GO_ALONE, new Area("Bravely, you offer to enter the forest. Hagrid protests, fearing for your safety.\n" +
        "But you have made up your mind and leave."));
  }
}
