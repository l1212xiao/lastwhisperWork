package com.lyx.loan.frame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author lvyunxiao
 * @date 2024/4/11
 * @description 加和计算器
 */
public class AddCalculator extends JFrame {

	// 待计算部分
	private JTextField addLeftTextField = new JTextField("");
	private JTextField addRightTextField = new JTextField("");
	private JTextField addTotalTextField = new JTextField();
	private JButton addButton = new JButton("计算器 相加");

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Double addLeft = Double.parseDouble(addLeftTextField.getText());
			Double addRight = Double.parseDouble(addRightTextField.getText());
			Double addTotal = addLeft + addRight;
			addTotalTextField.setText(String.format("%.2f", addTotal));
		}
	}

	public AddCalculator() {
		JPanel p1 = new JPanel(new GridLayout(16,2));
		// 输入部分
		p1.add(new JLabel("加数左:"));
		p1.add(addLeftTextField);
		p1.add(new JLabel("加数右:"));
		p1.add(addRightTextField);

		// 计算部分
		p1.add(new JLabel("和:"));
		p1.add(addTotalTextField);

		p1.setBorder(new TitledBorder("请输入以下值: "));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(addButton);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		addButton.addActionListener(new ButtonListener());

	}

	public static void main(String[] args) {
		AddCalculator frame = new AddCalculator();
		frame.setTitle("加和计算器");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
