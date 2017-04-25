package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@com.tencent.mm.ui.base.a(3)
public class VideoSegmentUI extends MMActivity {
    private String bdZ;
    private ProgressDialog dwR = null;
    private com.tencent.mm.remoteservice.d gZK = new com.tencent.mm.remoteservice.d(this);
    private int gee;
    private VideoTransPara hmR;
    private RelativeLayout hsA;
    private CountDownLatch hsB = new CountDownLatch(2);
    private int hsC = Constants.THREAD_BITSET_SIZE;
    private String hsD = "";
    private boolean hsE = false;
    private boolean hsF = false;
    private boolean hsG = false;
    private com.tencent.mm.plugin.mmsight.segment.d.b hsH = new com.tencent.mm.plugin.mmsight.segment.d.b(this) {
        final /* synthetic */ VideoSegmentUI hsK;

        {
            this.hsK = r1;
        }

        public final void r(float f, float f2) {
            if (this.hsK.hsx != null) {
                int d = this.hsK.gee;
                this.hsK.hsx.setLoop((int) (((float) d) * f), (int) (((float) d) * f2));
                this.hsK.hsx.seekTo((int) (((float) d) * f));
            }
        }

        public final void aAL() {
            if (this.hsK.hsx != null) {
                this.hsK.hsx.pause();
            }
        }

        public final void s(float f, float f2) {
            if (this.hsK.hsx != null) {
                int d = (int) (((float) this.hsK.gee) * f);
                this.hsK.hsx.setLoop(d, (int) (((float) this.hsK.gee) * f2));
                this.hsK.hsx.seekTo(d);
                this.hsK.hsx.start();
            }
        }

        public final void t(float f, float f2) {
            if ((f2 - f) * ((float) this.hsK.gee) <= ((float) this.hsK.hsC)) {
                this.hsK.iT(true);
            } else {
                this.hsK.iT(false);
            }
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.mp.c.a hsI = new com.tencent.mm.plugin.mmsight.segment.mp.c.a(this) {
        final /* synthetic */ VideoSegmentUI hsK;
        private Runnable hsL;

        {
            this.hsK = r1;
        }

        public final void ne(int i) {
            if (this.hsK.hsy != null) {
                if (this.hsL != null) {
                    ((View) this.hsK.hsy).removeCallbacks(this.hsL);
                }
                this.hsL = new c(this.hsK.hsy, i, this.hsK.gee);
                ((View) this.hsK.hsy).post(this.hsL);
            }
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.mp.a.d hsJ = new com.tencent.mm.plugin.mmsight.segment.mp.a.d(this) {
        final /* synthetic */ VideoSegmentUI hsK;

        {
            this.hsK = r1;
        }

        public final void bS(int i, int i2) {
            if (i <= 0 || i2 <= 0) {
                v.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.hsK.hsG)});
            } else if (this.hsK.hsG) {
                v.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
            } else {
                v.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.hsK.hsG = true;
                if (i2 <= 0 || i <= 0) {
                    v.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    this.hsK.hsF = true;
                    this.hsK.finish();
                    VideoSegmentUI.a(this.hsK);
                    return;
                }
                Runnable aVar = new a(this.hsK.hsA, i2, i, new b());
                if (this.hsK.hsA.getWidth() <= 0 || this.hsK.hsA.getHeight() <= 0) {
                    v.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
                    this.hsK.hsA.post(aVar);
                    return;
                }
                aVar.run();
            }
        }
    };
    private String hsv = null;
    private g hsw;
    private com.tencent.mm.plugin.mmsight.segment.mp.c hsx;
    private d hsy;
    private SurfaceHolder hsz;

    private class a implements Runnable {
        private Context context;
        final /* synthetic */ VideoSegmentUI hsK;
        private int hsP;
        private int hsQ;
        private ViewGroup hsR;
        private b hsS;

        private a(VideoSegmentUI videoSegmentUI, ViewGroup viewGroup, int i, int i2, b bVar) {
            this.hsK = videoSegmentUI;
            this.hsP = i;
            this.hsQ = i2;
            this.context = viewGroup.getContext();
            this.hsR = viewGroup;
            this.hsS = bVar;
        }

        public final void run() {
            if (!this.hsK.isFinishing()) {
                View surfaceView = new SurfaceView(this.context);
                if (surfaceView.getHolder() == null) {
                    v.e("MicroMsg.VideoSegmentUI", "Init surface view error, getHolder is null");
                    if (this.hsS != null) {
                        this.hsS.aAV();
                        return;
                    }
                    return;
                }
                int width = this.hsR.getWidth();
                int N = com.tencent.mm.bd.a.N(this.context, 2131493590);
                int top = ((View) this.hsK.hsy).getTop() - (N * 2);
                int i = this.hsQ;
                int i2 = this.hsP;
                Point point = new Point();
                float f = ((float) i2) / ((float) i) > ((float) top) / ((float) width) ? ((float) top) / ((float) i2) : ((float) width) / ((float) i);
                point.x = (int) (((float) i) * f);
                point.y = (int) (f * ((float) i2));
                v.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[]{Integer.valueOf(this.hsQ), Integer.valueOf(this.hsP), Integer.valueOf(N), Integer.valueOf(width), Integer.valueOf(top), point.toString()});
                if (point.x <= 0 || point.y <= 0) {
                    v.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", new Object[]{Integer.valueOf(this.hsQ), Integer.valueOf(this.hsP), Integer.valueOf(N), Integer.valueOf(width), Integer.valueOf(top), point.toString()});
                    if (this.hsS != null) {
                        this.hsS.aAV();
                        return;
                    }
                    return;
                }
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(point.x, point.y);
                N += (int) (((float) (top - point.y)) / 2.0f);
                layoutParams.topMargin = N;
                layoutParams.bottomMargin = N;
                width = (int) (((float) (width - point.x)) / 2.0f);
                layoutParams.leftMargin = width;
                layoutParams.rightMargin = width;
                surfaceView.getHolder().addCallback(this.hsS);
                surfaceView.setZOrderOnTop(true);
                this.hsR.addView(surfaceView, 0, layoutParams);
            }
        }
    }

