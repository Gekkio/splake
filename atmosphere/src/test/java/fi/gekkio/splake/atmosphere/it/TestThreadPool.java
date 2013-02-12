package fi.gekkio.splake.atmosphere.it;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.util.WebAppCleanup;
import org.zkoss.zk.ui.util.WebAppInit;

public class TestThreadPool implements WebAppInit, WebAppCleanup {

    static volatile ScheduledExecutorService executor;

    @Override
    public void cleanup(WebApp wapp) throws Exception {
        if (executor != null) {
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
            executor = null;
        }
    }

    @Override
    public void init(WebApp wapp) throws Exception {
        if (executor == null)
            executor = Executors.newScheduledThreadPool(1);
    }

}
