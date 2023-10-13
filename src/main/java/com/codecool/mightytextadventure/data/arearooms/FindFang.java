package com.codecool.mightytextadventure.data.arearooms;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.data.AreaName;

import java.util.Map;

public class FindFang {

  public static void loadFindFangRoom(Map<AreaName, Area> areas) {
    areas.put(AreaName.FIND_FANG, new Area(AreaName.FIND_FANG, "In the depths of the Forbidden Forest, where the trees were ancient and the sunlight scarce, you heard a faint\n" +
        "whimper. Following the sound, you discovered a small sunlit clearing where Fang lay, bruised and muddied but mostly\n" +
        "unharmed. As you approached, his tail wagged weakly, eyes full of relief. After a brief check and reassuring words, you and\n" +
        "Fang began your journey back to Hagrid, the forest now feeling less daunting with the loyal dog by your side.\n" +
        "\n" +
        "Hagrid could not believe his eyes and was beaming with joy!"));
  }
}
