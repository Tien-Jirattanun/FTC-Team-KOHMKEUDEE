package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Control1")                //The name of the program
public class Test extends LinearOpMode {  //This class extends from LinearOpMode

    DcMotorEx motor0;
    DcMotorEx motor1;
    DcMotorEx motor2;
    DcMotorEx motor3;
    DcMotorEx motor4;
    Servo servo1;
    Servo servo0;


    @Override
    public void runOpMode() {
        motor0 = hardwareMap.get(DcMotorEx.class, "motor0");              //make robot know that the motor encoder have plug in
        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");
        motor4 = hardwareMap.get(DcMotorEx.class, "motor4");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo0 = hardwareMap.get(Servo.class, "servo0");

        motor0.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);                   //Reset the encoder thick to zero
        motor1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        motor0.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);                        //Set encoder to RUN_USING_ENCODER mode
        motor1.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        double motorVelocity0 = 1440;                                               //Set the velocity of the motor encoder in the unit thick/sec
        double motorVelocity1 = -1440;
        double motorVelocity2 = 0;
        double X = gamepad1.left_stick_x;
        double Y = gamepad1.left_stick_y;
//        double W1 = -

        int encoderData = 0;

        waitForStart();

        motor4.setTargetPosition(encoderData);
        motor4.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor4.setVelocity(1440);

        while (opModeIsActive()) {

            motorVelocity0 = 1440;
            motorVelocity1 = -1440;
            motorVelocity2 = 0;



            if(gamepad1.start || gamepad1.right_stick_button){
                motorVelocity0 /= 3;
                motorVelocity1 /= 3;
                motorVelocity2 /= 3;
            }

            if (gamepad1.dpad_up){
                motor0.setVelocity(motorVelocity1);
                motor1.setVelocity(motorVelocity0);
                motor2.setVelocity(motorVelocity1);
                motor3.setVelocity(motorVelocity0);
            }
            else if (gamepad1.dpad_down){
                motor0.setVelocity(motorVelocity0);
                motor1.setVelocity(motorVelocity1);
                motor2.setVelocity(motorVelocity0);
                motor3.setVelocity(motorVelocity1);
            }
            else if(gamepad1.dpad_left){
                motor2.setVelocity(motorVelocity1);
                motor0.setVelocity(motorVelocity0);
                motor3.setVelocity(motorVelocity1);
                motor1.setVelocity(motorVelocity0);
            }
            else if(gamepad1.dpad_right){
                motor1.setVelocity(motorVelocity1);
                motor3.setVelocity(motorVelocity0);
                motor0.setVelocity(motorVelocity1);
                motor2.setVelocity(motorVelocity0);
            }

            //rotate
            else if(gamepad1.right_stick_x > 0){
                motor0.setVelocity(motorVelocity0);
                motor1.setVelocity(motorVelocity0);
                motor2.setVelocity(motorVelocity0);
                motor3.setVelocity(motorVelocity0);
            }
            else if(gamepad1.right_stick_x < 0){
                motor0.setVelocity(motorVelocity1);
                motor1.setVelocity(motorVelocity1);
                motor2.setVelocity(motorVelocity1);
                motor3.setVelocity(motorVelocity1);
            }
            else {
                motor0.setVelocity(motorVelocity2);
                motor1.setVelocity(motorVelocity2);
                motor2.setVelocity(motorVelocity2);
                motor3.setVelocity(motorVelocity2);
            }


            //griper

            if(gamepad1.right_bumper){
                servo0.setPosition(0.5);
                servo1.setPosition(0.5);
                sleep(500);
                encoderData -= 300;
                motor4.setTargetPosition(encoderData);
            }
            else if(gamepad1.left_bumper) {

                servo0.setPosition(1);
                servo1.setPosition(0);
            }

            //arm

            if(gamepad1.cross){
                encoderData -= 10;
            }
//            else if(gamepad1.square && encoderData > -10900) {
//                encoderData = -10850;
//            }
//            else if(gamepad1.triangle && encoderData > -14340){
//                encoderData = -14290;
//            }
            else if(gamepad1.circle){
                encoderData = 0;
            }
            motor4.setTargetPosition(encoderData);

            telemetry.addData("thick0 : ", motor0.getCurrentPosition());
            telemetry.addData("thick1 : ", motor1.getCurrentPosition());
            telemetry.addData("thick2 : ", motor2.getCurrentPosition());
            telemetry.addData("thick3 : ", motor3.getCurrentPosition());
            telemetry.addData("thick arm : ",motor4.getCurrentPosition());
            telemetry.addData("velocity", motor4.getVelocity());
            telemetry.addData("kuay",encoderData);
            telemetry.update();
        }

    }

}
