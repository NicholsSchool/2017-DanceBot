package org.usfirst.frc0.DanceBot1.commands;

import org.usfirst.frc0.DanceBot1.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CycleAutoFileUp extends Command
{
    protected void initialize() 
    {
    	Robot.autoNum += 1;
    }

    protected void execute()
    {
    	
    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() 
    {
    	
    }

    protected void interrupted() 
    {
    	end();
    }
}