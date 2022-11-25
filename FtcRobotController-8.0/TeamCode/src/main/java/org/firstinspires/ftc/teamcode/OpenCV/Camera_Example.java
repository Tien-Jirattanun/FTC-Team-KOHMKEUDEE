package org.firstinspires.ftc.teamcode.OpenCV;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

import java.util.ArrayList;

@Autonomous(name = "AR and Run")
public class Camera_Example extends LinearOpMode
{

    int encoderData = 0;
    OpenCvCamera camera;
    AprilTagDetectionPipeline aprilTagDetectionPipeline;

    static final double FEET_PER_METER = 3.28084;

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
    double fx = 578.272;
    double fy = 578.272;
    double cx = 402.145;
    double cy = 221.506;

    // UNITS ARE METERS
    double tagsize = 0.166;

    //int ID_TAG_OF_INTEREST = 18; // Tag ID 18 from the 36h11 family
    //tags of sleeve

    int one = 7;
    int two = 3;
    int three = 13;

    AprilTagDetection tagOfInterest = null;



    @Override
    public void runOpMode()
    {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);

        camera.setPipeline(aprilTagDetectionPipeline);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                camera.startStreaming(800,448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode)
            {

            }
        });

        telemetry.setMsTransmissionInterval(50);
        while (!isStarted() && !isStopRequested())
        {
            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();

            if(currentDetections.size() != 0)
            {
                boolean tagFound = false;

                for(AprilTagDetection tag : currentDetections)
                {
                    if(tag.id == one || tag.id == two || tag.id == three)
                    {
                        tagOfInterest = tag;
                        tagFound = true;
                        break;
                    }
                }

                if(tagFound)
                {
                    telemetry.addLine("Tag of interest is in sight!\n\nLocation data:");
                    tagToTelemetry(tagOfInterest);
                }
                else
                {
                    telemetry.addLine("Don't see tag of interest :(");

                    if(tagOfInterest == null)
                    {
                        telemetry.addLine("(The tag has never been seen)");
                    }
                    else
                    {
                        telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                        tagToTelemetry(tagOfInterest);
                    }
                }

            }
            else
            {
                telemetry.addLine("Don't see tag of interest :(");

                if(tagOfInterest == null)
                {
                    telemetry.addLine("(The tag has never been seen)");
                }
                else
                {
                    telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                    tagToTelemetry(tagOfInterest);
                }

            }

            telemetry.update();
            sleep(20);
        }

        //motor and servo zone

        DcMotorEx motor0;                     //RIGHT motor
        DcMotorEx motor1;                     //LEFT motor
        DcMotorEx motor2;
        DcMotorEx motor3;

        DcMotorEx motor4;

        if (opModeIsActive()) {
            motor0 = hardwareMap.get(DcMotorEx.class, "motor0");
            motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
            motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
            motor3 = hardwareMap.get(DcMotorEx.class, "motor3");
            motor4 = hardwareMap.get(DcMotorEx.class, "motor4");

            motor0.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
            motor1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
            motor2.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
            motor3.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

            waitForStart();

            motor4.setTargetPosition(encoderData);
            motor4.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
            motor4.setVelocity(1440);




            //after the run
            if (tagOfInterest.id == one){
                telemetry.addData("task","Go One");
                telemetry.update();

                //High junction
                motor0.setTargetPosition(-2360);
                motor1.setTargetPosition(2360);
                motor2.setTargetPosition(-2360);
                motor3.setTargetPosition(2360);

            }
            else if(tagOfInterest.id == two){
                telemetry.addData("task","Go Two");
                telemetry.update();
                //High junction
                motor0.setTargetPosition(-2360);
                motor1.setTargetPosition(2360);
                motor2.setTargetPosition(-2360);
                motor3.setTargetPosition(2360);
            }
            else if(tagOfInterest.id == three){
                telemetry.addData("task", "Go Three");
                telemetry.update();
                //High junction
                motor0.setTargetPosition(-2360);
                motor1.setTargetPosition(2360);
                motor2.setTargetPosition(-2360);
                motor3.setTargetPosition(2360);
            }


        }
    }


    //meter cal
    private int meterCal(int S){            //cm

        int thick = (int) ((((S / 5) * 360) / (2 * 3.14)) * 1440) / 360;

        return thick;
    }

    void tagToTelemetry(AprilTagDetection detection)
    {
        telemetry.addLine(String.format("\nDetected tag ID=%d", detection.id));
        telemetry.addLine(String.format("Translation X: %.2f feet", detection.pose.x*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Y: %.2f feet", detection.pose.y*FEET_PER_METER));
        telemetry.addLine(String.format("Translation Z: %.2f feet", detection.pose.z*FEET_PER_METER));
        telemetry.addLine(String.format("Rotation Yaw: %.2f degrees", Math.toDegrees(detection.pose.yaw)));
        telemetry.addLine(String.format("Rotation Pitch: %.2f degrees", Math.toDegrees(detection.pose.pitch)));
        telemetry.addLine(String.format("Rotation Roll: %.2f degrees", Math.toDegrees(detection.pose.roll)));
    }
}