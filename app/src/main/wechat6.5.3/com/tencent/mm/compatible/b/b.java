package com.tencent.mm.compatible.b;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class b {

    public enum a {
        PCM,
        AMR,
        SILK,
        SPEEX,
        UNKNOWN
    }

    public static a qP() {
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences(aa.bti(), 0);
        boolean z = p.ceB.cbz != 1;
        if (!sharedPreferences.contains("settings_voicerecorder_mode")) {
            sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", z).commit();
        }
        v.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", Integer.valueOf(p.ceB.cbz), Boolean.valueOf(z), Boolean.valueOf(sharedPreferences.getBoolean("settings_voicerecorder_mode", z)));
        if (sharedPreferences.getBoolean("settings_voicerecorder_mode", z)) {
            return a.PCM;
        }
        return a.AMR;
    }
}