    private class b implements Callback {
        final /* synthetic */ VideoSegmentUI hsK;

        private b(VideoSegmentUI videoSegmentUI) {
            this.hsK = videoSegmentUI;
        }

        public final void aAV() {
            v.e("MicroMsg.VideoSegmentUI", "surfaceInitError");
            this.hsK.hsF = true;
            this.hsK.finish();
            VideoSegmentUI.a(this.hsK);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            v.i("MicroMsg.VideoSegmentUI", "surfaceCreated");
            this.hsK.hsz = surfaceHolder;
            this.hsK.hsB.countDown();
            if (this.hsK.hsx == null && this.hsK.hsE) {
                v.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
                try {
                    this.hsK.a(false, surfaceHolder.getSurface(), true);
                    if (!(this.hsK.hsy == null || this.hsK.hsx == null)) {
                        this.hsK.hsx.setLoop((int) (((float) this.hsK.gee) * this.hsK.hsy.aAJ()), (int) (((float) this.hsK.gee) * this.hsK.hsy.aAK()));
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.VideoSegmentUI", e, "ResumeMediaPlayer error %s", new Object[]{e.getMessage()});
                }
                this.hsK.hsE = false;
            }
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            v.i("MicroMsg.VideoSegmentUI", "SurfaceCreatedCallback.surfaceDestroyed");
            try {
                if (this.hsK.hsx != null) {
                    v.i("MicroMsg.VideoSegmentUI", "SurfaceCreatedCallback MediaPlayer pause");
                    this.hsK.hsx.release();
                    this.hsK.hsx = null;
                    this.hsK.hsE = true;
                }
            } catch (Exception e) {
            }
        }
    }

    private static class c implements Runnable {
        private WeakReference<d> cxw;
        private int gee;
        private int hsT;

        public c(d dVar, int i, int i2) {
            this.cxw = new WeakReference(dVar);
            this.hsT = i;
            this.gee = i2;
        }

        public final void run() {
            d dVar = (d) this.cxw.get();
            if (dVar != null) {
                dVar.P(((float) this.hsT) / ((float) this.gee));
            }
        }
    }

    private class d implements Runnable {
        final /* synthetic */ VideoSegmentUI hsK;

        private d(VideoSegmentUI videoSegmentUI) {
            this.hsK = videoSegmentUI;
        }

