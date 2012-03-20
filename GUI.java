import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.event.ChangeListener; 

public class GUI extends JPanel implements Runnable
{
    private Dimension d;
    private JPanel inputPanel;
    private int width, height;
    
    private Thread animator;
    private final int DELAY = 2;
    
    private int x = 0, y = 0, speedX = 1, speedY = 1;
    
    public GUI(Dimension a) throws Exception
	{
    	d = a;
    	this.setLayout(null);
        this.setBounds(0, 0, d.width, d.height); 
        this.setBackground(Color.BLACK);  
        this.setVisible(true);
        this.setFocusable(true);
            
        width = this.getWidth();
        height = this.getHeight();
        
		inputPanel = new JPanel();
		inputPanel.setBackground(Color.DARK_GRAY);
		inputPanel.setLayout(null);
		inputPanel.setVisible(true);
		inputPanel.setBounds((int)(width*0.85),0,(int)(width*0.15),height);

		this.add(inputPanel);
    } 
    
    public void addNotify()
    {
    	super.addNotify();
    	animator = new Thread(this);
    	animator.start();
    }
    
    public void cycle() 
    {
        x += speedX;
        y += speedY;

        if((x > (width*0.85))||(x < 0)) 
        {
            speedX *= -1;
        }
        if((y > height)||(y < 0)) 
        {
            speedY *= -1;
        }
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.fillOval(x,y,10,10);    
    } 
    
    public void run() 
    {
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) 
        {
            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if(sleep < 0)
            {
                sleep = 2;
            }
            
            try 
            {
                Thread.sleep(sleep);
            }catch(InterruptedException e) 
            {
            }

            beforeTime = System.currentTimeMillis();
        }
    }   
}