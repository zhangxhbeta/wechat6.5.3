package com.tencent.mm.plugin.sns.ui.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.b.f;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.fq;
import com.tencent.mm.e.a.lh;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ac;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.am;
import com.tencent.mm.plugin.sns.e.an;
import com.tencent.mm.plugin.sns.e.as;
import com.tencent.mm.plugin.sns.lucky.b.o;
import com.tencent.mm.plugin.sns.lucky.b.x;
import com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI;
import com.tencent.mm.plugin.sns.storage.c;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.SnsUserUI;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.as.a;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.p;
import com.tencent.mm.protocal.c.agp;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.al;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awi;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.MaskImageButton;
import java.util.List;
import java.util.Map;

public abstract class b {
    Activity aXH;
    private ClipboardManager fRJ;
    ac jEK;
    public OnClickListener jIT;
    public OnClickListener kbA;
    public OnClickListener kbB;
    public OnClickListener kbC;
    public OnClickListener kbD;
    public OnClickListener kbE;
    public OnClickListener kbF;
    public OnClickListener kbG;
    public OnClickListener kbH;
    public c kbI;
    public c kbJ;
    public c kbK;
    public c kbL;
    c kbM;
    public OnTouchListener kbN;
    public OnClickListener kbO;
    public OnClickListener kbP;
    public OnClickListener kbQ;
    public OnClickListener kbR;
    public OnClickListener kbS;
    public OnClickListener kbT;
    public a kbU;
    public e kbm;
    public a kbv;
    public OnClickListener kbw;
    public OnLongClickListener kbx;
    public c kby;
    public OnClickListener kbz;
    int scene = 0;

    public abstract void aVv();

    public abstract void aVw();

    public abstract void aY(Object obj);

    public abstract void b(View view, int i, int i2, int i3);

    public abstract void cf(View view);

    public abstract void cg(View view);

    public abstract void ch(View view);

    public abstract void ci(View view);

