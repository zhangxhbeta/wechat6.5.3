package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.e.a.hz;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class a implements e {
    public String biB = SQLiteDatabase.KeyEmpty;
    public Context context;
    public p dwg;
    public String hUb = SQLiteDatabase.KeyEmpty;
    private LinkedList<String> ihX;
    private LinkedList<Integer> ihY;
    private a lJe;
    public b lJf;
    public String lJg;
    String lJh = SQLiteDatabase.KeyEmpty;
    public String lJi;
    public String lJj;
    public boolean lJk = true;
    public boolean lJl = true;
    public String lJm = SQLiteDatabase.KeyEmpty;
    public boolean lJn = false;

    public interface a {
        void a(boolean z, boolean z2, String str, String str2);
    }

    public interface b {
        boolean avs();
    }

    public a(Context context, a aVar) {
        this.context = context;
        this.lJe = aVar;
        this.ihX = new LinkedList();
        this.dwg = null;
    }

    public final void c(String str, LinkedList<Integer> linkedList) {
        b(str, linkedList, false);
    }

    public final void b(String str, LinkedList<Integer> linkedList, boolean z) {
        boolean z2 = str != null && str.length() > 0;
        Assert.assertTrue(z2);
        if (linkedList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.lJk = z;
        onStart();
        if (this.lJl) {
            Context context = this.context;
            this.context.getString(2131231164);
            this.dwg = g.a(context, this.context.getString(2131231996), true, new OnCancelListener(this) {
                final /* synthetic */ a lJo;

                {
                    this.lJo = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.lJo.c(false, false, this.lJo.lJh, this.lJo.lJm);
                }
            });
        }
        this.ihY = linkedList;
        this.ihX.add(str);
        this.lJh = str;
        k mVar = new m(1, this.ihX, linkedList, SQLiteDatabase.KeyEmpty, this.hUb, null, this.biB);
        if (!be.kS(this.lJi)) {
            mVar.dh(this.lJi, this.lJj);
        }
        ak.vy().a(mVar, 0);
    }

    private void c(boolean z, boolean z2, String str, String str2) {
        if (this.lJe != null) {
            this.lJe.a(z, z2, str, str2);
        }
        if (z) {
            com.tencent.mm.sdk.c.b hzVar = new hz();
            hzVar.bhS.username = str;
            com.tencent.mm.sdk.c.a.nhr.z(hzVar);
        }
    }

    public final void onStart() {
        ak.vy().a(30, (e) this);
    }

    public final void a(int i, int i2, String str, final k kVar) {
        v.d("MicroMsg.AddContact", "onSceneEnd, errType = " + i + ", errCode = " + i2 + "," + str);
        if (kVar.getType() != 30) {
            v.w("MicroMsg.AddContact", "not expected scene,  type = " + kVar.getType());
            return;
        }
        if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        ak.vy().b(30, (e) this);
        if (i == 0 && i2 == 0) {
            this.lJh = ((m) kVar).bmW();
            c(true, false, this.lJh, this.lJm);
        } else if (i2 == -44) {
            String str2 = this.lJm;
            if (this.lJf != null) {
                this.lJf.avs();
                c(false, false, this.lJh, str2);
                return;
            }
            j jVar = new j(this.context, new com.tencent.mm.pluginsdk.ui.applet.j.a(this) {
                final /* synthetic */ a lJo;

                {
                    this.lJo = r1;
                }

                public final void cr(boolean z) {
                    this.lJo.c(false, z, this.lJo.lJh, this.lJo.lJm);
                }
            });
            if (this.lJg != null) {
                jVar.lJg = this.lJg;
            }
            if (this.lJk) {
                List list = this.ihX;
                List list2 = this.ihY;
                jVar.lKN = false;
                jVar.onStart();
                ak.vy().a(new m(2, list, list2, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty), 0);
                return;
            }
            jVar.f(this.ihX, this.ihY);
        } else if (i2 == -87) {
            g.A(this.context, this.context.getString(2131232009), SQLiteDatabase.KeyEmpty);
        } else if (i2 == -101 && !be.kS(str)) {
            v.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", Integer.valueOf(i2), str);
            g.A(this.context, str, SQLiteDatabase.KeyEmpty);
        } else if (i2 == -302) {
            v.d("MicroMsg.AddContact", "onSceneEnd, verify relation out of date, opCode = %d", Integer.valueOf(((m) kVar).bdn));
            if (((m) kVar).bdn == 3) {
                g.b(this.context, this.context.getString(2131232200), this.context.getString(2131231164), this.context.getString(2131230900), this.context.getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ a lJo;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.d("MicroMsg.AddContact", "dealwith verify relation out of date");
                        m mVar = (m) kVar;
                        LinkedList linkedList = (mVar.cif == null || mVar.cif.Bx() == null) ? null : ((bdo) mVar.cif.czk.czs).mZz;
                        List list = ((m) kVar).lzD;
                        if (list != null && list.size() > 0) {
                            this.lJo.b((String) list.get(0), linkedList, false);
                        }
                    }
                }, null);
            }
        } else if (i2 != -2) {
            o(i, i2, str);
        } else if (be.kS(str)) {
            o(i, i2, null);
        } else {
            g.a(this.context, str, this.context.getString(2131231164), this.context.getString(2131231107), null);
        }
    }

    private void o(int i, int i2, String str) {
        if (this.lJn && !be.kS(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else if (i == 4 && i2 == -22) {
            Toast.makeText(this.context, this.context.getString(2131230827), 1).show();
        } else if (i == 4 && i2 == -24 && !be.kS(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else {
            Toast.makeText(this.context, this.context.getString(2131230826), 1).show();
        }
        c(false, false, this.lJh, this.lJm);
    }
}
