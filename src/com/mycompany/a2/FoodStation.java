package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

import java.util.Random;

public class FoodStation extends Fixed
{	
	private int capacity;

	/**
	 * Class constructor.
	 * 
	 * Randomly assigns size, location
	 */
	public FoodStation(GameWorld gw)
	{
		// Instantiate variables
		super(10 + new Random().nextInt(40),							   // size:	 10-50
			  new Point((int)(gw.getWidth()  * new Random().nextFloat()),  // x-coord:	 0-maxWidth
						(int)(gw.getHeight() * new Random().nextFloat())), // y-coord:	 0-maxHeight
			  ColorUtil.rgb(0, 128, 0));								   // color:	 green  
		this.capacity = getSize();										   // capacity: 1:1 ratio to size
	}

	// capacity methods
	public int getCapacity()
	{
		return capacity;
	}
	public void setCapacity(int f)
	{
		this.capacity = f;
	}
	
	@Override
	public String toString()
	{
		String s = "FoodStation: loc=" + Math.round(getLocation().getX()*10.0)/10.0 + ","
				   					   + Math.round(getLocation().getY()*10.0)/10.0 +
				   " color=[" 		   + ColorUtil.red(getColor())+ ","
	 			    				   + ColorUtil.green(getColor())+ ","
	 			    				   + ColorUtil.blue(getColor()) + "]" +
				   " size=" 		   + getSize() +
				   " capacity=" 	   + capacity + "\n";
		return s ;
	}
}
