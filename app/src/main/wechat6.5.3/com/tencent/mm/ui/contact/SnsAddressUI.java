package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.k.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SnsAddressUI extends MMBaseSelectContactUI {
    private HashSet<String> dud;
    private List<String> ejp;

    protected final void NH() {
        super.NH();
        this.ejp = new ArrayList();
        Collection g = be.g(be.ah(getIntent().getStringExtra("Block_list"), SQLiteDatabase.KeyEmpty).split(","));
        Collection bHP = r.bHP();
        bHP.addAll(g);
        this.ejp.addAll(bHP);
        this.ejp.addAll(r.bHQ());
        this.dud = new HashSet();
        String ah = be.ah(getIntent().getStringExtra("Select_Contact"), SQLiteDatabase.KeyEmpty);
        if (!be.kS(ah)) {
            this.dud.addAll(be.g(ah.split(",")));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.SnsAddressUI", "Create!");
        a(1, getString(2131231107), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsAddressUI oII;

            {
                this.oII = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                List g = be.g((String[]) this.oII.dud.toArray(new String[0]));
                if (g == null || g.size() == 0) {
                    intent.putExtra("Select_Contact", SQLiteDatabase.KeyEmpty);
                } else {
                    intent.putExtra("Select_Contact", be.b(g, ","));
                }
                this.oII.setResult(-1, intent);
                this.oII.finish();
                ad.g(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 oIJ;

                    {
                        this.oIJ = r1;
                    }

                    public final void run() {
                        if (!this.oIJ.oII.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                            this.oIJ.oII.moveTaskToBack(true);
                        }
                    }
                }, 100);
                return true;
            }
        }, b.nET);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsAddressUI oII;

            {
                this.oII = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oII.finish();
                if (!this.oII.getIntent().getBooleanExtra("stay_in_wechat", true)) {
                    this.oII.moveTaskToBack(true);
                }
                return true;
            }
        });
        Iterator it = this.dud.iterator();
        while (it.hasNext()) {
            this.hkH.Hq((String) it.next());
        }
        this.hkH.lHi = new a(this) {
            final /* synthetic */ SnsAddressUI oII;

            {
                this.oII = r1;
            }

            public final void mf(String str) {
                if (str != null) {
                    this.oII.dud.remove(str);
                    this.oII.NN();
                }
            }
        };
        NN();
    }

    public final void gJ(int i) {
        m bHH = bHH();
        com.tencent.mm.ui.contact.a.a xS = bHH.xS(i - this.ieb.getHeaderViewsCount());
        if (xS != null && xS.euW != null) {
            v.i("MicroMsg.SnsAddressUI", "ClickUser=%s", xS.euW.field_username);
            String str = xS.euW.field_username;
            bHM();
            if (this.dud.contains(str)) {
                this.dud.remove(str);
                this.hkH.Hq(str);
            } else if (this.dud.size() < s.nof) {
                this.dud.add(str);
                this.hkH.Hq(str);
            } else {
                Toast.makeText(this, 2131235482, 0).show();
                v.i("MicroMsg.SnsAddressUI", "select user size equal max size:%d", Integer.valueOf(s.nof));
            }
            NN();
            bHH.notifyDataSetChanged();
        }
    }

    protected final boolean NJ() {
        return true;
    }

    protected final String NK() {
        return be.ah(getIntent().getStringExtra("Add_address_titile"), SQLiteDatabase.KeyEmpty);
    }

    protected final n NL() {
        c.a aVar = new c.a();
        aVar.oER = true;
        aVar.oEX = true;
        aVar.oEZ = getString(2131230866);
        aVar.oEY = be.ah(getIntent().getStringExtra("Add_get_from_sns"), SQLiteDatabase.KeyEmpty);
        return new c(this, this.ejp, true, true, aVar);
    }

    protected final p NM() {
        return new p(this, this.ejp, true, this.scene);
    }

    private void NN() {
        String format;
        boolean z;
        if (this.dud.size() == 0) {
            format = String.format("%s", new Object[]{getString(2131231107)});
        } else {
            format = String.format("%s(%d/%d)", new Object[]{getString(2131231107), Integer.valueOf(this.dud.size()), Integer.valueOf(s.nof)});
        }
        aq(1, format);
        if (this.dud.size() >= 0) {
            z = true;
        } else {
            z = false;
        }
        U(1, z);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 3:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (be.kS(stringExtra)) {
                        v.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS return usernames is null or empty");
                        return;
                    }
                    v.i("MicroMsg.SnsAddressUI", "GET_LABEL_USERS select username=%s", stringExtra);
                    String[] split = stringExtra.split(",");
                    int length = split.length;
                    while (i3 < length) {
                        String str = split[i3];
                        if (this.dud.add(str)) {
                            this.hkH.Hq(str);
                        }
                        i3++;
                    }
                    NN();
                    bHH().notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
    }

    protected final boolean azF() {
        return true;
    }

    protected final void wt(String str) {
        Intent intent = new Intent();
        intent.setClass(this, SelectLabelContactUI.class);
        intent.putExtra("label", str);
        Collection hashSet = new HashSet();
        hashSet.addAll(this.dud);
        intent.putExtra("always_select_contact", be.b(new ArrayList(hashSet), ","));
        intent.putExtra("list_attr", r.s(16384, 64));
        startActivityForResult(intent, 3);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.dud.contains(aVar.euW.field_username);
    }

    public final int[] ayD() {
        return new int[]{131072};
    }

    public final void mf(String str) {
        this.dud.remove(str);
        bHH().notifyDataSetChanged();
        NN();
    }
}
