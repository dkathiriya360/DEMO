import javax.swing.*
import java.awt.Color
import java.awt.FlowLayout
import java.awt.Font
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class Weight {
    static JFrame frame
    static JLabel label, label2, output
    static JTextField inputText
    static JComboBox comboBox, comboBox2
    static JPanel panel, panel2
    static JButton button
    int unit1 = 0
    int unit2 = 2
    float result


    Weight () {
        frame = new JFrame(title : 'Weight', location : [500, 280], size : [400, 300])
        frame.setLayout(new FlowLayout())

        // create a list for weight units
        String[] weight = ["kilogram","gram", "pound", "ounces"]

        // add drop down menu for units
        comboBox = new JComboBox(weight)
        comboBox2 = new JComboBox(weight)

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
        label = new JLabel("From")
        label2 = new JLabel("To")
        output = new JLabel()
        output.setForeground(Color.BLUE)
        output.setFont(new Font("", Font.BOLD, 14));

        // add button layout
        button = new JButton("Enter")
        button.setSize(150,65)
        button.addActionListener(new ActionListener() {
            @Override
            void actionPerformed(ActionEvent e) {
                def val = inputText.getText()
                result = calculateWeight(Float.parseFloat(val))
                String stringResult = "Result =  $result ${weight[unit2]}"
                output.setText(stringResult)
                // println("Result = " + result)
            }
        })

        // text-field for user input
        inputText = new JTextField(15)

        // create a panel;
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

    // ["kilogram","gram", "pound", "ounces"] --> [0, 1, 2, 3]
    def calculateWeight(def val) {
        def gram = val
        def answer = val

        switch (unit1) {
            case 0 :
                gram = 1000 * val
                break
            case 1:
                gram = val
                break
            case 2:
                gram = 453.59237 * val
                break
            case 3:
                gram = 28.349523125 * val
                break
        }

        switch (unit2) {
            case 0 :
                answer = 0.001 * gram
                break
            case 1:
                answer = gram
                break
            case 2:
                answer = 0.0022046226 * gram
                break
            case 3:
                answer = 0.0352739619 * gram
                break
        }

        return answer
    }
}