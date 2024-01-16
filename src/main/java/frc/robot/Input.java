package frc.robot;
import edu.wpi.first.wpilibj.XboxController;

public class Input {
    
    public static XboxController driveController = new XboxController(0);
    public static XboxController OpController = new XboxController(0);

    // Add a speed limit, we're just driving this down the hall anyways
    public static double speedLimit(){
        return 1 - (driveController.getLeftY() * 0.5);
    }

    public static double getVertical(){
        return driveController.getLeftY() * speedLimit();
    }

    public static double getHorizontal(){
        return driveController.getLeftX();
    }

    public static XboxController Driver(){
        return driveController;
    }

}
