package com.mycompany.a2;

import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;

public class Game extends Form
{
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;

	/**
	 * Class constructor.
	 */
	public Game()
	{
		gw = new GameWorld();
		mv = new MapView();
		sv = new ScoreView();
		gw.addObserver(mv);
		gw.addObserver(sv);
		
		// Set layout of the Form
		this.setLayout(new BorderLayout());
		
		// Create a single instance of each command object
		Command myAccelerateCommand = new AccelerateCommand(gw);
		Command myBrakeCommand = new BrakeCommand(gw);
		Command myLeftTurnCommand = new LeftTurnCommand(gw);
		Command myRightTurnCommand = new RightTurnCommand(gw);
		Command myCollideWithFlagCommand = new CollideWithFlagCommand(gw);
		Command myCollideWithFoodStationCommand = new CollideWithFoodStationCommand(gw);
		Command myCollideWithSpiderCommand = new CollideWithSpiderCommand(gw);
		Command myTickCommand = new TickCommand(gw);
		Command myExitCommand = new ExitCommand();
		Command mySoundCommand = new SoundCommand(gw);
		Command myAboutCommand = new AboutCommand();
		Command myHelpCommand = new HelpCommand();
		
		// Create Toolbar
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		myToolbar.setTitle("FlagByFlag Game");
		
		// Create CheckBox for sound
		CheckBox soundCheckBox = new CheckBox("Sound");
		soundCheckBox.getAllStyles().setBgTransparency(255);
		soundCheckBox.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundCheckBox.setCommand(mySoundCommand);
		
		// Add commands to side menu and title bar
		myToolbar.addCommandToSideMenu(myAccelerateCommand);
		myToolbar.addComponentToSideMenu(soundCheckBox);
		myToolbar.addCommandToSideMenu(myAboutCommand);
		myToolbar.addCommandToSideMenu(myExitCommand);
		myToolbar.addCommandToRightBar(myHelpCommand);
		
		// Bind commands to keys
		addKeyListener('a', myAccelerateCommand);
		addKeyListener('b', myBrakeCommand);
		addKeyListener('l', myLeftTurnCommand);
		addKeyListener('r', myRightTurnCommand);
		addKeyListener('f', myCollideWithFoodStationCommand);
		addKeyListener('g', myCollideWithSpiderCommand);
		addKeyListener('t', myTickCommand);
		
		// Create control containers
		Container westContainer = new Container();
		Container eastContainer = new Container();
		Container southContainer = new Container();

		// Create buttons
		Button accelerateButton = new CustomButton();
		Button brakeButton = new CustomButton();
		Button leftTurnButton = new CustomButton();
		Button rightTurnButton = new CustomButton();
		Button collideWithFlagButton = new CustomButton();
		Button collideWithFoodStationButton = new CustomButton();
		Button collideWithSpiderButton = new CustomButton();
		Button tickButton = new CustomButton();
		
		// Add buttons to the control containers
		westContainer.add(accelerateButton);
		westContainer.add(leftTurnButton);
		eastContainer.add(brakeButton);
		eastContainer.add(rightTurnButton);
		southContainer.add(collideWithFlagButton);
		southContainer.add(collideWithSpiderButton);
		southContainer.add(collideWithFoodStationButton);
		southContainer.add(tickButton);
		
		// Add commands to the buttons
		accelerateButton.setCommand(myAccelerateCommand);
		brakeButton.setCommand(myBrakeCommand);
		leftTurnButton.setCommand(myLeftTurnCommand);
		rightTurnButton.setCommand(myRightTurnCommand);
		collideWithFlagButton.setCommand(myCollideWithFlagCommand);
		collideWithFoodStationButton.setCommand(myCollideWithFoodStationCommand);
		collideWithSpiderButton.setCommand(myCollideWithSpiderCommand);
		tickButton.setCommand(myTickCommand);
		
		// Add control containers to the Form
		this.add(BorderLayout.WEST, westContainer);
		this.add(BorderLayout.EAST, eastContainer);
		this.add(BorderLayout.SOUTH, southContainer);
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		
		// Set layout of containers
		westContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		eastContainer.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		southContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
		
		// Set padding of the containers
		westContainer.getAllStyles().setPadding(100, 0, 0, 0);
		eastContainer.getAllStyles().setPadding(100, 0, 0, 0);
		southContainer.getAllStyles().setPadding(0, 0, 450, 0);
		
		this.show();
		// code to query MapView's width and height and set them to the gw
		gw.setWidth(mv.getWidth());
		gw.setHeight(mv.getHeight());
		
		// Initialize world
		gw.init();
	}
}
