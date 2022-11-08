package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class testClass extends LinearOpMode {

    DcMotorEx motor2;
    DcMotorEx motor3;

    @Override
    public void runOpMode(){

        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");

        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motor2.setTargetPosition(0);
        motor3.setTargetPosition(0);



        waitForStart();

        while(opModeIsActive()){

        }

    }

    private void armBusy(boolean motor2, boolean motor3){
        while(motor2 && motor3) {
            telemetry.addData("Status", "Waiting for the motor to reach its target");
            telemetry.update();
        }
    }
}
