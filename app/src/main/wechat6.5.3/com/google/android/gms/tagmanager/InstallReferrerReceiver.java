package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    protected final Class<? extends CampaignTrackingService> hk() {
        return InstallReferrerService.class;
    }

    protected final void t(String str) {
        l.am(str);
    }
}
