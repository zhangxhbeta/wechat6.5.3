package com.tencent.mm.plugin.music.a.c;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends a {
    MediaPlayer djK = new MediaPlayer();
    boolean ecS = true;
    a hDv;

    private class a implements Runnable {
        boolean eUv;
        final /* synthetic */ b hDw;

        private a(b bVar) {
            this.hDw = bVar;
            this.eUv = true;
        }

        public final void run() {
            v.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
            while (!this.eUv) {
                try {
                    if (this.hDw.djK != null && this.hDw.djK.isPlaying()) {
                        int currentPosition = this.hDw.djK.getCurrentPosition();
                        int duration = this.hDw.djK.getDuration();
                        if (currentPosition > 0 && duration > 0) {
                            this.hDw.nw((currentPosition * 100) / duration);
                        }
                    }
                } catch (Exception e) {
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            }
        }
    }

    public b() {
        this.djK.setAudioStreamType(3);
        this.djK.setOnCompletionListener(new OnCompletionListener(this) {
            final /* synthetic */ b hDw;

            {
                this.hDw = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                this.hDw.eG(true);
            }
        });
        this.djK.setOnSeekCompleteListener(new OnSeekCompleteListener(this) {
            final /* synthetic */ b hDw;

            {
                this.hDw = r1;
            }

            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                if (this.hDw.djK != null && this.hDw.djK.isPlaying()) {
                    try {
                        this.hDw.djK.start();
                    } catch (Exception e) {
                    }
                }
            }
        });
        this.djK.setOnPreparedListener(new OnPreparedListener(this) {
            final /* synthetic */ b hDw;

            {
                this.hDw = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                if (this.hDw.djK != null) {
                    try {
                        this.hDw.djK.start();
                    } catch (Exception e) {
                    }
                    this.hDw.ecS = false;
                    this.hDw.onStart();
                    if (this.hDw.hDv != null) {
                        this.hDw.hDv.eUv = true;
                    }
                    this.hDw.hDv = new a();
                    Runnable runnable = this.hDw.hDv;
                    runnable.eUv = false;
                    e.a(runnable, "music_play_progress_runnable");
                }
            }
        });
        this.djK.setOnErrorListener(new OnErrorListener(this) {
            final /* synthetic */ b hDw;

            {
                this.hDw = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                this.hDw.eF(false);
                return false;
            }
        });
    }

    public final boolean isPlaying() {
        boolean z = false;
        try {
            z = this.djK.isPlaying();
        } catch (Throwable e) {
            v.a("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[z]);
        }
        return z;
    }

    public final boolean aDh() {
        return !this.ecS;
    }

    public final void xd(String str) {
        try {
            this.djK.setDataSource(str);
        } catch (Throwable e) {
            v.a("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[0]);
        }
    }

    public final int aDi() {
        return this.djK.getCurrentPosition();
    }

    public final int getDuration() {
        return this.djK.getDuration();
    }

    public final void play() {
        v.i("MicroMsg.Music.MMMediaPlayer", "play");
        if (aDh()) {
            try {
                if (!this.djK.isPlaying()) {
                    this.djK.start();
                    return;
                }
                return;
            } catch (Exception e) {
                return;
            }
        }
        try {
            this.djK.prepareAsync();
        } catch (Throwable e2) {
            v.a("MicroMsg.Music.MMMediaPlayer", e2, "play", new Object[0]);
        }
    }

    public final void stop() {
        this.ecS = true;
        try {
            if (this.djK != null) {
                this.djK.stop();
                this.djK.release();
            }
            if (this.hDv != null) {
                this.hDv.eUv = true;
                this.hDv = null;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.Music.MMMediaPlayer", e, "stop", new Object[0]);
        }
        eG(false);
    }

    public final void pause() {
        v.i("MicroMsg.Music.MMMediaPlayer", "pause");
        if (aDh()) {
            this.djK.pause();
        }
    }

    public final void seek(long j) {
        v.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[]{Long.valueOf(j)});
        this.djK.seekTo((int) j);
    }
}
