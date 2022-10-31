package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "control")
public class Main extends OpMode {

    private DcMotor motor0;                     //Top Left
    private DcMotor motor1;                     //Top Right
    private DcMotor motor2;                     //Bottom Left
    private DcMotor motor3;                     //Bottom Right

    @Override
    public void init()
    {
        motor0 = hardwareMap.get(DcMotor.class ,"motor0");
        motor1 = hardwareMap.get(DcMotor.class ,"motor1");
        motor2 = hardwareMap.get(DcMotor.class ,"motor2");
        motor3 = hardwareMap.get(DcMotor.class ,"motor3");
    }

    @Override
    public void loop()
    {

        if(gamepad1.dpad_up)
        {
            motor0.setPower(1);
            motor1.setPower(1);
            motor2.setPower(1);
            motor3.setPower(1);
        }
        else if(gamepad1.dpad_down)
        {
            motor0.setPower(-1);
            motor1.setPower(-1);
            motor2.setPower(-1);
            motor3.setPower(-1);
        }
        else if (gamepad1.dpad_right)
        {
            motor0.setPower(1);
            motor1.setPower(-1);
            motor2.setPower(-1);
            motor3.setPower(1);
        }
        else if (gamepad1.dpad_left)
        {
            motor0.setPower(-1);
            motor1.setPower(1);
            motor2.setPower(1);
            motor3.setPower(-1);
        }
        else if(gamepad1.dpad_up && gamepad1.dpad_right)
        {
            motor0.setPower(1);
            motor1.setPower(0);
            motor2.setPower(0);
            motor3.setPower(1);
        }
        else if(gamepad1.dpad_up && gamepad1.dpad_left)
        {
            motor0.setPower(0);
            motor1.setPower(1);
            motor2.setPower(1);
            motor3.setPower(0);
        }
        else if(gamepad1.dpad_down && gamepad1.dpad_right){
            motor0.setPower(0);
            motor1.setPower(-1);
            motor2.setPower(-1);
            motor3.setPower(0);
        }
        else if(gamepad1.dpad_down && gamepad1.dpad_left){
            motor0.setPower(-1);
            motor1.setPower(0);
            motor2.setPower(0);
            motor3.setPower(-1);
        }
        else if(gamepad1.right_bumper){
            motor0.setPower(1);
            motor1.setPower(-1);
            motor2.setPower(1);
            motor3.setPower(-1);
        }
        else if(gamepad1.left_bumper){
            motor0.setPower(-1);
            motor1.setPower(1);
            motor2.setPower(-1);
            motor3.setPower(1);
        }
    }
}
