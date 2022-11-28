package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DigitalChannel;

@TeleOp(name = "touch")
public class Touch extends LinearOpMode {

    DigitalChannel digitalTouch;  // Hardware Device Object

    @Override
    public void runOpMode() {

        digitalTouch = hardwareMap.get(DigitalChannel.class, "touch");

        digitalTouch.setMode(DigitalChannel.Mode.INPUT);

        waitForStart();

        while (opModeIsActive()) {

            if (digitalTouch.getState() == true) {
                telemetry.addData("Digital Touch", "Is Not Pressed");
            } else {
                telemetry.addData("Digital Touch", "Is Pressed");
            }

            telemetry.update();
        }
    }
}
