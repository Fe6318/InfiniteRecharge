/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveForwards extends CommandBase {
  public double ticksForward;
  /**
   * Creates a new DriveForwards.
   */
  public DriveForwards(double ticksForward) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(DriveTrain.getTrain());
    this.ticksForward = ticksForward;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriveTrain.leftPID.reset();
    DriveTrain.rightPID.reset();

    DriveTrain.rightPID.setTarget(ticksForward + DriveTrain.rightEncoderPIDSource.PIDGet());
    DriveTrain.leftPID.setTarget(ticksForward + DriveTrain.leftEncoderPIDSource.PIDGet());

    DriveTrain.rightPID.setTolerance(Constants.DRIVE_PID_TOLERANCE); 
    DriveTrain.leftPID.setTolerance(Constants.DRIVE_PID_TOLERANCE);

    DriveTrain.rightPID.enable();
    DriveTrain.leftPID.enable();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveTrain.leftPID.disable();
    DriveTrain.rightPID.disable();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return DriveTrain.rightPID.isOnTarget() 
    && DriveTrain.leftPID.isOnTarget() 
    && DriveTrain.leftPID.getDerivative() < Constants.MIN_FORWARD_DERIVATIVE 
    && DriveTrain.rightPID.getDerivative() < Constants.MIN_FORWARD_DERIVATIVE;
  }
}
