package com.tencent.wecall.talkroom.model;

import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    talk pHK = new talk();

    public b() {
        c.d("simon:TalkRoomContext", "construct");
    }

    public final int uninitLive() {
        if (!a.poK) {
            return 0;
        }
        int uninit;
        try {
            uninit = this.pHK.uninit();
        } catch (Throwable th) {
            c.i("simon:TalkRoomContext", "uninitLive ", th);
            uninit = 0;
        }
        c.d("simon:TalkRoomContext", "uninitLive ret: ", Integer.valueOf(uninit));
        return uninit;
    }

    public final int Close() {
        if (!a.poK) {
            return 0;
        }
        int close;
        try {
            close = this.pHK.close();
        } catch (Throwable th) {
            c.i("simon:TalkRoomContext", "Close ", th);
            close = 0;
        }
        c.d("simon:TalkRoomContext", "Close ret: ", Integer.valueOf(close));
        return close;
    }

    public final void OnMembersChanged(int[] iArr) {
        if (a.poK) {
            this.pHK.OnMembersChanged(iArr);
        }
    }

    public final byte[] bPs() {
        if (a.poK) {
            return this.pHK.field_capInfo;
        }
        return new byte[0];
    }

    public final int bPt() {
        int i = 0;
        try {
            if (a.poK) {
                AtomicInteger atomicInteger = new AtomicInteger();
                AtomicInteger atomicInteger2 = new AtomicInteger();
                this.pHK.getChannelBytes(atomicInteger, atomicInteger2);
                i = atomicInteger2.get();
            }
        } catch (Throwable th) {
            c.i("simon:TalkRoomContext", "getTotalWWANBytes: ", th);
        }
        return i;
    }
}
