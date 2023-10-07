package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AccelerateCommand extends Command
{
	private GameWorld myGW;
	
	public AccelerateCommand(GameWorld gw)
	{
		/**
		 * Class constructor.
		 * 
		 * @param command String
		 */
		super("Accelerate");
		this.myGW = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		myGW.accelerate();
	}
}
