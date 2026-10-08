package org.firstinspires.ftc.team36104.pedro;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.team36104.Hardware;

/**
 * Pedro Pathing 3 follower for Team 36104.
 *
 * <p>Drive motor names and directions come from {@link Hardware}. This robot's
 * Hardware class uses the hub IMU and does not own a Pinpoint, so the Pinpoint
 * block below stays in Pedro until that device is added to Hardware.</p>
 */
public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set(Hardware.FRONT_LEFT_NAME);
        c.frontRightName.set(Hardware.FRONT_RIGHT_NAME);
        c.backLeftName.set(Hardware.BACK_LEFT_NAME);
        c.backRightName.set(Hardware.BACK_RIGHT_NAME);
        c.frontLeftDirection.set(Hardware.FRONT_LEFT_DIRECTION);
        c.frontRightDirection.set(Hardware.FRONT_RIGHT_DIRECTION);
        c.backLeftDirection.set(Hardware.BACK_LEFT_DIRECTION);
        c.backRightDirection.set(Hardware.BACK_RIGHT_DIRECTION);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(-153.50);
        c.yPodOffset.set(56.00);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.REVERSED);
        c.offsetUnits.set(DistanceUnit.MM);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(c -> {
        Controller primaryTranslationalForward = Controller.proportional(1);
        Controller secondaryTranslationalForward = Controller.proportional(1);
        Controller primaryTranslationalLateral = Controller.proportional(1);
        Controller secondaryTranslationalLateral = Controller.proportional(1);

        c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
        c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));
        c.coast.set(Controller.proportionalFeedforward(1));
        c.brake.set(Controller.proportionalFeedforward(1));
        c.headingFeedback.set(Controller.proportional(1));
        c.headingBrakeCoefficients.set(Vector2D.cartesian(0, 0));
        c.linearBrakeCoefficients.set(Matrix.diag(0, 0));
        c.quadraticBrakeCoefficients.set(Matrix.diag(0, 0));
        c.maxAchievableForwardVelocity.set(1.0);
        c.maxAchievableStrafeVelocity.set(1.0);
        c.naturalForwardDeceleration.set(1.0);
        c.naturalStrafeDeceleration.set(1.0);
    });

    public static Follower create(HardwareMap hardwareMap) {
        return new Follower(
                new PinpointLocalizer(hardwareMap, localizerConfig),
                new Mecanum(hardwareMap, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }
}
