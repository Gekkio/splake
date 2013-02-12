package fi.gekkio.splake.highcharts;

import java.util.List;

import fi.gekkio.splake.highcharts.Highcharts.Value;

public interface HighchartsSeries<P> extends List<P> {

    Value<Animation> animation();

    void addSeriesDeltaListener(SeriesDeltaListener<? super P> l);

    void removeSeriesDeltaListener(SeriesDeltaListener<? super P> l);

}
