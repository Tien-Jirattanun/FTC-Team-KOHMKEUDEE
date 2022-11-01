package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "control")
public class Main extends LinearOpMode {

    DcMotor motor0;                     //RIGHT motor
    DcMotor motor1;                     //LEFT motor
    Servo servo0;                       //Base right arm
    Servo servo1;                       //High Right arm

    @Override
    public void runOpMode()
    {

        //equal to the starter value of the servo
        byte servoData0 = 0;
        byte servoData1 = 0;

        motor0 = hardwareMap.get(DcMotor.class ,"motor0");
        motor1 = hardwareMap.get(DcMotor.class ,"motor1");
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        telemetry.addData("Status", "Initialized");
        telemetry.update();



        waitForStart();

        while (opModeIsActive()) {

            //-------------------------Input-------------------------

            //left joy stick
            float xL = gamepad1.left_stick_x;
            float yL = gamepad1.left_stick_y;

            //right joy stick
            float yR = gamepad1.right_stick_y;

            //button
            boolean L1 = gamepad1.left_bumper;

            //-------------------------Movement-------------------------

            //slow mode
            if(L1 == true){
                xL /= 3;
                yL /= 3;
            }

            //wheel
            if(xL == 0)
            {
                motor0.setPower(yL);
                motor1.setPower(yL * -1);
            }
            else if(xL > 0)
            {
                motor0.setPower(yL - xL);
                motor1.setPower((yL + xL) * -1);
            }
            else if(xL < 0)
            {
                motor0.setPower(yL + (xL * (-1)));
                motor1.setPower((yL - (xL * (-1))) * -1);
            }

            //-------------------------Arm-------------------------
            //Auto arm
            if(gamepad1.cross)
            {
                //reset to the start position
                servoData0 = 0;
                servoData1 = 0;
                servo0.setPosition(0);
                servo1.setPosition(0);
            }
            else if(gamepad1.circle)
            {
                //Low junction
                servoData0 = 0;
                servoData1 = 0;
                servo0.setPosition(0);
                servo1.setPosition(0);
            }
            else if(gamepad1.square)
            {
                //Medium junction
                servoData0 = 0;
                servoData1 = 0;
                servo0.setPosition(0);
                servo1.setPosition(0);
            }
            else if(gamepad1.triangle)
            {
                //High junction
                servoData0 = 0;
                servoData1 = 0;
                servo0.setPosition(0);
                servo1.setPosition(0);
            }

            //Manual arm
            if(gamepad1.right_stick_y > 0){
                servoData0 += 0.1;
                servoData1 += 0.1;
                servo0.setPosition(servoData0);
                servo1.setPosition(servoData1);
            }
            else if(gamepad1.right_stick_y < 0){
                servoData0 -= 0.1;
                servoData1 -= 0.1;
                servo0.setPosition(servoData0);
                servo1.setPosition(servoData1);
            }


            telemetry.addData("Servo Position", servo0.getPosition());
            telemetry.addData("Servo Position", servo1.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();

        }



    }

}
