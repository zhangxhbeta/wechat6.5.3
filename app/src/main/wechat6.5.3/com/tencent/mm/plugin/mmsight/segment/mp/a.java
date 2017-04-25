package com.tencent.mm.plugin.mmsight.segment.mp;

import android.view.Surface;

public interface a {

    public interface a {
        boolean bT(int i, int i2);
    }

    public interface b {
        void aN(Object obj);
    }

    public interface c {
    }

    public interface d {
        void bS(int i, int i2);
    }

    void a(a aVar);

    void a(b bVar);

    void a(d dVar);

    int getCurrentPosition();

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void seekTo(int i);

    void setAudioStreamType(int i);

    void setDataSource(String str);

    void setLooping(boolean z);

    void setSurface(Surface surface);

    void start();

    void stop();
}
