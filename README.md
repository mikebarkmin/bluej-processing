# Processing in BlueJ

## Installation

* Copy processing, gluegen and jogl libraries into a +libs folder or copy them to the bluej userlibs folder (see [How do I use custom class libraries](https://www.bluej.org/faq.html))
* Copy BlueJPApplet and PObject into your project

## Usage

* Every Processing Sketch should extend BlueJPApplet
* Every Object you want to place on the Processing Sketch should implement PObject
* To add an PObject to the sketch call addObject

## Examples

* Download the examples folder
* Run the runSketch method of CatSketch
* Construct a new CatSprite named cat2
* Call the addObject method of CatSketch with cat2
* Call the changeTint method of cat2
* Enjoy :smile:


![CatSketch Example](catsketch.gif)
