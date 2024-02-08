import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class PizzaApp extends JFrame implements ActionListener {
    float pizzaPrice = 0; // 记录披萨价格
    Set<String> selectedToppings = new HashSet<>(); // 记录选择的配料
    JLabel pizzaQuestion = new JLabel("What kind of pizza you want?", SwingConstants.CENTER);

    JButton pressSmall = new JButton("Small $5");
    JButton pressMedium = new JButton("Medium $10");
    JButton pressLarge = new JButton("Large $15");
    JButton pressSuperLarge = new JButton("Super $20");

    JPanel cardPanel = new JPanel(new CardLayout());
    JPanel pizzaPanel = new JPanel(new GridLayout(5, 1, 10, 10)); // 使用GridLayout布局管理器
    JPanel toppingsPanel = new JPanel(new GridLayout(6, 1, 10, 10)); // 增加一行用于提示信息
    JLabel toppingsQuestion = new JLabel("Select up to 3 toppings. All for $1.25!", SwingConstants.CENTER);

    JButton topping1 = new JButton("Topping1 $0.5");
    JButton topping2 = new JButton("Topping2 $0.5");
    JButton topping3 = new JButton("Topping3 $0.5");
    JButton CHECKOUT = new JButton("CHECKOUT");

    public PizzaApp() {
        super("Pizza App");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pizzaPanel.add(pizzaQuestion);
        pizzaPanel.add(pressSmall);
        pizzaPanel.add(pressMedium);
        pizzaPanel.add(pressLarge);
        pizzaPanel.add(pressSuperLarge);

        toppingsPanel.add(toppingsQuestion);
        toppingsPanel.add(topping1);
        toppingsPanel.add(topping2);
        toppingsPanel.add(topping3);
        toppingsPanel.add(new JLabel()); // 占位符，保持布局一致
        toppingsPanel.add(CHECKOUT);

        cardPanel.add(pizzaPanel, "Pizza Size");
        cardPanel.add(toppingsPanel, "Toppings");
        add(cardPanel);

        pressSmall.addActionListener(this);
        pressMedium.addActionListener(this);
        pressLarge.addActionListener(this);
        pressSuperLarge.addActionListener(this);

        topping1.addActionListener(this);
        topping2.addActionListener(this);
        topping3.addActionListener(this);
        CHECKOUT.addActionListener(this);

        ((CardLayout) cardPanel.getLayout()).show(cardPanel, "Pizza Size");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton == pressSmall || clickedButton == pressMedium || clickedButton == pressLarge || clickedButton == pressSuperLarge) {
            pizzaPrice = Float.parseFloat(clickedButton.getText().replaceAll("[^0-9.]", ""));
            ((CardLayout) cardPanel.getLayout()).show(cardPanel, "Toppings");
        } else if (clickedButton == topping1 || clickedButton == topping2 || clickedButton == topping3) {
            if (selectedToppings.add(clickedButton.getText())) { // 成功添加说明之前未选
                clickedButton.setBackground(Color.RED); // 改变按钮颜色
            }
            if (selectedToppings.size() == 3) {
                // 当选择了三种配料时，设置特殊价格
                JOptionPane.showMessageDialog(this, "Special offer: All 3 toppings for $1.25!");
            }
        } else if (clickedButton == CHECKOUT) {
            float toppingsPrice = selectedToppings.size() == 3 ? 1.25f : selectedToppings.size() * 0.5f;
            float totalPrice = pizzaPrice + toppingsPrice;
            JOptionPane.showMessageDialog(this, "Total Price: $" + totalPrice);
            selectedToppings.clear(); // 结账后清除选择的配料
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PizzaApp().setVisible(true);
        });
    }
}