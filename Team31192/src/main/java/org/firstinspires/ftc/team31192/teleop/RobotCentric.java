package org.firstinspires.ftc.team31192.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.team31192.Hardware;

@TeleOp(name = "RobotCentric", group = "TeleOp")
public class RobotCentric extends OpMode {

    private Hardware hardware;

    @Override
    public void init() {
        hardware = new Hardware(hardwareMap);
        hardware.resetPose();
    }

    @Override
    public void loop(){
        hardware.updatePose();

        double axial   = -gamepad1.left_stick_y;
        double lateral =  gamepad1.left_stick_x;
        double yaw     =  gamepad1.right_stick_x;

        hardware.driveRobotCentric(axial, lateral, yaw);
        runIntake();

        // Telemetry
        hardware.addDriveTelemetry(telemetry);
        hardware.addIntakeTelemetry(telemetry);
        hardware.addPoseTelemetry(telemetry, DistanceUnit.MM, AngleUnit.DEGREES);
        telemetry.addData("Mode", "Robot Centric");
        telemetry.update();
    }

    @Override
    public void stop() {
        hardware.stopIntake();
    }

    private void runIntake() {
        hardware.runIntake(
                gamepad2.right_bumper,
                gamepad2.left_bumper,
                gamepad2.a,
                gamepad2.b);
    }
}