package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Kuay")
public class Kuay extends LinearOpMode {

    Servo servo0;
    Servo servo1;
    Servo servo4;
    Servo servo5;

    double servoPositionMid = 1.0;
    double servoPositionHigh = 1-servoPositionMid;
    double servoPositionMid1 = 1.0;

    @Override
    public void runOpMode(){
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo4 = hardwareMap.get(Servo.class, "servo4");
        servo5 = hardwareMap.get(Servo.class, "servo5");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        servo0.setPosition(servoPositionMid);
        servo4.setPosition(servoPositionMid);

        waitForStart();

        while(opModeIsActive()){

            if(gamepad1.dpad_down){
                if (servoPositionMid < 1 ){
                    servoPositionMid = servoPositionMid + 0.01;
                }

                if(servoPositionHigh > 0){
                    servoPositionHigh = servoPositionHigh - 0.012;
                }

                sleep(50);

            }
            else if(gamepad1.dpad_up){
                if (servoPositionMid > 0 && servoPositionHigh < 0.2 ){
                    servoPositionHigh = servoPositionHigh + 0.01;
                }
                if (servoPositionHigh >= 0.2){
                    if(servoPositionHigh < 1){
                        servoPositionHigh = servoPositionHigh + 0.01;
                    }
                    if(servoPositionMid > 0){
                        servoPositionMid = servoPositionMid - 0.01;
                    }


                }

                sleep(50);
            }

            servo0.setPosition(servoPositionMid);
            servo1.setPosition(servoPositionHigh);
            servo4.setPosition(servoPositionMid);
            servo5.setPosition(servoPositionHigh);

            telemetry.addData("servo0: ", servo0.getPosition());
            telemetry.addData("servo0 num : ", servoPositionMid);
            telemetry.addData("servo0: ", servo1.getPosition());
            telemetry.addData("servo0 num : ", servoPositionHigh);
            telemetry.addData("servo4: ", servo4.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }


    }
}