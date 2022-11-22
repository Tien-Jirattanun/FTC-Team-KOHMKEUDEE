package org.firstinspires.ftc.teamcode;

import static java.lang.Math.sqrt;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Control1")
public class Test extends LinearOpMode {

    DcMotor motor0;                     //RIGHT motor
    DcMotor motor1;                     //LEFT motor
    DcMotor motor2;
    DcMotor motor3;
    //    DcMotor motor3;
    Servo servo1;
    Servo servo0;

    int encoderData = 0;

    @Override
    public void runOpMode() {
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo0 = hardwareMap.get(Servo.class, "servo0");





        waitForStart();

        while (opModeIsActive()) {

            //joy
//            double R = 0.155;
//            float X = gamepad1.left_stick_x;
//            float Y = gamepad1.left_stick_y;
//            byte A = 0;
//            byte B = 0;
//            double W1 = -0.5*X - (sqrt(3)/2)*Y;
//            double W2 = -0.5*X + (sqrt(3)/2)*Y  ;
//            double W3 = X ;
//            int targetMotorPosition = 0;
//
//            motor0.setPower(W1);
//            motor1.setPower(W2);
//            motor2.setPower(W3*0.95);

            if (gamepad1.dpad_up){
                motor0.setPower(1);
                motor1.setPower(-1);
                motor2.setPower(1);
                motor3.setPower(-1);
            }
            else if (gamepad1.dpad_down){
                motor0.setPower(-1);
                motor1.setPower(1);
                motor2.setPower(-1);
                motor3.setPower(1);
            }
            else if (gamepad1.dpad_right){
                motor0.setPower(1);
                motor1.setPower(1);
                motor2.setPower(-1);
                motor3.setPower(-1);
            }
            else if (gamepad1.dpad_left){
                motor0.setPower(-1);
                motor1.setPower(-1);
                motor2.setPower(1);
                motor3.setPower(1);
            }
            else if (gamepad1.cross){
                motor0.setPower(1);
                motor1.setPower(1);
                motor2.setPower(1);
                motor3.setPower(1);
            }
            else if (gamepad1.square){
                motor0.setPower(-1);
                motor1.setPower(-1);
                motor2.setPower(-1);
                motor3.setPower(-1);
            }
            else if (gamepad1.dpad_left && gamepad1.dpad_up){
                motor0.setPower(0);
                motor1.setPower(-1);
                motor2.setPower(1);
                motor3.setPower(0);
            }
            else if (gamepad1.dpad_left && gamepad1.dpad_down){
                motor0.setPower(0);
                motor1.setPower(1);
                motor2.setPower(-1);
                motor3.setPower(0);
            }
            else if (gamepad1.dpad_right && gamepad1.dpad_up){
                motor0.setPower(1);
                motor1.setPower(0);
                motor2.setPower(0);
                motor3.setPower(-1);
            }
            else if (gamepad1.dpad_right && gamepad1.dpad_down){
                motor0.setPower(-1);
                motor1.setPower(0);
                motor2.setPower(0);
                motor3.setPower(1);
            }
            else{
                motor0.setPower(0);
                motor1.setPower(0);
                motor2.setPower(0);
                motor3.setPower(0);
            }

            //arm
//            motor3.setVelocity(200);
//
//            if(gamepad1.square){
//                encoderData -= 50;
//            }
//            else if(gamepad1.cross && encoderData < 0) {
//                encoderData += 50;
//            }
//
//            motor3.setTargetPosition(encoderData);

            //rotate2.0
            float C = gamepad1.right_stick_x;

            double R1 = (0.5*C)*0.69;
            double R2 = (0.5*C)*0.69;
            double R3 = C*0.69 ;

            motor0.setPower(R1*-1);
            motor1.setPower(R2*-1);
            motor2.setPower(R3*-0.94);


            //griper
            if(gamepad1.left_bumper){
                servo0.setPosition(1);
                servo1.setPosition(0);
            }
            else if(gamepad1.right_bumper){
                servo0.setPosition(0.6);
                servo1.setPosition(0.4);
            }
        }
    }

    private void armBreak(){
        while(motor3.isBusy()) {
            telemetry.addData("Status", "Waiting for the motor to reach its target");
            telemetry.update();
        }
    }

}







