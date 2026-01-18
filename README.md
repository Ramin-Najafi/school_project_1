# WarSim 2025 - Turn-Based Combat Simulation

A console-based turn-based combat game demonstrating object-oriented programming principles in Java. Players choose a warrior class, equip weapons and armor, then battle against an AI-controlled Orc enemy in strategic combat.

## 🎮 Overview

WarSim 2025 is a tactical combat simulation where players make strategic choices about their character build (warrior type, weapon, and armor) and then engage in turn-based combat against an enemy. The game features a robust combat system with attack types, damage calculations, armor protection, and dexterity mechanics.

**Built as a school project to demonstrate:** Object-Oriented Programming, Inheritance, Polymorphism, Encapsulation, and Game Logic Implementation

---

## ✨ Key Features

### Character Customization
- **3 Warrior Classes:**
  - **Human:** Balanced stats (Health: 120, Strength: 40, Dexterity: 60)
  - **Elf:** High dexterity (Health: 150, Strength: 100, Dexterity: 100)
  - **Hobbit:** Agile but weak (Health: 130, Strength: 50, Dexterity: 80)

### Weapon System
- **4 Weapon Types:**
  - **Dagger:** Fast, moderate damage (Base: 50, Hit Chance: 60%)
  - **Sword:** Balanced weapon (Base: 50, Hit Chance: 60%)
  - **Axe:** Heavy damage, low accuracy (Base: 90, Hit Chance: 40%)
  - **War Hammer:** Enemy-only weapon (Base: 60, Hit Chance: 50%)

### Armor System
- **3 Armor Types:**
  - **Leather:** Light protection (20% reduction, 5 dex cost)
  - **Chainmail:** Moderate protection (40% reduction, 35 dex cost)
  - **Platemail:** Heavy protection (60% reduction, 65 dex cost)

### Combat Mechanics
- **Turn-Based Combat:** Player and enemy alternate attacks
- **Attack Types:** Normal and Heavy attacks (affects hit chance)
- **Damage Calculation:** 
  - Base weapon damage
  - Strength bonus
  - Random variance
  - Armor damage reduction
  - Dexterity modifiers
- **Hit Chance System:** Roll-based combat with modifiers for attack type, dexterity, and armor weight
- **Colored Console Output:** ANSI escape codes for enhanced visual feedback

---

## 🛠️ Technologies & Concepts

### Java Features Used
- **Object-Oriented Programming (OOP)**
- **Abstract Classes** (Warrior, Weapon, Armour)
- **Inheritance** (All warrior/weapon/armor types extend base classes)
- **Polymorphism** (Different implementations of `strike()` method)
- **Encapsulation** (Private fields with getters/setters)
- **Packages** (Organized code structure)
- **Random Number Generation** (Combat rolls and damage variance)
- **Input Validation** (Error handling for user input)

### Design Patterns
- **Template Method Pattern** (Abstract weapon strike method)
- **Factory Pattern** (Enemy creation)
- **Strategy Pattern** (Different attack calculations per weapon)

---

## 📁 Project Structure

```
Java-project/
│
├── Battle.java              # Main game loop and setup
│
├── armour/
│   ├── Armour.java         # Abstract base class
│   ├── Leather.java        # Light armor
│   ├── Chainmail.java      # Medium armor
│   └── Platemail.java      # Heavy armor
│
├── warrior/
│   ├── Warrior.java        # Abstract base class
│   ├── Human.java          # Balanced warrior
│   ├── Elf.java            # High dexterity warrior
│   ├── Hobbit.java         # Agile warrior
│   └── Orc.java            # Enemy warrior
│
├── weapon/
│   ├── Weapon.java         # Abstract base class with strike() method
│   ├── Dagger.java         # Fast weapon
│   ├── Sword.java          # Balanced weapon
│   ├── Axe.java            # Heavy weapon
│   └── WarHammer.java      # Enemy weapon
│
├── enemy/
│   └── Enemy.java          # AI enemy controller
│
└── utility/
    ├── Ink.java            # Console output formatting and menus
    └── Validator.java      # Input validation
```

---

## 🎯 Object-Oriented Programming Principles Demonstrated

### 1. Inheritance
All warrior types inherit from abstract `Warrior` class:
```java
public class Elf extends Warrior {
    public Elf() {
        super("Elf");
        setHealth(150);
        setStrength(100);
        setDexterity(100);
    }
}
```

