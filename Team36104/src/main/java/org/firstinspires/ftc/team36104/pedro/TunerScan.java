package org.firstinspires.ftc.team36104.pedro;

import com.pedropathing.tuning.autotune.TunerScanner;

import dev.frozenmilk.sinister.Scanner;
import dev.frozenmilk.sinister.targeting.EmptySearch;
import dev.frozenmilk.sinister.targeting.SearchTarget;
import dev.frozenmilk.util.graph.Graph;
import dev.frozenmilk.util.graph.rule.AdjacencyRule;

/**
 * Pedro's built-in scanner only visits {@code org.firstinspires.ftc.teamcode}.
 * This scanner visits this team's package so Tuning can live with the rest of
 * the team code. Sinister loads {@link #INSTANCE}.
 */
@SuppressWarnings("unused")
public final class TunerScan implements Scanner {
    public static final TunerScan INSTANCE = new TunerScan();

    private final SearchTarget targets = new EmptySearch().include("org.firstinspires.ftc.team36104");

    private TunerScan() {}

    @Override
    public AdjacencyRule<Scanner, Graph<Scanner>> getLoadAdjacencyRule() {
        return Scanner.INDEPENDENT();
    }

    @Override
    public AdjacencyRule<Scanner, Graph<Scanner>> getUnloadAdjacencyRule() {
        return Scanner.INDEPENDENT();
    }

    @Override
    public SearchTarget getTargets() {
        return targets;
    }

    @Override
    public void scan(ClassLoader loader, Class<?> clazz) {
        TunerScanner.INSTANCE.scan(loader, clazz);
    }

    @Override
    public void unload(ClassLoader loader, Class<?> clazz) {
        TunerScanner.INSTANCE.unload(loader, clazz);
    }
}
