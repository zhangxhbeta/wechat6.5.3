package com.tencent.mm.plugin.backup.moveui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public class BakMoveUI extends MMActivity {
    private ah cXD = new ah(new a(this) {
        final /* synthetic */ BakMoveUI eme;

        {
            this.eme = r1;
        }

        public final boolean oU() {
            this.eme.Wu();
            return true;
        }
    }, true);
    private boolean elb = false;
    private TextView emb;
    private Button emc;
    private TextView emd;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131234983);
        this.emb = (TextView) findViewById(2131755513);
        this.emc = (Button) findViewById(2131755514);
        this.emd = (TextView) findViewById(2131755515);
        this.emc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveUI eme;

            {
                this.eme = r1;
            }

            public final void onClick(View view) {
                if (this.eme.elb) {
                    g.iuh.h(11788, new Object[0]);
                    g.iuh.a(103, 5, 1, false);
                    this.eme.q(BakMoveChooseUI.class);
                }
            }
        });
        this.emd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveUI eme;

            {
                this.eme = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, this.eme.getString(2131231209));
                intent.putExtra("rawUrl", this.eme.getString(2131236707, new Object[]{u.bsY()}));
                intent.putExtra("showShare", false);
                intent.putExtra("neverGetA8Key", true);
                c.b(this.eme, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakMoveUI eme;

            {
                this.eme = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eme.finish();
                return true;
            }
        });
        if (com.tencent.mm.plugin.backup.g.g.VA() < 30) {
            Intent intent = new Intent(aa.getContext(), BakMoveErrUI.class);
            intent.putExtra("battery_not_enough", true);
            intent.addFlags(335544320);
            aa.getContext().startActivity(intent);
            finish();
            return;
        }
        Wu();
    }

    private boolean Wu() {
        if (com.tencent.mm.plugin.backup.g.g.VA() < 30) {
            this.elb = false;
            this.emc.setEnabled(false);
            this.emb.setText(2131231335);
            this.emb.setTextColor(-65536);
            return false;
        }
        v.i("MicroMsg.BakMoveUI", "wifiName :%s", com.tencent.mm.plugin.backup.g.g.bw(this));
        if (be.kS(com.tencent.mm.plugin.backup.g.g.bw(this))) {
            this.elb = false;
            this.emc.setEnabled(false);
            this.emb.setText(2131231347);
            this.emb.setTextColor(-65536);
            return false;
        }
        this.emc.setEnabled(true);
        this.emb.setText(2131231347);
        this.emb.setTextColor(getResources().getColor(2131689909));
        this.elb = true;
        return true;
    }

    public void onResume() {
        super.onResume();
        if (this.cXD != null) {
            this.cXD.ea(5000);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.cXD != null) {
            this.cXD.QI();
        }
    }

    public void onDestroy() {
        v.d("MicroMsg.BakMoveUI", "BakMoveUI onDestroy.");
        super.onDestroy();
        com.tencent.mm.plugin.backup.movemodel.g UR = b.UR();
        synchronized (UR.lock) {
            if (UR.egg != null) {
                UR.egg.cAv = true;
                UR.egg = null;
            }
            e.e(new File(b.Vj()));
        }
        UR = b.UR();
        UR.ekY = new ah(new a(UR) {
            final /* synthetic */ g ekZ;

            {
                this.ekZ = r1;
            }

            public final boolean oU() {
                if (g.eaw != null) {
                    g.eaw.clear();
                }
                g.efQ = null;
                g.eaA = null;
                g.eay = false;
                return true;
            }
        }, false);
        UR.ekY.ea(300000);
    }

    protected final int getLayoutId() {
        return 2130903149;
    }
}
