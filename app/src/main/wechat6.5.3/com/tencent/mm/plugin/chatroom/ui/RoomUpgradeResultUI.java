package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ab.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI extends MMActivity {
    private String biB;
    private o ePs;
    private Button eRF;
    private View eRG;
    private ImageView eRH;
    private TextView eRI;
    private TextView eRJ;
    private TextView eRK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.biB = getIntent().getStringExtra("chatroom");
        v.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[]{this.biB});
        this.ePs = ak.yW().wO().LC(this.biB);
        if (this.ePs == null) {
            goBack();
        }
        NI();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131234674);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomUpgradeResultUI eRL;

            {
                this.eRL = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eRL.goBack();
                return true;
            }
        });
        this.eRG = findViewById(2131756030);
        this.eRH = (ImageView) findViewById(2131756031);
        this.eRI = (TextView) findViewById(2131756032);
        this.eRJ = (TextView) findViewById(2131756034);
        this.eRK = (TextView) findViewById(2131756036);
        this.eRF = (Button) findViewById(2131756037);
        this.eRF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RoomUpgradeResultUI eRL;

            {
                this.eRL = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                String str = "rawUrl";
                intent.putExtra(str, this.eRL.getString(2131231754, new Object[]{u.bsY()}));
                intent.putExtra("geta8key_username", k.xF());
                c.b(this.eRL, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
            }
        });
        this.eRF.setVisibility(0);
        final String str = this.ePs.field_roomowner;
        ak.yW();
        com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || ((int) LX.chr) > 0) {
            qL(str);
        } else {
            a.crZ.a(str, this.biB, new ab.c.a(this) {
                final /* synthetic */ RoomUpgradeResultUI eRL;

                public final void p(String str, boolean z) {
                    if (z) {
                        this.eRL.eRG.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 eRN;

                            {
                                this.eRN = r1;
                            }

                            public final void run() {
                                this.eRN.eRL.qL(str);
                            }
                        });
                    }
                }
            });
        }
        int bvg = this.ePs.bvg();
        this.eRJ.setVisibility(0);
        this.eRJ.setText(getString(2131234682, new Object[]{Integer.valueOf(bvg)}));
        this.eRF.setText(2131234677);
        this.eRK.setVisibility(8);
    }

    private void qL(String str) {
        ak.yW();
        com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX != null && ((int) LX.chr) > 0) {
            CharSequence tT = LX.tT();
            b.m(this.eRH, str);
            this.eRI.setVisibility(0);
            this.eRI.setText(tT);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        Intent intent = new Intent(this, RoomUpgradeUI.class);
        intent.addFlags(67108864);
        intent.putExtra("finish_self", true);
        startActivity(intent);
    }

    protected final int getLayoutId() {
        return 2130903278;
    }
}
