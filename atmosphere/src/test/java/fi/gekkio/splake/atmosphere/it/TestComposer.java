package fi.gekkio.splake.atmosphere.it;

import java.util.concurrent.TimeUnit;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Label;

public class TestComposer implements Composer<Label>, EventListener<Event> {

    private int counter;

    private Label label;
    private Desktop desktop;

    private final Runnable serverPush = new Runnable() {
        @Override
        public void run() {
            Executions.schedule(desktop, TestComposer.this, new Event("onServerPush", null, null));
        }
    };

    @Override
    public void doAfterCompose(final Label comp) throws Exception {
        this.label = comp;
        this.desktop = comp.getDesktop();

        comp.getDesktop().enableServerPush(true);

        TestThreadPool.executor.schedule(serverPush, 500, TimeUnit.MILLISECONDS);
    }

    @Override
    public void onEvent(Event event) throws Exception {
        if ("onServerPush".equals(event.getName())) {
            counter += 1;
            label.setValue(String.valueOf(counter));

            if (counter < 5)
                TestThreadPool.executor.schedule(serverPush, 200, TimeUnit.MILLISECONDS);
        }
    }

}
