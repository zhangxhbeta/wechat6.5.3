package com.tencent.tinker.a.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLogin;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShareAppMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.bo;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.g;
import com.tencent.mm.plugin.appbrand.jsapi.map.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

public final class f extends e {
    private final h pCd;
    private final c pCe;
    private final boolean pCf = true;

    public f(h hVar, c cVar) {
        super(null);
        this.pCd = hVar;
        this.pCe = cVar;
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        if (this.pCf) {
            i5 = this.pCe.zi(i5);
        }
        switch (i2) {
            case -1:
            case 0:
            case an.CTRL_INDEX /*14*/:
                this.pCd.c((short) i2);
                return;
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCd.a(b.dN(i2, b.dO(0, 0)), (short) i3, b.s(0, 0, 0, 0));
                return;
            case 40:
                byte b;
                if (this.pCf) {
                    b = i5 - this.pCd.pBY;
                    if (b == ((byte) b)) {
                        this.pCd.c(b.dN(i2, b & 255));
                        return;
                    } else if (b != ((short) b)) {
                        this.pCd.a((short) 42, (short) b, (short) (b >> 16));
                        return;
                    } else {
                        this.pCd.b((short) 41, (short) b);
                        return;
                    }
                }
                b = i5 - this.pCd.pBY;
                if (b != ((byte) b)) {
                    throw new j("Target out of range: " + a.zn(b) + ", perhaps you need to enable force jumbo mode.");
                }
                this.pCd.c(b.dN(i2, b & 255));
                return;
            case 41:
                short s;
                if (this.pCf) {
                    short s2 = i5 - this.pCd.pBY;
                    if (s2 != ((short) s2)) {
                        this.pCd.a((short) 42, (short) s2, (short) (s2 >> 16));
                        return;
                    }
                    s = (short) i2;
                    this.pCd.b(s, (short) s2);
                    return;
                }
                s = (short) i2;
                this.pCd.b(s, b.dP(i5, this.pCd.pBY));
                return;
            case 42:
                int i6 = i5 - this.pCd.pBY;
                this.pCd.a((short) i2, (short) i6, (short) (i6 >> 16));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        if (this.pCf) {
            i5 = this.pCe.zi(i5);
        }
        int i7;
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case as.CTRL_INDEX /*13*/:
            case am.CTRL_INDEX /*15*/:
            case 16:
            case 17:
            case JsApiChooseImage.CTRL_INDEX /*29*/:
            case 30:
            case y.CTRL_INDEX /*39*/:
                this.pCd.c(b.dN(i2, i6));
                return;
            case 18:
                short s = (short) i2;
                h hVar = this.pCd;
                if (j < -8 || j > 7) {
                    throw new j("Literal out of range: " + a.eJ(j));
                }
                hVar.c(b.dN(s, b.dO(i6, ((int) j) & 15)));
                return;
            case 19:
            case bf.CTRL_INDEX /*22*/:
                this.pCd.b(b.dN(i2, i6), b.eI(j));
                return;
            case 20:
            case 23:
                if (j != ((long) ((int) j))) {
                    throw new j("Literal out of range: " + a.eJ(j));
                }
                i7 = (int) j;
                this.pCd.a(b.dN(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 21:
            case 25:
                this.pCd.b(b.dN(i2, i6), (short) ((int) (j >> (i2 == 21 ? 16 : 48))));
                return;
            case 24:
                h hVar2 = this.pCd;
                short s2 = (short) ((int) j);
                short s3 = (short) ((int) (j >> 16));
                short s4 = (short) ((int) (j >> 32));
                short s5 = (short) ((int) (j >> 48));
                hVar2.c(b.dN(i2, i6));
                hVar2.c(s2);
                hVar2.c(s3);
                hVar2.c(s4);
                hVar2.c(s5);
                return;
            case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                if (this.pCf) {
                    if (i3 > 65535) {
                        this.pCd.a(b.dN(27, i6), (short) i3, (short) (i3 >> 16));
                        return;
                    } else {
                        this.pCd.b(b.dN(i2, i6), (short) i3);
                        return;
                    }
                } else if (i3 > 65535) {
                    throw new j("string index out of bound: " + a.zj(i3) + ", perhaps you need to enable force jumbo mode.");
                } else {
                    this.pCd.b(b.dN(i2, i6), (short) i3);
                    return;
                }
            case bv.CTRL_INDEX /*27*/:
                this.pCd.a(b.dN(i2, i6), (short) i3, (short) (i3 >> 16));
                return;
            case p.CTRL_INDEX /*28*/:
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
            case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case UpdateLogConst.ACTION_POP_INSTALL_DIALOG /*104*/:
            case 105:
            case 106:
            case 107:
            case ba.CTRL_INDEX /*108*/:
            case 109:
                this.pCd.b(b.dN(i2, i6), (short) i3);
                return;
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCd.a(b.dN(i2, b.dO(0, 1)), (short) i3, b.s(i6, 0, 0, 0));
                return;
            case aq.CTRL_INDEX /*38*/:
            case 43:
            case 44:
                switch (i2) {
                    case 43:
                    case 44:
                        this.pCd.dM(i5, this.pCd.pBY);
                        break;
                }
                i7 = i5 - this.pCd.pBY;
                this.pCd.a(b.dN(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 56:
            case 57:
            case 58:
            case 59:
            case EncrptType.VERIFY_CODE /*60*/:
            case 61:
                this.pCd.b(b.dN(i2, i6), b.dP(i5, this.pCd.pBY));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (this.pCf) {
            i5 = this.pCe.zi(i5);
        }
        switch (i2) {
            case 1:
            case 4:
            case 7:
            case JsApiStartPlayVoice.CTRL_INDEX /*33*/:
            case au.CTRL_INDEX /*123*/:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case e.CTRL_INDEX /*133*/:
            case d.CTRL_INDEX /*134*/:
            case b.CTRL_INDEX /*135*/:
            case g.CTRL_INDEX /*136*/:
            case 137:
            case 138:
            case 139:
            case c.CTRL_INDEX /*140*/:
            case i.CTRL_INDEX /*141*/:
            case 142:
            case 143:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            case 198:
            case 199:
            case 200:
            case 201:
            case 202:
            case 203:
            case 204:
            case 205:
            case 206:
            case 207:
                this.pCd.c(b.dN((short) i2, b.dO(i6, i7)));
                return;
            case 2:
            case 5:
            case 8:
                this.pCd.b(b.dN(i2, i6), b.zf(i7));
                return;
            case 3:
            case 6:
            case 9:
                this.pCd.a((short) i2, b.ze(i6), b.zf(i7));
                return;
            case JsApiStopRecordVoice.CTRL_INDEX /*32*/:
            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
            case 82:
            case bt.CTRL_INDEX /*83*/:
            case com.tencent.mm.plugin.appbrand.jsapi.b.c.CTRL_INDEX /*84*/:
            case bw.CTRL_INDEX /*85*/:
            case h.CTRL_INDEX /*86*/:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case r.CTRL_INDEX /*92*/:
            case 93:
            case s.CTRL_INDEX /*94*/:
            case 95:
                this.pCd.b(b.dN(i2, b.dO(i6, i7)), (short) i3);
                return;
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCd.a(b.dN(i2, b.dO(0, 2)), (short) i3, b.s(i6, i7, 0, 0));
                return;
            case 50:
            case com.tencent.mm.plugin.appbrand.jsapi.file.d.CTRL_INDEX /*51*/:
            case JsApiLogin.CTRL_INDEX /*52*/:
            case 53:
            case 54:
            case 55:
                this.pCd.b(b.dN(i2, b.dO(i6, i7)), b.dP(i5, this.pCd.pBY));
                return;
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
                this.pCd.b(b.dN(i2, b.dO(i6, i7)), b.eI(j));
                return;
            case 216:
            case 217:
            case 218:
            case 219:
            case 220:
            case 221:
            case 222:
            case 223:
            case 224:
            case 225:
            case 226:
                h hVar = this.pCd;
                short dN = b.dN(i2, i6);
                if (j != ((long) ((byte) ((int) j)))) {
                    throw new j("Literal out of range: " + a.eJ(j));
                }
                hVar.b(dN, b.dN(i7, ((int) j) & 255));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        switch (i2) {
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCd.a(b.dN(i2, b.dO(0, 3)), (short) i3, b.s(i6, i7, i8, 0));
                return;
            case 45:
            case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
            case 48:
            case 49:
            case at.CTRL_INDEX /*68*/:
            case q.CTRL_INDEX /*69*/:
            case com.tencent.mm.plugin.appbrand.jsapi.a.g.CTRL_INDEX /*70*/:
            case 71:
            case j.CTRL_INDEX /*72*/:
            case JsApiShareAppMessage.CTRL_INDEX /*73*/:
            case bk.CTRL_INDEX /*74*/:
            case 75:
            case 76:
            case 77:
            case 78:
            case JsApiOperateWXData.CTRL_INDEX /*79*/:
            case 80:
            case 81:
            case com.tencent.mm.plugin.appbrand.jsapi.map.f.CTRL_INDEX /*144*/:
            case t.CTRL_INDEX /*145*/:
            case bo.CTRL_INDEX /*146*/:
            case 147:
            case JsApiScanCode.CTRL_INDEX /*148*/:
            case 149:
            case br.CTRL_INDEX /*150*/:
            case 151:
            case v.CTRL_INDEX /*152*/:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
                this.pCd.b(b.dN(i2, i6), b.dN(i7, i8));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        switch (i2) {
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCd.a(b.dN(i2, b.dO(0, 4)), (short) i3, b.s(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        switch (i2) {
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCd.a(b.dN(i2, b.dO(i10, 5)), (short) i3, b.s(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.zl(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        switch (i2) {
            case JsApiGetLocation.CTRL_INDEX /*37*/:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                this.pCd.a(b.dN(i2, i7), (short) i3, b.ze(i6));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.zl(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        int length;
        int i3 = 0;
        int bOQ = this.pCd.bOQ();
        this.pCd.c((short) i2);
        this.pCd.c(b.zc(iArr2.length));
        for (int writeInt : iArr) {
            this.pCd.writeInt(writeInt);
        }
        if (this.pCf) {
            length = iArr2.length;
            while (i3 < length) {
                this.pCd.writeInt(this.pCe.zi(iArr2[i3]) - bOQ);
                i3++;
            }
            return;
        }
        length = iArr2.length;
        while (i3 < length) {
            this.pCd.writeInt(iArr2[i3] - bOQ);
            i3++;
        }
    }

    public final void b(int i, int i2, int i3, int[] iArr) {
        int i4 = 0;
        int bOQ = this.pCd.bOQ();
        this.pCd.c((short) i2);
        this.pCd.c(b.zc(iArr.length));
        this.pCd.writeInt(i3);
        int length;
        if (this.pCf) {
            length = iArr.length;
            while (i4 < length) {
                this.pCd.writeInt(this.pCe.zi(iArr[i4]) - bOQ);
                i4++;
            }
            return;
        }
        length = iArr.length;
        while (i4 < length) {
            this.pCd.writeInt(iArr[i4] - bOQ);
            i4++;
        }
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        int i5 = 0;
        this.pCd.c((short) i2);
        this.pCd.c((short) i4);
        this.pCd.writeInt(i3);
        h hVar;
        int length;
        switch (i4) {
            case 1:
                h hVar2 = this.pCd;
                int i6 = 1;
                int i7 = 0;
                for (byte b : (byte[]) obj) {
                    if (i6 != 0) {
                        i7 = b & 255;
                        i6 = 0;
                    } else {
                        i6 = (b << 8) | i7;
                        hVar2.c((short) i6);
                        i7 = i6;
                        i6 = 1;
                    }
                }
                if (i6 == 0) {
                    hVar2.c((short) i7);
                    return;
                }
                return;
            case 2:
                hVar = this.pCd;
                short[] sArr = (short[]) obj;
                length = sArr.length;
                while (i5 < length) {
                    hVar.c(sArr[i5]);
                    i5++;
                }
                return;
            case 4:
                hVar = this.pCd;
                int[] iArr = (int[]) obj;
                length = iArr.length;
                while (i5 < length) {
                    hVar.writeInt(iArr[i5]);
                    i5++;
                }
                return;
            case 8:
                hVar = this.pCd;
                long[] jArr = (long[]) obj;
                length = jArr.length;
                while (i5 < length) {
                    long j = jArr[i5];
                    hVar.c((short) ((int) j));
                    hVar.c((short) ((int) (j >> 16)));
                    hVar.c((short) ((int) (j >> 32)));
                    hVar.c((short) ((int) (j >> 48)));
                    i5++;
                }
                return;
            default:
                throw new j("bogus element_width: " + a.zk(i4));
        }
    }
}
