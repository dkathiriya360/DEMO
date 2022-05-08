
import javax.swing.*
import java.awt.Color
import java.awt.FlowLayout
import java.awt.Font
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class Temperature {
    static JFrame frame
    static JLabel title, label, label2, output
    static JTextField inputText
    static JComboBox comboBox, comboBox2
    static JPanel panel, panel2
    static JButton button
    int unit1 = 0
    int unit2 = 2
    float result


    Temperature () {
        frame = new JFrame(title : 'Temperature', location : [500, 280], size : [400, 300])
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
        output = new JLabel()
        output.setForeground(Color.BLUE)
        output.setFont(new Font("", Font.BOLD, 14));

        // button layout
        button = new JButton("Enter")
        button.setSize(150,65)
        button.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                def val = inputText.getText()
                result = calculateTemperature(Float.parseFloat(val))
                String stringResult = "Result =  $result ${temperature[unit2]}"
                output.setText(stringResult)
                //println("Result = " + result)
            }
        })

        // textfield for user input
        inputText = new JTextField(15)

        // create a panel
        panel = new JPanel()
        panel2 = new JPanel()
        // add components to panels
        panel.add(label)
        panel.add(label)
        panel.add(comboBox)
        panel.add(label2)
        panel.add(comboBox2)
        panel2.add(inputText)
        panel2.add(button)
        panel2.add(output)

        // add components to frame
        panel.setLayout(new FlowLayout())
        panel2.setLayout(new GridLayout(0,2))
        frame.add(panel)
        frame.add(panel2)
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