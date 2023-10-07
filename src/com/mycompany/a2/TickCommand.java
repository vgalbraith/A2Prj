package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TickCommand extends Command
{
	private GameWorld myGW;
	
	public TickCommand(GameWorld gw)
	{
		/**
		 * Class constructor.
		 * 
		 * @param command String
		 */
		super("Tick");
		this.myGW = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		myGW.clockTick();
	}
}
