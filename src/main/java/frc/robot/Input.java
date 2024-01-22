package frc.robot;
import edu.wpi.first.wpilibj.XboxController;

public class Input {
    
    public static XboxController driveController = new XboxController(0);
    public static XboxController OpController = new XboxController(0);

    // // Add a speed limit, we're just driving this down the hall anyways
    // public static double speedLimit(){
    //     return 1 - (driveController.getLeftY() * 0.1);
    // }

    public static double getVertical(){
        return (driveController.getLeftY());
    }

    public static double getHorizontal(){
        return driveController.getRightX() * 0.8;
    }

    public static boolean driveDecelerate(){
        return driveController.getLeftBumper();
    }

    public static XboxController Driver(){
        return driveController;
    }

}
