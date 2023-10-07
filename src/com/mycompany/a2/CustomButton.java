package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.plaf.Border;

public class CustomButton extends Button
{
	public CustomButton()
	{
		this.getUnselectedStyle().setBgTransparency(255);
		this.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		this.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		this.getAllStyles().setPadding(5, 5, 3, 3);
		this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
	}
}
