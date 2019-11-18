package com.rudderlabs.android.integration.autocapture;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;

import com.rudderlabs.android.sdk.core.RudderClient;
import com.rudderlabs.android.sdk.core.RudderIntegration;

import java.io.ObjectStreamException;

public class AutoCapturePlugin extends RudderIntegration<Void> {

    public RudderIntegration.Factory FACTORY = new Factory() {
        @Override
        public RudderIntegration<?> create(Object settings, RudderClient client) {
            return null;
        }

        @Override
        public String key() {
            return null;
        }
    };

    private RudderClient client;

    public AutoCapturePlugin(Object settings, RudderClient client) {
        this.client = client;

        initiateAutoCaptureEvents();
    }

    private void initiateAutoCaptureEvents() {
        // initiate click captures
        // initiate touch captures

        client.getApplication().registerActivityLifecycleCallbacks(new RudderActivityLifecycleCallback());
        client.getApplication().registerComponentCallbacks(new ComponentCallbacks() {
            @Override
            public void onConfigurationChanged(Configuration configuration) {

            }

            @Override
            public void onLowMemory() {

            }
        });

    }
}
