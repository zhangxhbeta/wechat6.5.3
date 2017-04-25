package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class SendFeedBackUI extends MMActivity implements e {
    private ProgressDialog dwR = null;
    private TextView iKi = null;
    private EditText idd;

    protected final int getLayoutId() {
        return 2130903472;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        ak.vy().b(153, this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131235016);
        this.idd = (EditText) findViewById(2131755329);
        String stringExtra = getIntent().getStringExtra("intentKeyFrom");
        if (stringExtra != null && stringExtra.equals("fromEnjoyAppDialog")) {
            this.iKi = (TextView) findViewById(2131756628);
            this.iKi.setVisibility(0);
            this.iKi.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SendFeedBackUI iKj;

                {
                    this.iKj = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", this.iKj.getString(2131236647));
                    c.b(this.iKj.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SendFeedBackUI iKj;

            {
                this.iKj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKj.axg();
                this.iKj.finish();
                return true;
            }
        });
        a(0, getString(2131231149), new OnMenuItemClickListener(this) {
            final /* synthetic */ SendFeedBackUI iKj;

            {
                this.iKj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String trim = this.iKj.idd.getText().toString().trim();
                if (trim.length() > 0) {
                    if (trim.startsWith("//traceroute")) {
                        this.iKj.idd.setText("");
                        c.w(this.iKj.nDR.nEl, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                    } else {
                        final l lVar = new l(p.rY(), trim + " key " + az.bxj() + " local key " + az.bxi() + "NetType:" + com.tencent.mm.sdk.platformtools.ak.getNetTypeString(this.iKj.getApplicationContext()) + " hasNeon: " + m.rD() + " isArmv6: " + m.rF() + " isArmv7: " + m.rE());
                        ak.vy().a(153, this.iKj);
                        ak.vy().a(lVar, 0);
                        this.iKj.axg();
                        SendFeedBackUI sendFeedBackUI = this.iKj;
                        SendFeedBackUI sendFeedBackUI2 = this.iKj;
                        this.iKj.getString(2131231164);
                        sendFeedBackUI.dwR = g.a(sendFeedBackUI2, this.iKj.getString(2131231151), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass3 iKl;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(lVar);
                            }
                        });
                    }
                }
                return false;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (i == 0 && i2 == 0) {
            g.a(this, getString(2131235015), getString(2131231164), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SendFeedBackUI iKj;

                {
                    this.iKj = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iKj.finish();
                }
            });
        } else {
            g.a(this, getString(2131235014), getString(2131231164), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SendFeedBackUI iKj;

                {
                    this.iKj = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }
}
