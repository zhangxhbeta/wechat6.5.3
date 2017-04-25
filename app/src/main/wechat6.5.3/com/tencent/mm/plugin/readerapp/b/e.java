package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.o.f;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class e implements f {
    public static e ilc = new e();

    private e() {
    }

    public final void a(int i, Map<String, bm> map, boolean z) {
        v.i("MicroMsg.ReaderFuncMsgUpdateMgr", "onFunctionMsgUpdate, op: %s, msgIdMap.size: %s, needUpdateTime: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(map.size()), Boolean.valueOf(z)});
        for (String str : map.keySet()) {
            bm bmVar = (bm) map.get(str);
            List<bc> a = a(bmVar, str);
            if (a != null) {
                long j = ((long) bmVar.hNS) * 1000;
                if (!(a == null || a.size() == 0)) {
                    v.i("MicroMsg.ReaderFuncMsgUpdateMgr", "processInfoList, op: %s, infoList.size: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(a.size())});
                    bc bcVar;
                    if (i == 1) {
                        for (bc bcVar2 : a) {
                            v.i("MicroMsg.ReaderFuncMsgUpdateMgr", "delete info, functionMsgId: %s", new Object[]{bcVar2.zM()});
                            g.aJg().a(bcVar2.zM(), bcVar2.type, true, true);
                        }
                    } else if (i == 0) {
                        bc bcVar3 = null;
                        List<bc> q = g.aJg().q(str, ((bc) a.get(0)).type);
                        bc bcVar4 = null;
                        v.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, functionMsgId: %s, oldInfoList: %s", new Object[]{str, q});
                        Object obj = null;
                        int i2 = 0;
                        int i3 = 0;
                        for (bc bcVar5 : a) {
                            if (bcVar3 == null) {
                                i3 = bcVar5.type;
                                bcVar5.cuS = 1;
                                bcVar3 = bcVar5;
                            }
                            if (q == null) {
                                v.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, insert new msg, functionMsgId: %s", new Object[]{bcVar5.zM()});
                                i2++;
                                g.aJg().a(bcVar5);
                            } else {
                                int i4;
                                Object obj2;
                                if (z) {
                                    bcVar5.time = j;
                                    if (bcVar3 != null) {
                                        bcVar3.time = j;
                                    }
                                    i4 = i2 + 1;
                                } else {
                                    if (bcVar4 == null) {
                                        bcVar2 = (bc) q.get(0);
                                        bcVar4 = bcVar2;
                                        for (bc bcVar22 : q) {
                                            if (bcVar22.cuS != 1) {
                                                bcVar22 = bcVar4;
                                            }
                                            bcVar4 = bcVar22;
                                        }
                                    }
                                    bcVar5.time = bcVar4.time;
                                    if (bcVar3 != null) {
                                        bcVar3.time = bcVar4.time;
                                    }
                                    i4 = i2;
                                }
                                v.i("MicroMsg.ReaderFuncMsgUpdateMgr", "update info, update the exist one, functionMsgId: %s, time: %s", new Object[]{bcVar5.zM(), Long.valueOf(bcVar5.time)});
                                if (obj == null) {
                                    g.aJg().a(bcVar5.zM(), bcVar5.type, false, false);
                                    obj2 = 1;
                                } else {
                                    obj2 = obj;
                                }
                                g.aJg().a(bcVar5);
                                obj = obj2;
                                i2 = i4;
                            }
                        }
                        if (i2 > 0) {
                            ak.yW();
                            ab Mh = c.wK().Mh(bc.eO(i3));
                            if (Mh == null || !Mh.field_username.equals(bc.eO(i3))) {
                                ab abVar = new ab();
                                abVar.setUsername(bc.eO(i3));
                                abVar.setContent(bcVar3 == null ? "" : bcVar3.getTitle());
                                abVar.s(bcVar3 == null ? be.Ni() : bcVar3.time);
                                abVar.di(0);
                                abVar.df(1);
                                ak.yW();
                                c.wK().d(abVar);
                            } else {
                                Mh.s(bcVar3.time);
                                Mh.di(0);
                                if (!(be.kS(bcVar3.getTitle()) || bcVar3.getTitle().equals(Mh.field_content)) || Mh.field_unReadCount == 0) {
                                    Mh.setContent(bcVar3.getTitle());
                                    Mh.df(Mh.field_unReadCount + 1);
                                }
                                ak.yW();
                                c.wK().a(Mh, bc.eO(i3), true);
                            }
                        }
                        g.aJg().Ls();
                    }
                }
            }
        }
    }

    private static List<bc> a(bm bmVar, String str) {
        String trim = m.a(bmVar.mbW).trim();
        if (trim.indexOf("<") != -1) {
            trim = trim.substring(trim.indexOf("<"));
        }
        long j = ((long) bmVar.hNS) * 1000;
        v.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg, createTime: %s, content: %s", new Object[]{Integer.valueOf(bmVar.hNS), trim});
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        List<bc> arrayList = new ArrayList();
        try {
            Map q = bf.q(trim, "mmreader");
            int i = 0;
            while (i <= 0) {
                String str2 = ".mmreader.category" + (i > 0 ? Integer.valueOf(i) : "");
                int i2 = be.getInt((String) q.get(str2 + ".$type"), 0);
                if (i2 != 0) {
                    if (i2 != 20 && i2 != 11) {
                        v.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error Type:" + i2);
                        break;
                    }
                    trim = (String) q.get(str2 + ".name");
                    if (be.kS(trim)) {
                        v.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".name  error");
                        break;
                    }
                    String str3 = (String) q.get(str2 + ".topnew.cover");
                    String str4 = (String) q.get(str2 + ".topnew.digest");
                    int i3 = be.getInt((String) q.get(str2 + ".$count"), 0);
                    if (i3 == 0) {
                        v.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$count  error");
                        break;
                    }
                    if (i3 > 1) {
                        str2 = str2 + (i2 == 20 ? ".newitem" : ".item");
                    } else {
                        str2 = str2 + ".item";
                    }
                    int i4 = 0;
                    while (i4 < i3) {
                        String str5 = str2 + (i4 > 0 ? Integer.valueOf(i4) : "");
                        bc bcVar = new bc();
                        bcVar.M((long) bmVar.mbT);
                        bcVar.title = (String) q.get(str5 + ".title");
                        if (i4 == 0) {
                            bcVar.cuS = 1;
                            bcVar.cqI = str3;
                            bcVar.cqK = be.kS(str4) ? (String) q.get(str5 + ".digest") : str4;
                        } else {
                            bcVar.cqI = (String) q.get(str5 + ".cover");
                            bcVar.cqK = (String) q.get(str5 + ".digest");
                        }
                        bcVar.cuT = q.containsKey(new StringBuilder().append(str5).append(".vedio").toString()) ? 1 : 0;
                        bcVar.url = (String) q.get(str5 + ".url");
                        bcVar.cuN = (String) q.get(str5 + ".shorturl");
                        bcVar.cuO = (String) q.get(str5 + ".longurl");
                        bcVar.cuP = be.getLong((String) q.get(str5 + ".pub_time"), 0);
                        String str6 = (String) q.get(str5 + ".tweetid");
                        if (str6 == null || "".equals(str6)) {
                            str6 = "N" + simpleDateFormat.format(new Date(System.currentTimeMillis() + ((long) i4)));
                            v.d("MicroMsg.ReaderFuncMsgUpdateMgr", "create tweetID = " + str6);
                        }
                        bcVar.cuM = str6;
                        bcVar.cuQ = (String) q.get(str5 + ".sources.source.name");
                        bcVar.cuR = (String) q.get(str5 + ".sources.source.icon");
                        bcVar.time = ((long) i) + j;
                        bcVar.type = i2;
                        bcVar.name = trim;
                        bcVar.cuV = str;
                        arrayList.add(bcVar);
                        String[] strArr = new Object[2];
                        strArr[0] = o.F(aa.getContext().getString(2131232866), bcVar.cuP);
                        strArr[1] = o.c(aa.getContext(), bcVar.time, false);
                        v.d("MicroMsg.ReaderFuncMsgUpdateMgr", "parse info, pubtime: %s, time: %s", strArr);
                        i4++;
                    }
                    i++;
                } else {
                    v.e("MicroMsg.ReaderFuncMsgUpdateMgr", "get " + str2 + ".$type  error");
                    break;
                }
            }
            return arrayList;
        } catch (Throwable e) {
            v.a("MicroMsg.ReaderFuncMsgUpdateMgr", e, "", new Object[0]);
            v.e("MicroMsg.ReaderFuncMsgUpdateMgr", "parseMsg error: %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
