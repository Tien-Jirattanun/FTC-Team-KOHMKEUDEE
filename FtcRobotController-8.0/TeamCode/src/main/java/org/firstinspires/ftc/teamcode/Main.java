package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "control")
public class Main extends LinearOpMode {

    DcMotor motor0;                     //RIGHT motor
    DcMotor motor1;                     //LEFT motor
    DcMotor motor2;

    @Override
    public void runOpMode(){
        motor0 = hardwareMap.get(DcMotor.class ,"motor0");
        motor1 = hardwareMap.get(DcMotor.class ,"motor1");
        motor2 = hardwareMap.get(DcMotor.class ,"motor2");
    
        waitForStart();

        while(opModeIsActive()){
            if (gamepad1.dpad_up){
                
            }
        }
    }
}