### 2. Polymorphism
Each weapon implements its own damage calculation:
```java
@Override
public int strike(int attackType, int strength, int dexterity, int aDexCost) {
    // Weapon-specific damage calculation
    int roll = randNum.nextInt(100) + 1;
    roll += attackType * 5;
    roll -= dexterity / 10;
    // ... different logic per weapon
}
```

### 3. Encapsulation
Private fields with public getters/setters:
```java
public abstract class Warrior {
    private final String type;
    private int health;
    private int strength;
    private int dexterity;
    
    public int getHealth() { return health; }
    public void setHealth(int h) { health = h; }
}
```

### 4. Abstraction
Base classes define structure, subclasses provide implementation:
```java
public abstract class Weapon {
    public abstract int strike(int attackType, int strength, 
                               int dexterity, int armorDexCost);
}
```

---

## 💻 How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Command line terminal or Java IDE (Eclipse, IntelliJ IDEA, VS Code)

### Compilation & Execution

**Using Command Line:**
```bash
# Navigate to project directory
cd Java-project

# Compile all Java files
javac Battle.java warrior/*.java weapon/*.java armour/*.java enemy/*.java utility/*.java

# Run the game
java Battle
```

**Using IDE:**
1. Import project into your Java IDE
2. Set `Battle.java` as the main class
3. Run the project

---

## 🎮 How to Play

### Game Flow

1. **Choose Your Warrior:**
   ```
   1) Human   - Balanced stats
   2) Elf     - High dexterity
   3) Hobbit  - Agile but weak
   ```

2. **Select Your Weapon:**
   ```
   1) Dagger  - Fast attacks
   2) Sword   - Balanced damage
   3) Axe     - Heavy damage, lower accuracy
   ```

3. **Equip Your Armor:**
   ```
   1) Leather    - Light protection, minimal dex penalty
   2) Chainmail  - Moderate protection
   3) Platemail  - Heavy protection, high dex penalty
   ```

4. **View Stats:**
   - Player and enemy stats are displayed
   - Compare health, strength, dexterity, and equipment

5. **Combat:**
   - **Your Turn:** Choose between Normal or Heavy attack
   - **Enemy Turn:** Orc automatically attacks
   - Turns alternate until one combatant reaches 0 health

6. **Victory or Defeat:**
   - Battle continues until one warrior is defeated
   - Winner is declared and game ends

---

## ⚔️ Combat System Explained

### Damage Calculation Formula

```java
// Step 1: Base Roll (1-100)
int roll = random(1, 100);

// Step 2: Apply Modifiers
roll += attackType * 5;        // Heavy attack adds +10
roll -= dexterity / 10;         // High dexterity helps hit
roll += armorDexCost / 10;      // Heavy armor makes you slower

// Step 3: Check Hit
if (roll <= weaponHitChance) {
    // Step 4: Calculate Damage
    damage = baseDamage + random(strength / 5);
    
    // Step 5: Apply Armor Reduction
    damage *= (1 - armorProtection / 100);
}
```

### Strategic Trade-offs

**Armor Choice:**
- Heavy armor = More protection BUT slower attacks (harder to hit)
- Light armor = Less protection BUT faster attacks (easier to hit)

**Weapon Choice:**
- Axe = High damage BUT low hit chance
- Dagger/Sword = Moderate damage BUT higher accuracy

**Attack Type:**
- Normal = Standard hit chance
- Heavy = Lower hit chance BUT potential for more damage

---

## 🧪 Example Gameplay

```
///////////////////////////////////
///// Welcome to Warsim 2025! /////
///////////////////////////////////

/////////////////////////////
/// Choose your warrior: 
/// 1) Human
/// 2) Elf
/// 3) Hobbit
/////////////////////////////

Enter a number between 1 and 3:
> 2
You entered: 2

/////////////////////////////
/// Choose your weapon: 
/// 1) Dagger
/// 2) Sword
/// 3) Axe
/////////////////////////////

Enter a number between 1 and 3:
> 3
You entered: 3

/////////////////////////////
/// Choose your armour: 
/// 1) Leather
/// 2) Chainmail
/// 3) Platemail
/////////////////////////////

Enter a number between 1 and 3:
> 2
You entered: 2

/////////////////////////////
/// Player(Elf) Stats:
/// Armour:    Chainmail
/// Weapon:    Axe
/// Health:             150
/// Strength:           100
/// Dexterity:          100

/////////////////////////////
/// Enemy(Orc) Stats:
/// Armour:    Chainmail
/// Weapon:    War Hammer
/// Health:             130
/// Strength:            90
/// Dexterity:           40
/////////////////////////////

/////////////////////////////
/// Select your attack: 
/// 1) Normal
/// 2) Heavy
/////////////////////////////

Enter a number between 1 and 2:
> 1
Player dealt 54.00 damage!
Orc has 76.00 health remaining.

Enemy dealt 36.00 damage!
Elf has 114.00 health remaining.

[Combat continues...]

Player Wins!

///////////////////////////////////
///// Thank you for playing!! /////
///////////////////////////////////
```

