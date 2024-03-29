import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.applet.*;
import java.awt.*;

//<applet code = "ex" width="1000" height="1000"> </applet>
public class Bouncing_Ball extends Applet{
void ball(int xmax,int ymax,int r,int x,int y,Graphics g)
{
g.setColor(Color.CYAN);
g.fillRect(0,0,xmax,ymax);
g.setColor(Color.GRAY);
g.fillRect(0,(ymax-50),xmax,50);  
g.setColor(Color.RED);
g.fillOval(x,y,r,r);
}

void dda(int x0,int y0,int x1, int y1, int r, Graphics g)
{
int dx = x1 - x0; 
int dy = y1 - y0; 
int step; 
int xmax = getSize().width;
int ymax = getSize().height;
if (dx > dy) 
step = Math.abs(dx); 
else
step = Math.abs(dy); 
float x_incr = (float) dx / step; 
float y_incr = (float) dy / step; 
int x = x0; 
int y = y0; 
try
{
for (int i = 0; i < step; i++) 
{ 
x += Math.round(x_incr);  
y += Math.round(y_incr); 
TimeUnit.MILLISECONDS.sleep(3);
ball(xmax,ymax,r,x,y,g);
}
}//try
catch(InterruptedException a)
{
}
}//dda

public void paint(Graphics g){
int xmax = getSize().width;
int ymax = getSize().height;
int r = 200;
dda(((xmax-r)/2),0,((xmax-r)/2),(ymax-r-50),r,g);
dda(((xmax-r)/2),(ymax-r-50),0,((ymax-r-50)/2),r,g);
dda(0,((ymax-r-50)/2),((xmax-r)/2),0,r,g);
dda(((xmax-r)/2),0,xmax-r-20,((ymax-r)/2),r,g);
dda(xmax-r-20,((ymax-r)/2),((xmax-r)/2),(ymax-r-50),r,g);
}//function
}//class