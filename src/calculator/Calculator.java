package calculator;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator extends JFrame implements ActionListener {
	
	JButton nums[]=new JButton[10];
	JButton funs[]=new JButton[8];
	JButton dot,equal, plus,minus;
	JButton multiply, divide,del,clr;
	JTextArea text=new JTextArea();
	JPanel panel=new JPanel();
	double num1,num2,sign=1;
	char op;
	
	Font font=new Font("Ink Free",Font.BOLD,30);
	
	Calculator(){
		this.setSize(450,550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		
		text.setBounds(50, 30,350, 50);
		text.setFont(font);
		text.setEditable(false);
		
		clr=new JButton("Clear");
		del=new JButton("Delete");
		divide=new JButton("/");
		multiply=new JButton("*");
		minus=new JButton("-");
		plus=new JButton("+");
		equal=new JButton("=");
		dot=new JButton(".");
		
		for(int i=0;i<10;i++) {
			nums[i]=new JButton(String.valueOf(i));
			nums[i].setFocusable(false);
			nums[i].addActionListener(this);
			nums[i].setFont(font);
		}
		
		funs[0]=plus;
		funs[1]=minus;
		funs[2]=multiply;
		funs[3]=divide;
		funs[4]=dot;
		funs[5]=equal;
		funs[6]=del;
		funs[7]=clr;
		
		for(int i=0;i<8;i++) {
			funs[i].setFocusable(false);
			funs[i].addActionListener(this);
			funs[i].setFont(font);
		}
		
		clr.setBounds(50,425,170,50);
		del.setBounds(230, 425, 170, 50);
		
		panel.setBounds(50, 100, 350, 300);
		panel.setLayout(new GridLayout(4,4,5,5));
		panel.add(nums[1]);
		panel.add(nums[2]);
		panel.add(nums[3]);
		panel.add(funs[0]);
		panel.add(nums[4]);
		panel.add(nums[5]);
		panel.add(nums[6]);
		panel.add(funs[1]);
		panel.add(nums[7]);
		panel.add(nums[8]);
		panel.add(nums[9]);
		panel.add(funs[2]);
		panel.add(funs[4]);
		panel.add(nums[0]);
		panel.add(funs[5]);
		panel.add(funs[3]);
		
		
		
		this.add(panel);
		this.add(text);
		this.add(clr);
		this.add(del);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
		if(e.getSource()==nums[i]) {
			text.setText(text.getText().concat(String.valueOf(i)));
		}
		}
		if(e.getSource()==plus) {
			num1=Double.parseDouble(text.getText());
			text.setText("");
			op='+';
		}
		if(e.getSource()==minus) {
			if(text.getText().isEmpty()) {
				sign=-1;
				text.setText("-");
			}
			else {
			num1=Double.parseDouble(text.getText());
			text.setText("");
			op='-';
			}
		}
		if(e.getSource()==multiply) {
			num1=Double.parseDouble(text.getText());
			text.setText("");
			op='*';
		}
		if(e.getSource()==divide) {
			num1=Double.parseDouble(text.getText());
			text.setText("");
			op='/';
		}
		if(e.getSource()==dot) {
			text.setText(text.getText().concat("."));
		}
		if(e.getSource()==clr) {
			text.setText("");
		}
		if(e.getSource()==equal) {
			num2=Double.parseDouble(text.getText());
			switch(op) {
			case '+':
				num1=num1+num2;
				text.setText(String.valueOf(num1));
				break;
			case '-':
				num1=num1-num2;
				text.setText(String.valueOf(num1));
				break;
			case '*':
				num1=num1*num2;
				text.setText(String.valueOf(num1));
				break;
			case '/':
				num1=num1/num2;
				text.setText(String.valueOf(num1));
				break;
			}
		}
		if(e.getSource()==del) {
			String s=text.getText();
			//if(s.charAt(s.length()-1)=='-1') sign=1;
			text.setText(s.substring(0, s.length()-1));
		}
		
	}

}























