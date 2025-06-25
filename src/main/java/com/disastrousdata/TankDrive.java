/*
TankDrive.java
Written by CoPokBl

This is a wrapper class for dealing with hardware.
It is a more abstract way of dealing with hardware, and it makes code easier to read.
It also allows for adding checks to hardware such as not letting an arm go too far.
Add more hardware to this class as needed.
*/

package com.disastrousdata;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

// Main class for controlling the robot, all robot functions should use this.
public class TankDrive {
    // Drive system - don't change
    private MotorController[] LeftMotors;
    private MotorController[] RightMotors;

    // Reuse for 2025 MRT changes
    public MotorController Arm;

    //public Joystick Controller;
    public XboxController Controller;

    public Hardware Hardware;

    // Hardware should be initialized before this is called. This is called in Hardware.java.
    public void Init(Hardware hardware) {
        Hardware = hardware;
        LeftMotors = new MotorController[] {
            hardware.LeftMotor1,
            hardware.LeftMotor2
        };
        RightMotors = new MotorController[] {
            hardware.RightMotor1,
            hardware.RightMotor2
        };
        
        // Reuse these for Coral and Algae
        // Arm for Algae
        Arm = hardware.ArmMotor;

        // not using pneumatics
        Controller = hardware.Controller;
    }

    public void Update(HardwareStates states) {
        // Drive
        SetLeftDrive(states.LeftDriveMotors);
        SetRightDrive(states.RightDriveMotors);
    }

    public void SetLeftDrive(double s) {
        for (MotorController c : LeftMotors) {
            c.set(s);
        }
    }

    public void SetRightDrive(double s) {
        for (MotorController c : RightMotors) {
            c.set(s);
        }
    }

    public enum IntakeMode {
        OFF,
        INTAKE,
        CHARGE,
        SHOOT
    }

    // reuse for algae intake. SHould not need to be changed
    public void setArmPower(double s) {
        Arm.set(s);
    }

    @SuppressWarnings("unused")  // May be used in future
    public void Stop() {
        Hardware.Reset();
    }
    
}
