package com.tencent.mm.plugin.radar.a;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.protocal.c.aoz;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class e implements com.tencent.mm.v.e {
    public com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ e iiy;

        {
            this.iiy = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (this.iiy.cAv) {
                v.d("MicroMsg.Radar.RadarManager", "cancel location");
                return false;
            } else if (this.iiy.iil != null) {
                return false;
            } else {
                if (z) {
                    n.a(2006, f, f2, (int) d2);
                    v.d("MicroMsg.Radar.RadarManager", "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
                    this.iiy.iil = new Location(f2, f, (int) d2, i, "", "");
                    this.iiy.iiw.ea(0);
                } else {
                    this.iiy.stop();
                }
                e eVar = this.iiy;
                if (eVar.iio != null) {
                    eVar.iio.eX(true);
                }
                return false;
            }
        }
    };
    private String bax;
    boolean cAv = false;
    public com.tencent.mm.modelgeo.c cCR;
    private LinkedList<apa> cTm = new LinkedList();
    private Context context = null;
    Location iil = null;
    b iim = null;
    private a iin = null;
    c iio = null;
    e iip = e.Stopped;
    public LinkedList<aoy> iiq;
    private HashMap<String, String> iir = new HashMap();
    private Map<String, com.tencent.mm.plugin.radar.a.c.d> iis = new HashMap();
    private Map<String, com.tencent.mm.plugin.radar.a.c.d> iit = new HashMap();
    private Map<Long, b> iiu = new HashMap();
    private Map<String, a> iiv = new HashMap();
    ah iiw = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ e iiy;

        {
            this.iiy = r1;
        }

        public final boolean oU() {
            if (this.iiy.cAv) {
                v.d("MicroMsg.Radar.RadarManager", "cancel radar searching");
            } else {
                this.iiy.iip = e.RadarSearching;
                v.d("MicroMsg.Radar.RadarManager", "status: %s", new Object[]{this.iiy.iip});
                if (this.iiy.iil == null || this.iiy.iil.bnO()) {
                    v.e("MicroMsg.Radar.RadarManager", "error! location is null!");
                } else {
                    v.d("MicroMsg.Radar.RadarManager", "do once search");
                    this.iiy.iim = new b(1, this.iiy.iil.cJq, this.iiy.iil.cJr, this.iiy.iil.accuracy, this.iiy.iil.biJ, this.iiy.iil.mac, this.iiy.iil.biL);
                    ak.vy().a(this.iiy.iim, 0);
                }
            }
            return false;
        }
    }, false);
    private ac iix = new ac(this) {
        final /* synthetic */ e iiy;

        {
            this.iiy = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                ak.vy().a(new b(), 0);
            }
        }
    };

    public enum a {
        Selected,
        UnSelected
    }

    public static class b {
        public apa iiD;
        public com.tencent.mm.plugin.radar.a.c.d iiE;

        public b(apa com_tencent_mm_protocal_c_apa, com.tencent.mm.plugin.radar.a.c.d dVar) {
            this.iiD = com_tencent_mm_protocal_c_apa;
            this.iiE = dVar;
        }
    }

    public interface c {
        void a(int i, int i2, LinkedList<apa> linkedList);

        void b(int i, int i2, LinkedList<aox> linkedList);

        void eX(boolean z);
    }

    public enum d {
        SEARCHING,
        SEARCH_RETRUN,
        RALATIONCHAIN,
        RALATIONCHAIN_RETRUN,
        CREATING_CHAT
    }

    private enum e {
        Stopped,
        Locating,
        RadarSearching,
        Waiting
    }

    public e(c cVar, Context context) {
        this.iio = cVar;
        this.context = context;
    }

    public final void aIG() {
        aIH();
        this.cAv = false;
        this.iil = null;
        this.iip = e.Stopped;
        this.iiw.QI();
        v.d("MicroMsg.Radar.RadarManager", "start radar");
        if (this.cCR == null) {
            this.cCR = com.tencent.mm.modelgeo.c.FY();
        }
        this.iip = e.Locating;
        this.cCR.a(this.bYl, true);
        v.d("MicroMsg.Radar.RadarManager", "status: %s", new Object[]{this.iip});
    }

    public final void aIH() {
        switch (this.iip) {
            case Stopped:
                return;
            case Locating:
                stop();
                return;
            case RadarSearching:
                if (this.iim != null) {
                    stop();
                    ak.vy().c(this.iim);
                    aII();
                    return;
                }
                return;
            case Waiting:
                stop();
                aII();
                break;
        }
        v.d("MicroMsg.Radar.RadarManager", "stop radar");
    }

    private void aII() {
        this.iix.sendEmptyMessageDelayed(1, 5000);
    }

    public final void stop() {
        this.cAv = true;
        this.iip = e.Stopped;
        this.iiw.QI();
    }

    private void a(int i, int i2, LinkedList<apa> linkedList) {
        if (this.iio != null) {
            this.iio.a(i, i2, linkedList);
        }
    }

    private void b(int i, int i2, LinkedList<aox> linkedList) {
        if (this.iio != null) {
            this.iio.b(i, i2, linkedList);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        switch (kVar.getType()) {
            case 425:
                if (this.iim == kVar) {
                    b bVar = (b) kVar;
                    if (bVar.bdf == 1) {
                        this.iip = e.Waiting;
                        if (i == 0 && i2 == 0) {
                            v.d("MicroMsg.Radar.RadarManager", "rader members count: %s ticket: %s", new Object[]{Integer.valueOf(bVar.aIE()), this.bax});
                            this.iiw.ea(3000);
                            Collection collection = ((apc) bVar.cif.czl.czs).mbB;
                            if (collection != null) {
                                Iterator it = collection.iterator();
                                while (it.hasNext()) {
                                    apa com_tencent_mm_protocal_c_apa = (apa) it.next();
                                    ak.yW().xv().dJ(com_tencent_mm_protocal_c_apa.gln, com_tencent_mm_protocal_c_apa.mvR);
                                }
                            }
                            this.cTm.clear();
                            this.cTm.addAll(collection);
                            LinkedList linkedList = this.cTm;
                            bVar.aIE();
                            a(i, i2, linkedList);
                            v.d("MicroMsg.Radar.RadarManager", "status: %s", new Object[]{this.iip});
                            return;
                        }
                        stop();
                        a(i, i2, null);
                        return;
                    }
                    a(i, i2, null);
                    return;
                }
                return;
            case 602:
                v.d("MicroMsg.Radar.RadarManager", " MMFunc_MMRadarRelationChain ");
                if (i == 0 && i2 == 0) {
                    aoz com_tencent_mm_protocal_c_aoz = (aoz) ((a) kVar).cif.czl.czs;
                    this.bax = com_tencent_mm_protocal_c_aoz.mpB;
                    if (com_tencent_mm_protocal_c_aoz.eOX > 0) {
                        LinkedList linkedList2 = com_tencent_mm_protocal_c_aoz.mbB;
                        int i3 = com_tencent_mm_protocal_c_aoz.eOX;
                        b(i, i2, linkedList2);
                        return;
                    }
                    b(i, i2, null);
                    return;
                }
                b(i, i2, null);
                return;
            default:
                return;
        }
    }

    public final HashMap<String, String> aIJ() {
        if (this.iir == null) {
            this.iir = new HashMap();
        }
        return this.iir;
    }

    public final Map<Long, b> aIK() {
        if (this.iiu == null) {
            this.iiu = new HashMap();
        }
        return this.iiu;
    }

    private Map<String, com.tencent.mm.plugin.radar.a.c.d> aIL() {
        if (this.iis == null) {
            this.iis = new HashMap();
        }
        return this.iis;
    }

    private Map<String, com.tencent.mm.plugin.radar.a.c.d> aIM() {
        if (this.iit == null) {
            this.iit = new HashMap();
        }
        return this.iit;
    }

    public final Map<String, a> aIN() {
        if (this.iiv == null) {
            this.iiv = new HashMap();
        }
        return this.iiv;
    }

    public final void a(String str, com.tencent.mm.plugin.radar.a.c.d dVar) {
        com.tencent.mm.plugin.radar.a.c.d dVar2 = (com.tencent.mm.plugin.radar.a.c.d) aIL().get(str);
        if (dVar2 != null && dVar2 != dVar) {
            aIM().put(str, dVar2);
        }
    }

    public final void b(String str, com.tencent.mm.plugin.radar.a.c.d dVar) {
        if (!be.ma(str).equals("")) {
            a(str, dVar);
            aIL().put(str, dVar);
        }
    }

    public final com.tencent.mm.plugin.radar.a.c.d a(apa com_tencent_mm_protocal_c_apa, boolean z) {
        com.tencent.mm.plugin.radar.a.c.d ac = ac(com_tencent_mm_protocal_c_apa.gln, z);
        if (ac == null) {
            return ac(com_tencent_mm_protocal_c_apa.mrE, z);
        }
        return ac;
    }

    public final com.tencent.mm.plugin.radar.a.c.d ac(String str, boolean z) {
        Map aIL = !z ? aIL() : aIM();
        if (be.ma(str).equals("")) {
            return null;
        }
        return (com.tencent.mm.plugin.radar.a.c.d) aIL.get(str);
    }

    public final void a(apa com_tencent_mm_protocal_c_apa) {
        if (aIN() != null && com_tencent_mm_protocal_c_apa != null) {
            String b = com.tencent.mm.plugin.radar.ui.c.b(com_tencent_mm_protocal_c_apa);
            if (aIN().containsKey(b)) {
                aIN().remove(b);
            } else {
                aIN().put(b, a.Selected);
            }
        }
    }
}
