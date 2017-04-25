package com.tencent.mm.plugin.brandservice.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.d.d;

public class BrandServiceIndexUI extends MMActivity implements a {
    private int cBO = 251658241;
    private TextView eyD = null;
    private BrandServiceSortView eyE;
    private boolean eyF = false;
    private boolean eyG = false;

    protected final int getLayoutId() {
        return 2130903194;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cBO = getIntent().getIntExtra("intent_service_type", 251658241);
        this.eyG = r.dn(getIntent().getIntExtra("list_attr", 0), 16384);
        NI();
        u.Dy().c(this);
    }

    protected void onResume() {
        if (this.eyF) {
            this.eyF = false;
            this.eyE.refresh();
        }
        super.onResume();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        U(1, true);
    }

    protected void onPause() {
        ak.yW();
        c.vf().set(233474, Long.valueOf(System.currentTimeMillis()));
        ak.yW();
        c.vf().set(233473, Long.valueOf(System.currentTimeMillis()));
        ak.yW();
        c.vf().set(233476, Long.valueOf(System.currentTimeMillis()));
        super.onPause();
    }

    protected void onDestroy() {
        this.eyE.release();
        u.Dy().d(this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131230868);
        this.eyE = (BrandServiceSortView) findViewById(2131755696);
        this.eyE.L(true);
        this.eyE.eyG = this.eyG;
        this.eyD = (TextView) findViewById(2131755695);
        this.eyD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI eyH;

            {
                this.eyH = r1;
            }

            public final void onClick(View view) {
            }
        });
        this.eyD.setVisibility(8);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI eyH;

            {
                this.eyH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eyH.finish();
                return true;
            }
        });
        a(0, 2131235684, 2131165206, new OnMenuItemClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI eyH;

            {
                this.eyH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.v("MicroMsg.BrandService.BrandServiceIndexUI", "search btn was clicked.");
                Intent intent = new Intent(this.eyH, BrandServiceLocalSearchUI.class);
                intent.putExtra("is_return_result", this.eyH.eyG);
                intent.addFlags(67108864);
                this.eyH.startActivityForResult(intent, 1);
                return true;
            }
        });
        a(1, 2131230798, 2131165188, new OnMenuItemClickListener(this) {
            final /* synthetic */ BrandServiceIndexUI eyH;

            {
                this.eyH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (h.Ih()) {
                    Intent Ij = h.Ij();
                    Ij.putExtra("KRightBtn", true);
                    Ij.putExtra("ftsneedkeyboard", true);
                    Ij.putExtra("key_load_js_without_delay", true);
                    Ij.putExtra("ftsType", 1);
                    Ij.putExtra("ftsbizscene", 6);
                    Ij.putExtra("rawUrl", h.l(h.a(6, true, 0)));
                    com.tencent.mm.ay.c.b(aa.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", Ij);
                } else {
                    v.e("MicroMsg.BrandService.BrandServiceIndexUI", "fts h5 template not avail");
                }
                this.eyH.U(1, false);
                return true;
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && this.eyG) {
            setResult(-1, intent);
            finish();
        }
    }

    public final void a(String str, i iVar) {
        v.v("MicroMsg.BrandService.BrandServiceIndexUI", "On Storage Change, event : %s.", new Object[]{str});
        this.eyF = true;
    }
}
