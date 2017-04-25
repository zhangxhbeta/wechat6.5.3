package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.graphics.Point;
import android.os.Process;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.a.o;
import com.tencent.mm.bd.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.pb.common.c.h;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class f {
    private static final String aRh;
    private static final String aRi;
    public static final int hAX = a.fromDPToPix(aa.getContext(), 8);
    public static final int hBd = a.fromDPToPix(aa.getContext(), 96);
    public static final int hBe = a.fromDPToPix(aa.getContext(), 76);
    public static final int kzE = a.fromDPToPix(aa.getContext(), 125);
    public static final int kzF = a.fromDPToPix(aa.getContext(), 48);
    public g kzG;
    public String kzH;
    private Point kzI;
    public boolean kzJ;

    static {
        String rK = p.rK();
        aRh = rK;
        aRi = o.getString(rK.hashCode());
    }

    public final void I(final Intent intent) {
        if (b.az(aa.getContext())) {
            J(intent);
            return;
        }
        v.e("MicroMsg.VoipVoiceMiniManager", "mini, permission denied");
        VoipWarningDialog.a(aa.getContext(), new VoipWarningDialog.a(this) {
            final /* synthetic */ f kzK;

            public final void a(VoipWarningDialog voipWarningDialog) {
                voipWarningDialog.finish();
                this.kzK.J(intent);
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
                v.d("MicroMsg.VoipVoiceMiniManager", "reportRawMessage, len: " + str.length());
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("\n#client.version=").append(com.tencent.mm.protocal.d.lWh).append("\n");
                stringBuilder.append("#accinfo.revision=").append(e.cmU).append("\n");
                stringBuilder.append("#accinfo.uin=").append(ai.cse.A("last_login_uin", aRi)).append("\n");
                stringBuilder.append("#accinfo.dev=").append(aRh).append("\n");
                stringBuilder.append("#accinfo.build=").append(e.cmX).append(":").append(e.cmY).append(":").append(com.tencent.mm.sdk.platformtools.f.aPW).append("\n");
                Date date = new Date();
                stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
                stringBuilder.append("#accinfo.content:\n");
                Intent intent2 = new Intent();
                intent2.setClassName(aa.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
                intent2.setAction("uncatch_exception");
                intent2.putExtra("exceptionWriteSdcard", false);
                intent2.putExtra("exceptionPid", Process.myPid());
                String str2 = "userName";
                String A = ai.cse.A("login_weixin_username", "");
                if (be.kS(A)) {
                    A = ai.cse.A("login_user_name", "never_login_crash");
                }
                intent2.putExtra(str2, A);
                intent2.putExtra("tag", "float_window_permission");
                intent2.putExtra("exceptionMsg", Base64.encodeToString((stringBuilder.toString() + str).getBytes(), 2));
                aa.getContext().startService(intent2);
            }
        }
    }

    private void J(final Intent intent) {
        if (this.kzG != null) {
            dismiss();
        }
        if (this.kzG == null) {
            this.kzG = new g(aa.getContext());
        }
        this.kzG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ f kzK;

            public final void onClick(View view) {
                intent.addFlags(268435456);
                intent.putExtra("enterMainUiSource", 1);
                aa.getContext().startActivity(intent);
                view.setOnClickListener(null);
            }
        });
        WindowManager windowManager = (WindowManager) aa.getContext().getSystemService("window");
        LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2002;
        layoutParams.format = 1;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        layoutParams.width = hBe;
        layoutParams.height = hBd;
        if (this.kzI == null) {
            ak.yW();
            int i = c.vf().getInt(327947, 0);
            int i2 = hAX;
            layoutParams.x = (a.dv(aa.getContext()) - layoutParams.width) - i2;
            layoutParams.y = i + i2;
        } else {
            layoutParams.x = this.kzI.x;
            layoutParams.y = this.kzI.y;
        }
        try {
            windowManager.addView(this.kzG, layoutParams);
        } catch (Exception e) {
            v.e("MicroMsg.VoipVoiceMiniManager", "add failed", new Object[]{e});
        }
        String stringExtra = intent.getStringExtra("enterMainUiWxGroupId");
        if (h.isNullOrEmpty(stringExtra)) {
            this.kzJ = false;
            j jVar = d.bbw().kuP;
            if (jVar != null && jVar.kul != null) {
                d.bbx().CO(jVar.kul.bdX());
                return;
            }
            return;
        }
        this.kzJ = true;
        this.kzH = stringExtra;
        if (com.tencent.mm.pluginsdk.j.a.lxR == null) {
            v.i("MicroMsg.VoipVoiceMiniManager", "IPluginEvent.Factory.getMultiTalkRoomMgr() is null,return");
        } else if (com.tencent.mm.pluginsdk.j.a.lxR.aCe()) {
            d.bbx().rR(com.tencent.mm.pluginsdk.j.a.lxR.aCs());
        } else {
            d.bbx().CO(aa.getContext().getString(2131233962));
        }
    }

    public final void rR(int i) {
        if (this.kzG != null) {
            CharSequence format = String.format("%02d:%02d", new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i % 60)});
            g gVar = this.kzG;
            gVar.fBO.setTextSize(1, 14.0f);
            gVar.fBO.setText(format);
        }
    }

    public final void CO(String str) {
        if (this.kzG != null) {
            g gVar = this.kzG;
            gVar.fBO.setTextSize(1, 12.0f);
            gVar.fBO.setText(str);
        }
    }

    public final void dismiss() {
        WindowManager windowManager = (WindowManager) aa.getContext().getSystemService("window");
        try {
            if (this.kzG != null) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) this.kzG.getLayoutParams();
                this.kzI = new Point(layoutParams.x, layoutParams.y);
                windowManager.removeView(this.kzG);
                this.kzG.setOnClickListener(null);
                this.kzG = null;
            }
        } catch (Exception e) {
            v.e("MicroMsg.VoipVoiceMiniManager", "remove failed", new Object[]{e});
        }
    }
}
