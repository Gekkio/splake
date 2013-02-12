package fi.gekkio.splake.highcharts;

public interface SeriesDeltaListener<P> {

    void onDelta(SeriesDelta<? extends P> delta);

}
