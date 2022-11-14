package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "control")
public class Main extends LinearOpMode {

    DcMotor motor0;                     //RIGHT motor
    DcMotor motor1;                     //LEFT motor
    DcMotor motor2;

    @Override
    public void runOpMode() {
        motor0 = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");

        waitForStart();

        while (opModeIsActive()) {

            boolean pad_up = gamepad1.dpad_up;
            boolean pad_right = gamepad1.dpad_right;
            boolean pad_left = gamepad1.dpad_left;
            boolean pad_down = gamepad1.dpad_down;

            if (pad_up) {
                motor0.setPower(1);
                motor1.setPower(1);
            } else if (pad_right) {
                motor0.setPower(1);
                motor1.setPower(-1);
                motor2.setPower(1);
            } else if (pad_left) {
                motor0.setPower(-1);
                motor1.setPower(1);
                motor2.setPower(-1);
            } else if (pad_down) {
                motor0.setPower(-1);
                motor1.setPower(-1);
            }
        }
    }

}



//    private void twoWheel(){
//        //check x,y
//        float x = gamepad1.left_stick_x;
//        float y = gamepad1.left_stick_y;
//
//        //button
//        boolean L1 = gamepad1.left_bumper;
//
//        //slow mode
//        if(L1 == true){
//            x /= 3;
//            y /= 3;
//        }
//
//        //wheel
//        if(x == 0)
//        {
//            motor0.setPower(y);
//            motor1.setPower(y * -1);
//        }
//        else if(x > 0)
//        {
//            motor0.setPower(y - x);
//            motor1.setPower((y + x) * -1);
//        }
//        else if(x < 0)
//        {
//            motor0.setPower(y + (x * (-1)));
//            motor1.setPower((y - (x * (-1))) * -1);
//        }
//    }
//}



