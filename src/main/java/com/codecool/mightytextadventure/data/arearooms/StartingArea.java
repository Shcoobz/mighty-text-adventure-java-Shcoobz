package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import java.util.Map;

public class StartingArea {
  public static void loadStartingArea(Map<AreaName, Area> areas) {
    areas.put(AreaName.STARTING_AREA, new Area("On the muddy path, Hagrid's rustic hut stands prominently, its patchwork roof contrasting the overcast sky. Rain gently\n" +
        "mists your face, carrying scents of damp earth and woodsmoke, suggesting a fire within. A dim light shines from a\n" +
        "window, causing raindrops to shimmer. To your left, the Forbidden Forest displays muted autumn hues, punctuated by\n" +
        "occasional owl hoots and rustlings of unseen creatures."));
  }

  public static void loadSAKnocking(Map<AreaName, Area> areas) {
    areas.put(AreaName.SA_KNOCK, new Area("You knock on Hagrid's door, the sound contrasting the steady rain. Silence ensues; no footsteps, no reply."));
  }

  public static void loadSALeaving(Map<AreaName, Area> areas) {
    areas.put(AreaName.SA_LEAVE, new Area("Unsure, you turn from the hut, wrapping your cloak tighter. The path leads to Hogwarts Castle's silhouette. Its windows\n" +
        "glow like distant stars, guiding you. The rhythmic rain accompanies you, invoking memories of the castle's warm\n" +
        "corridors. Soon, Hogwarts stands tall, its walls filled with magical tales. You wonder about future adventures\n" +
        "within."));
  }

  public static void loadSAKnockAgain(Map<AreaName, Area> areas) {
    areas.put(AreaName.SA_KNOCK_AGAIN, new Area("With renewed determination, you knock again, louder this time. The sound contrasts with the gentle rain, but soon\n" +
        "silence ensues. No sign of activity from within, the door stays still.\n"));
  }

  public static void loadSACallName(Map<AreaName, Area> areas) {
    areas.put(AreaName.SA_CALL_NAME, new Area("\"Hagrid?\" you call out, your voice raised against the rain. Inside, there's rustling, a clink of metal, and a deep\n" +
        "muffled voice. A shadow quickly moves past a lit window."));
  }
}
