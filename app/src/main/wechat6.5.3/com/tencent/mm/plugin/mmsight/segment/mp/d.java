package com.tencent.mm.plugin.mmsight.segment.mp;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.segment.mp.a.a;
import com.tencent.mm.plugin.mmsight.segment.mp.a.b;

public final class d implements a {
    private MediaPlayer djK = new MediaPlayer();

    public final void setSurface(Surface surface) {
        this.djK.setSurface(surface);
    }

    public final void setDataSource(String str) {
        this.djK.setDataSource(str);
    }

    public final void prepareAsync() {
        this.djK.prepareAsync();
    }

    public final void start() {
        this.djK.start();
    }

    public final void stop() {
        this.djK.stop();
    }

    public final void pause() {
        this.djK.pause();
    }

    public final boolean isPlaying() {
        return this.djK.isPlaying();
    }

    public final void seekTo(int i) {
        this.djK.seekTo(i);
    }

    public final int getCurrentPosition() {
        return this.djK.getCurrentPosition();
    }

    public final void release() {
        this.djK.release();
    }

    public final void setAudioStreamType(int i) {
        this.djK.setAudioStreamType(i);
    }

    public final void setLooping(boolean z) {
        this.djK.setLooping(z);
    }

    public final void a(final b bVar) {
        if (bVar == null) {
            this.djK.setOnPreparedListener(null);
        } else {
            this.djK.setOnPreparedListener(new OnPreparedListener(this) {
                final /* synthetic */ d htj;

                public final void onPrepared(MediaPlayer mediaPlayer) {
                    bVar.aN(mediaPlayer);
                }
            });
        }
    }

    public final void a(final com.tencent.mm.plugin.mmsight.segment.mp.a.d dVar) {
        if (dVar == null) {
            this.djK.setOnVideoSizeChangedListener(null);
        } else {
            this.djK.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener(this) {
                final /* synthetic */ d htj;

                public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                    dVar.bS(i, i2);
                }
            });
        }
    }

    public final void a(final a aVar) {
        if (aVar == null) {
            this.djK.setOnErrorListener(null);
        } else {
            this.djK.setOnErrorListener(new OnErrorListener(this) {
                final /* synthetic */ d htj;

                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    return aVar.bT(i, i2);
                }
            });
        }
    }
}
