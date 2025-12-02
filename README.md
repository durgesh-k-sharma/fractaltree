# Fractal Tree

An interactive fractal tree visualization built with Java Swing. The tree dynamically responds to mouse movements, allowing you to control the branch angles and thickness in real-time.

## Features

- **Interactive Controls**: Move your mouse to change the tree's appearance
  - **Vertical position**: Controls the angle between branches (0° to 180°)
  - **Horizontal position**: Controls the thickness of branches (distance from center affects thickness)
- **Recursive Rendering**: Uses recursive algorithms to generate the fractal tree structure
- **Smooth Visualization**: Anti-aliased graphics for a polished appearance
- **Dark Theme**: Black background with white branches for optimal visibility

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- No external dependencies required (uses built-in Java Swing)

## Project Structure

```
fractaltree/
├── src/
│   └── FractalTree.java    # Source code
├── out/                     # Compiled .class files (generated)
└── README.md
```

**Windows (PowerShell/CMD):**
```bash
javac -d out src\FractalTree.java
```

**Linux/Mac:**
```bash
mkdir -p out
javac -d out src/FractalTree.java
```

## Running

After compilation, run the program from the project root:

```bash
java -cp out FractalTree
```

A window titled "Fractal Tree" will appear with an 800x600 canvas.

## Quick Start (One-Line Commands)

**Windows:**
```bash
javac -d out src\FractalTree.java && java -cp out FractalTree
```

**Linux/Mac:**
```bash
mkdir -p out && javac -d out src/FractalTree.java && java -cp out FractalTree
```

## Cleanup

To remove all compiled files:

**Windows:**
```bash
rmdir /s /q out
```

**Linux/Mac:**
```bash
rm -rf out
```

## How to Use

1. Launch the application
2. Move your mouse within the window:
   - **Move vertically** to adjust the angle between branches
   - **Move horizontally** (away from center) to increase/decrease branch thickness
3. Watch the fractal tree morph in real-time!

## Technical Details

- **Max Depth**: 10 levels of recursion
- **Initial Branch Length**: 160 pixels
- **Length Scale Factor**: 0.75 (each branch is 75% the length of its parent)
- **Canvas Size**: 800x600 pixels
- **Thickness Range**: 0.1x to 3.0x based on mouse position

## License

This project is open source and available for educational purposes.
