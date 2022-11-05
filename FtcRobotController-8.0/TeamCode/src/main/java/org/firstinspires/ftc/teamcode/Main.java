package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class Main extends LinearOpMode {

    DcMotor motor0;
    DcMotor motor1;

    @Override
    public void runOpMode(){

        motor0 = hardwareMap.get(DcMotor.class,"motor0");
        motor1 = hardwareMap.get(DcMotor.class,"motor1");

        waitForStart();


        if (opModeIsActive()){
            motor0.setPower(1);
            motor1.setPower(1);
            sleep(1000);
            motor0.setPower(0);
            motor1.setPower(0);
            sleep(1000);
        }

    }
}