package frc.robot.subsystems;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class CameraSubsystem extends SubsystemBase {
    public void Camera(){
        CameraServer.startAutomaticCapture();
    }  
}
