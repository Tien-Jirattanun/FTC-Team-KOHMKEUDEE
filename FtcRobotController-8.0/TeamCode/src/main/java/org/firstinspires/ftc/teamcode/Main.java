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
        twoWheel();
    }

    private void twoWheel(){
        //check x,y
        float x = gamepad1.left_stick_x;
        float y = gamepad1.left_stick_y;

        //button
        boolean L1 = gamepad1.left_bumper;

        //slow mode
        if(L1 == true){
            x /= 3;
            y /= 3;
        }

        //wheel
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
