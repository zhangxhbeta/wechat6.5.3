package com.tencent.mm.plugin.voip.widget;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.m;
import com.tencent.mm.plugin.voip.ui.VideoActivity;
import com.tencent.mm.plugin.voip.ui.VoipWarningDialog;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class b implements a {
    private static final String aRh;
    private static final String aRi;
    private ah dwn;
    private WakeLock huF;
    private com.tencent.mm.plugin.voip.ui.b kCN;
    private BaseSmallView kCO;
    private long kCP = -1;
    private boolean kCQ = false;
    private OnClickListener kCR = new OnClickListener(this) {
        final /* synthetic */ b kCT;

        {
            this.kCT = r1;
        }

        public final void onClick(View view) {
            if (this.kCT.kCO != null) {
                this.kCT.kCO.setOnClickListener(null);
            }
            Intent intent = new Intent(aa.getContext(), VideoActivity.class);
            intent.setFlags(268435456);
            aa.getContext().startActivity(intent);
        }
    };
    private ah kCS;
    private CaptureView ktM;
    private u ktQ;
    private boolean ktR;
    private boolean ktS;
    private int ktW = 1;
    private long ktX = -1;
    private boolean kuY = false;
    private int mStatus = -1;

    static {
        String rK = p.rK();
        aRh = rK;
        aRi = o.getString(rK.hashCode());
    }

    public b(com.tencent.mm.plugin.voip.ui.b bVar, int i, u uVar, boolean z, boolean z2, boolean z3) {
        v.i("MicroMsg.Voip.VoipSmallWindow", "initState: %s, talker: %s, isVideoCall: %b", new Object[]{com.tencent.mm.plugin.voip.b.b.rV(i), uVar.field_username, Boolean.valueOf(z)});
        this.ktQ = uVar;
        this.kCN = bVar;
        this.ktS = z;
        this.ktR = z2;
        this.kuY = z3;
        cC(0, i);
        this.huF = ((PowerManager) aa.getContext().getSystemService("power")).newWakeLock(536870922, "MicroMsg.Voip.VoipSmallWindow");
        this.huF.acquire();
    }

    public final void rQ(int i) {
    }

    public final void dJ(boolean z) {
    }

    public final void cC(int i, int i2) {
        if (i2 == this.mStatus) {
            v.d("MicroMsg.Voip.VoipSmallWindow", "state unchange");
            return;
        }
        this.mStatus = i2;
        Integer num;
        String string;
        switch (i2) {
            case 0:
            case 2:
            case 4:
                v.i("MicroMsg.Voip.VoipSmallWindow", "showVideoInviting");
                num = this.kCO == null ? null : (Integer) this.kCO.getTag();
                if (num == null || !(num.intValue() == 0 || 2 == num.intValue() || 4 == num.intValue())) {
                    string = aa.getContext().getString(2131235953);
                    e(string, string, "", true);
                    if (this.kCN != null) {
                        this.kCN.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            case 1:
            case 3:
            case 5:
            case 257:
            case 259:
                if (2 == this.ktW) {
                    sc(2131235853);
                }
                bdZ();
                string = aa.getContext().getString(2131235960);
                e(string, l.er(this.ktQ.field_username), string, true);
                if (this.kCN != null) {
                    this.kCN.a(this, 2);
                    return;
                }
                return;
            case 6:
            case 260:
                v.i("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking");
                this.kCQ = true;
                if (-1 == this.kCP) {
                    this.kCP = System.currentTimeMillis();
                }
                if (com.tencent.mm.compatible.e.b.az(aa.getContext())) {
                    bdW();
                } else {
                    v.e("MicroMsg.Voip.VoipSmallWindow", "showVideoTalking, permission denied");
                    VoipWarningDialog.a(aa.getContext(), new VoipWarningDialog.a(this) {
                        final /* synthetic */ b kCT;

                        {
                            this.kCT = r1;
                        }

                        public final void a(VoipWarningDialog voipWarningDialog) {
                            voipWarningDialog.finish();
                            this.kCT.bdW();
                            String string = aa.getContext().getString(2131235953);
                            this.kCT.e(string, l.er(this.kCT.ktQ.field_username), string, false);
                        }

                        public final void b(VoipWarningDialog voipWarningDialog) {
                            voipWarningDialog.finish();
                        }
                    });
                    if (!d.bbw().kuW) {
                        d.bbw().kuW = true;
                        ak.yW();
                        if (System.currentTimeMillis() - c.vf().vc(327950) > 86400000) {
                            String str = "have not permission to showing floating window\n";
                            ak.yW();
                            c.vf().setLong(327950, System.currentTimeMillis());
                            v.d("MicroMsg.Voip.VoipSmallWindow", "reportRawMessage, len: " + str.length());
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.lWh).append("\n");
                            stringBuilder.append("#accinfo.revision=").append(e.cmU).append("\n");
                            stringBuilder.append("#accinfo.uin=").append(ai.cse.A("last_login_uin", aRi)).append("\n");
                            stringBuilder.append("#accinfo.dev=").append(aRh).append("\n");
                            stringBuilder.append("#accinfo.build=").append(e.cmX).append(":").append(e.cmY).append(":").append(f.aPW).append("\n");
                            stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date())).append("\n");
                            stringBuilder.append("#accinfo.content:\n");
                            Intent intent = new Intent();
                            intent.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                            intent.setAction("uncatch_exception");
                            intent.putExtra("exceptionWriteSdcard", false);
                            intent.putExtra("exceptionPid", Process.myPid());
                            String str2 = "userName";
                            string = ai.cse.A("login_weixin_username", "");
                            if (be.kS(string)) {
                                string = ai.cse.A("login_user_name", "never_login_crash");
                            }
                            intent.putExtra(str2, string);
                            intent.putExtra("tag", "float_window_permission");
                            intent.putExtra("exceptionMsg", Base64.encodeToString((stringBuilder.toString() + str).getBytes(), 2));
                            aa.getContext().startService(intent);
                        }
                    }
                }
                string = aa.getContext().getString(2131235953);
                e(string, l.er(this.ktQ.field_username), string, false);
                return;
            case 7:
            case 261:
                v.i("MicroMsg.Voip.VoipSmallWindow", "showVoiceTalking");
                if (-1 == this.kCP) {
                    this.kCP = System.currentTimeMillis();
                }
                if (2 == this.ktW) {
                    sc(2131235853);
                }
                bdZ();
                this.dwn = new ah(new ah.a(this) {
                    final /* synthetic */ b kCT;

                    {
                        this.kCT = r1;
                    }

                    public final boolean oU() {
                        String d = this.kCT.bdY();
                        this.kCT.e(d, l.er(this.kCT.ktQ.field_username), d, false);
                        return true;
                    }
                }, true);
                this.dwn.ea(5000);
                string = bdY();
                e(string, l.er(this.ktQ.field_username), string, false);
                v.i("MicroMsg.Voip.VoipSmallWindow", "showMini");
                this.kCS = new ah(new ah.a(this) {
                    final /* synthetic */ b kCT;

                    {
                        this.kCT = r1;
                    }

                    public final boolean oU() {
                        d.bbx().CO(this.kCT.bdX());
                        return true;
                    }
                }, true);
                this.kCS.ea(1000);
                Intent intent2 = new Intent();
                intent2.setClass(aa.getContext(), VideoActivity.class);
                intent2.setFlags(268435456);
                intent2.putExtra("Voip_User", this.ktQ.field_username);
                intent2.putExtra("Voip_Outcall", this.ktR);
                intent2.putExtra("Voip_VideoCall", this.ktS);
                d.bbx().I(intent2);
                if (4101 == i) {
                    sc(2131235947);
                }
                if (this.kCN != null) {
                    this.kCN.a(this, 2);
                    return;
                }
                return;
            case 8:
            case 262:
                switch (i) {
                    case 4099:
                        sc(2131235866);
                        break;
                    case 4105:
                        sc(2131235930);
                        break;
                    case 4106:
                        sc(2131235945);
                        break;
                }
                bdZ();
                return;
            case 256:
            case 258:
                v.i("MicroMsg.Voip.VoipSmallWindow", "showCalledVideoInviting");
                num = this.kCO == null ? null : (Integer) this.kCO.getTag();
                if (num == null || !(256 == num.intValue() || 258 == num.intValue())) {
                    string = aa.getContext().getString(2131235953);
                    e(string, string, "", true);
                    if (this.kCN != null) {
                        this.kCN.a(this, 2);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static void sc(int i) {
        Context context = aa.getContext();
        Toast.makeText(context, context.getString(i), 1).show();
    }

    private void bdW() {
        bdZ();
        Context context = aa.getContext();
        d.bbw();
        this.kCO = new a(context, m.gT(false));
        this.kCO.dr(this.ktX);
        context = aa.getContext();
        d.bbw();
        int height = (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 5) + com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 7.0f);
        int a = (int) (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 7.0f)) + (m.gT(true) * ((float) height)));
        this.kCO.cG(a, height);
        this.kCO.setOnClickListener(this.kCR);
        Point point = new Point(a, height);
        v.d("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager");
        if (this.dwn != null) {
            this.dwn.QI();
        }
        if (this.kCS != null) {
            this.kCS.QI();
        }
        ak.oH().cancel(40);
        WindowManager windowManager = (WindowManager) aa.getContext().getSystemService("window");
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        Context context2 = aa.getContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = point.x;
        layoutParams.height = point.y;
        point = d.bbw().kuV;
        if (point == null) {
            ak.yW();
            int i = c.vf().getInt(327947, 0);
            int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context2, 5.0f);
            layoutParams.x = (displayMetrics.widthPixels - layoutParams.width) - a2;
            layoutParams.y = i + a2;
        } else {
            layoutParams.x = point.x;
            layoutParams.y = point.y;
        }
        if (this.ktM != null) {
            this.kCO.a(this.ktM);
        }
        this.kCO.setTag(Integer.valueOf(this.mStatus));
        try {
            windowManager.addView(this.kCO, layoutParams);
        } catch (Exception e) {
            v.e("MicroMsg.Voip.VoipSmallWindow", "addViewToWindowManager failed: %s", new Object[]{e.getMessage()});
        }
        if (this.kCN != null) {
            this.kCN.a(this, 2);
        }
    }

    public final String bdX() {
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.ktX);
        if (this.ktX == -1) {
            currentTimeMillis = 0;
        }
        if (currentTimeMillis >= 3600) {
            return String.format(Locale.US, "%d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        return String.format(Locale.US, "%d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
    }

    private String bdY() {
        int currentTimeMillis = (int) ((System.currentTimeMillis() / 1000) - this.ktX);
        if (this.ktX == -1) {
            currentTimeMillis = 0;
        }
        String string = aa.getContext().getString(2131235960);
        if (currentTimeMillis >= 3600) {
            return string + String.format(Locale.US, "    %d:%02d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 3600), Integer.valueOf((currentTimeMillis % 3600) / 60), Integer.valueOf(currentTimeMillis % 60)});
        }
        return string + String.format(Locale.US, "    %d:%02d", new Object[]{Integer.valueOf(currentTimeMillis / 60), Integer.valueOf(currentTimeMillis % 60)});
    }

    public final void e(final String str, final String str2, final String str3, boolean z) {
        v.h("MicroMsg.Voip.VoipSmallWindow", "breathEffect " + z, new Object[0]);
        if (z) {
            this.dwn = new ah(new ah.a(this) {
                final /* synthetic */ b kCT;
                private int mCount = 0;

                public final boolean oU() {
                    this.mCount++;
                    if (this.kCT.mStatus == 8) {
                        ak.oH().cancel(40);
                        return false;
                    }
                    this.kCT.e(str + (this.mCount % 2 == 1 ? " " : ""), str2, str3, false);
                    return true;
                }
            }, true);
            this.dwn.ea(5000);
        }
        Intent intent = new Intent();
        intent.setClass(aa.getContext(), VideoActivity.class);
        intent.putExtra("Voip_User", this.ktQ.field_username);
        intent.putExtra("Voip_Outcall", this.ktR);
        intent.putExtra("Voip_VideoCall", this.ktS);
        Notification a = com.tencent.mm.plugin.voip.b.d.a(new Builder(aa.getContext()).setTicker(str).setWhen(System.currentTimeMillis()).setContentTitle(str2).setContentText(str3).setContentIntent(PendingIntent.getActivity(aa.getContext(), 40, intent, 134217728)).setOngoing(true));
        a.icon = VERSION.SDK_INT < 19 ? 2130838802 : 2130838803;
        ak.oH().a(40, a, false);
    }

    private void bdZ() {
        v.d("MicroMsg.Voip.VoipSmallWindow", "removeSmallView");
        if (this.kCO != null) {
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.kCO.getLayoutParams();
            d.bbw().kuV = new Point(layoutParams.x, layoutParams.y);
            this.kCO.uninit();
            try {
                ((WindowManager) aa.getContext().getSystemService("window")).removeView(this.kCO);
            } catch (IllegalArgumentException e) {
                v.e("MicroMsg.Voip.VoipSmallWindow", "remove failed", new Object[]{e});
            }
            this.kCO = null;
        }
        if (this.dwn != null) {
            this.dwn.QI();
        }
        d.bbx().CO(aa.getContext().getString(2131233911));
        if (this.kCS != null) {
            this.kCS.QI();
        }
        ak.oH().cancel(40);
        d.bbx().dismiss();
    }

    public final void ai(int i, String str) {
        int i2;
        if (i == 241) {
            Toast.makeText(aa.getContext(), str, 1).show();
        }
        v.d("MicroMsg.Voip.VoipSmallWindow", "getHintByErrorCode " + i);
        if (i == 235) {
            i2 = 2131235903;
        } else if (i == 233) {
            d.bbw().bcG();
            i2 = 2131235902;
        } else {
            i2 = i == 237 ? (!com.tencent.mm.af.b.He() || this.ktS) ? 2131235904 : 2131235906 : i == 236 ? 2131235918 : i == 211 ? 2131235905 : 0;
        }
        if (i2 == 0) {
            sc(2131235901);
        } else {
            sc(i2);
        }
    }

    public final void a(int i, int i2, int[] iArr) {
        if ((260 == this.mStatus || 6 == this.mStatus) && this.kCO != null) {
            this.kCO.a(i, i2, iArr);
        }
    }

    public final void bck() {
        if (this.kCO != null) {
            this.kCO.bck();
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6) {
        if ((260 == this.mStatus || 6 == this.mStatus) && this.kCO != null) {
            this.kCO.a(bArr, j, i, i2, i3, i4, i5);
        }
    }

    public final Context bdk() {
        return null;
    }

    public final void uninit() {
        int i = 3;
        v.d("MicroMsg.Voip.VoipSmallWindow", "uninit");
        if (-1 != this.kCP) {
            g gVar = g.iuh;
            Object[] objArr = new Object[3];
            if (this.kCQ) {
                i = 2;
            }
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Long.valueOf((System.currentTimeMillis() - this.kCP) / 1000);
            objArr[2] = Integer.valueOf(this.kuY ? 1 : 2);
            gVar.h(11620, objArr);
        }
        if (this.huF != null && this.huF.isHeld()) {
            this.huF.release();
        }
        bdZ();
        if (this.dwn != null) {
            this.dwn.QI();
        }
        if (this.kCS != null) {
            this.kCS.QI();
        }
        ak.oH().cancel(40);
        this.ktM = null;
    }

    public final void dr(long j) {
        this.ktX = j;
        if (this.kCO != null) {
            this.kCO.dr(j);
        } else if (261 == this.mStatus || 7 == this.mStatus) {
            String bdY = bdY();
            e(bdY, l.er(this.ktQ.field_username), bdY, false);
        }
    }

    public final void bdl() {
        Toast.makeText(aa.getContext(), 2131235927, 1).show();
    }

    public final void avv() {
    }

    public final void a(CaptureView captureView) {
        this.ktM = captureView;
        if (this.kCO != null && this.ktM != null) {
            if (this.ktM.getParent() != null && (this.ktM.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.ktM.getParent()).removeView(this.ktM);
            }
            this.kCO.a(captureView);
        }
    }
}
