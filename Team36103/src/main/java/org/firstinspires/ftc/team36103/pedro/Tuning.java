package org.firstinspires.ftc.team36103.pedro;

import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.pedropathing.tuning.autotune.Procedure;
import com.pedropathing.tuning.autotune.Tuner;

import org.firstinspires.ftc.team36103.pedro.procedures.ForesightTuner;
import org.firstinspires.ftc.team36103.pedro.procedures.MecanumTuner;
import org.firstinspires.ftc.team36103.pedro.procedures.PinpointTuner;
import org.firstinspires.ftc.team36103.pedro.procedures.Tests;

/**
 * AutoTune registration. TunerScan publishes these methods from this team
 * package. After deploy, open {@code http://192.168.43.1:10158} on robot Wi-Fi.
 */
public class Tuning {
    @Tuner
    public static Procedure mecanumTuner() {
        return new MecanumTuner();
    }

    @Tuner
    public static Procedure pinpointTuner() {
        return new PinpointTuner();
    }

    @Tuner
    public static Procedure tests() {
        return new Tests(
                hardwareMap -> new Mecanum(hardwareMap, Constants.drivetrainConfig),
                hardwareMap -> new PinpointLocalizer(hardwareMap, Constants.localizerConfig),
                null
        );
    }

    @Tuner
    public static Procedure foresightTuner() {
        return new ForesightTuner(
                hardwareMap -> new PinpointLocalizer(hardwareMap, Constants.localizerConfig),
                hardwareMap -> new Mecanum(hardwareMap, Constants.drivetrainConfig)
        );
    }
}
