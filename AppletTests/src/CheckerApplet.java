import java.applet.*;
import java.awt.*;

public class CheckerApplet extends Applet {

    int w = 50; //default width
    int h = 50; //default height
    Color col = Color.white; //default second color
    int nx = 5; //default nx
    int ny = 5; //default ny
    
    public void init(){
	String width = getParameter("checkerWidth");
	String height = getParameter("checkerHeight");
	String color = getParameter("color");
	String snx = getParameter("nx");
	String sny = getParameter("ny");
	
	parseWidth(width);
	parseHeight(height);
	parseColor(color);
	parseNx(snx);
	parseNy(sny);

    }

    public void paint(Graphics g){
	
	for(int i = 0; i < nx; i++){
	    for(int j = 0; j < ny; j++){
		if( (i+j) % 2 == 0){
		    g.setColor(col);
		}
		else {
		    g.setColor(Color.black);
		}
		
		g.fillRect(i*w,j*h,w,h);
	    }
	}
    }


    private void parseWidth(String width){
	if (width == null){
	    return;
	}
	else {
	    try{
		w = Integer.parseInt(width);
	    }
	    catch (Exception e){
	    }
	}
    }

    private void parseHeight(String height){
	if(height == null){
	    return;
	}
	else {
	    try{
		h = Integer.parseInt(height);
	    }
	    catch (Exception e){
	    }
	}
    }

    private void parseColor(String color){
	if(color == null){
	    //col = Color.yellow;
	    return;
	}
	else { 
	    try {
		if("red".equals(color)){
		    col = Color.red;
		}
		else if("green".equals(color)){
		    col = Color.green;
		}
		else if("blue".equals(color)){
		    col = Color.blue;
		}
		else if("white".equals(color)){
		    col = Color.white;
		}
	    }
	    catch (Exception e){
	    }
	}
    }

    void parseNx(String snx){
	if(snx == null){
	    return;
	}
	else {
	    try {
		nx = Integer.parseInt(snx);
	    }
	    catch (Exception e){
	    }
	}
    }

    void parseNy(String sny){
	if (sny == null){
	    return;
	}
	else {
	    try {
		ny = Integer.parseInt(sny);
	    }
	    catch (Exception e){
	    }
	}
    }
    

		
}
	
    
