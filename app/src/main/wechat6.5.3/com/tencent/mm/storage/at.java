package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.a.a.k;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.a.kp;
import com.tencent.mm.e.a.ms;
import com.tencent.mm.e.a.mu;
import com.tencent.mm.h.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.q.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;
import junit.framework.Assert;

public final class at extends f {
    public static String nvB = "voip_content_voice";
    public static String nvC = "voip_content_video";
    public boolean nvD = false;
    private String nvE;

    public static final class a {
        private String aHM = SQLiteDatabase.KeyEmpty;
        public int bBZ;
        public String bCj;
        private String bCk;
        private String bCl;
        public String bCp = SQLiteDatabase.KeyEmpty;
        private String bCq = SQLiteDatabase.KeyEmpty;
        public String bLc = SQLiteDatabase.KeyEmpty;
        public String cID = SQLiteDatabase.KeyEmpty;
        public String cIE = SQLiteDatabase.KeyEmpty;
        public String cIF = SQLiteDatabase.KeyEmpty;
        public String cIG = SQLiteDatabase.KeyEmpty;
        public String cIJ = SQLiteDatabase.KeyEmpty;
        public String hUf = SQLiteDatabase.KeyEmpty;
        public long hWq = 0;
        public String hWt = SQLiteDatabase.KeyEmpty;
        public String lct = SQLiteDatabase.KeyEmpty;
        public int ldy = 0;
        public int nvF = 0;
        public String nvG = SQLiteDatabase.KeyEmpty;
        public String nvH = SQLiteDatabase.KeyEmpty;
        public String nvI = SQLiteDatabase.KeyEmpty;
        public String nvJ = SQLiteDatabase.KeyEmpty;
        public int scene = 0;

        private a() {
        }

        public static a My(String str) {
            a aVar = new a();
            String trim = be.ah(str, SQLiteDatabase.KeyEmpty).trim();
            if (!trim.startsWith("<")) {
                int indexOf = trim.indexOf(":");
                if (indexOf != -1) {
                    trim = trim.substring(indexOf + 1);
                }
            }
            Map q = bf.q(trim, "msg");
            if (q != null) {
                try {
                    if (q.get(".msg.$fromusername") == null) {
                        aVar.lct = (String) q.get(".msg.$username");
                    } else {
                        aVar.lct = (String) q.get(".msg.$fromusername");
                    }
                    if (q.get(".msg.$fromnickname") == null) {
                        aVar.cID = (String) q.get(".msg.$nickname");
                    } else {
                        aVar.cID = (String) q.get(".msg.$fromnickname");
                    }
                    aVar.bLc = (String) q.get(".msg.$alias");
                    aVar.cIF = (String) q.get(".msg.$fullpy");
                    aVar.cIE = (String) q.get(".msg.$shortpy");
                    aVar.aHM = (String) q.get(".msg.$source");
                    aVar.nvF = Integer.valueOf((String) q.get(".msg.$imagestatus")).intValue();
                    aVar.scene = Integer.valueOf((String) q.get(".msg.$scene")).intValue();
                    aVar.nvG = (String) q.get(".msg.$mobileidentify");
                    aVar.nvH = (String) q.get(".msg.$mobilelongidentify");
                    if (q.get(".msg.$qqnum") != null && ((String) q.get(".msg.$qqnum")).length() > 0) {
                        aVar.hWq = Long.valueOf((String) q.get(".msg.$qqnum")).longValue();
                    }
                    aVar.bCj = (String) q.get(".msg.$sign");
                    if (q.get(".msg.$sex") != null && ((String) q.get(".msg.$sex")).length() > 0) {
                        aVar.bBZ = Integer.valueOf((String) q.get(".msg.$sex")).intValue();
                    }
                    aVar.bCl = (String) q.get(".msg.$city");
                    aVar.bCk = (String) q.get(".msg.$province");
                    aVar.cIG = (String) q.get(".msg.$qqnickname");
                    aVar.cIJ = (String) q.get(".msg.$qqremark");
                    aVar.ldy = Integer.valueOf(TextUtils.isEmpty((CharSequence) q.get(".msg.$certflag")) ? "0" : (String) q.get(".msg.$certflag")).intValue();
                    aVar.bCp = be.ma((String) q.get(".msg.$certinfo"));
                    aVar.hUf = be.ma((String) q.get(".msg.$brandIconUrl"));
                    aVar.bCq = be.ma((String) q.get(".msg.$regionCode"));
                    aVar.nvI = be.ma((String) q.get(".msg.$bigheadimgurl"));
                    aVar.nvJ = be.ma((String) q.get(".msg.$smallheadimgurl"));
                    aVar.hWt = be.ma((String) q.get(".msg.$googlecontact"));
                    v.d("MicroMsg.MsgInfo", "dkavatar FriendContent user:[%s] big:[%s] sm:[%s]", aVar.lct, aVar.nvI, aVar.nvJ);
                } catch (Throwable e) {
                    v.e("MicroMsg.MsgInfo", "exception:%s", be.e(e));
                }
            }
            return aVar;
        }

