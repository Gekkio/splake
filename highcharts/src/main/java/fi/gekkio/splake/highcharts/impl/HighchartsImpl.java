package fi.gekkio.splake.highcharts.impl;

import fi.gekkio.splake.highcharts.Highcharts;
import fi.gekkio.splake.highcharts.PointSeries.Point;

public final class HighchartsImpl {

    private HighchartsImpl() {
    }

    public static Highcharts.Options createOptions() {
        return new OptionsImpl();
    }

    public static Point createPoint() {
        return new PointImpl();
    }

}
