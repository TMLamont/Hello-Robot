package org.usfirst.frc.team4662.robot.subsystems;

import org.usfirst.frc.team4662.robot.OI;
import org.usfirst.frc.team4662.robot.RobotMap;
import org.usfirst.frc.team4662.robot.commands.JoystickMove;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RobotDrive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private final SpeedController MOTOR1 = new Talon(RobotMap.MOTOR1);
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickMove());
    }
    
  public void moveArm(double speed) {
    	
    	
    	MOTOR1.set(speed);
//    	logArm();
    	Dashboard(speed);
    }
  
  public void stopArm(){
	  moveArm(0);
	  
  }
  
  

  private final DigitalInput homeLocSw = new DigitalInput(RobotMap.iArmHomeLocSw);
  private final DigitalInput scoopLimSw = new DigitalInput(RobotMap.iArmBotLimSw);
  private final DigitalInput topLimSw = new DigitalInput(RobotMap.iArmTopLimSw);
  
  
  
  
  public boolean isTop() {
  	return !topLimSw.get();
  }
  
  public boolean isBottom() {
  	return !scoopLimSw.get();
  }
  
 public boolean isHome() {
  	return !homeLocSw.get();
  }
 
  public void Dashboard(double speed){
    SmartDashboard.putBoolean("Home Switch", isHome());
	SmartDashboard.putBoolean("Top Lim Switch", isTop());
	SmartDashboard.putBoolean("Bot Lim Switch", isBottom());
	SmartDashboard.putNumber("Motor Value", speed);
  	}
  
  
  
}

