package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.k.b;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectLabelContactUI extends MMBaseSelectContactUI {
    private HashSet<String> dud;
    private int eSM;
    private String label;
    private HashSet<String> oIn;

    protected final void NH() {
        super.NH();
        this.label = getIntent().getStringExtra("label");
        this.eSM = getIntent().getIntExtra("list_attr", 0);
        this.dud = new HashSet();
        this.oIn = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!be.kS(stringExtra)) {
            this.oIn.addAll(be.g(stringExtra.split(",")));
        }
        if (!be.kS(getIntent().getStringExtra("already_select_contact"))) {
            this.dud.addAll(be.g(stringExtra.split(",")));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (r.dn(this.eSM, 64)) {
            a(1, getString(2131231107), new OnMenuItemClickListener(this) {
                final /* synthetic */ SelectLabelContactUI oIG;

                {
                    this.oIG = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    v.i("MicroMsg.SelectLabelContactUI", "SelectUser: %s", new ArrayList(this.oIG.dud).toString());
                    this.oIG.Pi(be.b(r0, ","));
                    return true;
                }
            }, b.nET);
        }
        NN();
    }

    public final void gJ(int i) {
        m bHH = bHH();
        a xS = bHH.xS(i);
        if (xS != null && xS.euW != null) {
            String str = xS.euW.field_username;
            v.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", str);
            if (!r.dn(this.eSM, 64)) {
                Pi(str);
            } else if (this.oIn.contains(str) || this.dud.contains(str) || !r.dn(this.eSM, 131072) || this.oIn.size() + this.dud.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                if (!this.oIn.contains(str)) {
                    if (this.dud.contains(str)) {
                        this.dud.remove(str);
                    } else {
                        this.dud.add(str);
                    }
                }
                NN();
                bHH.notifyDataSetChanged();
            } else {
                g.a(this.nDR.nEl, getString(2131234864, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE))}), getString(2131231139), new OnClickListener(this) {
                    final /* synthetic */ SelectLabelContactUI oIG;

                    {
                        this.oIG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
    }

    private void NN() {
        if (!r.dn(this.eSM, 64) || this.dud.size() <= 0) {
            aq(1, getString(2131231107));
            U(1, false);
            return;
        }
        aq(1, getString(2131231107) + "(" + this.dud.size() + ")");
        U(1, true);
    }

    private void Pi(String str) {
        if (r.dn(this.eSM, 16384)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Contact", str);
            setResult(-1, intent);
            finish();
            return;
        }
        intent = new Intent();
        intent.setClass(this, ChattingUI.class);
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        startActivity(intent);
        finish();
    }

    protected final boolean NJ() {
        return false;
    }

    protected final String NK() {
        return this.label;
    }

    protected final n NL() {
        return new h(this, r.dn(this.eSM, 64), j.a.bmu().vy(j.a.bmu().vv(this.label)));
    }

    protected final p NM() {
        return null;
    }

    public final boolean a(a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.dud.contains(aVar.euW.field_username);
    }

    public final boolean b(a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.oIn.contains(aVar.euW.field_username);
    }
}
