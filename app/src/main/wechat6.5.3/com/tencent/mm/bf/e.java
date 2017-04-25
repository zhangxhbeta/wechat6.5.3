package com.tencent.mm.bf;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mm.e.a.gf;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.s;
import com.tencent.mm.storage.a.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

public class e {
    private static e nnu = null;
    private String[] nnv;
    private String[] nnw;
    private String[] nnx;
    private ArrayList<u> nny = new ArrayList();
    private SparseArray<u> nnz = new SparseArray();

    public e(Context context) {
        this.nnv = context.getResources().getStringArray(2131296282);
        this.nnw = context.getResources().getStringArray(2131296283);
        this.nnx = context.getResources().getStringArray(2131296284);
        this.nny.clear();
        this.nnz.clear();
        buP();
    }

    private void buP() {
        int i = 0;
        if (this.nnv != null && this.nnw != null) {
            int length = this.nnv.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                u uVar = new u(i3, this.nnv[i2]);
                this.nny.add(uVar);
                this.nnz.put(i3, uVar);
                i2++;
                i3++;
            }
            i2 = this.nnw.length;
            while (i < i2) {
                u uVar2 = new u(i3, this.nnw[i]);
                this.nny.add(uVar2);
                this.nnz.put(i3, uVar2);
                i++;
                i3++;
            }
        }
    }

    public void Th() {
        v.d("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
        this.nny.clear();
        ArrayList afd = a.bmr().afd();
        if (afd == null || afd.isEmpty()) {
            buP();
            return;
        }
        ArrayList afc = a.bmr().afc();
        int size = afd.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            u uVar = (u) afd.get(i);
            String str = uVar.field_key;
            if (!str.startsWith("[") || afc.contains(str)) {
                this.nny.add(uVar);
                this.nnz.put(i2, uVar);
                i3 = i2 + 1;
            } else {
                v.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", str);
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
    }

    public int Ti() {
        return this.nny == null ? 0 : this.nny.size();
    }

    public static e buQ() {
        if (nnu == null) {
            synchronized (e.class) {
                nnu = new e(aa.getContext());
            }
        }
        return nnu;
    }

    public Drawable hH(int i) {
        if (this.nnz == null) {
            v.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
            return null;
        }
        Drawable hH;
        u uVar = (u) this.nnz.get(i);
        s Ln = f.buR().Ln(uVar.field_key);
        int i2;
        if (Ln != null) {
            f.buR();
            i2 = Ln.field_position;
            hH = i2 >= 0 ? b.buL().hH(i2) : f.Lm(Ln.field_fileName);
        } else {
            c cVar;
            b buL = b.buL();
            String str = uVar.field_key;
            if (be.kS(str)) {
                v.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
                cVar = null;
            } else {
                i2 = str.codePointAt(0);
                cVar = buL.vb(i2) != null ? buL.vb(i2) : buL.cY(i2, 0);
            }
            hH = b.buL().a(cVar);
        }
        return hH;
    }

    public String getText(int i) {
        if (i < 0) {
            v.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return SQLiteDatabase.KeyEmpty;
        }
        u uVar = (u) this.nny.get(i);
        if (uVar == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        s Ln = f.buR().Ln(uVar.field_key);
        if (Ln != null) {
            if (com.tencent.mm.sdk.platformtools.u.bsV() && !be.kS(Ln.field_cnValue)) {
                return Ln.field_cnValue;
            }
            if (com.tencent.mm.sdk.platformtools.u.bsW() && !be.kS(Ln.field_twValue)) {
                return Ln.field_twValue;
            }
        }
        return uVar.field_key;
    }

    public String hJ(int i) {
        if (i < 0) {
            v.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return SQLiteDatabase.KeyEmpty;
        }
        u uVar = (u) this.nny.get(i);
        if (uVar != null) {
            return uVar.field_key;
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public String hI(int i) {
        if (i < 0) {
            v.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
            return SQLiteDatabase.KeyEmpty;
        }
        b gfVar = new gf();
        com.tencent.mm.sdk.c.a.nhr.z(gfVar);
        if ((gfVar.bfJ.aZB == 1 ? 1 : 0) == 0) {
            return buQ().nnw[i];
        }
        String[] split = buQ().nnw[i].split(" ");
        char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
        char[] toChars2 = Character.toChars(Integer.decode(split[1]).intValue());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toChars);
        stringBuilder.append(toChars2);
        return stringBuilder.toString();
    }
}
