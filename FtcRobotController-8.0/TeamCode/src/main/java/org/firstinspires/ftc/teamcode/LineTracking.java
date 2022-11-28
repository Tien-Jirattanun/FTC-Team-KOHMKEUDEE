package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;

@Autonomous(name = "LineTracking")
public class LineTracking extends LinearOpMode {

    DigitalChannel digitalTouch;
    ColorSensor color;

    DcMotorEx motor0;
    DcMotorEx motor1;
    DcMotorEx motor2;
    DcMotorEx motor3;

    boolean button = false;

    @Override
    public void runOpMode(){

        digitalTouch = hardwareMap.get(DigitalChannel.class, "touch");

        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        color = hardwareMap.get(ColorSensor.class, "color");

        motor0 = hardwareMap.get(DcMotorEx.class, "motor0");
        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");

        motor0.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor1.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        waitForStart();

        if (opModeIsActive()){

            while(digitalTouch.getState() == true) {

                if(color.blue() < 400){              //not found
                    motor0.setVelocity(0);
                    motor1.setVelocity(1000);
                    motor2.setVelocity(0);
                    motor3.setVelocity(1000);
                }
                else if(color.blue() >= 400){        //found
                    motor0.setVelocity(-1000);
                    motor1.setVelocity(0);
                    motor2.setVelocity(-1000);
                    motor3.setVelocity(0);
                }

                telemetry.addData("Blue", color.blue());
                telemetry.update();

            }

            telemetry.addData("out","");
            telemetry.update();
        }

    }
}


//base = 170
//Red line = 1000