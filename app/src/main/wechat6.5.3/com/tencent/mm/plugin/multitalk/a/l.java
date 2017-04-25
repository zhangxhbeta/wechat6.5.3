package com.tencent.mm.plugin.multitalk.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class l {
    public Map<String, a> hAm = Collections.synchronizedMap(new HashMap());

    private class a {
        public int angle;
        Bitmap hAn;
        Bitmap hAo;
        public Bitmap hAp;
        final /* synthetic */ l hAq;
        public int hzX;
        String username;

        private a(l lVar) {
            this.hAq = lVar;
        }
    }

    public final synchronized boolean a(MultiTalkVideoView multiTalkVideoView, int[] iArr, int i, int i2, int i3, int i4) {
        boolean z;
        if (multiTalkVideoView == null) {
            v.e("MicroMsg.MT.MultiTalkViewManager", "drawVideo view is null");
            z = false;
        } else if (iArr == null) {
            v.e("MicroMsg.MT.MultiTalkViewManager", "renderVideoBitmap img is null");
            z = false;
        } else if (iArr.length < i * i2) {
            v.e("MicroMsg.MT.MultiTalkViewManager", "img length error %d %d", new Object[]{Integer.valueOf(iArr.length), Integer.valueOf(i * i2)});
            z = false;
        } else if (i != i2) {
            v.e("MicroMsg.MT.MultiTalkViewManager", "imgW != imgH");
            z = false;
        } else {
            a aVar;
            a aVar2 = (a) this.hAm.get(multiTalkVideoView.username);
            if (aVar2 == null) {
                aVar2 = new a();
                this.hAm.put(multiTalkVideoView.username, aVar2);
                aVar = aVar2;
            } else {
                aVar = aVar2;
            }
            aVar.hzX = i3;
            aVar.angle = i4;
            if (aVar.hAp == null || aVar.hAp.getWidth() != i2) {
                aVar.hAp = Bitmap.createBitmap(i2, i2, Config.ARGB_8888);
            }
            aVar.hAp.setPixels(iArr, 0, i2, 0, 0, i2, i2);
            multiTalkVideoView.a(aVar.hAp, aVar.angle, aVar.hzX);
            z = true;
        }
        return z;
    }

    public final boolean a(MultiTalkVideoView multiTalkVideoView, boolean z) {
        if (multiTalkVideoView == null) {
            v.e("MicroMsg.MT.MultiTalkViewManager", "drawAvatar view is null");
            return false;
        }
        a aVar;
        if (this.hAm.containsKey(multiTalkVideoView.username)) {
            aVar = (a) this.hAm.get(multiTalkVideoView.username);
        } else {
            aVar = new a();
            aVar.username = multiTalkVideoView.username;
            this.hAm.put(multiTalkVideoView.username, aVar);
        }
        Bitmap a;
        if (aVar.hAn == null) {
            a = b.box().a(multiTalkVideoView.username, multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (a != null && a.getHeight() < a.getWidth()) {
                a = Bitmap.createBitmap(a, 0, 0, a.getHeight(), a.getHeight());
            }
            aVar.hAn = a;
        } else if (z) {
            a = b.box().a(multiTalkVideoView.username, multiTalkVideoView.getMeasuredWidth(), multiTalkVideoView.getMeasuredHeight(), 1);
            if (a != null && a.getHeight() < a.getWidth()) {
                a = Bitmap.createBitmap(a, 0, 0, a.getHeight(), a.getHeight());
            }
            aVar.hAn = a;
        }
        if (aVar.hAn != null) {
            multiTalkVideoView.a(aVar.hAn, 0, 0);
            return true;
        }
        if (aVar.hAo == null) {
            aVar.hAo = BitmapFactory.decodeResource(multiTalkVideoView.getResources(), 2130838721);
        }
        multiTalkVideoView.a(aVar.hAo, 0, 0);
        return true;
    }

    public final void aCA() {
        this.hAm.clear();
    }
}
