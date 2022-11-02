package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "control")
public class Main extends LinearOpMode {

    Servo servo0;                       //Mid Right arm
    Servo servo1;                       //High Right arm
    Servo servo2;                       //Mid Left arm
    Servo servo3;                       //High Left arm


    @Override
    public void runOpMode()
    {

        //equal to the starter value of the servo
        byte servoData0 = 0;
        byte servoData1 = 0;
        byte servoData2 = 0;
        byte servoData3 = 0;


        //servo define
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servo3 = hardwareMap.get(Servo.class, "servo3");

        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();

        while (opModeIsActive()) {

            servo0.setPosition(0);
            servo1.setPosition(0);
            servo0.setPosition(0);
            servo1.setPosition(0);

            telemetry.addData("Servo Position", servo0.getPosition());
            telemetry.addData("Servo Position", servo1.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();

        }



    }

}
