package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;

public class MapView extends Container implements Observer
{
	/**
	 * Class constructor.
	 */
	public MapView()
	{
		// empty container
		// use setBorder() method of Style class to give it a red border
		getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.rgb(255, 0, 0)));
	}
	
	@Override
	public void update(Observable o, Object data)
	{
		// code here to call the method in GameWorld (Observable) that output the
		// game object information to the console
		((GameWorld)o).map();
	}
}
