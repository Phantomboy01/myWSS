package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.studica.frc.Servo;

public class Arm extends SubsystemBase {
    
    private final Servo servo, servo1;
    private double servoAngle, servoAngle1;

    private final ShuffleboardTab tab = Shuffleboard.getTab("Arm");
    private final NetworkTableEntry D_armValue = tab.add("armValue", 0).getEntry();

    public Arm() {
        servo = new Servo(0);
        servo1 = new Servo(1);
    }
    
    public void setServoAngle(final double degrees) {
        servoAngle = degrees;
        servo.setAngle(degrees);
    }

    public void setServoAngle1(final double degrees) {
        servoAngle1 = degrees;
        servo1.setAngle(degrees);
    }

    public void periodic()
    {
        D_armValue.setDouble(servoAngle);
        //D_armValue.setDouble(servoAngle1);
    }

}