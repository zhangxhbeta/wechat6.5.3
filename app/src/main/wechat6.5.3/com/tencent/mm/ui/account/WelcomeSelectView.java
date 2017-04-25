package com.tencent.mm.ui.account;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.be;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.account.mobile.MobileInputUI;

public class WelcomeSelectView extends WelcomeView {
    private int QW = 800;
    private Context context;
    private View nJP;
    private Button nML;
    private Button nMM;
    private TextView nMN;

    @TargetApi(11)
    public WelcomeSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bF(context);
    }

    public WelcomeSelectView(Context context) {
        super(context);
        bF(context);
    }

    public final void onResume() {
        init();
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    private void init() {
        String e = u.e(this.context.getSharedPreferences(aa.bti(), 0));
        this.nMN.setText(u.dK(this.context));
        if (e != null && e.equals("language_default")) {
            this.nMN.setText(this.context.getString(2131233560));
        }
        this.nML.setText(2131233299);
        this.nMM.setText(2131233298);
    }

    private void bF(final Context context) {
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(2130904714, this);
        this.nJP = inflate.findViewById(2131760099);
        this.nML = (Button) inflate.findViewById(2131759035);
        this.nMM = (Button) inflate.findViewById(2131759034);
        this.nMN = (TextView) inflate.findViewById(2131760098);
        this.nJP.setVisibility(8);
        this.nMN.setVisibility(8);
        this.nMN.setText(u.dK(context));
        this.QW = context.getResources().getDisplayMetrics().heightPixels;
        this.nMN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WelcomeSelectView nMO;

            {
                this.nMO = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                intent.putExtra("from_login_history", true);
                a.drp.s(intent, this.nMO.getContext());
            }
        });
        this.nML.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WelcomeSelectView nMO;

            public final void onClick(View view) {
                Intent intent = new Intent(context, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 5);
                context.startActivity(intent);
            }
        });
        this.nMM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WelcomeSelectView nMO;

            public final void onClick(View view) {
                if (d.lWk) {
                    String string = context.getString(2131232240, new Object[]{"0x" + Integer.toHexString(d.lWh), u.bsY()});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", string);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                    a.drp.j(intent, context);
                    return;
                }
                be.zN();
                Intent intent2 = new Intent(context, RegByMobileRegAIOUI.class);
                intent2.putExtra("login_type", 0);
                context.startActivity(intent2);
                be.zN();
                b.gM(20);
                b.mi("RE200_100");
                b.b(false, ak.uR() + "," + getClass().getName() + ",R100_100_new," + ak.dR("R100_100_new") + ",2");
                b.mh("R100_100_new");
            }
        });
        init();
    }

    public final void bBn() {
        cz(this.nJP);
        cz(this.nMN);
        this.nJP.setVisibility(0);
        this.nMN.setVisibility(0);
        ad.o(new Runnable(this) {
            final /* synthetic */ WelcomeSelectView nMO;

            {
                this.nMO = r1;
            }

            public final void run() {
                ak.vy().a(new ay(new ay.a(this) {
                    final /* synthetic */ AnonymousClass4 nMP;

                    {
                        this.nMP = r1;
                    }

                    public final void a(e eVar) {
                    }
                }, "launch normal"), 0);
            }
        });
    }
}
