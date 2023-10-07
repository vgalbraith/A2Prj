package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class BrakeCommand extends Command
{
	private GameWorld myGW;
	
	public BrakeCommand(GameWorld gw)
	{
		/**
		 * Class constructor.
		 * 
		 * @param command String
		 */
		super("Brake");
		this.myGW = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		myGW.brake();
	}
}
