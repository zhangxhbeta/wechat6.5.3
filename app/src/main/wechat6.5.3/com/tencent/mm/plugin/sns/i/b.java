package com.tencent.mm.plugin.sns.i;

import com.tencent.mm.e.a.oc;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.pu;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    int bYL;
    c bYn;
    public int eyU;
    public boolean jrH;
    public long jrI;
    public long jrJ;
    public int jrK;
    int jrL;
    int jrM;
    int jrN;
    public int jrO;
    public int jrP;
    int jrQ;
    public int jrR;
    public int jrS;
    int jrT;
    public int jrU;
    public int jrV;
    public String jrW;
    public String jrX;
    String jrY;
    int jrZ;
    long jsA;
    long jsB;
    long jsC;
    long jsD;
    long jsE;
    long jsF;
    long jsG;
    long jsH;
    long jsI;
    long jsJ;
    long jsK;
    long jsL;
    long jsM;
    long jsN;
    long jsO;
    long jsP;
    long jsQ;
    long jsR;
    long jsS;
    long jsT;
    long jsU;
    long jsV;
    String jsW;
    int jsX;
    long jsY;
    private long jsZ;
    public int jsa;
    public int jsb;
    public int jsc;
    public int jsd;
    public int jse;
    public int jsf;
    public int jsg;
    public int jsh;
    int jsi;
    int jsj;
    int jsk;
    int jsl;
    int jsm;
    int jsn;
    public int jso;
    public int jsp;
    int jsq;
    int jsr;
    public long jss;
    public long jst;
    long jsu;
    long jsv;
    long jsw;
    long jsx;
    long jsy;
    long jsz;
    public HashSet<String> jtA;
    public HashSet<String> jtB;
    public HashSet<String> jtC;
    public HashSet<String> jtD;
    public long jtE;
    long jta;
    private long jtb;
    private HashSet<String> jtc;
    HashSet<String> jtd;
    public HashSet<String> jte;
    HashSet<String> jtf;
    public HashSet<String> jtg;
    HashSet<String> jth;
    HashSet<String> jti;
    public HashSet<String> jtj;
    public HashSet<String> jtk;
    HashSet<String> jtl;
    public HashSet<String> jtm;
    private HashSet<String> jtn;
    public HashSet<String> jto;
    public HashSet<String> jtp;
    public int jtq;
    public int jtr;
    public HashSet<String> jts;
    public HashSet<String> jtt;
    public HashSet<String> jtu;
    public HashSet<String> jtv;
    public HashSet<String> jtw;
    public HashSet<String> jtx;
    public HashSet<String> jty;
    public HashSet<String> jtz;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ b jtF;
        final /* synthetic */ int jtG;

        public AnonymousClass2(b bVar, int i) {
            this.jtF = bVar;
            this.jtG = i;
        }

        public final void run() {
            b bVar = this.jtF;
            int i = this.jtG;
            if (i != -1) {
                k qg = ah.qg(i);
                if (qg != null) {
                    String g = i.g(qg);
                    bVar.jrY = g;
                    pu aUA = ad.aSG().Bu("@__weixintimtline").aUA();
                    if (aUA.mrG == 0 || i.cF(aUA.mrG).compareTo(g) <= 0) {
                        bVar.gj(false);
                    } else {
                        bVar.gj(true);
                    }
                }
            }
            i = m.yw();
            com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
            cVar.n("20BrowseTime", bVar.jrJ + ",");
            cVar.n("21BrowseFeedCount", bVar.jrK + ",");
            cVar.n("22CommentOrLikeFeedCount", bVar.jrL + ",");
            cVar.n("23ClickFeedCount", bVar.jrM + ",");
            cVar.n("24ClickAlbumCount", bVar.jrN + ",");
            cVar.n("25PostFeedCount", bVar.jrO + ",");
            cVar.n("26ExposeFeedCount", bVar.jte.size() + ",");
            cVar.n("27FavFeedCount", bVar.jtf.size() + ",");
            cVar.n("28BlackListFriendCount", bVar.jrR + ",");
            cVar.n("29OutsiderFriendCount", bVar.jrS + ",");
            cVar.n("30BrowseNewFeedCount", bVar.jrT + ",");
            cVar.n("31HasNewSnsMsgWhenEntrance", bVar.jrU + ",");
            cVar.n("32HasNewChatMsgWhenExit", bVar.jrV + ",");
            cVar.n("33StartBrowseSnsObjectId", bVar.jrW + ",");
            cVar.n("34EndBrowseSnsObjectId", bVar.jrX + ",");
            cVar.n("35NextBrowseSnsObjectId", bVar.jrY + ",");
            cVar.n("36HasNewFeedInServer", bVar.jrZ + ",");
            cVar.n("37BrowseBrandUrlFeedCount", bVar.jsa + ",");
            cVar.n("38BrowseNotBrandUrlFeedCount", bVar.jsb + ",");
            cVar.n("39BrowseTextFeedCount", bVar.jsc + ",");
            cVar.n("40BrowseImageFeedCount", bVar.jsd + ",");
            cVar.n("41BrowseSightFeedCount", bVar.jse + ",");
            cVar.n("42BrowseAdFeedCount", bVar.jsf + ",");
            cVar.n("43BrowseMusicFeedCount", bVar.jsg + ",");
            cVar.n("44contactCount", i + ",");
            cVar.n("BrowseVideoFeedCount45", bVar.jsh + ",");
            cVar.n("ClickBrandUrlFeedCount46", bVar.jsi + ",");
            cVar.n("ClickNotBrandUrlFeedCount47", bVar.jsj + ",");
            cVar.n("ClickImageFeedCount48", bVar.jsk + ",");
            cVar.n("ClickSightFeedCount49", bVar.jsl + ",");
            cVar.n("ClickMusicFeedCount50", bVar.jsm + ",");
            cVar.n("ClickVideoFeedCount51", bVar.jsn + ",");
            cVar.n("BrowseOtherFeedCount52", bVar.jso + ",");
            cVar.n("BrowserStreamVideoFeedCount53", bVar.jsp + ",");
            cVar.n("ClickStreamVideoCount54", bVar.jsq + ",");
            cVar.n("ClickAdFeed55", bVar.jsr + ",");
            cVar.n("56BackGroundTime", bVar.jss + ",");
            cVar.n("57BrowseTimeLineTime", bVar.jsu + ",");
            cVar.n("58BrowseMyAlbumTime", bVar.jsw + ",");
            cVar.n("59BrowseOtherAlbumTime", bVar.jsy + ",");
            cVar.n("60BrowseMessageListTime", bVar.jsA + ",");
            cVar.n("61ClickNewPostTime", bVar.jsC + ",");
            cVar.n("62BrowseFullScreenImageTime", bVar.jsE + ",");
            cVar.n("63BrowseFullScreenSightTime", bVar.jsG + ",");
            cVar.n("64BrowseMPArticleTime", bVar.jsI + ",");
            cVar.n("65BrowseExternalArticleTime", bVar.jsK + ",");
            cVar.n("66BrowseFullScreenAdImageTime", bVar.jsM + ",");
            cVar.n("67BrowseAdSightTime", "0,");
            cVar.n("68BrowseAdDetailTime", bVar.jsO + ",");
            cVar.n("69BrowseFullScreenAdSightTime", bVar.jsQ + ",");
            cVar.n("70BrowseFullScreenAdLongVideoTime", bVar.jsS + ",");
            cVar.n("71BrowseForwardAdLongVideoTime", bVar.jsU + ",");
            cVar.n("72StartBrowseTime", bVar.jtE + ",");
            cVar.n("73ClickFeedIdList", b.d(bVar.jtd) + ",");
            cVar.n("74ExposeFeedIdList", b.d(bVar.jte) + ",");
            cVar.n("75FavFeedIdList", b.d(bVar.jtf) + ",");
            cVar.n("76ClickAlbumUserList", b.d(bVar.jtl) + ",");
            cVar.n("77ForwardFeedIdList", b.d(bVar.jtg) + ",");
            cVar.n("78ClickAvatarFeedIdList", b.d(bVar.jth) + ",");
            cVar.n("79ClickNickNameFeedIdList", b.d(bVar.jti) + ",");
            cVar.n("80ForwardToSingleChatFeedIdList", b.d(bVar.jtj) + ",");
            cVar.n("81ForwardToChatRoomFeedIdList", b.d(bVar.jtk) + ",");
            cVar.n("82FeedUpdateNotification", bVar.bYL + ",");
            cVar.n("83abandon", ",");
            cVar.n("84abandon", ",");
            cVar.n("85LastestUnReadFeedId", bVar.jsW + ",");
            cVar.n("86UnReadMsgCount", bVar.jsX + ",");
            cVar.n("87BrowseAdCanvasPageTime", bVar.jsY + ",");
            cVar.n("88BrowseForwardAdCanvasTime", bVar.jta + ",");
            v.v("MicroMsg.SnsBrowseInfoHelper", "report logbuffer(12076): " + cVar.JH());
            g.iuh.h(12076, new Object[]{cVar});
            a.nhr.f(bVar.bYn);
            bVar.jrJ = 0;
            bVar.jrK = 0;
            bVar.jrL = 0;
            bVar.jrM = 0;
            bVar.jrN = 0;
            bVar.jrO = 0;
            bVar.jrP = 0;
            bVar.jrQ = 0;
            bVar.jrR = 0;
            bVar.jrS = 0;
            bVar.jrT = 0;
            bVar.jrU = 0;
            bVar.jrV = 0;
            bVar.jrW = "";
            bVar.jrX = "";
            bVar.jrY = "";
            bVar.jrZ = 0;
            bVar.jsa = 0;
            bVar.jsb = 0;
            bVar.jsc = 0;
            bVar.jsd = 0;
            bVar.jse = 0;
            bVar.jsf = 0;
            bVar.jsg = 0;
            bVar.eyU = 0;
            bVar.jsh = 0;
            bVar.jsi = 0;
            bVar.jsj = 0;
            bVar.jsk = 0;
            bVar.jsl = 0;
            bVar.jsm = 0;
            bVar.jsn = 0;
            bVar.jso = 0;
            bVar.jsp = 0;
            bVar.jsq = 0;
            bVar.jsr = 0;
            bVar.jss = 0;
            bVar.jst = 0;
            bVar.jsu = 0;
            bVar.jsv = 0;
            bVar.jsw = 0;
            bVar.jsx = 0;
            bVar.jsy = 0;
            bVar.jsz = 0;
            bVar.jsA = 0;
            bVar.jsB = 0;
            bVar.jsC = 0;
            bVar.jsD = 0;
            bVar.jsE = 0;
            bVar.jsF = 0;
            bVar.jsG = 0;
            bVar.jsH = 0;
            bVar.jsI = 0;
            bVar.jsJ = 0;
            bVar.jsK = 0;
            bVar.jsL = 0;
            bVar.jsM = 0;
            bVar.jsN = 0;
            bVar.jsO = 0;
            bVar.jsP = 0;
            bVar.jsQ = 0;
            bVar.jsR = 0;
            bVar.jsS = 0;
            bVar.jsT = 0;
            bVar.jsU = 0;
            bVar.jsV = 0;
            bVar.jtd.clear();
            bVar.jte.clear();
            bVar.jtf.clear();
            bVar.jtg.clear();
            bVar.jth.clear();
            bVar.jti.clear();
            bVar.jtj.clear();
            bVar.jtk.clear();
            bVar.bYL = 0;
            bVar.jsW = "";
            bVar.jsX = 0;
        }
    }

    public final void u(k kVar) {
        if (kVar != null) {
            this.jtc.add(kVar.aUL());
            this.jrL = this.jtc.size();
        }
    }

    public final void v(k kVar) {
        if (kVar != null) {
            String aUL = kVar.aUL();
            String g = i.g(kVar);
            if (!this.jtd.contains(g)) {
                v.i("MicroMsg.SnsBrowseInfoHelper", "onClickFeed localId:Td, snsId:%s", new Object[]{aUL, g});
                this.jrM++;
                this.jtd.add(g);
                if (kVar.qC(32)) {
                    this.jsr++;
                }
                switch (kVar.field_type) {
                    case 1:
                        this.jsk++;
                        break;
                    case 3:
                        if (!be.kS(kVar.aUp().mWr)) {
                            this.jsi++;
                            break;
                        } else {
                            this.jsj++;
                            break;
                        }
                    case 4:
                        this.jsm++;
                        break;
                    case 5:
                        this.jsn++;
                        break;
                    case am.CTRL_INDEX /*15*/:
                        this.jsl++;
                        break;
                    case 18:
                        this.jsq++;
                        break;
                }
                if (kVar.qC(32)) {
                    if (kVar.aUm() != null && kVar.aUm().jun) {
                        ga(true);
                    } else if (kVar.field_type == 1) {
                        gf(true);
                    } else if (kVar.field_type == 15) {
                        gg(true);
                    }
                } else if (kVar.aUp() == null || be.kS(kVar.aUp().jYp)) {
                    switch (kVar.field_type) {
                        case 1:
                            fZ(true);
                            return;
                        case 3:
                            if (be.kS(kVar.aUp().mWr)) {
                                ge(true);
                                return;
                            } else {
                                gd(true);
                                return;
                            }
                        case 4:
                            ge(true);
                            return;
                        case 5:
                            ge(true);
                            return;
                        case am.CTRL_INDEX /*15*/:
                            gc(true);
                            return;
                        case 18:
                            gi(true);
                            return;
                        default:
                            return;
                    }
                } else {
                    gb(true);
                }
            }
        }
    }

    public final void a(k kVar, boolean z) {
        if (kVar != null) {
            if (z) {
                this.jth.add(i.g(kVar));
            } else {
                this.jti.add(i.g(kVar));
            }
            this.jtl.add(kVar.field_userName);
            this.jrN = this.jtl.size();
            if (ad.aSk().equals(kVar.field_userName)) {
                fV(true);
            } else {
                fW(true);
            }
        }
    }

    public final void cH(String str, String str2) {
        this.jtf.add(str2);
        this.jtn.add(str);
        this.jrQ = this.jtn.size();
    }

    public final void fU(boolean z) {
        if (z) {
            this.jsv = System.currentTimeMillis();
        } else if (this.jsv > 0) {
            this.jsu += System.currentTimeMillis() - this.jsv;
            this.jsv = 0;
        }
    }

    public final void fV(boolean z) {
        if (z) {
            this.jsx = System.currentTimeMillis();
        } else if (this.jsx > 0) {
            this.jsw += System.currentTimeMillis() - this.jsx;
            this.jsx = 0;
        }
    }

    public final void fW(boolean z) {
        if (z) {
            this.jsz = System.currentTimeMillis();
        } else if (this.jsz > 0) {
            this.jsy += System.currentTimeMillis() - this.jsz;
            this.jsz = 0;
        }
    }

    public final void fX(boolean z) {
        if (z) {
            this.jsB = System.currentTimeMillis();
        } else if (this.jsB > 0) {
            this.jsA += System.currentTimeMillis() - this.jsB;
            this.jsB = 0;
        }
    }

    public final void fY(boolean z) {
        if (z) {
            this.jsD = System.currentTimeMillis();
        } else if (this.jsD > 0) {
            this.jsC += System.currentTimeMillis() - this.jsD;
            this.jsD = 0;
        }
    }

    public final void fZ(boolean z) {
        if (z) {
            this.jsF = System.currentTimeMillis();
        } else if (this.jsF > 0) {
            this.jsE += System.currentTimeMillis() - this.jsF;
            this.jsF = 0;
        }
    }

    public final void ga(boolean z) {
        if (z) {
            this.jsZ = System.currentTimeMillis();
        } else if (this.jsZ > 0) {
            this.jsY += System.currentTimeMillis() - this.jsZ;
            this.jsZ = 0;
        }
    }

    public final void gb(boolean z) {
        if (z) {
            this.jtb = System.currentTimeMillis();
        } else if (this.jtb > 0) {
            this.jta += System.currentTimeMillis() - this.jtb;
            this.jtb = 0;
        }
    }

    public final void gc(boolean z) {
        if (z) {
            this.jsH = System.currentTimeMillis();
        } else if (this.jsH > 0) {
            this.jsG += System.currentTimeMillis() - this.jsH;
            this.jsH = 0;
        }
    }

    public final void gd(boolean z) {
        if (z) {
            this.jsJ = System.currentTimeMillis();
        } else if (this.jsJ > 0) {
            this.jsI += System.currentTimeMillis() - this.jsJ;
            this.jsJ = 0;
        }
    }

    public final void ge(boolean z) {
        if (z) {
            this.jsL = System.currentTimeMillis();
        } else if (this.jsL > 0) {
            this.jsK += System.currentTimeMillis() - this.jsL;
            this.jsL = 0;
        }
    }

    public final void gf(boolean z) {
        if (z) {
            this.jsN = System.currentTimeMillis();
        } else if (this.jsN > 0) {
            this.jsM += System.currentTimeMillis() - this.jsN;
            this.jsN = 0;
        }
    }

    public final void gg(boolean z) {
        if (z) {
            this.jsR = System.currentTimeMillis();
        } else if (this.jsR > 0) {
            this.jsQ += System.currentTimeMillis() - this.jsR;
            this.jsR = 0;
        }
    }

    public final void gh(boolean z) {
        if (z) {
            this.jsT = System.currentTimeMillis();
        } else if (this.jsT > 0) {
            this.jsS += System.currentTimeMillis() - this.jsT;
            this.jsT = 0;
        }
    }

    public final void gi(boolean z) {
        if (z) {
            this.jsV = System.currentTimeMillis();
        } else if (this.jsV > 0) {
            this.jsU += System.currentTimeMillis() - this.jsV;
            this.jsV = 0;
        }
    }

    public final void gj(boolean z) {
        this.jrZ = z ? 1 : 0;
    }

    public b() {
        this.jrH = false;
        this.jrI = -1;
        this.jrJ = 0;
        this.jrK = 0;
        this.jrL = 0;
        this.jrM = 0;
        this.jrN = 0;
        this.jrO = 0;
        this.jrP = 0;
        this.jrQ = 0;
        this.jrR = 0;
        this.jrS = 0;
        this.jrT = 0;
        this.jrU = 0;
        this.jrV = 0;
        this.jrW = "";
        this.jrX = "";
        this.jrY = "";
        this.jsa = 0;
        this.jsb = 0;
        this.jsc = 0;
        this.jsd = 0;
        this.jse = 0;
        this.jsf = 0;
        this.jsg = 0;
        this.eyU = 0;
        this.jsh = 0;
        this.jsi = 0;
        this.jsj = 0;
        this.jsk = 0;
        this.jsl = 0;
        this.jsm = 0;
        this.jsn = 0;
        this.jso = 0;
        this.jsp = 0;
        this.jsq = 0;
        this.jsr = 0;
        this.jss = 0;
        this.jst = 0;
        this.jsu = 0;
        this.jsv = 0;
        this.jsw = 0;
        this.jsx = 0;
        this.jsy = 0;
        this.jsz = 0;
        this.jsA = 0;
        this.jsB = 0;
        this.jsC = 0;
        this.jsD = 0;
        this.jsE = 0;
        this.jsF = 0;
        this.jsG = 0;
        this.jsH = 0;
        this.jsI = 0;
        this.jsJ = 0;
        this.jsK = 0;
        this.jsL = 0;
        this.jsM = 0;
        this.jsN = 0;
        this.jsO = 0;
        this.jsP = 0;
        this.jsQ = 0;
        this.jsR = 0;
        this.jsS = 0;
        this.jsT = 0;
        this.jsU = 0;
        this.jsV = 0;
        this.jsY = 0;
        this.jsZ = 0;
        this.jta = 0;
        this.jtb = 0;
        this.jtc = new HashSet();
        this.jtd = new HashSet();
        this.jte = new HashSet();
        this.jtf = new HashSet();
        this.jtg = new HashSet();
        this.jth = new HashSet();
        this.jti = new HashSet();
        this.jtj = new HashSet();
        this.jtk = new HashSet();
        this.jtl = new HashSet();
        this.jtm = new HashSet();
        this.jtn = new HashSet();
        this.jto = new HashSet();
        this.jtp = new HashSet();
        this.jtq = Integer.MAX_VALUE;
        this.jtr = 0;
        this.jts = new HashSet();
        this.jtt = new HashSet();
        this.jtu = new HashSet();
        this.jtv = new HashSet();
        this.jtw = new HashSet();
        this.jtx = new HashSet();
        this.jty = new HashSet();
        this.jtz = new HashSet();
        this.jtA = new HashSet();
        this.jtB = new HashSet();
        this.jtC = new HashSet();
        this.jtD = new HashSet();
        this.bYn = new c<oc>(this) {
            final /* synthetic */ b jtF;

            {
                this.jtF = r2;
                this.nhz = oc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                oc ocVar = (oc) bVar;
                if (ocVar instanceof oc) {
                    v.i("MicroMsg.SnsBrowseInfoHelper", "IListener callback " + this.jtF.jrI);
                    if (this.jtF.jrI != -1 && this.jtF.jrI < 0) {
                        Iterator it = ocVar.bpd.bpe.iterator();
                        while (it.hasNext()) {
                            if (((Long) it.next()).longValue() > this.jtF.jrI) {
                                b bVar2 = this.jtF;
                                bVar2.jrT++;
                            }
                        }
                    }
                }
                return false;
            }
        };
        this.jtE = 0;
        a.nhr.e(this.bYn);
    }

    public b(int i, String str, int i2) {
        this();
        this.bYL = i;
        this.jsW = str;
        this.jsX = i2;
    }

    static String d(HashSet<String> hashSet) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = hashSet.iterator();
        Object obj = 1;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (obj != null) {
                stringBuffer.append(str);
                obj = null;
            } else {
                stringBuffer.append("|" + str);
            }
        }
        return stringBuffer.toString();
    }
}
