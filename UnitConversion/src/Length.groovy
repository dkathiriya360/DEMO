import javax.swing.*
import java.awt.Color
import java.awt.FlowLayout
import java.awt.Font
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class Length {
    static JFrame frame
    static JLabel label, label2, output
    static JTextField inputText
    static JComboBox comboBox, comboBox2
    static JPanel panel, panel2
    static JButton button
    int unit1 = 0
    int unit2 = 2
    float result


    Length () {
        frame = new JFrame(title : 'Length', location : [500, 280], size : [400, 300])
        frame.setLayout(new FlowLayout())

        // create a list for length units
        String[] length = ["Kilometer","meter", "Mile", "feet", "Inch"]

        // add drop down menu for units
        comboBox = new JComboBox(length)
        comboBox2 = new JComboBox(length)

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
                result = calculateLength(Float.parseFloat(val))
                String stringResult = "Result =  $result ${length[unit2]}"
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

    // ["Kilometer","meter", "Mile", "feet", "Inch"] --> [0, 1, 2, 3, 4]
    def calculateLength(def val) {
        def meter = val
        def answer = val

        switch (unit1) {
            case 0 :
                meter = 1000 * val
                break
            case 1:
                meter = val
                break
            case 2:
                meter = 1609.344 * val
                break
            case 3:
                meter = 0.3048 * val
                break
            case 4:
                meter = 0.0254 * val
                break

        }

        switch (unit2) {
            case 0 :
                answer = 0.001 * meter
                break
            case 1:
                answer = meter
                break
            case 2:
                answer = 0.0006213712 * meter
                break
            case 3:
                answer = 3.280839895 * meter
                break
            case 4:
                answer = 39.37007874 * meter
                break

        }

        return answer
    }
}