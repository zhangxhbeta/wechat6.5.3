package com.tencent.mm.plugin.f.a;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.bf;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.plugin.f.a.a.i;
import com.tencent.mm.plugin.f.a.a.j;
import com.tencent.mm.protocal.c.ajj;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.FileUtils;

public final class g implements i {
    private static final b hlc = new b();

    public interface a {
        void a(ajj com_tencent_mm_protocal_c_ajj);
    }

    private static final class b extends com.tencent.mm.av.a<a> implements a {
        private b() {
        }

        public final void a(final ajj com_tencent_mm_protocal_c_ajj) {
            a(new com.tencent.mm.av.a.a<a>(this) {
                final /* synthetic */ b hle;

                public final /* synthetic */ void an(Object obj) {
                    ((a) obj).a(com_tencent_mm_protocal_c_ajj);
                }
            });
        }
    }

    public static com.tencent.mm.vending.b.b a(a aVar) {
        return hlc.ay(aVar);
    }

    public final void a(kz kzVar, byte[] bArr, boolean z, j jVar) {
        switch (kzVar.bkM) {
            case 1:
                u uVar;
                ajj com_tencent_mm_protocal_c_ajj = (ajj) new ajj().az(bArr);
                int i = com_tencent_mm_protocal_c_ajj.mJH;
                com.tencent.mm.kernel.g.vw().vf().get(2, null);
                r vf = com.tencent.mm.kernel.g.vw().vf();
                v.i("MicroMsg.UserInfoSyncExtension", "processModUserInfo bitFlag:%d status:%d PluginFlag:%d PluginSwitch:%d", Integer.valueOf(com_tencent_mm_protocal_c_ajj.mJH), Integer.valueOf(com_tencent_mm_protocal_c_ajj.eeO), Integer.valueOf(com_tencent_mm_protocal_c_ajj.mau), Integer.valueOf(com_tencent_mm_protocal_c_ajj.mJO));
                String a = m.a(com_tencent_mm_protocal_c_ajj.moM);
                String a2 = m.a(com_tencent_mm_protocal_c_ajj.mEj);
                String a3 = m.a(com_tencent_mm_protocal_c_ajj.mJI);
                String a4 = m.a(com_tencent_mm_protocal_c_ajj.mJJ);
                int i2 = com_tencent_mm_protocal_c_ajj.mar;
                ab LX = ((d) com.tencent.mm.kernel.g.f(d.class)).wH().LX(a);
                if (LX == null || LX.field_username == null || !LX.field_username.equals(a)) {
                    uVar = new u(a);
                } else {
                    ab abVar = LX;
                }
                uVar.bP(com_tencent_mm_protocal_c_ajj.cHh);
                uVar.bS(a2);
                uVar.cl(RegionCodeDecoder.Y(com_tencent_mm_protocal_c_ajj.cHl, com_tencent_mm_protocal_c_ajj.cHd, com_tencent_mm_protocal_c_ajj.cHe));
                uVar.cV(com_tencent_mm_protocal_c_ajj.cHc);
                uVar.cf(com_tencent_mm_protocal_c_ajj.cHf);
                uVar.cQ(com_tencent_mm_protocal_c_ajj.mFy);
                uVar.cj(com_tencent_mm_protocal_c_ajj.mFw);
                uVar.bV(com_tencent_mm_protocal_c_ajj.mFx);
                uVar.cW(i2);
                ((d) com.tencent.mm.kernel.g.f(d.class)).wH().M(uVar);
                vf.set(2, a);
                vf.set(4, a2);
                vf.set(5, a3);
                vf.set(6, a4);
                vf.set(9, Integer.valueOf(i2));
                String str = "MicroMsg.UserInfoSyncExtension";
                StringBuilder stringBuilder = new StringBuilder("doCmd : status ");
                int i3 = com_tencent_mm_protocal_c_ajj.eeO;
                String str2 = "code=" + Integer.toHexString(i3) + ", status = " + i3;
                if ((i3 & 1) != 0) {
                    str2 = str2 + ", open";
                }
                if ((i3 & 2) != 0) {
                    str2 = str2 + ", email-verified";
                }
                if ((i3 & 4) != 0) {
                    str2 = str2 + ", mobile-verified";
                }
                if ((i3 & 8) != 0) {
                    str2 = str2 + ", hide-qq-search";
                }
                if ((i3 & 16) != 0) {
                    str2 = str2 + ", hide-qq-promote";
                }
                if ((i3 & 32) != 0) {
                    str2 = str2 + ", need-verify";
                }
                if ((i3 & 64) != 0) {
                    str2 = str2 + ", has-qq-msg";
                }
                if ((i3 & FileUtils.S_IWUSR) != 0) {
                    str2 = str2 + ", no-qq-promote";
                }
                if ((i3 & FileUtils.S_IRUSR) != 0) {
                    str2 = str2 + ", no-mobile-promote";
                }
                if ((i3 & 512) != 0) {
                    str2 = str2 + ", hide-mobile_search";
                }
                if ((i3 & 4096) != 0) {
                    str2 = str2 + ", open-float-bottle";
                }
                if ((i3 & 131072) != 0) {
                    str2 = str2 + ", bind but not upload";
                }
                v.d(str, stringBuilder.append(str2).toString());
                vf.set(7, Integer.valueOf(com_tencent_mm_protocal_c_ajj.eeO));
                if (com_tencent_mm_protocal_c_ajj.cHg != 0) {
                    bf bfVar = new bf();
                    bfVar.bCi = 1;
                    bfVar.bBZ = com_tencent_mm_protocal_c_ajj.cHc;
                    bfVar.bCj = com_tencent_mm_protocal_c_ajj.cHf;
                    bfVar.bfd = com_tencent_mm_protocal_c_ajj.cHl;
                    bfVar.cvf = com_tencent_mm_protocal_c_ajj.cHd;
                    bfVar.cve = com_tencent_mm_protocal_c_ajj.cHe;
                    bfVar.bCo = com_tencent_mm_protocal_c_ajj.mFw;
                    v.d("MicroMsg.UserInfoSyncExtension", " getPersonalCard weibo url : " + bfVar.bCo + " nickName :" + com_tencent_mm_protocal_c_ajj.mFx);
                    bf.a(bfVar);
                }
                str = "MicroMsg.UserInfoSyncExtension";
                stringBuilder = new StringBuilder("userinfo Plugstate: ");
                i3 = com_tencent_mm_protocal_c_ajj.mau;
                str2 = "code=" + Integer.toHexString(i3) + ", pluginFlag = " + i3;
                str2 = (i3 & 1) != 0 ? str2 + ", QQMAIL_UNINSTALL" : str2 + ", QQMAIL_INSTALL";
                str2 = (i3 & 2) != 0 ? str2 + ", PM_UNINSTALL" : str2 + ", PM_INSTALL";
                str2 = (i3 & 4) != 0 ? str2 + ", FM_UNINSTALL" : str2 + ", FM_INSTALL";
                str2 = (i3 & 8) != 0 ? str2 + ", WEIBO_UNINSTALL" : str2 + ", WEIBO_INSTALL";
                str2 = (i3 & 16) != 0 ? str2 + ", MEDIANOTE_UNINSTALL" : str2 + ", MEDIANOTE_INSTALL";
                str2 = (i3 & 32) != 0 ? str2 + ", QMSG_UNINSTALL" : str2 + ", QMSG_INSTALL";
                str2 = (i3 & 64) != 0 ? str2 + ", BOTTLE_UNINSTALL" : str2 + ", BOTTLE_INSTALL";
                str2 = (i3 & FileUtils.S_IWUSR) != 0 ? str2 + ", QSYNC_UNISTALL" : str2 + ", QSYNC_INSTALL";
                str2 = (i3 & FileUtils.S_IRUSR) != 0 ? str2 + ", SHAKE_UNISTALL" : str2 + ", SHAKE_INSTALL";
                str2 = (i3 & 512) != 0 ? str2 + ", LBS_UNISTALL" : str2 + ", LBS_INSTALL";
                str2 = (i3 & 1024) != 0 ? str2 + ", BOTTLE_CHART_INSTALL" : str2 + ", BOTTLE_CHART_INSTALL";
                str2 = (i3 & 4096) != 0 ? str2 + ",CHECKQQF_UNINSTALL" : str2 + ",CHECKQQF_INSTALL";
                v.d(str, stringBuilder.append((i3 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? str2 + ",MM_FEEDSAPP_UNINSTALL" : str2 + ",MM_FEEDSAPP_INSTALL").toString());
                vf.set(34, Integer.valueOf(com_tencent_mm_protocal_c_ajj.mau));
                vf.set(8200, Boolean.valueOf(be.a(Boolean.valueOf(1 == com_tencent_mm_protocal_c_ajj.mJr.mpg), false)));
                vf.set(8201, Integer.valueOf(be.a(Integer.valueOf(com_tencent_mm_protocal_c_ajj.mJr.mph.mpk), 22)));
                vf.set(8208, Integer.valueOf(be.a(Integer.valueOf(com_tencent_mm_protocal_c_ajj.mJr.mph.mpl), 8)));
                vf.set(66049, Integer.valueOf(com_tencent_mm_protocal_c_ajj.mFu));
                vf.set(66050, com_tencent_mm_protocal_c_ajj.mFv);
                vf.set(40, Integer.valueOf(com_tencent_mm_protocal_c_ajj.mJO));
                ai.cse.J("last_login_use_voice", com_tencent_mm_protocal_c_ajj.mJO);
                vf.set(41, Integer.valueOf(com_tencent_mm_protocal_c_ajj.mFy));
                vf.set(43, com_tencent_mm_protocal_c_ajj.mFx);
                v.d("MicroMsg.UserInfoSyncExtension", "doCmd PluginSwitch:" + com_tencent_mm_protocal_c_ajj.mJO + " WeiboFlag:" + com_tencent_mm_protocal_c_ajj.mFy);
                vf.set(868518889, Integer.valueOf(com_tencent_mm_protocal_c_ajj.mJD));
                v.d("MicroMsg.UserInfoSyncExtension", "doCmd USERINFO_TXNEWSCATEGORY:" + com_tencent_mm_protocal_c_ajj.mJD);
                vf.set(42, com_tencent_mm_protocal_c_ajj.cHh);
                v.d("MicroMsg.UserInfoSyncExtension", "userid:" + com_tencent_mm_protocal_c_ajj.mrx + " username:" + com_tencent_mm_protocal_c_ajj.mry);
                vf.set(65825, com_tencent_mm_protocal_c_ajj.mrx);
                vf.set(65826, com_tencent_mm_protocal_c_ajj.mry);
                v.d("MicroMsg.UserInfoSyncExtension", "getiAlbumFlag " + com_tencent_mm_protocal_c_ajj.cHi);
                v.d("MicroMsg.UserInfoSyncExtension", "getiAlbumStyle " + com_tencent_mm_protocal_c_ajj.cHj);
                v.d("MicroMsg.UserInfoSyncExtension", "getPcAlbumBGImgID " + com_tencent_mm_protocal_c_ajj.cHk);
                str2 = be.ma((String) com.tencent.mm.kernel.g.vw().vf().get(65830, null));
                if (str2 == null || str2.length() == 0) {
                    str2 = com_tencent_mm_protocal_c_ajj.mJR;
                    if (str2 != null && str2.length() > 0) {
                        com.tencent.mm.kernel.g.vw().vf().set(65830, str2);
                    }
                }
                hlc.a(com_tencent_mm_protocal_c_ajj);
                return;
            default:
                return;
        }
    }
}
