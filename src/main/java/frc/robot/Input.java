package frc.robot;
import edu.wpi.first.wpilibj.XboxController;

public class Input {
    
    public static XboxController driveController = new XboxController(0);
    public static XboxController OpController = new XboxController(0);

    public static double speedLimit(){
        return 1 - (driveController.getLeftY() * 0.5);
        }

    public static double getVertical(){
        return driveController.getLeftY() * speedLimit();
        }

    public static double getHorizontal(){
        return driveController.getRightX();
        }

    public static double driveDecelerate(){
        return driveController.getLeftTriggerAxis();
        }

    public static XboxController Driver(){
        return driveController;
        }
}
