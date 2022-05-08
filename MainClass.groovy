import groovy.swing.SwingBuilder
import javax.swing.*
import java.awt.*

// create a builder
def swing = new SwingBuilder()

def displayTemperature = {
    Temperature t = new Temperature() // call temperature class
}
def displayLength = {
    println("length class")
}
def displayWeight = {
    println("weight class")
} //


// compose the builder
def frame = swing.frame(
        title : 'Unit Converter', location : [200, 200], size : [400, 300],
        defaultCloseOperation : WindowConstants.EXIT_ON_CLOSE) {
    label(text: "Unit Converter", horizontalAlignment: JLabel.CENTER, constraints: BorderLayout.NORTH)
    //boxLayout(axis: BoxLayout.Y_AXIS) {
    vbox {
        panel(constraints: BorderLayout.SOUTH) {
            button(text: 'Temperature', actionPerformed: displayTemperature)
            button(text: 'Length', actionPerformed: displayLength)
            button(text: 'Weight', actionPerformed: displayWeight)
        }
    }
}

// display the frame view
frame.setVisible(true)