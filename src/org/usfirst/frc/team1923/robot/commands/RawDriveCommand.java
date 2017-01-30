package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command directly feeds the raw values on the joysticks to the motor
 * without PID
 */
public class RawDriveCommand extends Command {

	public RawDriveCommand() {
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.drive.disablePID();// Disables the PID system to gain full control
									// without correction
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.drive.set(Robot.oi.driver.getLeftY(), Robot.oi.driver.getRightY());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.set(0, 0); // Stops the robot
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}