package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

import java.util.Random;

public class Spider extends Movable
{	
	/**
	 * Class constructor.
	 * 
	 * Randomly assigns size, location, heading, and speed
	 */
	public Spider(GameWorld gw)
	{
		super(new Random().nextInt(40) + 10, 					 			 // size:	 10-50
			  new Point((int)(gw.getWidth() * new Random().nextFloat()),	 // x-coord: 0-1000
						(int)(gw.getHeight() * new Random().nextFloat())),   // y-coord: 0-1000
			  ColorUtil.BLACK,									 			 // color:	 black
			  new Random().nextInt(359),						 			 // heading: 0-359
			  new Random().nextInt(5) + 5);						 			 // speed:	 5-10
	}

	// move methods
	@Override
	public void move(GameWorld gw)
	{
		super.move(gw);
		
		if (getLocation().getX() == 0 || getLocation().getX() == gw.getWidth() ||
			getLocation().getY() == 0 || getLocation().getY() == gw.getHeight())
		{
			// Spider collided with wall, set new random heading
			setHeading(new Random().nextInt(359));
		}
	}

	// heading methods
	public void updateHeading()
	{
		// Update heading by adding or subtracting up to 5 degrees
		setHeading(getHeading() + new Random().nextInt(10) - 5);
	}
	
	// color methods
	@Override
	public void setColor(int c)
	{
		// Spiders are not allowed to change color once they are created
	}
	
	@Override
	public String toString()
	{
		String s = "Spider: loc=" + Math.round(getLocation().getX()*10.0)/10.0 + ","
				   				  + Math.round(getLocation().getY()*10.0)/10.0 +
				   " color=["     + ColorUtil.red(getColor()) + ","
				 			      + ColorUtil.green(getColor()) + ","
				 			      + ColorUtil.blue(getColor()) + "]" +
	 			   " heading="    + getHeading() +
	 			   " speed="      + getSpeed() +
				   " size="       + getSize() + "\n";
		return s;
	}
}
