package com.lyx.loan;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author lvyunxiao
 * @date 2023/6/2
 * @description
 */
public class LoanCalculator extends JFrame {
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int loanType = Integer.parseInt(jtfLoanType.getText());
			double interestC = Double.parseDouble(jtfLoanRateC.getText()) / 100;
			double interestAF = Double.parseDouble(jtfLoanRateAF.getText()) / 100;
			int loanAmountAF = 10000 * Integer.parseInt(jtfLoanAmountAF.getText());

			int year = Integer.parseInt(jtfLoanYears.getText());
			double area = Double.parseDouble(jtfAreas.getText());
			double pricePerSquareMeter = Double.parseDouble(jtfPricePerSquareMeter.getText());
			double firstRate = Double.parseDouble(jtfHouseFirstAmountRating.getText());
			double houseAmount = area * pricePerSquareMeter;
			double firstAmount = firstRate * houseAmount;
			double loanAmount = houseAmount - firstRate * houseAmount;

			double loanAmountC = loanType == 2 ? loanAmount : loanAmount - loanAmountAF;
			int allMonth = year * 12;
			//计算商贷部分，纯公积金贷款时该部分为0
			//房贷计算部分
			double monthlyInterestC = interestC / 12;


			//等额本息 : 贷款本金*月利率*(1+月利率)^还款月数/((1+月利率)*还款月数-1)  = 贷款本金*月利率 / 1 - 1/(月利率*(1+月利率)^还款月数)
			double monthlyPaymentC_ECT = loanAmountC * monthlyInterestC / (1 - 1 / Math.pow(1 + monthlyInterestC, allMonth));
			double totalPaymentC_ECT = monthlyPaymentC_ECT * allMonth;

			//等额本金
			//每月还款额 = 每月本金 + 每月本息     每月本金=本金/还款月数    每月本息=(本金-累积还款总额)*月利率
			double monthPrincipalAmountC_CT = loanAmountC / allMonth;

			ArrayList<Double> loanListECT = new ArrayList<>(allMonth);
			double monthDifferenceC_CT = monthPrincipalAmountC_CT * monthlyInterestC;
			//E = 总月数*月本金 + 总贷款*月数*月利率 - (n-1)*n/2*月本金*月利率 = 总贷款 + 总贷款*年*年利率 - (n-1)/2*总贷款*月利率 = 总贷款(1+ 年*年利率-(月数-1)/2 *月利率)
			double totalPaymentC_CT = loanAmountC * (1 + year * interestC - (allMonth - 1) * monthlyInterestC/ 2 );
			for (int i = 0; i < allMonth; i++) {
				double moneyCT = monthPrincipalAmountC_CT + (loanAmountC - i * monthPrincipalAmountC_CT) * monthlyInterestC;
				loanListECT.add(moneyCT);
			}
			double monthlyPaymentAF_ECT = 0;
			double totalPaymentAF_ECT = 0;
			double monthDifferenceAF_CT = 0;
			double totalPaymentAF_CT = 0;
			ArrayList<Double> loanListCT = new ArrayList<>(allMonth);
			//不是纯商贷时，计算公积金贷款
			if (loanType != 2) {
				//等额本息
				double monthlyInterestAF = interestAF / 12;
				monthlyPaymentAF_ECT = loanAmountAF * monthlyInterestAF / (1 - 1 / Math.pow(1 + monthlyInterestAF, allMonth));
				totalPaymentAF_ECT = monthlyPaymentAF_ECT * allMonth;

				//等额本金
				//每月还款额 = 每月本金 + 每月本息     每月本金=本金/还款月数    每月本息=(本金-累积还款总额)*月利率
				double monthPrincipalAmountAF = loanAmountAF / allMonth;
				monthDifferenceAF_CT = monthPrincipalAmountAF * monthlyInterestAF;
				totalPaymentAF_CT = loanAmountAF * (1 + year * interestAF - (allMonth - 1)* monthlyInterestAF / 2 );
				for (int i = 0; i < allMonth; i++) {
					double moneyAF = monthPrincipalAmountAF + (loanAmountAF - i * monthPrincipalAmountAF) * monthlyInterestAF;
					loanListCT.add(moneyAF);

				}

			}
			double monthlyPayment_ECT = monthlyPaymentC_ECT + monthlyPaymentAF_ECT;
			double totalPayment_ECT = totalPaymentC_ECT + totalPaymentAF_ECT;

			double totalPayment_CT = totalPaymentC_CT + totalPaymentAF_CT;
			double monthDifference_CT = monthDifferenceC_CT + monthDifferenceAF_CT;

