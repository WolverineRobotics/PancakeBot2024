// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import frc.robot.Constants;
import frc.robot.Input;

import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class DriveSubsystem extends SubsystemBase {

  public static DifferentialDrive driveTrain;

  public DriveSubsystem() {

    // Declare Motor CAN IDs 
    WPI_TalonSRX _leftFollower = new WPI_TalonSRX(Constants.LEFT_MOTOR_1);
    WPI_VictorSPX _leftMaster = new WPI_VictorSPX(Constants.LEFT_MOTOR_2);
    WPI_TalonSRX _rightFollower = new WPI_TalonSRX(Constants.RIGHT_MOTOR_1);
    WPI_TalonSRX _rightMaster = new WPI_TalonSRX(Constants.RIGHT_MOTOR_2);
    
    _leftFollower.follow(_leftMaster);
    _rightFollower.follow(_rightMaster);
    
    _leftFollower.setInverted(InvertType.FollowMaster);
    _rightFollower.setInverted(InvertType.FollowMaster);

    _leftFollower.setNeutralMode(NeutralMode.Brake);
    _leftMaster.setNeutralMode(NeutralMode.Brake);
    _rightFollower.setNeutralMode(NeutralMode.Brake);
    _rightMaster.setNeutralMode(NeutralMode.Brake);

    driveTrain = new DifferentialDrive(_leftMaster, _rightMaster);
    driveTrain.setSafetyEnabled(false);
  }
  
  // public void setDeadband(){
  //   driveTrain.setDeadband(Constants.DEADBAND_CONST);
  // }

  // Tele-Op Driving 
  public void ArcadeDrive(){
    driveTrain.arcadeDrive(Input.getHorizontal(),Input.getVertical());
  }

  // Rotate when given a speed
  public void Rotate(double speed){
    driveTrain.arcadeDrive(speed, 0);
  }

  public void AutoDrive(double speed,double rotation){
    driveTrain.arcadeDrive(rotation, speed);
  }

  // Move straight when given a speed
  public void Straight(double speed){
    driveTrain.arcadeDrive(speed, 0);
  }

  public Command exampleMethodCommand() {
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
