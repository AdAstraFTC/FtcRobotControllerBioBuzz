package org.firstinspires.ftc.team00000.pedro;

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
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.team00000.Hardware;

/**
 * Pedro Pathing 3 follower for the mentor bot.
 *
 * <p>Motor names, directions, and Pinpoint geometry come from {@link Hardware.Config}.
 * Foresight coefficients stay here. They are path-following tuning, not robot wiring.
 * Poses are in inches so autonomous distances match the field drawings.</p>
 */
public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set(Hardware.Config.FRONT_LEFT_NAME);
        c.frontRightName.set(Hardware.Config.FRONT_RIGHT_NAME);
        c.backLeftName.set(Hardware.Config.BACK_LEFT_NAME);
        c.backRightName.set(Hardware.Config.BACK_RIGHT_NAME);
        c.frontLeftDirection.set(Hardware.Config.FRONT_LEFT_DIRECTION);
        c.frontRightDirection.set(Hardware.Config.FRONT_RIGHT_DIRECTION);
        c.backLeftDirection.set(Hardware.Config.BACK_LEFT_DIRECTION);
        c.backRightDirection.set(Hardware.Config.BACK_RIGHT_DIRECTION);
    });

    public static PinpointConfig localizerConfig = new PinpointConfig(c -> {
        c.name.set(Hardware.Config.PINPOINT_NAME);
        c.podType.set(Hardware.Config.PODS);
        // goBILDA setOffsets(x, y): x is the forward pod's sideways offset, y is the strafe pod's forward offset.
        c.xPodOffset.set(Hardware.Config.FORWARD_POD_Y_MM);
        c.yPodOffset.set(Hardware.Config.STRAFE_POD_X_MM);
        c.xPodDirection.set(Hardware.Config.FORWARD_ENCODER_DIRECTION);
        c.yPodDirection.set(Hardware.Config.STRAFE_ENCODER_DIRECTION);
        c.offsetUnits.set(Hardware.Config.PINPOINT_DISTANCE_UNIT);
        c.globalDistanceUnit.set(DistanceUnit.INCH);
    });

    public static ForesightConfig foresightConfig = new ForesightConfig(c -> {
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
    });

    public static Follower create(HardwareMap hardwareMap) {
        return new Follower(
                new PinpointLocalizer(hardwareMap, localizerConfig),
                new Mecanum(hardwareMap, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }
}
