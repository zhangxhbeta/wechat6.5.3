package com.tencent.mm.pluginsdk.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.w.d;
import com.tencent.mm.model.ak;

public class DownloadReceiver extends ResultReceiver {
    private static final String TAG = DownloadReceiver.class.getSimpleName();
    private d lyE;

    protected void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        if (i == 4657) {
            int i2 = bundle.getInt("progress");
            if (i2 < 100) {
                this.lyE.b(100, i2, false).b("Download in progress:" + i2);
                ak.oH().notify(4657, this.lyE.build());
                return;
            }
            this.lyE.b(0, 0, false).b("Download Complete");
            ak.oH().notify(4658, this.lyE.build());
        }
    }
}
