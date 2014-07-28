import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.applet.Applet;


public class ExampleEventHandling extends Applet implements MouseListener {

    private StringBuffer strBuffer;
    
    public void init(){
	addMouseListener(this);
	strBuffer = new StringBuffer();
	addItem("initializing the applet");
    }

    public void start(){
	addItem("starting the applet");
    }
    
    public void stop(){
	addItem("Stopping the applet");
    }
    
    public void destroy(){
	addItem("Unloading the applet");
    }

    private void addItem(String word){
	System.out.println(word);
	if(strBuffer.length() > 100){
	    strBuffer.delete(0,50);
	}
	strBuffer.append(word+", ");
	repaint();
    }

    public void paint(Graphics g){
	g.drawRect(0,0,getWidth()-1,getHeight()-1);
	g.drawString(strBuffer.toString(),10,20);
    }

    public void mouseEntered(MouseEvent event){
	addItem("Mouse entered");
    }

    public void mouseExited(MouseEvent event){
	addItem("Mouse exited");
    }

    public void mousePressed(MouseEvent event){
	addItem("Mouse pressed");
    }
    
    public void mouseReleased(MouseEvent event){
	addItem("Mouse released");
    }

    public void mouseClicked(MouseEvent event){
	addItem("Mouse clicked");
    }

}
	    
