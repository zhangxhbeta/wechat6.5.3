package com.tencent.mm.model;

import com.tencent.mm.a.o;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.b.c;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.protocal.c.aju;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.protocal.c.ih;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.z.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class aj {
    private static final a csf = new a();

    private static final class a extends com.tencent.mm.av.a<com.tencent.mm.plugin.b.a.a> implements com.tencent.mm.plugin.b.a.a {
        private a() {
        }

        public final void a(final f fVar, final baq com_tencent_mm_protocal_c_baq, final boolean z) {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.plugin.b.a.a>(this) {
                final /* synthetic */ a csj;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.plugin.b.a.a) obj).a(fVar, com_tencent_mm_protocal_c_baq, z);
                }
            });
        }

        public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
            final b bVar2 = bVar;
            final String str4 = str;
            final int i3 = i;
            final String str5 = str2;
            final String str6 = str3;
            final int i4 = i2;
            a(new com.tencent.mm.av.a.a<com.tencent.mm.plugin.b.a.a>(this) {
                final /* synthetic */ a csj;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.plugin.b.a.a) obj).a(bVar2, str4, i3, str5, str6, i4);
                }
            });
        }

        public final void a(final ih ihVar, final ih ihVar2, final ih ihVar3) {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.plugin.b.a.a>(this) {
                final /* synthetic */ a csj;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.plugin.b.a.a) obj).a(ihVar, ihVar2, ihVar3);
                }
            });
        }

        public final void a(final d dVar, final e eVar) {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.plugin.b.a.a>(this) {
                final /* synthetic */ a csj;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.plugin.b.a.a) obj).a(dVar, eVar);
                }
            });
        }

        public final void a(final f fVar, final g gVar) {
            a(new com.tencent.mm.av.a.a<com.tencent.mm.plugin.b.a.a>(this) {
                final /* synthetic */ a csj;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.plugin.b.a.a) obj).a(fVar, gVar);
                }
            });
        }
    }

    public static void a(ih ihVar, ih ihVar2, ih ihVar3) {
        csf.a(ihVar, ihVar2, ihVar3);
    }

    public static void a(f fVar, baq com_tencent_mm_protocal_c_baq, boolean z) {
        int i;
        int i2 = com_tencent_mm_protocal_c_baq.mXe;
        String str = "MicroMsg.MMAuthHandleChain";
        String str2 = "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b";
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_baq.mXf == null ? -1 : com_tencent_mm_protocal_c_baq.mXf.mei);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = com_tencent_mm_protocal_c_baq.mXf;
        objArr[3] = com_tencent_mm_protocal_c_baq.mXg;
        objArr[4] = com_tencent_mm_protocal_c_baq.mXh;
        objArr[5] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        int i3 = 0;
        if ((i2 & 1) != 0) {
            i3 = com_tencent_mm_protocal_c_baq.mXf.fvo;
        } else {
            v.w("MicroMsg.MMAuthHandleChain", "summerauth updateProfile authsect not set and new uin is 0!");
        }
        com.tencent.mm.kernel.e.a(com.tencent.mm.kernel.g.vw().cjT, i3);
        com.tencent.mm.kernel.a.ey(i3);
        r vf = com.tencent.mm.kernel.g.vw().vf();
        vf.set(FileUtils.S_IRUSR, Boolean.valueOf(false));
        if ((i2 & 1) != 0) {
            if (com_tencent_mm_protocal_c_baq.mXf.mei > 0) {
                vf.a(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf((long) com_tencent_mm_protocal_c_baq.mXf.mei));
                vf.a(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_TIME_LONG, Long.valueOf(be.Nh()));
                vf.a(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf((long) com.tencent.mm.protocal.d.lWh));
                v.i("MicroMsg.MMAuthHandleChain", "summerauth updateProfile need update flag[%d], autoauth[%b]", Integer.valueOf(com_tencent_mm_protocal_c_baq.mXf.mei), Boolean.valueOf(z));
                if (z) {
                    com.tencent.mm.plugin.report.b.itm.a(148, com_tencent_mm_protocal_c_baq.mXf.mei == 2 ? 19 : 41, 1, true);
                } else {
                    com.tencent.mm.plugin.report.b.itm.a(148, com_tencent_mm_protocal_c_baq.mXf.mei == 2 ? 10 : 11, 1, true);
                }
            } else {
                vf.a(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf((long) com_tencent_mm_protocal_c_baq.mXf.mei));
                vf.a(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_TIME_LONG, Long.valueOf(be.Nh()));
                vf.a(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf(0));
            }
        }
        if ((i2 & 2) != 0) {
            ai aiVar = com_tencent_mm_protocal_c_baq.mXg;
            v.i("MicroMsg.MMAuthHandleChain", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", o.getString(aiVar.mar), Integer.valueOf(aiVar.eeO), aiVar.gln, aiVar.efy, aiVar.mas, aiVar.mat, aiVar.cHh, Integer.valueOf(aiVar.mau), Integer.valueOf(aiVar.mav), aiVar.maw, Integer.valueOf(aiVar.may), aiVar.maz, aiVar.maz, Integer.valueOf(aiVar.maB), aiVar.maC);
            if (!z) {
                vf.set(52, Integer.valueOf(aiVar.mav));
            }
            vf.set(9, Integer.valueOf(aiVar.mar));
            vf.set(7, Integer.valueOf(aiVar.eeO));
            vf.set(2, aiVar.gln);
            vf.set(4, aiVar.efy);
            vf.set(5, aiVar.mas);
            vf.set(6, aiVar.mat);
            vf.set(42, aiVar.cHh);
            vf.set(34, Integer.valueOf(aiVar.mau));
            com.tencent.mm.kernel.g.vw().vg().Nt(aiVar.maw);
            vf.set(64, Integer.valueOf(aiVar.may));
            vf.set(21, aiVar.maz);
            vf.set(22, aiVar.maz);
            vf.set(17, Integer.valueOf(aiVar.maB));
            ai.cse.J("login_weixin_username", aiVar.gln);
            ai.cse.c(aiVar.mat, aiVar.mar, aiVar.mas);
        } else {
            v.w("MicroMsg.MMAuthHandleChain", "summerauth updateProfile acctsect not set!");
        }
        boolean z2 = false;
        if ((i2 & 1) != 0) {
            boolean a;
            com.tencent.mm.network.e eVar;
            dl dlVar = com_tencent_mm_protocal_c_baq.mXf;
            String str3 = dlVar.mec;
            String bn = be.bn(m.a(dlVar.med));
            v.i("MicroMsg.MMAuthHandleChain", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", dlVar.meg, Integer.valueOf(dlVar.meh), Integer.valueOf(dlVar.mei), Integer.valueOf(dlVar.mej), be.KW(str3), be.KW(bn), dlVar.maC);
            int i4 = dlVar.mdW;
            o oVar = new o(be.f((Integer) vf.get(9, Integer.valueOf(0))));
            str = "MicroMsg.MMAuthHandleChain";
            str2 = "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(i4);
            objArr[1] = oVar;
            objArr[2] = Integer.valueOf(dlVar.mdX == null ? -1 : dlVar.mdX.mQu);
            v.i(str, str2, objArr);
            if (i4 != 0) {
                if (i4 == 1) {
                    com.tencent.mm.plugin.report.b.itm.a(148, 20, 1, false);
                    a = com.tencent.mm.kernel.g.vu().cjh.a(oVar.longValue(), m.a(dlVar.mdX));
                    v.i("MicroMsg.MMAuthHandleChain", "WTLoginRspBuff len %s", Integer.valueOf(r5.length));
                    str = be.bn(com.tencent.mm.kernel.g.vu().cjh.R(oVar.longValue()));
                    vf.set(-1535680990, str3);
                    vf.set(46, bn);
                    vf.set(72, str);
                    vf.set(29, dlVar.maC);
                } else if (i4 == 2) {
                    com.tencent.mm.plugin.report.b.itm.a(148, 21, 1, false);
                    com.tencent.mm.kernel.g.vu().cjh.S(oVar.longValue());
                    String bn2 = be.bn(com.tencent.mm.kernel.g.vu().cjh.R(oVar.longValue()));
                    vf.set(-1535680990, str3);
                    vf.set(46, bn);
                    vf.set(72, bn2);
                    vf.set(29, dlVar.maC);
                    a = false;
                } else {
                    v.i("MicroMsg.MMAuthHandleChain", "summerauth undefined wrBuffFlag[%d]", Integer.valueOf(i4));
                }
                v.i("MicroMsg.MMAuthHandleChain", "wtBuffFlag %s", Integer.valueOf(i4));
                if (dlVar.mdY != null) {
                    str = be.bn(m.a(dlVar.mdY.mgX));
                    if (str != null && str.length() > 0) {
                        vf.set(47, str);
                        com.tencent.mm.kernel.g.vw().cjT.set(18, str);
                    }
                    v.i("MicroMsg.MMAuthHandleChain", "updateProfile ksid:%s", be.KW(str));
                }
                i = dlVar.mek;
                v.i("MicroMsg.MMAuthHandleChain", "summerauth mmtls:%d", Integer.valueOf(i));
                com.tencent.mm.kernel.g.vw().cjT.set(47, Integer.valueOf(i));
                eVar = com.tencent.mm.kernel.g.vv().cjC.cAa;
                if (eVar != null) {
                    eVar.aW((i & 1) != 0);
                }
                z2 = a;
            }
            a = false;
            v.i("MicroMsg.MMAuthHandleChain", "wtBuffFlag %s", Integer.valueOf(i4));
            if (dlVar.mdY != null) {
                str = be.bn(m.a(dlVar.mdY.mgX));
                vf.set(47, str);
                com.tencent.mm.kernel.g.vw().cjT.set(18, str);
                v.i("MicroMsg.MMAuthHandleChain", "updateProfile ksid:%s", be.KW(str));
            }
            i = dlVar.mek;
            v.i("MicroMsg.MMAuthHandleChain", "summerauth mmtls:%d", Integer.valueOf(i));
            com.tencent.mm.kernel.g.vw().cjT.set(47, Integer.valueOf(i));
            eVar = com.tencent.mm.kernel.g.vv().cjC.cAa;
            if (eVar != null) {
                if ((i & 1) != 0) {
                }
                eVar.aW((i & 1) != 0);
            }
            z2 = a;
        } else {
            v.w("MicroMsg.MMAuthHandleChain", "summerauth updateProfile authsect not set!");
            com.tencent.mm.plugin.report.b.itm.a(148, 22, 1, false);
        }
        if ((i2 & 4) != 0) {
            com.tencent.mm.plugin.report.b.itm.a(148, 23, 1, false);
            aju com_tencent_mm_protocal_c_aju = com_tencent_mm_protocal_c_baq.mXh;
            al.a(false, com_tencent_mm_protocal_c_aju.mgK, com_tencent_mm_protocal_c_aju.mgL, com_tencent_mm_protocal_c_aju.mgJ);
        } else {
            v.w("MicroMsg.MMAuthHandleChain", "summerauth updateProfile networksect not set!");
        }
        if (z) {
            i = 4;
            bn2 = k.xF();
            if (z2) {
                i = 1;
                bn2 = k.xE();
            }
            v.i("MicroMsg.MMAuthHandleChain", "loginType %s", Integer.valueOf(i));
            c.j(1, i, bn2);
        }
        vf.set(3, SQLiteDatabase.KeyEmpty);
        vf.set(19, SQLiteDatabase.KeyEmpty);
        vf.iB(true);
        com.tencent.mm.kernel.g.vw().cjT.setInt(46, 0);
        a.wv();
        csf.a(fVar, com_tencent_mm_protocal_c_baq, z);
    }

    public static void a(b bVar, String str, int i, String str2, String str3) {
        if (!com.tencent.mm.kernel.g.uz() || com.tencent.mm.kernel.g.vu().uin == 0 || com.tencent.mm.kernel.g.vw().vf() == null) {
            v.e("MicroMsg.MMAuthHandleChain", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", Boolean.valueOf(com.tencent.mm.kernel.g.uz()), o.getString(com.tencent.mm.kernel.g.vu().uin), com.tencent.mm.kernel.g.vw().vf());
            return;
        }
        String str4 = bVar.lXv.gln;
        String str5 = bVar.lXv.mas;
        int i2 = bVar.lXv.eeO;
        String str6 = bVar.lXv.maz;
        String str7 = bVar.lXv.maA;
        int i3 = bVar.lXv.maB;
        int i4 = bVar.lXv.mKR;
        String str8 = bVar.lXv.lZp;
        String str9 = bVar.lXv.maC;
        String str10 = bVar.lXv.mec;
        String str11 = bVar.lXv.mKQ;
        v.i("MicroMsg.MMAuthHandleChain", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", str4, str, o.getString(i), str2, str5, str3, Integer.valueOf(i2), str6, str7, Integer.valueOf(i3), Integer.valueOf(i4), be.KW(str8), str9, Integer.valueOf(0), be.KW(str10), be.KW(null), be.KW(null), be.KW(null), Integer.valueOf(-1), str11, Integer.valueOf(0));
        r vf = com.tencent.mm.kernel.g.vw().vf();
        ai.cse.J("login_weixin_username", str4);
        ai.cse.c(str3, i, str5);
        vf.set(2, str4);
        vf.set(42, str);
        vf.set(9, Integer.valueOf(i));
        vf.set(4, str2);
        vf.set(5, str5);
        vf.set(6, str3);
        vf.set(7, Integer.valueOf(i2));
        vf.set(21, str6);
        vf.set(22, str7);
        vf.set(57, Integer.valueOf(0));
        vf.set(17, Integer.valueOf(i3));
        vf.set(25, Integer.valueOf(i4));
        vf.set(1, str8);
        vf.set(29, str9);
        vf.set(34, Integer.valueOf(0));
        vf.set(FileUtils.S_IRUSR, Boolean.valueOf(false));
        v.i("MicroMsg.MMAuthHandleChain", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
        vf.set(-1535680990, str10);
        vf.set(46, null);
        vf.set(72, null);
        vf.set(64, Integer.valueOf(-1));
        vf.iB(true);
        csf.a(bVar, str, i, str2, str3, 0);
    }

    public static void a(d dVar, e eVar) {
        csf.a(dVar, eVar);
    }

    public static void a(f fVar, g gVar) {
        csf.a(fVar, gVar);
    }

    public static com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.b.a.a aVar) {
        return csf.ay(aVar);
    }
}
