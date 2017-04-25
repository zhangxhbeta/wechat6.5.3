package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.media.audiofx.NoiseSuppressor;
import com.tencent.mm.compatible.b.e.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class g implements a {
    private NoiseSuppressor cbq = null;

    @TargetApi(16)
    public g(AudioRecord audioRecord) {
        boolean isAvailable = NoiseSuppressor.isAvailable();
        v.d("MicroMsg.MMNoiseSuppressor", "available  " + isAvailable);
        if (isAvailable) {
            this.cbq = NoiseSuppressor.create(audioRecord.getAudioSessionId());
        }
    }

    @TargetApi(16)
    public final boolean isAvailable() {
        return NoiseSuppressor.isAvailable();
    }

    @TargetApi(16)
    public final boolean qQ() {
        if (this.cbq != null) {
            try {
                int enabled = this.cbq.setEnabled(true);
                if (enabled == 0) {
                    return true;
                }
                v.d("MicroMsg.MMNoiseSuppressor", "setEnabled failed " + enabled);
            } catch (Throwable e) {
                v.a("MicroMsg.MMNoiseSuppressor", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return false;
    }
}
