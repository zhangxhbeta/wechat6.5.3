package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.p;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@a(19)
public class SelectRemittanceContactUI extends MMBaseSelectContactUI {
    private List<String> ejp;
    private View hhZ;
    private List<String> isC;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void NH() {
        super.NH();
        String stringExtra = getIntent().getStringExtra("recent_remittance_contact_list");
        v.v("MicroMsg.SelectRemittanceContactUI", "recent list:" + stringExtra);
        this.isC = new ArrayList();
        if (!be.kS(stringExtra)) {
            this.isC = be.g(stringExtra.split(","));
        }
        Collection hashSet = new HashSet();
        hashSet.addAll(r.bHP());
        hashSet.addAll(r.bHQ());
        String stringExtra2 = getIntent().getStringExtra("Select_block_List");
        if (!be.kS(stringExtra2)) {
            hashSet.addAll(be.g(stringExtra2.split(",")));
        }
        this.ejp = new ArrayList();
        this.ejp.addAll(hashSet);
    }

    protected final n NL() {
        return new b(this, this.isC, this.ejp);
    }

    protected final p NM() {
        return new p(this, this.ejp, false, this.scene);
    }

    public final int[] ayD() {
        return new int[]{131072};
    }

    public final void gJ(int i) {
        if (i < this.ieb.getHeaderViewsCount()) {
            v.i("MicroMsg.SelectRemittanceContactUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
            v.i("MicroMsg.SelectRemittanceContactUI", "doCallSelectContactUI");
            Intent intent = new Intent();
            int s = r.s(new int[]{16, 1, 2, 4, 16384});
            intent.putExtra("list_type", 0);
            intent.putExtra("list_attr", s);
            intent.putExtra("titile", getString(2131234544));
            intent.putExtra("sub_title", getString(2131236646));
            c.a(this, ".ui.contact.SelectContactUI", intent, 1);
            overridePendingTransition(2130968646, 2130968623);
            return;
        }
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) this.ieb.getAdapter().getItem(i);
        if (aVar != null) {
            u uVar = aVar.euW;
            if (uVar != null) {
                v.i("MicroMsg.SelectRemittanceContactUI", "doClickUser=%s", new Object[]{uVar.field_username});
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_User", r0);
                setResult(-1, intent2);
                finish();
                axg();
            }
        }
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

    protected final boolean NJ() {
        return false;
    }

    protected final String NK() {
        return getString(2131234548);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.hhZ == null) {
            View inflate = View.inflate(this, 2130904324, null);
            this.hhZ = inflate.findViewById(2131755329);
            ((TextView) inflate.findViewById(2131755314)).setText(2131234523);
            listView.addHeaderView(inflate);
        }
        this.hhZ.setVisibility(i);
    }

    protected final void ayE() {
        super.ayE();
        axg();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ayE();
        }
        return super.onKeyUp(i, keyEvent);
    }
}
