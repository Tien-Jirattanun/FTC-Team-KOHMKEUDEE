package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "control")
public class Main extends LinearOpMode {

    DcMotor motor0;                     //RIGHT motor
    DcMotor motor1;                     //LEFT motor
    DcMotor motor2;                     //Base arm Left
    DcMotor motor3;                     //Base arm Right
    Servo servo0;                       //Mid Right arm
    Servo servo1;                       //High Right arm
    Servo servo4;                       //Mid Left arm
    Servo servo5;                       //High Left arm


    @Override
    public void runOpMode()
    {

        //equal to the starter value of the servo
        byte servoData0 = 0;
        byte servoData1 = 0;
        byte servoData2 = 0;
        byte servoData3 = 0;
        int encoder2 = 0;
        int encoder3 = 0;

        //motor define
        motor0 = hardwareMap.get(DcMotor.class ,"motor0");
        motor1 = hardwareMap.get(DcMotor.class ,"motor1");
        motor2 = hardwareMap.get(DcMotorEx.class ,"motor2");
        motor3 = hardwareMap.get(DcMotorEx.class ,"motor3");

        servo0 = hardwareMap.get(Servo.class ,"servo0");
        servo1 = hardwareMap.get(Servo.class ,"servo1");
        servo4 = hardwareMap.get(Servo.class ,"servo4");
        servo5 = hardwareMap.get(Servo.class ,"servo5");


        //Mode setting
        //Wheel setting
        motor0.setDirection(DcMotor.Direction.FORWARD);
        motor1.setDirection(DcMotor.Direction.REVERSE);
        //Arm setting
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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

            telemetry.addData("Servo0 Position", servo0.getPosition());             //low right
            telemetry.addData("Servo1 Position", servo1.getPosition());             //high right
            telemetry.addData("Servo4 Position", servo4.getPosition());             //low left
            telemetry.addData("Servo5 Position", servo5.getPosition());             //high left
            telemetry.addData("Motor2 Position", motor2.getCurrentPosition());      //base right
            telemetry.addData("Motor3 Position", motor3.getCurrentPosition());      //base left
            telemetry.addData("Status", "Running");
            telemetry.update();

        }



    }

}
