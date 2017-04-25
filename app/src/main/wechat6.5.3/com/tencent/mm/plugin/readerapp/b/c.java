package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.d.a;
import com.tencent.mm.v.d.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class c implements d {
    public final b b(a aVar) {
        Throwable th;
        int i;
        bm bmVar = aVar.czu;
        if (bmVar == null) {
            v.e("MicroMsg.ReaderAppMsgExtension", "onPreAddMessage cmdAM is null");
            return null;
        }
        int i2;
        Object valueOf;
        int i3;
        String str;
        bc bcVar;
        g.aJg().N((long) bmVar.mbT);
        String a = m.a(bmVar.mbW);
        long Ni = be.Ni();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        int i4 = 0;
        List<bc> arrayList = new ArrayList();
        int i5 = 0;
        try {
            Map q = bf.q(a, "mmreader");
            i4 = 0;
            i2 = 0;
            while (i4 <= 0) {
                StringBuilder stringBuilder = new StringBuilder(".mmreader.category");
                if (i4 > 0) {
                    valueOf = Integer.valueOf(i4);
                } else {
                    try {
                        valueOf = "";
                    } catch (Throwable e) {
                        th = e;
                        i = i2;
                        i2 = i4;
                    }
                }
                String stringBuilder2 = stringBuilder.append(valueOf).toString();
                i5 = be.getInt((String) q.get(stringBuilder2 + ".$type"), 0);
                if (i5 != 0) {
                    if (i5 != 20 && i5 != 11) {
                        v.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$type  error Type:" + i5);
                        i3 = i4;
                        break;
                    }
                    a = (String) q.get(stringBuilder2 + ".name");
                    if (be.kS(a)) {
                        v.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".name  error");
                        i2 = i5;
                        i3 = i4;
                        break;
                    }
                    String str2 = (String) q.get(stringBuilder2 + ".topnew.cover");
                    str = (String) q.get(stringBuilder2 + ".topnew.digest");
                    int i6 = be.getInt((String) q.get(stringBuilder2 + ".$count"), 0);
                    if (i6 == 0) {
                        v.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$count  error");
                        i2 = i5;
                        i3 = i4;
                        break;
                    }
                    if (i6 > 1) {
                        stringBuilder2 = stringBuilder2 + (i5 == 20 ? ".newitem" : ".item");
                    } else {
                        stringBuilder2 = stringBuilder2 + ".item";
                    }
                    int i7 = 0;
                    while (i7 < i6) {
                        String str3 = stringBuilder2 + (i7 > 0 ? Integer.valueOf(i7) : "");
                        bc bcVar2 = new bc();
                        bcVar2.M((long) bmVar.mbT);
                        bcVar2.title = (String) q.get(str3 + ".title");
                        if (i7 == 0) {
                            long j = be.getLong((String) q.get(str3 + ".pub_time"), 0);
                            if (j > 0) {
                                Ni = 1000 * j;
                            }
                            bcVar2.cuS = 1;
                            bcVar2.cqI = str2;
                            bcVar2.cqK = be.kS(str) ? (String) q.get(str3 + ".digest") : str;
                        } else {
                            bcVar2.cqI = (String) q.get(str3 + ".cover");
                            bcVar2.cqK = (String) q.get(str3 + ".digest");
                        }
                        bcVar2.cuT = q.containsKey(new StringBuilder().append(str3).append(".vedio").toString()) ? 1 : 0;
                        bcVar2.url = (String) q.get(str3 + ".url");
                        bcVar2.cuN = (String) q.get(str3 + ".shorturl");
                        bcVar2.cuO = (String) q.get(str3 + ".longurl");
                        bcVar2.cuP = be.getLong((String) q.get(str3 + ".pub_time"), 0);
                        String str4 = (String) q.get(str3 + ".tweetid");
                        if (str4 == null || "".equals(str4)) {
                            str4 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i7)));
                            v.d("MicroMsg.ReaderAppMsgExtension", "create tweetID = " + str4);
                        }
                        bcVar2.cuM = str4;
                        bcVar2.cuQ = (String) q.get(str3 + ".sources.source.name");
                        bcVar2.cuR = (String) q.get(str3 + ".sources.source.icon");
                        bcVar2.time = ((long) i4) + Ni;
                        bcVar2.type = i5;
                        bcVar2.name = a;
                        arrayList.add(bcVar2);
                        i7++;
                    }
                    i4++;
                    i2 = i5;
                } else {
                    v.e("MicroMsg.ReaderAppMsgExtension", "get " + stringBuilder2 + ".$type  error");
                    i3 = i4;
                    break;
                }
            }
            i3 = i4;
        } catch (Throwable e2) {
            th = e2;
            i2 = i4;
            i = i5;
        }
        v.d("MicroMsg.ReaderAppMsgExtension", "type = " + i2 + ", want to receive news? " + aJe());
        for (bc bcVar3 : arrayList) {
            if (be.kS(bcVar3.getTitle())) {
                if (be.kS(bcVar3.getUrl())) {
                    v.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + bcVar3.zG() + ", type = " + bcVar3.type);
                    valueOf = null;
                    break;
                }
            }
            v.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + bcVar3.zG() + ", type = " + bcVar3.type);
            valueOf = null;
            break;
        }
        i = 1;
        if (arrayList.size() > 0 || r4 == null) {
            return null;
        }
        int i8 = 0;
        bc bcVar4 = null;
        i5 = 0;
        while (i5 < arrayList.size()) {
            int i9;
            if (g.aJg().a((bc) arrayList.get(i5))) {
                if (bcVar4 == null) {
                    bcVar3 = (bc) arrayList.get(i5);
                    bcVar3.cuS = 1;
                } else {
                    bcVar3 = bcVar4;
                }
                i9 = i8 + 1;
            } else {
                bcVar3 = bcVar4;
                i9 = i8;
            }
            i5++;
            i8 = i9;
            bcVar4 = bcVar3;
        }
        if (i8 > 0) {
            ak.yW();
            ab Mh = com.tencent.mm.model.c.wK().Mh(bc.eO(i2));
            if (Mh == null || !Mh.field_username.equals(bc.eO(i2))) {
                ab abVar = new ab();
                abVar.setUsername(bc.eO(i2));
                abVar.setContent(bcVar4 == null ? "" : bcVar4.getTitle());
                abVar.s(bcVar4 == null ? be.Ni() : bcVar4.time);
                abVar.di(0);
                abVar.df(i3);
                ak.yW();
                com.tencent.mm.model.c.wK().d(abVar);
            } else {
                Mh.setContent(bcVar4.getTitle());
                Mh.s(bcVar4.time);
                Mh.di(0);
                Mh.df(i3 + Mh.field_unReadCount);
                ak.yW();
                com.tencent.mm.model.c.wK().a(Mh, bc.eO(i2), true);
            }
            g.aJg().Ls();
            str = bcVar4.getTitle();
            at atVar = new at();
            atVar.setContent(str);
            atVar.cH(bc.eO(i2));
            atVar.setType(1);
            atVar.x(7377812);
            return new b(atVar, true);
        }
        v.e("MicroMsg.ReaderAppMsgExtension", "insert error");
        return null;
        v.a("MicroMsg.ReaderAppMsgExtension", th, "", new Object[0]);
        i3 = i2;
        i2 = i;
        v.d("MicroMsg.ReaderAppMsgExtension", "type = " + i2 + ", want to receive news? " + aJe());
        for (bc bcVar32 : arrayList) {
            if (be.kS(bcVar32.getTitle())) {
                if (be.kS(bcVar32.getUrl())) {
                    v.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getUrl() is null, appInfo.tweetid = " + bcVar32.zG() + ", type = " + bcVar32.type);
                    valueOf = null;
                    break;
                }
            }
            v.e("MicroMsg.ReaderAppMsgExtension", "readerAppInfo.getTitle() is null, appInfo.tweetid = " + bcVar32.zG() + ", type = " + bcVar32.type);
            valueOf = null;
            break;
        }
        i = 1;
        if (arrayList.size() > 0) {
        }
        return null;
    }

    public static boolean aJe() {
        return (k.xL() & 1024) == 0;
    }

    public final void d(at atVar) {
    }
}
