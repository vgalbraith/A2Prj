package com.mycompany.a2;

import com.codename1.charts.models.Point;

public abstract class Movable extends GameObject
{
	private int heading;
	private int speed;

	/**
	 * Class constructor.
	 * 
	 * @param sz  size
	 * @param loc location
	 * @param c	  color
	 * @param h	  heading
	 * @param sp  speed
	 */
	public Movable(int sz, Point loc, int c, int h, int sp)
	{
		super(sz, loc, c);
		this.heading = h;
		this.speed = sp;
	}

	public void move(GameWorld gw)
	{
		// Update location based on current heading and speed
		this.setLocation(new Point(
				getLocation().getX() + (float)Math.cos(Math.toRadians(90 - heading)) * speed,
				getLocation().getY() + (float)Math.sin(Math.toRadians(90 - heading)) * speed));
		
		// Constrict Movable object to the defined game grid
		if (getLocation().getX() < 0)
		{
			setLocation(new Point(0, getLocation().getY()));
		}
		else if (getLocation().getX() > gw.getWidth())
		{
			setLocation(new Point(gw.getWidth(), getLocation().getY()));
		}
		if (getLocation().getY() < 0)
		{
			setLocation(new Point(getLocation().getX(), 0));
		}
		else if (getLocation().getY() > gw.getHeight())
		{
			setLocation(new Point(getLocation().getX(), gw.getHeight()));
		}
	}

	// heading methods
	public int getHeading()
	{
		return heading;
	}
	public void setHeading(int h)
	{
		this.heading = h;
	}

	// speed methods
	public int getSpeed()
	{
		return speed;
	}
	public void setSpeed(int sp)
	{
		this.speed = sp;
	}
}