			double monthlyPaymentProIntFirst = loanListECT.get(0) + loanListCT.get(0);
			double monthlyPaymentProIntLast = loanListECT.get(loanListECT.size() - 1) + loanListCT.get(loanListECT.size() - 1);
			jtfHouseAmount.setText(String.format("%.2f", houseAmount));
			jtfFirstAmount.setText(String.format("%.2f", firstAmount));
			jtfLoanAmount.setText(String.format("%.2f", loanAmount));
			jtfCommercialLoanAmount.setText(String.format("%.2f", loanAmountC));

			jtfMonthlyPaymentInterestECT.setText(String.format("%.2f", monthlyPayment_ECT));
			jtfMonthlyPaymentEC.setText("" + String.format("%.2f", monthlyPaymentProIntFirst) + "|" + String.format("%.2f", monthlyPaymentProIntLast) + "|" + String.format("%.2f", monthDifference_CT));
			jtfTotalPaymentECT.setText(String.format("%.2f", totalPayment_ECT));
			jtfTotalPaymentEC.setText(String.format("%.2f", totalPayment_CT));
		}
	}

	private JTextField jtfLoanType = new JTextField("1");
	private JTextField jtfLoanRateC = new JTextField("4.85");  //商业贷款利率 jtfLoanRateCommercial
	private JTextField jtfLoanRateAF = new JTextField("3.1");  //公积金贷款利率 jtfLoanRateAccumulationFund
	private JTextField jtfLoanAmountAF = new JTextField("60");  //公积金贷款数
	private JTextField jtfLoanYears = new JTextField("25");
	private JTextField jtfHouseFirstAmountRating = new JTextField("0.4"); //首付
	private JTextField jtfAreas = new JTextField("80");
	private JTextField jtfPricePerSquareMeter = new JTextField("50000");
	//待计算部分

	private JTextField jtfHouseAmount = new JTextField();
	private JTextField jtfFirstAmount = new JTextField();//首付
	private JTextField jtfLoanAmount = new JTextField();//贷款总额
	private JTextField jtfCommercialLoanAmount = new JTextField();//商业贷款总额

	private JTextField jtfMonthlyPaymentInterestECT = new JTextField();//等额本息 月供 jtfMonthlyPaymentEqualityCorpusInterest
	private JTextField jtfMonthlyPaymentEC = new JTextField();//等额本金月供 jtfMonthlyPaymentEqualityCorpus
	private JTextField jtfTotalPaymentECT = new JTextField();//等额本息 总额
	private JTextField jtfTotalPaymentEC = new JTextField();//等额本金 总额
	private JButton jbtComputeLoan = new JButton("房贷计算器 Compute Payment");

	public LoanCalculator() {
		JPanel p1 = new JPanel(new GridLayout(16, 2));
		//输入部分
		p1.add(new JLabel("贷款方式 1组合贷款默认 2纯商贷 3纯公积金贷款"));
		p1.add(jtfLoanType);
		p1.add(new JLabel("商业贷款利率 默认4.85"));
		p1.add(jtfLoanRateC);
		p1.add(new JLabel("公积金贷款利率 默认3.1"));
		p1.add(jtfLoanRateAF);
		p1.add(new JLabel("贷款年限 默认25"));
		p1.add(jtfLoanYears);
		p1.add(new JLabel("首付比例 默认40%"));
		p1.add(jtfHouseFirstAmountRating);
		p1.add(new JLabel("公积金数 默认60W"));
		p1.add(jtfLoanAmountAF);
		p1.add(new JLabel("房屋面积 areas"));
		p1.add(jtfAreas);
		p1.add(new JLabel("房屋单价 price_per_square_meter"));
		p1.add(jtfPricePerSquareMeter);

		//计算部分
		p1.add(new JLabel("房价总额 "));
		p1.add(jtfHouseAmount);
		p1.add(new JLabel("首付总额 "));
		p1.add(jtfFirstAmount);
		p1.add(new JLabel("贷款总额 "));
		p1.add(jtfLoanAmount);
		p1.add(new JLabel("商贷总额 "));
		p1.add(jtfCommercialLoanAmount);
		p1.add(new JLabel("月供-等额本息 每月一样"));
		p1.add(jtfMonthlyPaymentInterestECT);
		p1.add(new JLabel("月供-等额本金 逐月递减，格式为，首月|末月|递减"));
		p1.add(jtfMonthlyPaymentEC);
		p1.add(new JLabel("等额本息总还贷款 Total"));
		p1.add(jtfTotalPaymentECT);
		p1.add(new JLabel("等额本金总还贷款 Total"));
		p1.add(jtfTotalPaymentEC);

		p1.setBorder(new TitledBorder("请输入以下值："));
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(jbtComputeLoan);
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		jbtComputeLoan.addActionListener(new ButtonListener());

	}

	public static void main(String[] args) {
		LoanCalculator frame = new LoanCalculator();
		frame.setTitle("房贷计算器");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

