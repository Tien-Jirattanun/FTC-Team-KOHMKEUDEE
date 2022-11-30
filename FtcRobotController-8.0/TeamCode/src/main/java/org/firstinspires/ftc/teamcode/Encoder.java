package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.Velocity;


@Autonomous(name = "Encoder")
public class Encoder extends LinearOpMode {

    int encoderMotor0 = 0;
    int encoderMotor1 = 0;
    int encoderMotor2 = 0;
    int encoderMotor3 = 0;

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

        motor0.setTargetPosition(encoderMotor0);
        motor1.setTargetPosition(encoderMotor1);
        motor2.setTargetPosition(encoderMotor2);
        motor3.setTargetPosition(encoderMotor3);



        waitForStart();

        motor0.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor0.setVelocity(500);
        motor1.setVelocity(500);
        motor2.setVelocity(500);
        motor3.setVelocity(500);

        if (opModeIsActive()){
            //go backward

            backward(2160);
            moveRight(6800);


        }


    }

    //60 cm with 2160 thick

    private void backward(int thick){
        encoderMotor0 += thick;
        encoderMotor1 -= thick;
        encoderMotor2 += thick;
        encoderMotor3 -= thick;
        motorRun();
        motorWait();
    }

    private void forward(int thick){
        encoderMotor0 -= thick;
        encoderMotor1 += thick;
        encoderMotor2 -= thick;
        encoderMotor3 += thick;
        motorRun();
        motorWait();
    }

    private void moveLeft(int thick){
        encoderMotor0 += thick;
        encoderMotor1 += thick;
        encoderMotor2 -= thick;
        encoderMotor3 -= thick;
        motorRun();
        motorWait();
    }

    private void moveRight(int thick){
        encoderMotor0 -= thick;
        encoderMotor1 -= thick;
        encoderMotor2 += thick;
        encoderMotor3 += thick;
        motorRun();
        motorWait();
    }


    private void motorRun(){
        motor0.setTargetPosition(encoderMotor0);
        motor1.setTargetPosition(encoderMotor1);
        motor2.setTargetPosition(encoderMotor2);
        motor3.setTargetPosition(encoderMotor3);
    }

    private void motorWait(){
        while (motor0.isBusy() && motor1.isBusy() && motor2.isBusy() && motor3.isBusy()){
            telemetry.addData("Go", "Robot is running");
            telemetry.update();
        }
    }



}
