package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

@Autonomous(name = "Encoder")
public class Encoder extends LinearOpMode {

    DcMotorEx motor0;
    DcMotorEx motor1;
    DcMotorEx motor2;
    DcMotorEx motor3;

    @Override
    public void runOpMode(){

        motor0 = hardwareMap.get(DcMotorEx.class, "motor0");
        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");

        motor0.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        motor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor0.setVelocity(500);
        motor1.setVelocity(500);
        motor2.setVelocity(500);
        motor3.setVelocity(500);

        while (opModeIsActive()){
            //go backward

            motor0.setTargetPosition(1440);
            motor1.setTargetPosition(-1440);
            motor2.setTargetPosition(1440);
            motor3.setTargetPosition(-1440);
            sleep(500);

            motor0.setTargetPosition(-1440);
            motor1.setTargetPosition(-1440);
            motor2.setTargetPosition(1440);
            motor2.setTargetPosition(1440);


        }




    }



}
