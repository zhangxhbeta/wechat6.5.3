package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.contact.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class SelectLuckyMoneyContactUI extends MMBaseSelectContactUI {
    private List<String> ejp;
    private View hhZ;

    protected final void NH() {
        super.NH();
        Collection hashSet = new HashSet();
        hashSet.addAll(r.bHP());
        hashSet.addAll(r.bHQ());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!be.kS(stringExtra)) {
            hashSet.addAll(be.g(stringExtra.split(",")));
        }
        this.ejp = new ArrayList();
        this.ejp.addAll(hashSet);
    }

    public final void gJ(int i) {
        if (i < this.ieb.getHeaderViewsCount()) {
            v.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
            v.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            int intExtra = getIntent().getIntExtra("key_friends_num", 0);
            Intent intent = new Intent();
            int s = r.s(new int[]{16, 1, 2, 4, 16384, 64, 65536, 131072});
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", s);
            intent.putExtra("max_limit_num", intExtra);
            intent.putExtra("titile", getString(2131233654, new Object[]{Integer.valueOf(intExtra)}));
            intent.putExtra("sub_title", getString(2131236646));
            c.a(this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(2130968646, 2130968623);
            return;
        }
        a aVar = (a) this.ieb.getAdapter().getItem(i);
        if (aVar != null) {
            u uVar = aVar.euW;
            if (uVar != null) {
                String str = uVar.field_username;
                v.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[]{str});
                final Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", str);
                String str2 = null;
                if (m.dE(str)) {
                    str2 = getString(2131234863, new Object[]{Integer.valueOf(i.el(str))});
                }
                com.tencent.mm.pluginsdk.ui.applet.c.b(this.nDR, str, getString(2131234559), str, str2, getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                    final /* synthetic */ SelectLuckyMoneyContactUI hib;

                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            this.hib.setResult(-1, intent2);
                            this.hib.finish();
                        }
                    }
                });
            }
        }
    }

    protected final boolean NJ() {
        return false;
    }

    protected final String NK() {
        return getString(2131233655);
    }

    protected final n NL() {
        return new s(this, this.ejp);
    }

    protected final p NM() {
        return new p(this, this.ejp, false, this.scene);
    }

    public final int[] ayD() {
        return new int[]{131072};
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.hhZ == null) {
            View inflate = View.inflate(this, 2130904324, null);
            this.hhZ = inflate.findViewById(2131755329);
            ((TextView) inflate.findViewById(2131755314)).setText(2131233615);
            listView.addHeaderView(inflate);
        }
        this.hhZ.setVisibility(i);
    }

    protected final void ayE() {
        super.ayE();
        axg();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ayE();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            v.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            v.i("MicroMsg.SelectRemittanceContactUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            v.e("MicroMsg.SelectRemittanceContactUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1) {
            v.i("MicroMsg.SelectRemittanceContactUI", "getIntent = " + getIntent());
            setResult(-1, intent);
            finish();
        }
    }
}
