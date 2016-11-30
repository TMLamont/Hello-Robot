package org.usfirst.frc.team4662.robot.subsystems;

import org.usfirst.frc.team4662.robot.OI;
import org.usfirst.frc.team4662.robot.RobotMap;
import org.usfirst.frc.team4662.robot.commands.JoystickMove;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

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
    }


  public void stopArm() {
     	
  	moveArm(0);
  } 
    
    
}

