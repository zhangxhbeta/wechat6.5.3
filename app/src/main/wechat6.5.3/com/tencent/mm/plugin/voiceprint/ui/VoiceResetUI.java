package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.v;

public class VoiceResetUI extends VoiceUnLockUI {
    protected final void bbh() {
        v.d("MicroMsg.VoiceResetUI", "unlock success");
        startActivity(new Intent(this, VoiceCreateUI.class));
        finish();
    }
}
