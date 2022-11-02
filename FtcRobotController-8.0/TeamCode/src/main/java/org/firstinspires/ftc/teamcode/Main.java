package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "control")
public class Main extends LinearOpMode {

    Servo servo0;                       //Mid Right arm
    Servo servo1;                       //High Right arm
    Servo servo4;                       //Mid Left arm
    Servo servo5;                       //High Left arm
    private ElapsedTime runtime = new ElapsedTime();


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
        servo4 = hardwareMap.get(Servo.class, "servo4");
        servo5 = hardwareMap.get(Servo.class, "servo5");

        telemetry.addData("Status", "Initialized");
        telemetry.update();


        waitForStart();
        
        while(true) {
            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() <= 3.0)) {
                servo1.setPosition(0);
                servo0.setPosition(0);
                servo4.setPosition(0);
                servo5.setPosition(0);
                telemetry.addData("Leg 1", runtime.seconds());
                telemetry.update();
            }

            runtime.reset();
            while (opModeIsActive() && (runtime.seconds() <= 3.0)) {
                servo1.setPosition(1);
                servo0.setPosition(1);
                servo4.setPosition(1);
                servo5.setPosition(1);
                telemetry.addData("Leg 2", runtime.seconds());
                telemetry.update();
            }
        }
    }

}
