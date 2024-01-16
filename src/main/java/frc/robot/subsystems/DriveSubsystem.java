// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Input;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class DriveSubsystem extends SubsystemBase {
  public DriveSubsystem() {

    // Declare Motor CAN IDs 
    WPI_TalonSRX _leftMotor1 = new WPI_TalonSRX(Constants.LEFT_MOTOR_1, "rio");
    WPI_VictorSPX _leftMotor2 = new WPI_VictorSPX(Constants.LEFT_MOTOR_2, "rio");
    WPI_TalonSRX _rightMotor1 = new WPI_TalonSRX(Constants.RIGHT_MOTOR_1, "rio");
    WPI_TalonSRX _rightMotor2 = new WPI_TalonSRX(Constants.RIGHT_MOTOR_2, "rio");

    // Slave and Master
    _leftMotor1.follow(_leftMotor2);
    _rightMotor1.follow(_rightMotor2);

    /*
    /
    / ** UNTESTED **
    / Set joystick output, there is probably a better way to implement this
    / by setting a left/right SpeedControllerGroup and passing it into the DifferentialDrive class.
    /
    */
    _leftMotor2.set(ControlMode.PercentOutput, Input.getVertical());
    _rightMotor2.set(ControlMode.PercentOutput, Input.getVertical());
    _leftMotor2.set(ControlMode.PercentOutput, Input.getHorizontal());
    _rightMotor2.set(ControlMode.PercentOutput, Input.getHorizontal());

  }


  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }


  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
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
