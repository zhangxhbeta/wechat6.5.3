package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.as.u;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.ic;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.a.a.j.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ac;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.ayj;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.p;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.List;

public final class bd {
    Context context;
    p dwg;
    ac jEK;
    public OnClickListener jRS = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.jZg.jYS >= 500) {
                this.jZg.jYS = currentTimeMillis;
                if (view.getTag() instanceof p) {
                    p pVar = (p) view.getTag();
                    azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                    k Bq = ad.aSE().Bq(pVar.bap);
                    if (this.jZg.jEK != null) {
                        this.jZg.jEK.aSj().v(Bq);
                    }
                    Intent intent;
                    aib com_tencent_mm_protocal_c_aib;
                    if (com_tencent_mm_protocal_c_azr.mWq.mol == 18) {
                        Context context = this.jZg.context;
                        azr com_tencent_mm_protocal_c_azr2 = pVar.jFh;
                        j.a(b.AdUrl, com.tencent.mm.plugin.sns.a.a.j.a.EnterCompleteVideo, ad.aSE().Bq(pVar.bap));
                        intent = new Intent();
                        com_tencent_mm_protocal_c_aib = null;
                        if (com_tencent_mm_protocal_c_azr2.mWq.mom.size() > 0) {
                            com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr2.mWq.mom.get(0);
                        }
                        intent.putExtra("IsAd", false);
                        intent.putExtra("KStremVideoUrl", com_tencent_mm_protocal_c_azr2.mWq.glb);
                        intent.putExtra("KSta_SourceType", 2);
                        intent.putExtra("KSta_Scene", b.AdUrl.value);
                        intent.putExtra("KSta_FromUserName", com_tencent_mm_protocal_c_azr2.gln);
                        intent.putExtra("KSta_SnSId", com_tencent_mm_protocal_c_azr2.gID);
                        if (com_tencent_mm_protocal_c_aib == null) {
                            intent.putExtra("KMediaId", "fakeid_" + (com_tencent_mm_protocal_c_aib == null ? com_tencent_mm_protocal_c_azr2.gID : com_tencent_mm_protocal_c_aib.gID));
                        } else {
                            intent.putExtra("KMediaId", com_tencent_mm_protocal_c_aib.gID);
                        }
                        ayj com_tencent_mm_protocal_c_ayj = com_tencent_mm_protocal_c_azr2.mWv;
                        if (com_tencent_mm_protocal_c_ayj != null) {
                            intent.putExtra("KMediaVideoTime", com_tencent_mm_protocal_c_ayj.cqh);
                            intent.putExtra("StreamWording", com_tencent_mm_protocal_c_ayj.cqj);
                            intent.putExtra("StremWebUrl", com_tencent_mm_protocal_c_ayj.cqk);
                            intent.putExtra("KMediaTitle", com_tencent_mm_protocal_c_ayj.cqi);
                            intent.putExtra("KStremVideoUrl", com_tencent_mm_protocal_c_ayj.cqg);
                            intent.putExtra("KThumUrl", com_tencent_mm_protocal_c_ayj.cql);
                            intent.putExtra("KSta_StremVideoAduxInfo", com_tencent_mm_protocal_c_ayj.cqm);
                            intent.putExtra("KSta_StremVideoPublishId", com_tencent_mm_protocal_c_ayj.cqn);
                        }
                        intent.putExtra("KSta_SnsStatExtStr", com_tencent_mm_protocal_c_azr2.jGu);
                        c.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
                        return;
                    }
                    String str = com_tencent_mm_protocal_c_azr.mWq.glb;
                    String str2 = com_tencent_mm_protocal_c_azr.mWp.gID;
                    v.d("MicroMsg.TimeLineClickEvent", "url:" + str);
                    String s = com.tencent.mm.plugin.sns.b.a.drq.s(str, "timeline");
                    if (s != null && s.length() != 0) {
                        Intent intent2 = new Intent();
                        Bundle bundle = null;
                        if (com_tencent_mm_protocal_c_azr != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("KSnsStrId", com_tencent_mm_protocal_c_azr.gID);
                            bundle2.putString("KSnsLocalId", pVar.bap);
                            bundle2.putBoolean("KFromTimeline", true);
                            if (com_tencent_mm_protocal_c_azr.mWq != null && com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                                bundle2.putString("K_sns_thumb_url", ((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).mHP);
                                bundle2.putString("K_sns_raw_url", com_tencent_mm_protocal_c_azr.mWq.glb);
                                v.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", new Object[]{((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).mHP, com_tencent_mm_protocal_c_azr.mWq.glb});
                            }
                            bundle = bundle2;
                        }
                        bundle.putString("key_snsad_statextstr", com_tencent_mm_protocal_c_azr.jGu);
                        intent2.putExtra("rawUrl", s);
                        intent2.putExtra("shortUrl", s);
                        intent2.putExtra("useJs", true);
                        intent2.putExtra(Columns.TYPE, -255);
                        if (com_tencent_mm_protocal_c_azr.mWr != null) {
                            intent2.putExtra("srcUsername", com_tencent_mm_protocal_c_azr.mWr);
                            intent2.putExtra("srcDisplayname", com_tencent_mm_protocal_c_azr.lJj);
                            v.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + com_tencent_mm_protocal_c_azr.lJj + " tlObj.publicUserName: " + com_tencent_mm_protocal_c_azr.mWr);
                        }
                        intent2.putExtra("sns_local_id", pVar.bap);
                        if (Bq != null) {
                            intent2.putExtra("KPublisherId", "sns_" + i.cE(Bq.field_snsId));
                            intent2.putExtra("pre_username", Bq.field_userName);
                            intent2.putExtra("prePublishId", "sns_" + i.cE(Bq.field_snsId));
                            intent2.putExtra("preUsername", Bq.field_userName);
                        }
                        if (!(com_tencent_mm_protocal_c_azr == null || com_tencent_mm_protocal_c_azr.mWp == null)) {
                            intent2.putExtra("KAppId", com_tencent_mm_protocal_c_azr.mWp.gID);
                        }
                        if (Bq != null && Bq.qC(32)) {
                            com.tencent.mm.plugin.sns.storage.a aUo = Bq.aUo();
                            if (aUo != null) {
                                intent2.putExtra("KsnsViewId", aUo.jbF);
                            }
                        }
                        if (!(Bq == null || com_tencent_mm_protocal_c_azr == null)) {
                            com.tencent.mm.modelsns.a gh = this.jZg.scene == 0 ? com.tencent.mm.modelsns.a.gh(718) : com.tencent.mm.modelsns.a.gi(718);
                            gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR()).kj(com_tencent_mm_protocal_c_azr.mWr).kj(com_tencent_mm_protocal_c_azr.mWp == null ? "" : com_tencent_mm_protocal_c_azr.mWp.gID).kj(com_tencent_mm_protocal_c_azr.mWq.glb);
                            gh.JF();
                            gh = this.jZg.scene == 0 ? com.tencent.mm.modelsns.a.gh(743) : com.tencent.mm.modelsns.a.gi(743);
                            com.tencent.mm.modelsns.a kj = gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR()).kj(com_tencent_mm_protocal_c_azr.mWr);
                            if (com_tencent_mm_protocal_c_azr.mWp == null) {
                                str2 = "";
                            } else {
                                str2 = com_tencent_mm_protocal_c_azr.mWp.gID;
                            }
                            kj.kj(str2).kj(com_tencent_mm_protocal_c_azr.mWq.glb);
                            if (bundle != null) {
                                str2 = "intent_key_StatisticsOplog";
                                byte[] BX = gh.BX();
                                if (BX != null) {
                                    bundle.putByteArray(str2, BX);
                                }
                            }
                        }
                        if (bundle != null) {
                            intent2.putExtra("jsapiargs", bundle);
                        }
                        intent2.putExtra("geta8key_scene", 2);
                        intent2.putExtra("from_scence", 3);
                        if (be.kS(com_tencent_mm_protocal_c_azr.jYp) || !e.Bm(com_tencent_mm_protocal_c_azr.jYp)) {
                            com.tencent.mm.plugin.sns.b.a.drp.j(intent2, this.jZg.context);
                            str2 = null;
                            int i = 0;
                            if (!(com_tencent_mm_protocal_c_azr == null || com_tencent_mm_protocal_c_azr.mWp == null)) {
                                str2 = com_tencent_mm_protocal_c_azr.mWp.gID;
                                i = be.getInt(com_tencent_mm_protocal_c_azr.mWp.efc, 0);
                            }
                            s = com.tencent.mm.plugin.sns.b.a.drq.h(str2, i);
                            if (!be.kS(s) && com.tencent.mm.plugin.sns.b.a.drq.bp(str2)) {
                                String str3 = null;
                                if (!(com_tencent_mm_protocal_c_azr == null || com_tencent_mm_protocal_c_azr.joj == null || com_tencent_mm_protocal_c_azr.joj.maK == null)) {
                                    str3 = com_tencent_mm_protocal_c_azr.joj.maK.maD;
                                }
                                com.tencent.mm.plugin.sns.b.a.drq.a(this.jZg.context, str2, s, com_tencent_mm_protocal_c_azr == null ? null : com_tencent_mm_protocal_c_azr.gln, 5, 4, 1, str3, com_tencent_mm_protocal_c_azr.gID);
                            }
                            g.iuh.h(11105, new Object[]{com_tencent_mm_protocal_c_azr.gln, com_tencent_mm_protocal_c_azr.mWq.glb});
                            if (Bq != null && Bq.field_type == 4) {
                                String str4;
                                com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
                                g gVar = g.iuh;
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(1);
                                if (com_tencent_mm_protocal_c_aib == null) {
                                    str4 = "";
                                } else {
                                    str4 = com_tencent_mm_protocal_c_aib.gkC;
                                }
                                objArr[1] = str4;
                                objArr[2] = com_tencent_mm_protocal_c_azr.mWp.gID;
                                gVar.h(13043, objArr);
                                return;
                            }
                            return;
                        }
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        if (com_tencent_mm_protocal_c_azr != null) {
                            List list = com_tencent_mm_protocal_c_azr.mWq.mom;
                            if (list.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((aib) list.get(0)).mHP);
                            }
                        }
                        intent.putExtra("sns_landing_pages_share_sns_id", Bq.aUq());
                        intent.putExtra("sns_landing_pages_aid", Bq.aTz());
                        intent.putExtra("sns_landing_pages_traceid", Bq.aTA());
                        intent.putExtra("sns_landing_pages_ux_info", Bq.aUR());
                        intent.putExtra("sns_landig_pages_from_source", this.jZg.scene == 0 ? 3 : 4);
                        intent.setClass(this.jZg.context, SnsAdNativeLandingPagesUI.class);
                        intent.putExtra("sns_landing_pages_xml", com_tencent_mm_protocal_c_azr.jYp);
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        e.z(intent, this.jZg.context);
                    }
                }
            }
        }
    };
    a jYR;
    long jYS = 0;
    public OnClickListener jYT = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            boolean z;
            String str;
            String str2 = null;
            bd bdVar = this.jZg;
            if (view == null || !(view.getTag() instanceof azr)) {
                z = true;
            } else {
                str = ((azr) view.getTag()).mWp.gID;
                if ("wx485a97c844086dc9".equals(str)) {
                    c.b(view.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
                    z = true;
                } else if ("wx9181ed3f223e6d76".equals(str) || "wx2fe12a395c426fcf".equals(str)) {
                    v.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                    r0 = new Intent();
                    r0.putExtra("shake_tv", true);
                    c.b(view.getContext(), "shake", ".ui.ShakeReportUI", r0);
                    z = true;
                } else if ("wx751a1acca5688ba3".equals(str)) {
                    r0 = new Intent();
                    r0.putExtra("BaseScanUI_select_scan_mode", 5);
                    if (!(u.bi(bdVar.context) || com.tencent.mm.ah.a.aT(bdVar.context))) {
                        c.b(bdVar.context, "scanner", ".ui.BaseScanUI", r0);
                    }
                    z = true;
                } else if ("wxfbc915ff7c30e335".equals(str)) {
                    r0 = new Intent();
                    r0.putExtra("BaseScanUI_select_scan_mode", 1);
                    if (!(u.bi(bdVar.context) || com.tencent.mm.ah.a.aT(bdVar.context))) {
                        c.b(bdVar.context, "scanner", ".ui.BaseScanUI", r0);
                    }
                    z = true;
                } else if ("wx482a4001c37e2b74".equals(str)) {
                    r0 = new Intent();
                    r0.putExtra("BaseScanUI_select_scan_mode", 2);
                    if (!(u.bi(bdVar.context) || com.tencent.mm.ah.a.aT(bdVar.context))) {
                        c.b(bdVar.context, "scanner", ".ui.BaseScanUI", r0);
                    }
                    z = true;
                } else if (!"wxaf060266bfa9a35c".equals(str)) {
                    z = false;
                } else if (com.tencent.mm.ai.c.HG()) {
                    r0 = new Intent();
                    r0.putExtra("shake_tv", true);
                    c.b(bdVar.context, "shake", ".ui.ShakeReportUI", r0);
                    z = true;
                } else {
                    z = true;
                }
            }
            if (!z && view != null && (view.getTag() instanceof azr)) {
                azr com_tencent_mm_protocal_c_azr = (azr) view.getTag();
                if (com_tencent_mm_protocal_c_azr == null || com_tencent_mm_protocal_c_azr.mWp == null) {
                    v.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
                    return;
                }
                String str3 = com_tencent_mm_protocal_c_azr.mWp.gID;
                String bn = com.tencent.mm.plugin.sns.b.a.drq.bn(str3);
                if (be.kS(bn) || !com.tencent.mm.plugin.sns.b.a.drq.bp(str3)) {
                    str = com.tencent.mm.plugin.sns.b.a.drq.e(this.jZg.context, str3, "timeline");
                    if (str != null && str.length() != 0) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str);
                        intent.putExtra("shortUrl", str);
                        intent.putExtra("useJs", true);
                        intent.putExtra(Columns.TYPE, -255);
                        intent.putExtra("geta8key_scene", 2);
                        com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.jZg.context);
                        return;
                    }
                    return;
                }
                int i;
                String str4 = com_tencent_mm_protocal_c_azr == null ? null : com_tencent_mm_protocal_c_azr.gln;
                if (com_tencent_mm_protocal_c_azr.mWq.mol == 1) {
                    i = 2;
                } else if (com_tencent_mm_protocal_c_azr.mWq.mol == 3) {
                    i = 5;
                } else {
                    i = 2;
                }
                if (!(com_tencent_mm_protocal_c_azr.joj == null || com_tencent_mm_protocal_c_azr.joj.maK == null)) {
                    str2 = com_tencent_mm_protocal_c_azr.joj.maK.maD;
                }
                lj ljVar = new lj();
                ljVar.bmI.context = this.jZg.context;
                ljVar.bmI.scene = 4;
                ljVar.bmI.bmJ = str3;
                ljVar.bmI.packageName = bn;
                ljVar.bmI.msgType = i;
                ljVar.bmI.bhM = str4;
                ljVar.bmI.mediaTagName = str2;
                ljVar.bmI.bmK = 5;
                ljVar.bmI.bmL = 0;
                ljVar.bmI.bmM = com_tencent_mm_protocal_c_azr.gID;
                com.tencent.mm.sdk.c.a.nhr.z(ljVar);
                fq fqVar = new fq();
                fqVar.beY.actionCode = 2;
                fqVar.beY.scene = 3;
                fqVar.beY.beZ = "timeline_src=3";
                fqVar.beY.appId = str3;
                fqVar.beY.context = this.jZg.context;
                com.tencent.mm.sdk.c.a.nhr.z(fqVar);
            }
        }
    };
    public OnClickListener jYU = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof ba) {
                final ba baVar = (ba) view.getTag();
                if (be.kS(baVar.jYD)) {
                    v.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
                    Toast.makeText(this.jZg.context, this.jZg.context.getString(2131232922, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                    return;
                }
                ak.yW();
                com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(baVar.jYD);
                if (LX == null || !LX.field_username.equals(baVar.jYD)) {
                    com.tencent.mm.model.ab.a.crZ.a(baVar.jYD, "", new com.tencent.mm.model.ab.c.a(this) {
                        final /* synthetic */ AnonymousClass8 jZh;

                        {
                            this.jZh = r1;
                        }

                        public final void p(String str, boolean z) {
                            if (this.jZh.jZg.dwg != null) {
                                this.jZh.jZg.dwg.dismiss();
                            }
                            if (z) {
                                com.tencent.mm.u.b.r(str, 3);
                                n.Bq().gD(str);
                                Intent intent = new Intent();
                                intent.addFlags(268435456);
                                intent.putExtra("Contact_User", str);
                                intent.putExtra("Contact_Scene", 37);
                                ak.yW();
                                com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
                                if (LX != null && LX.bvm()) {
                                    g.iuh.Y(10298, str + ",37");
                                    intent.putExtra("Contact_Scene", 37);
                                }
                                com.tencent.mm.plugin.sns.b.a.drp.d(intent, this.jZh.jZg.context);
                                return;
                            }
                            Toast.makeText(this.jZh.jZg.context, this.jZh.jZg.context.getString(2131232922, new Object[]{Integer.valueOf(3), Integer.valueOf(-1)}), 0).show();
                        }
                    });
                    bd bdVar = this.jZg;
                    Context context = this.jZg.context;
                    this.jZg.context.getString(2131231164);
                    bdVar.dwg = com.tencent.mm.ui.base.g.a(context, this.jZg.context.getString(2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass8 jZh;

                        public final void onCancel(DialogInterface dialogInterface) {
                            com.tencent.mm.model.ab.a.crZ.fD(baVar.jYD);
                        }
                    });
                    return;
                }
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", baVar.jYD);
                g.iuh.Y(10298, baVar.jYD + ",37");
                intent.putExtra("Contact_Scene", 37);
                com.tencent.mm.plugin.sns.b.a.drp.d(intent, this.jZg.context);
            }
        }
    };
    public OnClickListener jYV = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof p) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                    k Bq = ad.aSE().Bq(pVar.bap);
                    if (this.jZg.jEK != null) {
                        this.jZg.jEK.aSj().v(Bq);
                    }
                    String str = ((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).jFe;
                    Intent intent = new Intent();
                    intent.putExtra("key_Product_xml", str);
                    intent.putExtra("key_ProductUI_getProductInfoScene", 2);
                    c.b(view.getContext(), "scanner", ".ui.ProductUI", intent);
                }
            }
        }
    };
    public OnClickListener jYW = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            v.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
            if (view.getTag() instanceof p) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                    k Bq = ad.aSE().Bq(pVar.bap);
                    if (this.jZg.jEK != null) {
                        this.jZg.jEK.aSj().v(Bq);
                    }
                    String str = ((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).jFe;
                    Intent intent = new Intent();
                    intent.putExtra("key_TV_xml", str);
                    intent.putExtra("key_TV_getProductInfoScene", 2);
                    c.b(view.getContext(), "shake", ".ui.TVInfoUI", intent);
                }
            }
        }
    };
    public OnClickListener jYX = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof p) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                    k Bq = ad.aSE().Bq(pVar.bap);
                    if (this.jZg.jEK != null) {
                        this.jZg.jEK.aSj().v(Bq);
                    }
                    String str = ((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).jFe;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("preceding_scence", 10);
                    intent.putExtra("download_entrance_scene", 13);
                    c.b(view.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
                }
            }
        }
    };
    public OnClickListener jYY = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof p) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                    k Bq = ad.aSE().Bq(pVar.bap);
                    if (this.jZg.jEK != null) {
                        this.jZg.jEK.aSj().v(Bq);
                    }
                    String str = ((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).jFe;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    c.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
                }
            }
        }
    };
    public OnClickListener jYZ = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof p) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                    k Bq = ad.aSE().Bq(pVar.bap);
                    if (this.jZg.jEK != null) {
                        this.jZg.jEK.aSj().v(Bq);
                    }
                    String str = ((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).jFe;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    intent.putExtra("extra_scence", 13);
                    c.b(view.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
                }
            }
        }
    };
    public OnClickListener jZa = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof p) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                    k Bq = ad.aSE().Bq(pVar.bap);
                    if (this.jZg.jEK != null) {
                        this.jZg.jEK.aSj().v(Bq);
                    }
                    String str = ((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).jFe;
                    Intent intent = new Intent();
                    intent.putExtra("sns_object_data", str);
                    c.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
                }
            }
        }
    };
    public OnClickListener jZb = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            boolean z = view.getTag() instanceof p;
            v.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click " + z);
            if (z) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (bd.yS(com_tencent_mm_protocal_c_azr.gID)) {
                    g.iuh.Y(10231, "1");
                    com.tencent.mm.ai.b.HB();
                } else if (!(u.bj(this.jZg.context) || com.tencent.mm.ah.a.aT(this.jZg.context))) {
                    g.iuh.Y(10090, "1,0");
                    if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                        String str;
                        aib com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
                        com.tencent.mm.modelsns.a gh = this.jZg.scene == 0 ? com.tencent.mm.modelsns.a.gh(738) : com.tencent.mm.modelsns.a.gi(738);
                        com.tencent.mm.modelsns.a kj = gh.kj(com_tencent_mm_protocal_c_azr.gID).kj(com_tencent_mm_protocal_c_azr.gln);
                        if (com_tencent_mm_protocal_c_azr.mWp == null) {
                            str = "";
                        } else {
                            str = com_tencent_mm_protocal_c_azr.mWp.gID;
                        }
                        kj.kj(str).kj(com_tencent_mm_protocal_c_aib.aXz).kj(com_tencent_mm_protocal_c_aib.gkC).kj("");
                        gh.JF();
                    }
                    if (pVar.jFi) {
                        com.tencent.mm.ai.b.a(com.tencent.mm.ai.b.a(ad.xq(), com_tencent_mm_protocal_c_azr, 9));
                    } else {
                        com.tencent.mm.ai.b.b(com.tencent.mm.ai.b.a(ad.xq(), com_tencent_mm_protocal_c_azr, 1));
                    }
                }
                if (this.jZg.jYR != null) {
                    this.jZg.jYR.aWG();
                }
            }
        }
    };
    public OnClickListener jZc = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
            if (view.getTag() instanceof p) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                k Bq = ad.aSE().Bq(pVar.bap);
                if (this.jZg.jEK != null) {
                    this.jZg.jEK.aSj().v(Bq);
                }
                if (com_tencent_mm_protocal_c_azr.mWw == null) {
                    v.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
                    return;
                }
                String str = com_tencent_mm_protocal_c_azr.mWw.username;
                String str2 = com_tencent_mm_protocal_c_azr.mWw.path;
                v.i("MicroMsg.TimeLineClickEvent", "username: " + str + "pagepath: " + str2);
                ok okVar = new ok();
                okVar.bpu.userName = str;
                okVar.bpu.bpw = str2;
                okVar.bpu.scene = 1009;
                okVar.bpu.aWP = com_tencent_mm_protocal_c_azr.gID + ":" + com_tencent_mm_protocal_c_azr.gln;
                com.tencent.mm.sdk.c.a.nhr.z(okVar);
            }
        }
    };
    public OnClickListener jZd = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
            if (view.getTag() instanceof azr) {
                azr com_tencent_mm_protocal_c_azr = (azr) view.getTag();
                if (com_tencent_mm_protocal_c_azr.mWw == null) {
                    v.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
                    return;
                }
                String str = com_tencent_mm_protocal_c_azr.mWw.username;
                ok okVar = new ok();
                v.i("MicroMsg.TimeLineClickEvent", "username: " + str);
                okVar.bpu.userName = str;
                okVar.bpu.scene = 1009;
                okVar.bpu.aWP = com_tencent_mm_protocal_c_azr.gID + ":" + com_tencent_mm_protocal_c_azr.gln;
                com.tencent.mm.sdk.c.a.nhr.z(okVar);
            }
        }
    };
    public OnClickListener jZe = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
            if (view.getTag() instanceof p) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                    k Bq = ad.aSE().Bq(pVar.bap);
                    if (this.jZg.jEK != null) {
                        this.jZg.jEK.aSj().v(Bq);
                    }
                    String str = ((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).jFe;
                    Intent intent = new Intent();
                    intent.putExtra("key_product_scene", 2);
                    intent.putExtra("key_product_info", str);
                    c.b(this.jZg.context, "product", ".ui.MallProductUI", intent);
                }
            }
        }
    };
    public OnClickListener jZf = new OnClickListener(this) {
        final /* synthetic */ bd jZg;

        {
            this.jZg = r1;
        }

        public final void onClick(View view) {
            v.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
            if (view.getTag() instanceof p) {
                p pVar = (p) view.getTag();
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                    k Bq = ad.aSE().Bq(pVar.bap);
                    if (this.jZg.jEK != null) {
                        this.jZg.jEK.aSj().v(Bq);
                    }
                    String str = ((aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0)).jFe;
                    Intent intent = new Intent();
                    intent.putExtra("key_from_scene", 12);
                    if (TextUtils.isEmpty(str)) {
                        v.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
                        return;
                    }
                    String[] split = str.split("#");
                    if (split.length >= 2) {
                        v.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + split[0]);
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", split[1]);
                        c.b(this.jZg.context, "card", ".ui.CardDetailUI", intent);
                    } else if (split.length == 1) {
                        v.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
                        v.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :" + str);
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", "");
                        c.b(this.jZg.context, "card", ".ui.CardDetailUI", intent);
                    } else {
                        v.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
                        v.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :" + str);
                    }
                }
            }
        }
    };
    int scene = 0;

    public interface a {
        void aWG();
    }

    public bd(Context context, a aVar, int i, ac acVar) {
        this.context = context;
        this.jYR = aVar;
        this.scene = i;
        this.jEK = acVar;
    }

    protected static boolean yS(String str) {
        ic icVar = new ic();
        icVar.bhZ.action = -2;
        com.tencent.mm.sdk.c.a.nhr.z(icVar);
        ajr com_tencent_mm_protocal_c_ajr = icVar.bia.bib;
        if (com_tencent_mm_protocal_c_ajr != null && com.tencent.mm.ai.b.d(com_tencent_mm_protocal_c_ajr) && str.equals(com_tencent_mm_protocal_c_ajr.mJW) && com.tencent.mm.ai.b.HC()) {
            return true;
        }
        return false;
    }
}
