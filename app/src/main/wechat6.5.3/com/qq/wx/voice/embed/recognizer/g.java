package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class g {
    c aHe;
    Handler aHf = new h(this);

    public final void a(int i) {
        Message obtainMessage = this.aHf.obtainMessage(100);
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        obtainMessage.setData(bundle);
        this.aHf.sendMessage(obtainMessage);
    }
}
