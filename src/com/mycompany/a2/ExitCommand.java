package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

public class ExitCommand extends Command
{
	public ExitCommand()
	{
		/**
		 * Class constructor.
		 * 
		 * @param command String
		 */
		super("Exit");
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		boolean b = Dialog.show("Exit?", null, "YES", "NO");
		if (b) System.exit(0);
	}
}
