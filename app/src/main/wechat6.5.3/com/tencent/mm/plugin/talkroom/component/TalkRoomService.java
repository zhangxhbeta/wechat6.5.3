package com.tencent.mm.plugin.talkroom.component;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.v;

public class TalkRoomService extends Service {
    private g kjS;

    static {
        v.i("MicroMsg.TalkRoomService", Thread.currentThread().getId());
    }

    public void onCreate() {
        v.d("MicroMsg.TalkRoomService", "onCreate~~~threadID:" + Thread.currentThread());
        super.onCreate();
        if (VERSION.SDK_INT < 18) {
            startForeground(9999, new Notification());
        }
        if (this.kjS == null) {
            this.kjS = new g();
        }
    }

    public void onDestroy() {
        v.d("MicroMsg.TalkRoomService", "onDestroy~~~ threadID:" + Thread.currentThread());
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        v.d("MicroMsg.TalkRoomService", "onUnbind~~~ threadID:" + Thread.currentThread());
        return super.onUnbind(intent);
    }

    public IBinder onBind(Intent intent) {
        v.d("MicroMsg.TalkRoomService", "onBind~~~ threadID:" + Thread.currentThread());
        return this.kjS;
    }

    public void onRebind(Intent intent) {
        v.d("MicroMsg.TalkRoomService", "onRebind~~~ threadID:" + Thread.currentThread());
        super.onRebind(intent);
    }
}
