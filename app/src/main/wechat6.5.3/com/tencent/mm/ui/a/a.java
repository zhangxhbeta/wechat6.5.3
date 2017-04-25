package com.tencent.mm.ui.a;

import android.content.Context;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.u;
import java.util.Locale;

public final class a {
    public Context aHq;
    Vibrator ewK;
    private AccessibilityManager jk;
    TextToSpeech nHy = null;

    class AnonymousClass1 implements OnInitListener {
        final /* synthetic */ String dpn;
        final /* synthetic */ a nHz;

        AnonymousClass1(a aVar, String str) {
            this.nHz = aVar;
            this.dpn = str;
        }

        public final void onInit(int i) {
            if (this.nHz.nHy != null) {
                this.nHz.nHy.setLanguage(u.bsU() ? Locale.CHINESE : Locale.ENGLISH);
                this.nHz.nHy.speak(this.dpn, 0, null);
            }
        }
    }

    private static class a {
        private static final a nHA = new a(aa.getContext());
    }

    public a(Context context) {
        this.aHq = context;
        this.jk = (AccessibilityManager) this.aHq.getSystemService("accessibility");
    }

    public final boolean bAJ() {
        return this.jk.isEnabled() && this.jk.isTouchExplorationEnabled();
    }

    public final void a(View view, String str, int i, String str2, String str3) {
        if (bAJ() && this.aHq != null && view != null && str != null && str2 != null && str3 != null) {
            b bVar = new b();
            bVar.Of(str);
            if (i > 0) {
                bVar.Of(this.aHq.getResources().getQuantityString(2131361796, 1, new Object[]{Integer.valueOf(i)}));
            }
            bVar.Of(str2).Of(str3);
            bVar.cy(view);
        }
    }
}
