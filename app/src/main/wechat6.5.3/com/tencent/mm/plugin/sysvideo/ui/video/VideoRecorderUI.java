package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.n.b;
import com.tencent.mm.pluginsdk.n.e;
import com.tencent.mm.pluginsdk.n.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.w;

public class VideoRecorderUI extends MMActivity {
    private static VideoRecorderUI kjg;
    private String bdo = null;
    private String bou = null;
    private ProgressDialog dwR = null;
    private long ewI = -1;
    private ah exc = new ah(new a(this) {
        final /* synthetic */ VideoRecorderUI kjo;

        {
            this.kjo = r1;
        }

        public final boolean oU() {
            if (this.kjo.ewI == -1) {
                this.kjo.ewI = SystemClock.elapsedRealtime();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.kjo.ewI;
            this.kjo.kjb.setText(e.gH((int) (elapsedRealtime / 1000)));
            if (elapsedRealtime > 30000 || elapsedRealtime < 20000) {
                this.kjo.kiW.setVisibility(8);
            } else {
                long j = (30000 - elapsedRealtime) / 1000;
                this.kjo.kiW.setVisibility(0);
                this.kjo.kiW.setText(this.kjo.getResources().getQuantityString(2131361824, (int) j, new Object[]{Long.valueOf(j)}));
            }
            if (elapsedRealtime >= 30000) {
                v.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
                VideoRecorderUI.d(this.kjo);
                this.kjo.ewI = -1;
                return false;
            }
            this.kjo.kje = this.kjo.kje % 2;
            if (this.kjo.kje == 0) {
                this.kjo.kja.setVisibility(4);
            } else {
                this.kjo.kja.setVisibility(0);
            }
            this.kjo.kje = this.kjo.kje + 1;
            return true;
        }
    }, true);
    private SurfaceHolder hui = null;
    private boolean iDJ;
    private SurfaceView iZB = null;
    Callback iZC = new Callback(this) {
        final /* synthetic */ VideoRecorderUI kjo;

        {
            this.kjo = r1;
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            v.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
            if (this.kjo.kiS.g(this.kjo, this.kjo.kjh) != 0) {
                this.kjo.aZO();
            }
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            v.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
            this.kjo.kji = true;
            this.kjo.kiS.bor();
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            v.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + i + " w:" + i2 + " h:" + i3);
            if (this.kjo.kiS.c(surfaceHolder) != 0) {
                this.kjo.aZO();
            }
            this.kjo.kjh = false;
            this.kjo.kji = false;
            VideoRecorderUI.x(this.kjo);
        }
    };
    private String kiO = null;
    private b kiS;
    private ImageButton kiT;
    private boolean kiU = false;
    private boolean kiV = false;
    private TextView kiW;
    private LinearLayout kiX;
    private ImageView kiY;
    private ImageButton kiZ = null;
    private ImageView kja;
    private TextView kjb;
    private TextView kjc;
    private TextView kjd;
    private int kje = 0;
    private ImageButton kjf;
    private boolean kjh = false;
    private boolean kji = true;
    private String kjj = null;
    private String kjk = null;
    private View kjl;
    private View kjm;
    private ac kjn = new ac(this) {
        final /* synthetic */ VideoRecorderUI kjo;

        {
            this.kjo = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.kjo.kjf.setEnabled(true);
        }
    };

