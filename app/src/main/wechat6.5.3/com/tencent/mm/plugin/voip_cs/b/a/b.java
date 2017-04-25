package com.tencent.mm.plugin.voip_cs.b.a;

import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.brandservice.a.j;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.ui.VoipBigIconButton;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip_cs.ui.VoipCSMainUI;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.pb.common.c.h;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;

public final class b implements SurfaceTextureListener, OnClickListener, com.tencent.mm.plugin.voip.model.k.a, f {
    protected static final int[] kxw = new int[]{-1, 2131235893, 2131235898, 2131235897};
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    public boolean beg = false;
    private ac cnC;
    private TextView eTg;
    public TextView euh;
    private Timer fUZ;
    private View hBF;
    public com.tencent.mm.plugin.voip.video.a hBO;
    public ObservableTextureView hBQ;
    private ImageButton hBn;
    public String kEA = "";
    public String kEB = "";
    public ah kEC = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ b kEJ;

        {
            this.kEJ = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.voipcs.VoipCSViewManager", "voipcs invite time out!opposite not responese");
            com.tencent.mm.plugin.voip_cs.b.b.bed().aKG = 1;
            this.kEJ.onFinish(6);
            return true;
        }
    }, false);
    public ah kED = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ b kEJ;

        {
            this.kEJ = r1;
        }

        public final boolean oU() {
            this.kEJ.kEo.setText(aa.getContext().getString(2131235900));
            this.kEJ.kEp.setVisibility(0);
            com.tencent.mm.plugin.voip_cs.c.a c = this.kEJ.kEz;
            TextView b = this.kEJ.kEp;
            int[] iArr = b.kxw;
            if (iArr == null || b == null) {
                v.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
            } else {
                c.bdp();
                c.kxH = 0;
                c.kxF = iArr;
                c.kG = b;
                c.kxG = 500;
                if (c.dwn != null) {
                    c.dwn.ea((long) c.kxG);
                }
                v.h("MicroMsg.DynamicTextWrap", "start textview:" + b, new Object[0]);
            }
            return true;
        }
    }, false);
    a kEE = new a();
    c kEF;
    b kEG;
    String kEH = "";
    Drawable kEI = null;
    public VoipCSMainUI kEl;
    public RelativeLayout kEm;
    private TextView kEn;
    private TextView kEo;
    private TextView kEp;
    private TextView kEq;
    public ImageView kEr;
    private ac kEs;
    private boolean kEt = false;
    protected long kEu = -1;
    private boolean kEv = false;
    private boolean kEw = false;
    public int kEx = 60000;
    public int kEy = 5000;
    private com.tencent.mm.plugin.voip_cs.c.a kEz = new com.tencent.mm.plugin.voip_cs.c.a();
    private OpenGlView kxP;
    private OpenGlView kxQ;
    public OpenGlRender kxR;
    public OpenGlRender kxS;
    private boolean kyC = false;
    private OnClickListener kyU = new OnClickListener(this) {
        final /* synthetic */ b kEJ;

        {
            this.kEJ = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.voipcs.VoipCSViewManager", "switch camera");
            this.kEJ.kyl.setEnabled(false);
            if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe > 1) {
                this.kEJ.beo();
            }
            this.kEJ.kyl.setEnabled(true);
            if (this.kEJ.hBO != null) {
                this.kEJ.hBO.bdD();
            }
        }
    };
    private VoipBigIconButton kyl;

    private class a {
        int h;
        int[] hzY;
        final /* synthetic */ b kEJ;
        int w;

        private a(b bVar) {
            this.kEJ = bVar;
        }
    }

    class b implements Runnable {
        final /* synthetic */ b kEJ;

        b(b bVar) {
            this.kEJ = bVar;
        }

        public final void run() {
            this.kEJ.kEI = b.CT(this.kEJ.kEH);
            Message message = new Message();
            message.what = 12;
            this.kEJ.kEs.sendMessage(message);
            e.remove(this.kEJ.kEG);
        }
    }

    class c implements Runnable {
        final /* synthetic */ b kEJ;
        boolean ksO = false;

        c(b bVar) {
            this.kEJ = bVar;
        }

        public final void run() {
            while (!this.ksO && !this.kEJ.beg) {
                if (com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.videoDecode(com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kwx) == 1) {
                    int i = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.field_remoteImgWidth;
                    int i2 = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.field_remoteImgHeight;
                    if (OpenGlRender.kBL == 1) {
                        if (this.kEJ.kyC) {
                            this.kEJ.kxS.a(com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kwx, i, i2, OpenGlRender.kBq + OpenGlRender.kBw);
                        } else {
                            this.kEJ.kxR.a(com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kwx, i, i2, OpenGlRender.kBq + OpenGlRender.kBw);
                        }
                    } else if (this.kEJ.kyC) {
                        this.kEJ.kxS.a(com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kwx, i, i2, OpenGlRender.kBt + OpenGlRender.kBw);
                    } else {
                        this.kEJ.kxR.a(com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kwx, i, i2, OpenGlRender.kBt + OpenGlRender.kBw);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    v.a("MicroMsg.voipcs.VoipCSViewManager", e, "", new Object[0]);
                }
            }
        }
    }

    public b(VoipCSMainUI voipCSMainUI) {
        this.kEl = voipCSMainUI;
        WindowManager windowManager = (WindowManager) voipCSMainUI.getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) voipCSMainUI.findViewById(2131759695)).setPadding(0, 0, 0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(voipCSMainUI.nDR.nEl, 40.0f));
        }
        this.kxQ = new MovableVideoView(voipCSMainUI.getApplicationContext());
        ((MovableVideoView) this.kxQ).cD(width, height);
        this.kxQ.setVisibility(8);
        this.kxR = new OpenGlRender(this.kxQ, OpenGlRender.kBA);
        this.kxQ.a(this.kxR);
        this.kxQ.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.kxQ.setZOrderOnTop(true);
        } else {
            this.kxQ.setZOrderMediaOverlay(true);
        }
        this.eTg = (TextView) voipCSMainUI.findViewById(2131755923);
        this.eTg.setVisibility(0);
        this.fUZ = new Timer("voip_cs_talking_time");
        this.kEn = (TextView) voipCSMainUI.findViewById(2131759698);
        this.kEn.setVisibility(0);
        this.kEo = (TextView) voipCSMainUI.findViewById(2131759692);
        this.kEo.setVisibility(0);
        this.euh = (TextView) voipCSMainUI.findViewById(2131759690);
        this.euh.setVisibility(0);
        this.kEr = (ImageView) voipCSMainUI.findViewById(2131759689);
        this.kEr.setVisibility(0);
        this.kEq = (TextView) voipCSMainUI.findViewById(2131759699);
        this.kEp = (TextView) voipCSMainUI.findViewById(2131759693);
        this.kyl = (VoipBigIconButton) voipCSMainUI.findViewById(2131759697);
        if (voipCSMainUI.kER == null || !voipCSMainUI.kER.equals("1")) {
            this.kyl.setVisibility(8);
        } else {
            this.kyl.setVisibility(0);
            this.kyl.setOnClickListener(this.kyU);
        }
        this.cnC = new ac();
        this.kEs = new ac(this) {
            final /* synthetic */ b kEJ;

            {
                this.kEJ = r1;
            }

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 12:
                        if (this.kEJ.kEI != null) {
                            this.kEJ.kEr.setImageDrawable(this.kEJ.kEI);
                            return;
                        } else {
                            this.kEJ.kEr.setImageResource(2130838080);
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        this.hBF = voipCSMainUI.findViewById(2131759687);
        this.hBn = (ImageButton) voipCSMainUI.findViewById(2131759696);
        this.kEm = (RelativeLayout) voipCSMainUI.findViewById(2131759687);
        mScreenWidth = com.tencent.mm.bd.a.dv(voipCSMainUI.nDR.nEl);
        mScreenHeight = com.tencent.mm.plugin.voip_cs.c.b.cL(voipCSMainUI.nDR.nEl);
        this.kxP = (OpenGlView) voipCSMainUI.findViewById(2131759688);
        this.kxP.cE(mScreenWidth, mScreenHeight);
        this.kxS = new OpenGlRender(this.kxP, OpenGlRender.kBz);
        this.kxP.a(this.kxS);
        this.kxP.setRenderMode(0);
        this.kxP.setVisibility(0);
        v.i("MicroMsg.voipcs.VoipCSViewManager", "mScreenHeight %d", new Object[]{Integer.valueOf(mScreenHeight)});
        this.hBn.setOnClickListener(this);
        this.kEm.addView(this.kxQ);
        this.kxQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b kEJ;

            {
                this.kEJ = r1;
            }

            public final void onClick(View view) {
                this.kEJ.kyC = !this.kEJ.kyC;
                Point b = this.kEJ.gV(this.kEJ.kyC);
                this.kEJ.kxQ.cF(b.x, b.y);
            }
        });
        this.kxR.kBg = true;
        this.kxS.kBg = true;
        if (!d.cF(aa.getContext())) {
            d.cG(aa.getContext());
        }
        SharedPreferences btk = aa.btk();
        this.kEA = btk.getString(bel(), "");
        if (this.kEl.fSc != null && !this.kEl.fSc.equals("")) {
            CS(this.kEl.fSc);
        } else if (!h.isNullOrEmpty(this.kEA)) {
            CS(this.kEA);
        }
        this.kEB = btk.getString(bem(), "");
        if (!h.isNullOrEmpty(this.kEB)) {
            CR(this.kEB);
        }
        com.tencent.mm.plugin.voip_cs.b.d bec = com.tencent.mm.plugin.voip_cs.b.b.bec();
        String str = this.kEl.kEf;
        v.d("MicroMsg.voipcs.VoipCSService", "start getBizInfo for username:" + str);
        ak.vy().a(455, bec);
        ak.vy().a(new j(str), 0);
    }

    public final void CR(String str) {
        this.euh.setText(str);
    }

    public final void CS(String str) {
        if (!h.isNullOrEmpty(str)) {
            this.kEG = new b(this);
            if (this.kEl.fSc == null || this.kEl.fSc.equals("")) {
                this.kEH = str;
            } else {
                this.kEH = this.kEl.fSc;
            }
            e.b(this.kEG, "VOIPCS_netPic", 10);
        }
    }

    public final String bel() {
        return "voip_cs_headImageUrl_" + this.kEl.kEf;
    }

    public final String bem() {
        return "voip_cs_nickname_" + this.kEl.kEf;
    }

    private Point gV(boolean z) {
        int height = ((WindowManager) this.kEl.getSystemService("window")).getDefaultDisplay().getHeight() / 5;
        return new Point((int) (gT(!z) * ((float) height)), height);
    }

    private static float gT(boolean z) {
        byte[] bArr;
        float f = 0.74766356f;
        if (z) {
            try {
                bArr = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.field_capInfo;
            } catch (Exception e) {
                v.e("MicroMsg.voipcs.VoipCSViewManager", "update failed: " + e.getMessage());
            }
        } else {
            bArr = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.kvK;
        }
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (wrap.getInt() > 65535) {
                wrap.order(ByteOrder.LITTLE_ENDIAN);
            }
            wrap.getShort();
            wrap.getShort();
            float f2 = ((float) wrap.getInt()) / 100.0f;
            if (f2 != 0.0f) {
                f = f2;
            }
            v.d("MicroMsg.voipcs.VoipCSViewManager", "use rate: %s, changed: %s", new Object[]{Float.valueOf(f), Boolean.valueOf(z)});
        }
        return f;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (view.getId() == 2131759696) {
            if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe < 2) {
                com.tencent.mm.plugin.voip_cs.b.b.bed().aKG = 2;
            } else {
                com.tencent.mm.plugin.voip_cs.b.b.bed().aKG = 4;
            }
            com.tencent.mm.plugin.voip_cs.b.c bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
            bed.kDg = 1;
            bed.kDE = 1;
            bed.kDh = (int) (System.currentTimeMillis() / 1000);
            bed = com.tencent.mm.plugin.voip_cs.b.b.bed();
            v.d("MicroMsg.VoipCSReportHelper", "selfCancel");
            if (bed.kDB == 0) {
                bed.kDw = 3;
                if (bed.kDF == 0 && bed.kDR != 0) {
                    bed.kDF = (long) (((int) (System.currentTimeMillis() / 1000)) - bed.kDR);
                }
            }
            com.tencent.mm.plugin.voip_cs.b.b.bed().bee();
            v.d("MicroMsg.voipcs.VoipCSViewManager", "user click hangup button!");
            onFinish(0);
            return;
        }
        int i = this.hBn.getVisibility() == 0 ? 8 : 0;
        this.hBn.setVisibility(i);
        this.eTg.setVisibility(i);
        this.kEn.setVisibility(i);
        sf(i);
        if (i == 0) {
            z = true;
        }
        gZ(z);
    }

    private void sf(int i) {
        if (this.kEl.kER == null || !this.kEl.kER.equals("1")) {
            this.kyl.setVisibility(8);
        } else {
            this.kyl.setVisibility(i);
        }
    }

    public final void ben() {
        v.i("MicroMsg.voipcs.VoipCSViewManager", "stop capture render");
        if (this.hBQ != null) {
            this.kEm.removeView(this.hBQ);
            this.hBQ = null;
        }
        if (this.hBO != null) {
            this.hBO.bdF();
            this.hBO.bdG();
            this.hBO = null;
        }
    }

    private void beo() {
        v.i("MicroMsg.voipcs.VoipCSViewManager", "trigger dismiss button");
        this.cnC.postDelayed(new Runnable(this) {
            final /* synthetic */ b kEJ;

            {
                this.kEJ = r1;
            }

            public final void run() {
                v.i("MicroMsg.voipcs.VoipCSViewManager", "dismiss button");
                if (!this.kEJ.kEl.isFinishing()) {
                    this.kEJ.hBn.setVisibility(8);
                    this.kEJ.eTg.setVisibility(8);
                    this.kEJ.kEn.setVisibility(8);
                    this.kEJ.sf(8);
                    this.kEJ.gZ(false);
                }
            }
        }, 10000);
    }

    private void gZ(boolean z) {
        if (Build.MANUFACTURER.equalsIgnoreCase("sony")) {
            v.i("MicroMsg.voipcs.VoipCSViewManager", "sony is not compatible,so we return.");
        } else if (z) {
            this.kEl.getWindow().clearFlags(1024);
        } else {
            this.kEl.getWindow().setFlags(1024, 1024);
        }
    }

    public final void atQ() {
        this.kEC.QI();
        this.kED.QI();
        this.kEz.bdp();
        this.kEp.setVisibility(8);
        this.kEo.setText(2131235896);
        this.kEn.setText(2131235884);
        sf(0);
        this.hBF.setOnClickListener(this);
        if (this.kEl.kES != null && this.kEl.kES.equals("1")) {
            this.kxQ.setVisibility(0);
            this.kyC = true;
            Point gV = gV(this.kyC);
            ((MovableVideoView) this.kxQ).cD(gV.x, gV.y);
            bep();
        }
        beo();
        this.kEv = true;
        if (this.fUZ == null) {
            this.fUZ = new Timer("voip_cs_talking_time");
        }
        if (!this.kEt) {
            if (this.kEu == -1) {
                this.kEu = be.Nh();
            }
            this.kEt = true;
            this.fUZ.schedule(new TimerTask(this) {
                final /* synthetic */ b kEJ;

                {
                    this.kEJ = r1;
                }

                public final void run() {
                    this.kEJ.cnC.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass7 kEK;

                        {
                            this.kEK = r1;
                        }

                        public final void run() {
                            this.kEK.kEJ.eTg.setText(b.ao(be.ax(this.kEK.kEJ.kEu)));
                        }
                    });
                }
            }, 1000, 1000);
            k.bct().bcu();
            k.bct().kuD = this;
        }
    }

    public static Drawable CT(String str) {
        try {
            return Drawable.createFromStream((InputStream) new URL(str).getContent(), "urlDrawable");
        } catch (Exception e) {
            v.e("MicroMsg.voipcs.VoipCSViewManager", "parse Drawable faill!");
            return null;
        }
    }

    protected static String ao(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    public final void onFinish(int i) {
        v.i("MicroMsg.voipcs.VoipCSViewManager", "onFinish for action:" + i);
        if (this.fUZ != null) {
            this.fUZ.cancel();
            this.fUZ = null;
        }
        if (!this.kEC.btC()) {
            this.kEC.QI();
        }
        if (!this.kED.btC()) {
            this.kED.QI();
        }
        this.kEz.bdp();
        this.kEt = false;
        this.kEq.setVisibility(0);
        this.kEq.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.kEq.setBackgroundResource(2130839459);
        this.kEq.setCompoundDrawables(null, null, null, null);
        this.kEq.setCompoundDrawablePadding(0);
        this.kEq.setText(sg(i));
        if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe == 2) {
            e.a(new Runnable(this) {
                final /* synthetic */ b kEJ;

                {
                    this.kEJ = r1;
                }

                public final void run() {
                    a bej = a.bej();
                    if (bej.kve != null) {
                        bej.kve.d(2131165831, false, 0);
                    }
                }
            }, "VoipCS_play_end_sound");
        }
        this.cnC.postDelayed(new Runnable(this) {
            final /* synthetic */ b kEJ;

            {
                this.kEJ = r1;
            }

            public final void run() {
                this.kEJ.kEl.finish();
            }
        }, 2000);
    }

    private static int sg(int i) {
        if (i == 1) {
            return 2131235878;
        }
        if (i == 0) {
            return 2131235882;
        }
        if (i == -1 || i == 5) {
            return 2131235891;
        }
        if (i == 403 || i == 404) {
            return 2131235899;
        }
        if (i == 6) {
            return 2131235894;
        }
        if (i == 1001) {
            return 2131235890;
        }
        if (i == 10) {
            return 2131235881;
        }
        if (com.tencent.mm.plugin.voip_cs.b.b.bec().kEe < 2) {
            return 2131235877;
        }
        return 2131235882;
    }

    public final void atR() {
        this.kEq.setVisibility(0);
        this.kEq.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        this.kEq.setBackgroundResource(2130839459);
        this.kEq.setCompoundDrawables(null, null, null, null);
        this.kEq.setCompoundDrawablePadding(0);
        this.kEq.setText(sg(1001));
    }

    public final void atS() {
        this.kEq.setVisibility(8);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3) {
        v.d("MicroMsg.voipcs.VoipCSViewManager", "receive frame data , isPause : " + this.beg);
        if (!this.beg) {
            if (this.kEE.hzY == null) {
                this.kEE.w = i;
                this.kEE.h = i2;
                this.kEE.hzY = new int[(this.kEE.w * this.kEE.h)];
            }
            int i4 = this.hBO.bdH() ? OpenGlRender.kBy : 0;
            int i5 = this.hBO.bdI() ? OpenGlRender.kBx : OpenGlRender.kBw;
            if (this.kEv) {
                v.d("MicroMsg.voipcs.VoipCSViewManager", "videoEncodeToSend , ret = " + com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.videoEncodeToSend(bArr, bArr.length, i, i2, i3));
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = com.tencent.mm.plugin.voip_cs.b.b.beb().gGO;
                com_tencent_mm_plugin_voip_model_v2protocal.kwN++;
            }
            com.tencent.mm.plugin.voip_cs.b.b.beb().gGO.videoEncodeToLocal(bArr, (int) j, i, i2, i3, 75, this.kEE.hzY);
            if (OpenGlRender.kBL == 1) {
                if (this.kyC) {
                    this.kxR.a(this.kEE.hzY, i, i2, (OpenGlRender.kBr + i4) + i5);
                } else {
                    this.kxS.a(this.kEE.hzY, i, i2, (OpenGlRender.kBr + i4) + i5);
                }
            } else if (OpenGlRender.kBL != 2) {
            } else {
                if (this.kyC) {
                    this.kxR.b(bArr, i, i2, (OpenGlRender.kBv + i4) + i5);
                } else {
                    this.kxS.b(bArr, i, i2, (OpenGlRender.kBv + i4) + i5);
                }
            }
        }
    }

    public final void aCN() {
        v.e("MicroMsg.voipcs.VoipCSViewManager", "init camera fail！");
    }

    public final void bep() {
        beq();
        this.kEF = new c(this);
        e.b(this.kEF, "VOIPCS_VideoDecode", 10);
        v.d("MicroMsg.voipcs.VoipCSViewManager", "start video decode thread..");
    }

    public final void beq() {
        if (this.kEF != null) {
            v.d("MicroMsg.voipcs.VoipCSViewManager", "stop videodecode thread...");
            this.kEF.ksO = true;
            e.remove(this.kEF);
            this.kEF = null;
        }
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
