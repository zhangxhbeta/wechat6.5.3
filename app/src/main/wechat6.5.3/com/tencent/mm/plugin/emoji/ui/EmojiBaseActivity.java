package com.tencent.mm.plugin.emoji.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity extends MMActivity {
    a fgQ;
    b fgR;
    private HandlerThread sM;

    private class a extends ac {
        final /* synthetic */ EmojiBaseActivity fgS;

        a(EmojiBaseActivity emojiBaseActivity, Looper looper) {
            this.fgS = emojiBaseActivity;
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.fgS.f(message);
        }
    }

    private class b extends ac {
        final /* synthetic */ EmojiBaseActivity fgS;

        b(EmojiBaseActivity emojiBaseActivity, Looper looper) {
            this.fgS = emojiBaseActivity;
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.fgS.g(message);
        }
    }

    public abstract void f(Message message);

    public abstract void g(Message message);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sM = e.Lg("EmojiBaseActivity_handlerThread");
        this.sM.start();
        this.fgQ = new a(this, this.sM.getLooper());
        this.fgR = new b(this, getMainLooper());
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!(this.fgQ == null || this.fgQ.getLooper() == null)) {
            this.fgQ.getLooper().quit();
        }
        this.sM = null;
        this.fgQ = null;
        this.fgR = null;
    }

    public final void by(int i, int i2) {
        if (this.fgR != null) {
            this.fgR.sendEmptyMessageDelayed(i, (long) i2);
        }
    }

    public final void h(Message message) {
        if (this.fgR != null) {
            this.fgR.sendMessage(message);
        }
    }

    public final void agG() {
        if (this.fgR != null) {
            this.fgR.removeMessages(131074);
        }
    }
}