        public final String bwE() {
            return this.lct;
        }

        public final String getDisplayName() {
            if (!TextUtils.isEmpty(this.cID)) {
                return this.cID;
            }
            if (!TextUtils.isEmpty(this.bLc)) {
                return this.bLc;
            }
            v.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return be.ma(this.lct);
        }

        public final int bwF() {
            return this.scene;
        }

        public final String bwG() {
            return this.nvG;
        }

        public final long bwH() {
            return this.hWq;
        }

        public final String bwI() {
            if (this.cIJ != null && this.cIJ.length() > 0) {
                return this.cIJ;
            }
            if (this.cIG == null || this.cIG.length() <= 0) {
                return Long.toString(this.hWq);
            }
            return this.cIG;
        }

        public final String bwJ() {
            return this.nvH;
        }

        public final String getCity() {
            if (!be.kS(this.bCq)) {
                String[] split = this.bCq.split("_");
                if (split.length > 0) {
                    if (split.length > 2) {
                        this.bCl = RegionCodeDecoder.bxc().Z(split[0], split[1], split[2]);
                    } else if (split.length == 2) {
                        this.bCl = RegionCodeDecoder.bxc().dP(split[0], split[1]);
                    } else {
                        this.bCl = SQLiteDatabase.KeyEmpty;
                    }
                }
            }
            return this.bCl;
        }

        public final String getProvince() {
            if (!be.kS(this.bCq)) {
                String[] split = this.bCq.split("_");
                if (split.length > 0) {
                    if (split.length <= 2 || !RegionCodeDecoder.Nn(split[0])) {
                        this.bCk = RegionCodeDecoder.bxc().No(split[0]);
                    } else {
                        this.bCk = RegionCodeDecoder.bxc().dP(split[0], split[1]);
                    }
                }
            }
            return this.bCk;
        }

        public final int bwK() {
            return this.ldy;
        }
    }

    public static final class b {
        public int bhu = 0;
        public double gRK = 0.0d;
        public double gRL = 0.0d;
        public String gUr = SQLiteDatabase.KeyEmpty;
        public String label = SQLiteDatabase.KeyEmpty;
        public String lct = SQLiteDatabase.KeyEmpty;
        public String lyO = SQLiteDatabase.KeyEmpty;
        public String nvK = SQLiteDatabase.KeyEmpty;
        public String nvL = null;
        public String nvM = null;
        public String nvN = null;

        public final String toString() {
            return String.format("%d-%d-%d", new Object[]{Integer.valueOf((int) (this.gRK * 1000000.0d)), Integer.valueOf((int) (this.gRL * 1000000.0d)), Integer.valueOf(this.bhu)});
        }

        public final String bwL() {
            return this.gUr;
        }

