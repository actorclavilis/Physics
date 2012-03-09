import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.event.ChangeListener; 

public class GUI extends JPanel implements ChangeListener
{
    Dimension d;
    int width, height, freq, amp;
    JButton sine;
    JLabel imageL;
    JSlider freqS, ampS;
    BufferedImage image;
    Graphics myG;
    
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
        	
		freqS = new JSlider(JSlider.VERTICAL, 1, 10000, 500);
		freqS.setBounds((int)(width*0.1), (int)(height*0.1), 30, 200);       
		freqS.addChangeListener(this);
		
		ampS = new JSlider(JSlider.VERTICAL, 1, 100, 50);
		ampS.setBounds((int)(width*0.15), (int)(height*0.1), 30, 200);       
       	ampS.addChangeListener(this);
   
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        imageL = new JLabel(new ImageIcon(image));
        imageL.setBounds(0,0,width,height);
               
        myG = image.getGraphics();
        myG.setColor(Color.WHITE);
        
        this.add(freqS); 
        this.add(ampS);
        this.add(imageL);
        
        freq = freqS.getValue();
    	amp = ampS.getValue();
		drawSine((int)(width*0.4), (int)(height*0.5), freq, amp);
    } 
    
    public void resetScreen()
    {	 	
    	myG.setColor(Color.BLACK);
    	myG.fillRect(0,0,width,height);
    	myG.setColor(Color.WHITE);
    	
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);         
    }    
    
    public void stateChanged(javax.swing.event.ChangeEvent e)
    {
    	repaint();
    	resetScreen();
    	
    	if(e.getSource() == freqS)
    	{
			freq = freqS.getValue();
		}
		if(e.getSource() == ampS)
		{
			amp = ampS.getValue();
		}	
		
		drawSine((int)(width*0.4), (int)(height*0.5), freq, amp);
    } 
        
    public void drawSine(float x, float y, float freq, float amp)
    {	 	
    	int scopeWidth = 400;
    	int scopeHeight = 100;
    	
    	myG.drawLine((int)x, (int)y, (int)(x+scopeWidth), (int)y);
    	myG.drawLine((int)x, (int)(y-scopeHeight), (int)x, (int)y+scopeHeight);
    	
    	int offset = 0;
    	float ySine1 = y;
    	float ySine2 = y;
    	float xSine1 = x;
    	float xSine2 = x;
    	
    	for(int i = 0; i < (scopeWidth*100); i++)
    	{
    		ySine1 = (float)(amp*Math.sin(freq*((float)(i/100)) + offset)) + y;
    		xSine1 = x+(i/100);
    		
    		myG.drawLine((int)xSine1, (int)ySine1, (int)xSine2, (int)ySine2);
    		
    		ySine2 = ySine1;
    		xSine2 = xSine1;
    	}
    }
}