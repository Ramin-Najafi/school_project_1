# Java Battle Simulation

### Overview

This project is a turn-based battle simulation developed in Java as part of Assignment 3 for a college course. The application demonstrates key object-oriented programming (OOP) principles, including inheritance, polymorphism, encapsulation, and the use of packages to structure code.

⸻

### Game Summary

The program simulates a one-on-one combat scenario.
The player controls a warrior character and battles a predefined enemy—an Orc equipped with a WarHammer and protected by Chainmail armour. Each turn, both sides attack or defend until one of them reaches zero health.

⸻

### Project Structure

The application is organized into multiple packages to separate responsibilities:
	•	warrior – Player character classes
	•	weapon – Weapon types (e.g., Sword, Axe, Dagger, WarHammer)
	•	armour – Armour types (e.g., Chainmail)
	•	enemy – Enemy character classes
	•	utility – Helper utilities (e.g., randomization, ANSI color formatting)
	•	Battle – Core battle system logic
	•	Battle.java – Entry point to run the simulation

This modular design highlights proper OOP structure and class interaction.

⸻

### Objective

The goal is simple: defeat the enemy before your health reaches zero.
Combat outcomes are influenced by factors such as character strength, weapon damage, and armour defense.

⸻

#### Running the Program
	1.	Open a terminal in the project’s root directory.
	2.	Compile and run the game:

javac *.java
java Battle
