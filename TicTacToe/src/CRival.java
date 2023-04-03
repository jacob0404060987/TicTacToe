import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CRival extends TicTacToe implements ActionListener {
int n;
Random random=new Random();

	CRival(int w)
	{
		setn(w);
		board_panel.setLayout(new GridLayout(n,n));
		
		for(int i=0;i<n*n;i++)
		{
			buttons[i]=new JButton();
			board_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].setBackground(Color.BLACK);
			buttons[i].addActionListener(this);
		}
		frame2= new JFrame();
		frame2.setLayout(new BorderLayout());
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(800,1000);
		frame2.getContentPane().setBackground(Color.BLACK);
		frame2.setLayout(new BorderLayout());
		frame2.setVisible(true);
		frame2.add(board_panel,BorderLayout.CENTER);
		frame2.add(reset,BorderLayout.NORTH);
		frame2.add(textfield,BorderLayout.SOUTH);
		firstTurn1();
	}
	
			
	 
	public void setn(int n)
	{
		this.n=n;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<n*n;i++)
		{
			
			if(e.getSource()==buttons[i])
			{
				
				if(player1turn)
				{
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1turn=false;
						if(n==3)
						{
							check3x();
						}
						if(n==5)
						{
							check5x();
						}
						if(n==7)
						{
							check7x();
						}
						
					}
				}else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player1turn=true;
						if(n==3)
						{
							check3();
						}
						if(n==5)
						{
							check5();
						}
						if(n==7)
						{
							check7();
						}
						
					
				}
			}
		}
			firstTurn1();
		
	}
		if(e.getSource()==reset)
		{
			game.dispose();
			game=new TicTacToe();
		}
}
	public void check3x()
	{
		
for(int i=0;i<n*n;i=i+n)
{
	if((buttons[i].getText()=="X") && (buttons[i+1].getText()=="X") &&(buttons[i+2].getText()=="X")) Wins3(i,i+1,i+2);
}
for(int i=0;i+n+n<n*n;i++)
{
	if((buttons[i].getText()=="X") && (buttons[i+n].getText()=="X") &&(buttons[i+n+n].getText()=="X")) Wins3(i,i+n,i+n+n);
}
if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") &&(buttons[8].getText()=="X")) Wins3(0,n+1,2*n+2);
if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") &&(buttons[6].getText()=="X")) Wins3(n-1,n+1,2*n);

		
	 

	}
	
	public void check5x()
	{
		for(int i=0;i<n*n;i=i+n)
		{
			if((buttons[i].getText()=="X") && (buttons[i+1].getText()=="X") &&(buttons[i+2].getText()=="X") && (buttons[i+3].getText()=="X")&&(buttons[i+4].getText()=="X")) Wins5(i,i+1,i+2,i+3,i+4);
		}
		for(int i=0;i+n+n<n*n;i++)
		{
			if((buttons[i].getText()=="X") && (buttons[i+n].getText()=="X") &&(buttons[i+2*n].getText()=="X") && (buttons[i+3*n].getText()=="X")&&(buttons[i+4*n].getText()=="X")) Wins5(i,i+n,i+2*n,i+3*n,i+4*n);
		}
		if((buttons[0].getText()=="X") && (buttons[6].getText()=="X") &&(buttons[12].getText()=="X")&& (buttons[18].getText()=="X") &&(buttons[24].getText()=="X")) Wins5(0,6,12,18,24);
		if((buttons[4].getText()=="X") && (buttons[8].getText()=="X") &&(buttons[12].getText()=="X")&& (buttons[16].getText()=="X") &&(buttons[20].getText()=="X")) Wins5(4,8,12,16,20);
		
	}
	public void check7x()
	{
		for(int i=0;i<n*n;i=i+n)
		{
			if((buttons[i].getText()=="X") && (buttons[i+1].getText()=="X") &&(buttons[i+2].getText()=="X") && (buttons[i+3].getText()=="X") && (buttons[i+4].getText()=="X")&& (buttons[i+5].getText()=="X") && (buttons[i+6].getText()=="X")) Wins7(i,i+1,i+2,i+3,i+4,i+5,i+6);
		}
		for(int i=0;i+n+n<n*n;i++)
		{
			if((buttons[i].getText()=="X") && (buttons[i+n].getText()=="X") &&(buttons[i+2*n].getText()=="X") && (buttons[i+3*n].getText()=="X") && (buttons[i+4*n].getText()=="X")&& (buttons[i+5*n].getText()=="X") && (buttons[i+6*n].getText()=="X")) Wins7(i,i+n,i+2*n,i+3*n,i+4*n,i+5*n,i+6*n);
		}
		if((buttons[0].getText()=="X") && (buttons[8].getText()=="X") &&(buttons[16].getText()=="X") && (buttons[24].getText()=="X") &&(buttons[32].getText()=="X") && (buttons[40].getText()=="X") &&(buttons[48].getText()=="X")) Wins7(0,8,16,24,32,40,48);
		if((buttons[6].getText()=="X") && (buttons[12].getText()=="X") &&(buttons[18].getText()=="X") && (buttons[24].getText()=="X") &&(buttons[30].getText()=="X") && (buttons[36].getText()=="X") &&(buttons[42].getText()=="X")) Wins7(6,12,18,24,30,36,42);		
	}
	
	public void check3()
	{
		
for(int i=0;i<n*n;i=i+n)
{
	if((buttons[i].getText()=="O") && (buttons[i+1].getText()=="O") &&(buttons[i+2].getText()=="O")) Wins3(i,i+1,i+2);
}
for(int i=0;i+n+n<n*n;i++)
{
	if((buttons[i].getText()=="O") && (buttons[i+n].getText()=="O") &&(buttons[i+n+n].getText()=="O")) Wins3(i,i+n,i+n+n);
}
if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") &&(buttons[8].getText()=="O")) Wins3(0,n+1,2*n+2);
if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") &&(buttons[6].getText()=="O")) Wins3(n-1,n+1,2*n);

		
	 

	}
	
	public void check5()
	{
		for(int i=0;i<n*n;i=i+n)
		{
			if((buttons[i].getText()=="O") && (buttons[i+1].getText()=="O") &&(buttons[i+2].getText()=="O") && (buttons[i+3].getText()=="O")&&(buttons[i+4].getText()=="O")) Wins5(i,i+1,i+2,i+3,i+4);
		}
		for(int i=0;i+n+n<n*n;i++)
		{
			if((buttons[i].getText()=="O") && (buttons[i+n].getText()=="O") &&(buttons[i+2*n].getText()=="O") && (buttons[i+3*n].getText()=="O")&&(buttons[i+4*n].getText()=="O")) Wins5(i,i+n,i+2*n,i+3*n,i+4*n);
		}
		if((buttons[0].getText()=="O") && (buttons[6].getText()=="O") &&(buttons[12].getText()=="O")&& (buttons[18].getText()=="O") &&(buttons[24].getText()=="O")) Wins5(0,6,12,18,24);
		if((buttons[4].getText()=="O") && (buttons[8].getText()=="O") &&(buttons[12].getText()=="O")&& (buttons[16].getText()=="O") &&(buttons[20].getText()=="O")) Wins5(4,8,12,16,20);
		
	}
	public void check7()
	{
		for(int i=0;i<n*n;i=i+n)
		{
			if((buttons[i].getText()=="O") && (buttons[i+1].getText()=="O") &&(buttons[i+2].getText()=="O") && (buttons[i+3].getText()=="O") && (buttons[i+4].getText()=="O")&& (buttons[i+5].getText()=="O") && (buttons[i+6].getText()=="O")) Wins7(i,i+1,i+2,i+3,i+4,i+5,i+6);
		}
		for(int i=0;i+n+n<n*n;i++)
		{
			if((buttons[i].getText()=="O") && (buttons[i+n].getText()=="O") &&(buttons[i+2*n].getText()=="O") && (buttons[i+3*n].getText()=="O") && (buttons[i+4*n].getText()=="O")&& (buttons[i+5*n].getText()=="O") && (buttons[i+6*n].getText()=="O")) Wins7(i,i+n,i+2*n,i+3*n,i+4*n,i+5*n,i+6*n);
		}
		if((buttons[0].getText()=="O") && (buttons[8].getText()=="O") &&(buttons[16].getText()=="O") && (buttons[24].getText()=="O") &&(buttons[32].getText()=="O") && (buttons[40].getText()=="O") &&(buttons[48].getText()=="O")) Wins7(0,8,16,24,32,40,48);
		if((buttons[6].getText()=="O") && (buttons[12].getText()=="O") &&(buttons[18].getText()=="O") && (buttons[24].getText()=="O") &&(buttons[30].getText()=="O") && (buttons[36].getText()=="O") &&(buttons[42].getText()=="O")) Wins7(6,12,18,24,30,36,42);		
	}
	
	
	public void Wins3(int a,int b,int c) {
		for(int i=0;i<n*n;i++) {
			buttons[i].setEnabled(false);
		}
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
	}
	public void Wins5(int a,int b,int c,int d, int e) {
		for(int i=0;i<n*n;i++) {
			buttons[i].setEnabled(false);
		}
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		buttons[d].setBackground(Color.GREEN);
		buttons[e].setBackground(Color.GREEN);
		
	}
	public void Wins7(int a,int b,int c,int d, int e,int f, int g) {
		for(int i=0;i<n*n;i++) {
			buttons[i].setEnabled(false);
		}
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		buttons[d].setBackground(Color.GREEN);
		buttons[e].setBackground(Color.GREEN);
		buttons[f].setBackground(Color.GREEN);
		buttons[g].setBackground(Color.GREEN);
		
	}
	
	public void firstTurn1()
	{
			
		
		
		if(player1turn) {
			player1turn=true;
			textfield.setText("X turn");
		}
		else {
			player1turn=false;
			textfield.setText("O turn");
		}
	}
}
