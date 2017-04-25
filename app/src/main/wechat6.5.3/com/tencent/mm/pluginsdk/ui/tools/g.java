package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;

public interface g {

    public interface a {
        void abH();

        void bp(int i, int i2);

        int bq(int i, int i2);

        void br(int i, int i2);

        void pa();
    }

    void a(a aVar);

    String aOV();

    double aPB();

    long aPC();

    void dJ(boolean z);

    void fD(boolean z);

    void fE(boolean z);

    int getCurrentPosition();

    int getDuration();

    boolean h(Context context, boolean z);

    void i(double d);

    boolean isPlaying();

    void onDetach();

    void pause();

    void setVideoPath(String str);

    boolean start();

    void stop();
}
