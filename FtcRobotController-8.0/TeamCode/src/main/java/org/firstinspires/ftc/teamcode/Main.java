package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "servo")
public class Motor extends LinearOpMode {

    Servo servo0;                       //Mid Right arm



    @Override
    public void runOpMode() {

        //equal to the starter value of the servo
        byte servoData0 = 0;

        //servo define
        servo0 = hardwareMap.get(Servo.class, "servo0");

        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        while(opModeIsActive()){

            if(gamepad1.dpad_left){
                servo0.setPosition(0);
            }
            else if(gamepad1.dpad_right){
                servo0.setPosition(0.3);
            }

            telemetry.addData("servo", servo0.getPosition());
            telemetry.addData("servo : ", servoData0);
            telemetry.update();

        }

    }

}