        public static b Mz(String str) {
            b bVar = new b();
            Map q = bf.q(str, "msg");
            if (q != null) {
                bVar.lct = be.ah((String) q.get(".msg.location.$fromusername"), SQLiteDatabase.KeyEmpty);
                bVar.gRK = be.KN((String) q.get(".msg.location.$x"));
                bVar.gRL = be.KN((String) q.get(".msg.location.$y"));
                bVar.label = be.ah((String) q.get(".msg.location.$label"), SQLiteDatabase.KeyEmpty);
                bVar.nvK = be.ah((String) q.get(".msg.location.$maptype"), SQLiteDatabase.KeyEmpty);
                bVar.bhu = be.KL((String) q.get(".msg.location.$scale"));
                bVar.nvN = be.ah((String) q.get(".msg.location.$localLocationen"), SQLiteDatabase.KeyEmpty);
                bVar.nvL = be.ah((String) q.get(".msg.location.$localLocationcn"), SQLiteDatabase.KeyEmpty);
                bVar.nvM = be.ah((String) q.get(".msg.location.$localLocationtw"), SQLiteDatabase.KeyEmpty);
                bVar.gUr = be.ah((String) q.get(".msg.location.$poiname"), SQLiteDatabase.KeyEmpty);
                bVar.lyO = be.ah((String) q.get(".msg.location.$infourl"), SQLiteDatabase.KeyEmpty);
            }
            return bVar;
        }

        public final double bwM() {
            return this.gRK;
        }

        public final double bwN() {
            return this.gRL;
        }

        public final int bwO() {
            return this.bhu;
        }
    }

    public static final class c {
        public String cYw = SQLiteDatabase.KeyEmpty;
        public String content = SQLiteDatabase.KeyEmpty;
        public boolean fPG = false;
        public String iaq;
        public String nvO = SQLiteDatabase.KeyEmpty;
        public String title = SQLiteDatabase.KeyEmpty;

        private c() {
        }

        public static c MA(String str) {
            c cVar = new c();
            Map q = bf.q(str, "msg");
            if (q != null) {
                try {
                    cVar.title = (String) q.get(".msg.pushmail.content.subject");
                    cVar.content = (String) q.get(".msg.pushmail.content.digest");
                    cVar.cYw = (String) q.get(".msg.pushmail.content.sender");
                    cVar.nvO = (String) q.get(".msg.pushmail.waplink");
                    cVar.fPG = be.ma((String) q.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
                    cVar.iaq = (String) q.get(".msg.pushmail.mailid");
                } catch (Throwable e) {
                    v.e("MicroMsg.MsgInfo", "exception:%s", be.e(e));
                }
            }
            return cVar;
        }

        public final String bwP() {
            return this.nvO;
        }
    }

    public static final class d {
        public int bBZ;
        public String bCj;
        public String bLc = SQLiteDatabase.KeyEmpty;
        public int bdn;
        private String bfd;
        public String biB = SQLiteDatabase.KeyEmpty;
        public String cID = SQLiteDatabase.KeyEmpty;
        public String cIE = SQLiteDatabase.KeyEmpty;
        public String cIF = SQLiteDatabase.KeyEmpty;
        public String cIG = SQLiteDatabase.KeyEmpty;
        private String cIJ = SQLiteDatabase.KeyEmpty;
        public String content = SQLiteDatabase.KeyEmpty;
        private String cve;
        private String cvf;
        public String hUb;
        public long hWq = 0;
        public String hWt;
        public String lJi;
        public String lJj;
        public String lct = SQLiteDatabase.KeyEmpty;
        public int nvF = 0;
        public String nvG = SQLiteDatabase.KeyEmpty;
        public String nvH = SQLiteDatabase.KeyEmpty;
        public String nvI = SQLiteDatabase.KeyEmpty;
        public String nvJ = SQLiteDatabase.KeyEmpty;
        public int nvP = 0;
        public String nvQ;
        public String nvR;
        public int nvS;
        public String nvT;
        public String nvU;
        public int scene = 0;

        private d() {
        }

