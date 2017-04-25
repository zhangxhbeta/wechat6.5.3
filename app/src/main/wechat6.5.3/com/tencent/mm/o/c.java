package com.tencent.mm.o;

import com.tencent.mm.o.b.a;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c {
    volatile boolean chY = false;
    private volatile boolean chZ = false;
    private List<Map<String, String>> cia = new CopyOnWriteArrayList();

    public final void a(bm bmVar, Map<String, String> map) {
        v.j("MicroMsg.FunctionMsgFetcher", "fetchFromNewXml, newXmlMsgQueue.size: %s, addMsg.createTime: %s", Integer.valueOf(this.cia.size()), Integer.valueOf(bmVar.hNS));
        map.put("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY", String.valueOf(bmVar.hNS));
        this.cia.add(map);
        ug();
    }

    public final synchronized boolean ug() {
        boolean z;
        if (this.cia.size() <= 0) {
            v.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, all process finished");
            z = false;
        } else if (this.chZ) {
            v.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, processing new xml");
            z = false;
        } else {
            this.chZ = true;
            Map map = (Map) this.cia.remove(0);
            String str = (String) map.get(".sysmsg.functionmsg.cgi");
            int i = be.getInt((String) map.get(".sysmsg.functionmsg.cmdid"), 0);
            String str2 = (String) map.get(".sysmsg.functionmsg.functionmsgid");
            long j = be.getLong((String) map.get(".sysmsg.functionmsg.version"), 0);
            int i2 = be.getInt((String) map.get(".sysmsg.functionmsg.op"), 0);
            String str3 = (String) map.get(".sysmsg.functionmsg.custombuff");
            v.d("MicroMsg.FunctionMsgFetcher", "processNextNewXml, cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, op: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s", str, Integer.valueOf(i), str2, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(be.getInt((String) map.get(".sysmsg.functionmsg.retryinterval"), 0)), Integer.valueOf(be.getInt((String) map.get(".sysmsg.functionmsg.reportid"), 0)), Integer.valueOf(be.getInt((String) map.get(".sysmsg.functionmsg.successkey"), 0)), Integer.valueOf(be.getInt((String) map.get(".sysmsg.functionmsg.failkey"), 0)), Integer.valueOf(be.getInt((String) map.get(".sysmsg.functionmsg.finalfailkey"), 0)), str3);
            com.tencent.mm.sdk.h.c dVar = new d();
            if (!be.kS(str)) {
                dVar.field_cgi = str;
            }
            dVar.field_cmdid = i;
            if (!be.kS(str2)) {
                dVar.field_functionmsgid = str2;
            }
            dVar.field_version = j;
            dVar.field_retryinterval = r10;
            dVar.field_reportid = r11;
            dVar.field_successkey = r12;
            dVar.field_failkey = r13;
            dVar.field_finalfailkey = r14;
            if (!be.kS(str3)) {
                dVar.field_custombuff = str3;
            }
            dVar.field_status = -1;
            dVar.b(null);
            int intValue = Integer.valueOf((String) map.get("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY")).intValue();
            com.tencent.mm.sdk.h.c dL = h.uo().dL(dVar.field_functionmsgid);
            if (dL != null) {
                v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem.status: %s, version: %s, preVersion: %s", Integer.valueOf(dL.field_status), Long.valueOf(dL.field_version), Long.valueOf(dL.field_preVersion));
            }
            v.d("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem: %s", dL);
            if (i2 == 0) {
                dVar.field_needShow = true;
                if (dL == null) {
                    v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, insert a new one", dVar.field_functionmsgid);
                    h.uo().b(dVar);
                } else if (dL.field_version < dVar.field_version) {
                    v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, update the exist one", dVar.field_functionmsgid);
                    dL.field_preVersion = dL.field_version;
                    dVar.field_preVersion = dL.field_version;
                    h.uo().a(dL.field_functionmsgid, dVar);
                }
                ui();
            } else if (i2 == 1) {
                v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, op delete");
                if (dL != null) {
                    v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s", dL.field_functionmsgid, Long.valueOf(dVar.field_version), Long.valueOf(dL.field_version));
                    if (dVar.field_version == dL.field_version || dVar.field_version == 0) {
                        if (dL != null) {
                            try {
                                bm a = a(dL.field_addMsg);
                                str3 = "MicroMsg.FunctionMsgFetcher";
                                r6 = "callbackToDelete, msgContent==null: %s";
                                r7 = new Object[1];
                                r7[0] = Boolean.valueOf(a == null);
                                v.d(str3, r6, r7);
                                if (a != null) {
                                    Map singletonMap = Collections.singletonMap(dL.field_functionmsgid, dL.field_addMsg);
                                    List<f> list = (List) h.un().cio.get(Integer.valueOf(a.gll));
                                    if (list != null) {
                                        for (f a2 : list) {
                                            a2.a(1, singletonMap, false);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                v.e("MicroMsg.FunctionMsgFetcher", "callbackToDelete error: %s", e.getMessage());
                            }
                        }
                        h.uo().c(dL, new String[0]);
                    }
                } else {
                    v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, the origin one not exist", dVar.field_functionmsgid);
                }
                uj();
            } else if (i2 == 2) {
                dVar.field_needShow = false;
                if (dL == null) {
                    v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, insert a new one", dVar.field_functionmsgid);
                    h.uo().b(dVar);
                } else if (dL.field_version < dVar.field_version) {
                    v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, update the exist one, preVersion: %s", dVar.field_functionmsgid, Long.valueOf(dL.field_preVersion));
                    dL.field_preVersion = dL.field_version;
                    dVar.field_preVersion = dL.field_version;
                    h.uo().a(dL.field_functionmsgid, dVar);
                }
                ui();
            } else {
                if (i2 == 3) {
                    v.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op show, functionMsgItem: %s", dVar.field_functionmsgid, dL);
                    dVar.field_needShow = true;
                    if (dL != null) {
                        str3 = "MicroMsg.FunctionMsgFetcher";
                        r6 = "fetchInternal, op show, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, functionMsgItem.msgContent == null: %s";
                        r7 = new Object[3];
                        r7[0] = Long.valueOf(dVar.field_version);
                        r7[1] = Long.valueOf(dL.field_version);
                        r7[2] = Boolean.valueOf(dL.field_addMsg == null);
                        v.i(str3, r6, r7);
                        if (dL.field_version >= dVar.field_version || dVar.field_version == 0) {
                            dL.field_needShow = true;
                            if (dL.field_addMsg != null) {
                                v.i("MicroMsg.FunctionMsgFetcher", "show, update create time to: %s", Integer.valueOf(intValue));
                                dL.field_addMsg.hNS = intValue;
                            }
                            h.uo().a(dL.field_functionmsgid, dL);
                            if (dL.field_addMsg != null) {
                                b(Collections.singletonList(dL), true);
                            }
                        }
                    }
                }
                uj();
            }
            z = true;
        }
        return z;
    }

    private static bm a(bm bmVar) {
        boolean z = true;
        if (bmVar == null) {
            return null;
        }
        String str = "MicroMsg.FunctionMsgFetcher";
        String str2 = "processAddMsg, fromUser: %s, msgType: %s, content==null: %s";
        Object[] objArr = new Object[3];
        objArr[0] = bmVar.mbU;
        objArr[1] = Integer.valueOf(bmVar.gll);
        if (bmVar.mbW != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        String ma = be.ma(m.a(bmVar.mbU));
        if ("readerapp".equals(ma)) {
            bmVar.mbU = m.lY("newsapp");
            bmVar.gll = 12399999;
        }
        if (!"blogapp".equals(ma) && !"newsapp".equals(ma)) {
            return bmVar;
        }
        bmVar.gll = 12399999;
        return bmVar;
    }

    public final synchronized boolean uh() {
        return this.chY;
    }

    public final synchronized void ui() {
        if (this.chY) {
            v.j("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, isFetching, ignore this", new Object[0]);
            uj();
        } else if (ak.isNetworkConnected(aa.getContext())) {
            this.chY = true;
            List uk = h.uo().uk();
            v.d("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItems: %s", uk);
            if (uk == null || uk.size() <= 0) {
                this.chY = false;
                uj();
            } else {
                v.i("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItem.size: %s", Integer.valueOf(uk.size()));
                new b(uk, new a(this) {
                    final /* synthetic */ c cib;

                    {
                        this.cib = r1;
                    }

                    public final void r(List<d> list) {
                        this.cib.chY = false;
                        if (list != null) {
                            v.i("MicroMsg.FunctionMsgFetcher", "onFetchFinish, fetchSuccessList.size: %s", list);
                            c.b(list, false);
                        }
                        this.cib.uj();
                    }
                }).start();
            }
        } else {
            v.j("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed network not connected, ignore this", new Object[0]);
            uj();
        }
    }

    final void uj() {
        v.j("MicroMsg.FunctionMsgFetcher", "loopToNextNewXml", new Object[0]);
        this.chZ = false;
        ug();
    }

    static void b(List<d> list, boolean z) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collection arrayList = new ArrayList();
                    for (d dVar : list) {
                        if (dVar.field_needShow) {
                            dVar.b(a(dVar.field_addMsg));
                            arrayList.add(dVar);
                        }
                    }
                    v.d("MicroMsg.FunctionMsgFetcher", "callbackToUpdate, msgList.size: %s, isShow: %s", Integer.valueOf(arrayList.size()), Boolean.valueOf(z));
                    Map c = c(arrayList);
                    for (Integer intValue : c.keySet()) {
                        int intValue2 = intValue.intValue();
                        List<d> list2 = (List) c.get(Integer.valueOf(intValue2));
                        Map hashMap = new HashMap();
                        for (d dVar2 : list2) {
                            hashMap.put(dVar2.field_functionmsgid, dVar2.field_addMsg);
                        }
                        List<f> list3 = (List) h.un().cio.get(Integer.valueOf(intValue2));
                        if (list3 != null) {
                            for (f a : list3) {
                                a.a(0, hashMap, z);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                v.e("MicroMsg.FunctionMsgFetcher", "callbackToUpdate error: %s", e.getMessage());
            }
        }
    }

    private static Map<Integer, List<d>> c(Collection<d> collection) {
        Map<Integer, List<d>> hashMap = new HashMap();
        for (d dVar : collection) {
            if (dVar.field_addMsg != null) {
                List list = (List) hashMap.get(Integer.valueOf(dVar.field_addMsg.gll));
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(dVar);
                hashMap.put(Integer.valueOf(dVar.field_addMsg.gll), list);
            }
        }
        return hashMap;
    }
}
