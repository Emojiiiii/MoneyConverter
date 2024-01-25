import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaApp extends JFrame implements ActionListener {
    int price = 0; // 记录总价格
    JLabel question = new JLabel("您想要哪种比萨？");

    JButton pressSmall = new JButton("小号 $5");
    JButton pressMedium = new JButton("中号 $10");
    JButton pressLarge = new JButton("大号 $15");
    JButton pressSuperLarge = new JButton("超大号 $20");

    public PizzaApp() {
        super("比萨应用");
        final int WIDTH = 275;
        final int HEIGHT = 224;
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(question);
        add(pressSmall);
        add(pressMedium);
        add(pressLarge);
        add(pressSuperLarge);

        pressSmall.addActionListener(this);
        pressMedium.addActionListener(this);
        pressLarge.addActionListener(this);
        pressSuperLarge.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 根据按钮点击事件更新价格
        if (e.getSource() == pressSmall) {
            price += 5;
        } else if (e.getSource() == pressMedium) {
            price += 10;
        } else if (e.getSource() == pressLarge) {
            price += 15;
        } else if (e.getSource() == pressSuperLarge) {
            price += 20;
        }

        // 创建新的弹窗询问配料
        if (price > 0) {
            JLabel toppingsQuestion = new JLabel("您想要哪些配料？");
            JLabel topping1 = new JLabel("1");
            JLabel topping2 = new JLabel("2");
            JLabel topping3 = new JLabel("3");
            JLabel check = new JLabel("完成");

            // 在此可以添加代码来显示配料选择的界面

            // 可以使用JOptionPane.showInputDialog等方法来获取用户输入

            // 最后，您可能需要更新总价格和配料的逻辑

            // 示例：使用JOptionPane显示总价
            JOptionPane.showMessageDialog(this, "总价格：" + price);
        }
    }

    public static void main(String[] args) {
        new PizzaApp().setVisible(true);
    }
}




