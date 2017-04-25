package com.tencent.mm.plugin.sight.encode.a;

import android.hardware.Camera.PreviewCallback;

public interface b {

    public interface a {
        void aPT();

        void onError();

        void onStart();

        void onStop();
    }

    public enum b {
        WaitStart,
        Start,
        PrepareStop,
        WaitStop,
        Stop,
        WaitSend,
        Sent,
        Error,
        Initialized,
        Pause
    }

    void a(a aVar);

    void a(b bVar);

    float aAh();

    b aAk();

    boolean aPO();

    long aPP();

    void aPQ();

    String aPR();

    PreviewCallback aPS();

    void b(a aVar);

    void cancel();

    void cv(String str, String str2);

    int getDuration();

    int getFrameCount();

    void initialize(int i);

    void reset();

    void s(Runnable runnable);
}
