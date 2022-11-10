package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Main extends LinearOpMode {

    DcMotorEx motor2;
    DcMotorEx motor3;

    int targetMotorPosition2 = 0;
    int targetMotorPosition3 = 0;

    @Override
    public void runOpMode(){
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");

        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        motor2.setTargetPosition(targetMotorPosition2);
        motor3.setTargetPosition(targetMotorPosition3);




        waitForStart();

        while(opModeIsActive()){


            motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor2.setVelocity(300);
            motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor3.setVelocity(300);


            if(gamepad1.dpad_down && motor3.getCurrentPosition() > 0 && motor2.getCurrentPosition() < 0){
                targetMotorPosition2 += 50;
                targetMotorPosition3 -= 50;
            }
            else if(gamepad1.dpad_up && motor3.getCurrentPosition() < 1440 && motor2.getCurrentPosition() > -1440){
                targetMotorPosition2 -= 50;
                targetMotorPosition3 += 50;
            }

            motor2.setTargetPosition(targetMotorPosition2);
            motor3.setTargetPosition(targetMotorPosition3);
            armBreak();

            telemetry.addData("Encoder value", motor2.getCurrentPosition());
            telemetry.addData("Encoder value", motor3.getCurrentPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }

    private void armBreak(){
        while(motor2.isBusy() && motor3.isBusy()) {
            telemetry.addData("Status", "Waiting for the motor to reach its target");
            telemetry.update();
        }
    }
}