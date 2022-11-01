package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "control")
public class Main extends LinearOpMode {

    DcMotor motor0;                     //RIGHT motor
    DcMotor motor1;                     //LEFT motor
    DcMotor motor2;                     //Base arm Left
    DcMotor motor3;                     //Base arm Right
    Servo servo0;                       //Mid Right arm
    Servo servo1;                       //High Right arm
    Servo servo2;                       //Mid Left arm
    Servo servo3;                       //High Left arm


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
        motor2 = hardwareMap.get(DcMotor.class ,"motor2");
        motor3 = hardwareMap.get(DcMotor.class ,"motor3");

        //servo define
        servo0 = hardwareMap.get(Servo.class, "servo0");
        servo1 = hardwareMap.get(Servo.class, "servo1");
        servo2 = hardwareMap.get(Servo.class, "servo2");
        servo3 = hardwareMap.get(Servo.class, "servo3");

        //Mode setting
            //Wheel setting
        motor0.setDirection(DcMotor.Direction.FORWARD);
        motor1.setDirection(DcMotor.Direction.REVERSE);
            //Arm setting
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);

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

            //Auto arm (NEED CALIBRATION BEFORE USE)
            if(gamepad1.cross)
            {
                //reset to the start position
                servoData0 = 0;
                servoData1 = 0;
                servoData2 = 0;
                servoData3 = 0;
                encoder2 = 0;
                encoder3 = 0;
                servo0.setPosition(servoData0);
                servo1.setPosition(servoData1);
                servo2.setPosition(servoData2);
                servo3.setPosition(servoData3);
                motor2.setTargetPosition(encoder2);
                motor3.setTargetPosition(encoder3);

            }
            else if(gamepad1.circle)
            {
                //Low junction
                servoData0 = 0;
                servoData1 = 0;
                servoData2 = 0;
                servoData3 = 0;
                encoder2 = 0;
                encoder3 = 0;
                servo0.setPosition(servoData0);
                servo1.setPosition(servoData1);
                servo2.setPosition(servoData2);
                servo3.setPosition(servoData3);
                motor2.setTargetPosition(encoder2);
                motor3.setTargetPosition(encoder3);
            }
            else if(gamepad1.square)
            {
                //Medium junction
                servoData0 = 0;
                servoData1 = 0;
                servoData2 = 0;
                servoData3 = 0;
                encoder2 = 0;
                encoder3 = 0;
                servo0.setPosition(servoData0);
                servo1.setPosition(servoData1);
                servo2.setPosition(servoData2);
                servo3.setPosition(servoData3);
                motor2.setTargetPosition(encoder2);
                motor3.setTargetPosition(encoder3);
            }
            else if(gamepad1.triangle)
            {
                //High junction
                servoData0 = 0;
                servoData1 = 0;
                servoData2 = 0;
                servoData3 = 0;
                encoder2 = 0;
                encoder3 = 0;
                servo0.setPosition(servoData0);
                servo1.setPosition(servoData1);
                servo2.setPosition(servoData2);
                servo3.setPosition(servoData3);
                motor2.setTargetPosition(encoder2);
                motor3.setTargetPosition(encoder3);
            }

            //Manual arm
            //Not finish because not CALIBRATE the encoder motor yet

            /*
            
            if(gamepad1.right_stick_y > 0){

            }
            else if(gamepad1.right_stick_y < 0){
                servoData0 -= 0.1;
                servoData1 -= 0.1;
                servo0.setPosition(servoData0);
                servo1.setPosition(servoData1);
            }

            */


            telemetry.addData("Servo Position", servo0.getPosition());
            telemetry.addData("Servo Position", servo1.getPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();

        }



    }

}
