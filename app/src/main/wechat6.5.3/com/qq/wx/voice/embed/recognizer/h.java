package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;
import android.os.Message;

final class h extends Handler {
    private /* synthetic */ g aHd;

    h(g gVar) {
        this.aHd = gVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 100:
                this.aHd.aHe.cD(message.getData().getInt("errorCode"));
                return;
            case 200:
                this.aHd.aHe.a((a) message.obj);
                return;
            default:
                return;
        }
    }
}
