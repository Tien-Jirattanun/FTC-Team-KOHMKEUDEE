package org.firstinspires.ftc.teamcode;

import static java.lang.Math.sqrt;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Controll")
public class Test extends LinearOpMode {

    DcMotor motor0;                     //RIGHT motor
    DcMotor motor1;                     //LEFT motor
    DcMotor motor2;

    @Override
    public void runOpMode() {
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");

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
            motor2.setPower(W3);

            //dpad
            if (gamepad1.dpad_up){
                B=1;
            }
            else if (gamepad1.dpad_down){
                B=-1;
            }
            else if (gamepad1.dpad_right){
                A=1;
            }
            else if (gamepad1.dpad_left){
                A=-1;
            }

            double M1 = -0.5*A - (sqrt(3)/2)*B;
            double M2 = -0.5*A + (sqrt(3)/2)*B;
            double M3 = A ;

            motor0.setPower(M1);
            motor1.setPower(M2);
            motor2.setPower(M3);

            //rotate
            if(gamepad1.left_bumper){
                motor0.setPower(0.69);
                motor1.setPower(0.69);
                motor2.setPower(0.69);
            }
            if(gamepad1.right_bumper){
                motor0.setPower(-0.69);
                motor1.setPower(-0.69);
                motor2.setPower(-0.69);
            }


        }
    }

}