        public final void run() {
            boolean await;
            try {
                await = this.hsK.hsB.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                v.e("MicroMsg.VideoSegmentUI", "count down latch error %s", new Object[]{e});
                await = false;
            }
            if (await) {
                try {
                    if (!(this.hsK.hsF || this.hsK.isFinishing() || this.hsK.hsz == null || this.hsK.hsz.getSurface() == null || !this.hsK.hsz.getSurface().isValid())) {
                        if (this.hsK.hsx != null) {
                            this.hsK.hsx.release();
                            this.hsK.hsx = null;
                        }
                        try {
                            this.hsK.a(false, this.hsK.hsz.getSurface(), true);
                            this.hsK.hsx.setSurface(this.hsK.hsz.getSurface());
                            ad.o(new Runnable(this) {
                                final /* synthetic */ d hsU;

                                {
                                    this.hsU = r1;
                                }

                                public final void run() {
                                    if (this.hsU.hsK.hsF || this.hsU.hsK.isFinishing() || this.hsU.hsK.hsy == null || this.hsU.hsK.hsx == null) {
                                        v.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
                                        return;
                                    }
                                    ((View) this.hsU.hsK.hsy).setAlpha(0.0f);
                                    ((View) this.hsU.hsK.hsy).setVisibility(0);
                                    ((View) this.hsU.hsK.hsy).animate().setDuration(300).setStartDelay(200).alpha(1.0f);
                                    float aAJ = this.hsU.hsK.hsy.aAJ();
                                    float aAK = this.hsU.hsK.hsy.aAK();
                                    if ((aAK - aAJ) * ((float) this.hsU.hsK.gee) <= ((float) this.hsU.hsK.hsC)) {
                                        this.hsU.hsK.iT(true);
                                    }
                                    this.hsU.hsK.hsx.setLoop((int) (aAJ * ((float) this.hsU.hsK.gee)), (int) (aAK * ((float) this.hsU.hsK.gee)));
                                }
                            });
                            return;
                        } catch (Throwable e2) {
                            v.a("MicroMsg.VideoSegmentUI", e2, "init segmentPlayer second time %s", new Object[]{e2.getMessage()});
                            this.hsK.finish();
                            return;
                        }
                    }
                } catch (Throwable e22) {
                    v.a("MicroMsg.VideoSegmentUI", e22, "Finished when init", new Object[0]);
                    this.hsK.finish();
                    return;
                }
            }
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "Waiting Prepared error : latchawait = [%b], latchCount = [%d], needFinish = [%b], surfaceHolder = [%s] surfaceValid = [%s], isFinishing = [%b]";
            Object[] objArr = new Object[6];
            objArr[0] = Boolean.valueOf(await);
            objArr[1] = Long.valueOf(this.hsK.hsB.getCount());
            objArr[2] = Boolean.valueOf(this.hsK.hsF);
            objArr[3] = this.hsK.hsz == null ? null : this.hsK.hsz;
            String valueOf = this.hsK.hsz == null ? null : this.hsK.hsz.getSurface() == null ? null : String.valueOf(this.hsK.hsz.getSurface().isValid());
            objArr[4] = valueOf;
            objArr[5] = Boolean.valueOf(this.hsK.isFinishing());
            v.e(str, str2, objArr);
            this.hsK.finish();
            ad.o(new Runnable(this) {
                final /* synthetic */ d hsU;

                {
                    this.hsU = r1;
                }

                public final void run() {
                    Toast.makeText(this.hsU.hsK.nDR.nEl, "prepared error", 0).show();
                }
            });
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI) {
        int i = 0;
        while (true) {
            try {
                if (((long) i) < videoSegmentUI.hsB.getCount()) {
                    videoSegmentUI.hsB.countDown();
                    i++;
                } else {
                    return;
                }
            } catch (Exception e) {
                v.e("MicroMsg.VideoSegmentUI", "ensureNotWaiting e : %s", new Object[]{e});
                return;
            }
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI, boolean z, String str) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", videoSegmentUI.hsD);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", videoSegmentUI.bdZ);
            videoSegmentUI.setResult(-1, intent);
            videoSegmentUI.finish();
            return;
        }
        v.e("MicroMsg.VideoSegmentUI", "Clip not success. %s", new Object[]{str});
    }

