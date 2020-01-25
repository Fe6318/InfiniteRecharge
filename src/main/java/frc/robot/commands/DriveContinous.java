/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class DriveContinous extends CommandBase {
  /**
   * Creates a new DriveContinous.
   */
  public DriveContinous() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    /*double speedX = RobotContainer.deadZone(RobotContainer.driver.getRawAxis(0));

    if(speedX < 0)
    {
      speedX = -1 * Math.pow(2, speedX);
    }
    else{
      speedX = Math.pow(2, speedX);
    }   
    */
    DriveTrain.driveTrain.arcadeDrive(
      squareJoystick(RobotContainer.driver.getRawAxis(1)), 
      squareJoystick(RobotContainer.driver.getRawAxis(2)) + squareJoystick(RobotContainer.driver.getRawAxis(0)));
    

  }

  private double squareJoystick(double input)
  {
    double output = input;
    
    if(Math.abs(output) < 0.05)
    {
      output = 0;
    }

    if(output > 0)
    {
      return Math.pow(output, 2.0);

    }
    else{
      return -Math.pow(output, 2.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
