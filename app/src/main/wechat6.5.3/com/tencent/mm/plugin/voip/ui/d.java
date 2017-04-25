package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.MovableVideoView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public final class d extends c {
    private TextView gPg;
    int[] hzY = null;
    private Bitmap jfF = null;
    private CaptureView ktM;
    private OpenGlView kxP;
    private OpenGlView kxQ;
    private OpenGlRender kxR;
    private OpenGlRender kxS;
    private View kxT;
    private ImageView kxU;
    private TextView kxV;
    private TextView kxW;
    private TextView kxX;
    private View kxY;
    private TextView kxZ;
    private int kyA;
    private int kyB = 0;
    private boolean kyC = false;
    private boolean kyD = false;
    private Timer kyE;
    private boolean kyF = false;
    private boolean kyG;
    public long kyH = 0;
    private a kyI;
    private OnClickListener kyJ = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.Voip.VoipVideoFragment", "hangup video talking");
            if (this.kyY.kxl != null && this.kyY.kxl.get() != null && ((b) this.kyY.kxl.get()).bbU()) {
                this.kyY.kyk.setEnabled(false);
                this.kyY.kyj.setEnabled(false);
                this.kyY.bf(this.kyY.getString(2131235907), -1);
            }
        }
    };
    private OnClickListener kyK = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            if (this.kyY.kxl != null && this.kyY.kxl.get() != null) {
                ((b) this.kyY.kxl.get()).bcd();
            }
        }
    };
    private OnClickListener kyL = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            if (this.kyY.kxl != null && this.kyY.kxl.get() != null) {
                ((b) this.kyY.kxl.get()).bcd();
            }
        }
    };
    private OnClickListener kyM = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite use voice button");
            if (ak.isWifi(this.kyY.aG()) || l.bcx()) {
                d.c(this.kyY);
            } else {
                g.a(this.kyY.aG(), 2131235931, 2131235932, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass13 kza;

                    {
                        this.kza = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l.bcw();
                        d.c(this.kza.kyY);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass13 kza;

                    {
                        this.kza = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        d.d(this.kza.kyY);
                    }
                });
            }
        }
    };
    private OnClickListener kyN = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.Voip.VoipVideoFragment", "click accept video invite button");
            if (ak.isWifi(this.kyY.aG()) || (l.bcx() && !ak.is2G(this.kyY.aG()))) {
                d.e(this.kyY);
            } else {
                g.a(this.kyY.aG(), 2131235931, 2131235932, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass14 kzb;

                    {
                        this.kzb = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (!ak.is2G(this.kzb.kyY.aG())) {
                            l.bcw();
                        }
                        d.e(this.kzb.kyY);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass14 kzb;

                    {
                        this.kzb = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        d.d(this.kzb.kyY);
                    }
                });
            }
        }
    };
    private OnClickListener kyO = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.Voip.VoipVideoFragment", "click reject video invite button");
            d.d(this.kyY);
        }
    };
    private OnClickListener kyP = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.Voip.VoipVideoFragment", "click cancel video invite button");
            if (this.kyY.kxl != null && this.kyY.kxl.get() != null && ((b) this.kyY.kxl.get()).bca()) {
                this.kyY.kyk.setEnabled(false);
                this.kyY.kyg.setEnabled(false);
                this.kyY.kya.setVisibility(0);
                this.kyY.kya.setText(2131235874);
            }
        }
    };
    private OnClickListener kyQ = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.report.service.g.iuh.h(11618, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
            if (!(this.kyY.kxl == null || this.kyY.kxl.get() == null)) {
                ((b) this.kyY.kxl.get()).gQ(true);
            }
            if (this.kyY.kxA != null) {
                this.kyY.kxA.v(false, true);
            }
        }
    };
    private OnClickListener kyR = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.report.service.g.iuh.h(11619, new Object[]{Integer.valueOf(2)});
            if (this.kyY.kxl != null && this.kyY.kxl.get() != null) {
                ((b) this.kyY.kxl.get()).bcp();
            }
        }
    };
    private OnClickListener kyS = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            this.kyY.kyv = !this.kyY.kyv;
            if (!this.kyY.kyv) {
                this.kyY.kys.setVisibility(8);
            }
            Toast.makeText(this.kyY.aG(), String.format("mIsShowFaceRect:%b", new Object[]{Boolean.valueOf(this.kyY.kyv)}), 0).show();
        }
    };
    private OnClickListener kyT = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            boolean a = be.a((Boolean) view.getTag(), false);
            view.setTag(Boolean.valueOf(!a));
            if (a) {
                this.kyY.kys.setVisibility(8);
                Toast.makeText(this.kyY.aG(), "stop face detect", 0).show();
            } else {
                Toast.makeText(this.kyY.aG(), "start face detect", 0).show();
            }
            if (this.kyY.kxl != null && this.kyY.kxl.get() != null) {
                ((b) this.kyY.kxl.get()).bcq();
            }
        }
    };
    private OnClickListener kyU = new OnClickListener(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.Voip.VoipVideoFragment", "switch camera");
            this.kyY.kyl.setEnabled(false);
            this.kyY.bdq();
            this.kyY.kyl.setEnabled(true);
            if (this.kyY.kxl != null && this.kyY.kxl.get() != null) {
                ((b) this.kyY.kxl.get()).bcc();
            }
        }
    };
    private Runnable kyV = new Runnable(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void run() {
            v.i("MicroMsg.Voip.VoipVideoFragment", "dismiss bar");
            this.kyY.kyB = this.kyY.kyB - 1;
            if (this.kyY.aG() != null && !this.kyY.aG().isFinishing() && this.kyY.kyB <= 0) {
                this.kyY.kyl.setVisibility(8);
                this.kyY.kyc.setVisibility(8);
                this.kyY.kxZ.setVisibility(8);
                this.kyY.kyk.setVisibility(8);
                this.kyY.kyj.setVisibility(8);
                d.d(this.kyY, false);
            }
        }
    };
    private Runnable kyW = new Runnable(this) {
        final /* synthetic */ d kyY;

        {
            this.kyY = r1;
        }

        public final void run() {
            if (this.kyY.aG() != null && !this.kyY.aG().isFinishing()) {
                this.kyY.kya.setVisibility(8);
            }
        }
    };
    int kyX = 0;
    private TextView kya;
    private RelativeLayout kyb;
    private Button kyc;
    private VoipSmallIconButton kyd;
    private VoipSmallIconButton kye;
    private VoipSmallIconButton kyf;
    private VoipBigIconButton kyg;
    private VoipBigIconButton kyh;
    private VoipBigIconButton kyi;
    private VoipBigIconButton kyj;
    private VoipBigIconButton kyk;
    private VoipBigIconButton kyl;
    private TextView kym;
    private TextView kyn;
    private TextView kyo;
    private TextView kyp;
    private TextView kyq;
    private TextView kyr;
    private e kys = null;
    private Button kyt = null;
    private Button kyu = null;
    private boolean kyv = false;
    private int kyw;
    private int kyx;
    private int kyy;
    private int kyz;

    public class a implements Runnable {
        final /* synthetic */ d kyY;

        public final void run() {
            v.i("MicroMsg.Voip.VoipVideoFragment", "try load blur bitmap");
            final Bitmap A = this.kyY.jfF;
            this.kyY.ihw.post(new Runnable(this) {
                final /* synthetic */ a kzc;

                public final void run() {
                    if (this.kzc.kyY.kxy != null) {
                        this.kzc.kyY.kxy.setBackgroundDrawable(new BitmapDrawable(A));
                    }
                    this.kzc.kyY.kyI = null;
                }
            });
        }
    }

    static /* synthetic */ void c(d dVar) {
        v.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite use voice");
        com.tencent.mm.plugin.report.service.g.iuh.a(11526, true, true, new Object[]{Integer.valueOf(com.tencent.mm.plugin.voip.model.d.bbw().bcB()), Long.valueOf(com.tencent.mm.plugin.voip.model.d.bbw().bcC()), Long.valueOf(com.tencent.mm.plugin.voip.model.d.bbw().bcD()), Integer.valueOf(3)});
        if (dVar.kxl != null && dVar.kxl.get() != null && ((b) dVar.kxl.get()).bbV()) {
            dVar.kyf.setEnabled(false);
            dVar.kyi.setEnabled(false);
            dVar.kyh.setEnabled(false);
            dVar.kxW.setText(2131235965);
            dVar.kxB.a(dVar.kxX, kxw);
        }
    }

    static /* synthetic */ void d(d dVar) {
        v.i("MicroMsg.Voip.VoipVideoFragment", "reject video invite");
        com.tencent.mm.plugin.report.service.g.iuh.a(11526, true, true, new Object[]{Integer.valueOf(com.tencent.mm.plugin.voip.model.d.bbw().bcB()), Long.valueOf(com.tencent.mm.plugin.voip.model.d.bbw().bcC()), Long.valueOf(com.tencent.mm.plugin.voip.model.d.bbw().bcD()), Integer.valueOf(4)});
        if (dVar.kxl != null && dVar.kxl.get() != null && ((b) dVar.kxl.get()).bbW()) {
            dVar.bf(dVar.getString(2131235941), -1);
            dVar.kyh.setEnabled(false);
            dVar.kyi.setEnabled(false);
            dVar.kyf.setEnabled(false);
        }
    }

    static /* synthetic */ void d(d dVar, boolean z) {
        if (z) {
            dVar.aG().getWindow().clearFlags(1024);
        } else {
            dVar.aG().getWindow().setFlags(1024, 1024);
        }
    }

    static /* synthetic */ void e(d dVar) {
        v.i("MicroMsg.Voip.VoipVideoFragment", "accept video invite");
        com.tencent.mm.plugin.report.service.g.iuh.a(11526, true, true, new Object[]{Integer.valueOf(com.tencent.mm.plugin.voip.model.d.bbw().bcB()), Long.valueOf(com.tencent.mm.plugin.voip.model.d.bbw().bcC()), Long.valueOf(com.tencent.mm.plugin.voip.model.d.bbw().bcD()), Integer.valueOf(1)});
        if (dVar.kxl != null && dVar.kxl.get() != null && ((b) dVar.kxl.get()).bbX()) {
            dVar.kyi.setEnabled(false);
            dVar.kyh.setEnabled(false);
            dVar.kyf.setEnabled(false);
            dVar.kyg.setVisibility(8);
        }
    }

    static /* synthetic */ void t(d dVar) {
        m bbw = com.tencent.mm.plugin.voip.model.d.bbw();
        int i = dVar.kyx;
        com.tencent.mm.plugin.voip.model.g gVar = bbw.kuO.kqI.kse;
        gVar.kqI.ksc.kwD = i;
        gVar.kqI.ksc.kwE = 0;
        if (q.dqX) {
            long Nh = be.Nh();
            int i2 = (int) (Nh - dVar.kyH);
            if (i2 <= 1) {
                i2 = 1;
            }
            CharSequence format = String.format(Locale.US, "Cap Fps: %d", new Object[]{Integer.valueOf(dVar.kyx)});
            CharSequence format2 = String.format(Locale.US, "Send Fps: %d", new Object[]{Integer.valueOf(dVar.kyw)});
            CharSequence format3 = String.format(Locale.US, "Recv Fps: %d", new Object[]{Integer.valueOf(dVar.kyy)});
            int i3 = com.tencent.mm.plugin.voip.model.d.bbw().kuO.kqI.kse.kqI.ksc.field_sendVideoLen;
            int i4 = com.tencent.mm.plugin.voip.model.d.bbw().kuO.kqI.kse.kqI.ksc.field_recvVideoLen;
            dVar.kyz = (int) ((((double) (i3 - dVar.kyz)) * 8.0d) / ((double) (i2 * BaseReportManager.MAX_READ_COUNT)));
            dVar.kyA = (int) ((((double) (i4 - dVar.kyA)) * 8.0d) / ((double) (i2 * BaseReportManager.MAX_READ_COUNT)));
            CharSequence format4 = String.format(Locale.US, "Send Br: %d", new Object[]{Integer.valueOf(dVar.kyz)});
            CharSequence format5 = String.format(Locale.US, "Recv Br: %d", new Object[]{Integer.valueOf(dVar.kyA)});
            byte[] bArr = com.tencent.mm.plugin.voip.model.d.bbw().kuO.kqI.ksc.kwF;
            if (bArr != null) {
                try {
                    dVar.kyr.setText(new String(bArr, "UTF-8"));
                } catch (Throwable e) {
                    v.a("MicroMsg.Voip.VoipVideoFragment", e, "", new Object[0]);
                }
            }
            dVar.kym.setText(format);
            dVar.kyn.setText(format2);
            dVar.kyo.setText(format3);
            dVar.kyq.setText(format5);
            dVar.kyp.setText(format4);
            dVar.kyz = i3;
            dVar.kyA = i4;
            dVar.kyH = Nh;
        }
        dVar.kyx = 0;
        dVar.kyw = 0;
        dVar.kyy = 0;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.kxx = (RelativeLayout) layoutInflater.inflate(2130904596, viewGroup, false);
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            ((RelativeLayout) this.kxx.findViewById(2131759718)).setPadding(0, 0, 0, b.a(aG(), 40.0f));
        }
        this.kxy = (ImageView) this.kxx.findViewById(2131759702);
        this.kyb = (RelativeLayout) this.kxx.findViewById(2131759704);
        this.kxP = (OpenGlView) this.kxx.findViewById(2131759703);
        this.kxP.cE(mScreenWidth, mScreenHeight);
        this.kyl = (VoipBigIconButton) this.kxx.findViewById(2131759729);
        this.kyl.setOnClickListener(this.kyU);
        this.kyk = (VoipBigIconButton) this.kxx.findViewById(2131759728);
        this.kyk.setOnClickListener(this.kyK);
        this.kyg = (VoipBigIconButton) this.kxx.findViewById(2131759719);
        this.kyg.setOnClickListener(this.kyP);
        this.kyj = (VoipBigIconButton) this.kxx.findViewById(2131759725);
        this.kyj.setOnClickListener(this.kyJ);
        this.kyi = (VoipBigIconButton) this.kxx.findViewById(2131759723);
        this.kyi.setOnClickListener(this.kyN);
        this.kyf = (VoipSmallIconButton) this.kxx.findViewById(2131759724);
        this.kyf.setOnClickListener(this.kyM);
        this.kyh = (VoipBigIconButton) this.kxx.findViewById(2131759721);
        this.kyh.setOnClickListener(this.kyO);
        this.kye = (VoipSmallIconButton) this.kxx.findViewById(2131759720);
        this.kye.setOnClickListener(this.kyL);
        this.kyG = com.tencent.mm.plugin.voip.b.d.lR("VOIPBlockIgnoreButton") == 0;
        this.kyd = (VoipSmallIconButton) this.kxx.findViewById(2131759722);
        this.kyd.setOnClickListener(this.kyR);
        if (!this.kyG) {
            this.kyd.setVisibility(8);
        }
        this.kxZ = (TextView) this.kxx.findViewById(2131759727);
        this.kxT = this.kxx.findViewById(2131759706);
        this.kxU = (ImageView) this.kxx.findViewById(2131759707);
        com.tencent.mm.pluginsdk.ui.a.b.a(this.kxU, this.bZy, 0.05882353f, true);
        this.kxV = (TextView) this.kxx.findViewById(2131759708);
        this.kxW = (TextView) this.kxx.findViewById(2131759710);
        this.kxX = (TextView) this.kxx.findViewById(2131759711);
        this.kxY = this.kxx.findViewById(2131759709);
        b(this.kxX, getResources().getString(2131235949));
        this.kya = (TextView) this.kxx.findViewById(2131759730);
        this.kyc = (Button) this.kxx.findViewById(2131759705);
        this.gPg = (TextView) this.kxx.findViewById(2131757561);
        if (q.dqX) {
            this.kym = (TextView) this.kxx.findViewById(2131759712);
            this.kyn = (TextView) this.kxx.findViewById(2131759713);
            this.kyo = (TextView) this.kxx.findViewById(2131759714);
            this.kyp = (TextView) this.kxx.findViewById(2131759715);
            this.kyq = (TextView) this.kxx.findViewById(2131759716);
            this.kyr = (TextView) this.kxx.findViewById(2131759717);
        }
        this.kyt = (Button) this.kxx.findViewById(2131759731);
        this.kyu = (Button) this.kxx.findViewById(2131759732);
        this.kyt.setVisibility(8);
        this.kyu.setVisibility(8);
        this.kyt.setOnClickListener(this.kyS);
        this.kyu.setOnClickListener(this.kyT);
        this.kys = new e(aG());
        this.kxx.addView(this.kys);
        this.kys.setVisibility(8);
        this.kyc.setOnClickListener(this.kyQ);
        c(this.ktM);
        int eA = s.eA(aG());
        v.d("MicroMsg.Voip.VoipVideoFragment", "statusHeight: " + eA);
        c.A(this.kyc, eA);
        c.A(this.kxx.findViewById(2131759726), eA);
        c.A(this.kxT, eA);
        this.kyx = 0;
        this.kyw = 0;
        this.kyy = 0;
        this.kyz = 0;
        this.kyA = 0;
        WindowManager windowManager = (WindowManager) aG().getSystemService("window");
        int height = windowManager.getDefaultDisplay().getHeight() / 5;
        int width = (windowManager.getDefaultDisplay().getWidth() * height) / windowManager.getDefaultDisplay().getHeight();
        this.kxQ = new MovableVideoView(aG().getApplicationContext());
        ((MovableVideoView) this.kxQ).cD(width, height);
        this.kxQ.setVisibility(8);
        this.kxR = new OpenGlRender(this.kxQ, OpenGlRender.kBA);
        this.kxQ.a(this.kxR);
        this.kxQ.setRenderMode(0);
        this.kxS = new OpenGlRender(this.kxP, OpenGlRender.kBz);
        this.kxP.a(this.kxS);
        this.kxP.setRenderMode(0);
        if (Build.MODEL.equals("Nexus 6")) {
            this.kxQ.setZOrderOnTop(true);
        } else {
            this.kxQ.setZOrderMediaOverlay(true);
        }
        this.kxx.addView(this.kxQ);
        this.kxQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d kyY;

            {
                this.kyY = r1;
            }

            public final void onClick(View view) {
                boolean z;
                d dVar = this.kyY;
                if (this.kyY.kyC) {
                    z = false;
                } else {
                    z = true;
                }
                dVar.kyC = z;
                dVar = this.kyY;
                if (this.kyY.kyC) {
                    z = false;
                } else {
                    z = true;
                }
                Point c = dVar.gV(z);
                this.kyY.kxQ.cF(c.x, c.y);
                com.tencent.mm.plugin.report.service.g.iuh.h(11079, new Object[]{Integer.valueOf(3)});
            }
        });
        this.kxV.setText(com.tencent.mm.pluginsdk.ui.d.e.a(aG(), com.tencent.mm.model.l.er(this.bZy), this.kxV.getTextSize()));
        if (!this.ktR) {
            this.kyC = !this.kyC;
        }
        if (this.ktR) {
            this.ihw.postDelayed(new Runnable(this) {
                final /* synthetic */ d kyY;

                {
                    this.kyY = r1;
                }

                public final void run() {
                    this.kyY.kxW.setText(2131235922);
                    this.kyY.kxB.a(this.kyY.kxX, c.kxw);
                }
            }, 2000);
        }
        this.kyE = new Timer("VoIP_video_talking_count");
        this.kyF = true;
        cC(0, this.mStatus);
        return this.kxx;
    }

    public final void onDestroy() {
        this.kyD = false;
        super.onDestroy();
    }

    private void bdq() {
        v.i("MicroMsg.Voip.VoipVideoFragment", "trigger dismiss bar");
        this.kyB++;
        this.ihw.postDelayed(this.kyV, 10000);
    }

    public final void cC(int i, int i2) {
        super.cC(i, i2);
        v.i("MicroMsg.Voip.VoipVideoFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.rV(i2));
        if (this.kxx == null) {
            v.i("MicroMsg.Voip.VoipVideoFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 0:
            case 2:
                this.kxY.setVisibility(0);
                this.kyb.setVisibility(0);
                this.kxP.setVisibility(0);
                this.kxW.setText(2131235922);
                this.kxy.setVisibility(8);
                this.kya.setVisibility(8);
                this.kxB.a(this.kxX, kxw);
                this.kyl.setVisibility(8);
                this.kyk.setVisibility(8);
                this.kyg.setVisibility(0);
                this.kyj.setVisibility(8);
                this.kyi.setVisibility(8);
                this.kyf.setVisibility(8);
                this.kyh.setVisibility(8);
                this.kye.setVisibility(0);
                this.kyd.setVisibility(8);
                return;
            case 4:
            case 258:
                this.kxW.setText(2131235965);
                this.kxB.a(this.kxX, kxw);
                return;
            case 6:
            case 260:
                this.kxx.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d kyY;

                    {
                        this.kyY = r1;
                    }

                    public final void onClick(View view) {
                        int i;
                        boolean z = false;
                        com.tencent.mm.plugin.report.service.g.iuh.h(11079, new Object[]{Integer.valueOf(4)});
                        if (!(this.kyY.kyC || this.kyY.kxl.get() == null)) {
                            this.kyY.kyl.getVisibility();
                        }
                        if (this.kyY.kyl.getVisibility() == 0) {
                            i = 4;
                        } else {
                            boolean z2 = false;
                        }
                        int i2 = i == 0 ? 0 : 8;
                        this.kyY.kyl.setVisibility(i2);
                        this.kyY.kyc.setVisibility(i2);
                        this.kyY.kxZ.setVisibility(i2);
                        this.kyY.kyj.setVisibility(i2);
                        this.kyY.kyk.setVisibility(i2);
                        d dVar = this.kyY;
                        if (i2 == 0) {
                            z = true;
                        }
                        d.d(dVar, z);
                        if (q.dqX) {
                            this.kyY.kym.setVisibility(i2);
                            this.kyY.kyn.setVisibility(i2);
                            this.kyY.kyo.setVisibility(i2);
                            this.kyY.kyp.setVisibility(i2);
                            this.kyY.kyq.setVisibility(i2);
                            this.kyY.kyr.setVisibility(i2);
                        }
                        if (i == 0) {
                            this.kyY.bdq();
                        }
                    }
                });
                if (this.kxQ.getVisibility() != 0) {
                    if (this.ktR) {
                        this.kyC = !this.kyC;
                        Point gV = gV(!this.kyC);
                        this.kxQ.cF(gV.x, gV.y);
                    }
                    if (q.dqX) {
                        this.kym.setVisibility(0);
                        this.kyn.setVisibility(0);
                        this.kyo.setVisibility(0);
                        this.kyp.setVisibility(0);
                        this.kyq.setVisibility(0);
                        this.kyr.setVisibility(0);
                    }
                    this.kxT.setVisibility(8);
                    this.kxP.setVisibility(0);
                    this.kxQ.setVisibility(0);
                    this.kxZ.setVisibility(0);
                    this.kyc.setVisibility(0);
                    this.kyb.setVisibility(0);
                    this.kyl.setVisibility(0);
                    this.kyk.setVisibility(0);
                    this.kyg.setVisibility(8);
                    this.kyj.setVisibility(0);
                    this.kyi.setVisibility(8);
                    this.kyf.setVisibility(8);
                    this.kyh.setVisibility(8);
                    this.kye.setVisibility(8);
                    this.kyd.setVisibility(8);
                    Point gV2 = gV(!this.kyC);
                    ((MovableVideoView) this.kxQ).cD(gV2.x, gV2.y);
                    if (!(this.kyE == null || this.kyD)) {
                        if (-1 == this.kxn) {
                            this.kxn = be.Nh();
                        }
                        this.kyH = this.kxn;
                        this.kyD = true;
                        this.kyE.schedule(new TimerTask(this) {
                            final /* synthetic */ d kyY;

                            {
                                this.kyY = r1;
                            }

                            public final void run() {
                                this.kyY.ihw.post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass9 kyZ;

                                    {
                                        this.kyZ = r1;
                                    }

                                    public final void run() {
                                        this.kyZ.kyY.kxZ.setText(c.ao(be.ax(this.kyZ.kyY.kxn)));
                                        d.t(this.kyZ.kyY);
                                    }
                                });
                            }
                        }, 1000, 1000);
                    }
                    if (aa.btk().getBoolean("voipfaceDebug", false)) {
                        this.kyt.setVisibility(0);
                        this.kyu.setVisibility(0);
                    }
                    bdq();
                    return;
                }
                return;
            case 8:
            case 262:
                this.kxB.bdp();
                this.kyg.setEnabled(false);
                this.kyk.setEnabled(false);
                this.kyj.setEnabled(false);
                this.kyi.setEnabled(false);
                this.kyh.setEnabled(false);
                this.kyf.setEnabled(false);
                this.kyl.setEnabled(false);
                this.kye.setEnabled(false);
                this.kyd.setEnabled(false);
                switch (i) {
                    case 4105:
                        this.kya.setVisibility(0);
                        this.kya.setText(2131235930);
                        break;
                }
                if (this.kxA != null) {
                    this.kxA.v(true, false);
                    return;
                }
                return;
            case 256:
                this.kxP.setVisibility(8);
                this.kxT.setVisibility(0);
                this.kxV.setVisibility(0);
                this.kxW.setText(2131235924);
                this.kxY.setVisibility(0);
                this.kxU.setVisibility(0);
                this.kxB.a(this.kxX, kxw);
                this.kyl.setVisibility(8);
                this.kyk.setVisibility(8);
                this.kyg.setVisibility(8);
                this.kyj.setVisibility(8);
                this.kyi.setVisibility(0);
                this.kyf.setVisibility(0);
                this.kyh.setVisibility(0);
                this.kye.setVisibility(8);
                if (this.kyG) {
                    this.kyd.setVisibility(0);
                }
                bdo();
                return;
            default:
                return;
        }
    }

    public final void b(CaptureView captureView) {
        this.ktM = captureView;
        c(this.ktM);
    }

    public final void uninit() {
        this.kxQ.setVisibility(4);
        if (this.ktM != null) {
            this.kxx.removeView(this.ktM);
            this.ktM = null;
            v.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView removed");
        }
        if (this.kyI != null) {
            com.tencent.mm.sdk.i.e.remove(this.kyI);
            this.kyI = null;
        }
        super.uninit();
    }

    public final void dJ(boolean z) {
    }

    public final void onStop() {
        this.kxS.bdN();
        this.kxR.bdN();
        super.onStop();
    }

    public final void onStart() {
        this.kxS.kBg = true;
        this.kxR.kBg = true;
        super.onStart();
    }

    protected final void bf(String str, int i) {
        if (this.kya != null) {
            this.kya.setText(be.ma(str));
            this.kya.setVisibility(0);
            this.kya.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.kya.setBackgroundResource(2130839475);
            this.kya.setCompoundDrawables(null, null, null, null);
            this.kya.setCompoundDrawablePadding(0);
            this.ihw.removeCallbacks(this.kyW);
            if (-1 != i) {
                this.ihw.postDelayed(this.kyW, (long) i);
            }
        }
    }

    protected final void bdm() {
        if (this.gPg != null) {
            this.gPg.clearAnimation();
            this.gPg.setVisibility(0);
        }
    }

    protected final void bdn() {
        if (this.gPg != null) {
            this.gPg.clearAnimation();
            this.gPg.setVisibility(8);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.kyF) {
            if (OpenGlRender.kBL == 1) {
                if (this.kyX < i * i2) {
                    this.hzY = null;
                }
                if (this.hzY == null) {
                    this.kyX = i * i2;
                    this.hzY = new int[this.kyX];
                }
                if (com.tencent.mm.plugin.voip.model.d.bbw().a(bArr, (int) j, i3 & 31, i, i2, this.hzY) >= 0 && this.hzY != null) {
                    if (this.kyC) {
                        this.kxR.a(this.hzY, i, i2, (OpenGlRender.kBr + i4) + i5);
                    } else {
                        this.kxS.a(this.hzY, i, i2, (OpenGlRender.kBr + i4) + i5);
                    }
                } else {
                    return;
                }
            } else if (OpenGlRender.kBL == 2) {
                if (this.kyC) {
                    this.kxR.b(bArr, i, i2, (OpenGlRender.kBv + i4) + i5);
                } else {
                    this.kxS.b(bArr, i, i2, (OpenGlRender.kBv + i4) + i5);
                }
            }
            this.kyx++;
            if (i6 > 0) {
                this.kyw++;
            }
            e eVar = this.kys;
            eVar.kAF = i;
            eVar.kAG = i2;
            eVar = this.kys;
            int width = this.kxx.getWidth();
            int height = this.kxx.getHeight();
            eVar.kAE = width;
            eVar.ff = height;
        }
    }

    public final void a(int i, int i2, int[] iArr) {
        if (this.kyF) {
            this.kyy++;
            if (OpenGlRender.kBL == 1) {
                if (this.kyC) {
                    this.kxS.a(iArr, i, i2, OpenGlRender.kBq + OpenGlRender.kBw);
                } else {
                    this.kxR.a(iArr, i, i2, OpenGlRender.kBq + OpenGlRender.kBw);
                }
            } else if (this.kyC) {
                this.kxS.a(iArr, i, i2, OpenGlRender.kBt + OpenGlRender.kBw);
            } else {
                this.kxR.a(iArr, i, i2, OpenGlRender.kBt + OpenGlRender.kBw);
            }
        }
    }

    public final void bck() {
        if (this.kyF) {
            this.kxS.bdO();
            this.kxR.bdO();
        }
    }

    private void c(CaptureView captureView) {
        if (this.kxx != null && captureView != null) {
            this.kxx.removeView(this.ktM);
            this.ktM = null;
            this.ktM = captureView;
            this.kxx.addView(captureView, new LayoutParams(1, 1));
            this.ktM.setVisibility(0);
            v.d("MicroMsg.Voip.VoipVideoFragment", "CaptureView added");
        }
    }

    public final void onDetach() {
        v.i("MicroMsg.Voip.VoipVideoFragment", "onDetach");
        if (this.kyE != null) {
            this.kyE.cancel();
            this.kyE = null;
        }
        super.onDetach();
    }

    public final void rQ(int i) {
    }

    private Point gV(boolean z) {
        int height = (int) (((double) aG().getWindowManager().getDefaultDisplay().getHeight()) / 5.0d);
        float f = (float) height;
        com.tencent.mm.plugin.voip.model.d.bbw();
        return new Point((int) (f * m.gT(z)), height);
    }
}
