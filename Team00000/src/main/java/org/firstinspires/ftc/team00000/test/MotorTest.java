package org.firstinspires.ftc.team00000.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.team00000.Hardware;
@Disabled
@TeleOp(name = "Motor Test (No Gamepad)", group = "Test")
public class MotorTest extends LinearOpMode {

    private Hardware hardware;

    @Override
    public void runOpMode() {
        hardware = new Hardware(hardwareMap);
        hardware.resetPose();

        // Get motors (update names to match your config)
        DcMotor frontLeft  = hardwareMap.get(DcMotor.class, "frontLeftDrive");
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "frontRightDrive");
        DcMotor backLeft   = hardwareMap.get(DcMotor.class, "backLeftDrive");
        DcMotor backRight  = hardwareMap.get(DcMotor.class, "backRightDrive");

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addLine("Motor Test Ready. Motors will run in sequence.");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Simple test sequence
            telemetry.addLine("Running frontLeft...");
            telemetry.update();
            frontLeft.setPower(0.4);
            sleep(1500);
            frontLeft.setPower(0);

            telemetry.addLine("Running frontRight...");
            telemetry.update();
            frontRight.setPower(0.4);
            sleep(1500);
            frontRight.setPower(0);

            telemetry.addLine("Running backLeft...");
            telemetry.update();
            backLeft.setPower(0.4);
            sleep(1500);
            backLeft.setPower(0);

            telemetry.addLine("Running backRight...");
            telemetry.update();
            backRight.setPower(0.4);
            sleep(1500);
            backRight.setPower(0);

            telemetry.addLine("Running positive Axial...");
            telemetry.update();
            hardware.driveRobotCentric(0.4, 0, 0);
            sleep(1500);
            hardware.stopDrive();

            telemetry.addLine("Test cycle complete. Restart OpMode to run again.");
            telemetry.update();
            sleep(2000);
        }
    }
}