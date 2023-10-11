package com.codecool.mightytextadventure;

import com.codecool.mightytextadventure.data.Area;
import com.codecool.mightytextadventure.logic.Game;
import com.codecool.mightytextadventure.logic.Player;
import com.codecool.mightytextadventure.ui.Display;
import com.codecool.mightytextadventure.ui.Input;

// TODO: add guit game condition for game over
// TODO: add teleport to woods, keyword "woods"

public class Application {
  public static void main(String[] args) {
    Display display = new Display();
    Input input = new Input();

    display.printMessage("\nStarting Mighty Text Adventure by >>> Master JAVA <<<!");

    Area[] areas = loadAreas();
    setupAreaConnections(areas);
    Player player = new Player(input.getNameFromUser(), areas[0]);
    Game game = new Game(areas, input, display, player);
    game.run();

    display.printMessage("\nExiting from Mighty Text Adventure!");

  }

  private static Area[] loadAreas() {
    Area[] areas = new Area[20];
/*

    // in front Hagrids Hut
    areas[0] = new Area("Stepping onto the muddy path, you're met by the shadowy form of Hagrid's rustic hut, its logs and patchwork roof damp\n" +
        "from the rain. The scent of wet earth and a hint of woodsmoke waft through the air. A dim light glows from a window,\n" +
        "turning raindrops into fleeting sparkles. To your left, the Forbidden Forest stands, its trees draped in muted autumn\n" +
        "colors, their beauty occasionally punctuated by the distant cry of an owl.");
    areas[1] = new Area("You knock on Hagrid's rough wooden door. The sound is swallowed by the rain, and a quiet stillness ensues. No answer.");
    areas[2] = new Area("You hesitate and turn away from Hagrid's door, pulling your cloak close against the rain. The path towards Hogwarts\n" +
        "becomes evident, its lit windows shining like distant beacons. With each rain-soaked step, memories of the castle's\n" +
        "warmth hasten your pace. Soon, its grandeur towers before you, promising more adventures within its storied walls. \n\n [GAME OVER]");

    // in front Hagrids Hut continued
    areas[3] = new Area("You shout, \"Hagrid?\" The rain muffles your call, but a rustle and metallic clink emanate from inside, followed by a\n" +
        "muffled voice. A fleeting shadow moves past a window.");
    areas[4] = new Area("Room 5");
    areas[5] = new Area("Room 5");

    // in front Hagrids Hut continued 2
    areas[6] = new Area("\" Hagrid, it's me!\" you call out. After a tense pause, the door creaks open, revealing Hagrid's tear-streaked face. His\n" +
        "eyes, usually lively, are shadowed with pain. \"'s that you?\" he rasps, emotion choking his voice. Without waiting for an\n" +
        "answer, he opens the door wider. Stepping inside, the hut's warmth contrasts starkly with Hagrid's palpable sorrow.");
    areas[7] = new Area ("");




    // inside Hagrids Hut

    areas[8] = new Area ("Inside Hagrid's hut, a comforting warmth contrasts the outdoor chill. The walls showcase magical trinkets, reflecting\\n\" +\n" +
        "        \"the soft light of a fireplace. A distressed Hagrid, usually robust and cheerful, sits on a large chair, his hands hiding\\n\" +\n" +
        "        \"tearful sobs. The scene is surprisingly poignant.");
    areas[8] = new Area("You survey the room, illuminated by the flickering hearth. Notably, Fang's usual spot by the fire is vacant, with only a\n" +
        "chew toy hinting at his absence.");
    areas[9] = new Area("Knowing Hagrid's love for tea, you start brewing. In the kitchenette, the kettle's soft whistle and clinking teacups\n" +
        "bring a touch of normalcy to the tense ambiance.");


    areas[10] = new Area ("");

*/
/*    areas[0] = new Area("Narrator starting point");
    areas[1] = new Area("Action knock");
    areas[2] = new Area("action leave");

    areas[3] = new Area("Narrator");
    areas[4] = new Area("Action knock again");
    areas[5] = new Area("call name");
    areas[6] = new Area("leave");

    areas[0] = new Area("");
    areas[0] = new Area("");*/

    // Starting Area
    areas[0] = new Area("On the muddy path, Hagrid's rustic hut stands prominently, its patchwork roof contrasting the overcast sky. Rain gently mists your face, carrying scents of damp earth and woodsmoke, suggesting a fire within. A dim light shines from a window, causing raindrops to shimmer. To your left, the Forbidden Forest displays muted autumn hues, punctuated by occasional owl hoots and rustlings of unseen creatures.");

    // After Knocking on Hagrid's Door
    areas[1] = new Area("You knock on Hagrid's door, the sound contrasting the steady rain. Silence ensues; no footsteps, no reply.");

    // Knocking Again
    areas[3] = new Area("With renewed determination, you knock again, louder this time. The sound contrasts with the gentle rain, but soon silence ensues. No sign of activity from within, the door stays still.");

    // Calling Hagrid's Name
    areas[4] = new Area("Hagrid? you call out, your voice raised against the rain. Inside, there's rustling, a clink of metal, and a deep muffled voice. A shadow quickly moves past a lit window.");

    // Leaving the Hut Area
    areas[2] = new Area("Unsure, you turn from the hut, wrapping your cloak tighter. The path leads to Hogwarts Castle's silhouette. Its windows glow like distant stars, guiding you. The rhythmic rain accompanies you, invoking memories of the castle's warm corridors. Soon, Hogwarts stands tall, its walls filled with magical tales. You wonder about future adventures within.");

    return areas;

  }
  private static void setupAreaConnections(Area[] areas) {
/*    areas[0].addConnection("Correct", areas[1]);
    areas[0].addConnection("False", areas[2]);

    areas[3].addConnection("False", areas[4]);
    areas[3].addConnection("Correct", areas[2]);
    areas[3].addConnection("False", areas[2]);*/

    // Starting Area connections
    areas[0].addConnection("[Knock]", areas[1]);  // Transition to Hagrid's door when knocked.
    areas[0].addConnection("[Leave]", areas[2]);  // Transition to the path leading away from the hut.

    // After Knocking connections
    areas[1].addConnection("[Knock again]", areas[3]);  // Transition to knocking again on the door.
    areas[1].addConnection("[Call His Name]", areas[4]);  // Transition to calling out for Hagrid.
    areas[1].addConnection("[Leave]", areas[2]);  // Transition to the path leading away from the hut.
  }

}
