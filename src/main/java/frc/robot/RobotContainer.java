// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DecelerateDriveCommand;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {

  private DriveSubsystem m_drive = new DriveSubsystem();
  private Command m_drivecommand = new DefaultDriveCommand(m_drive);
  
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    m_drive = new DriveSubsystem();
    m_drivecommand = new DefaultDriveCommand(m_drive);
    CommandScheduler.getInstance().setDefaultCommand(m_drive, m_drivecommand);
    
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.leftBumper().whileTrue(new DecelerateDriveCommand(m_drive));
  }

  public DriveSubsystem VroomVroom(){
    return m_drive;
  }

   /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_drive);
  }
  
}

