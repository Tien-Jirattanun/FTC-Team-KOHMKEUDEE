
//for motor code

package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;


@TeleOp
public class Main extends LinearOpMode {

    DcMotorEx motor2;
    DcMotorEx motor3;

    double servoPosition0 = 0.5;

    @Override
    public void runOpMode(){
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");

        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motor2.setTargetPosition(0);
        motor3.setTargetPosition(0);

        motor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        motor2.setVelocity(500);
        motor3.setVelocity(500);

        motor2.setTargetPosition(1440);
        motor3.setTargetPosition(1440);
        armBusy(motor2.isBusy(),motor3.isBusy());

        motor2.setTargetPosition(0);
        motor3.setTargetPosition(0);
        armBusy(motor2.isBusy(),motor3.isBusy());


        motor2.setTargetPosition(1440);
        motor3.setTargetPosition(1440);
        armBusy(motor2.isBusy(),motor3.isBusy());



        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while(opModeIsActive()){
            telemetry.addData("Status", "Running");
            telemetry.update();
        }




    }

    private void armBusy(boolean motor2, boolean motor3){
        while(motor2 && motor3) {
            telemetry.addData("Status", "Waiting for the motor to reach its target");
            telemetry.update();
        }
    }
}