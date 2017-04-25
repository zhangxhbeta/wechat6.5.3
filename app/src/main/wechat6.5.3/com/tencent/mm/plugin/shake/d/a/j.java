package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.j.b;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.plugin.shake.d.a.m.d;
import com.tencent.mm.plugin.shake.d.a.m.e;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.auh;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends b {
    public static boolean hqt = false;
    public static j iQr;
    private boolean aWE = false;
    public a iQq = new a();
    private long iQs;

    static /* synthetic */ boolean a(j jVar, String str) {
        List arrayList = new ArrayList();
        d zv = d.zv(str);
        if (zv == null || zv.cZp == null) {
            v.w("Micromsg.ShakeMusicMgr", "parse url fail");
            jVar.e(arrayList, 4);
            return false;
        }
        v.d("Micromsg.ShakeMusicMgr", "parse url: link=" + zv.cZp + ", title=" + zv.title + ", thumburl=" + zv.bea);
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
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean b(j jVar, String str) {
        e zw = e.zw(str);
        List arrayList = new ArrayList();
        if (zw == null || zw.userName == null) {
            v.w("Micromsg.ShakeMusicMgr", "parse user fail");
            jVar.e(arrayList, 4);
            return false;
        }
        v.d("Micromsg.ShakeMusicMgr", "parse user: username=" + zw.userName + ", nickname=" + zw.aGX + ", showchat=" + zw.iQy);
        com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
        dVar.field_username = zw.userName;
        dVar.field_nickname = zw.aGX;
        dVar.field_type = 6;
        dVar.field_insertBatch = 1;
        dVar.field_distance = zw.iQy;
        k.aNO().a(dVar, true);
        arrayList.add(dVar);
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean c(j jVar, String str) {
        boolean z = true;
        List arrayList = new ArrayList();
        if (str == null || !str.startsWith("<tv")) {
            String str2 = "Micromsg.ShakeMusicMgr";
            String str3 = "wrong args, xml == null ? [%s]";
            Object[] objArr = new Object[1];
            if (str != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.e(str2, str3, objArr);
            jVar.e(arrayList, 2);
            return false;
        }
        a zy = c.zy(str);
        if (zy == null) {
            v.e("Micromsg.ShakeMusicMgr", "shakeTV resCallback xml error");
            jVar.e(arrayList, 4);
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
            v.d("Micromsg.ShakeMusicMgr", "Del the old tv item history, curTime=" + dVar.field_reserved2 + ", oldOneCreatedTime=" + aNE.field_reserved2);
            k.aNO().pl(aNE.field_shakeItemID);
        }
        k.aNO().a(dVar, true);
        jVar.e(arrayList, 1);
        v.d("Micromsg.ShakeMusicMgr", "process get tv OK");
        return true;
    }

    static /* synthetic */ boolean d(j jVar, String str) {
        List arrayList = new ArrayList();
        m.a zs = m.a.zs(str);
        if (zs == null || zs.iQw == null) {
            v.w("Micromsg.ShakeMusicMgr", "parse pay fail");
            jVar.e(arrayList, 4);
            return false;
        }
        v.d("Micromsg.ShakeMusicMgr", "parese pay: wx_pay_url=" + zs.iQw + ", title=" + zs.title + ", thumbUrl=" + zs.bea);
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
        jVar.e(arrayList, 1);
        return true;
    }

    static /* synthetic */ boolean e(j jVar, String str) {
        List arrayList = new ArrayList();
        m.b zt = m.b.zt(str);
        if (zt == null || zt.id == null) {
            v.w("Micromsg.ShakeMusicMgr", "parse product fail");
            jVar.e(arrayList, 4);
            return false;
        }
        v.d("Micromsg.ShakeMusicMgr", "parese pruduct: product_id=" + zt.id + ", title=" + zt.title + ", thumbUrl=" + zt.bea);
        com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
        dVar.field_username = zt.id;
        dVar.field_nickname = zt.title;
        dVar.field_sns_bgurl = zt.bea;
        dVar.field_type = 10;
        dVar.field_insertBatch = 1;
        dVar.field_lvbuffer = str.getBytes();
        k.aNO().a(dVar, true);
        arrayList.add(dVar);
        jVar.e(arrayList, 1);
        return true;
    }

    public static j a(com.tencent.mm.plugin.shake.b.j.a aVar) {
        if (iQr == null || iQr.iOn == null) {
            iQr = new j(aVar);
        }
        return iQr;
    }

    private j(com.tencent.mm.plugin.shake.b.j.a aVar) {
        super(aVar);
    }

    public final void start() {
        if (this.iOn == null) {
            v.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            return;
        }
        this.iQs = System.currentTimeMillis();
        this.iQq.a(367, new a.a(this) {
            final /* synthetic */ j iQt;

            {
                this.iQt = r1;
            }

            public final void a(aqx com_tencent_mm_protocal_c_aqx, long j, boolean z) {
                if (this.iQt.iOn == null) {
                    v.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
                    return;
                }
                auh com_tencent_mm_protocal_c_auh = (auh) com_tencent_mm_protocal_c_aqx;
                if (com_tencent_mm_protocal_c_auh == null) {
                    v.w("Micromsg.ShakeMusicMgr", "resp null & return");
                    this.iQt.e(new ArrayList(), 4);
                } else if (com_tencent_mm_protocal_c_auh.mRX == 1) {
                    long currentTimeMillis;
                    if (j > this.iQt.iQs) {
                        currentTimeMillis = System.currentTimeMillis() - j;
                    } else {
                        currentTimeMillis = System.currentTimeMillis() - this.iQt.iQs;
                    }
                    if (com_tencent_mm_protocal_c_auh != null && !be.kS(com_tencent_mm_protocal_c_auh.mRZ)) {
                        boolean a;
                        v.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_auh.mRY), com_tencent_mm_protocal_c_auh.mRZ});
                        String str = com_tencent_mm_protocal_c_auh.mRZ;
                        if (str != null) {
                            str = str.trim();
                        }
                        switch (com_tencent_mm_protocal_c_auh.mRY) {
                            case 0:
                                a = j.a(this.iQt, str);
                                break;
                            case 1:
                                a = j.b(this.iQt, str);
                                break;
                            case 2:
                                a = j.c(this.iQt, str);
                                break;
                            case 3:
                                a = j.d(this.iQt, str);
                                break;
                            case 4:
                                a = j.e(this.iQt, str);
                                break;
                            default:
                                v.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + com_tencent_mm_protocal_c_auh.mRY);
                                this.iQt.e(new ArrayList(), 4);
                                a = false;
                                break;
                        }
                        if (a) {
                            g.iuh.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - this.iQt.iQs))});
                            return;
                        }
                        g.iuh.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis)});
                    } else if (z) {
                        this.iQt.e(new ArrayList(), 4);
                        g.iuh.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis)});
                    } else {
                        this.iQt.e(new ArrayList(), 4);
                        g.iuh.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis)});
                    }
                } else {
                    List arrayList = new ArrayList();
                    if (com_tencent_mm_protocal_c_auh != null) {
                        com.tencent.mm.plugin.shake.b.d dVar = new com.tencent.mm.plugin.shake.b.d();
                        if (!(com_tencent_mm_protocal_c_auh.mRT == null || com_tencent_mm_protocal_c_auh.mRT.mQw == null)) {
                            dVar.field_username = com_tencent_mm_protocal_c_auh.mRT.mQw.brp();
                        }
                        if (!(com_tencent_mm_protocal_c_auh.mRS == null || com_tencent_mm_protocal_c_auh.mRS.mQw == null)) {
                            dVar.field_nickname = com_tencent_mm_protocal_c_auh.mRS.mQw.brp();
                        }
                        if (!(com_tencent_mm_protocal_c_auh.mRT == null || com_tencent_mm_protocal_c_auh.mRT.mQw == null)) {
                            dVar.field_distance = com_tencent_mm_protocal_c_auh.mRT.mQw.brp();
                        }
                        if (!(com_tencent_mm_protocal_c_auh.mAo == null || com_tencent_mm_protocal_c_auh.mAo.mQw == null)) {
                            dVar.field_sns_bgurl = com_tencent_mm_protocal_c_auh.mAo.mQw.brp();
                        }
                        dVar.field_type = 4;
                        dVar.field_insertBatch = 1;
                        try {
                            dVar.field_lvbuffer = com_tencent_mm_protocal_c_auh.toByteArray();
                        } catch (IOException e) {
                            v.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[]{e.getLocalizedMessage()});
                        }
                        k.aNO().a(dVar, true);
                        arrayList.add(dVar);
                    }
                    this.iQt.iOn.d(arrayList, j);
                }
            }
        });
    }

    public final void init() {
        if (!hqt) {
            if (this.iQq.aOo()) {
                hqt = true;
            } else {
                v.e("Micromsg.ShakeMusicMgr", "init MusicFingerPrintRecorder false");
            }
        }
    }

    public final void reset() {
    }

    public final void pause() {
    }

    public final void aNB() {
        this.iQq.pb();
        super.aNB();
    }

    public final void resume() {
    }

    private void e(List<com.tencent.mm.plugin.shake.b.d> list, long j) {
        if (this.iOn != null) {
            this.iOn.d(list, j);
        }
    }
}
