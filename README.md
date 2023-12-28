# Mighty Text Adventure

![Mighty Text Adventure Logo](src/main/resources/img/mighty-text-adventure.png)

## Project Summary
Mighty Text Adventure is a thrilling text-based role-playing game set in a magical realm. Players navigate through various areas, encounter enemies, and engage in battles, all through text-based commands. The game combines classic RPG elements like exploration, combat, and story progression in a console-based interface. The goal is to provide an engaging and nostalgic experience reminiscent of early computer games.

## Features
- Text-based user interface with clear instructions and feedback.
- Diverse areas to explore, each with unique descriptions and challenges.
- Engaging combat system allowing players to battle various enemies.
- Inventory management with items like potions and a magical wand.
- Interactive story progression based on player choices and actions.

## Technology Stack
- Java: Core programming language for game logic and user interface.
- Scanner Class: For handling user input in the console.
- Enum and Classes: To structure game elements like areas, enemies, and player attributes.

## Task Division

### [Adrian Monemi](https://github.com/AdrianMonemi):
- **Player Mechanics**: Implemented the logic for player attributes such as health points, potions, and attack strength. Also handled the effects of items like the magic wand on player stats.
- **Game Logic**: Developed the core game loop including area exploration, player progression, and state management.
- **Battle Logic**: Crafted the battle system, allowing players to engage in combat with enemies, using a blend of strategy and resource management.

### [Shcoobz](https://github.com/Shcoobz): 
- **User Interface**: Designed and implemented the text-based user interface using Java's Scanner class. Ensured clear user feedback and intuitive command input.
- **Area Design**: Created and described various game areas, setting the scene for player exploration and interaction.
- **Game Details**: Fine-tuned game elements like story details, help messages, and area connections to ensure a cohesive and engaging player experience.

## Getting Started

### Prerequisites
- Java JDK 11 or higher

### Running the Game
1. Clone the repository to your local machine.
2. Navigate to the src directory.
3. Compile the Java files: `javac com/codecool/mightytextadventure/*.java`
4. Run the game: `java com.codecool.mightytextadventure.Application`

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments
- Special thanks to the Java community for support and resources.
- Inspired by classic text-based adventure games of the early computing era.
