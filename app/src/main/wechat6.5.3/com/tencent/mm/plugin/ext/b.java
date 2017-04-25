package com.tencent.mm.plugin.ext;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.e.a.dy;
import com.tencent.mm.e.a.eg;
import com.tencent.mm.e.a.em;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderEntry;
import com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg;
import com.tencent.mm.plugin.ext.voicecontrol.ExtControlProviderVoiceControl;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.s;
import com.tencent.mm.pluginsdk.model.g;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.protocal.c.bcx;
import com.tencent.mm.protocal.c.zz;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class b implements ag {
    private static HashMap<Integer, c> bXq;
    private static boolean fGH = false;
    private String cka;
    private ac fGA = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ b fGI;

        @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140514", reviewer = 20, vComment = {EType.INTENTCHECK})
        public final void handleMessage(Message message) {
            if (aa.getContext() == null || !ak.uz()) {
                v.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong status");
                return;
            }
            Cursor bxb = b.akM().bxb();
            if (bxb == null) {
                v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler getValidOpenMsgListener cu == null");
                return;
            }
            v.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler listener count = %s", Integer.valueOf(bxb.getCount()));
            if (bxb.getCount() <= 0) {
                bxb.close();
                v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler cu.getCount() <= 0");
                return;
            }
            try {
                if (bxb.moveToFirst()) {
                    HashMap hashMap = new HashMap();
                    synchronized (this.fGI) {
                        hashMap.putAll(this.fGI.fGx);
                        this.fGI.fGx.clear();
                    }
                    do {
                        LinkedList linkedList = new LinkedList();
                        ArrayList arrayList = new ArrayList();
                        if (hashMap.entrySet() == null) {
                            v.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler waitForNotify.entrySet() == null");
                            return;
                        }
                        av avVar = new av();
                        avVar.b(bxb);
                        if (be.kS(avVar.field_appId) || be.kS(avVar.field_packageName)) {
                            v.w("MicroMsg.SubCoreExt", "notifyMsgChangeHandler wrong msgListener, appid = %s, package = %s", avVar.field_appId, avVar.field_packageName);
                        } else {
                            for (Entry entry : hashMap.entrySet()) {
                                String ma = be.ma((String) entry.getKey());
                                Integer num = (Integer) entry.getValue();
                                ak.yW();
                                af Mh = com.tencent.mm.model.c.wK().Mh(ma);
                                if (Mh != null && !be.kS(Mh.field_username) && Mh.field_unReadCount <= 0) {
                                    v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler no unread in conversation");
                                } else if (!(m.fo(ma) || m.dE(ma) || m.eD(ma))) {
                                    bc bcVar;
                                    bd akN = b.akN();
                                    String str = avVar.field_appId;
                                    if (str == null || str.length() <= 0 || ma == null || ma.length() <= 0) {
                                        bcVar = null;
                                    } else {
                                        Cursor query = akN.cie.query("UserOpenIdInApp", null, "appId=? and username=? ", new String[]{be.lZ(str), be.lZ(ma)}, null, null, null);
                                        if (query.getCount() <= 0) {
                                            v.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with appId-%s, username-%s:", str, ma);
                                            query.close();
                                            bcVar = null;
                                        } else {
                                            query.moveToFirst();
                                            bcVar = new bc();
                                            bcVar.b(query);
                                            query.close();
                                        }
                                    }
                                    if (bcVar == null || be.kS(bcVar.field_openId) || be.kS(bcVar.field_username)) {
                                        v.d("MicroMsg.SubCoreExt", "notifyMsgChangeHandler openId is null, go get it.");
                                        Integer num2 = (Integer) this.fGI.fGx.get(ma);
                                        if (num2 == null) {
                                            this.fGI.fGx.put(ma, num);
                                        } else {
                                            this.fGI.fGx.put(ma, Integer.valueOf(num2.intValue() + num.intValue()));
                                        }
                                        linkedList.add(ma);
                                    } else {
                                        v.v("MicroMsg.SubCoreExt", "username[%s], appId[%s], openId[%s]", bcVar.field_username, bcVar.field_appId, bcVar.field_openId);
                                        arrayList.add(String.format("%s,%s,%s", new Object[]{bcVar.field_openId, num, Long.valueOf(System.currentTimeMillis() - 1600)}));
                                    }
                                }
                            }
                            if (linkedList.size() > 0) {
                                v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler doGetGetUserInfoInApp");
                                b bVar = this.fGI;
                                String str2 = avVar.field_appId;
                                if (!be.kS(str2) && linkedList.size() > 0) {
                                    g bmQ = g.bmQ();
                                    Context context = aa.getContext();
                                    com.tencent.mm.pluginsdk.model.g.a aVar = bVar.fGz;
                                    v.d("MicroMsg.GetUserInfoInAppLogic", "getGetUserInfoInApp");
                                    if (!g.lze) {
                                        bmQ.bmR();
                                    }
                                    if (ak.uz() && context != null) {
                                        if (linkedList.size() == 0) {
                                            v.d("MicroMsg.GetUserInfoInAppLogic", "userNameList empty");
                                        } else {
                                            bmQ.lzg = aVar;
                                            com.tencent.mm.pluginsdk.model.app.v kVar = new k(str2, linkedList);
                                            am.ash();
                                            d.a(14, kVar);
                                        }
                                    }
                                }
                            }
                            if (arrayList.size() <= 0) {
                                bxb.close();
                                v.i("MicroMsg.SubCoreExt", "notifyMsgChangeHandler userDataList.size() <= 0");
                                return;
                            }
                            if ((avVar.field_status == 1 ? 1 : null) == null) {
                                v.w("MicroMsg.SubCoreExt", "invalid msgListener, appid = %s, package = %s", avVar.field_appId, avVar.field_packageName);
                            } else if (!(be.kS(avVar.field_appId) || be.kS(avVar.field_packageName))) {
                                v.i("MicroMsg.SubCoreExt", "notify app, appId = %s, package = %s", avVar.field_appId, avVar.field_packageName);
                                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_NOTIFY_MSG");
                                intent.addCategory("com.tencent.mm.category." + avVar.field_packageName);
                                com.tencent.mm.compatible.a.a.a(12, new com.tencent.mm.compatible.a.a.a(this) {
                                    final /* synthetic */ AnonymousClass7 fGJ;

                                    public final void run() {
                                        intent.setFlags(32);
                                    }
                                });
                                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "NEW_MESSAGE");
                                intent.putStringArrayListExtra("EXTRA_EXT_OPEN_USER_DATA", arrayList);
                                aa.getContext().sendBroadcast(intent);
                            }
                        }
                    } while (bxb.moveToNext());
                }
                bxb.close();
            } catch (Exception e) {
                v.e("MicroMsg.SubCoreExt", "Exception in handleMessage, %s", e.getMessage());
                if (bxb != null) {
                    bxb.close();
                }
            }
        }
    };
    private LinkedList<String> fGB = new LinkedList();
    private final long fGC = 60;
    private ac fGD = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ b fGI;

        public final void handleMessage(Message message) {
            try {
                if (this.fGI.fGB.size() > 0) {
                    Iterator it = this.fGI.fGB.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (!"*".equals(str)) {
                            f aC = com.tencent.mm.pluginsdk.model.app.g.aC(str, false);
                            if (aC == null) {
                                v.w("MicroMsg.SubCoreExt", "appInfo is null");
                            } else if (be.kS(aC.field_appId)) {
                                v.w("MicroMsg.SubCoreExt", "appId is null");
                            } else {
                                v.d("MicroMsg.SubCoreExt", "onAppInfoStgChange, notify[%s], appFlag[%s], id[%s]", str, Integer.valueOf(aC.field_appInfoFlag), aC.field_appId);
                                av Nl = b.akM().Nl(aC.field_appId);
                                if (Nl == null) {
                                    v.w("MicroMsg.SubCoreExt", "openMsgListener is null, appId = %s", aC.field_appId);
                                } else {
                                    if (com.tencent.mm.pluginsdk.model.app.g.j(aC)) {
                                        if (Nl.field_status != 1) {
                                            Nl.field_status = 1;
                                        }
                                    } else if (Nl.field_status != 0) {
                                        Nl.field_status = 0;
                                    }
                                    aw akM = b.akM();
                                    if (be.kS(aC.field_appId) || Nl == null || be.kS(Nl.field_appId)) {
                                        v.w("MicroMsg.OpenMsgListenerStorage", "wrong argument");
                                    } else {
                                        int update;
                                        ContentValues py = Nl.py();
                                        if (py.size() > 0) {
                                            update = akM.cie.update("OpenMsgListener", py, "appId=?", new String[]{be.lZ(r3)});
                                        } else {
                                            update = 0;
                                        }
                                        v.d("MicroMsg.OpenMsgListenerStorage", "update: id=%s, ret=%s ", Nl.field_appId, Integer.valueOf(update));
                                    }
                                }
                            }
                        }
                    }
                    this.fGI.fGB.clear();
                }
            } catch (Exception e) {
                v.e("MicroMsg.SubCoreExt", "exception in onAppInfoStgChange, %s", e.getMessage());
            }
        }
    };
    private com.tencent.mm.sdk.h.g.a fGE = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ b fGI;

        {
            this.fGI = r1;
        }

        public final void a(String str, i iVar) {
            if (!this.fGI.fGB.contains(str)) {
                this.fGI.fGB.add(str);
            }
            this.fGI.fGD.removeMessages(0);
            this.fGI.fGD.sendEmptyMessageDelayed(0, 60);
        }
    };
    private boolean fGF = true;
    private boolean fGG = false;
    private final long fGr = 1600;
    private r fGs;
    private aw fGt;
    private bd fGu;
    private a fGv;
    private b fGw;
    private HashMap<String, Integer> fGx = new HashMap();
    private com.tencent.mm.storage.au.a fGy = new com.tencent.mm.storage.au.a(this) {
        final /* synthetic */ b fGI;

        {
            this.fGI = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.storage.au r9, com.tencent.mm.storage.au.c r10) {
            /*
            r8 = this;
            r0 = 0;
            if (r9 == 0) goto L_0x0009;
        L_0x0003:
            if (r10 == 0) goto L_0x0009;
        L_0x0005:
            r1 = r10.nwt;
            if (r1 != 0) goto L_0x0013;
        L_0x0009:
            r0 = "MicroMsg.SubCoreExt";
            r1 = "onMsgChange, wrong args";
            com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        L_0x0012:
            return;
        L_0x0013:
            r3 = r8.fGI;
            monitor-enter(r3);
            r1 = com.tencent.mm.plugin.ext.b.akM();	 Catch:{ all -> 0x002b }
            r1 = r1.bxb();	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x002e;
        L_0x0020:
            r0 = "MicroMsg.SubCoreExt";
            r1 = "onMsgChange onNotifyChange getValidOpenMsgListener cu == null";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);	 Catch:{ all -> 0x002b }
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            goto L_0x0012;
        L_0x002b:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            throw r0;
        L_0x002e:
            r2 = "MicroMsg.SubCoreExt";
            r4 = "onMsgChange onNotifyChange listener count = %s";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x002b }
            r6 = 0;
            r7 = r1.getCount();	 Catch:{ all -> 0x002b }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x002b }
            r5[r6] = r7;	 Catch:{ all -> 0x002b }
            com.tencent.mm.sdk.platformtools.v.d(r2, r4, r5);	 Catch:{ all -> 0x002b }
            r2 = r1.getCount();	 Catch:{ all -> 0x002b }
            if (r2 > 0) goto L_0x0059;
        L_0x004b:
            r1.close();	 Catch:{ all -> 0x002b }
            r0 = "MicroMsg.SubCoreExt";
            r1 = "onMsgChange onNotifyChange cu.getCount() <= 0";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);	 Catch:{ all -> 0x002b }
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            goto L_0x0012;
        L_0x0059:
            r1.close();	 Catch:{ all -> 0x002b }
            r2 = r0;
        L_0x005d:
            r0 = r10.nwt;	 Catch:{ all -> 0x002b }
            r0 = r0.size();	 Catch:{ all -> 0x002b }
            if (r2 >= r0) goto L_0x00fd;
        L_0x0065:
            r0 = r10.nwt;	 Catch:{ all -> 0x002b }
            r0 = r0.get(r2);	 Catch:{ all -> 0x002b }
            r0 = (com.tencent.mm.storage.at) r0;	 Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x00c5;
        L_0x006f:
            r1 = r0.field_isSend;	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00c5;
        L_0x0073:
            r1 = r0.field_status;	 Catch:{ all -> 0x002b }
            r4 = 4;
            if (r1 == r4) goto L_0x00c5;
        L_0x0078:
            r1 = r0.field_type;	 Catch:{ all -> 0x002b }
            r4 = 9999; // 0x270f float:1.4012E-41 double:4.94E-320;
            if (r1 == r4) goto L_0x00c5;
        L_0x007e:
            r1 = r0.field_type;	 Catch:{ all -> 0x002b }
            r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            if (r1 == r4) goto L_0x00c5;
        L_0x0084:
            r1 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r1 = com.tencent.mm.model.m.fo(r1);	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00c5;
        L_0x008c:
            r1 = r8.fGI;	 Catch:{ all -> 0x002b }
            r1 = r1.fGx;	 Catch:{ all -> 0x002b }
            r4 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r1 = r1.get(r4);	 Catch:{ all -> 0x002b }
            r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x00c9;
        L_0x009c:
            r1 = r8.fGI;	 Catch:{ all -> 0x002b }
            r1 = r1.fGx;	 Catch:{ all -> 0x002b }
            r4 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r5 = 1;
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x002b }
            r1.put(r4, r5);	 Catch:{ all -> 0x002b }
            r1 = "MicroMsg.SubCoreExt";
            r4 = "onMsgChange %s, %d";
            r5 = 2;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x002b }
            r6 = 0;
            r0 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r5[r6] = r0;	 Catch:{ all -> 0x002b }
            r0 = 1;
            r6 = 1;
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x002b }
            r5[r0] = r6;	 Catch:{ all -> 0x002b }
            com.tencent.mm.sdk.platformtools.v.d(r1, r4, r5);	 Catch:{ all -> 0x002b }
        L_0x00c5:
            r0 = r2 + 1;
            r2 = r0;
            goto L_0x005d;
        L_0x00c9:
            r4 = r8.fGI;	 Catch:{ all -> 0x002b }
            r4 = r4.fGx;	 Catch:{ all -> 0x002b }
            r5 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r6 = r1.intValue();	 Catch:{ all -> 0x002b }
            r6 = r6 + 1;
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x002b }
            r4.put(r5, r6);	 Catch:{ all -> 0x002b }
            r4 = "MicroMsg.SubCoreExt";
            r5 = "onMsgChange %s, %d";
            r6 = 2;
            r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x002b }
            r7 = 0;
            r0 = r0.field_talker;	 Catch:{ all -> 0x002b }
            r6[r7] = r0;	 Catch:{ all -> 0x002b }
            r0 = 1;
            r1 = r1.intValue();	 Catch:{ all -> 0x002b }
            r1 = r1 + 1;
            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x002b }
            r6[r0] = r1;	 Catch:{ all -> 0x002b }
            com.tencent.mm.sdk.platformtools.v.d(r4, r5, r6);	 Catch:{ all -> 0x002b }
            goto L_0x00c5;
        L_0x00fd:
            r0 = r8.fGI;	 Catch:{ all -> 0x002b }
            r0 = r0.fGx;	 Catch:{ all -> 0x002b }
            r0 = r0.size();	 Catch:{ all -> 0x002b }
            if (r0 <= 0) goto L_0x0111;
        L_0x0109:
            r0 = r8.fGI;	 Catch:{ all -> 0x002b }
            r0.akQ();	 Catch:{ all -> 0x002b }
        L_0x010e:
            monitor-exit(r3);	 Catch:{ all -> 0x002b }
            goto L_0x0012;
        L_0x0111:
            r0 = "MicroMsg.SubCoreExt";
            r1 = "notifyMsgUsers.size < 1";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);	 Catch:{ all -> 0x002b }
            goto L_0x010e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.b.5.a(com.tencent.mm.storage.au, com.tencent.mm.storage.au$c):void");
        }
    };
    com.tencent.mm.pluginsdk.model.g.a fGz = new com.tencent.mm.pluginsdk.model.g.a(this) {
        final /* synthetic */ b fGI;

        {
            this.fGI = r1;
        }

        public final void a(k kVar) {
            if (kVar != null) {
                zz zzVar;
                if (kVar.fut == null) {
                    zzVar = null;
                } else {
                    zzVar = (zz) kVar.fut.czl.czs;
                }
                Iterator it = zzVar.mBu.iterator();
                int i = 0;
                while (it.hasNext()) {
                    bcx com_tencent_mm_protocal_c_bcx = (bcx) it.next();
                    v.v("MicroMsg.SubCoreExt", "AppId[%s], UserName[%s], Xml[%s]", kVar.lzC, com_tencent_mm_protocal_c_bcx.gln, com_tencent_mm_protocal_c_bcx.mYZ);
                    if (!(be.kS(com_tencent_mm_protocal_c_bcx.gln) || be.kS(com_tencent_mm_protocal_c_bcx.mYZ))) {
                        ak.yW();
                        com.tencent.mm.i.a LV = com.tencent.mm.model.c.wH().LV(com_tencent_mm_protocal_c_bcx.gln);
                        if (LV == null || ((int) LV.chr) <= 0) {
                            v.e("MicroMsg.SubCoreExt", "contact is null");
                        } else if (LV.bvm()) {
                            v.w("MicroMsg.SubCoreExt", "isBizContact");
                        } else {
                            com.tencent.mm.pluginsdk.model.g.b Gp = g.Gp(com_tencent_mm_protocal_c_bcx.mYZ);
                            if (!(Gp == null || be.kS(Gp.lzh))) {
                                v.v("MicroMsg.SubCoreExt", "AppId[%s], openId[%s]", kVar.lzC, Gp.lzh);
                                b.akN().a(new bc(kVar.lzC, com_tencent_mm_protocal_c_bcx.gln, Gp.lzh));
                                i = 1;
                            }
                        }
                    }
                }
                if (i != 0) {
                    this.fGI.akQ();
                }
            }
        }
    };
    com.tencent.mm.sdk.h.j.b fvi = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ b fGI;

        {
            this.fGI = r1;
        }

        public final void a(int i, j jVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                v.d("MicroMsg.SubCoreExt", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
            } else if (ak.uz()) {
                ak.yW();
                if (jVar == com.tencent.mm.model.c.wH()) {
                    this.fGI.cT(false);
                }
            } else {
                v.i("MicroMsg.SubCoreExt", "onNotifyChange acc not ready");
            }
        }
    };

    public static class a extends com.tencent.mm.sdk.c.c<eg> {
        public a() {
            this.nhz = eg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            eg egVar = (eg) bVar;
            if (!(egVar instanceof eg)) {
                v.f("MicroMsg.SubCoreExt", "mismatched event");
                return false;
            } else if (egVar.bcD == null) {
                v.e("MicroMsg.SubCoreExt", "revent.data is null");
                return false;
            } else {
                if (egVar.bcD.bbX == 9 || egVar.bcD.bbX == 13) {
                    ExtControlProviderMsg extControlProviderMsg = new ExtControlProviderMsg(egVar.bcD.aWv, egVar.bcD.bbX, egVar.bcD.context);
                    egVar.bcE.bbY = extControlProviderMsg.query(egVar.bcD.uri, null, null, egVar.bcD.selectionArgs, null);
                } else if (egVar.bcD.bbX == 3) {
                    ExtControlProviderEntry extControlProviderEntry = new ExtControlProviderEntry(egVar.bcD.aWv, egVar.bcD.bbX, egVar.bcD.context);
                    egVar.bcE.bbY = extControlProviderEntry.query(egVar.bcD.uri, null, null, egVar.bcD.selectionArgs, null);
                } else if (egVar.bcD.bbX == 29) {
                    ExtControlProviderVoiceControl extControlProviderVoiceControl = new ExtControlProviderVoiceControl(egVar.bcD.aWv, egVar.bcD.bbX, egVar.bcD.context);
                    egVar.bcE.bbY = extControlProviderVoiceControl.query(egVar.bcD.uri, null, null, egVar.bcD.selectionArgs, null);
                    SharedPreferences btk = aa.btk();
                    if (!b.fGH) {
                        btk.edit().putBoolean("hasCallVoiceControlApi", true).commit();
                        b.fGH = true;
                    }
                } else {
                    ExtControlProviderOpenApi extControlProviderOpenApi = new ExtControlProviderOpenApi(egVar.bcD.aWv, egVar.bcD.bbX, egVar.bcD.context);
                    egVar.bcE.bbY = extControlProviderOpenApi.query(egVar.bcD.uri, null, null, egVar.bcD.selectionArgs, null);
                }
                return true;
            }
        }
    }

    public static class b extends com.tencent.mm.sdk.c.c<em> {
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            em emVar = (em) bVar;
            if (emVar.bcU == null) {
                v.e("MicroMsg.SubCoreExt", "StepCount revent.data is null");
            } else {
                v.i("MicroMsg.SubCoreExt", " action = " + emVar.bcU.action);
                if (emVar.bcU.action == 1) {
                    b.akP();
                    v.d("MicroMsg.SubCoreExt", " sendBroadcast");
                    return true;
                }
            }
            return false;
        }

        public b() {
            super(0);
            this.nhz = em.class.getName().hashCode();
        }
    }

    static {
        int rx = l.rx();
        try {
            if (!Build.CPU_ABI.contains("armeabi")) {
                v.e("hakon SilkCodec", "x86 machines not supported.");
            } else if ((rx & 1024) != 0) {
                com.tencent.mm.compatible.util.k.b("wechatvoicesilk_v7a", b.class.getClassLoader());
            } else if ((rx & 512) != 0) {
                com.tencent.mm.compatible.util.k.b("wechatvoicesilk", b.class.getClassLoader());
            } else {
                v.e("hakon SilkCodec", "load library failed! silk don't support armv5!!!!");
            }
        } catch (Exception e) {
            v.e("hakon SilkCodec", "load library failed!");
        }
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("OPENMSGLISTENER_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return aw.cic;
            }
        });
        bXq.put(Integer.valueOf("USEROPENIDINAPP_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return bd.cic;
            }
        });
    }

    public static b akK() {
        b bVar = (b) ak.yP().fY("plugin.ext");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        ak.yP().a("plugin.ext", bVar2);
        return bVar2;
    }

    public static r akL() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (akK().fGs == null) {
            b akK = akK();
            ak.yW();
            akK.fGs = new r(com.tencent.mm.model.c.wE());
        }
        return akK().fGs;
    }

    public static aw akM() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (akK().fGt == null) {
            b akK = akK();
            ak.yW();
            akK.fGt = new aw(com.tencent.mm.model.c.wE());
        }
        return akK().fGt;
    }

    public static bd akN() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (akK().fGu == null) {
            b akK = akK();
            ak.yW();
            akK.fGu = new bd(com.tencent.mm.model.c.wE());
        }
        return akK().fGu;
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void aH(boolean z) {
        ak.yW();
        this.cka = com.tencent.mm.model.c.xq();
        File file = new File(this.cka);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.cka + "image/ext/pcm");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void aG(boolean z) {
        com.tencent.mm.sdk.c.b dyVar = new dy();
        dyVar.bbR.op = 1;
        if (!com.tencent.mm.sdk.c.a.nhr.z(dyVar)) {
            v.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountPostReset");
        }
        g.bmQ().bmR();
        ak.yW();
        com.tencent.mm.model.c.wJ().a(this.fGy, null);
        if (this.fGv == null) {
            this.fGv = new a();
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.fGv);
        if (this.fGw == null) {
            this.fGw = new b();
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.fGw);
        com.tencent.mm.pluginsdk.model.app.i bnB = am.bnB();
        if (bnB != null) {
            bnB.c(this.fGE);
        }
        SharedPreferences btk = aa.btk();
        this.fGG = btk.getBoolean("hasTryToInitVoiceControlData", false);
        fGH = btk.getBoolean("hasCallVoiceControlApi", false);
        v.i("MicroMsg.SubCoreExt", "onAccountPostReset,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(this.fGG), Boolean.valueOf(fGH));
        ak.yW();
        com.tencent.mm.model.c.wH().a(this.fvi);
        cT(true);
    }

    public final void th() {
        if (this.fGv != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.fGv);
        }
        if (this.fGw != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.fGw);
        }
        com.tencent.mm.pluginsdk.model.app.i bnB = am.bnB();
        if (bnB != null) {
            bnB.d(this.fGE);
        }
        ak.yW();
        com.tencent.mm.model.c.wJ().a(this.fGy);
        com.tencent.mm.sdk.c.b dyVar = new dy();
        dyVar.bbR.op = 2;
        if (!com.tencent.mm.sdk.c.a.nhr.z(dyVar)) {
            v.e("MicroMsg.SubCoreExt", "ExtAgentLifeEvent event fail in onAccountRelease");
        }
        s bmQ = g.bmQ();
        if (ak.uz()) {
            g.lze = false;
            am.ash().b(14, bmQ);
        }
        this.cka = SQLiteDatabase.KeyEmpty;
        ak.yW();
        com.tencent.mm.model.c.wH().b(this.fvi);
    }

    public static String akO() {
        return akK().cka + "image/ext/pcm";
    }

    public static void akP() {
        String str = (String) akL().get(com.tencent.mm.storage.t.a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        v.i("MicroMsg.SubCoreExt", "sendSportBroadcast pkgNames = " + str);
        if (str != null) {
            for (String str2 : str.split(";")) {
                final Intent intent = new Intent("com.tencent.mm.plugin.openapi.Intent.ACTION_SET_SPORT_STEP");
                intent.setPackage(str2);
                com.tencent.mm.compatible.a.a.a(12, new com.tencent.mm.compatible.a.a.a() {
                    public final void run() {
                        intent.setFlags(32);
                    }
                });
                intent.putExtra("EXTRA_EXT_OPEN_NOTIFY_TYPE", "SPORT_MESSAGE");
                aa.getContext().sendBroadcast(intent);
            }
        }
    }

    public final void ed(int i) {
    }

    public static u bt(long j) {
        if (!ak.uz() || j <= 0) {
            return null;
        }
        ak.yW();
        return com.tencent.mm.model.c.wH().eg(j);
    }

    public static void bu(long j) {
        if (j > 0) {
            try {
                int i;
                ak.yW();
                au wJ = com.tencent.mm.model.c.wJ();
                for (int i2 = 0; i2 < wJ.nwa.size(); i2++) {
                    if (((com.tencent.mm.storage.au.b) wJ.nwa.get(i2)).eq(j)) {
                        i = 1;
                        break;
                    }
                }
                i = 0;
                if (i != 0) {
                    ak.yW();
                    au wJ2 = com.tencent.mm.model.c.wJ();
                    ak.yW();
                    wJ2.S(com.tencent.mm.model.c.wJ().ek(j));
                    return;
                }
                v.e("MicroMsg.SubCoreExt", "msgId is out of range, " + j);
            } catch (Throwable e) {
                v.e("MicroMsg.SubCoreExt", e.getMessage());
                v.a("MicroMsg.SubCoreExt", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
    }

    public final void akQ() {
        this.fGA.removeMessages(0);
        this.fGA.sendEmptyMessageDelayed(0, 1600);
    }

    private void cT(boolean z) {
        if (!this.fGF) {
            return;
        }
        if (z && this.fGG) {
            v.i("MicroMsg.SubCoreExt", "fromStartApp and already try to init");
        } else if (z || fGH) {
            v.i("MicroMsg.SubCoreExt", "initLocalVoiceControl,fromStartApp:%s,hasTryToInit:%s,hasCallApi:%s", Boolean.valueOf(z), Boolean.valueOf(this.fGG), Boolean.valueOf(fGH));
            this.fGF = false;
            ak.vA().f(new Runnable(this) {
                final /* synthetic */ b fGI;

                {
                    this.fGI = r1;
                }

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                    r13 = this;
                    r7 = 0;
                    r12 = 1;
                    r0 = com.tencent.mm.h.j.sU();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "VoiceRecognizeSprSoMD5";
                    r1 = r0.getValue(r1);	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.h.j.sU();	 Catch:{ Exception -> 0x00e5 }
                    r2 = "VoiceRecognizeSprDataMD5";
                    r2 = r0.getValue(r2);	 Catch:{ Exception -> 0x00e5 }
                    if (r1 == 0) goto L_0x001c;
                L_0x001a:
                    if (r2 != 0) goto L_0x0034;
                L_0x001c:
                    r0 = "MicroMsg.SubCoreExt";
                    r3 = "error mMd5So:%s,  mMd5Data:%s";
                    r4 = 2;
                    r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00e5 }
                    r5 = 0;
                    r4[r5] = r1;	 Catch:{ Exception -> 0x00e5 }
                    r1 = 1;
                    r4[r1] = r2;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);	 Catch:{ Exception -> 0x00e5 }
                    r0 = r13.fGI;	 Catch:{ Exception -> 0x00e5 }
                    r0.fGF = true;	 Catch:{ Exception -> 0x00e5 }
                L_0x0033:
                    return;
                L_0x0034:
                    r0 = "/system/lib/";
                    r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x00e5 }
                    r4 = 24;
                    if (r3 < r4) goto L_0x0040;
                L_0x003d:
                    r0 = "/vendor/lib/";
                L_0x0040:
                    r3 = "MicroMsg.SubCoreExt";
                    r4 = "mMd5So:%s,  mMd5Data:%s,  mSoPath:%s";
                    r5 = 3;
                    r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00e5 }
                    r6 = 0;
                    r5[r6] = r1;	 Catch:{ Exception -> 0x00e5 }
                    r6 = 1;
                    r5[r6] = r2;	 Catch:{ Exception -> 0x00e5 }
                    r6 = 2;
                    r5[r6] = r0;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.v.i(r3, r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r3 = com.qq.wx.voice.embed.recognizer.b.a.aGW;	 Catch:{ Exception -> 0x00e5 }
                    r6 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ Exception -> 0x00e5 }
                    r3 = r3.aGV;	 Catch:{ Exception -> 0x00e5 }
                    r8 = r3.d;	 Catch:{ Exception -> 0x00e5 }
                    if (r8 == 0) goto L_0x00f9;
                L_0x0065:
                    r0 = r7;
                L_0x0066:
                    r8 = com.tencent.mm.sdk.platformtools.aa.btk();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "MicroMsg.SubCoreExt";
                    r2 = "checkFiles ret:%s,use time:%s";
                    r3 = 2;
                    r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
                    r6 = 0;
                    r9 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
                    r3[r6] = r9;	 Catch:{ Exception -> 0x00e5 }
                    r6 = 1;
                    r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r4 = r10 - r4;
                    r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00e5 }
                    r3[r6] = r4;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 != 0) goto L_0x01d5;
                L_0x008c:
                    r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r3 = new java.util.LinkedList;	 Catch:{ Exception -> 0x00e5 }
                    r3.<init>();	 Catch:{ Exception -> 0x00e5 }
                    r0 = "tmessage";
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                    r0 = "officialaccounts";
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                    r0 = "helper_entry";
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.model.ak.yW();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.model.c.wN();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "@t.qq.com";
                    r0 = r0.Nr(r1);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 == 0) goto L_0x00bc;
                L_0x00b7:
                    r0 = r0.name;	 Catch:{ Exception -> 0x00e5 }
                    r3.add(r0);	 Catch:{ Exception -> 0x00e5 }
                L_0x00bc:
                    r9 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00e5 }
                    r9.<init>();	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.model.ak.yW();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.tencent.mm.model.c.wH();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "@all.contact.android";
                    r2 = 0;
                    r4 = 0;
                    r5 = 1;
                    r6 = 1;
                    r0 = r0.a(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 != 0) goto L_0x0107;
                L_0x00d5:
                    r0 = "MicroMsg.SubCoreExt";
                    r1 = "initLocalVoiceControl cu is null";
                    com.tencent.mm.sdk.platformtools.v.w(r0, r1);	 Catch:{ Exception -> 0x00e5 }
                    r0 = r13.fGI;	 Catch:{ Exception -> 0x00e5 }
                    r0.fGF = true;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x0033;
                L_0x00e5:
                    r0 = move-exception;
                    r1 = "MicroMsg.SubCoreExt";
                    r2 = "initLocalVoiceControl Exception:%s";
                    r3 = new java.lang.Object[r12];
                    r0 = r0.getMessage();
                    r3[r7] = r0;
                    com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
                    goto L_0x0033;
                L_0x00f9:
                    r8 = r3.aHc;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r8.checkFiles(r6, r0, r1, r2);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 < 0) goto L_0x0066;
                L_0x0101:
                    r0 = 1;
                    r3.d = r0;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r7;
                    goto L_0x0066;
                L_0x0107:
                    r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x00e5 }
                    if (r1 == 0) goto L_0x012d;
                L_0x010d:
                    r1 = r0.isAfterLast();	 Catch:{ Exception -> 0x00e5 }
                    if (r1 != 0) goto L_0x012d;
                L_0x0113:
                    r1 = new com.tencent.mm.storage.f;	 Catch:{ Exception -> 0x00e5 }
                    r1.<init>();	 Catch:{ Exception -> 0x00e5 }
                    r1.b(r0);	 Catch:{ Exception -> 0x00e5 }
                    r2 = new com.qq.wx.voice.embed.recognizer.d;	 Catch:{ Exception -> 0x00e5 }
                    r3 = r1.field_username;	 Catch:{ Exception -> 0x00e5 }
                    r4 = r1.field_nickname;	 Catch:{ Exception -> 0x00e5 }
                    r1 = r1.field_conRemark;	 Catch:{ Exception -> 0x00e5 }
                    r2.<init>(r3, r4, r1);	 Catch:{ Exception -> 0x00e5 }
                    r9.add(r2);	 Catch:{ Exception -> 0x00e5 }
                    r0.moveToNext();	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x010d;
                L_0x012d:
                    r0.close();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "MicroMsg.SubCoreExt";
                    r2 = "init cusor,count:%s,use time:%s";
                    r3 = 2;
                    r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00e5 }
                    r4 = 0;
                    r0 = r0.getCount();	 Catch:{ Exception -> 0x00e5 }
                    r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
                    r3[r4] = r0;	 Catch:{ Exception -> 0x00e5 }
                    r0 = 1;
                    r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r4 = r4 - r10;
                    r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00e5 }
                    r3[r0] = r4;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);	 Catch:{ Exception -> 0x00e5 }
                    r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r0 = com.qq.wx.voice.embed.recognizer.b.a.aGW;	 Catch:{ Exception -> 0x00e5 }
                    r1 = r0.aGV;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r1.d;	 Catch:{ Exception -> 0x00e5 }
                    if (r0 != 0) goto L_0x01ab;
                L_0x015f:
                    r0 = -304; // 0xfffffffffffffed0 float:NaN double:NaN;
                L_0x0161:
                    if (r0 != 0) goto L_0x01c5;
                L_0x0163:
                    r1 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
                    r4 = "hasInitVoiceControlData";
                    r5 = 1;
                    r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r4 = "hasTryToInitVoiceControlData";
                    r5 = 1;
                    r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r1.commit();	 Catch:{ Exception -> 0x00e5 }
                    r1 = r13.fGI;	 Catch:{ Exception -> 0x00e5 }
                    r1.fGG = true;	 Catch:{ Exception -> 0x00e5 }
                L_0x017f:
                    r1 = "MicroMsg.SubCoreExt";
                    r4 = "init ret:%s,use time:%s";
                    r5 = 2;
                    r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00e5 }
                    r6 = 0;
                    r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00e5 }
                    r5[r6] = r0;	 Catch:{ Exception -> 0x00e5 }
                    r0 = 1;
                    r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00e5 }
                    r2 = r8 - r2;
                    r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x00e5 }
                    r5[r0] = r2;	 Catch:{ Exception -> 0x00e5 }
                    com.tencent.mm.sdk.platformtools.v.i(r1, r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r0 = r13.fGI;	 Catch:{ Exception -> 0x00e5 }
                    r0.fGF = true;	 Catch:{ Exception -> 0x00e5 }
                L_0x01a4:
                    r0 = r13.fGI;	 Catch:{ Exception -> 0x00e5 }
                    r0.fGF = true;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x0033;
                L_0x01ab:
                    r0 = r1.e;	 Catch:{ Exception -> 0x00e5 }
                    if (r0 == 0) goto L_0x01b9;
                L_0x01af:
                    r0 = r1.aHc;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r0.update(r9);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 < 0) goto L_0x0161;
                L_0x01b7:
                    r0 = r7;
                    goto L_0x0161;
                L_0x01b9:
                    r0 = r1.aHc;	 Catch:{ Exception -> 0x00e5 }
                    r0 = r0.init(r9);	 Catch:{ Exception -> 0x00e5 }
                    if (r0 < 0) goto L_0x0161;
                L_0x01c1:
                    r0 = 1;
                    r1.e = r0;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x01b7;
                L_0x01c5:
                    r1 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
                    r4 = "hasInitVoiceControlData";
                    r5 = 0;
                    r1 = r1.putBoolean(r4, r5);	 Catch:{ Exception -> 0x00e5 }
                    r1.commit();	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x017f;
                L_0x01d5:
                    r0 = r8.edit();	 Catch:{ Exception -> 0x00e5 }
                    r1 = "hasInitVoiceControlData";
                    r2 = 0;
                    r0 = r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x00e5 }
                    r1 = "hasTryToInitVoiceControlData";
                    r2 = 1;
                    r0 = r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x00e5 }
                    r0.commit();	 Catch:{ Exception -> 0x00e5 }
                    r0 = r13.fGI;	 Catch:{ Exception -> 0x00e5 }
                    r0.fGG = true;	 Catch:{ Exception -> 0x00e5 }
                    goto L_0x01a4;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.b.2.run():void");
                }
            }, 10000);
        }
    }
}
