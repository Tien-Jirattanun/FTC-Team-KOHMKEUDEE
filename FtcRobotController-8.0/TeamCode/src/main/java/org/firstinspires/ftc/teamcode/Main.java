package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Main extends LinearOpMode {

    DcMotorEx motor2;

    int targetMotorPosition = 0;

    @Override
    public void runOpMode(){
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");

        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        motor2.setTargetPosition(targetMotorPosition);


        waitForStart();

        while(opModeIsActive()){


            motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor2.setVelocity(200);


            if(gamepad1.dpad_down && motor2.getCurrentPosition() < 1440){
                targetMotorPosition += 108;
            }
            else if(gamepad1.dpad_up && motor2.getCurrentPosition() > -1440){
                targetMotorPosition -= 108;
            }

            sleep(50);
            motor2.setTargetPosition(targetMotorPosition);
            armBreak();

            telemetry.addData("Encoder value", motor2.getCurrentPosition());
            telemetry.addData("Status", "Running");
            telemetry.update();
        }


    }

    private void armBreak(){
        while(motor2.isBusy()) {
            telemetry.addData("Status", "Waiting for the motor to reach its target");
            telemetry.update();
        }
    }
}