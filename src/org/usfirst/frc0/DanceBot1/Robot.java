package org.usfirst.frc0.DanceBot1;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc0.DanceBot1.commands.*;
import org.usfirst.frc0.DanceBot1.subsystems.*;

public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    public static DriveTrain driveTrain;
    public static LightRotater lightRotater;
    public static AutoSwitch AutoSwitch;
    public static TeleopRecorder teleopRecorder;
    
    public static boolean isRecording;

    public void robotInit()
    {
    	RobotMap.init();
        driveTrain = new DriveTrain();
        lightRotater = new LightRotater();

        AutoSwitch = new AutoSwitch();
        
        teleopRecorder = new TeleopRecorder();
        isRecording = false;
        
        oi = new OI();

        autonomousCommand = new AutonomousCommand();
    }

    public void disabledInit()
    {

    }

    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() 
    {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
        
       // SmartDashboard.putNumber("TestPot Value", RobotMap.testPot.get());
        SmartDashboard.putNumber("Current Dial", Robot.AutoSwitch.getDial());
        SmartDashboard.putBoolean("isRecording", isRecording);
        SmartDashboard.putBoolean("isPlaying", Robot.teleopRecorder.isPlaying());
    }

    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
