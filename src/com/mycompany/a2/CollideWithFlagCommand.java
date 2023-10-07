package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CollideWithFlagCommand extends Command
{
	private GameWorld myGW;
	
	public CollideWithFlagCommand(GameWorld gw)
	{
		/**
		 * Class constructor.
		 * 
		 * @param command String
		 */
		super("Collide with Flag");
		this.myGW = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		myGW.hitFlag();
	}
}
