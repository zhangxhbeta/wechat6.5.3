package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import com.tencent.mmdb.FileUtils;

final class r {
    private static r pxt = null;
    Context aHq;
    s pxu = null;

    private r(Context context) {
        this.aHq = context.getApplicationContext();
        this.pxu = new s(this.aHq);
    }

    public static synchronized r fD(Context context) {
        r rVar;
        synchronized (r.class) {
            if (pxt == null) {
                pxt = new r(context);
            }
            rVar = pxt;
        }
        return rVar;
    }

    final void j(Activity activity, int i) {
        s sVar = this.pxu;
        if (!(i != 3 || sVar.bNC() || sVar.pxx == null)) {
            sVar.pxx.pause();
        }
        if (i == 4) {
            sVar.mContext = null;
            if (!(sVar.bNC() || sVar.pxx == null)) {
                sVar.pxx.stopPlayback();
                sVar.pxx = null;
            }
        }
        if (i == 2 && !sVar.bNC()) {
            sVar.mContext = activity;
            if (!(sVar.bNC() || sVar.pxx == null)) {
                if (sVar.pxx.getParent() == null) {
                    Window window = activity.getWindow();
                    FrameLayout frameLayout = (FrameLayout) window.getDecorView();
                    window.addFlags(1024);
                    window.addFlags(FileUtils.S_IWUSR);
                    frameLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                    MediaController mediaController = new MediaController(activity);
                    mediaController.setMediaPlayer(sVar.pxx);
                    sVar.pxx.setMediaController(mediaController);
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    frameLayout.addView(sVar.pxx, layoutParams);
                }
                if (VERSION.SDK_INT >= 8) {
                    sVar.pxx.start();
                }
            }
        }
        if (sVar.bNC()) {
            sVar.pxw.a(sVar.pxv, activity, i);
        }
    }
}
