//import java.awt.*
import javax.swing.*
import java.awt.FlowLayout
import java.awt.Font
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.util.concurrent.Flow

class Temperature {
    static JFrame frame
    static JLabel title, label, label2, output
    static JTextField inputText
    static JComboBox comboBox, comboBox2
    static JPanel panel, panel2, panel3
    static JButton button
    int unit1 = 0
    int unit2 = 2
    float result


    Temperature () {
        frame = new JFrame(title : 'Temperature', location : [200, 200], size : [400, 300])
        frame.setLayout(new FlowLayout())

        // create a list for temperature units
        String[] temperature = ["Celsius", "Kelvin", "Fahrenheit"]

        // add drop down menu for units
        comboBox = new JComboBox(temperature)
        comboBox2 = new JComboBox(temperature)

        // set default selected items
        comboBox.setSelectedIndex(0)
        comboBox2.setSelectedIndex(2)

        // action listener for selected entry
        comboBox.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                if (e.getSource()==comboBox) {
                    unit1 = comboBox.getSelectedIndex()
                }
            }

        })
        comboBox2.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                if (e.getSource()==comboBox2) {
                    unit2 = comboBox2.getSelectedIndex()
                }
            }
        })

        // add labels
        title = new JLabel("Temperature", SwingConstants.CENTER)
        title.setFont(new Font("Serif", Font.BOLD, 20))
        label = new JLabel("From")
        label2 = new JLabel("To")
        // TODO: Display result
        //output = new JLabel("Result = $result")


        // add button layout
        button = new JButton("Enter")
        button.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                def val = inputText.getText()
                result = calculateTemperature(Float.parseFloat(val))
                println("Result = " + result)
            }
        })

        // textfield for user input
        inputText = new JTextField(15)

        // create a panel; add labels and combobox
        panel = new JPanel()
        panel2 = new JPanel() // for input text and button
        panel3 = new JPanel() // for result
        panel.add(label)
        panel.add(label)
        panel.add(comboBox)
        panel.add(label2)
        panel.add(comboBox2)
        panel2.add(inputText)
        panel2.add(button)
        //panel3.add(output)

        // add components to frame
        panel.setLayout(new FlowLayout())
        //frame.add(title)
        frame.add(panel)
        frame.add(panel2)
        frame.add(panel3)
        frame.show()

    }

    // ["Celsius", "Kelvin", "Fahrenheit"] --> [0, 1, 2]
    def calculateTemperature(double val) {
        if (unit1 == 0 && unit2 == 1) {
            return (val + 273.15)
        }
        else if (unit1 == 0 && unit2 == 2) {
            return ((val*1.8) + 32)
        }
        else if (unit1 == 1 && unit2 == 0) {
            return (val - 273.15)
        }
        else if (unit1 == 1 && unit2 == 2) {
            return ((val-273.15)*1.8 + 32)
        }
        else if (unit1 == 2 && unit2 == 0) {
            return ((val-32)*(5/9))
        }
        else if (unit1 == 2 && unit2 == 1) {
            return ((val-32)*(5/9) + 273.15)
        }
        else {
            return val
        }
    }
}