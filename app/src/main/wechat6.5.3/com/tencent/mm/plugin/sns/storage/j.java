package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.j.q.b;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class j extends f<i> implements b {
    public static final String[] cic = new String[]{f.a(i.chq, "snsExtInfo3")};
    public d cie;
    private boolean jBN = false;
    private e jBO = null;

    public final void aUB() {
        v.d("MicroMsg.SnsExtStorage", "attachCache");
        this.jBN = true;
    }

    public final void aUC() {
        this.jBN = false;
        this.jBO.aST();
        v.d("MicroMsg.SnsExtStorage", "detchCache");
    }

    public j(d dVar, e eVar) {
        super(dVar, i.chq, "snsExtInfo3", null);
        this.cie = dVar;
        this.jBO = eVar;
        v.i("MicroMsg.SnsExtStorage", "createExtStorage " + dVar + "  " + Thread.currentThread().getId());
    }

    public final boolean b(i iVar) {
        return super.a(iVar);
    }

    public final boolean a(i iVar) {
        if (!this.jBN || this.jBO == null) {
            return super.a(iVar);
        }
        boolean a = this.jBO.a(iVar);
        if (this.jBO == null) {
            return a;
        }
        this.jBO.aSS();
        return a;
    }

    public final void Br(String str) {
        i Bu = Bu(str);
        Bu.field_userName = str;
        super.c(Bu, new String[]{this.nmf.nmc});
    }

    public final int cL(String str, String str2) {
        i Bu = Bu(str);
        Bu.field_md5 = str2;
        super.a(Bu);
        return 0;
    }

    public final int e(String str, String str2, byte[] bArr) {
        i Bu = Bu(str);
        Bu.field_md5 = str2;
        Bu.field_adsession = bArr;
        super.a(Bu);
        return 0;
    }

    public final boolean cM(String str, String str2) {
        i Bu = Bu(str);
        Bu.field_newerIds = str2;
        return super.a(Bu);
    }

    public final rb Bs(String str) {
        rb rbVar;
        rb rbVar2 = new rb();
        i iVar = new i();
        iVar = Bu(str);
        try {
            if (!be.bl(iVar.field_faultS)) {
                rbVar = (rb) new rb().az(iVar.field_faultS);
                if (rbVar != null) {
                    return new rb();
                }
                return rbVar;
            }
        } catch (Exception e) {
            v.e("MicroMsg.SnsExtStorage", "parser field_faultS error");
        }
        rbVar = rbVar2;
        if (rbVar != null) {
            return rbVar;
        }
        return new rb();
    }

    public final void Bt(String str) {
        i iVar = new i();
        iVar = Bu(str);
        iVar.field_userName = str;
        iVar.field_local_flag &= -2;
        c(iVar);
    }

    public final i Bu(String str) {
        i iVar = new i();
        if (this.jBO != null && this.jBN) {
            iVar = this.jBO.As(str);
            if (iVar == null) {
                iVar = new i();
            }
            return iVar;
        }
        iVar.field_userName = str;
        super.b(iVar, new String[]{this.nmf.nmc});
        return iVar;
    }

    public final boolean c(i iVar) {
        if (iVar == null || iVar.field_userName == null || iVar.field_userName.equals("")) {
            return false;
        }
        return super.a(iVar);
    }

    public final boolean a(String str, axg com_tencent_mm_protocal_c_axg) {
        i Bu = Bu(str);
        String cE = i.cE(com_tencent_mm_protocal_c_axg.cHp);
        if (!be.kS(com_tencent_mm_protocal_c_axg.cHo) && (Bu.field_bgUrl == null || !Bu.field_bgId.equals(cE))) {
            Bu.field_older_bgId = Bu.field_bgId;
            Bu.field_local_flag |= 1;
            Bu.aUx();
            v.d("MicroMsg.SnsExtStorage", "bg change");
        }
        Bu.field_bgId = cE;
        Bu.field_bgUrl = com_tencent_mm_protocal_c_axg.cHo;
        Bu.field_iFlag = com_tencent_mm_protocal_c_axg.cHn;
        Bu.field_snsBgId = com_tencent_mm_protocal_c_axg.cHp;
        Bu.field_local_flag |= 4;
        if (com_tencent_mm_protocal_c_axg != null) {
            try {
                Bu.field_snsuser = com_tencent_mm_protocal_c_axg.toByteArray();
            } catch (Exception e) {
            }
        }
        a(Bu);
        return true;
    }

    public final axg b(String str, axg com_tencent_mm_protocal_c_axg) {
        i Bu = Bu(str);
        i a;
        int i;
        if (Bu == null) {
            a = a(str, Bu);
            if (a != null) {
                if (com_tencent_mm_protocal_c_axg.cHn == -1) {
                    i = a.field_iFlag;
                } else {
                    i = com_tencent_mm_protocal_c_axg.cHn;
                }
                com_tencent_mm_protocal_c_axg.cHn = i;
            }
        } else {
            com_tencent_mm_protocal_c_axg.cHo = be.kS(com_tencent_mm_protocal_c_axg.cHo) ? Bu.field_bgUrl : com_tencent_mm_protocal_c_axg.cHo;
            Object obj = com_tencent_mm_protocal_c_axg.cHn == -1 ? 1 : null;
            com_tencent_mm_protocal_c_axg.cHn = obj != null ? Bu.field_iFlag : com_tencent_mm_protocal_c_axg.cHn;
            a = a(str, Bu);
            if (a != null) {
                if (obj != null) {
                    i = a.field_iFlag;
                } else {
                    i = com_tencent_mm_protocal_c_axg.cHn;
                }
                com_tencent_mm_protocal_c_axg.cHn = i;
            }
        }
        return com_tencent_mm_protocal_c_axg;
    }

    private i a(String str, i iVar) {
        int i;
        int i2;
        Cursor rawQuery;
        i iVar2;
        if (iVar == null) {
            i = 0;
        } else {
            if ((iVar.field_iFlag & 1) > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if ((iVar.field_local_flag & 4) > 0) {
                i2 = i;
                i = 1;
                if (i == 0 && r4 == 0) {
                    rawQuery = this.cie.rawQuery("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null);
                    if (rawQuery.moveToFirst()) {
                        i = 0;
                    } else {
                        i = rawQuery.getInt(0);
                    }
                    rawQuery.close();
                    if (i != 0) {
                        v.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[]{str});
                        return null;
                    }
                    v.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[]{"select * from snsExtInfo2 where userName=\"" + be.lZ(str) + "\""});
                    rawQuery = this.cie.rawQuery(r0, null);
                    iVar2 = new i();
                    if (rawQuery.moveToFirst()) {
                        rawQuery.close();
                    } else {
                        iVar2.b(rawQuery);
                        v.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[]{str});
                        rawQuery.close();
                        return iVar2;
                    }
                }
                return null;
            }
        }
        i2 = i;
        i = 0;
        rawQuery = this.cie.rawQuery("select count(*)  from sqlite_master where type='table' and name = 'snsExtInfo2'", null);
        if (rawQuery.moveToFirst()) {
            i = 0;
        } else {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        if (i != 0) {
            v.d("MicroMsg.SnsExtStorage", "get from snsextinfo2 sql %s", new Object[]{"select * from snsExtInfo2 where userName=\"" + be.lZ(str) + "\""});
            rawQuery = this.cie.rawQuery(r0, null);
            iVar2 = new i();
            if (rawQuery.moveToFirst()) {
                rawQuery.close();
                return null;
            }
            iVar2.b(rawQuery);
            v.i("MicroMsg.SnsExtStorage", "setSnsUserInfo fix newversion change snsextinfo3 %s", new Object[]{str});
            rawQuery.close();
            return iVar2;
        }
        v.v("MicroMsg.SnsExtStorage", "can not get snsextinfo2 %s", new Object[]{str});
        return null;
    }

    public final axg Bv(String str) {
        i Bu = Bu(str);
        if (Bu == null) {
            return new axg();
        }
        return Bu.aUz();
    }

    public final boolean am(String str, boolean z) {
        i Bu = Bu(str);
        int i = Bu.field_iFlag;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        Bu.field_iFlag = i;
        c(Bu);
        return true;
    }

    public final axg an(String str, boolean z) {
        axg aUz = Bu(str).aUz();
        if (aUz == null) {
            v.e("MicroMsg.SnsExtStorage", "userinfo is null");
            return null;
        }
        int i = aUz.mUx;
        if (z) {
            i |= 1;
        } else {
            i &= -2;
        }
        aUz.mUx = i;
        return aUz;
    }
}
