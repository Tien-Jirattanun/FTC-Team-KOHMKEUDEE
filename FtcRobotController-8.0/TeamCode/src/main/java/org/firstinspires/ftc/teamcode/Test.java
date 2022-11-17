package org.firstinspires.ftc.teamcode;

import static java.lang.Math.sqrt;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "Controll1")
public class Test extends LinearOpMode {

    DcMotor motor0;                     //RIGHT motor
    DcMotor motor1;                     //LEFT motor
    DcMotor motor2;
    DcMotor motor3;

    @Override
    public void runOpMode() {
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");

        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setTargetPosition(0);
//        motor3.

        waitForStart();

        while (opModeIsActive()) {
            //joy
            double R = 0.155;
            float X = gamepad1.left_stick_x;
            float Y = gamepad1.left_stick_y;
            byte A = 0;
            byte B = 0;
            double W1 = -0.5*X - (sqrt(3)/2)*Y;
            double W2 = -0.5*X + (sqrt(3)/2)*Y  ;
            double W3 = X ;

            motor0.setPower(W1);
            motor1.setPower(W2);
            motor2.setPower(W3*0.95);


            //arm
            if(gamepad1.left_bumper){
                motor3.setPower(1);
            }
            if(gamepad1.right_bumper){
                motor0.setPower(-0.66);
                motor1.setPower(-0.66);
                motor2.setPower(-0.66);
            }

            //rotate2.0
            float C = gamepad1.right_stick_x;

            double R1 = (0.5*C)*0.69;
            double R2 = (0.5*C)*0.69;
            double R3 = C*0.69 ;

            motor0.setPower(R1);
            motor1.setPower(R2);
            motor2.setPower(R3*0.94);


        }
    }

}







