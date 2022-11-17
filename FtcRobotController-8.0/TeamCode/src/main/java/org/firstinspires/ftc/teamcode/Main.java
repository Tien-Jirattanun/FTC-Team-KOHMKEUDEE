package org.firstinspires.ftc.teamcode;

import static java.lang.Math.sqrt;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Controll")
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
            double R = 0.155;
            float X = gamepad1.left_stick_x;
            float Y = gamepad1.left_stick_y;
            double W1 = -0.5*X - (sqrt(3)/2)*Y;
            double W2 = -0.5*X + (sqrt(3)/2)*Y  ;
            double W3 = X ;

            motor0.setPower(W2);
            motor1.setPower(W1);

            if (X>0 || X<0) {
                sleep(125);
                motor2.setPower(W3);
            }
            else {
                motor0.setPower(0);
                motor1.setPower(0);
                motor2.setPower(0);
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

//if (pad_up) {
//        motor0.setPower(1);
//        motor1.setPower(-1);
//        motor2.setPower(0);
//        } else if (pad_right) {
//        motor0.setPower(-0.545);
//        motor1.setPower(-0.545);
//        motor2.setPower(1);
//        } else if (pad_left) {
//        motor0.setPower(0.545);
//        motor1.setPower(0.545);
//        motor2.setPower(-1);
//        } else if (pad_down) {
//        motor0.setPower(-1);
//        motor1.setPower(1);
//        motor2.setPower(0);
//        }
//        else{
//        motor0.setPower(0);
//        motor1.setPower(0);
//        motor2.setPower(0);
//        }



