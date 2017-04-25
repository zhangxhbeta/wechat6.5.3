package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.an;

public final class a {
    public static boolean a(AudioManager audioManager) {
        if (an.brE) {
            return false;
        }
        if (p.ceJ.cdo == 1 || p.ceJ.cdp == -1) {
            audioManager.setBluetoothScoOn(false);
        }
        if (p.ceJ.cdo == 1 || p.ceJ.cdp == -1) {
            audioManager.stopBluetoothSco();
        }
        return true;
    }
}
