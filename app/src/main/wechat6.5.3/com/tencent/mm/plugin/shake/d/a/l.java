package com.tencent.mm.plugin.shake.d.a;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.j;
import com.tencent.mm.plugin.shake.b.j.b;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.plugin.shake.d.a.m.d;
import com.tencent.mm.plugin.shake.d.a.m.e;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.aul;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class l extends b {
    private static boolean aHp = false;
    private static boolean hqt = false;
    private boolean aWE = false;
    private Context context;
    private a iQq = new a();
    private long iQs;

    static /* synthetic */ boolean a(l lVar, String str) {
        List arrayList = new ArrayList();
        d zv = d.zv(str);
        if (zv == null || zv.cZp == null) {
            v.w("Micromsg.ShakeTVService", "parse url fail");
            lVar.e(arrayList, 4);
            return false;
        }
        v.d("Micromsg.ShakeTVService", "parse url: link=" + zv.cZp + ", title=" + zv.title + ", thumburl=" + zv.bea);
        com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
        dVar.field_username = zv.cZp;
        dVar.field_nickname = zv.title;
        dVar.field_distance = zv.bkp;
        dVar.field_sns_bgurl = zv.bea;
        dVar.field_type = 7;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        k.aNO().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean b(l lVar, String str) {
        e zw = e.zw(str);
        List arrayList = new ArrayList();
        if (zw == null || zw.userName == null) {
            v.w("Micromsg.ShakeTVService", "parse user fail");
            lVar.e(arrayList, 4);
            return false;
        }
        v.d("Micromsg.ShakeTVService", "parse user: username=" + zw.userName + ", nickname=" + zw.aGX + ", showchat=" + zw.iQy);
        com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
        dVar.field_username = zw.userName;
        dVar.field_nickname = zw.aGX;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = zw.iQy;
        k.aNO().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean c(l lVar, String str) {
        boolean z = true;
        List arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            String str2 = "Micromsg.ShakeTVService";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.e(str2, str3, objArr);
            lVar.e(arrayList, 2);
            return false;
        }
        a zy = c.zy(str);
        if (zy == null) {
            v.e("Micromsg.ShakeTVService", "shakeTV resCallback xml error");
            aHp = false;
            lVar.e(arrayList, 4);
            return false;
        }
        com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
        dVar.field_username = be.ma(zy.field_subtitle);
        dVar.field_nickname = be.ma(zy.field_topic);
        dVar.field_distance = be.ma(zy.field_title);
        if (zy.field_thumburl != null) {
            dVar.field_sns_bgurl = zy.field_thumburl;
        }
        dVar.field_type = 8;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        dVar.field_reserved2 = (int) be.Nh();
        arrayList.add(dVar);
        com.tencent.mm.plugin.shake.b.d aNE = k.aNO().aNE();
        if (aNE.field_type == 8 && dVar.field_distance.equals(aNE.field_distance) && dVar.field_nickname.equals(aNE.field_nickname) && dVar.field_reserved2 - aNE.field_reserved2 < 1800) {
            v.d("Micromsg.ShakeTVService", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + aNE.field_reserved2);
            k.aNO().pl(aNE.field_shakeItemID);
        }
        k.aNO().a(dVar, true);
        lVar.e(arrayList, 1);
        v.d("Micromsg.ShakeTVService", "process get tv OK");
        return true;
    }

    static /* synthetic */ boolean d(l lVar, String str) {
        List arrayList = new ArrayList();
        m.a zs = m.a.zs(str);
        if (zs == null || zs.iQw == null) {
            v.w("Micromsg.ShakeTVService", "parse pay fail");
            lVar.e(arrayList, 4);
            return false;
        }
        v.d("Micromsg.ShakeTVService", "parese pay: wx_pay_url=" + zs.iQw + ", title=" + zs.title + ", thumbUrl=" + zs.bea);
        com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
        dVar.field_username = zs.iQw;
        dVar.field_nickname = zs.title;
        dVar.field_sns_bgurl = zs.bea;
        dVar.field_distance = zs.hOv;
        dVar.field_type = 9;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        k.aNO().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean e(l lVar, String str) {
        List arrayList = new ArrayList();
        m.b zt = m.b.zt(str);
        if (zt == null || zt.id == null) {
            v.w("Micromsg.ShakeTVService", "parse product fail");
            lVar.e(arrayList, 4);
            return false;
        }
        v.d("Micromsg.ShakeTVService", "parese pruduct: product_id=" + zt.id + ", title=" + zt.title + ", thumbUrl=" + zt.bea);
        com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
        dVar.field_username = zt.id;
        dVar.field_nickname = zt.title;
        dVar.field_sns_bgurl = zt.bea;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        k.aNO().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean f(l lVar, String str) {
        List arrayList = new ArrayList();
        m.c zu = m.c.zu(str);
        if (zu == null || be.kS(zu.iQx)) {
            v.w("Micromsg.ShakeTVService", "parse product fail");
            lVar.e(arrayList, 4);
            return false;
        }
        com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
        dVar.field_username = zu.iQx;
        dVar.field_nickname = zu.title;
        dVar.field_distance = zu.username;
        dVar.field_sns_bgurl = zu.bea;
        dVar.field_type = 12;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        k.aNO().a(dVar, true);
        arrayList.add(dVar);
        lVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ void zr(String str) {
        n nVar;
        String[] strArr = null;
        if (be.kS(str)) {
            nVar = null;
        } else {
            n nVar2;
            Map q = bf.q(str, "tvinfo");
            if (q != null) {
                String str2 = (String) q.get(".tvinfo.username");
                if (be.kS(str2)) {
                    nVar = null;
                } else {
                    n nVar3 = new n();
                    nVar3.field_username = str2;
                    nVar3.field_iconurl = be.ma((String) q.get(".tvinfo.iconurl"));
                    nVar3.field_title = be.ma((String) q.get(".tvinfo.title"));
                    nVar3.field_deeplink = be.ma((String) q.get(".tvinfo.deeplinkjumpurl"));
                    nVar3.field_createtime = be.getLong((String) q.get(".tvinfo.createtime"), 0);
                    nVar2 = nVar3;
                }
            } else {
                nVar2 = null;
            }
            nVar = nVar2;
        }
        if (nVar != null) {
            o aNQ = k.aNQ();
            Cursor query = aNQ.cie.query("shaketvhistory", null, "username=?", new String[]{nVar.field_username}, null, null, null);
            if (query.getCount() <= 0) {
                v.i("MicroMsg.ShakeTvHistoryStorage", "get null with username:" + r9);
                query.close();
            } else {
                query.moveToFirst();
                strArr = new n();
                strArr.b(query);
                query.close();
            }
            if (strArr != null) {
                v.i("Micromsg.ShakeTVService", "processShakeTvHistory upate");
                aNQ = k.aNQ();
                if (be.kS(nVar.field_username)) {
                    v.w("MicroMsg.ShakeTvHistoryStorage", "update fail username null");
                    return;
                }
                aNQ.cie.update("shaketvhistory", nVar.py(), "username=?", new String[]{nVar.field_username});
                return;
            }
            v.i("Micromsg.ShakeTVService", "processShakeTvHistory new insert");
            k.aNQ().b(nVar);
        }
    }

    public l(Context context, j.a aVar) {
        super(aVar);
        this.context = context;
        aHp = false;
    }

    public final void start() {
        if (this.iOn == null) {
            v.w("Micromsg.ShakeTVService", "shakeGetListener == null");
        } else if (this.context instanceof Activity) {
            aHp = true;
            this.iQs = System.currentTimeMillis();
            this.iQq.a(408, new a.a(this) {
                final /* synthetic */ l iQv;

                {
                    this.iQv = r1;
                }

                public final void a(aqx com_tencent_mm_protocal_c_aqx, long j, boolean z) {
                    long currentTimeMillis;
                    if (j > this.iQv.iQs) {
                        currentTimeMillis = System.currentTimeMillis() - j;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - this.iQv.iQs;
                    }
                    if (com_tencent_mm_protocal_c_aqx != null && !be.kS(((aul) com_tencent_mm_protocal_c_aqx).mii)) {
                        boolean a;
                        aul com_tencent_mm_protocal_c_aul = (aul) com_tencent_mm_protocal_c_aqx;
                        v.w("Micromsg.ShakeTVService", "resCallback Type:%d, xml:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aul.efm), com_tencent_mm_protocal_c_aul.mii});
                        String str = null;
                        String str2 = null;
                        if (com_tencent_mm_protocal_c_aul.mii != null) {
                            com_tencent_mm_protocal_c_aul.mii = com_tencent_mm_protocal_c_aul.mii.trim();
                            int indexOf = com_tencent_mm_protocal_c_aul.mii.indexOf("<tvinfo>");
                            if (indexOf > 0) {
                                str = com_tencent_mm_protocal_c_aul.mii.substring(0, indexOf);
                                str2 = com_tencent_mm_protocal_c_aul.mii.substring(indexOf);
                            } else if (indexOf == 0) {
                                str2 = com_tencent_mm_protocal_c_aul.mii;
                            } else {
                                str = com_tencent_mm_protocal_c_aul.mii;
                            }
                        }
                        l.zr(str2);
                        switch (com_tencent_mm_protocal_c_aul.efm) {
                            case 0:
                                a = l.a(this.iQv, str);
                                break;
                            case 1:
                                a = l.b(this.iQv, str);
                                break;
                            case 2:
                                a = l.c(this.iQv, str);
                                break;
                            case 3:
                                a = l.d(this.iQv, str);
                                break;
                            case 4:
                                a = l.e(this.iQv, str);
                                break;
                            case 5:
                                a = l.f(this.iQv, str);
                                break;
                            default:
                                v.w("Micromsg.ShakeTVService", "parse unknown type:" + com_tencent_mm_protocal_c_aul.efm);
                                this.iQv.e(new ArrayList(), 4);
                                a = false;
                                break;
                        }
                        if (a) {
                            g.iuh.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - this.iQv.iQs))});
                        } else {
                            g.iuh.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis)});
                        }
                    } else if (z) {
                        this.iQv.e(new ArrayList(), 4);
                        g.iuh.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis)});
                    } else {
                        this.iQv.e(new ArrayList(), 4);
                        g.iuh.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis)});
                    }
                    l.aHp = false;
                }
            });
        } else {
            v.e("Micromsg.ShakeTVService", "context not an Activity");
            this.iOn.d(new ArrayList(), 0);
        }
    }

    public final void init() {
        if (!hqt) {
            if (this.iQq.aOo()) {
                hqt = true;
            } else {
                v.e("Micromsg.ShakeTVService", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void aNB() {
        super.aNB();
        this.iQq.pb();
        if (aHp) {
            long currentTimeMillis = System.currentTimeMillis() - this.iQs;
            v.d("Micromsg.ShakeTVService", "destroyShakeMgr, costTime=%s, isRunning=%s", new Object[]{Long.valueOf(currentTimeMillis), Boolean.valueOf(aHp)});
            g.iuh.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(2), Integer.valueOf((int) currentTimeMillis)});
            aHp = false;
        }
    }

    public final void resume() {
    }

    private void e(List<com.tencent.mm.plugin.shake.b.d> list, long j) {
        if (this.iOn != null) {
            this.iOn.d(list, j);
        }
    }
}
