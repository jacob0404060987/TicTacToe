import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener{
	
	Random random=new Random();
	JFrame frame=new JFrame();
	JFrame frame2;
	JPanel menu_panel = new JPanel();
	JPanel title_panel = new JPanel();
	JLabel textfield = new JLabel();
	JTextField textfield2;
	JPanel board_panel = new JPanel();
	JButton[] buttons = new JButton[49];
	JButton board3 = new JButton("Plansza 3x3");
	JButton board5 = new JButton("Plansza 5x5");
	JButton board7 = new JButton("Plansza 7x7");
	JButton reset = new JButton("Reset");
	JButton solo = new JButton("Gra solo");
	JButton backup = new JButton("*HARD*");
	static TicTacToe game;
	
	
	boolean player1turn;
	
	TicTacToe()
	{
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,1000);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true); 
		
		menu_panel.setLayout(new GridLayout(2,3));
		menu_panel.setBounds(0,0,800,100);
		
		board3.setFont(new Font("Ink Free",Font.BOLD,40));
		board3.setBackground(Color.BLACK);
		board3.setForeground(Color.WHITE);
		board5.setFont(new Font("Ink Free",Font.BOLD,40));
		board5.setBackground(Color.BLACK);
		board5.setForeground(Color.WHITE);
		board7.setFont(new Font("Ink Free",Font.BOLD,40));
		board7.setBackground(Color.BLACK);
		board7.setForeground(Color.WHITE);
		
		reset.setFont(new Font("Ink Free",Font.BOLD,40));
		reset.setBackground(Color.BLACK);
		reset.setForeground(Color.WHITE);
		solo.setFont(new Font("Ink Free",Font.BOLD,40));
		solo.setBackground(Color.BLACK);
		solo.setForeground(Color.WHITE);
		backup.setFont(new Font("Ink Free",Font.BOLD,40));
		backup.setBackground(Color.BLACK);
		backup.setForeground(Color.WHITE);
		
		board3.addActionListener(this);
		board5.addActionListener(this);
		board7.addActionListener(this);
		solo.addActionListener(this);
		backup.addActionListener(this);
		reset.addActionListener(this);
		
		
		menu_panel.add(board3);
		menu_panel.add(board5);
		menu_panel.add(board7);
		menu_panel.add(solo);
		menu_panel.add(reset);
		menu_panel.add(backup);
		
		textfield.setBackground(Color.BLACK);
		textfield.setForeground(Color.WHITE);
		textfield.setFont(new Font("Ink Free",Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.add(textfield);
		title_panel.setBackground(Color.BLACK);
		frame.add(menu_panel,BorderLayout.CENTER);
		frame.add(title_panel,BorderLayout.NORTH);

		firstTurn();
		
		
		
	}
	
	public void firstTurn()

	{
		if(random.nextInt(2)==0)
		{
			player1turn=true;
		}
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==board3)
		{
			frame.setVisible(false);
			CRival rival = new CRival(3);
	
			
		
		}
		if(e.getSource()==board5)
		{
			CRival rival = new CRival(5);
		}
		if(e.getSource()==board7)
		{
			CRival rival = new CRival(7);
		}
		
		
		
		
		
		if(e.getSource()==solo)
		{
			Computer computer = new Computer();
			
			
			
			}
		if(e.getSource()==backup)
		{
			Ultimate ultimate = new Ultimate();
		}	
		if(e.getSource()==reset)
		{
			game.setVisible(false);
			game.dispose();
			game=new TicTacToe();
			
		}
		
			
		}
	public static void main(String[] args) {
		game = new TicTacToe();
}
}


