import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;


public class Computer extends CRival implements ActionListener {
public int x;
public int movecalc;

	Computer()
	{
		super(3);
		firstTurn();		
	}
		
	
	
	public void button_pick()
	{
		int w =0;
		do {
		x=random.nextInt(8);
		if(buttons[x].getText()=="") 
		{
			buttons[x].setForeground(new Color(0,0,255));
			buttons[x].setText("O");
			player1turn=true;
			
				check3();
				w=0;
				movecalc=movecalc+1;
		}else
		{
			w=w+1;
		}
		if(movecalc==9)
		{
			w=0;
		}
		}while(w>0);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<n*n;i++)
		{
			if(e.getSource()==buttons[i])
			
			{
			firstTurn1();
				if(player1turn)
				{
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						player1turn=false;
						check3x();
						movecalc=movecalc+1;
					}
				}
				
				button_pick();
					
			}
		}
		
		if(e.getSource()==reset)
		{
			
			game=new TicTacToe();
		}
		
	}

}
