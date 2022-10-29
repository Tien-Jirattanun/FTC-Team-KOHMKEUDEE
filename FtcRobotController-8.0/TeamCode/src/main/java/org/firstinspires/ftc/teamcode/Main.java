package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "control")
public class Main extends OpMode {

    DcMotor motor0;                     //RIGHT motor
    DcMotor motor1;                     //LEFT motor

    @Override
    public void init() {
        motor0 = hardwareMap.get(DcMotor.class ,"motor0");
        motor1 = hardwareMap.get(DcMotor.class ,"motor1");
    }

    @Override
    public void loop() {

        //check x,y
        float x = gamepad1.left_stick_x;
        float y = gamepad1.left_stick_y;

        //log
        System.out.print("x axis : ");
        System.out.println(x);
        System.out.print("y axis : ");
        System.out.println(y);
        System.out.println("------------------");

        System.out.println("branch --");

        if(x == 0)
        {
            motor0.setPower(y);
            motor1.setPower(y * -1);
        }
        else if(x > 0)
        {
            motor0.setPower(y - x);
            motor1.setPower((y + x) * -1);
        }
        else if(x < 0)
        {
            motor0.setPower(y + (x * (-1)));
            motor1.setPower((y - (x * (-1))) * -1);
        }
    }
}
