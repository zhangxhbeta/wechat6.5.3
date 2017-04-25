package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.widget.Toast;
import com.tencent.mm.c.b.h;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import java.util.List;

public final class b implements com.tencent.mm.pluginsdk.ui.chat.b {
    p dwg = null;
    ToneGenerator ewH;
    long ewI = -1;
    Toast ewJ;
    private Vibrator ewK;
    final ah exb = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ b hjN;

        {
            this.hjN = r1;
        }

        public final boolean oU() {
            this.hjN.hjH.uh(this.hjN.hjI.getMaxAmplitude());
            return true;
        }
    }, true);
    final ah exc = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ b hjN;

        {
            this.hjN = r1;
        }

        public final boolean oU() {
            if (this.hjN.ewI == -1) {
                this.hjN.ewI = be.Nj();
            }
            long az = be.az(this.hjN.ewI);
            if (az >= 50000 && az <= 60000) {
                int i;
                if (this.hjN.ewJ == null) {
                    i = (int) ((60000 - az) / 1000);
                    this.hjN.ewJ = Toast.makeText(this.hjN.hjG, this.hjN.hjG.getResources().getQuantityString(2131361794, i, new Object[]{Integer.valueOf(i)}), 0);
                } else {
                    i = (int) ((60000 - az) / 1000);
                    this.hjN.ewJ.setText(this.hjN.hjG.getResources().getQuantityString(2131361794, i, new Object[]{Integer.valueOf(i)}));
                }
                this.hjN.ewJ.show();
            }
            if (az < 60000) {
                return true;
            }
            v.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
            if (this.hjN.hjI.ph()) {
                this.hjN.azi();
            }
            this.hjN.hjH.anf();
            ao.T(this.hjN.hjG, 2131235667);
            return false;
        }
    }, true);
    private final com.tencent.mm.v.h.a exf = new com.tencent.mm.v.h.a(this) {
        final /* synthetic */ b hjN;

        {
            this.hjN = r1;
        }

        public final void onError() {
            this.hjN.hjI.reset();
            this.hjN.exb.QI();
            this.hjN.exc.QI();
            ab.Kj("keep_app_silent");
            this.hjN.hjH.anf();
            v.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
            Toast.makeText(this.hjN.hjG, this.hjN.hjG.getString(2131231870), 0).show();
        }
    };
    MassSendMsgUI hjG;
    ChatFooter hjH;
    a hjI;
    private String hjJ;
    private List<String> hjK;
    private boolean hjL;
    private final com.tencent.mm.v.h.b hjM = new com.tencent.mm.v.h.b(this) {
        final /* synthetic */ b hjN;

        {
            this.hjN = r1;
        }

        public final void Bw() {
            this.hjN.hjH.bpK();
        }
    };

    class a extends h {
        String aST;
        final /* synthetic */ b hjN;

        public a(b bVar, Context context) {
            this.hjN = bVar;
            super(context, false);
        }

        public final String getFileName() {
            return this.aST;
        }

        public final boolean ph() {
            this.aST = super.getFileName();
            boolean ph = super.ph();
            super.reset();
            return ph;
        }
    }

    public b(MassSendMsgUI massSendMsgUI, ChatFooter chatFooter, String str, List<String> list, boolean z) {
        this.hjG = massSendMsgUI;
        this.hjH = chatFooter;
        this.hjJ = str;
        this.hjK = list;
        this.hjL = z;
        this.hjI = new a(this, massSendMsgUI);
        this.hjI.a(this.exf);
        this.hjI.a(this.hjM);
        this.ewH = new ToneGenerator(1, 60);
        this.ewK = (Vibrator) massSendMsgUI.getSystemService("vibrator");
    }

    public final boolean azh() {
        this.exb.QI();
        this.exc.QI();
        this.ewI = -1;
        if (this.hjI.ph()) {
            azi();
            this.hjH.anf();
        } else {
            this.hjH.bpI();
        }
        ak.oJ().pT();
        return false;
    }

    final void azi() {
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.hjq = this.hjJ;
        aVar.hjr = this.hjK.size();
        aVar.filename = this.hjI.aST;
        aVar.msgType = 34;
        aVar.hjs = this.hjI.aVe;
        final f fVar = new f(aVar, this.hjL);
        ak.vy().a(fVar, 0);
        MassSendMsgUI massSendMsgUI = this.hjG;
        this.hjG.getString(2131231164);
        this.dwg = g.a(massSendMsgUI, this.hjG.getString(2131234922), true, new OnCancelListener(this) {
            final /* synthetic */ b hjN;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(fVar);
                if (this.hjN.dwg != null) {
                    this.hjN.dwg.dismiss();
                    this.hjN.dwg = null;
                }
            }
        });
    }

    public final boolean azj() {
        this.exb.QI();
        this.exc.QI();
        this.ewI = -1;
        this.hjH.anf();
        a aVar = this.hjI;
        aVar.ph();
        q.lH(aVar.aST);
        ak.oJ().pT();
        return false;
    }

    public final boolean azk() {
        ak.yW();
        if (c.isSDCardAvailable()) {
            this.ewH.startTone(24);
            new ac().postDelayed(new Runnable(this) {
                final /* synthetic */ b hjN;

                {
                    this.hjN = r1;
                }

                public final void run() {
                    this.hjN.ewH.stopTone();
                }
            }, 200);
            this.ewK.vibrate(50);
            this.exb.ea(100);
            this.exc.ea(200);
            this.hjH.ug(this.hjG.getResources().getDisplayMetrics().heightPixels - this.hjH.getHeight());
            this.hjI.by("_USER_FOR_THROWBOTTLE_");
            this.hjI.a(this.hjM);
            this.hjI.a(this.exf);
            ak.oJ().pU();
        } else {
            s.ey(this.hjG);
        }
        return false;
    }

    public final boolean wm(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        MassSendMsgUI.wq(str);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.hjq = this.hjJ;
        aVar.hjr = this.hjK.size();
        aVar.filename = str;
        aVar.msgType = 1;
        final f fVar = new f(aVar, this.hjL);
        ak.vy().a(fVar, 0);
        MassSendMsgUI massSendMsgUI = this.hjG;
        this.hjG.getString(2131231164);
        this.dwg = g.a(massSendMsgUI, this.hjG.getString(2131234922), true, new OnCancelListener(this) {
            final /* synthetic */ b hjN;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(fVar);
                if (this.hjN.dwg != null) {
                    this.hjN.dwg.dismiss();
                    this.hjN.dwg = null;
                }
            }
        });
        return true;
    }

    public final void azl() {
    }

    public final void azm() {
    }

    public final void azn() {
    }

    public final void release() {
        this.ewH.release();
    }

    public final void onPause() {
        this.exb.QI();
        this.exc.QI();
        this.ewI = -1;
        this.hjI.ph();
        ak.oJ().pT();
    }

    public final void eg(boolean z) {
    }
}
