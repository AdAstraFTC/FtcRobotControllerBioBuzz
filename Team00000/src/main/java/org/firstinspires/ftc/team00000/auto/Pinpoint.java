package org.firstinspires.ftc.team00000.auto;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.team00000.Hardware;

@Autonomous(name = "DriveByPinpoint (Iterative)", group = "Auto")
public class Pinpoint extends OpMode {

    private Hardware hardware;

    // === Autonomous Steps ===
    private int step = 0;

    // === Parameters ===
    private static final double DRIVE_SPEED = 0.5;
    private static final double TURN_SPEED = 0.4;

    @Override
    public void init() {
        hardware = new Hardware(hardwareMap);
        hardware.resetPose();
        telemetry.addLine("Initialized. Ready to run");
    }

    @Override
    public void loop() {
        hardware.updatePose();

        switch (step) {
            case 0: // Drive forward 24 inches
                if (driveStraight(24, DRIVE_SPEED, 0)) {
                    step++;
                }
                break;
            case 1: // Turn to 90 degrees (left)
                if (turnToHeading(90, TURN_SPEED)) {
                    step++;
                }
                break;
            case 2: // Drive forward another 24 inches
                if (driveStraight(24, DRIVE_SPEED, 0)) {
                    step++;
                }
                break;
            case 3: // Stop
                hardware.stopDrive();
                telemetry.addLine("Autonomous Complete");
                break;
        }
    }

    /**
     * Drives straight a certain distance while holding a target heading.
     * Return true when the distance is reached.
     */
    private boolean driveStraight(double inches, double power, double targetHeadingDeg) {
        double currentX = hardware.getX(DistanceUnit.INCH);
        double currentHeading = hardware.getHeading(AngleUnit.DEGREES);

        double headingError = targetHeadingDeg - currentHeading;
        double correction = headingError * 0.025; // Simple P gain

        if (currentX < inches) {
            hardware.driveRobotCentric(power, 0, correction);
            return false;
        } else {
            hardware.stopDrive();
            return true;
        }
    }

    private boolean turnToHeading(double targetHeadingDeg, double power) {
        double currentHeading = hardware.getHeading(AngleUnit.DEGREES);
        double headingError = targetHeadingDeg - currentHeading;

        // Normalize error between -180 and 180 degrees
        while (headingError > 180) headingError -= 360;
        while (headingError < -180) headingError += 360;

        if (Math.abs(headingError) > 2) { // 2 degree tolerance
            double turnPower = Math.signum(headingError) * power;
            hardware.driveRobotCentric(0, 0, turnPower);
            return false;
        } else {
            hardware.stopDrive();
            return true;
        }
    }
}
