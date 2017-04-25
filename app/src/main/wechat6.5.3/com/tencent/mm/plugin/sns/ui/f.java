package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.protocal.c.abp;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f extends c<aib> {
    private List<aib> gKQ = new ArrayList();
    private String gRN = "";
    private de jDE;
    private bw jDF;
    private a jDG;
    private int jDn = 0;
    private int jDo = 0;
    private String path = "";

    public interface a {
        void a(List<aib> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, int i, int i2, de deVar);

        void aVl();
    }

    public f(a aVar) {
        this.jDG = aVar;
    }

    public final void bu(List<aib> list) {
        if (this.jDG == null) {
            return;
        }
        if (list != null) {
            Map hashMap = new HashMap();
            Map hashMap2 = new HashMap();
            hashMap.clear();
            hashMap2.clear();
            int size = list.size();
            v.d("MicroMsg.ArtistAdapterHelper", "initFixType " + size);
            int i = 0;
            int i2 = 0;
            int i3;
            for (int i4 = 0; i4 < size; i4 = i3 + i4) {
                String str = ((aib) list.get(i4)).gkC;
                i3 = i4 + 1 < size ? !str.equals(((aib) list.get(i4 + 1)).gkC) ? 1 : i4 + 2 < size ? !str.equals(((aib) list.get(i4 + 2)).gkC) ? 2 : 3 : 2 : 1;
                hashMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                hashMap2.put(Integer.valueOf(i), Integer.valueOf(i3));
                i2 += i3;
                i++;
            }
            this.jDn = i + 1;
            this.jDo = list.size();
            v.d("MicroMsg.ArtistAdapterHelper", "icount " + this.jDn);
            this.gKQ = list;
            this.jDG.a(this.gKQ, hashMap, hashMap2, this.jDo, this.jDn, this.jDE);
            return;
        }
        this.jDG.aVl();
    }

    public final List<aib> aVk() {
        List<aib> arrayList = new ArrayList();
        try {
            arrayList.clear();
            this.jDF = null;
            String str = this.path + this.gRN + "_ARTISTF.mm";
            if (FileOp.aR(str)) {
                this.jDF = (bw) new bw().az(FileOp.c(str, 0, -1));
            }
            if (this.jDF == null) {
                String str2 = this.path + this.gRN + "_ARTIST.mm";
                this.jDF = com.tencent.mm.plugin.sns.g.a.AX(new String(FileOp.c(str2, 0, (int) FileOp.jP(str2))));
                if (this.jDF == null) {
                    FileOp.deleteFile(str2);
                    return null;
                }
                FileOp.deleteFile(str);
                FileOp.l(str, this.jDF.toByteArray());
            }
            if (this.jDF == null) {
                return null;
            }
            Iterator it = this.jDF.mcs.iterator();
            while (it.hasNext()) {
                abp com_tencent_mm_protocal_c_abp = (abp) it.next();
                String str3 = com_tencent_mm_protocal_c_abp.gkB;
                Iterator it2 = com_tencent_mm_protocal_c_abp.mom.iterator();
                while (it2.hasNext()) {
                    aib com_tencent_mm_protocal_c_aib = (aib) it2.next();
                    com_tencent_mm_protocal_c_aib.gkC = str3;
                    arrayList.add(com_tencent_mm_protocal_c_aib);
                }
            }
            this.jDE = this.jDF.mcr;
            return arrayList;
        } catch (Throwable e) {
            v.a("MicroMsg.ArtistAdapterHelper", e, "loadData failed.", new Object[0]);
            return null;
        }
    }

    public final void cN(String str, String str2) {
        this.gRN = str;
        this.path = str2;
        gn(true);
    }
}