    static /* synthetic */ void b(VideoSegmentUI videoSegmentUI) {
        videoSegmentUI.hsD = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
        videoSegmentUI.bdZ = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg";
        e.a(new Runnable(videoSegmentUI) {
            final /* synthetic */ VideoSegmentUI hsK;

            {
                this.hsK = r1;
            }

            public final void run() {
                List<FileEntry> A = FileOp.A(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                if (A != null && A.size() != 0) {
                    for (FileEntry fileEntry : A) {
                        if (fileEntry.name != null && ((fileEntry.name.contains("vsg_output_") && !fileEntry.name.contains(this.hsK.hsD)) || (fileEntry.name.contains("vsg_thumb_") && !fileEntry.name.contains(this.hsK.bdZ)))) {
                            com.tencent.mm.loader.stub.b.deleteFile(fileEntry.name);
                        }
                    }
                }
            }
        }, "delete_old_temp_video_file");
        if (be.kS(videoSegmentUI.hsD) || be.kS(videoSegmentUI.bdZ)) {
            v.e("MicroMsg.VideoSegmentUI", "Create output file failed.");
            return;
        }
        videoSegmentUI.hmR = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        if (videoSegmentUI.hmR == null) {
            v.e("MicroMsg.VideoSegmentUI", "VideoTransPara not provided.");
        } else if (videoSegmentUI.hsv == null) {
            v.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
        } else if (videoSegmentUI.hsB.getCount() != 0) {
            v.e("MicroMsg.VideoSegmentUI", "Not prepared right now, please try again.");
        } else {
            v.i("MicroMsg.VideoSegmentUI", "Start to process video");
            videoSegmentUI.getString(2131231164);
            videoSegmentUI.dwR = g.a(videoSegmentUI, videoSegmentUI.getString(2131231182), false, null);
            videoSegmentUI.hsy.ej(true);
            e.a(new Runnable(videoSegmentUI) {
                final /* synthetic */ VideoSegmentUI hsK;

                {
                    this.hsK = r1;
                }

                public final void run() {
                    boolean z = true;
                    String str = null;
                    try {
                        this.hsK.hsx.stop();
                        int d = this.hsK.gee;
                        long Nj = be.Nj();
                        this.hsK.hsw.a(this.hsK.hsv, this.hsK.hsD, this.hsK.hmR);
                        if (this.hsK.hsw.k((long) (this.hsK.hsy.aAJ() * ((float) d)), (long) (((float) d) * this.hsK.hsy.aAK())) < 0) {
                            v.i("MicroMsg.VideoSegmentUI", "clip failed! %s", new Object[]{Integer.valueOf(this.hsK.hsw.k((long) (this.hsK.hsy.aAJ() * ((float) d)), (long) (((float) d) * this.hsK.hsy.aAK())))});
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass6 hsO;

                                {
                                    this.hsO = r1;
                                }

                                public final void run() {
                                    if (this.hsO.hsK.dwR != null) {
                                        this.hsO.hsK.dwR.dismiss();
                                    }
                                    if (this.hsO.hsK.hsy != null) {
                                        this.hsO.hsK.hsy.ej(false);
                                    }
                                    Toast.makeText(this.hsO.hsK, 2131233847, 1).show();
                                }
                            });
                            return;
                        }
                        Bitmap wx = com.tencent.mm.plugin.mmsight.b.wx(this.hsK.hsD);
                        if (wx != null) {
                            v.i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", new Object[]{Integer.valueOf(wx.getWidth()), Integer.valueOf(wx.getHeight())});
                            com.tencent.mm.sdk.platformtools.d.a(wx, 80, CompressFormat.JPEG, this.hsK.bdZ, true);
                            v.i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", new Object[]{Long.valueOf(be.az(Nj))});
                        } else {
                            v.e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
                        }
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 hsO;

                            public final void run() {
                                if (this.hsO.hsK.dwR != null) {
                                    this.hsO.hsK.dwR.dismiss();
                                }
                                if (this.hsO.hsK.hsy != null) {
                                    this.hsO.hsK.hsy.ej(false);
                                }
                                VideoSegmentUI.a(this.hsO.hsK, z, str);
                            }
                        });
                    } catch (Throwable e) {
                        Throwable th = e;
                        str = th.getMessage();
                        v.a("MicroMsg.VideoSegmentUI", th, "UnexpectedException when clip : [%s]", new Object[]{th.getMessage()});
                        z = false;
                    }
                }
            }, "clip_video");
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.gZK));
        this.gZK.z(new Runnable(this) {
            final /* synthetic */ VideoSegmentUI hsK;

            {
                this.hsK = r1;
            }

            public final void run() {
                v.i("MicroMsg.VideoSegmentUI", "has connect");
                if (CaptureMMProxy.getInstance() != null) {
                    p.dr(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VideoSegmentUI hsK;

            {
                this.hsK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hsK.finish();
                VideoSegmentUI.a(this.hsK);
                return true;
            }
        });
        vD(2131232309);
        a(0, com.tencent.mm.bd.a.O(this.nDR.nEl, 2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ VideoSegmentUI hsK;

            {
                this.hsK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                VideoSegmentUI.b(this.hsK);
                return true;
            }
        }, com.tencent.mm.ui.k.b.nET);
        iT(false);
        Intent intent = getIntent();
        if (intent == null || be.kS(intent.getStringExtra("key_video_path"))) {
            boolean z2;
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "is Intent null ? %b, is path null ? %b";
            Object[] objArr = new Object[2];
            if (intent == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (intent == null || intent.getStringExtra("key_video_path") == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            v.e(str, str2, objArr);
            finish();
            return;
        }
        this.hsv = intent.getStringExtra("key_video_path");
        v.i("MicroMsg.VideoSegmentUI", "selectVideoPath: %s", new Object[]{this.hsv});
        if (this.hsv == null || this.hsv.length() == 0) {
            v.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            return;
        }
        NI();
        try {
            a(true, null, false);
            this.hsy.a(new com.tencent.mm.plugin.mmsight.segment.d.a(this) {
                final /* synthetic */ VideoSegmentUI hsK;

                {
                    this.hsK = r1;
                }

                public final void ek(boolean z) {
                    if (z) {
                        v.e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
                        this.hsK.hsF = true;
                        this.hsK.finish();
                        VideoSegmentUI.a(this.hsK);
                        return;
                    }
                    if (!(this.hsK.isFinishing() || this.hsK.hsy == null)) {
                        this.hsK.gee = this.hsK.hsy.getDurationMs();
                        v.i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", new Object[]{Integer.valueOf(this.hsK.gee)});
                        try {
                            if (this.hsK.hsx != null) {
                                this.hsK.hsx.setLoop((int) (((float) this.hsK.gee) * this.hsK.hsy.aAJ()), (int) (((float) this.hsK.gee) * this.hsK.hsy.aAK()));
                            }
                        } catch (Exception e) {
                        }
                    }
                    this.hsK.hsB.countDown();
                }
            });
            this.hsy.a(this.hsH);
            this.hsy.wB(this.hsv);
            this.hsw = new n();
            e.b(new d(), "waiting_for_component_prepared.");
        } catch (Throwable e) {
            v.a("MicroMsg.VideoSegmentUI", e, "MediaPlayer set data source error : [%s]", new Object[]{e.getMessage()});
            finish();
        }
    }

    protected final void NI() {
        this.hsy = (d) findViewById(2131759633);
        this.hsA = (RelativeLayout) findViewById(2131755452);
    }

    private void a(boolean z, Surface surface, boolean z2) {
        if (this.hsx != null) {
            v.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
            return;
        }
        this.hsx = new com.tencent.mm.plugin.mmsight.segment.mp.c();
        this.hsx.setDataSource(this.hsv);
        this.hsx.a(new com.tencent.mm.plugin.mmsight.segment.mp.a.a(this) {
            final /* synthetic */ VideoSegmentUI hsK;

            {
                this.hsK = r1;
            }

            public final boolean bT(int i, int i2) {
                v.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.hsK.hsF = true;
                this.hsK.finish();
                VideoSegmentUI.a(this.hsK);
                return true;
            }
        });
        if (z) {
            this.hsx.a(this.hsJ);
        }
        this.hsx.setAudioStreamType(3);
        this.hsx.setLooping(true);
        if (surface != null) {
            this.hsx.setSurface(surface);
        }
        this.hsx.hsI = this.hsI;
        if (z2) {
            this.hsx.a(new com.tencent.mm.plugin.mmsight.segment.mp.a.b(this) {
                final /* synthetic */ VideoSegmentUI hsK;

                {
                    this.hsK = r1;
                }

                public final void aN(Object obj) {
                    v.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", new Object[]{obj});
                    try {
                        if (this.hsK.hsx != null) {
                            this.hsK.hsx.start();
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }
        this.hsx.prepareAsync();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.gZK.release();
        if (this.hsy != null) {
            this.hsy.release();
        }
        if (this.hsx != null) {
            this.hsx.release();
        }
        if (!(this.hsz == null || this.hsz.getSurface() == null)) {
            this.hsz.getSurface().release();
        }
        if (this.hsw != null) {
            this.hsw.release();
        }
        h.hoF.wc();
    }

    protected final int getLayoutId() {
        return 2130904576;
    }
}
