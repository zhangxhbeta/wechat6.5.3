package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import com.tencent.mm.compatible.b.e.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class c implements a {
    private AcousticEchoCanceler caZ = null;

    @TargetApi(16)
    public c(AudioRecord audioRecord) {
        boolean isAvailable = AcousticEchoCanceler.isAvailable();
        v.d("MicroMsg.MMAcousticEchoCanceler", "available  " + isAvailable);
        if (isAvailable) {
            this.caZ = AcousticEchoCanceler.create(audioRecord.getAudioSessionId());
        }
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        return AcousticEchoCanceler.isAvailable();
    }

    @TargetApi(16)
    public final boolean qQ() {
        if (this.caZ != null) {
            try {
                int enabled = this.caZ.setEnabled(true);
                if (enabled == 0) {
                    return true;
                }
                v.d("MicroMsg.MMAcousticEchoCanceler", "setEnabled failed " + enabled);
            } catch (Throwable e) {
                v.a("MicroMsg.MMAcousticEchoCanceler", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return false;
    }
}
