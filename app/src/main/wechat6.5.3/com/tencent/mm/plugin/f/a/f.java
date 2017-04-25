package com.tencent.mm.plugin.f.a;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.modelmulti.p.c;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.plugin.f.a.a.j;
import com.tencent.mm.plugin.zero.a.i;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class f implements i {
    private static com.tencent.mm.plugin.f.a.a.j.a hkZ;
    private j hla;

    static class b implements Runnable {
        private String TAG;
        private final q cRF;
        private final LinkedList<kz> fLW;
        private int hlb;

        public b(String str, q qVar, LinkedList<kz> linkedList) {
            this.TAG = str;
            this.cRF = qVar;
            this.fLW = linkedList;
        }

        public final void run() {
            if (this.cRF != null) {
                int i = this.cRF.cSM;
                if (i != 3) {
                    if (!this.cRF.cSL) {
                        if (!(i == 1 || i == 2 || i == 8)) {
                            return;
                        }
                    }
                    return;
                }
                this.hlb = 0;
                Iterator it = this.fLW.iterator();
                while (it.hasNext()) {
                    kz kzVar = (kz) it.next();
                    byte[] a = m.a(kzVar.mnB);
                    if (kzVar.bkM == 5) {
                        try {
                            String com_tencent_mm_protocal_c_arf = ((bm) new bm().az(a)).mbU.toString();
                            ab LX = ((d) g.f(d.class)).wH().LX(com_tencent_mm_protocal_c_arf);
                            if (com_tencent_mm_protocal_c_arf.endsWith("@chatroom") && LX.bCh == 0) {
                                this.hlb++;
                            }
                        } catch (IOException e) {
                            v.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + e.getMessage());
                        }
                    }
                }
                if (this.hlb > 0) {
                    if (this.hlb <= 5) {
                        com.tencent.mm.plugin.report.b.itm.a(202, (long) this.hlb, 1, false);
                    } else if (this.hlb <= 10) {
                        com.tencent.mm.plugin.report.b.itm.a(202, 6, 1, false);
                    } else if (this.hlb <= 15) {
                        com.tencent.mm.plugin.report.b.itm.a(202, 7, 1, false);
                    } else if (this.hlb <= 20) {
                        com.tencent.mm.plugin.report.b.itm.a(202, 8, 1, false);
                    } else {
                        com.tencent.mm.plugin.report.b.itm.a(202, 9, 1, false);
                    }
                    v.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.hlb);
                    switch (i) {
                        case 1:
                            com.tencent.mm.plugin.report.b.itm.a(202, 11, 1, false);
                            break;
                        case 2:
                            com.tencent.mm.plugin.report.b.itm.a(202, 12, 1, false);
                            break;
                        case 3:
                            com.tencent.mm.plugin.report.b.itm.a(202, 10, 1, false);
                            break;
                        case 8:
                            com.tencent.mm.plugin.report.b.itm.a(202, 13, 1, false);
                            break;
                    }
                    v.i(this.TAG, "muteroom idkeyStat:aiScene = " + i);
                }
            }
        }
    }

    private static class a implements j {
        private a() {
        }

        public final void Xd() {
        }

        public final void a(at atVar, bm bmVar) {
        }
    }

    public static final void a(com.tencent.mm.plugin.f.a.a.j.a aVar) {
        hkZ = aVar;
    }

    public final void aK(Object obj) {
        if (hkZ != null) {
            this.hla = hkZ.Xc();
        }
        if (this.hla == null) {
            this.hla = new a();
        }
        if (obj instanceof k) {
            ((d) g.f(d.class)).azI().MC(((k) obj).TAG);
        } else if (obj instanceof String) {
            if (obj.equals("NetSceneInit")) {
                ((d) g.f(d.class)).azI().MC((String) obj);
            }
        } else if (obj instanceof c) {
            ((d) g.f(d.class)).azI().MC(obj.toString());
        }
    }

    public final void a(Object obj, int i, int i2, kz kzVar, byte[] bArr, boolean z) {
        com.tencent.mm.plugin.f.a.a.i mU = com.tencent.mm.plugin.f.a.a.i.a.mU(kzVar.bkM);
        if (mU != null) {
            try {
                mU.a(kzVar, bArr, z, this.hla);
                return;
            } catch (IOException e) {
                v.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + e.getMessage());
                throw new RuntimeException("docmd: parse protobuf error");
            }
        }
        v.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", Integer.valueOf(kzVar.bkM));
    }

    public final void aL(Object obj) {
        if (obj instanceof k) {
            LinkedList linkedList;
            this.hla.Xd();
            ((d) g.f(d.class)).azI().MD(((k) obj).TAG);
            ad vA = g.vA();
            String str = ((k) obj).TAG;
            q qVar = ((k) obj).cRF;
            k kVar = (k) obj;
            if (kVar.cRN == null || kVar.cRN.lXt.mkI == null) {
                linkedList = null;
            } else {
                linkedList = kVar.cRN.lXt.mkI.eeu;
            }
            vA.x(new b(str, qVar, linkedList));
        } else if ((obj instanceof String) && obj.equals("NetSceneInit")) {
            this.hla.Xd();
            ((d) g.f(d.class)).azI().MD((String) obj);
        } else if (obj instanceof c) {
            this.hla.Xd();
            ((d) g.f(d.class)).azI().MD(obj.toString());
        }
    }

    public final void aM(Object obj) {
        if (obj instanceof k) {
            ((d) g.f(d.class)).azI().MD(((k) obj).TAG);
        }
    }
}