    static /* synthetic */ void d(VideoRecorderUI videoRecorderUI) {
        Bitmap createVideoThumbnail;
        videoRecorderUI.kiV = false;
        videoRecorderUI.releaseWakeLock();
        videoRecorderUI.kiT.setImageResource(2130839381);
        videoRecorderUI.kiT.setEnabled(false);
        videoRecorderUI.getString(2131231164);
        videoRecorderUI.dwR = g.a(videoRecorderUI, videoRecorderUI.getString(2131235783, new Object[]{Integer.valueOf(0)}), true, new OnCancelListener(videoRecorderUI) {
            final /* synthetic */ VideoRecorderUI kjo;

            {
                this.kjo = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                v.d("MicroMsg.VideoRecorderUI", "tipDialog onCancel");
                if (this.kjo.kiS != null) {
                    this.kjo.auH();
                    this.kjo.kiX.setVisibility(0);
                    this.kjo.iZB.setVisibility(0);
                }
            }
        });
        long elapsedRealtime = SystemClock.elapsedRealtime() - videoRecorderUI.ewI;
        videoRecorderUI.exc.QI();
        videoRecorderUI.kiW.setVisibility(8);
        videoRecorderUI.kiU = true;
        b bVar = videoRecorderUI.kiS;
        if (bVar.iWO != null) {
            try {
                bVar.iWO.stop();
                bVar.iWO.release();
            } catch (Exception e) {
                v.e("MicroMsg.SceneVideo", "video[tiger] video stop failed");
            }
            bVar.iWO = null;
            bVar.hmu.dhK = (int) (elapsedRealtime / 1000);
            bVar.hmu.dhK = bVar.hmu.dhK > 0 ? bVar.hmu.dhK : 1;
            bVar.hmu.lFC = bVar.hmu.dhK * bVar.hmu.cdg;
            if (!(!com.tencent.mm.a.e.aR(bVar.hmu.lFB) || com.tencent.mm.a.e.aR(bVar.hmu.lFz) || bVar.context == null)) {
                createVideoThumbnail = d.dW(8) ? ThumbnailUtils.createVideoThumbnail(bVar.hmu.lFB, 1) : null;
                if (createVideoThumbnail != null) {
                    try {
                        v.d("MicroMsg.SceneVideo", "saveBitmapToImage " + bVar.hmu.lFz);
                        e.a(createVideoThumbnail, CompressFormat.JPEG, bVar.hmu.lFz);
                    } catch (Throwable e2) {
                        v.a("MicroMsg.SceneVideo", e2, "", new Object[0]);
                    }
                } else {
                    try {
                        e.a(BitmapFactory.decodeStream(bVar.context.getResources().openRawResource(2130838073)), CompressFormat.JPEG, bVar.hmu.lFz);
                    } catch (Throwable e22) {
                        v.a("MicroMsg.SceneVideo", e22, "", new Object[0]);
                    }
                }
            }
            if (com.tencent.mm.a.e.aR(bVar.hmu.lFB)) {
                bVar.fileSize = com.tencent.mm.a.e.aQ(bVar.hmu.lFB);
            }
        }
        String str = videoRecorderUI.kiS.hmu.lFz;
        if (str == null || str.length() <= 0) {
            createVideoThumbnail = null;
        } else {
            Bitmap c = BackwardSupportUtil.b.c(str.trim(), com.tencent.mm.bd.a.getDensity(videoRecorderUI));
            if (c != null) {
                int width = c.getWidth();
                int height = c.getHeight();
                int a = BackwardSupportUtil.b.a(videoRecorderUI, 224.0f);
                createVideoThumbnail = Bitmap.createScaledBitmap(c, a, (int) (((float) height) / (((float) width) / ((float) a))), true);
                if (c != createVideoThumbnail) {
                    v.i("MicroMsg.SceneVideo", "recycle bitmap:%s", new Object[]{c.toString()});
                    c.recycle();
                }
            } else {
                createVideoThumbnail = c;
            }
        }
        if (createVideoThumbnail != null) {
            videoRecorderUI.iZB.setVisibility(8);
            videoRecorderUI.kiY.setVisibility(0);
            videoRecorderUI.kiY.setImageBitmap(createVideoThumbnail);
        }
        if (videoRecorderUI.dwR != null) {
            videoRecorderUI.dwR.dismiss();
            videoRecorderUI.dwR = null;
        }
        videoRecorderUI.kiW.setVisibility(8);
        videoRecorderUI.kjm.setVisibility(0);
        TextView textView = videoRecorderUI.kjc;
        elapsedRealtime = (long) videoRecorderUI.kiS.fileSize;
        r0 = (elapsedRealtime >> 20) > 0 ? (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1048576.0f)) / 10.0f) + "MB" : (elapsedRealtime >> 9) > 0 ? (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1024.0f)) / 10.0f) + "KB" : elapsedRealtime + "B";
        textView.setText(r0);
        videoRecorderUI.kjd.setText(e.gH(videoRecorderUI.kiS.hmu.dhK));
        videoRecorderUI.kiX.setVisibility(8);
        videoRecorderUI.kiZ.setVisibility(0);
        videoRecorderUI.kjl.setVisibility(8);
        videoRecorderUI.kjf.setVisibility(8);
        videoRecorderUI.kiT.setVisibility(8);
        videoRecorderUI.kiT.setEnabled(true);
        videoRecorderUI.getWindow().clearFlags(1024);
        videoRecorderUI.cU().cV().show();
    }

    static /* synthetic */ void n(VideoRecorderUI videoRecorderUI) {
        videoRecorderUI.nDR.bAj();
        videoRecorderUI.kiX.setVisibility(0);
        videoRecorderUI.iZB.setVisibility(0);
        videoRecorderUI.kjf.setVisibility(8);
        videoRecorderUI.kjm.setVisibility(8);
        videoRecorderUI.kiV = true;
        videoRecorderUI.kiY.setVisibility(8);
        videoRecorderUI.kiZ.setVisibility(8);
        videoRecorderUI.kjl.setVisibility(0);
        videoRecorderUI.kiW.setVisibility(0);
        videoRecorderUI.ewI = -1;
        videoRecorderUI.exc.ea(300);
        videoRecorderUI.iZB.setKeepScreenOn(true);
        b bVar = videoRecorderUI.kiS;
        SurfaceHolder surfaceHolder = videoRecorderUI.hui;
        if (surfaceHolder == null) {
            v.e("MicroMsg.SceneVideo", "start fail, holder is null");
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        bVar.lFF = 0;
        bVar.a(surface, bVar.hmu.cdg, 0);
    }

    static /* synthetic */ void x(VideoRecorderUI videoRecorderUI) {
        int azU;
        int azV;
        LayoutParams layoutParams = (LayoutParams) videoRecorderUI.iZB.getLayoutParams();
        DisplayMetrics displayMetrics = videoRecorderUI.getResources().getDisplayMetrics();
        if (videoRecorderUI.iDJ) {
            azU = videoRecorderUI.kiS.azU();
            azV = videoRecorderUI.kiS.azV();
        } else {
            azU = videoRecorderUI.kiS.azV();
            azV = videoRecorderUI.kiS.azU();
        }
        v.i("MicroMsg.VideoRecorderUI", "resizeLayout priveview[%d, %d], dm[%d, %d]", new Object[]{Integer.valueOf(azU), Integer.valueOf(azV), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
        if (((float) azU) / ((float) azV) > ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels)) {
            v.i("MicroMsg.VideoRecorderUI", "resizeLayout wider");
            azV = (int) (((float) azV) * (((float) displayMetrics.widthPixels) / ((float) azU)));
            azU = displayMetrics.widthPixels;
        } else {
            v.i("MicroMsg.VideoRecorderUI", "resizeLayout higher");
            azU = (int) ((((float) displayMetrics.heightPixels) / ((float) azV)) * ((float) azU));
            azV = displayMetrics.heightPixels;
        }
        v.i("MicroMsg.VideoRecorderUI", "resizeLayout width:%d, height:%d", new Object[]{Integer.valueOf(azU), Integer.valueOf(azV)});
        layoutParams.width = azU;
        layoutParams.height = azV;
        videoRecorderUI.iZB.setLayoutParams(layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.ed(this);
        kjg = this;
        getWindow().setFlags(1024, 1024);
        cU().cV().hide();
        vD(2131235802);
        a(0, getString(2131231149), new OnMenuItemClickListener(this) {
            final /* synthetic */ VideoRecorderUI kjo;

            {
                this.kjo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("VideoRecorder_FileName", this.kjo.kiS.filename);
                intent.putExtra("VideoRecorder_VideoLength", this.kjo.kiS.hmu.dhK);
                intent.putExtra("VideoRecorder_ToUser", this.kjo.bdo);
                this.kjo.setResult(-1, intent);
                this.kjo.finish();
                return true;
            }
        }, k.b.nET);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VideoRecorderUI kjo;

            {
                this.kjo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kjo.aZN();
                return true;
            }
        });
        this.bdo = getIntent().getStringExtra("VideoRecorder_ToUser");
        this.bou = getIntent().getStringExtra("VideoRecorder_VideoPath");
        this.kiO = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        this.kjj = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
        this.kjk = getIntent().getStringExtra("VideoRecorder_FileName");
        v.d("MicroMsg.VideoRecorderUI", "talker :" + this.bdo);
        v.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.bou + " videoFullPath " + this.kiO + " videoThumbPath " + this.kjj + " KFileName " + this.kjk);
        NI();
        auH();
        ak.oJ().pU();
    }

    public void onStart() {
        super.onStart();
        if (this.iDJ) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    protected void onDestroy() {
        kjg = null;
        v.v("MicroMsg.VideoRecorderUI", "on destroy");
        ak.oJ().pT();
        super.onDestroy();
    }

    protected final void NI() {
        int i = 1;
        this.iZB = (SurfaceView) findViewById(2131759200);
        this.kiX = (LinearLayout) findViewById(2131755553);
        this.hui = this.iZB.getHolder();
        this.hui.addCallback(this.iZC);
        this.hui.setType(3);
        this.kja = (ImageView) findViewById(2131759624);
        this.kjf = (ImageButton) findViewById(2131759626);
        this.kjb = (TextView) findViewById(2131759625);
        this.kjl = findViewById(2131759623);
        this.kjm = findViewById(2131759628);
        this.kjb.setText(e.gH(0));
        this.kiS = new b();
        this.kiW = (TextView) findViewById(2131759627);
        this.kjc = (TextView) findViewById(2131759630);
        this.kjd = (TextView) findViewById(2131759629);
        this.kiT = (ImageButton) findViewById(2131756304);
        this.kiT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI kjo;

            {
                this.kjo = r1;
            }

            public final void onClick(View view) {
                ak.yW();
                if (!c.isSDCardAvailable()) {
                    s.ey(this.kjo);
                } else if (this.kjo.kiV) {
                    VideoRecorderUI.d(this.kjo);
                } else if (this.kjo.kiU) {
                    g.a(this.kjo, this.kjo.getString(2131235801), this.kjo.getString(2131231164), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 kjp;

                        {
                            this.kjp = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kjp.kjo.kiT.setImageResource(2130839382);
                            VideoRecorderUI.n(this.kjp.kjo);
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass7 kjp;

                        {
                            this.kjp = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    this.kjo.kiT.setImageResource(2130839382);
                    VideoRecorderUI.n(this.kjo);
                }
            }
        });
        if (com.tencent.mm.compatible.d.c.getNumberOfCameras() > 1) {
            this.kjf.setVisibility(0);
        } else {
            this.kjf.setVisibility(4);
        }
        this.kjf.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI kjo;

            {
                this.kjo = r1;
            }

            public final void onClick(View view) {
                this.kjo.kjf.setEnabled(false);
                this.kjo.kjn.sendEmptyMessageDelayed(0, 3000);
                this.kjo.kjh = true;
                this.kjo.kiS.bor();
                if (this.kjo.kiS.g(this.kjo, this.kjo.kjh) != 0 || this.kjo.kiS.c(this.kjo.hui) != 0) {
                    this.kjo.aZO();
                }
            }
        });
        this.kiZ = (ImageButton) findViewById(2131759631);
        this.kiY = (ImageView) findViewById(2131759622);
        this.kiZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI kjo;

            {
                this.kjo = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.kjo, VideoRecorderPreviewUI.class);
                intent.putExtra("VideoRecorder_FileName", this.kjo.kiS.filename);
                intent.putExtra("VideoRecorder_VideoLength", this.kjo.kiS.hmu.dhK);
                intent.putExtra("VideoRecorder_VideoSize", this.kjo.kiS.fileSize);
                intent.putExtra("VideoRecorder_ToUser", this.kjo.bdo);
                intent.putExtra("VideoRecorder_VideoFullPath", this.kjo.kiO);
                this.kjo.startActivityForResult(intent, 0);
                this.kjo.overridePendingTransition(0, 0);
            }
        });
        b bVar = this.kiS;
        int i2 = !this.iDJ ? 1 : 0;
        String str = this.bou;
        String str2 = this.kiO;
        String str3 = this.kjj;
        String str4 = this.kjk;
        bVar.dgq = 0;
        if (1 == bVar.dgq) {
            bVar.hmu = com.tencent.mm.pluginsdk.n.a.bop();
        } else {
            bVar.hmu = com.tencent.mm.pluginsdk.n.a.boo();
        }
        if (p.ceC.cfc) {
            bVar.hmu.lFt = p.ceC.cfe;
            bVar.hmu.lFu = p.ceC.cfd;
            bVar.hmu.lFs = p.ceC.cfh;
        }
        bVar.filename = str4;
        bVar.hmu.lFB = str2;
        bVar.hmu.lFz = str3;
        bVar.hmu.lFy = str + "temp.pcm";
        bVar.hmu.lFx = str + "temp.yuv";
        bVar.hmu.lFA = str + "temp.vid";
        bVar.hmu.lFD = com.tencent.mm.compatible.d.c.getNumberOfCameras();
        com.tencent.mm.pluginsdk.n.a aVar = bVar.hmu;
        if (i2 == 0) {
            i = 0;
        }
        aVar.cdi = i;
        bVar.hmu.dhK = 0;
        bVar.lFE = new f();
    }

    protected final void bB(View view) {
        w.c(w.a(getWindow(), null), this.nDR.nDX);
        ((ViewGroup) this.nDR.nDX.getParent()).removeView(this.nDR.nDX);
        ((ViewGroup) getWindow().getDecorView()).addView(this.nDR.nDX, 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        v.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
        if (this.kiV) {
            return true;
        }
        aZN();
        return true;
    }

    private void aZN() {
        if (this.kiU) {
            g.a(this, getString(2131235800), getString(2131231164), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ VideoRecorderUI kjo;

                {
                    this.kjo = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kjo.finish();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ VideoRecorderUI kjo;

                {
                    this.kjo = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else {
            finish();
        }
    }

    private void auH() {
        cU().cV().hide();
        this.kjb.setText(e.gH(0));
        this.kjl.setVisibility(8);
        this.kjm.setVisibility(8);
        this.kja.setVisibility(0);
        this.kiU = false;
        this.kiX.setVisibility(0);
        this.iZB.setVisibility(0);
        this.kiW.setVisibility(8);
        this.kiZ.setVisibility(8);
        this.kjb.setText(e.gH(0));
        this.kiY.setVisibility(8);
        this.kiT.setEnabled(true);
        this.kjf.setVisibility(0);
    }

    protected void onResume() {
        if (!(this.kji || (this.kiS.g(this, false) == 0 && this.kiS.c(this.hui) == 0))) {
            aZO();
        }
        this.kji = false;
        v.v("MicroMsg.VideoRecorderUI", "onResume");
        super.onResume();
    }

    protected void onPause() {
        if (this.kiV) {
            b bVar = this.kiS;
            if (bVar.iWO != null) {
                bVar.iWO.stop();
                bVar.iWO.release();
                bVar.iWO = null;
            }
            auH();
            this.kiV = false;
            releaseWakeLock();
            this.kiT.setImageResource(2130839381);
            this.exc.QI();
            this.kiW.setVisibility(8);
            this.kiX.setVisibility(0);
            this.iZB.setVisibility(0);
        }
        this.kiS.bor();
        v.v("MicroMsg.VideoRecorderUI", "onPause");
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 0) {
                setResult(-1, intent);
                finish();
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void aZO() {
        g.a(this, 2131235784, 2131231164, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ VideoRecorderUI kjo;

            {
                this.kjo = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.kjo.kiS.bor();
                this.kjo.finish();
            }
        });
    }

    private void releaseWakeLock() {
        this.iZB.setKeepScreenOn(false);
    }

    protected final int getLayoutId() {
        this.iDJ = com.tencent.mm.compatible.d.c.rt();
        if (!this.iDJ) {
            return 2130904573;
        }
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(0);
        return 2130904574;
    }
}
