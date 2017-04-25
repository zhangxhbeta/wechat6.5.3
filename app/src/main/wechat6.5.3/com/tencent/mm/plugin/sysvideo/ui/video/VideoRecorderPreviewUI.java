package com.tencent.mm.plugin.sysvideo.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.video.VideoView;
import com.tencent.mm.ui.w;

public class VideoRecorderPreviewUI extends MMActivity {
    private long dfS = -1;
    private VideoView kiN;
    private String kiO = null;
    private final int kiP = 3000;
    private ac kiQ = new ac(this) {
        final /* synthetic */ VideoRecorderPreviewUI kiR;

        {
            this.kiR = r1;
        }

        public final void handleMessage(Message message) {
            this.kiR.getWindow().setFlags(1024, 1024);
            this.kiR.nDR.bAj();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        this.nDR.bAj();
        this.kiO = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        vD(2131235799);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI kiR;

            {
                this.kiR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kiR.finish();
                this.kiR.overridePendingTransition(0, 0);
                return true;
            }
        });
        NI();
    }

    public void onStart() {
        super.onStart();
    }

    protected final void NI() {
        this.kiN = (VideoView) findViewById(2131759622);
        this.kiN.djd = new OnErrorListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI kiR;

            {
                this.kiR = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                this.kiR.kiN.stopPlayback();
                g.f(this.kiR, 2131235798, 2131235796);
                return false;
            }
        };
        this.kiN.oYx = new OnPreparedListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI kiR;

            {
                this.kiR = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                v.d("MicroMsg.VideoRecorderPreviewUI", com.tencent.mm.compatible.util.g.sl() + " onPrepared");
                v.d("MicroMsg.VideoRecorderPreviewUI", com.tencent.mm.compatible.util.g.sl() + " onPrepared");
                VideoView a = this.kiR.kiN;
                if (a.iZA == null || !a.lUE) {
                    a.lUF = true;
                } else {
                    a.iZA.start();
                    a.lUF = false;
                }
                this.kiR.kiQ.sendEmptyMessageDelayed(0, 3000);
            }
        };
        findViewById(2131759621).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI kiR;

            {
                this.kiR = r1;
            }

            public final void onClick(View view) {
                this.kiR.kiQ.removeMessages(0);
                if (this.kiR.bAa()) {
                    this.kiR.getWindow().setFlags(1024, 1024);
                    this.kiR.nDR.bAj();
                    return;
                }
                this.kiR.getWindow().clearFlags(1024);
                this.kiR.bzZ();
                this.kiR.kiQ.removeMessages(0);
                this.kiR.kiQ.sendEmptyMessageDelayed(0, 3000);
            }
        });
        this.kiN.djc = new OnCompletionListener(this) {
            final /* synthetic */ VideoRecorderPreviewUI kiR;

            {
                this.kiR = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                this.kiR.finish();
                this.kiR.overridePendingTransition(0, 0);
            }
        };
        if (this.kiO != null) {
            this.kiN.stopPlayback();
            VideoView videoView = this.kiN;
            videoView.lUD = this.kiO;
            videoView.lUF = false;
            videoView.hvs = 0;
            videoView.bqY();
            videoView.requestLayout();
            videoView.invalidate();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.kiN.isPlaying()) {
            VideoView videoView = this.kiN;
            if (videoView.iZA != null && videoView.lUE && videoView.iZA.isPlaying()) {
                videoView.iZA.pause();
            }
            videoView.lUF = false;
        }
        finish();
        overridePendingTransition(0, 0);
        this.kiQ.removeMessages(0);
    }

    protected final void bB(View view) {
        w.c(w.a(getWindow(), null), this.nDR.nDX);
        ((ViewGroup) this.nDR.nDX.getParent()).removeView(this.nDR.nDX);
        ((ViewGroup) getWindow().getDecorView()).addView(this.nDR.nDX, 0);
    }

    protected final int getLayoutId() {
        return 2130904575;
    }
}
