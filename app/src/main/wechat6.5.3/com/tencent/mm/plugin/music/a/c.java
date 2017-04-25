package com.tencent.mm.plugin.music.a;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    OnAudioFocusChangeListener hCt = new OnAudioFocusChangeListener(this) {
        final /* synthetic */ c hCu;

        {
            this.hCu = r1;
        }

        public final void onAudioFocusChange(int i) {
            v.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[]{Integer.valueOf(i)});
            if (i == -2 || i == -3) {
                v.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
                if (i.aDd().hCQ.hCI) {
                    i.aDd().hCQ.pause();
                }
            } else if (i == 1 || i == 2 || i == 3) {
                v.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
                if (i.aDd().hCQ.hCI) {
                    i.aDd().hCQ.resume();
                }
            } else if (i == -1) {
                v.d("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss");
                if (i.aDd().hCQ.hCI) {
                    i.aDd().hCQ.XV();
                }
                i.aDf().abandonAudioFocus(this.hCu.hCt);
            }
        }
    };

    public final boolean requestFocus() {
        boolean z;
        int requestAudioFocus = i.aDf().requestAudioFocus(this.hCt, 3, 2);
        String str = "MicroMsg.Music.MusicAudioFocusHelper";
        String str2 = "request audio focus %b";
        Object[] objArr = new Object[1];
        if (requestAudioFocus == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        if (requestAudioFocus == 1) {
            return true;
        }
        return false;
    }

    public final void aCU() {
        v.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        i.aDf().abandonAudioFocus(this.hCt);
    }
}
