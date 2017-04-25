package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.a.f.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import java.util.ArrayList;
import java.util.HashMap;

public final class c {
    private static int aLe = 0;
    private static c gdK = null;
    private l gdG;
    private a gdH;
    private e gdI;
    private ArrayList<MediaItem> gdJ = null;
    private HashMap<Integer, Boolean> gdL = new HashMap();

    public static MediaItem tW(String str) {
        MediaItem a = MediaItem.a(0, 0, str, "", "");
        if (aql().gdJ != null) {
            int indexOf = aql().gdJ.indexOf(a);
            if (indexOf >= 0) {
                return (MediaItem) aql().gdJ.get(indexOf);
            }
        }
        return null;
    }

    private c() {
        if (this.gdH == null) {
            this.gdH = new a();
        }
        if (this.gdG == null) {
            this.gdG = new l();
        }
        if (this.gdI == null) {
            this.gdI = new e();
        }
    }

    private static c aql() {
        if (gdK == null) {
            gdK = new c();
        }
        return gdK;
    }

    public static a aqm() {
        return aql().gdH;
    }

    public static l aqn() {
        return aql().gdG;
    }

    public static e aqo() {
        return aql().gdI;
    }

    public static void aqp() {
        synchronized (c.class) {
            aLe++;
        }
    }

    public static void dj(boolean z) {
        synchronized (c.class) {
            if (aLe > 0) {
                aLe--;
            }
            if (z && aLe == 0) {
                aql().gdG = null;
                if (aql().gdH != null) {
                    b bVar = aql().gdH.gdr;
                    if (bVar.gdC != null) {
                        bVar.gdC.a(new a<String, a>(bVar) {
                            final /* synthetic */ b gdF;

                            {
                                this.gdF = r1;
                            }
                        });
                        bVar.gdC = null;
                    }
                    if (bVar.gdD != null) {
                        d dVar = bVar.gdD;
                        dVar.aqu();
                        dVar.aqv();
                        dVar.aqx();
                        bVar.gdD = null;
                    }
                    aql().gdH = null;
                }
                e eVar = aql().gdI;
                if (eVar.gdQ != null) {
                    eVar.gdQ.quit();
                    eVar.gdQ = null;
                }
                eVar.gdT = null;
                if (eVar.gdR != null) {
                    eVar.gdR.quit();
                    eVar.gdR = null;
                }
                eVar.gdU = null;
                if (eVar.gdS != null) {
                    eVar.gdS.quit();
                    eVar.gdS = null;
                }
                eVar.gdV = null;
                aql().gdI = null;
                gdK = null;
            }
        }
    }

    public static ArrayList<MediaItem> aqq() {
        return aql().gdJ;
    }

    public static void A(ArrayList<MediaItem> arrayList) {
        aql().gdJ = arrayList;
    }

    public static void lb(int i) {
        aql().gdL.put(Integer.valueOf(i), Boolean.valueOf(true));
    }

    public static void aqr() {
        aql().gdL.clear();
    }

    public static int aqs() {
        return aql().gdL.size();
    }
}
