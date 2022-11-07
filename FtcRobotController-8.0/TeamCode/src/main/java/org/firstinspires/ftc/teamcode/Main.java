package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Main extends LinearOpMode {

    Servo servo0;
    Servo servo1;

    double servoPosition0 = 0.5;

    @Override
    public void runOpMode(){
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        servo0.setPosition(0.5);

        waitForStart();

        while(opModeIsActive()){

            if(gamepad1.dpad_up && servoPosition0 < 1){
                servoPosition0 = servoPosition0 + 0.01;
                sleep(50);

            }
            else if(gamepad1.dpad_down && servoPosition0 > 0){
                servoPosition0 = servoPosition0 - 0.01;
                sleep(50);
            }

            servo0.setPosition(servoPosition0);

            telemetry.addData("servo0: ", servo0.getPosition());
            telemetry.addData("servo0 num : ", servoPosition0);
            telemetry.addData("Status", "Running");
            telemetry.update();
        }


    }
}