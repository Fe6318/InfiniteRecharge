/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.utilities.PIDOutputGroup;
import frc.robot.utilities.VictorPIDOutput;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  public static VictorSPX frontRightMotor;
  public static VictorSPX frontLeftMotor;
  public static VictorSPX backRightMotor;
  public static VictorSPX backLeftMotor;

  public static VictorPIDOutput frontLeftPIDOutput;
  public static VictorPIDOutput frontRightPIDOutput;
  public static VictorPIDOutput backRightPIDOutput;
  public static VictorPIDOutput backLeftPIDOutput;

  public static PIDOutputGroup leftMotors;
  public static PIDOutputGroup rightMotors;

  private static ArrayList<VictorPIDOutput> leftMotorsList;
  private static ArrayList<VictorPIDOutput> rightMotorsList;

  
  public DriveTrain() {
    frontLeftMotor = new VictorSPX(Constants.FRONT_LEFT_MOTOR);
    frontRightMotor = new VictorSPX(Constants.FRONT_RIGHT_MOTOR);
    backRightMotor = new VictorSPX(Constants.BACK_RIGHT_MOTOR);
    backLeftMotor = new VictorSPX(Constants.BACK_LEFT_MOTOR);

    frontLeftPIDOutput = new VictorPIDOutput(frontLeftMotor);
    frontRightPIDOutput = new VictorPIDOutput(frontRightMotor);
    backRightPIDOutput = new VictorPIDOutput(backRightMotor);
    backLeftPIDOutput = new VictorPIDOutput(backLeftMotor);

    leftMotorsList = new ArrayList<VictorPIDOutput>();
    rightMotorsList = new ArrayList<VictorPIDOutput>();

    leftMotorsList.add(frontLeftPIDOutput);
    leftMotorsList.add(backLeftPIDOutput);

    rightMotorsList.add(frontRightPIDOutput);
    rightMotorsList.add(backRightPIDOutput);
    
    leftMotors = new PIDOutputGroup(leftMotorsList);
    rightMotors = new PIDOutputGroup(rightMotorsList);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