    public b(int i, Activity activity, ac acVar) {
        this.scene = i;
        this.aXH = activity;
        this.jEK = acVar;
        this.fRJ = (ClipboardManager) this.aXH.getSystemService("clipboard");
        this.kbv = new a(this.aXH, this.scene, this.jEK);
        this.kbF = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null && (view.getTag() instanceof Long)) {
                    String str;
                    com.tencent.mm.plugin.sns.storage.a aUo;
                    String str2;
                    Intent intent;
                    boolean z;
                    Parcelable snsAdClick;
                    Bundle bundle;
                    c cV = ad.aSF().cV(((Long) view.getTag()).longValue());
                    k aUr = cV.aUr();
                    j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.DetailTimeline, cV.aUr());
                    int source = cV.getSource();
                    com.tencent.mm.plugin.sns.storage.a aUo2 = aUr.aUo();
                    String str3 = aUo2 != null ? aUo2.jue : "";
                    if (be.kS(str3)) {
                        com.tencent.mm.plugin.sns.storage.b aUm = aUr.aUm();
                        str = aUm != null ? aUm.jue : "";
                    } else {
                        str = str3;
                    }
                    if (aUr.qC(32)) {
                        aUo = aUr.aUo();
                        int i = -1;
                        com.tencent.mm.storage.a Lp = com.tencent.mm.model.c.c.Av().Lp("Sns_CanvasAd_DetailLink_JumpWay");
                        if (Lp.isValid()) {
                            i = be.getInt(Lp.field_value, -1);
                        }
                        if (aUo != null && aUo.jua == 1) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("key_card_id", aUo.juc);
                            intent2.putExtra("key_card_ext", aUo.jud);
                            intent2.putExtra("key_from_scene", 21);
                            intent2.putExtra("key_stastic_scene", 15);
                            com.tencent.mm.ay.c.b(this.kbV.aXH, "card", ".ui.CardDetailUI", intent2);
                            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(aUr.aUQ(), 3, this.kbV.scene == 0 ? 1 : 2, "", aUr.field_type == 1 ? 1 : 2, 11, source, aUr.aUp().jGu), 0);
                            return;
                        } else if (aUo == null || r0 != 1) {
                            if (aUo == null || r0 != 0) {
                                if (aUo != null && r0 == -1 && aUo.jua == 3 && aUr.aUm().jun && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Bm(aUr.aUS().field_adxml)) {
                                    str3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(aUr);
                                    if (!be.kS(str3)) {
                                        cV.field_adxml = str3;
                                    }
                                    r1 = new Intent();
                                    r1.putExtra("sns_landing_pages_share_sns_id", aUr.aUq());
                                    r1.putExtra("sns_landing_pages_ux_info", aUr.aUR());
                                    r1.putExtra("sns_landing_pages_aid", aUr.aTz());
                                    r1.putExtra("sns_landing_pages_traceid", aUr.aTA());
                                    r0 = aUr.aUp();
                                    if (r0 != null) {
                                        r0 = r0.mWq.mom;
                                        if (r0.size() > 0) {
                                            r1.putExtra("sns_landing_pages_share_thumb_url", ((aib) r0.get(0)).mHP);
                                        }
                                    }
                                    r1.setClass(this.kbV.aXH, SnsAdNativeLandingPagesUI.class);
                                    r1.putExtra("sns_landig_pages_from_source", this.kbV.scene == 0 ? 9 : 10);
                                    r1.putExtra("sns_landing_pages_xml", aUr.aUS().field_adxml);
                                    r1.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                    r1.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                                    this.kbV.aXH.startActivity(r1);
                                    this.kbV.aXH.overridePendingTransition(0, 0);
                                    ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(aUr.aUQ(), 3, this.kbV.scene == 0 ? 1 : 2, "", aUr.field_type == 1 ? 1 : 2, 21, source, aUr.aUp().jGu), 0);
                                    return;
                                }
                            } else if (aUr.aUm().jun && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Bm(aUr.aUS().field_adxml)) {
                                str3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(aUr);
                                if (!be.kS(str3)) {
                                    cV.field_adxml = str3;
                                }
                                Map q = f.q(aUr.aUS().field_adxml, "adxml");
                                if (q != null) {
                                    str3 = be.ah((String) q.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                                    if (!be.kS(str3)) {
                                        str = str3;
                                    }
                                    str2 = str;
                                } else {
                                    v.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + aUr.aUS().field_adxml);
                                    str2 = str;
                                }
                                ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(aUr.aUQ(), 3, this.kbV.scene != 0 ? 1 : 2, "", aUr.field_type != 1 ? 1 : 2, 0, source, aUr.aUp().jGu), 0);
                                v.i("MicroMsg.TimelineClickListener", "adlink url " + str2 + " " + aUr.aUm().jus);
                                intent = new Intent();
                                z = aUr.aUm().jus != 0;
                                if (q.dqs) {
                                    z = false;
                                }
                                snsAdClick = new SnsAdClick(aUr.aUQ(), this.kbV.scene != 0 ? 1 : 2, aUr.field_snsId, aUr.aUR(), aUr.field_type != 1 ? 1 : 2, (byte) 0);
                                if (aUr.qC(32)) {
                                    aUo = aUr.aUo();
                                    if (aUo != null) {
                                        intent.putExtra("KsnsViewId", aUo.jbF);
                                    }
                                }
                                intent.putExtra("KRightBtn", z);
                                bundle = new Bundle();
                                bundle.putParcelable("KSnsAdTag", snsAdClick);
                                bundle.putString("key_snsad_statextstr", cV.aUp().jGu);
                                intent.putExtra("jsapiargs", bundle);
                                intent.putExtra("rawUrl", str2);
                                intent.putExtra("useJs", true);
                                intent.putExtra("srcUsername", aUr.field_userName);
                                intent.putExtra("stastic_scene", 15);
                                intent.putExtra("KPublisherId", "sns_" + i.cE(aUr.field_snsId));
                                intent.putExtra("pre_username", aUr.field_userName);
                                intent.putExtra("prePublishId", "sns_" + i.cE(aUr.field_snsId));
                                intent.putExtra("preUsername", aUr.field_userName);
                                com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.kbV.aXH);
                            }
                        } else if (aUr.aUm().jun && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Bm(aUr.aUS().field_adxml)) {
                            str3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(aUr);
                            if (!be.kS(str3)) {
                                cV.field_adxml = str3;
                            }
                            r1 = new Intent();
                            r1.putExtra("sns_landing_pages_share_sns_id", aUr.aUq());
                            r1.putExtra("sns_landing_pages_ux_info", aUr.aUR());
                            r1.putExtra("sns_landing_pages_aid", aUr.aTz());
                            r1.putExtra("sns_landing_pages_traceid", aUr.aTA());
                            r0 = aUr.aUp();
                            if (r0 != null) {
                                r0 = r0.mWq.mom;
                                if (r0.size() > 0) {
                                    r1.putExtra("sns_landing_pages_share_thumb_url", ((aib) r0.get(0)).mHP);
                                }
                            }
                            r1.setClass(this.kbV.aXH, SnsAdNativeLandingPagesUI.class);
                            r1.putExtra("sns_landig_pages_from_source", this.kbV.scene == 0 ? 9 : 10);
                            r1.putExtra("sns_landing_pages_xml", aUr.aUS().field_adxml);
                            r1.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            r1.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                            this.kbV.aXH.startActivity(r1);
                            this.kbV.aXH.overridePendingTransition(0, 0);
                            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(aUr.aUQ(), 3, this.kbV.scene == 0 ? 1 : 2, "", aUr.field_type == 1 ? 1 : 2, 21, source, aUr.aUp().jGu), 0);
                            return;
                        }
                    }
                    str2 = str;
                    if (this.kbV.scene != 0) {
                    }
                    if (aUr.field_type != 1) {
                    }
                    ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(aUr.aUQ(), 3, this.kbV.scene != 0 ? 1 : 2, "", aUr.field_type != 1 ? 1 : 2, 0, source, aUr.aUp().jGu), 0);
                    v.i("MicroMsg.TimelineClickListener", "adlink url " + str2 + " " + aUr.aUm().jus);
                    intent = new Intent();
                    if (aUr.aUm().jus != 0) {
                    }
                    if (q.dqs) {
                        z = false;
                    }
                    if (this.kbV.scene != 0) {
                    }
                    if (aUr.field_type != 1) {
                    }
                    snsAdClick = new SnsAdClick(aUr.aUQ(), this.kbV.scene != 0 ? 1 : 2, aUr.field_snsId, aUr.aUR(), aUr.field_type != 1 ? 1 : 2, (byte) 0);
                    if (aUr.qC(32)) {
                        aUo = aUr.aUo();
                        if (aUo != null) {
                            intent.putExtra("KsnsViewId", aUo.jbF);
                        }
                    }
                    intent.putExtra("KRightBtn", z);
                    bundle = new Bundle();
                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                    bundle.putString("key_snsad_statextstr", cV.aUp().jGu);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("useJs", true);
                    intent.putExtra("srcUsername", aUr.field_userName);
                    intent.putExtra("stastic_scene", 15);
                    intent.putExtra("KPublisherId", "sns_" + i.cE(aUr.field_snsId));
                    intent.putExtra("pre_username", aUr.field_userName);
                    intent.putExtra("prePublishId", "sns_" + i.cE(aUr.field_snsId));
                    intent.putExtra("preUsername", aUr.field_userName);
                    com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.kbV.aXH);
                }
            }
        };
        this.kbP = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                int i = 2;
                if (view.getTag() instanceof String) {
                    k Bq = ad.aSE().Bq((String) view.getTag());
                    if (Bq == null) {
                        return;
                    }
                    com.tencent.mm.modelsns.a gh;
                    if (Bq.qC(32)) {
                        v.i("MicroMsg.TimelineClickListener", "click the ad poi button");
                        ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(Bq.aUQ(), 19, this.kbV.scene == 0 ? 1 : 2, "", Bq.field_type == 1 ? 1 : 2), 0);
                        com.tencent.mm.plugin.sns.storage.a aUo = Bq.aUo();
                        if (aUo == null) {
                            v.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                            return;
                        } else if (be.kS(aUo.jui)) {
                            v.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
                            return;
                        } else {
                            gh = this.kbV.scene == 0 ? com.tencent.mm.modelsns.a.gh(724) : com.tencent.mm.modelsns.a.gi(724);
                            gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR()).kj("").kj("").kj("").kj("").kj(aUo.juh).kj("").kj("");
                            gh.JF();
                            v.i("MicroMsg.TimelineClickListener", "open webview url : " + aUo.jui);
                            Intent intent = new Intent();
                            String aUQ = Bq.aUQ();
                            int i2 = this.kbV.scene == 0 ? 1 : 2;
                            long j = Bq.field_snsId;
                            String aUR = Bq.aUR();
                            if (Bq.field_type == 1) {
                                i = 1;
                            }
                            Parcelable snsAdClick = new SnsAdClick(aUQ, i2, j, aUR, i);
                            if (Bq != null && Bq.qC(32)) {
                                com.tencent.mm.plugin.sns.storage.a aUo2 = Bq.aUo();
                                if (aUo2 != null) {
                                    intent.putExtra("KsnsViewId", aUo2.jbF);
                                }
                            }
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("KSnsAdTag", snsAdClick);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("useJs", true);
                            intent.putExtra("KPublisherId", "sns_" + i.cE(Bq.field_snsId));
                            intent.putExtra("pre_username", Bq.field_userName);
                            intent.putExtra("prePublishId", "sns_" + i.cE(Bq.field_snsId));
                            intent.putExtra("preUsername", Bq.field_userName);
                            intent.putExtra("rawUrl", aUo.jui);
                            com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.kbV.aXH);
                            return;
                        }
                    }
                    agp com_tencent_mm_protocal_c_agp = Bq.aUp().mWo;
                    Intent intent2 = new Intent();
                    gh = this.kbV.scene == 0 ? com.tencent.mm.modelsns.a.gh(724) : com.tencent.mm.modelsns.a.gi(724);
                    gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR()).kj(com_tencent_mm_protocal_c_agp.mGi).gk(com_tencent_mm_protocal_c_agp.jGT).kj(com_tencent_mm_protocal_c_agp.mjN).kj(com_tencent_mm_protocal_c_agp.mjM).kj(com_tencent_mm_protocal_c_agp.gUr).kj(com_tencent_mm_protocal_c_agp.jGR).kj(com_tencent_mm_protocal_c_agp.cHe);
                    gh.JF();
                    if (be.kS(com_tencent_mm_protocal_c_agp.mGi)) {
                        intent2.putExtra("map_view_type", 7);
                        intent2.putExtra("kwebmap_slat", (double) com_tencent_mm_protocal_c_agp.mjN);
                        intent2.putExtra("kwebmap_lng", (double) com_tencent_mm_protocal_c_agp.mjM);
                        intent2.putExtra("kPoiName", com_tencent_mm_protocal_c_agp.gUr);
                        intent2.putExtra("Kwebmap_locaion", com_tencent_mm_protocal_c_agp.jGR);
                        com.tencent.mm.ay.c.b(this.kbV.aXH, "location", ".ui.RedirectUI", intent2);
                        return;
                    }
                    intent2.putExtra("rawUrl", String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[]{com_tencent_mm_protocal_c_agp.mGi}));
                    com.tencent.mm.plugin.sns.b.a.drp.j(intent2, this.kbV.aXH);
                }
            }
        };
        this.kbT = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof String) {
                    k Bq = ad.aSE().Bq((String) view.getTag());
                    if (Bq != null && Bq.qC(32)) {
                        v.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                        com.tencent.mm.plugin.sns.storage.a aUo = Bq.aUo();
                        if (aUo == null) {
                            v.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                        } else if (be.kS(aUo.jul)) {
                            v.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
                        } else {
                            v.i("MicroMsg.TimelineClickListener", "open webview url : " + aUo.jul);
                            Intent intent = new Intent();
                            intent.putExtra("jsapiargs", new Bundle());
                            intent.putExtra("useJs", true);
                            intent.putExtra("rawUrl", aUo.jul);
                            com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.kbV.aXH);
                        }
                    }
                }
            }
        };
        this.kbw = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                k kVar;
                String str;
                boolean z;
                com.tencent.mm.modelsns.a gh;
                int i = 721;
                boolean z2 = false;
                String str2 = (String) view.getTag();
                v.d("MicroMsg.TimelineClickListener", "onCommentClick:" + str2);
                Intent intent = new Intent();
                String str3 = "";
                if (!(view instanceof MaskImageButton) || ((MaskImageButton) view).oTP == null) {
                    kVar = null;
                    str = str3;
                    z = false;
                } else {
                    k Bq = ad.aSE().Bq((String) ((MaskImageButton) view).oTP);
                    if (Bq.qC(32)) {
                        str = Bq.aUQ();
                        com.tencent.mm.plugin.sns.storage.b aUm = Bq.aUm();
                        if (aUm == null || aUm.juz != 1 || be.kS(aUm.juA)) {
                            kVar = Bq;
                            z = true;
                        } else {
                            str2 = aUm.juA;
                            v.i("MicroMsg.TimelineClickListener", "headClickParam url " + str2 + " " + aUm.juB);
                            Intent intent2 = new Intent();
                            if (aUm.juB == 0) {
                                z2 = true;
                            }
                            intent2.putExtra("KsnsViewId", str);
                            intent2.putExtra("KRightBtn", z2);
                            intent2.putExtra("jsapiargs", new Bundle());
                            intent2.putExtra("rawUrl", str2);
                            intent2.putExtra("useJs", true);
                            com.tencent.mm.plugin.sns.b.a.drp.j(intent2, this.kbV.aXH);
                            return;
                        }
                    }
                    kVar = Bq;
                    str = str3;
                    z = false;
                }
                if (kVar != null) {
                    if (this.kbV.scene == 0) {
                        gh = com.tencent.mm.modelsns.a.gh(kVar.qC(32) ? 722 : 721);
                    } else {
                        if (kVar.qC(32)) {
                            i = 722;
                        }
                        gh = com.tencent.mm.modelsns.a.gi(i);
                    }
                    gh.kj(i.g(kVar)).gk(kVar.field_type).bg(kVar.qC(32)).kj(kVar.aUR()).kj(str2);
                    gh.JF();
                }
                if (z) {
                    int i2;
                    Parcelable snsAdClick = new SnsAdClick(str, this.kbV.scene == 0 ? 1 : 2, kVar.field_snsId, kVar.aUR(), kVar.field_type == 1 ? 1 : 2, (byte) 0);
                    intent.putExtra("Contact_User", str2);
                    intent.putExtra("KSnsAdTag", snsAdClick);
                    com.tencent.mm.plugin.sns.b.a.drp.d(intent, this.kbV.aXH);
                    if (this.kbV.scene == 0) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(str, 1, i2, "", kVar.field_type == 1 ? 1 : 2), 0);
                    return;
                }
                this.kbV.jEK.aSj().a(kVar, true);
                intent.setClass(this.kbV.aXH, SnsUserUI.class);
                gh = this.kbV.scene == 0 ? com.tencent.mm.modelsns.a.gh(746) : com.tencent.mm.modelsns.a.gi(746);
                gh.kj(str2).bg(str2.endsWith(com.tencent.mm.model.k.xF()));
                Intent e = ad.aSu().e(intent, str2);
                gh.b(e, "intent_key_StatisticsOplog");
                if (e != null) {
                    this.kbV.aXH.startActivity(e);
                    if ((e.getFlags() & 67108864) != 0) {
                        this.kbV.aXH.finish();
                    }
                }
            }
        };
        this.kbx = new OnLongClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final boolean onLongClick(View view) {
                final String str = (String) view.getTag();
                v.d("MicroMsg.TimelineClickListener", "onCommentLongClick:" + str);
                if (be.kS(str)) {
                    return true;
                }
                if (str.equals(ad.aSk())) {
                    return true;
                }
                String str2;
                int i;
                if (((MaskImageButton) view).oTP == null || !(((MaskImageButton) view).oTP instanceof String)) {
                    str2 = "";
                } else {
                    str2 = (String) ((MaskImageButton) view).oTP;
                }
                Intent intent = new Intent();
                final k Bq = ad.aSE().Bq(str2);
                if (Bq == null || !Bq.qC(32)) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    return false;
                }
                g.a(this.kbV.aXH, null, new String[]{this.kbV.aXH.getString(2131232104), this.kbV.aXH.getString(2131235547)}, null, new g.c(this) {
                    final /* synthetic */ AnonymousClass22 kcd;

                    public final void gT(int i) {
                        long j = 0;
                        Intent intent;
                        switch (i) {
                            case 0:
                                intent = new Intent();
                                String str = "sns_permission_snsinfo_svr_id";
                                if (Bq != null) {
                                    j = Bq.field_snsId;
                                }
                                intent.putExtra(str, j);
                                intent.putExtra("sns_permission_userName", str);
                                intent.putExtra("sns_permission_anim", true);
                                intent.putExtra("sns_permission_block_scene", 5);
                                intent.setClass(this.kcd.kbV.aXH, SnsPermissionUI.class);
                                this.kcd.kbV.aXH.startActivityForResult(intent, 11);
                                return;
                            case 1:
                                intent = new Intent();
                                k Bq = ad.aSE().Bq(str2);
                                if (Bq == null) {
                                    v.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + str2);
                                    return;
                                }
                                v.i("MicroMsg.TimelineClickListener", "expose id " + Bq.aUq() + " " + Bq.field_userName);
                                String str2 = "k_expose_msg_id";
                                if (Bq != null) {
                                    j = Bq.field_snsId;
                                }
                                intent.putExtra(str2, j);
                                intent.putExtra("k_username", Bq == null ? "" : Bq.field_userName);
                                intent.putExtra("showShare", false);
                                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                                com.tencent.mm.ay.c.b(this.kcd.kbV.aXH, "webview", ".ui.tools.WebViewUI", intent);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return false;
            }
        };
        this.kby = new c(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                ap apVar = (ap) view.getTag();
                k Bp = ad.aSE().Bp(apVar.boC);
                if (Bp != null) {
                    contextMenu.add(0, 0, 0, this.kbV.aXH.getString(2131231773));
                    if (com.tencent.mm.ay.c.EH("favorite")) {
                        contextMenu.add(0, 1, 0, this.kbV.aXH.getString(2131234180));
                    }
                    azr aUp = Bp.aUp();
                    if (apVar.jRD || !(aUp == null || aUp.mWs == 1 || apVar.jRE)) {
                        if (apVar.aXl()) {
                            am.b(contextMenu, true);
                        } else {
                            am.a(contextMenu, true);
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Bp);
                }
            }

            public final boolean cm(View view) {
                if (!(view.getTag() instanceof ap)) {
                    return false;
                }
                k Bp = ad.aSE().Bp(((ap) view.getTag()).boC);
                if (Bp == null) {
                    return false;
                }
                this.kbV.kbv.a(view, Bp.aUL(), Bp.aUp());
                return true;
            }
        };
        this.kbK = new c(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof p) {
                    this.kbV.kbM.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                }
            }

            public final boolean cm(View view) {
                if (!(view.getTag() instanceof p)) {
                    return false;
                }
                String str = ((p) view.getTag()).bap;
                this.kbV.kbv.a(view, str, ad.aSE().Bq(str).aUp());
                return true;
            }
        };
        this.kbJ = new c(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.am) {
                    String str = ((com.tencent.mm.plugin.sns.ui.am) view.getTag()).bde;
                    k Bq = ad.aSE().Bq(str);
                    if (com.tencent.mm.ay.c.EH("favorite")) {
                        contextMenu.add(0, 2, 0, this.kbV.aXH.getString(2131234180));
                        cp cpVar = new cp();
                        cpVar.bay.bap = str;
                        com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                        if (cpVar.baz.aZW) {
                            contextMenu.add(0, 18, 0, this.kbV.aXH.getString(2131231834));
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Bq);
                }
            }

            public final boolean cm(View view) {
                if (!(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.am)) {
                    return false;
                }
                String str = ((com.tencent.mm.plugin.sns.ui.am) view.getTag()).bde;
                this.kbV.kbv.a(view, str, ad.aSE().Bq(str).aUp());
                return true;
            }
        };
        this.jIT = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.am) {
                    String str;
                    k Bq = com.tencent.mm.plugin.sns.storage.f.Bq(((com.tencent.mm.plugin.sns.ui.am) view.getTag()).bde);
                    if (Bq.aUp().mWq.mol == 21) {
                        if (com.tencent.mm.model.k.xF().equals(Bq.field_userName)) {
                            str = Bq.aUp().gID;
                            x.j(Bq);
                            x.i(Bq);
                            System.currentTimeMillis();
                            com.tencent.mm.plugin.sns.lucky.b.b.kZ(25);
                        }
                        if (!com.tencent.mm.model.k.xF().equals(Bq.field_userName)) {
                            com.tencent.mm.plugin.sns.lucky.c.a.a(2, Bq);
                            com.tencent.mm.plugin.sns.lucky.b.b.kZ(30);
                        }
                    }
                    if (Bq.qC(32)) {
                        Bq.aUo();
                        if (Bq.aUm().jun && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Bm(Bq.aUS().field_adxml)) {
                            int i;
                            str = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Bq);
                            if (!be.kS(str)) {
                                Bq.aUS().field_adxml = str;
                            }
                            String aUQ = Bq.aUQ();
                            int i2 = this.kbV.scene == 0 ? 1 : 2;
                            String str2 = "";
                            if (Bq.field_type == 1) {
                                i = 1;
                            } else {
                                i = 2;
                            }
                            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(aUQ, 21, i2, str2, i), 0);
                            int[] iArr = new int[2];
                            if (view != null) {
                                view.getLocationInWindow(iArr);
                            }
                            int width = view.getWidth();
                            int height = view.getHeight();
                            Intent intent = new Intent();
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            intent.putExtra("sns_landing_pages_share_sns_id", Bq.aUq());
                            intent.putExtra("sns_landing_pages_ux_info", Bq.aUR());
                            intent.putExtra("sns_landing_pages_aid", Bq.aTz());
                            intent.putExtra("sns_landing_pages_traceid", Bq.aTA());
                            azr aUp = Bq.aUp();
                            if (aUp != null) {
                                List list = aUp.mWq.mom;
                                if (list.size() > 0) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", ((aib) list.get(0)).mHP);
                                }
                            }
                            intent.setClass(this.kbV.aXH, SnsAdNativeLandingPagesUI.class);
                            intent.putExtra("sns_landig_pages_from_source", this.kbV.scene == 0 ? 1 : 2);
                            intent.putExtra("sns_landing_pages_xml", Bq.aUS().field_adxml);
                            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                            this.kbV.aXH.startActivity(intent);
                            this.kbV.aXH.overridePendingTransition(0, 0);
                            if (this.kbV.jEK != null) {
                                this.kbV.jEK.aSj().v(Bq);
                            }
                        } else {
                            this.kbV.aY(view);
                        }
                    } else {
                        this.kbV.aY(view);
                    }
                    Bq.qC(32);
                    com.tencent.mm.plugin.sns.ui.am amVar = (com.tencent.mm.plugin.sns.ui.am) view.getTag();
                    if (amVar.jMd && Bq != null) {
                        au.b(Bq, amVar.index);
                        as.AE(Bq.aUL());
                    }
                    if (Bq != null) {
                        azr aUp2 = Bq.aUp();
                        if (aUp2 != null) {
                            String str3 = aUp2.mWp == null ? null : aUp2.mWp.gID;
                            if (!be.kS(str3) && com.tencent.mm.plugin.sns.b.a.drq.bp(str3)) {
                                com.tencent.mm.plugin.sns.b.a.drq.a(null, str3, com.tencent.mm.plugin.sns.b.a.drq.bn(str3), aUp2.gln, 2, 4, 4, aUp2.mWu, aUp2.gID);
                            }
                        }
                    }
                }
            }
        };
        this.kbz = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(final View view) {
                g.a(this.kbV.aXH, 2131235549, 2131231164, 2131231020, 2131231010, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 kbW;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (view.getTag() instanceof String) {
                            String str = (String) view.getTag();
                            v.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
                            k Bq = ad.aSE().Bq(str);
                            if (Bq == null) {
                                v.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %d then return it", new Object[]{str});
                            } else if (Bq.aUN()) {
                                v.i("MicroMsg.TimelineClickListener", "dead item");
                                ad.aSE().qH(Bq.jBI);
                                if (this.kbW.kbV.kbU != null) {
                                    this.kbW.kbV.kbU.aXD();
                                }
                                r0 = this.kbW.kbV.scene == 0 ? com.tencent.mm.modelsns.a.gh(739) : com.tencent.mm.modelsns.a.gi(739);
                                r3 = r0.kj(i.g(Bq)).gk(Bq.field_type);
                                r1 = Bq.aUN() ? "2" : Bq.field_snsId == 0 ? "1" : "0";
                                r3.kj(r1);
                                r0.JF();
                                if (Bq.field_type == 21) {
                                    o.aRh().aRj();
                                }
                            } else if (Bq.aSn()) {
                                v.i("MicroMsg.TimelineClickListener", "cancel item " + Bq.aUL());
                                ad.aSA().r(Bq);
                                this.kbW.kbV.aVv();
                            } else {
                                v.i("MicroMsg.TimelineClickListener", "delete by server");
                                str = Bq.aUq();
                                ad.aSD().cP(s.BK(str));
                                ak.vy().a(new com.tencent.mm.plugin.sns.e.p(s.BK(str), 1), 0);
                                ad.aSE().delete(s.BK(str));
                                ad.aSH().cX(s.BK(str));
                                this.kbW.kbV.aVv();
                                azr aUp = Bq.aUp();
                                if (aUp != null) {
                                    if (aUp.mWp == null) {
                                        str = null;
                                    } else {
                                        str = aUp.mWp.gID;
                                    }
                                    if (!be.kS(str) && com.tencent.mm.plugin.sns.b.a.drq.bp(str)) {
                                        String bn = com.tencent.mm.plugin.sns.b.a.drq.bn(str);
                                        lh lhVar = new lh();
                                        lhVar.bmD.appId = str;
                                        lhVar.bmD.bmE = aUp.gln;
                                        lhVar.bmD.aRm = bn;
                                        lhVar.bmD.mediaTagName = aUp.mWu;
                                        com.tencent.mm.sdk.c.a.nhr.z(lhVar);
                                    }
                                }
                                r0 = this.kbW.kbV.scene == 0 ? com.tencent.mm.modelsns.a.gh(739) : com.tencent.mm.modelsns.a.gi(739);
                                r3 = r0.kj(i.g(Bq)).gk(Bq.field_type);
                                r1 = Bq.aUN() ? "2" : Bq.field_snsId == 0 ? "1" : "0";
                                r3.kj(r1);
                                r0.JF();
                            }
                        }
                    }
                }, null);
            }
        };
        this.kbA = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                String str = (String) view.getTag();
                v.d("MicroMsg.TimelineClickListener", "onItemDelClick:" + str);
                azr aUp = ad.aSE().Bq(str).aUp();
                al alVar = aUp.joj;
                if (alVar.maK != null) {
                    int i;
                    String bn = com.tencent.mm.plugin.sns.b.a.drq.bn(alVar.maK.glj);
                    if (aUp.mWq.mol == 1) {
                        i = 2;
                    } else if (aUp.mWq.mol == 3) {
                        i = 5;
                    } else {
                        i = 2;
                    }
                    if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(aUp, this.kbV.aXH)) {
                        fq fqVar;
                        switch (alVar.efm) {
                            case 4:
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", alVar.glb);
                                com.tencent.mm.plugin.sns.b.a.drp.j(intent, this.kbV.aXH);
                                com.tencent.mm.plugin.sns.b.a.drq.a(this.kbV.aXH, alVar.maK.glj, bn, aUp.gln, i, 11, 1, alVar.maK.maD, aUp.gID);
                                return;
                            case 5:
                                if (alVar.maG == 1) {
                                    fqVar = new fq();
                                    fqVar.beY.actionCode = 2;
                                    fqVar.beY.scene = 3;
                                    fqVar.beY.appId = alVar.maK.glj;
                                    fqVar.beY.context = this.kbV.aXH;
                                    com.tencent.mm.sdk.c.a.nhr.z(fqVar);
                                    com.tencent.mm.plugin.sns.b.a.drq.a(this.kbV.aXH, alVar.maK.glj, bn, aUp.gln, i, 11, 6, alVar.maK.maD, aUp.gID);
                                    return;
                                }
                                return;
                            case 6:
                                int i2 = alVar == null ? 0 : alVar.efm == 6 ? alVar.maM == null ? 0 : com.tencent.mm.plugin.sns.b.a.drq.o(this.kbV.aXH, alVar.maK.glj) ? alVar.maM.mcx : alVar.maM.mcy : alVar.maG;
                                if (i2 == 1) {
                                    fqVar = new fq();
                                    fqVar.beY.context = this.kbV.aXH;
                                    fqVar.beY.actionCode = 2;
                                    fqVar.beY.appId = alVar.maK.glj;
                                    fqVar.beY.messageAction = alVar.maK.maF;
                                    fqVar.beY.messageExt = alVar.maK.maE;
                                    fqVar.beY.scene = 3;
                                    com.tencent.mm.sdk.c.a.nhr.z(fqVar);
                                    com.tencent.mm.plugin.sns.b.a.drq.a(this.kbV.aXH, alVar.maK.glj, bn, aUp.gln, i, 11, 6, alVar.maK.maD, aUp.gID);
                                    return;
                                } else if (i2 == 2) {
                                    fqVar = new fq();
                                    fqVar.beY.context = this.kbV.aXH;
                                    fqVar.beY.actionCode = 1;
                                    fqVar.beY.appId = alVar.maK.glj;
                                    fqVar.beY.messageAction = alVar.maK.maF;
                                    fqVar.beY.messageExt = alVar.maK.maE;
                                    fqVar.beY.scene = 3;
                                    com.tencent.mm.sdk.c.a.nhr.z(fqVar);
                                    com.tencent.mm.plugin.sns.b.a.drq.a(this.kbV.aXH, alVar.maK.glj, bn, aUp.gln, i, 11, 3, alVar.maK.maD, aUp.gID);
                                    return;
                                } else {
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                }
            }
        };
        this.kbH = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof k) {
                    k kVar = (k) view.getTag();
                    if (kVar.field_type == 21 && com.tencent.mm.model.k.xF().equals(kVar.field_userName)) {
                        String str = kVar.aUp().gID;
                        x.j(kVar);
                        x.i(kVar);
                        System.currentTimeMillis();
                        com.tencent.mm.plugin.sns.lucky.b.b.kZ(24);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_sendid", kVar.aUq());
                    intent.putExtra("key_feedid", kVar.aUL());
                    intent.setClass(this.kbV.aXH, SnsLuckyMoneyDetailUI.class);
                    this.kbV.aXH.startActivity(intent);
                }
            }
        };
        this.kbB = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                this.kbV.cf(view);
            }
        };
        this.kbC = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                this.kbV.ch(view);
            }
        };
        this.kbD = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof String) {
                    String str = (String) view.getTag();
                    v.d("MicroMsg.TimelineClickListener", "localId " + str);
                    ah.qh(s.BL(str));
                    ah.qf(s.BL(str));
                    ad.aSA().aTe();
                    this.kbV.aVv();
                    if (this.kbV.kbU != null) {
                        this.kbV.kbU.aXD();
                    }
                }
            }
        };
        this.kbE = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                try {
                    int BL = s.BL((String) view.getTag());
                    Intent intent = new Intent();
                    intent.putExtra("sns_label_sns_info", BL);
                    com.tencent.mm.plugin.sns.b.a.drp.y(intent, this.kbV.aXH);
                } catch (Exception e) {
                }
            }
        };
        this.kbI = new c(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.k) {
                    com.tencent.mm.plugin.sns.ui.k kVar = (com.tencent.mm.plugin.sns.ui.k) view.getTag();
                    contextMenu.add(0, 11, 0, this.kbV.aXH.getString(2131231773));
                    if (kVar.gln != null && kVar.gln.equals(com.tencent.mm.model.k.xF())) {
                        contextMenu.add(0, 7, 0, this.kbV.aXH.getString(2131231020));
                    }
                    String cB = am.cB(kVar.jEU, (kVar.jkg.mSN != 0 ? (long) kVar.jkg.mSN : kVar.jkg.mSQ));
                    int i = kVar.scene == 1 ? 2 : kVar.scene == 2 ? 4 : -1;
                    com.tencent.mm.plugin.sns.e.am.b AA = am.AA(cB);
                    boolean z = (AA == null || !AA.cvW || AA.cyo || (i & AA.bCd) == 0) ? false : true;
                    if (z) {
                        am.b(contextMenu, false);
                    } else {
                        am.a(contextMenu, false);
                    }
                }
            }

            public final boolean cm(View view) {
                if (!(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.k)) {
                    return false;
                }
                k Bp = ad.aSE().Bp(((com.tencent.mm.plugin.sns.ui.k) view.getTag()).jEU);
                this.kbV.kbv.a(view, Bp.aUL(), Bp.aUp());
                return true;
            }
        };
        this.kbN = new OnTouchListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                v.d("MicroMsg.TimelineClickListener", "v " + view.getId() + "  ");
                this.kbV.cg(view);
                return false;
            }
        };
        this.kbO = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof ap) {
                    k Bp = ad.aSE().Bp(((ap) view.getTag()).boC);
                    if (Bp != null) {
                        Intent intent = new Intent();
                        intent.putExtra("sns_text_show", Bp.aUp().mWn);
                        intent.putExtra("sns_local_id", Bp.aUL());
                        intent.setClass(this.kbV.aXH, SnsSingleTextViewUI.class);
                        this.kbV.aXH.startActivity(intent);
                    }
                }
            }
        };
        this.kbR = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof p) {
                    p pVar = (p) view.getTag();
                    aib com_tencent_mm_protocal_c_aib = (aib) pVar.jFh.mWq.mom.get(0);
                    ad.aSE().Bp(pVar.bap);
                    String str = "";
                    String cA = com.tencent.mm.plugin.sns.e.al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
                    String str2 = "";
                    String i = i.i(com_tencent_mm_protocal_c_aib);
                    if (FileOp.aR(cA + i)) {
                        str = cA + i;
                        str2 = cA + i.c(com_tencent_mm_protocal_c_aib);
                    }
                    if (FileOp.aR(cA + i.o(com_tencent_mm_protocal_c_aib))) {
                        str = cA + i.o(com_tencent_mm_protocal_c_aib);
                        str2 = cA + i.m(com_tencent_mm_protocal_c_aib);
                    }
                    int[] iArr = new int[2];
                    if (view != null) {
                        view.getLocationInWindow(iArr);
                    }
                    int width = view.getWidth();
                    int height = view.getHeight();
                    Intent intent = new Intent();
                    intent.setClass(this.kbV.aXH, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", str);
                    intent.putExtra("intent_thumbpath", str2);
                    intent.putExtra("intent_localid", pVar.bap);
                    intent.putExtra("intent_isad", false);
                    intent.putExtra("intent_from_scene", this.kbV.scene);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    this.kbV.aXH.startActivity(intent);
                    this.kbV.aXH.overridePendingTransition(0, 0);
                }
            }
        };
        this.kbQ = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                int i;
                int i2;
                int i3;
                int i4;
                Throwable e;
                v.i("MicroMsg.TimelineClickListener", "onsight click");
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ah) {
                    com.tencent.mm.plugin.sns.ui.ah ahVar = (com.tencent.mm.plugin.sns.ui.ah) view.getTag();
                    k Bq = ad.aSE().Bq(ahVar.bap);
                    if (Bq != null) {
                        if (this.kbV.jEK != null) {
                            this.kbV.jEK.aSj().v(Bq);
                        }
                        boolean qC = Bq.qC(32);
                        azr com_tencent_mm_protocal_c_azr = ahVar.jKk;
                        if (com_tencent_mm_protocal_c_azr.mWq.mom == null || com_tencent_mm_protocal_c_azr.mWq.mom.size() == 0) {
                            v.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                            return;
                        }
                        aib com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
                        if (qC) {
                            ad.aSB();
                            if (!com.tencent.mm.plugin.sns.e.g.v(com_tencent_mm_protocal_c_aib)) {
                                ahVar.jzs.setVisibility(8);
                                ahVar.jzr.setVisibility(0);
                                ahVar.jzr.bKj();
                                ad.aSB().A(com_tencent_mm_protocal_c_aib);
                                com.tencent.mm.plugin.sns.e.b aSz = ad.aSz();
                                com.tencent.mm.storage.ak bvV = com.tencent.mm.storage.ak.bvV();
                                bvV.hrm = com_tencent_mm_protocal_c_azr.hNS;
                                aSz.a(com_tencent_mm_protocal_c_aib, 4, null, bvV);
                                if (qC) {
                                    j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.PlayIcon, Bq);
                                    return;
                                }
                                return;
                            }
                        }
                        Object obj = (Bq.qC(32) && Bq.aUm().jun && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Bm(Bq.aUS().field_adxml)) ? 1 : null;
                        if (obj == null && qC && ad.aSB().w(com_tencent_mm_protocal_c_aib)) {
                            ad.aSB().A(com_tencent_mm_protocal_c_aib);
                            ahVar.jzs.setVisibility(8);
                            ahVar.jzr.setVisibility(8);
                            com.tencent.mm.plugin.sns.e.g aSB = ad.aSB();
                            com.tencent.mm.plugin.sight.decode.a.a aVar = ahVar.iWn;
                            int hashCode = this.kbV.aXH.hashCode();
                            int i5 = ahVar.position;
                            com.tencent.mm.storage.ak bvV2 = com.tencent.mm.storage.ak.bvV();
                            bvV2.hrm = com_tencent_mm_protocal_c_azr.hNS;
                            aSB.a(Bq, com_tencent_mm_protocal_c_aib, aVar, hashCode, i5, bvV2, qC);
                            if (qC) {
                                j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.PlayIcon, Bq);
                                return;
                            }
                            return;
                        }
                        com.tencent.mm.modelsns.a gh = this.kbV.scene == 0 ? com.tencent.mm.modelsns.a.gh(717) : com.tencent.mm.modelsns.a.gi(717);
                        gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32)).kj(Bq.aUR()).kj(com_tencent_mm_protocal_c_aib.gID);
                        gh.JF();
                        gh = this.kbV.scene == 0 ? com.tencent.mm.modelsns.a.gh(745) : com.tencent.mm.modelsns.a.gi(745);
                        gh.kj(i.g(Bq)).gk(Bq.field_type).bg(Bq.qC(32));
                        if (qC) {
                            int i6;
                            int i7 = this.kbV.scene == 0 ? 1 : 2;
                            String aUQ = Bq.aUQ();
                            int i8 = (Bq.qC(32) && Bq.aUm().jun) ? 21 : 17;
                            String str = "";
                            if (Bq.field_type == 1) {
                                i6 = 1;
                            } else {
                                i6 = 2;
                            }
                            ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(aUQ, i8, i7, str, i6), 0);
                            j.a(com.tencent.mm.plugin.sns.a.a.j.b.Sight, j.a.EnterFullScreen, Bq);
                        }
                        String str2 = "";
                        String cA = com.tencent.mm.plugin.sns.e.al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID);
                        String str3 = "";
                        String i9 = i.i(com_tencent_mm_protocal_c_aib);
                        if (FileOp.aR(cA + i9)) {
                            str2 = cA + i9;
                            str3 = cA + i.c(com_tencent_mm_protocal_c_aib);
                        }
                        if (FileOp.aR(cA + i.o(com_tencent_mm_protocal_c_aib))) {
                            str2 = cA + i.o(com_tencent_mm_protocal_c_aib);
                            str3 = cA + i.m(com_tencent_mm_protocal_c_aib);
                        }
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        com.tencent.mm.plugin.report.service.g.iuh.h(11444, new Object[]{Integer.valueOf(3)});
                        if (!qC) {
                            v.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
                            Intent intent = new Intent();
                            intent.setClass(this.kbV.aXH, SnsOnlineVideoActivity.class);
                            intent.putExtra("intent_videopath", str2);
                            intent.putExtra("intent_thumbpath", str3);
                            intent.putExtra("intent_localid", ahVar.bap);
                            intent.putExtra("intent_isad", qC);
                            intent.putExtra("intent_from_scene", this.kbV.scene);
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            gh.b(intent, "intent_key_StatisticsOplog");
                            this.kbV.aXH.startActivity(intent);
                            this.kbV.aXH.overridePendingTransition(0, 0);
                        } else if (Bq.qC(32) && Bq.aUm().jun && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Bm(Bq.aUS().field_adxml)) {
                            String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Bq);
                            if (!be.kS(w)) {
                                Bq.aUS().field_adxml = w;
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("img_gallery_left", iArr[0]);
                            intent2.putExtra("img_gallery_top", iArr[1]);
                            intent2.putExtra("img_gallery_width", width);
                            intent2.putExtra("img_gallery_height", height);
                            intent2.putExtra("sns_landing_pages_share_sns_id", Bq.aUq());
                            intent2.putExtra("sns_landing_pages_ux_info", Bq.aUR());
                            r2 = Bq.aUp();
                            if (r2 != null) {
                                List list = r2.mWq.mom;
                                if (list.size() > 0) {
                                    intent2.putExtra("sns_landing_pages_share_thumb_url", ((aib) list.get(0)).mHP);
                                }
                            }
                            intent2.setClass(this.kbV.aXH, SnsAdNativeLandingPagesUI.class);
                            intent2.putExtra("sns_landig_pages_from_source", this.kbV.scene == 0 ? 1 : 2);
                            intent2.putExtra("sns_landing_pages_xml", Bq.aUS().field_adxml);
                            intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                            intent2.putExtra("sns_landing_is_native_sight_ad", true);
                            this.kbV.aXH.startActivity(intent2);
                            this.kbV.aXH.overridePendingTransition(0, 0);
                        } else {
                            Intent intent3 = new Intent();
                            intent3.setClass(this.kbV.aXH, SnsSightPlayerUI.class);
                            intent3.putExtra("intent_videopath", str2);
                            intent3.putExtra("intent_thumbpath", str3);
                            intent3.putExtra("intent_localid", ahVar.bap);
                            intent3.putExtra("intent_isad", qC);
                            intent3.putExtra("intent_from_scene", this.kbV.scene);
                            intent3.putExtra("img_gallery_left", iArr[0]);
                            intent3.putExtra("img_gallery_top", iArr[1]);
                            intent3.putExtra("img_gallery_width", width);
                            intent3.putExtra("img_gallery_height", height);
                            gh.b(intent3, "intent_key_StatisticsOplog");
                            this.kbV.aXH.startActivity(intent3);
                            this.kbV.aXH.overridePendingTransition(0, 0);
                            final aib com_tencent_mm_protocal_c_aib2 = com_tencent_mm_protocal_c_aib;
                            final com.tencent.mm.plugin.sns.ui.ah ahVar2 = ahVar;
                            final k kVar = Bq;
                            final azr com_tencent_mm_protocal_c_azr2 = com_tencent_mm_protocal_c_azr;
                            final boolean z = qC;
                            new com.tencent.mm.sdk.platformtools.ac().postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass14 kcb;

                                public final void run() {
                                    if (ad.aSB().w(com_tencent_mm_protocal_c_aib2)) {
                                        ahVar2.iWn.ag(null, false);
                                        com.tencent.mm.plugin.sns.e.g aSB = ad.aSB();
                                        k kVar = kVar;
                                        aib com_tencent_mm_protocal_c_aib = com_tencent_mm_protocal_c_aib2;
                                        com.tencent.mm.plugin.sight.decode.a.a aVar = ahVar2.iWn;
                                        int hashCode = this.kcb.kbV.aXH.hashCode();
                                        int i = ahVar2.position;
                                        com.tencent.mm.storage.ak bvV = com.tencent.mm.storage.ak.bvV();
                                        bvV.hrm = com_tencent_mm_protocal_c_azr2.hNS;
                                        aSB.a(kVar, com_tencent_mm_protocal_c_aib, aVar, hashCode, i, bvV, z);
                                        ahVar2.jzs.setVisibility(0);
                                        ahVar2.jzr.setVisibility(8);
                                        ahVar2.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this.kcb.kbV.aXH, 2131165914));
                                    }
                                }
                            }, 500);
                            int[] iArr2 = new int[3];
                            if (!qC && ad.aSB().a(Bq, iArr2) > 5) {
                                ad.aSB().z(com_tencent_mm_protocal_c_aib);
                                i = 1;
                            } else if (!qC || ad.aSB().b(Bq, iArr2) <= 5) {
                                i = 2;
                            } else {
                                ad.aSB().z(com_tencent_mm_protocal_c_aib);
                                i = 1;
                            }
                            int i10 = iArr2[0];
                            int i11 = iArr2[1];
                            if (i == 2) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            width = iArr2[2];
                            r2 = Bq.aUp();
                            com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                            cVar.n("20FeedId", r2.gID + ",");
                            cVar.n("21AdUxInfo", Bq.aUR() + ",");
                            try {
                                awa com_tencent_mm_protocal_c_awa = (awa) new awa().az(Bq.field_attrBuf);
                                if (com_tencent_mm_protocal_c_awa.mTy != null) {
                                    awi com_tencent_mm_protocal_c_awi = (awi) new awi().az(com_tencent_mm_protocal_c_awa.mTy.mQw.lVU);
                                    if (com_tencent_mm_protocal_c_awi.mTL != null) {
                                        i3 = com_tencent_mm_protocal_c_awi.mTL.moW;
                                        try {
                                            i4 = com_tencent_mm_protocal_c_awi.mTL.moX;
                                        } catch (Exception e2) {
                                            e = e2;
                                            v.a("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                            i4 = 0;
                                            cVar.n("22LayerId", i3 + ",");
                                            cVar.n("23ExpId", i4 + ",");
                                            cVar.n("24ClickState", i + ",");
                                            cVar.n("25ClickTime", be.Nh() + ",");
                                            i4 = 0;
                                            if (!com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                                                i4 = 1;
                                            } else if (!com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext())) {
                                                i4 = 2;
                                            } else if (!com.tencent.mm.sdk.platformtools.ak.is3G(aa.getContext())) {
                                                i4 = 3;
                                            } else if (com.tencent.mm.sdk.platformtools.ak.is4G(aa.getContext())) {
                                                i4 = 4;
                                            }
                                            cVar.n("26NetworkType", i4 + ",");
                                            cVar.n("27IsFlowControl", i10 + ",");
                                            cVar.n("28AutoDownloadSetting", i11 + ",");
                                            cVar.n("29IsAutoPlay", i2 + ",");
                                            cVar.n("30IsFlowControlDatePeriod", width + ",");
                                            v.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + cVar.JH());
                                            com.tencent.mm.plugin.report.service.g.iuh.h(13323, new Object[]{cVar});
                                        }
                                        cVar.n("22LayerId", i3 + ",");
                                        cVar.n("23ExpId", i4 + ",");
                                        cVar.n("24ClickState", i + ",");
                                        cVar.n("25ClickTime", be.Nh() + ",");
                                        i4 = 0;
                                        if (!com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                                            i4 = 1;
                                        } else if (!com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext())) {
                                            i4 = 2;
                                        } else if (!com.tencent.mm.sdk.platformtools.ak.is3G(aa.getContext())) {
                                            i4 = 3;
                                        } else if (com.tencent.mm.sdk.platformtools.ak.is4G(aa.getContext())) {
                                            i4 = 4;
                                        }
                                        cVar.n("26NetworkType", i4 + ",");
                                        cVar.n("27IsFlowControl", i10 + ",");
                                        cVar.n("28AutoDownloadSetting", i11 + ",");
                                        cVar.n("29IsAutoPlay", i2 + ",");
                                        cVar.n("30IsFlowControlDatePeriod", width + ",");
                                        v.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + cVar.JH());
                                        com.tencent.mm.plugin.report.service.g.iuh.h(13323, new Object[]{cVar});
                                    }
                                }
                                i4 = 0;
                                i3 = 0;
                            } catch (Exception e3) {
                                e = e3;
                                i3 = 0;
                                v.a("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                i4 = 0;
                                cVar.n("22LayerId", i3 + ",");
                                cVar.n("23ExpId", i4 + ",");
                                cVar.n("24ClickState", i + ",");
                                cVar.n("25ClickTime", be.Nh() + ",");
                                i4 = 0;
                                if (!com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                                    i4 = 1;
                                } else if (!com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext())) {
                                    i4 = 2;
                                } else if (!com.tencent.mm.sdk.platformtools.ak.is3G(aa.getContext())) {
                                    i4 = 3;
                                } else if (com.tencent.mm.sdk.platformtools.ak.is4G(aa.getContext())) {
                                    i4 = 4;
                                }
                                cVar.n("26NetworkType", i4 + ",");
                                cVar.n("27IsFlowControl", i10 + ",");
                                cVar.n("28AutoDownloadSetting", i11 + ",");
                                cVar.n("29IsAutoPlay", i2 + ",");
                                cVar.n("30IsFlowControlDatePeriod", width + ",");
                                v.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + cVar.JH());
                                com.tencent.mm.plugin.report.service.g.iuh.h(13323, new Object[]{cVar});
                            }
                            cVar.n("22LayerId", i3 + ",");
                            cVar.n("23ExpId", i4 + ",");
                            cVar.n("24ClickState", i + ",");
                            cVar.n("25ClickTime", be.Nh() + ",");
                            i4 = 0;
                            if (!com.tencent.mm.sdk.platformtools.ak.isWifi(aa.getContext())) {
                                i4 = 1;
                            } else if (!com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext())) {
                                i4 = 2;
                            } else if (!com.tencent.mm.sdk.platformtools.ak.is3G(aa.getContext())) {
                                i4 = 3;
                            } else if (com.tencent.mm.sdk.platformtools.ak.is4G(aa.getContext())) {
                                i4 = 4;
                            }
                            cVar.n("26NetworkType", i4 + ",");
                            cVar.n("27IsFlowControl", i10 + ",");
                            cVar.n("28AutoDownloadSetting", i11 + ",");
                            cVar.n("29IsAutoPlay", i2 + ",");
                            cVar.n("30IsFlowControlDatePeriod", width + ",");
                            v.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + cVar.JH());
                            com.tencent.mm.plugin.report.service.g.iuh.h(13323, new Object[]{cVar});
                        }
                    }
                }
            }
        };
        this.kbL = new c(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ah) {
                    int i;
                    cp cpVar;
                    com.tencent.mm.plugin.sns.ui.ah ahVar = (com.tencent.mm.plugin.sns.ui.ah) view.getTag();
                    if (!ahVar.jdE) {
                        contextMenu.add(0, 19, 0, this.kbV.aXH.getString(2131231833));
                    }
                    if (be.KL(com.tencent.mm.h.j.sU().getValue("SIGHTCannotTransmitForFav")) == 0) {
                        aib com_tencent_mm_protocal_c_aib = (aib) ahVar.jKk.mWq.mom.get(0);
                        String str = com.tencent.mm.plugin.sns.e.al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.c(com_tencent_mm_protocal_c_aib);
                        String a = an.a(ahVar.bap, com_tencent_mm_protocal_c_aib);
                        v.i("MicroMsg.TimelineOnCreateContextMenuListener", "config can forward sight, thumb existed %B, video existed %B", new Object[]{Boolean.valueOf(FileOp.aR(str)), Boolean.valueOf(FileOp.aR(a))});
                        if (FileOp.aR(str) && r1) {
                            i = 1;
                            if (com.tencent.mm.ay.c.EH("favorite")) {
                                contextMenu.add(0, 10, 0, this.kbV.aXH.getString(2131234180));
                            }
                            if (i != 0) {
                                cpVar = new cp();
                                cpVar.bay.bap = ahVar.bap;
                                com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                                if (cpVar.baz.aZW) {
                                    contextMenu.add(0, 18, 0, this.kbV.aXH.getString(2131231834));
                                }
                            }
                        }
                    }
                    i = 0;
                    if (com.tencent.mm.ay.c.EH("favorite")) {
                        contextMenu.add(0, 10, 0, this.kbV.aXH.getString(2131234180));
                    }
                    if (i != 0) {
                        cpVar = new cp();
                        cpVar.bay.bap = ahVar.bap;
                        com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                        if (cpVar.baz.aZW) {
                            contextMenu.add(0, 18, 0, this.kbV.aXH.getString(2131231834));
                        }
                    }
                }
            }

            public final boolean cm(View view) {
                if (!(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ah)) {
                    return false;
                }
                String str = ((com.tencent.mm.plugin.sns.ui.ah) view.getTag()).bap;
                this.kbV.kbv.a(view, str, ad.aSE().Bq(str).aUp());
                return true;
            }
        };
        this.kbS = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                int i = 1;
                this.kbV.ci(view);
                if (view.getTag() != null && (view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
                    k Bq = ad.aSE().Bq(((com.tencent.mm.plugin.sns.data.b) view.getTag()).bap);
                    if (Bq != null && Bq.qC(32)) {
                        int i2;
                        String aUQ = Bq.aUQ();
                        if (this.kbV.scene == 0) {
                            i2 = 1;
                        } else {
                            i2 = 2;
                        }
                        String str = "";
                        if (Bq.field_type != 1) {
                            i = 2;
                        }
                        ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(aUQ, 20, i2, str, i), 0);
                    }
                }
            }
        };
        this.kbG = new OnClickListener(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void onClick(View view) {
                v.i("MicroMsg.TimelineClickListener", "unlike click");
                this.kbV.aVw();
                k Bq = ad.aSE().Bq(((com.tencent.mm.plugin.sns.data.b) view.getTag()).bap);
                if (Bq != null) {
                    if (Bq.qC(32)) {
                        com.tencent.mm.plugin.sns.storage.a aUo = Bq.aUo();
                        String str = aUo == null ? "" : aUo.jbF;
                        com.tencent.mm.plugin.report.service.g.iuh.h(11855, new Object[]{Integer.valueOf(1), Integer.valueOf(3), str});
                    }
                    ak.vy().a(new com.tencent.mm.plugin.sns.e.p(Bq.field_snsId, 8), 0);
                }
            }
        };
        this.kbM = new c(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final boolean cm(View view) {
                Object tag = view.getTag();
                if (!(tag instanceof p)) {
                    return false;
                }
                p pVar = (p) tag;
                azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                if (com_tencent_mm_protocal_c_azr.mWq.mol == 10 || com_tencent_mm_protocal_c_azr.mWq.mol == 17 || com_tencent_mm_protocal_c_azr.mWq.mol == 22 || com_tencent_mm_protocal_c_azr.mWq.mol == 23) {
                    return false;
                }
                this.kbV.kbv.a(view, pVar.bap, com_tencent_mm_protocal_c_azr);
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if (tag instanceof p) {
                    p pVar = (p) tag;
                    azr com_tencent_mm_protocal_c_azr = pVar.jFh;
                    if (com.tencent.mm.ay.c.EH("favorite")) {
                        cp cpVar;
                        switch (com_tencent_mm_protocal_c_azr.mWq.mol) {
                            case 3:
                                contextMenu.add(0, 3, 0, view.getContext().getString(2131234180));
                                cpVar = new cp();
                                cpVar.bay.bap = pVar.bap;
                                com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                                if (cpVar.baz.aZW) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(2131231834));
                                    break;
                                }
                                break;
                            case 4:
                                contextMenu.add(0, 4, 0, view.getContext().getString(2131234180));
                                cpVar = new cp();
                                cpVar.bay.bap = pVar.bap;
                                com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                                if (cpVar.baz.aZW) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(2131231834));
                                    break;
                                }
                                break;
                            case 9:
                                contextMenu.add(0, 5, 0, view.getContext().getString(2131234180));
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.an.CTRL_INDEX /*14*/:
                                contextMenu.add(0, 9, 0, view.getContext().getString(2131234180));
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.am.CTRL_INDEX /*15*/:
                                contextMenu.add(0, 10, 0, view.getContext().getString(2131234180));
                                break;
                            default:
                                contextMenu.add(0, 3, 0, view.getContext().getString(2131234180));
                                break;
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, ad.aSE().Bq(pVar.bap));
                }
            }
        };
        this.kbm = new e(this) {
            final /* synthetic */ b kbV;

            {
                this.kbV = r1;
            }

            public final void d(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                if (bVar != null && i == 0) {
                    View view = bVar.iTT != null ? (View) bVar.iTT.get() : null;
                    if (view != null && (view instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view;
                        aVar.aOV();
                        if (aVar.aOY() != null && (aVar.aOY() instanceof com.tencent.mm.plugin.sns.ui.ah)) {
                            aVar.aOY();
                        }
                    }
                }
            }
        };
    }

    public final void aYq() {
        ak.vy().a(218, this.kbv);
    }

    public final void afF() {
        ak.vy().b(218, this.kbv);
    }
}
