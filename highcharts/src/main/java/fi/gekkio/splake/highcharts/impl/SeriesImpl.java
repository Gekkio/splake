package fi.gekkio.splake.highcharts.impl;

import org.zkoss.json.JSONObject;

import fi.gekkio.splake.highcharts.Color;
import fi.gekkio.splake.highcharts.Highcharts;
import fi.gekkio.splake.highcharts.Highcharts.Value;

class SeriesImpl extends OptionBase implements Highcharts.Options.Series {

    private Value<Color> color;
    private Value<String> name;

    private Marker marker;

    static class MarkerImpl extends OptionBase implements Highcharts.Options.Series.Marker {

        private Value<Boolean> enabled;

        @Override
        public Value<Boolean> enabled() {
            if (enabled == null)
                enabled = new Value<Boolean>();
            return enabled;
        }

        @Override
        protected void writeJsonOutput(JSONObject json) {
            writeValue(json, "enabled", enabled);
        }

    }

    @Override
    public Value<Color> color() {
        if (color == null)
            color = new Value<Color>();
        return color;
    }

    @Override
    public Value<String> name() {
        if (name == null)
            name = new Value<String>();
        return name;
    }

    @Override
    public Marker marker() {
        if (marker == null)
            marker = new MarkerImpl();
        return marker;
    }

    @Override
    protected void writeJsonOutput(JSONObject json) {
        writeValue(json, "color", color);
        writeValue(json, "name", name);

        if (marker != null)
            json.put("marker", marker);
    }

}
