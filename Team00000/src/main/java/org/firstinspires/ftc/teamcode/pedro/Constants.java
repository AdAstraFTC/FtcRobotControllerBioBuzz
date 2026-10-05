package org.firstinspires.ftc.teamcode.pedro;

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
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Official Pedro Pathing 3 constants (Quickstart layout).
 * After AutoTune, paste generated Java from the Java tab over these configs.
 */
public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("frontLeftDrive");
        c.frontRightName.set("frontRightDrive");
        c.backLeftName.set("backLeftDrive");
        c.backRightName.set("backRightDrive");
        c.frontLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.frontRightDirection.set(DcMotorSimple.Direction.FORWARD);
        c.backLeftDirection.set(DcMotorSimple.Direction.REVERSE);
        c.backRightDirection.set(DcMotorSimple.Direction.FORWARD);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set("pinpoint");
        c.podType.set(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        c.xPodOffset.set(-7.321552667092151);
        c.yPodOffset.set(-3.2495591771884227);
        c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
        c.offsetUnits.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.22617873910962438);
                Controller secondaryTranslationalForward = Controller.proportional(0.08356700049379048);
                Controller primaryTranslationalLateral = Controller.proportional(0.3763206032222293);
                Controller secondaryTranslationalLateral = Controller.proportional(0.1390404074189014);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.01511253431105898));
                c.brake.set(Controller.proportionalFeedforward(0.012845654164400132));

                c.headingFeedback.set(Controller.proportional(3.5092825117726507));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.04699506328929273, 0.0065988500427560754));

                c.linearBrakeCoefficients.set(Matrix.diag(0.06634817074206803, 0.056581850244749744));
                c.quadraticBrakeCoefficients.set(Matrix.diag(9.907462500036675E-4, 0.0013314981357841352));

                c.maxAchievableForwardVelocity.set(77.39104901467698);
                c.maxAchievableStrafeVelocity.set(63.654735708257554);
                c.naturalForwardDeceleration.set(61.60668602527794);
                c.naturalStrafeDeceleration.set(85.18275325954738);
            }
    );

    public static Follower create(HardwareMap hardwareMap) {
        return new Follower(
                new PinpointLocalizer(hardwareMap, localizerConfig),
                new Mecanum(hardwareMap, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }
}