        public static d MB(String str) {
            d dVar = new d();
            Map q = bf.q(str, "msg");
            if (q != null) {
                try {
                    dVar.lct = (String) q.get(".msg.$fromusername");
                    dVar.bLc = (String) q.get(".msg.$alias");
                    dVar.cID = (String) q.get(".msg.$fromnickname");
                    dVar.cIF = (String) q.get(".msg.$fullpy");
                    dVar.cIE = (String) q.get(".msg.$shortpy");
                    dVar.content = (String) q.get(".msg.$content");
                    dVar.nvF = Integer.valueOf((String) q.get(".msg.$imagestatus")).intValue();
                    dVar.scene = Integer.valueOf((String) q.get(".msg.$scene")).intValue();
                    dVar.nvG = (String) q.get(".msg.$mhash");
                    dVar.nvH = (String) q.get(".msg.$mfullhash");
                    if (q.get(q.get(".msg.$qqnum")) != null && ((String) q.get(q.get(".msg.$qqnum"))).length() > 0) {
                        dVar.hWq = Long.valueOf((String) q.get(".msg.$qqnum")).longValue();
                    }
                    dVar.cIG = (String) q.get(".msg.$qqnickname");
                    dVar.cIJ = (String) q.get(".msg.$qqremark");
                    dVar.bCj = (String) q.get(".msg.$sign");
                    if (q.get(".msg.$sex") != null && ((String) q.get(".msg.$sex")).length() > 0) {
                        dVar.bBZ = Integer.valueOf((String) q.get(".msg.$sex")).intValue();
                    }
                    dVar.cve = (String) q.get(".msg.$city");
                    dVar.cvf = (String) q.get(".msg.$province");
                    dVar.bfd = (String) q.get(".msg.$country");
                    if (q.get(".msg.$snsflag") != null) {
                        dVar.nvP = Integer.valueOf((String) q.get(".msg.$snsflag")).intValue();
                        dVar.nvQ = (String) q.get(".msg.$snsbgimgid");
                    }
                    dVar.hUb = (String) q.get(".msg.$ticket");
                    v.d("MicroMsg.MsgInfo", "dkverify ticket:%s", dVar.hUb);
                    dVar.nvI = be.ma((String) q.get(".msg.$bigheadimgurl"));
                    dVar.nvJ = be.ma((String) q.get(".msg.$smallheadimgurl"));
                    dVar.bdn = Integer.valueOf(be.ah((String) q.get(".msg.$opcode"), "0")).intValue();
                    dVar.nvR = be.ma((String) q.get(".msg.$encryptusername"));
                    dVar.hWt = be.ma((String) q.get(".msg.$googlecontact"));
                    v.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", dVar.lct, dVar.nvI, dVar.nvJ);
                    dVar.biB = be.ma((String) q.get(".msg.$chatroomusername"));
                    dVar.lJi = (String) q.get(".msg.$sourceusername");
                    dVar.lJj = (String) q.get(".msg.$sourcenickname");
                    dVar.nvS = be.getInt((String) q.get(".msg.Antispam.$isSuspiciousUser"), 0);
                    if (dVar.nvS == 1) {
                        dVar.nvT = (String) q.get(".msg.Antispam.safetyWarning");
                        dVar.nvU = (String) q.get(".msg.Antispam.safetyWarningDetail");
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.MsgInfo", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            return dVar;
        }

        public final String bwE() {
            return this.lct;
        }

        public final String getDisplayName() {
            if (this.cID != null && this.cID.length() > 0) {
                return this.cID;
            }
            v.f("MicroMsg.MsgInfo", "username is nullOrNil");
            return this.lct;
        }

        public final int bwF() {
            return this.scene;
        }

        public final String bwG() {
            return this.nvG;
        }

        public final String getCity() {
            if (be.kS(this.bfd) || be.kS(this.cvf)) {
                return this.cve;
            }
            if (be.kS(this.cve)) {
                return RegionCodeDecoder.bxc().dP(this.bfd, this.cvf);
            }
            return RegionCodeDecoder.bxc().Z(this.bfd, this.cvf, this.cve);
        }

        public final String getProvince() {
            if (be.kS(this.bfd)) {
                return this.cvf;
            }
            if (be.kS(this.cvf) || be.kS(this.cve) || !RegionCodeDecoder.Nn(this.bfd)) {
                return RegionCodeDecoder.bxc().No(this.bfd);
            }
            return RegionCodeDecoder.bxc().dP(this.bfd, this.cvf);
        }

        public final int bwQ() {
            return this.nvP;
        }

        public final String bwR() {
            return this.nvQ;
        }
    }

    public at(String str) {
        super.cH(str);
    }

    public final boolean bvY() {
        return (this.field_type & 65535) == 49;
    }

    public final boolean bvZ() {
        return this.field_type == 285212721;
    }

    public final boolean bwa() {
        return this.field_type == 486539313;
    }

    public final boolean bwb() {
        return this.field_type == 34;
    }

    public final boolean bwc() {
        return this.field_type == 436207665;
    }

    public final boolean bwd() {
        return this.field_type == 469762097;
    }

    public final boolean bwe() {
        return this.field_type == 301989937;
    }

    public final boolean bwf() {
        return this.field_type == 50 || this.field_type == 53;
    }

    public final boolean bwg() {
        return this.field_type == 52;
    }

    public final boolean bwh() {
        return this.field_type == 318767153;
    }

    public final boolean bwi() {
        return this.field_type == CdnLogic.MediaType_FAVORITE_VIDEO;
    }

    public final boolean bwj() {
        switch (this.field_type) {
            case 3:
            case 13:
            case k.Nb /*23*/:
            case 33:
            case 39:
                return true;
            default:
                return false;
        }
    }

    public final boolean bwk() {
        return this.field_type == 42;
    }

    public final boolean bwl() {
        return this.field_type == 48;
    }

    public final boolean bwm() {
        switch (this.field_type) {
            case 1:
            case 11:
            case 21:
            case 31:
            case 36:
                return true;
            default:
                return false;
        }
    }

    public final boolean isSystem() {
        return this.field_type == 10000;
    }

    public final boolean bwn() {
        return this.field_type == 43;
    }

    public final boolean bwo() {
        return this.field_type == 62;
    }

    public final boolean bwp() {
        return this.field_type == 47;
    }

    public final boolean bwq() {
        return this.field_type == 1048625;
    }

    public final boolean bwr() {
        return this.field_type == 268435505;
    }

    public final boolean bws() {
        return this.field_type == -1879048191;
    }

    public final boolean bwt() {
        switch (this.field_type) {
            case 55:
            case 57:
                return true;
            default:
                return false;
        }
    }

    public final boolean bwu() {
        Object obj;
        String value = ((h) g.f(h.class)).sU().getValue("TranslateMsgOff");
        if (be.kS(value) || be.KL(value) == 0) {
            int i = 1;
        } else {
            v.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
            obj = null;
        }
        return (obj == null || be.kS(this.field_transContent)) ? false : true;
    }

    public static at O(at atVar) {
        if (atVar == null) {
            v.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
            return null;
        }
        at atVar2 = new at();
        atVar2.x(atVar.field_msgId);
        atVar2.y(atVar.field_msgSvrId);
        atVar2.setType(atVar.field_type);
        atVar2.dh(atVar.field_status);
        atVar2.di(atVar.field_isSend);
        atVar2.field_isShowTimer = atVar.field_isShowTimer;
        atVar2.bMV = true;
        atVar2.z(atVar.field_createTime);
        atVar2.cH(atVar.field_talker);
        atVar2.setContent(atVar.field_content);
        atVar2.cI(atVar.field_imgPath);
        atVar2.cJ(atVar.field_reserved);
        atVar2.field_lvbuffer = atVar.field_lvbuffer;
        atVar2.bKL = true;
        atVar2.cK(atVar.field_transContent);
        atVar2.cM(atVar.bNm);
        atVar2.ds(atVar.bNn);
        atVar2.cN(atVar.bNo);
        return atVar2;
    }

    public final void dh(int i) {
        com.tencent.mm.sdk.c.b msVar;
        super.dh(i);
        if (this.field_isSend == 1) {
            int i2 = (bwm() || bwl() || bwk()) ? 0 : 1;
            if (i2 != 0) {
                if (this.field_status == 5) {
                    v.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", Long.valueOf(this.field_msgId), Integer.valueOf(this.field_type), this.field_talker, be.bur());
                    msVar = new ms();
                    msVar.boc.aXd = this;
                    com.tencent.mm.sdk.c.a.nhr.z(msVar);
                    return;
                } else if (this.field_status == 2) {
                    v.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", Long.valueOf(this.field_msgId), Integer.valueOf(this.field_type));
                    msVar = new mu();
                    msVar.boe.aXd = this;
                    com.tencent.mm.sdk.c.a.nhr.z(msVar);
                    return;
                } else {
                    return;
                }
            }
        }
        if (this.field_isSend == 0) {
            msVar = new kp();
            msVar.blT.aXd = this;
            com.tencent.mm.sdk.c.a.nhr.z(msVar);
        }
    }

    public final boolean bwv() {
        return (this.bNr & 1) > 0;
    }

    public final void bww() {
        if (bwx()) {
            ds(this.bNn & -33);
        }
    }

    public final boolean bwx() {
        return (this.bNn & 32) > 0;
    }

    public final boolean bwy() {
        return bwu() && (this.bNn & 16) > 0;
    }

    public final void bwz() {
        if (bwu()) {
            ds(this.bNn | 16);
        }
    }

    public final void bwA() {
        ds(this.bNn | 48);
    }

    public final boolean bwB() {
        return (this.bNn & 48) != 0;
    }

    public final void vg(int i) {
        switch (i) {
            case 0:
            case 1:
                ds(this.bNn | i);
                return;
            default:
                v.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
                return;
        }
    }

    public final boolean Mw(String str) {
        if (!(be.kS(this.bNo) || be.kS(str))) {
            Map q = bf.q(this.bNo, "msgsource");
            if (q == null) {
                return false;
            }
            String str2 = (String) q.get(".msgsource.atuserlist");
            if (!be.kS(str2)) {
                for (String trim : str2.split(",")) {
                    if (trim.trim().equals(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean Mx(String str) {
        boolean z;
        if (be.kS(this.bNo) || be.kS(str) || !this.bNo.contains("announcement@all")) {
            z = false;
        } else {
            z = true;
        }
        v.d("MicroMsg.MsgInfo", "isChatRoomNotice userName:%s, isChatRoomNotice:%s", be.ma(str), Boolean.valueOf(z));
        return z;
    }

    public static boolean V(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            z = true;
        } else {
            z = false;
        }
        v.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public static boolean W(Map<String, String> map) {
        boolean z;
        if (map != null && map.containsKey(".sysmsg.$type") && ((String) map.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
            z = true;
        } else {
            z = false;
        }
        v.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", Boolean.valueOf(z));
        return z;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        ej(this.field_msgId);
    }

    public static void ej(long j) {
        String str = "msgId not in the reasonable scope";
        boolean z = 100000000 > j && -10 < j;
        Assert.assertTrue(str, z);
    }

    public final ContentValues py() {
        ej(this.field_msgId);
        return super.py();
    }

    public final String bwC() {
        if (!bwi()) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (this.nvE == null) {
            bwD();
        }
        return this.nvE;
    }

    public final com.tencent.mm.aj.a bwD() {
        v.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
        com.tencent.mm.aj.a b = com.tencent.mm.aj.a.a.b(com.tencent.mm.b.f.q(this.field_content, "sysmsg"), this);
        if (b != null) {
            v.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", b);
            b.HJ();
            this.nvE = b.cSX;
        } else {
            v.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
        }
        return b;
    }
}
