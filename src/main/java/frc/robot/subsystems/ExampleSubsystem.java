/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class ExampleSubsystem extends SubsystemBase {
  private WPI_TalonSRX frontLeft;
  private WPI_TalonSRX backLeft;
  private WPI_TalonSRX frontRight;
  private WPI_TalonSRX backRight;
  private SpeedControllerGroup left;
  private SpeedControllerGroup right;
  private DifferentialDrive driveBase;
  private XboxController joy;

  /**
   * Creates a new ExampleSubsystem.
   */
  public ExampleSubsystem() {
    frontLeft = new WPI_TalonSRX(45);
    backLeft = new WPI_TalonSRX(51);
    frontRight = new WPI_TalonSRX(50);
    backRight = new WPI_TalonSRX(46);
    left = new SpeedControllerGroup(frontLeft, backLeft);
    right = new SpeedControllerGroup(frontRight, backRight);
    driveBase = new DifferentialDrive(left, right);
    joy = new XboxController(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double x = joy.getRawAxis(0);
    double y = joy.getRawAxis(1);

    driveBase.arcadeDrive(y * 0.5, x * 0.5);
  }
}
