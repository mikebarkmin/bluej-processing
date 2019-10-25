# Processing in BlueJ

## Installation

* Copy processing, gluegen and jogl libraries into a +libs folder or copy them to the bluej userlibs folder (see [How do I use custom class libraries](https://www.bluej.org/faq.html))
* Copy BlueJPApplet and PObject into your project
* If you want to use additional processsing libraries copy them also into the +libs folder

## Usage

* Every Processing Sketch should extend BlueJPApplet
* Every Object you want to place on the Processing Sketch should implement PObject
* To add an PObject to the sketch call addObject

## Examples
* Download the examples folder

### Cat 

* Additional Processing Libraries: Scratch

Corresponding [Scratch Project](https://scratch.mit.edu/projects/339257357/)

* Open the cat example
* Run the runSketch method of CatSketch
* Inspect the CatSketch object and get the ScratchStage object
* Construct a new CatSprite named cat
* Call the addSprite method of the ScratchStage object with cat
* Call the changeTint method of cat
* Enjoy :smile:

![Cat Example](.github/cat.gif)

### Halloween

* Additional Processing Libraries: Scratch, Audio

Corresponding [Scratch Project](https://scratch.mit.edu/projects/338613208/)

* Open the halloween example
* Run the runSketch method of HalloweenSketch
* Inspect the HalloweenSketch object and get the Ghost object
* Call the setAnimationInterval method of the Ghost object with 50
* Enjoy :running:

![Halloween Example](.github/halloween.gif)