---

## 🎓 What I Learned

Through building this project, I gained hands-on experience with:

### Object-Oriented Programming
- **Class Hierarchies:** Creating logical inheritance structures
- **Abstract Classes:** Defining contracts for subclasses
- **Polymorphism:** Same method name, different implementations
- **Encapsulation:** Protecting data with private access modifiers

### Java Fundamentals
- **Package Organization:** Structuring code into logical modules
- **Random Number Generation:** Using `java.util.Random` for game mechanics
- **Input Validation:** Handling user input errors gracefully
- **String Formatting:** Using `printf()` for formatted console output

### Game Development Concepts
- **Turn-Based Combat:** Implementing alternating player/enemy turns
- **Stat Systems:** Balancing health, strength, and dexterity
- **Damage Calculation:** Creating formulas with multiple modifiers
- **AI Behavior:** Simple enemy decision-making

### Software Design
- **Code Reusability:** Abstract base classes reduce code duplication
- **Separation of Concerns:** Each package has a specific responsibility
- **Maintainability:** Well-organized code is easier to extend

### Problem-Solving
- **Balancing Game Mechanics:** Ensuring no warrior/weapon is overpowered
- **Console UI Design:** Creating readable menus without graphics
- **Edge Case Handling:** Preventing negative health values

---

## 🔄 Potential Enhancements

Future improvements could include:

- [ ] **Multiple Rounds:** Best of 3 or 5 battles
- [ ] **Experience System:** Warriors level up and gain stats
- [ ] **More Enemy Types:** Different AI opponents with unique abilities
- [ ] **Special Abilities:** Class-specific skills (e.g., Elf archery)
- [ ] **Inventory System:** Potions, scrolls, power-ups
- [ ] **Save/Load Game:** Persistent player progress
- [ ] **Graphical UI:** Swing or JavaFX interface
- [ ] **Multiplayer:** Player vs Player mode
- [ ] **Sound Effects:** Audio feedback for attacks
- [ ] **Difficulty Levels:** Easy, Medium, Hard enemy scaling

---

## 🐛 Known Limitations

- **Single Battle Only:** Game ends after one combat encounter
- **Fixed Enemy:** Always fight an Orc with Chainmail and War Hammer
- **Console-Based:** No graphical interface
- **No Save Function:** Progress is not saved between sessions
- **Limited AI:** Enemy attacks are random, not strategic
- **No Ranged Combat:** All weapons are melee

---

## 📚 Code Quality Features

### Input Validation
All user input is validated to prevent crashes:
```java
public int validatePick(int maxVal) {
    try {
        choice = Integer.parseInt(input.nextLine());
        if (choice >= 1 && choice <= maxVal) {
            return choice;
        }
    } catch (NumberFormatException e) {
        System.out.println("Invalid number. Try again.");
    }
}
```

### Clean Code Practices
- Descriptive variable names
- Commented code sections
- Consistent formatting
- DRY principle (Don't Repeat Yourself)
- Single Responsibility Principle

### Error Handling
- Try-catch blocks for input parsing
- Health cannot go below 0
- Validated menu choices

---

## 🤝 Contributing

This is a school project demonstrating OOP principles in Java. Feedback and suggestions for improvement are welcome!

---

## 📝 License

This project is open source and available for educational purposes.

---

## 👨‍💻 Author

**Ramin Najafi**
- Portfolio: [ramin-najafi.github.io](https://ramin-najafi.github.io/)
- GitHub: [@Ramin-Najafi](https://github.com/Ramin-Najafi)
- Email: rnajafi.dev@gmail.com

---

## 🙏 Acknowledgments

- **triOS College** for Java programming education
- **Object-Oriented Design Principles** for inspiring the architecture
- **Classic RPG Games** for combat system inspiration

---

**Built with ☕ to demonstrate mastery of Java OOP principles**