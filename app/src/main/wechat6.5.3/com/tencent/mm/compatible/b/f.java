package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AutomaticGainControl;
import com.tencent.mm.compatible.b.e.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class f implements a {
    private AutomaticGainControl cbp = null;

    @TargetApi(16)
    public f(AudioRecord audioRecord) {
        boolean isAvailable = AutomaticGainControl.isAvailable();
        v.d("MicroMsg.MMAutomaticGainControl", "available  " + isAvailable);
        if (isAvailable) {
            this.cbp = AutomaticGainControl.create(audioRecord.getAudioSessionId());
        }
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        return AutomaticGainControl.isAvailable();
    }

    @TargetApi(16)
    public final boolean qQ() {
        if (this.cbp != null) {
            try {
                int enabled = this.cbp.setEnabled(true);
                if (enabled == 0) {
                    return true;
                }
                v.d("MicroMsg.MMAutomaticGainControl", "setEnabled failed " + enabled);
            } catch (Throwable e) {
                v.a("MicroMsg.MMAutomaticGainControl", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return false;
    }
}
