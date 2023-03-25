# L-Systems-DrawBot #

## Description: ##

Java project using Swing to draw L-Systems.
Developed in Eclipse IDE for Java.

## How to Run the Program: ##

Load the project folder into Eclipse and press Run. This will launch the application window. Once launched, press the LOAD button. The program will read the <code>l-system.txt</code> file and load its information into the window's text-fields. All text-fields except the generation number can then be edited via the application window. 

## How to Set the Maximum Number of Generations: ##

By default, the maximum number of generations is set to 10. To change this value, open the <code>L_Gui.java</code> file (in Eclipse or a text editor of your choosing). Navigate to line 382: <code>getData(10);</code>.
<br/><br/>
The number within the parentheses is the maximum number of generations. Note that it must be an integer (whole number). Entering a negative number will result in a maximum generation number of 0 (the starting axiom). The value's upper limit corresponds to the size of a Java <code>int</code>. That said, the complexity of the defined l-system impacts application performance. Simpler systems allow for a larger number of generations. The system defined by <code>l-system.txt</code> runs well up to generation 4. Generation 5 takes roughly 15 seconds to load. 

## How to Set the Generation Instructions: ##

There are two ways to change the generation instructions:

  1. Edit <code>l-system.txt</code>;
  2. Edit the text-fields in the application window. 

<code>l-system.txt</code> must be formatted as follows: <br/>

  > Axiom <br/>
  > Rule <br/>
  > Angle <br/>
  > Scale <br/>
  > X-coordinate <br/>
  > Y-coordinate <br/>
  > Direction

To clarify:

  - *Axiom:* Start of the "plant"
  - *Rule:* A production (replaces each occurance of 'F' upon generation)
  - *Angle:* Size of each turn (degrees)
  - *Scale:* Size of each forward motion (pixels)
  - *X-coordinate:* Horizontal starting position
  - *Y-coordinate:* Vertical starting position
  - *Direction:* Initial direction the turtle is facing (degrees)
  
You are free to edit <code>l-system.txt</code> while the application is running. Simply make your desired changes, save the file, and then click LOAD to apply the new instructions. Pressing DRAW will produce generation 0. 

## Symbols Key: ##

List of symbols recognized by the DrawBot:

  - **F** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Move forward
  - **+** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Turn right
  - **-** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Turn left
  - **[** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Save the DrawBot's current state (x-coordinate, y-coordinate, and direction)
  - **]** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Return to the last saved state

***NOTE:** Always ensure that there is a matching number of open brackets ('[') and closing brackets (']')!*

## Information on L-Systems: ##

To learn about L-Systems, including their history and applications, have a look at the following:

  - For a brief description and a lot of cool example systems: [L System User Notes](http://paulbourke.net/fractals/lsys/) by Paul Bourke
  - Full novel on the subject (available for free!): [The Algorithmic Beauty of Plants](http://algorithmicbotany.org/papers/abop/abop.pdf) by Przemyslaw Prusinkiewicz and Aristid Lindenmayer
  - Collection of resources on algorithmic botany: [BMV Publications](http://algorithmicbotany.org/papers/#abop) 

## License: ##

This work is published under the GNU General Public License v3.0.
