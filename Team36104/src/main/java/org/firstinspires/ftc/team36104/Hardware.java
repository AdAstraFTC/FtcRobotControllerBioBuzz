/* Copyright (c) 2026 Coach Chris Lemoine — Team00000
 *
 * SCAFFOLDED VERSION — MentorBotHardware
 *
 * Team00000 is a reference and demonstration platform.
 * Students are expected to study the reference and recreate equivalent functionality
 * in their own team’s codebase.
 *
 * Work through each TODO and implement the required logic.
 */

package org.firstinspires.ftc.team36104;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver.EncoderDirection;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver.GoBildaOdometryPods;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class Hardware {

    /* =====================================================
     * HARDWARE OBJECTS
     * ===================================================== */
    private DcMotor frontLeftDrive  = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive   = null;
    private DcMotor backRightDrive  = null;

    private GoBildaPinpointDriver pinpoint = null;

    /* =====================================================
     * CONFIGURATION CONSTANTS
     * ===================================================== */
    public static final String FRONT_LEFT_NAME  = "frontLeftDrive";
    public static final String FRONT_RIGHT_NAME = "frontRightDrive";
    public static final String BACK_LEFT_NAME   = "backLeftDrive";
    public static final String BACK_RIGHT_NAME  = "backRightDrive";
    public static final String PINPOINT_NAME    = "pinpoint";

    private static final double PINPOINT_X_OFFSET_MM = 0.0;
    private static final double PINPOINT_Y_OFFSET_MM = 0.0;

    private static final GoBildaOdometryPods PODS = GoBildaOdometryPods.goBILDA_4_BAR_POD;
    private static final EncoderDirection X_ENCODER_DIRECTION = EncoderDirection.FORWARD;
    private static final EncoderDirection Y_ENCODER_DIRECTION = EncoderDirection.FORWARD;

    /* =====================================================
     * CONSTRUCTOR
     * ===================================================== */
    public Hardware(HardwareMap hardwareMap) {
        initDriveMotors(hardwareMap);
        initPinpoint(hardwareMap);
    }

    /* =====================================================
     * INITIALIZATION — IMPLEMENT THESE
     * ===================================================== */

    private void initDriveMotors(HardwareMap hardwareMap) {
        // TODO 1: Get the four drive motors from hardwareMap
        // frontLeftDrive  = hardwareMap.get(DcMotor.class, FRONT_LEFT_NAME);
        // frontRightDrive = hardwareMap.get(DcMotor.class, FRONT_RIGHT_NAME);
        // backLeftDrive   = hardwareMap.get(DcMotor.class, BACK_LEFT_NAME);
        // backRightDrive  = hardwareMap.get(DcMotor.class, BACK_RIGHT_NAME);

        // TODO 2: Set motor directions (consistent order: FL, FR, BL, BR)
        // frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        // frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        // backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        // backRightDrive.setDirection(DcMotor.Direction.FORWARD);

        // TODO 3: Set ZeroPowerBehavior.BRAKE on all motors
        // TODO 4: Set RunMode.RUN_WITHOUT_ENCODER on all motors
    }

    private void initPinpoint(HardwareMap hardwareMap) {
        // TODO 5: Get the Pinpoint device
        // pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, PINPOINT_NAME);

        // TODO 6: Configure the Pinpoint
        // pinpoint.setOffsets(PINPOINT_X_OFFSET_MM, PINPOINT_Y_OFFSET_MM, DistanceUnit.MM);
        // pinpoint.setEncoderResolution(PODS);
        // pinpoint.setEncoderDirections(X_ENCODER_DIRECTION, Y_ENCODER_DIRECTION);

        // TODO 7: Reset position and IMU
        // pinpoint.resetPosAndIMU();
    }

    /* =====================================================
     * DRIVE METHODS — IMPLEMENT THESE
     * ===================================================== */

    public void driveRobot(double axial, double lateral, double yaw) {
        // TODO 8: Calculate power for each wheel using mecanum equations
        // TODO 9: Normalize the four wheel powers
        // TODO 10: Call setDrivePower(...) with the normalized values
    }

    public void setDrivePower(double frontLeft, double frontRight, double backLeft, double backRight) {
        // TODO 11: Send power to the four motors using Range.clip
    }

    public void stopDrive() {
        setDrivePower(0, 0, 0, 0);
    }

    /* =====================================================
     * ODOMETRY / PINPOINT METHODS — IMPLEMENT THESE
     * ===================================================== */

    public void updatePose() {
        // TODO 12: Call pinpoint.update()
    }

    public Pose2D getPose() {
        // TODO 13: Return the current pose from the Pinpoint
        return new Pose2D(DistanceUnit.MM, 0, 0, AngleUnit.DEGREES, 0);
    }

    public double getX(DistanceUnit unit) {
        return getPose().getX(unit);
    }

    public double getY(DistanceUnit unit) {
        return getPose().getY(unit);
    }

    public double getHeading(AngleUnit unit) {
        return getPose().getHeading(unit);
    }

    public void resetPose() {
        // TODO 14: Reset the Pinpoint position and IMU
    }

    public boolean isPinpointReady() {
        // TODO 15: Return whether the Pinpoint is ready
        return false;
    }

    public void recalibratePinpoint() {
        // TODO 16: Trigger a fresh reset + IMU recalibration
    }

    public GoBildaPinpointDriver getPinpoint() {
        return pinpoint;
    }

    /* =====================================================
     * TELEMETRY HELPERS (optional)
     * ===================================================== */
    public void addDriveTelemetry(org.firstinspires.ftc.robotcore.external.Telemetry telemetry) {
        // Optional
    }

    public void addPoseTelemetry(org.firstinspires.ftc.robotcore.external.Telemetry telemetry,
                                 DistanceUnit distUnit, AngleUnit angleUnit) {
        // Optional
    }
}