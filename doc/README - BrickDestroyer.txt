Brick Destroyer
Authors: Rithvik Muthyalapati, Atharv Koratkar
Revision: May 23th, 2020


Introduction: 
Our program simulates a basic game of brick and ball similar to the renowned Atari Breakout. The main problem that it solves is immense boredom. This is a game that helps keep the mind active to stimuli. We decided to take on the challenge of recreating this game in Java because it is a well-known game and a very fun game. We also decided to add unique features that were not included in the original Atari Breakout.


We both loved playing video games since we were very young. We one day had a go at Atari Breakout and realized how great of a game it was. The main and only rule is to have fun. The goal of the game is to break all the blocks in the game without losing all of your lives. To do so, the ball will need to be hit by the paddle which you control with arrow keys. You must prevent the ball from hitting the ground at all costs. If the ball falls through the ground, you lose one life. Each difficulty has a different number of lives. For example, easy mode grants you with three lives, medium mode with two, and hard mode with one life. Losing a life doesn’t delete all of your progress, however, if you lose all of your lives, the game is over and you must restart from the beginning.


Anyone of any age that is in extreme boredom or wants to improve on their avid gaming skills can turn to this game and get the best positive experience out of it. The primary features of our program include an eye-appealing menu screen and while in the game, there will be a paddle, a ball, and several bricks to destroy.


Instructions:
This is quite a simple program/game to understand. Most of the controls come from the arrow keys and the mouse. Similarly to Atari Breakout, you get full control of a so-called “paddle” which moves left to right when the left and right arrow keys are pressed respectively. The paddle is used so that the ball doesn’t fall through the ground, otherwise, a life is taken away or it’s game over. To start the game and get the ball moving on the screen, simply press the spacebar. The ball will move based on where it comes in contact with the paddle. For the game that we are creating, we decided to have multiple levels which are all of the different difficulties.


In order to get to your desired location, we designed separate menus that will have to be navigated. We plan on implementing simple rectangles with text that represent different “buttons” which include the play button, the help button, and the quit button. The play button will allow you to navigate to the level selection which will be located on the menu. Once that button is pressed, it will command you to select a level of difficulty you prefer(easy, medium, or hard). Once you have done that, it will open up the level that you selected. If you failed to complete the game, a new “Game Over” screen will pop up which displays your score and the high score and will prompt you to go back to the menu. If you have successfully completed the game, a new “You Win” screen will pop up which also displays your score and the high score and will prompt you to go back to the menu. In the menu, there will also be a button that will allow you to view the instructions of the game. It will be quite basic, just explaining the rules and basic movement of our player “paddle”. Also, there will be a button in the menu that will allow you to exit the game, which will be located at the bottom. Actions will not have to be taken in a certain order, except when starting a game/level, as explained above.


Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
*  Life-counter
*  Paddle and Ball
*  Bricks to be destroyed(Different colors)
*  Music in the levels
*  A “Game Over” screen
* An eye-appealing Menu
* The velocity of the ball


Want-to-have Features:
* Ball color changes to that of the brick it destroyed(Included in the project)
* Level difficulties(Included in the project)
* Shop to purchase paddle skins
* Coins to use in the shop; they can be obtained by completing a level and the higher the difficulty, the more coins you will earn
* Multiplayer
* Highscore tracker(Included in the project)


Stretch Features:
* Certain power-ups that will give you an advantage(delete bricks automatically, decrease in speed of ball)
* Use of servers(online playing)
* An online leaderboard that keeps track of the best players that have played the game


Class List:
* Paddle.java: This class will represent the paddle which the player controls.
* Ball.java: This class will represent the ball.
* Brick.java: This class will represent a single brick.
* Menu.java: This class will display and create features of the menu.
* Window.java: This class will initiate the program with a JFrame.
* Game.java: This class will be in charge of loading the entire game .
* DrawingSurface.java: This class draws all of the components of the game and also is in charge of many game mechanics.
* GameObject.java: This is an abstract class that holds two important methods for all game objects.


Credits:
External Sources:
Websites for Help: 
* processing.org(Examples and References)


Sound Files:
* Menu Music: https://www.youtube.com/watch?v=cNZfbuZBaG4&t=108s
* Game Music: https://www.youtube.com/watch?v=Jf2hubTVuQw
* Ball Bounce: https://freesound.org/people/junggle/sounds/26777/
* Death Sound: https://freesound.org/people/harrietniamh/sounds/415079/
* Game Over Sound: https://freesound.org/people/Leszek_Szary/sounds/133283/
* Win Sound: https://freesound.org/people/unadamlar/sounds/341984/
Images:
* Game Background Image: smooth-blurry-colorful-gradient-mesh-260nw-719772391.jpg


External Libraries:
* Processing Core library


Group Credit:
Classes worked on by Atharv: 
* DrawingSurface.java
* Brick.java
* Menu.java
Classes worked on by Rithvik: 
* DrawingSurface.java
* GameObject.java
* Game.java
* Menu.java
* Paddle.java
* Brick.java
* Ball.java
Both:
* Menu.java
* Brick.java
* DrawingSurface.java


Both of us have worked on and implemented these classes. We would first talk about how we would want to write these classes and then one of us would actually write that certain class. We ensured that work was split evenly between each other. 


Project Credit:
* Rithvik Muthyalapati
   * Added Menu, Game Over, Select, and Win screens
   * Implemented Paddle movement
   * Implemented Ball and Paddle collision
   * Implemented high score tracker
   * Implemented music and sounds to the game
   * Implemented game buttons
   * Implemented multicolored Bricks 
   * Implemented Ball color changing with the destroyed Brick’s color
* Atharv Koratkar
   * Implemented Brick and Ball collision
   * Implemented Score to all levels
   * Implemented some music
   * I came up with the game idea
   * Helped overall with the project
* Both
   * We developed the structure of our project
   * Contributed towards achieving Ball collision with Brick
   * We came up with new ideas to make our game different from the original game