package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideWithSpiderCommand extends Command
{
	private GameWorld myGW;
	
	public CollideWithSpiderCommand(GameWorld gw)
	{
		/**
		 * Class constructor.
		 * 
		 * @param command String
		 */
		super("Collide with Spider");
		this.myGW = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		myGW.hitSpider();
	}
}
