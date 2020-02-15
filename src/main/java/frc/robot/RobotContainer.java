/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.SpinWheel;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  
  public static Joystick driver;
  public static Joystick operator;
  
  private JoystickButton redButton;
  private JoystickButton blueButton;
  private JoystickButton yellowButton;
  private JoystickButton greenButton;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    driver = new Joystick(0);
    operator = new Joystick(1);

    redButton = new JoystickButton(operator, Constants.RED_BUTTON);
    blueButton = new JoystickButton(operator, Constants.BLUE_BUTTON);
    greenButton = new JoystickButton(operator, Constants.GREEN_BUTTON);
    yellowButton = new JoystickButton(operator, Constants.YELLOW_BUTTON);

    redButton.whenPressed(new SpinWheel(Constants.RED), true);
    blueButton.whenPressed(new SpinWheel(Constants.BLUE), true);
    greenButton.whenPressed(new SpinWheel(Constants.GREEN), true);
    yellowButton.whenPressed(new SpinWheel(Constants.YELLOW), true);
  }

 
  public static double deadZone(double input)
  {
    if(Math.abs(input) < 0.1)
    {
      return 0;
    }
    return input;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
