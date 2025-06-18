/*
Hardware.java
Written by CoPokBl

This contains all the hardware definitions for the robot.
An instance of it can be used to access all the hardware.
If any hardware is changed for added it should be added here.

Where possible you shouldn't use anything here directly, instead use
a TankDrive instance which is a safer approach and allows for
checks to be made on the values being set to the motors.
*/

package com.disastrousdata;

//import java.lang.ModuleLayer.Controller;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.revrobotics.spark.SparkBase.IdleMode;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
//import com.kauailabs.navx.frc.AHRS; 
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.studica.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class Hardware {


    // ==========================
    //         Drive Motors
    // ==========================
    public SparkMax RightMotor1;
    public SparkMax RightMotor2;

    public SparkMax LeftMotor1;
    public SparkMax LeftMotor2;

    // ==========================
    //        Other Motors
    // ==========================
    public WPI_TalonSRX TopIntakeMotor;
    public WPI_TalonSRX BottomIntakeMotor;

    public WPI_TalonSRX ClawMotor;
    public WPI_TalonSRX ArmMotor;

    // ==========================
    //         Controls
    // ==========================
    //public Joystick Controller;
    //public Joystick Slider;
    public XboxController Controller;
    public XboxController Slider; 

    // ==========================
    //         Pneumatics
    // ==========================
    public Compressor AirCompressor;
    public DoubleSolenoid Solenoid;

    // ==========================
    //           Sensors
    // ==========================
    public DigitalInput LimitSwitch;
    public AHRS NavX;

    public void Init() {  // Arm: 2,4 Intake: 5,7
        RightMotor1 = new SparkMax(1, MotorType.kBrushed);
        RightMotor2 = new SparkMax(2, MotorType.kBrushed);
        LeftMotor1 = new SparkMax(3, MotorType.kBrushed);
        LeftMotor2 = new SparkMax(4, MotorType.kBrushed);
        // same for 2025 Lib
        TopIntakeMotor = new WPI_TalonSRX(7);
        BottomIntakeMotor = new WPI_TalonSRX(5);

        //Change for Algae Intake, Coral flap, coral claw(Ib)
        ClawMotor = new WPI_TalonSRX(2);
        // Arm for Algae
        ArmMotor = new WPI_TalonSRX(4);

        //Controller Stuff same as 2025
        Controller = new XboxController(1);
        //Slider = new Joystick(3);
        

        //Use new SparkMaxConfig type to configue parameters
        /*
        RightMotor2.setInverted(true);
        RightMotor1.setInverted(true);
        LeftMotor1.setInverted(false);
        LeftMotor2.setInverted(false);

        RightMotor2.setIdleMode(IdleMode.kBrake);
        RightMotor1.setIdleMode(IdleMode.kBrake);
        LeftMotor1.setIdleMode(IdleMode.kBrake);
        LeftMotor2.setIdleMode(IdleMode.kBrake);
        */

        //Copy and pasted from Stephen code
        SparkBaseConfig driveConfig = new SparkMaxConfig().idleMode(SparkBaseConfig.IdleMode.kBrake);
        RightMotor1.configure(driveConfig.inverted(false), SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kNoPersistParameters);
        RightMotor2.configure(driveConfig.inverted(false), SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kNoPersistParameters);
        LeftMotor1.configure(driveConfig.inverted(true), SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kNoPersistParameters);
        LeftMotor2.configure(driveConfig.inverted(true), SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kNoPersistParameters);
        //AirCompressor = new Compressor(PneumaticsModuleType.REVPH);
        //Solenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 1);

        //LimitSwitch = new DigitalInput(9);
        //NavX = new AHRS();
        
    }

    public void Reset() {
        RightMotor1.set(0);
        RightMotor2.set(0);
        LeftMotor1.set(0);
        LeftMotor2.set(0);
    }
}
