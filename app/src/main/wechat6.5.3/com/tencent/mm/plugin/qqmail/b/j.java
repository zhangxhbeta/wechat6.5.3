package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.qqmail.b.q.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j {
    List<a> bXt;
    long iaP = 0;
    private e iaQ;
    a iaR;
    private int iaS = 0;
    int iaT = 1;
    private int iaU = 2;
    int iaV = 3;
    int status = this.iaS;

    public static abstract class a {
        public abstract void onComplete();
    }

    j(String str) {
        this.iaQ = new e(str, 1);
        byte[] readFromFile = e.readFromFile(this.iaQ.iay + "address");
        if (readFromFile != null) {
            this.iaQ.a("address", null, readFromFile);
            b.deleteFile(this.iaQ.iay + "address");
        } else {
            readFromFile = this.iaQ.f("address", null);
        }
        if (readFromFile != null) {
            try {
                this.iaR = new a().ay(readFromFile);
            } catch (Throwable e) {
                v.a("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
                this.iaR = new a();
                this.iaR.xV("");
            }
        } else {
            this.iaR = new a();
            this.iaR.xV("");
        }
        this.bXt = new ArrayList();
    }

    protected final void finalize() {
        this.bXt.clear();
    }

    public final List<i> ya(String str) {
        List<i> list = this.iaR.ial;
        if (this.status <= this.iaT) {
            aHv();
            return list;
        } else if (str == null || str.length() == 0) {
            return list;
        } else {
            List<i> arrayList = new ArrayList();
            for (i iVar : list) {
                if (iVar != null && ((iVar.name != null && iVar.name.contains(str)) || ((iVar.iaO != null && iVar.iaO.contains(str)) || (iVar.gRG != null && iVar.gRG.contains(str))))) {
                    a.b(iVar);
                    arrayList.add(iVar);
                }
            }
            return arrayList;
        }
    }

    public final void aHv() {
        if (this.status != this.iaU) {
            if (be.Ni() - this.iaP <= 600000) {
                for (a onComplete : this.bXt) {
                    onComplete.onComplete();
                }
                return;
            }
            this.status = this.iaU;
            Map hashMap = new HashMap();
            hashMap.put("syncinfo", this.iaR.iaj == null ? "" : this.iaR.iaj);
            v.d("MicroMsg.Plugin.MailAddrMgr", "%s", new Object[]{"sync~~~"});
            x.aHG().b("/cgi-bin/syncaddrlist", hashMap, new c(), new com.tencent.mm.plugin.qqmail.b.q.a(this) {
                final /* synthetic */ j iaW;

                {
                    this.iaW = r1;
                }

                public final void onSuccess(String str, Map<String, String> map) {
                    j jVar = this.iaW;
                    int i = be.getInt((String) map.get(".Response.result.Count"), 0);
                    if (i > 0) {
                        int i2 = jVar.iaR.ial.size() == 0 ? 1 : 0;
                        int i3 = 0;
                        while (i3 < i) {
                            String str2 = ".Response.result.List.item" + (i3 > 0 ? String.valueOf(i3) : "") + ".";
                            String str3 = (String) map.get(str2 + "Del");
                            String str4 = (String) map.get(str2 + "Freq");
                            String str5 = (String) map.get(str2 + "Name");
                            str2 = (String) map.get(str2 + "Addr");
                            if (str2 != null && str2.length() != 0) {
                                if (str5 == null || str5.length() == 0) {
                                    str5 = str2;
                                }
                                int hashCode = str2.hashCode();
                                if (str3.equals("0")) {
                                    List list = jVar.iaR.ial;
                                    int i4 = 0;
                                    while (i2 == 0 && i4 < list.size() && ((i) list.get(i4)).iaM != hashCode) {
                                        i4++;
                                    }
                                    if (i4 >= list.size() || i2 != 0) {
                                        i iVar = new i();
                                        iVar.iaM = hashCode;
                                        iVar.name = str5;
                                        iVar.gRG = str2;
                                        iVar.iaN = Integer.parseInt(str4);
                                        jVar.iaR.a(iVar);
                                    }
                                } else {
                                    Iterator it = jVar.iaR.ial.iterator();
                                    int i5 = 0;
                                    while (it.hasNext()) {
                                        if (((i) it.next()).iaM == hashCode) {
                                            jVar.iaR.ov(i5);
                                            break;
                                        }
                                        i5++;
                                    }
                                }
                            }
                            i3++;
                        }
                        jVar.iaR.xV((String) map.get(".Response.result.SyncInfo"));
                        jVar.save();
                    }
                    if (((String) map.get(".Response.result.ContinueFlag")).equals("1")) {
                        new ac().postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 iaX;

                            {
                                this.iaX = r1;
                            }

                            public final void run() {
                                this.iaX.iaW.status = this.iaX.iaW.iaT;
                                this.iaX.iaW.aHv();
                            }
                        }, 0);
                        return;
                    }
                    this.iaW.iaP = be.Ni();
                    for (a onComplete : this.iaW.bXt) {
                        onComplete.onComplete();
                    }
                }

                public final void onError(int i, String str) {
                    for (a onComplete : this.iaW.bXt) {
                        onComplete.onComplete();
                    }
                }

                public final void onComplete() {
                    this.iaW.status = this.iaW.iaV;
                }
            });
        }
    }

    public final void a(a aVar) {
        for (a aVar2 : this.bXt) {
            if (aVar2 == aVar) {
                return;
            }
        }
        this.bXt.add(aVar);
    }

    public final void b(a aVar) {
        for (a aVar2 : this.bXt) {
            if (aVar2 == aVar) {
                this.bXt.remove(aVar2);
                return;
            }
        }
    }

    public final void aY(List<i> list) {
        a aVar = this.iaR;
        if (!(list == null || list.size() == 0)) {
            for (i iVar : list) {
                Iterator it = aVar.ial.iterator();
                int i = 0;
                while (it.hasNext()) {
                    i iVar2 = (i) it.next();
                    if (iVar2.gRG.equalsIgnoreCase(iVar.gRG)) {
                        aVar.ov(i);
                        iVar2.iaN++;
                        aVar.a(iVar2);
                        break;
                    }
                    i++;
                }
            }
        }
        save();
    }

    final void save() {
        try {
            this.iaQ.a("address", null, this.iaR.toByteArray());
        } catch (Throwable e) {
            v.a("MicroMsg.Plugin.MailAddrMgr", e, "", new Object[0]);
        }
    }

    public static i yb(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        int lastIndexOf = trim.trim().lastIndexOf(" ");
        if (lastIndexOf == -1) {
            return null;
        }
        i iVar = new i();
        iVar.name = trim.substring(0, lastIndexOf);
        iVar.gRG = trim.substring(lastIndexOf + 1);
        return iVar;
    }
}
