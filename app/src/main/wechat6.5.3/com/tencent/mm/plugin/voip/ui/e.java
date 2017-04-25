package com.tencent.mm.plugin.voip.ui;

import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.s;
import java.util.Timer;
import java.util.TimerTask;

public final class e extends c {
    private boolean aUy = false;
    private TextView gPg;
    private int ktW = 1;
    private boolean kyD = false;
    private Timer kyE;
    private boolean kyG = false;
    private OnClickListener kyQ = new OnClickListener(this) {
        final /* synthetic */ e kzC;

        {
            this.kzC = r1;
        }

        public final void onClick(View view) {
            g.iuh.h(11618, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
            if (!(this.kzC.kxl == null || this.kzC.kxl.get() == null)) {
                ((b) this.kzC.kxl.get()).gQ(true);
            }
            if (this.kzC.kxA != null) {
                this.kzC.kxA.v(false, true);
            }
        }
    };
    private OnClickListener kyR = new OnClickListener(this) {
        final /* synthetic */ e kzC;

        {
            this.kzC = r1;
        }

        public final void onClick(View view) {
            g.iuh.h(11619, new Object[]{Integer.valueOf(3)});
            if (this.kzC.kxl != null && this.kzC.kxl.get() != null) {
                ((b) this.kzC.kxl.get()).bcp();
            }
        }
    };
    private Runnable kyW = new Runnable(this) {
        final /* synthetic */ e kzC;

        {
            this.kzC = r1;
        }

        public final void run() {
            if (this.kzC.aG() != null && !this.kzC.aG().isFinishing()) {
                this.kzC.kzq.setVisibility(8);
            }
        }
    };
    private Button kyc;
    private OnClickListener kzA = new OnClickListener(this) {
        final /* synthetic */ e kzC;

        {
            this.kzC = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
            if (this.kzC.kxl != null && this.kzC.kxl.get() != null && ((b) this.kzC.kxl.get()).bbU()) {
                this.kzC.bf(this.kzC.getString(2131235907), -1);
            }
        }
    };
    private OnClickListener kzB = new OnClickListener(this) {
        final /* synthetic */ e kzC;

        {
            this.kzC = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
            if (this.kzC.kxl != null && this.kzC.kxl.get() != null && ((b) this.kzC.kxl.get()).bcb()) {
                this.kzC.bf(this.kzC.getString(2131235874), -1);
                this.kzC.kzu.setEnabled(false);
            }
        }
    };
    private View kzd;
    private ImageView kze;
    private TextView kzf;
    private TextView kzg;
    private TextView kzh;
    private TextView kzi;
    private View kzj;
    private RelativeLayout kzk;
    private MMCheckBox kzl;
    private TextView kzm;
    private RelativeLayout kzn;
    private MMCheckBox kzo;
    private TextView kzp;
    private TextView kzq;
    private VoipBigIconButton kzr;
    private VoipBigIconButton kzs;
    private VoipBigIconButton kzt;
    private VoipBigIconButton kzu;
    private VoipSmallIconButton kzv;
    private OnClickListener kzw = new OnClickListener(this) {
        final /* synthetic */ e kzC;

        {
            this.kzC = r1;
        }

        public final void onClick(View view) {
            boolean isChecked = this.kzC.kzl.isChecked();
            v.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[]{Boolean.valueOf(isChecked)});
            this.kzC.kzl.setEnabled(false);
            if (!(this.kzC.kxl == null || this.kzC.kxl.get() == null)) {
                ((b) this.kzC.kxl.get()).gO(isChecked);
            }
            this.kzC.ktW = isChecked ? 1 : 2;
            this.kzC.kzl.setEnabled(true);
        }
    };
    private OnClickListener kzx = new OnClickListener(this) {
        final /* synthetic */ e kzC;

        {
            this.kzC = r1;
        }

        public final void onClick(View view) {
            boolean isChecked = this.kzC.kzo.isChecked();
            v.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[]{Boolean.valueOf(isChecked)});
            this.kzC.kzo.setEnabled(false);
            if (!(this.kzC.kxl == null || this.kzC.kxl.get() == null)) {
                ((b) this.kzC.kxl.get()).ew(isChecked);
            }
            this.kzC.aUy = isChecked;
            this.kzC.kzo.setEnabled(true);
        }
    };
    private OnClickListener kzy = new OnClickListener(this) {
        final /* synthetic */ e kzC;

        {
            this.kzC = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
            g.iuh.a(11526, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(2)});
            if (this.kzC.kxl != null && this.kzC.kxl.get() != null && ((b) this.kzC.kxl.get()).bbZ()) {
                this.kzC.kzr.setEnabled(false);
                this.kzC.kzh.setText(2131235965);
                this.kzC.kxB.a(this.kzC.kzi, c.kxw);
                this.kzC.kzj.setVisibility(0);
                this.kzC.kzg.setVisibility(8);
                this.kzC.kzr.setVisibility(8);
                this.kzC.kzs.setVisibility(8);
                this.kzC.kzt.setVisibility(0);
            }
        }
    };
    private OnClickListener kzz = new OnClickListener(this) {
        final /* synthetic */ e kzC;

        {
            this.kzC = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
            g.iuh.a(11526, true, true, new Object[]{Integer.valueOf(d.bbw().bcB()), Long.valueOf(d.bbw().bcC()), Long.valueOf(d.bbw().bcD()), Integer.valueOf(5)});
            if (this.kzC.kxl != null && this.kzC.kxl.get() != null && ((b) this.kzC.kxl.get()).bbY()) {
                this.kzC.kzs.setEnabled(false);
                this.kzC.kzr.setEnabled(false);
                this.kzC.bf(this.kzC.getString(2131235941), -1);
                if (this.kzC.kxA != null) {
                    this.kzC.kxA.v(true, false);
                }
            }
        }
    };

    public final void onDestroy() {
        this.kyD = false;
        super.onDestroy();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) layoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        v.i("MicroMsg.VoipVoiceFragment", "dpi: " + (((float) displayMetrics.heightPixels) / displayMetrics.density));
        if (((float) displayMetrics.heightPixels) / displayMetrics.density <= 540.0f) {
            this.kxx = (RelativeLayout) layoutInflater.inflate(2130904598, viewGroup, false);
        } else {
            this.kxx = (RelativeLayout) layoutInflater.inflate(2130904597, viewGroup, false);
            if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
                ((RelativeLayout) this.kxx.findViewById(2131759739)).setPadding(0, 0, 0, b.a(aG(), 40.0f));
            }
        }
        this.kxy = (ImageView) this.kxx.findViewById(2131759702);
        this.kzd = this.kxx.findViewById(2131759733);
        this.kze = (ImageView) this.kxx.findViewById(2131759734);
        a.b.a(this.kze, this.bZy, 0.0375f, true);
        this.kzf = (TextView) this.kxx.findViewById(2131759735);
        this.kzf.setText(com.tencent.mm.pluginsdk.ui.d.e.a(aG(), l.er(this.bZy), this.kzf.getTextSize()));
        this.kzg = (TextView) this.kxx.findViewById(2131759746);
        this.kzh = (TextView) this.kxx.findViewById(2131759737);
        this.kzi = (TextView) this.kxx.findViewById(2131759738);
        this.kzj = this.kxx.findViewById(2131759736);
        this.kzq = (TextView) this.kxx.findViewById(2131759745);
        this.gPg = (TextView) this.kxx.findViewById(2131757561);
        b(this.kzi, getResources().getString(2131235949));
        this.kzn = (RelativeLayout) this.kxx.findViewById(2131759747);
        this.kzo = (MMCheckBox) this.kxx.findViewById(2131759748);
        this.kzo.setChecked(this.aUy);
        this.kzp = (TextView) this.kxx.findViewById(2131759749);
        this.kzp.setText(2131235926);
        this.kzk = (RelativeLayout) this.kxx.findViewById(2131759750);
        this.kzl = (MMCheckBox) this.kxx.findViewById(2131759751);
        this.kzm = (TextView) this.kxx.findViewById(2131759752);
        this.kzm.setText(2131235946);
        bdr();
        this.kzr = (VoipBigIconButton) this.kxx.findViewById(2131759741);
        this.kzr.setOnClickListener(this.kzy);
        this.kzs = (VoipBigIconButton) this.kxx.findViewById(2131759740);
        this.kzs.setOnClickListener(this.kzz);
        this.kzt = (VoipBigIconButton) this.kxx.findViewById(2131759743);
        this.kzt.setOnClickListener(this.kzA);
        this.kzu = (VoipBigIconButton) this.kxx.findViewById(2131759744);
        this.kzu.setOnClickListener(this.kzB);
        this.kyG = com.tencent.mm.plugin.voip.b.d.lR("VOIPBlockIgnoreButton") == 0;
        this.kzv = (VoipSmallIconButton) this.kxx.findViewById(2131759742);
        this.kzv.setOnClickListener(this.kyR);
        if (!this.kyG) {
            this.kzv.setVisibility(8);
        }
        this.kzl.setOnClickListener(this.kzw);
        this.kzo.setOnClickListener(this.kzx);
        this.kyc = (Button) this.kxx.findViewById(2131759705);
        this.kyc.setOnClickListener(this.kyQ);
        int eA = s.eA(aG());
        v.d("MicroMsg.VoipVoiceFragment", "statusHeight: " + eA);
        c.A(this.kyc, eA);
        if (this.ktR && 2 == this.ktW) {
            bf(getString(2131235853), 10000);
        }
        this.kyE = new Timer();
        cC(this.kxz, this.mStatus);
        return this.kxx;
    }

    public final void cC(int i, int i2) {
        super.cC(i, i2);
        v.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.b.b.rV(i2));
        if (this.kxx == null) {
            v.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
            return;
        }
        switch (i2) {
            case 1:
                this.kzd.setVisibility(0);
                this.kzg.setVisibility(8);
                this.kzh.setText(2131235935);
                this.kxB.a(this.kzi, kxw);
                this.kzj.setVisibility(0);
                this.kzr.setVisibility(8);
                this.kzs.setVisibility(8);
                this.kzt.setVisibility(8);
                this.kzu.setVisibility(0);
                this.kzv.setVisibility(8);
                this.kzn.setVisibility(0);
                this.kzo.setEnabled(false);
                this.kzo.setBackgroundResource(2130839481);
                this.kzp.setTextColor(1728053247);
                bdr();
                this.kzo.setChecked(this.aUy);
                this.kzk.setVisibility(0);
                if (2 == this.ktW) {
                    bf(getString(2131235853), 10000);
                }
                bdo();
                return;
            case 3:
                this.kzd.setVisibility(0);
                this.kzg.setVisibility(8);
                this.kzh.setText(2131235922);
                this.kxB.a(this.kzi, kxw);
                this.kzj.setVisibility(0);
                this.kzr.setVisibility(8);
                this.kzs.setVisibility(8);
                this.kzt.setVisibility(8);
                this.kzu.setVisibility(0);
                this.kzv.setVisibility(8);
                this.kzn.setVisibility(0);
                this.kzo.setEnabled(false);
                this.kzo.setBackgroundResource(2130839481);
                this.kzp.setTextColor(1728053247);
                bdr();
                this.kzo.setChecked(this.aUy);
                this.kzk.setVisibility(0);
                if (i != 4097 && 2 == this.ktW) {
                    bf(getString(2131235853), 10000);
                }
                bdo();
                return;
            case 5:
                this.kzh.setText(2131235965);
                this.kxB.a(this.kzi, kxw);
                this.kzr.setVisibility(8);
                this.kzs.setVisibility(8);
                this.kzt.setVisibility(0);
                this.kzu.setVisibility(8);
                this.kzv.setVisibility(8);
                return;
            case 7:
            case 261:
                this.kzu.setVisibility(8);
                this.kzr.setVisibility(8);
                this.kzs.setVisibility(8);
                this.kzv.setVisibility(8);
                this.kzj.setVisibility(8);
                this.kxB.bdp();
                this.kzt.setVisibility(0);
                this.kzg.setVisibility(0);
                this.kzn.setVisibility(0);
                this.kzk.setVisibility(0);
                this.kzd.setVisibility(0);
                this.kyc.setVisibility(0);
                this.kzo.setEnabled(true);
                this.kzo.setBackgroundResource(2130839473);
                this.kzp.setTextColor(-1);
                bdr();
                this.kzo.setChecked(this.aUy);
                if (2 == this.ktW) {
                    bf(getString(2131235853), 10000);
                }
                bdo();
                if (this.kyE != null && !this.kyD) {
                    if (-1 == this.kxn) {
                        this.kxn = be.Nh();
                    }
                    this.kyD = true;
                    this.kyE.schedule(new TimerTask(this) {
                        final /* synthetic */ e kzC;

                        {
                            this.kzC = r1;
                        }

                        public final void run() {
                            this.kzC.ihw.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 kzD;

                                {
                                    this.kzD = r1;
                                }

                                public final void run() {
                                    this.kzD.kzC.kzg.setText(c.ao(be.ax(this.kzD.kzC.kxn)));
                                }
                            });
                        }
                    }, 1000, 1000);
                    return;
                }
                return;
            case 8:
            case 262:
                this.kxB.bdp();
                this.kzt.setEnabled(false);
                this.kzu.setEnabled(false);
                this.kzr.setEnabled(false);
                this.kzs.setEnabled(false);
                this.kzv.setEnabled(false);
                return;
            case 257:
                this.kzd.setVisibility(0);
                this.kzj.setVisibility(0);
                this.kzh.setText(2131235923);
                this.kxB.a(this.kzi, kxw);
                bdr();
                this.kzr.setVisibility(0);
                this.kzs.setVisibility(0);
                this.kzt.setVisibility(8);
                this.kzu.setVisibility(8);
                if (this.kyG) {
                    this.kzv.setVisibility(0);
                }
                bf(getString(2131235854), 10000);
                bdo();
                return;
            case 259:
                this.kzd.setVisibility(0);
                this.kzj.setVisibility(0);
                this.kzh.setText(2131235965);
                this.kxB.a(this.kzi, kxw);
                this.kzr.setVisibility(8);
                this.kzs.setVisibility(8);
                this.kzt.setVisibility(0);
                this.kzu.setVisibility(8);
                this.kzv.setVisibility(8);
                bf(getString(2131235854), 10000);
                bdo();
                return;
            default:
                return;
        }
    }

    public final void b(CaptureView captureView) {
    }

    public final void uninit() {
        if (this.kyE != null) {
            this.kyE.cancel();
            this.kyE = null;
        }
        super.uninit();
    }

    protected final void bf(String str, int i) {
        if (this.kzq != null) {
            this.kzq.setText(be.ma(str));
            this.kzq.setVisibility(0);
            this.kzq.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            this.kzq.setBackgroundResource(2130839475);
            this.kzq.setCompoundDrawables(null, null, null, null);
            this.kzq.setCompoundDrawablePadding(0);
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

    public final void dJ(boolean z) {
        this.aUy = z;
        if (this.kzo != null && this.kzp != null) {
            this.kzo.setChecked(z);
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public final void a(int i, int i2, int[] iArr) {
    }

    public final void bck() {
    }

    public final void rQ(int i) {
        this.ktW = i;
        bdr();
    }

    private void bdr() {
        boolean z = false;
        if (this.kzl == null || this.kzm == null) {
            v.e("MicroMsg.VoipVoiceFragment", "speaker is null");
        } else if (4 == this.ktW || 3 == this.ktW) {
            this.kzl.setEnabled(false);
            this.kzm.setTextColor(1728053247);
            this.kzl.setBackgroundResource(2130839470);
        } else {
            if (this.ktW == 1) {
                z = true;
            }
            this.kzl.setBackgroundResource(2130839474);
            this.kzl.setEnabled(true);
            this.kzm.setTextColor(-1);
            this.kzl.setChecked(z);
        }
    }
}
