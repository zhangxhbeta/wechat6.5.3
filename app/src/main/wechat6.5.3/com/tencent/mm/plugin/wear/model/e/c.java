package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.bha;
import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.protocal.c.bhh;
import com.tencent.mm.protocal.c.bid;
import com.tencent.mm.protocal.c.bie;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.contact.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends a {
    public final List<Integer> bhU() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11008));
        arrayList.add(Integer.valueOf(11009));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        int i2 = 5;
        if (i == 11008) {
            a.sy(6);
            bid com_tencent_mm_protocal_c_bid = new bid();
            try {
                com_tencent_mm_protocal_c_bid.az(bArr);
                List linkedList = new LinkedList();
                linkedList.addAll(r.bHP());
                linkedList.addAll(r.bHQ());
                ak.yW();
                Cursor g = com.tencent.mm.model.c.wK().g(linkedList, com_tencent_mm_protocal_c_bid.mfb);
                if (com_tencent_mm_protocal_c_bid.mfb != 0) {
                    i2 = 20;
                }
                bie com_tencent_mm_protocal_c_bie = new bie();
                com_tencent_mm_protocal_c_bie.mfb = com_tencent_mm_protocal_c_bid.mfb;
                while (g != null && g.moveToNext()) {
                    String string = g.getString(g.getColumnIndex("username"));
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(string);
                    com_tencent_mm_protocal_c_bie.mfb++;
                    if (!(LX.bvm() || LX.tK())) {
                        bha com_tencent_mm_protocal_c_bha = new bha();
                        com_tencent_mm_protocal_c_bha.efy = l.c(LX);
                        com_tencent_mm_protocal_c_bha.gln = LX.field_username;
                        com_tencent_mm_protocal_c_bie.mxQ.add(com_tencent_mm_protocal_c_bha);
                        if (com_tencent_mm_protocal_c_bie.mxQ.size() >= i2) {
                            com_tencent_mm_protocal_c_bie.ncp = g.moveToNext();
                            break;
                        }
                    }
                }
                v.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bid.mfb), Integer.valueOf(com_tencent_mm_protocal_c_bie.mfb), Integer.valueOf(com_tencent_mm_protocal_c_bie.mxQ.size())});
                if (g != null) {
                    g.close();
                }
                try {
                    return com_tencent_mm_protocal_c_bie.toByteArray();
                } catch (IOException e) {
                    return null;
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.Wear.HttpContactServer", e2, "", new Object[0]);
                return null;
            }
        } else if (i != 11009) {
            return null;
        } else {
            a.sy(7);
            bhg com_tencent_mm_protocal_c_bhg = new bhg();
            try {
                com_tencent_mm_protocal_c_bhg.az(bArr);
                bhh com_tencent_mm_protocal_c_bhh = new bhh();
                ak.yW();
                Cursor cd = com.tencent.mm.model.c.wH().cd(null);
                int i3 = com_tencent_mm_protocal_c_bhg.mfb;
                while (cd != null && cd.moveToNext()) {
                    if (i3 > 0) {
                        i3--;
                    } else {
                        String string2 = cd.getString(0);
                        ak.yW();
                        u LX2 = com.tencent.mm.model.c.wH().LX(string2);
                        bha com_tencent_mm_protocal_c_bha2 = new bha();
                        com_tencent_mm_protocal_c_bha2.efy = l.c(LX2);
                        com_tencent_mm_protocal_c_bha2.gln = LX2.field_username;
                        com_tencent_mm_protocal_c_bhh.mxQ.add(com_tencent_mm_protocal_c_bha2);
                        if (com_tencent_mm_protocal_c_bhh.mxQ.size() >= 5) {
                            com_tencent_mm_protocal_c_bhh.ncp = cd.moveToNext();
                            break;
                        }
                    }
                }
                if (cd != null) {
                    cd.close();
                }
                com_tencent_mm_protocal_c_bhh.mfb = com_tencent_mm_protocal_c_bhg.mfb + com_tencent_mm_protocal_c_bhh.mxQ.size();
                try {
                    return com_tencent_mm_protocal_c_bhh.toByteArray();
                } catch (Throwable e22) {
                    v.a("MicroMsg.Wear.HttpContactServer", e22, "", new Object[0]);
                    return null;
                }
            } catch (Throwable e222) {
                v.a("MicroMsg.Wear.HttpContactServer", e222, "", new Object[0]);
                return null;
            }
        }
    }

    protected final boolean sA(int i) {
        if (i == 11008 || i == 11009) {
            return true;
        }
        return super.sA(i);
    }

    protected final boolean sz(int i) {
        if (i == 11008 || i == 11009) {
            return true;
        }
        return super.sz(i);
    }
}
