import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DemoPizza {
    private static ArrayList<String> toppingsList = new ArrayList<>();
    private static JFrame frame;
    private static JTextField toppingInputField;
    private static JTextArea toppingsDisplayArea;
    private static JTextField deliveryAddressInputField;
    private static JCheckBox deliveryCheckbox;
    private static JButton addButton;
    private static JButton finishButton;
    private static JLabel totalPriceLabel;

    public static void main(String[] args) {
        // 设置基础窗体
        frame = new JFrame("Pizza Order System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // 配料输入
        toppingInputField = new JTextField(20);
        frame.add(new JLabel("Enter topping:"));
        frame.add(toppingInputField);

        // 添加按钮
        addButton = new JButton("Add Topping");
        frame.add(addButton);

        // 显示已添加的配料
        toppingsDisplayArea = new JTextArea(5, 30);
        toppingsDisplayArea.setEditable(false);
        frame.add(new JScrollPane(toppingsDisplayArea));

        // 是否需要送货
        deliveryCheckbox = new JCheckBox("Delivery?");
        frame.add(deliveryCheckbox);

        // 送货地址输入
        deliveryAddressInputField = new JTextField(20);
        frame.add(new JLabel("Delivery address:"));
        frame.add(deliveryAddressInputField);

        // 完成按钮
        finishButton = new JButton("Finish");
        frame.add(finishButton);

        // 总价格显示
        totalPriceLabel = new JLabel("Total Price: $0.00");
        frame.add(totalPriceLabel);

        // 添加事件监听器
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTopping();
            }
        });

        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                finishOrder();
            }
        });

        // 显示窗体
        frame.setVisible(true);
    }

    private static void addTopping() {
        String topping = toppingInputField.getText().trim();
        if (!topping.isEmpty() && toppingsList.size() < 10) {
            toppingsList.add(topping);
            toppingsDisplayArea.append(topping + "\n");
            toppingInputField.setText("");
        }
    }

    private static void finishOrder() {
        Pizza pizza;
        if (deliveryCheckbox.isSelected()) {
            String address = deliveryAddressInputField.getText().trim();
            String[] toppingsArray = toppingsList.toArray(new String[0]);
            pizza = new DeliveryPizza(toppingsArray, address, toppingsList.size());
        } else {
            String[] toppingsArray = toppingsList.toArray(new String[0]);
            pizza = new Pizza(toppingsArray, toppingsList.size());
        }
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", pizza.getPrice()));
        JOptionPane.showMessageDialog(frame, pizza.toString(), "Order Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}
