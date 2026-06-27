package org.firstinspires.ftc.team36104.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.team36104.Hardware;

@TeleOp(name = "FieldCentric", group = "OpMode")
public class FieldCentric extends OpMode {

    private Hardware hardware;

    @Override
    public void init() {
        hardware = new Hardware(hardwareMap);
        // TODO: Reset pose if needed
    }

    @Override
    public void loop(){
        hardware.updatePose();

        double axial   = -gamepad1.left_stick_y;
        double lateral =  gamepad1.left_stick_x;
        double yaw     =  gamepad1.right_stick_x;

        // TODO: Call the correct drive method (robot centric)

        // Telemetry
        hardware.addDriveTelemetry(telemetry);
        hardware.addPoseTelemetry(telemetry, DistanceUnit.MM, AngleUnit.DEGREES);
        telemetry.addData("Mode", "Field Centric");
        telemetry.update();
    }
}
