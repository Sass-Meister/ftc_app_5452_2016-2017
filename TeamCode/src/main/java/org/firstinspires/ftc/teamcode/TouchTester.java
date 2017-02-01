package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DigitalChannelController;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by mlowery2 on 1/24/2017.
 *
 * This is just a program for me to learn how to use the touch sensor because there arent any sample programs
 *
 * TODO: Once LinearBase is updated with the touch, update this program
 */
@Autonomous(name = "Touch Testing", group ="testing")
public class TouchTester extends LinearOpMode {

    final int BLUE_LED_CHANNEL = 0;
    final int RED_LED_CHANNEL = 1;

    DeviceInterfaceModule dim;                  // Device Object
    DigitalChannel        digIn;                // Device Object

    public void runOpMode()
    {
        // get a reference to a Modern Robotics DIM, and IO channels.
        dim = hardwareMap.get(DeviceInterfaceModule.class, "dim");   //  Use generic form of device mapping
        digIn  = hardwareMap.get(DigitalChannel.class, "touch");     //  Use generic form of device mapping

        digIn.setMode(DigitalChannelController.Mode.INPUT);          // Set the direction of each channel

        waitForStart();

        while(opModeIsActive())
        {

            // Display input pin state on LEDs
            if (digIn.getState()) {
                dim.setLED(RED_LED_CHANNEL, true);
                dim.setLED(BLUE_LED_CHANNEL, false);
            }
            else {
                dim.setLED(RED_LED_CHANNEL, false);
                dim.setLED(BLUE_LED_CHANNEL, true);
            }

            telemetry.addData("Input", digIn.getState());
            telemetry.addData("LED",   digIn.getState() ? "Red" : "Blue" );
            telemetry.update();

        }
    }
}