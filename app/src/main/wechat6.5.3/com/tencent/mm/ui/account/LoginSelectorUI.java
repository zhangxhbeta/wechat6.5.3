package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.mobile.MobileInputUI;
import com.tencent.mm.ui.base.b;

@Deprecated
public class LoginSelectorUI extends MMActivity implements OnClickListener {
    private TextView nJO;
    private View nJP;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vB(8);
        a.drq.oz();
        ak.uS();
        NI();
    }

    protected final int getLayoutId() {
        return 2130904330;
    }

    public void onResume() {
        super.onResume();
        ak.uS();
    }

    protected final void NI() {
        Button button = (Button) findViewById(2131759035);
        Button button2 = (Button) findViewById(2131759034);
        this.nJO = (TextView) findViewById(2131759037);
        this.nJP = findViewById(2131759036);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        this.nJO.setText(u.dK(this.nDR.nEl));
        this.nJP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LoginSelectorUI nJQ;

            {
                this.nJQ = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("not_auth_setting", true);
                a.drp.s(intent, this.nJQ.nDR.nEl);
            }
        });
        if (f.nhZ) {
            a.drq.d(this);
        } else {
            a.drq.ah(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Intent ak = a.drp.ak(this);
            ak.addFlags(67108864);
            ak.putExtra("can_finish", true);
            startActivity(ak);
            finish();
            b.ew(this);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onClick(View view) {
        Intent intent;
        if (2131759035 == view.getId()) {
            intent = new Intent(this, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", 5);
            startActivity(intent);
        } else if (2131759034 != view.getId()) {
        } else {
            if (d.lWk) {
                String string = getString(2131232240, new Object[]{"0x" + Integer.toHexString(d.lWh), u.bsY()});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", string);
                intent2.putExtra("showShare", false);
                intent2.putExtra("show_bottom", false);
                intent2.putExtra("needRedirect", false);
                intent2.putExtra("neverGetA8Key", true);
                intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                intent2.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                a.drp.j(intent2, this);
                return;
            }
            be.zN();
            intent = new Intent(this, RegByMobileRegAIOUI.class);
            intent.putExtra("login_type", 0);
            startActivity(intent);
        }
    }
}
