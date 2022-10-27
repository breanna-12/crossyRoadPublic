###### q2-project-base-breanna-12
# Crossy Road Game
## Objective of the Game
The goal of this game is to get the chicken to the finishing point at the top-right while collecting money and avoiding hitting any vehicles. The higher the level, the faster the vehicles go!

![game design](https://user-images.githubusercontent.com/90793524/148111953-8d7ad42d-4c86-4fd5-8336-495fd2b32597.png)

## How Each Class Works
### Tree, YouMadeIt_GIF, Background
The main purpose of the Tree, YouMadeIt_GIF, and Background classes is to create an object with a certain displaying image. Each class imports the appropriate picture with a certain x and y value as the parameters of the contructor, which are then used in the Frame class. It also sets the scale of the image when initializing and updating and has getters and setters for every variable made. For example, the Tree class:
![tree class](https://user-images.githubusercontent.com/90793524/148102428-2b855276-d784-44f2-b8b0-3a914ec6cedf.png)

### Chicken
The Chicken class contains the constructor, attributes and methods needed for the chicken object to function in the game. The constructor takes in x and y values similar to the previous classes and inits the chicken image to that location.
The **chickenReset** method takes in two int parameters and sets the current location of the chicken to the two values given:
![chicken-chickenreset](https://user-images.githubusercontent.com/90793524/148109902-952a0c63-4202-4335-8a62-9a9ff96276a6.png)

The **chickenFlat** method changes the scaling of the chicken image to appear squished and sets the flat boolean to true: 
![chicken-chickenflat](https://user-images.githubusercontent.com/90793524/148110156-2f0673f5-09e4-4813-90eb-497f8612b11f.png)

The **chickenMove** method shifts the location of the chicken up 25 pixels and right 25 pixels by changing the x and y values: 
![chicken-chickenmove](https://user-images.githubusercontent.com/90793524/148110345-912bdf4d-f126-4b05-b1f4-136b24fd9da5.png)

### Coin (displayed as money)
The Coin class is similar to the previous classes, the only difference being that the Coin class has x and y velocities for smooth movement. The coin object is moved in the **update** method where vx and vy (the velocities) affect the actual x and y locations:
![coin-update](https://user-images.githubusercontent.com/90793524/148111173-d5d8531c-c499-43be-819a-f75b771130fa.png)

The reset method is called when the image is off the 600x600 pixel screen (known by checking x values compared to border values). This method resets the x value to the given double parameter value and sets y to a random int from 20 to 580:
![coin-reset](https://user-images.githubusercontent.com/90793524/148111592-309aab98-6ecc-4c85-b1c7-a21902f78a0e.png)
