package com.tencent.mm.ui.a;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.Settings.Secure;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.a.a.AnonymousClass1;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Method;
import java.util.Locale;

@TargetApi(14)
public final class c extends AccessibilityDelegate {
    private boolean nHC = false;

    public c() {
        boolean z;
        a bAK = a.nHA;
        AudioManager audioManager = (AudioManager) bAK.aHq.getSystemService("audio");
        if (!bAK.bAJ() || (Secure.getInt(bAK.aHq.getContentResolver(), "speak_password", 0) == 0 && !audioManager.isWiredHeadsetOn())) {
            z = false;
        } else {
            z = true;
        }
        this.nHC = z;
    }

    public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public final AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
        return null;
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
    }

    public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }

    public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return true;
    }

    public final void sendAccessibilityEvent(View view, int i) {
        if (!this.nHC || view == null) {
            return;
        }
        if (i == FileUtils.S_IWUSR || i == 1) {
            CharSequence text;
            if (view instanceof EditText) {
                EditText editText = (EditText) view;
                text = !be.D(editText.getText()) ? editText.getText() : !be.D(editText.getContentDescription()) ? editText.getContentDescription() : editText.getHint() != null ? editText.getHint() : null;
            } else {
                text = view instanceof TextView ? be.D(view.getContentDescription()) ? ((TextView) view).getText() : view.getContentDescription() : view.getContentDescription();
            }
            v.d("MicroMsg.MMSecureAccessibilityDelegate", "speak content: %s", text);
            if (!be.D(text)) {
                a bAK = a.nHA;
                String charSequence = text.toString();
                if (bAK.nHy == null) {
                    bAK.nHy = new TextToSpeech(bAK.aHq, new AnonymousClass1(bAK, charSequence));
                } else {
                    bAK.nHy.setLanguage(u.bsU() ? Locale.CHINESE : Locale.ENGLISH);
                    bAK.nHy.speak(charSequence, 0, null);
                }
                Class cls = View.class;
                try {
                    Method method = cls.getMethod("clearAccessibilityFocus", new Class[0]);
                    method.setAccessible(true);
                    method.invoke(view, new Object[0]);
                    Method method2 = cls.getMethod("requestAccessibilityFocus", new Class[0]);
                    method2.setAccessible(true);
                    method2.invoke(view, new Object[0]);
                } catch (Throwable e) {
                    v.a("MicroMsg.Accessibility.AccessibilityHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                if (bAK.ewK != null) {
                    bAK.ewK = (Vibrator) aa.getContext().getSystemService("vibrator");
                }
                if (bAK.ewK != null) {
                    bAK.ewK.vibrate(50);
                }
            }
        }
    }

    public final void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
    }
}
