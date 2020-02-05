/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Lift;

public class MoveLift extends CommandBase {
  /**
   * Creates a new Lift.
   */
  public MoveLift() {
    addRequirements(Robot.lift);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Lift.liftMotorLeft.set(RobotContainer.operator.getRawAxis(3));
    Lift.liftMotorRight.set(RobotContainer.operator.getRawAxis(3));
    Lift.liftMotorLeft.set(-RobotContainer.operator.getRawAxis(2));
    Lift.liftMotorRight.set(-RobotContainer.operator.getRawAxis(2));
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
