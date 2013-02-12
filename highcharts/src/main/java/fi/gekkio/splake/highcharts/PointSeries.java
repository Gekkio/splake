package fi.gekkio.splake.highcharts;

import fi.gekkio.splake.highcharts.Highcharts.Value;
import fi.gekkio.splake.highcharts.PointSeries.Point;
import fi.gekkio.splake.highcharts.impl.HighchartsImpl;

public class PointSeries extends SeriesBase<Point> {

    private static final long serialVersionUID = -1667960121067951516L;

    public static interface Point extends RawJsonSupport {
        Value<String> name();

        Value<Double> x();

        Value<Double> y();
    }

    public static Point createPoint() {
        return HighchartsImpl.createPoint();
    }

}
