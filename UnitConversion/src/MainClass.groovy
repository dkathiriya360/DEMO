import groovy.swing.SwingBuilder
import javax.swing.*
import java.awt.*

class MainClass {
    static void main(String[] args) {
        // create a builder
        def swing = new SwingBuilder()

        def displayTemperature = {
            Temperature t = new Temperature() // call temperature class
        }
        def displayLength = {
            Length l = new Length() // call Length class
        }
        def displayWeight = {
            Weight w = new Weight() // call Weight class
        }

        // compose the builder
        def frame = swing.frame(
                title : 'Unit Converter', location : [500, 280], size : [400, 300],
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
    }
}
