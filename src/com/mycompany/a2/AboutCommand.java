package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class AboutCommand extends Command
{
	public AboutCommand()
	{
		/**
		 * Class constructor.
		 * 
		 * @param command String
		 */
		super("About");
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		Dialog.show("About", "Victor Galbraith - CSC-133", "OK", null);
	}
}
