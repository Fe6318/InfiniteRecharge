/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class SpinWheel extends CommandBase {
  /**
   * Creates a new SpinWheel.
   */
  private String colorInput;
  public SpinWheel(String colorInput) {
    addRequirements(Robot.spinner);
    this.colorInput = colorInput;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.spinner.spinnerMotor.set(0.6);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.spinner.spinnerMotor.set(0);
  }

  public boolean colorRangeCheck(String colorName)
  { 
    double redIn = 0;
    double blueIn = 0;
    double greenIn = 0;
    
    System.out.println(colorName);
    if(colorName.equals("RED"))
    {
      redIn = Constants.RR;
      blueIn = Constants.RB;
      greenIn = Constants.RG;
    }
    if(colorName.equals("BLUE"))
    {
       redIn = Constants.BR;
       blueIn = Constants.BB;
       greenIn = Constants.BG;
    }
    if(colorName.equals("GREEN"))
    {
       redIn = Constants.GR;
       blueIn = Constants.GB;
       greenIn = Constants.GG;
    }
    if(colorName.equals("YELLOW"))
    {
      redIn = Constants.YR;
      blueIn = Constants.YB;
      greenIn = Constants.YG;
    }

   double redSense = Robot.spinner.colorSensor.getRed();
   double blueSense = Robot.spinner.colorSensor.getBlue();
   double greenSense = Robot.spinner.colorSensor.getGreen();

   System.out.println("Red Sense: " + redSense + "Green Sense: " + greenSense + "Blue Sense:" + blueSense);
   System.out.printf("Red In: %6.1f Blue In: %6.1f Green In: %6.1f ", redIn, blueIn, greenIn);
   
   if(redSense > redIn - Constants.RANGE && redSense < redIn + Constants.RANGE
   && blueSense > blueIn - Constants.RANGE && blueSense < blueIn + Constants.RANGE 
   && greenSense > greenIn - Constants.RANGE  && greenSense < greenIn + Constants.RANGE)
   {
    return true;
   }
   return false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if((RobotContainer.operator.getRawAxis(3) + RobotContainer.operator.getRawAxis(2)) > 0.1)
    {
      return true;
    }
    return(colorRangeCheck(colorInput));
}
}
