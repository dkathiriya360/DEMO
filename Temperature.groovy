
import groovy.swing.SwingBuilder

import javax.swing.JLabel
import javax.swing.JList
import javax.swing.WindowConstants
import java.awt.BorderLayout

class Temperature {
    def swing = new SwingBuilder()
    Temperature() {
        //def swing = new SwingBuilder()
        def tempFrame = swing.frame(title : 'Unit Converter', location : [200, 200], size : [400, 300],
                defaultCloseOperation : WindowConstants.EXIT_ON_CLOSE) {
            mainView()
        }
        tempFrame.setVisible(true)
    }

    def void mainView() {

        def main_view = swing.panel(constraints: BorderLayout.CENTER) {
            label(text : 'Temperature', horizontalAlignment : JLabel.CENTER,
                    constraints : BorderLayout.NORTH)
            // selectionPanel()
            String[] values = ["Celsius", "Kelvin", "Fahrenheit"]
            swing.scrollPane() {
                JList<String> valueList = new JList<>(values)

            } //

        }


    }

    // convert the temperature
    def void selectionPanel() {
        //TODO: implement a selection feature - JList
        String[] values = ["Celsius", "Kelvin", "Fahrenheit"]

        vbox {
            swing.label(text: "Selection: ")
        }

    }
}