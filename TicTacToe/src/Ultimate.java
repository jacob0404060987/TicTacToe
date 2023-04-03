import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ultimate extends CRival implements ActionListener
{
public int movecalc;
	Ultimate() {
		super(3);
		firstTurn();
	}
	

	public Boolean isEmpty() {
		boolean empty=true;
		for(int i=0;i<9;i++)
		{
			if(buttons[i].getText()=="")
			{
			empty=true;
			}else empty=false;
			}
		return empty;
}
	
	public int checkifwin()
	{
		for(int i=0;i<n*n;i=i+n)
		{
			if((buttons[i].getText()=="O") && (buttons[i+1].getText()=="O") &&(buttons[i+2].getText()=="O")) return -10;
		}
		for(int i=0;i+n+n<n*n;i++)
		{
			if((buttons[i].getText()=="O") && (buttons[i+n].getText()=="O") &&(buttons[i+n+n].getText()=="O")) return -10;;
		}
		if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") &&(buttons[8].getText()=="O")) return -10;
		if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") &&(buttons[6].getText()=="O")) return -10;
		
		for(int i=0;i<n*n;i=i+n)
		{
			if((buttons[i].getText()=="X") && (buttons[i+1].getText()=="X") &&(buttons[i+2].getText()=="X")) return 10;
		}
		for(int i=0;i+n+n<n*n;i++)
		{
			if((buttons[i].getText()=="X") && (buttons[i+n].getText()=="X") &&(buttons[i+n+n].getText()=="X")) return 10;
		}
		if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") &&(buttons[8].getText()=="X")) return 10;
		if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") &&(buttons[6].getText()=="X")) return 10;

		return 0;
	}
	
	int minimax(int d, Boolean isMax)
	{
		int score = checkifwin();
		if(score==10)
			return score;
		if (score== -10)
			return score;
		if (isEmpty()==false)
			return 0;
		
		if (isMax)
		{
			int best = -1000;
			for(int i=0;i<9;i++)
			{
				if(buttons[i].getText()=="")
				{
					buttons[i].setText("X");
					best= Math.min(best, minimax(d+1, !isMax));
					buttons[i].setText("");
				}
			}
			return best;
		}else
		{
			int best=1000;
			
			for(int i=0;i<9;i++)
			{
				if(buttons[i].getText()=="")
				{
					buttons[i].setText("O");
					best= Math.min(best, minimax(d+1, !isMax));
					buttons[i].setText("");
				}
			}
			return best;
			}
		}
		
		public int BestMove()

		{
			int bestVal=-1000;
			int movement = 10;
			for(int i=0;i<9;i++)
			{
				if(buttons[i].getText()=="")
				{
					buttons[i].setText("X");
					int moveVal = minimax(0,false);
					buttons[i].setText("");
					if(moveVal>bestVal)
					{
						movement = i;
						bestVal= moveVal;
					}
				}
			}
			return movement;
		}
		
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<n*n;i++)
			{
				if(e.getSource()==buttons[i])
				
				{
				firstTurn1();
				if(movecalc<9)
				{
					if(player1turn)
					{
						if(buttons[i].getText()=="") {
							buttons[i].setForeground(new Color(255,0,0));
							buttons[i].setText("X");
							check3x();
;							player1turn=false;
							
							
						}
					}
					
					if(buttons[BestMove()].getText()=="") {
						buttons[BestMove()].setForeground(new Color(0,0,255));
						buttons[BestMove()].setText("O");
						check3();
						player1turn=true;
						
				}
			}
				}
			
			if(e.getSource()==reset)
			{
				
				game=new TicTacToe();
			}
			
		}
		
	}
}
