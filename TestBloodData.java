import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestBloodData extends JFrame {
    private JComboBox<BloodData.BloodType> bloodTypeComboBox;
    private JRadioButton positiveRhButton, negativeRhButton;
    private JButton showButton, updateButton;
    private JTextArea displayArea;
    private BloodData defaultBloodData = new BloodData();

    public TestBloodData() {
        super("Blood Data Test");

        // 设置主布局为 BorderLayout
        setLayout(new BorderLayout());

        // 创建包含选择器和按钮的面板，使用默认的FlowLayout
        JPanel inputPanel = new JPanel();
        
        bloodTypeComboBox = new JComboBox<>(BloodData.BloodType.values());
        inputPanel.add(bloodTypeComboBox);

        positiveRhButton = new JRadioButton("Positive", true);
        negativeRhButton = new JRadioButton("Negative");
        ButtonGroup group = new ButtonGroup();
        group.add(positiveRhButton);
        group.add(negativeRhButton);
        inputPanel.add(positiveRhButton);
        inputPanel.add(negativeRhButton);

        showButton = new JButton("Show Default Blood Data");
        inputPanel.add(showButton);

        updateButton = new JButton("Update with User Input");
        inputPanel.add(updateButton);

        // 将inputPanel添加到窗口的北部（上方）
        add(inputPanel, BorderLayout.NORTH);

        // 初始化用于显示信息的 JTextArea
        displayArea = new JTextArea(5, 20);
        displayArea.setEditable(false); // 使其不可编辑
        // 将JTextArea放置在JScrollPane中以支持滚动，并将其添加到窗口的南部（底部）
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        // 为按钮添加事件监听器
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("Default BloodData: " + defaultBloodData.describe());
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BloodData.BloodType selectedType = (BloodData.BloodType) bloodTypeComboBox.getSelectedItem();
                BloodData.RhFactor selectedFactor = positiveRhButton.isSelected() ? BloodData.RhFactor.POSITIVE : BloodData.RhFactor.NEGATIVE;

                defaultBloodData.setBloodType(selectedType);
                defaultBloodData.setRhFactor(selectedFactor);
                displayArea.setText("Updated BloodData: " + defaultBloodData.describe());
            }
        });

        // Final setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // 自动调整大小以适应内容
        setVisible(true); // 使窗口可见
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestBloodData();
            }
        });
    }
}
