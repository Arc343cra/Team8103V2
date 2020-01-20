/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class RealRobot extends TimedRobot {
  
  private PWMVictorSPX rf;
  private PWMVictorSPX rb;
  private PWMVictorSPX lf;
  private PWMVictorSPX lb;
  private SpeedControllerGroup left;
  private SpeedControllerGroup right;
  private Joystick logicleft;
  private Joystick logicright;

  @Override
  public void robotInit() {
    lf = new PWMVictorSPX(0);
    lb = new PWMVictorSPX(1);
    left = new SpeedControllerGroup(lf, lb);
      rf = new PWMVictorSPX(2);
      rb = new PWMVictorSPX(3);
    right = new SpeedControllerGroup(rf, rb);
      logicleft = new Joystick(1);
      logicright= new Joystick(1);
    
  
    
  }
@Override
public void autonomousInit() {
  try {
//this section drives forward
    left.set(0.75);
    right.set(0.75);
    Thread.sleep(1000);
    left.set(0);
    right.set(0);
//this should stop here
//this section should turn left
      left.set(-0.75);
      right.set(0.75);
      Thread.sleep(1000);
      left.set(0);
      right.set(0);
//this section stop here
//this section is meant to back into the goal
        left.set(-0.75);
        right.set(-0.75);
        Thread.sleep(1000);
        left.set(0);
        right.set(0);
//this section ends the driving
  } catch (InterruptedException e) 
   {
    e.printStackTrace();
   }

  super.autonomousInit();
}
  @Override
  public void teleopPeriodic() {
    left.set(logicleft.getRawAxis(1));
    right.set(logicright.getRawAxis(5));
    
  }
}
