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
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.f;
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
import com.tencent.tinker.a.c.a;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

public final class c extends e {
    private final a pBZ = new a();
    private int pCa = 0;

    public c() {
        super(null);
    }

    private void zh(int i) {
        if (i != this.pCa) {
            a aVar = this.pBZ;
            int i2 = this.pCa;
            if (aVar.hO == 0 || i > aVar.vV[aVar.hO - 1]) {
                aVar.vV = a.c(aVar.vV, aVar.hO, i);
                aVar.pCP = a.c(aVar.pCP, aVar.hO, i2);
                aVar.hO++;
                return;
            }
            aVar.put(i, i2);
        }
    }

    public final int zi(int i) {
        int indexOfKey = this.pBZ.indexOfKey(i);
        return indexOfKey < 0 ? i : this.pBZ.pCP[indexOfKey];
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        zh(i);
        switch (i2) {
            case -1:
            case 0:
            case an.CTRL_INDEX /*14*/:
                this.pCa++;
                return;
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCa += 3;
                return;
            case 40:
                byte b = i5 - this.pCa;
                if (b == ((byte) b)) {
                    this.pCa++;
                    return;
                } else if (b != ((short) b)) {
                    this.pCa += 3;
                    return;
                } else {
                    this.pCa += 2;
                    return;
                }
            case 41:
                short s = i5 - this.pCa;
                if (s != ((short) s)) {
                    this.pCa += 3;
                    return;
                } else {
                    this.pCa += 2;
                    return;
                }
            case 42:
                this.pCa += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        zh(i);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case as.CTRL_INDEX /*13*/:
            case am.CTRL_INDEX /*15*/:
            case 16:
            case 17:
            case 18:
            case JsApiChooseImage.CTRL_INDEX /*29*/:
            case 30:
            case y.CTRL_INDEX /*39*/:
                this.pCa++;
                return;
            case 19:
            case 21:
            case bf.CTRL_INDEX /*22*/:
            case 25:
            case p.CTRL_INDEX /*28*/:
            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
            case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
            case 56:
            case 57:
            case 58:
            case 59:
            case EncrptType.VERIFY_CODE /*60*/:
            case 61:
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
                this.pCa += 2;
                return;
            case 20:
            case 23:
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case aq.CTRL_INDEX /*38*/:
            case 43:
            case 44:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCa += 3;
                return;
            case 24:
                this.pCa += 5;
                return;
            case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                if (i3 > 65535) {
                    this.pCa += 3;
                    return;
                } else {
                    this.pCa += 2;
                    return;
                }
            case bv.CTRL_INDEX /*27*/:
                this.pCa += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        zh(i);
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
            case com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX /*140*/:
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
                this.pCa++;
                return;
            case 2:
            case 5:
            case 8:
                this.pCa += 2;
                return;
            case 3:
            case 6:
            case 9:
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCa += 3;
                return;
            case JsApiStopRecordVoice.CTRL_INDEX /*32*/:
            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
            case 50:
            case com.tencent.mm.plugin.appbrand.jsapi.file.d.CTRL_INDEX /*51*/:
            case JsApiLogin.CTRL_INDEX /*52*/:
            case 53:
            case 54:
            case 55:
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
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
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
                this.pCa += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        zh(i);
        switch (i2) {
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCa += 3;
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
            case f.CTRL_INDEX /*144*/:
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
                this.pCa += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        zh(i);
        switch (i2) {
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCa += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.zl(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        zh(i);
        switch (i2) {
            case JsApiChooseVideo.CTRL_INDEX /*36*/:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
                this.pCa += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.zl(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        zh(i);
        switch (i2) {
            case JsApiGetLocation.CTRL_INDEX /*37*/:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                this.pCa += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + com.tencent.tinker.a.b.b.a.zl(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        zh(i);
        this.pCa += 2;
        this.pCa += iArr.length * 2;
        this.pCa += iArr2.length * 2;
    }

    public final void b(int i, int i2, int i3, int[] iArr) {
        zh(i);
        this.pCa += 4;
        this.pCa += iArr.length * 2;
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        zh(i);
        this.pCa += 4;
        switch (i4) {
            case 1:
                int length = ((byte[]) obj).length;
                this.pCa = ((length & 1) + (length >> 1)) + this.pCa;
                return;
            case 2:
                this.pCa += ((short[]) obj).length * 1;
                return;
            case 4:
                this.pCa += ((int[]) obj).length * 2;
                return;
            case 8:
                this.pCa += ((long[]) obj).length * 4;
                return;
            default:
                throw new j("bogus element_width: " + com.tencent.tinker.a.b.b.a.zk(i4));
        }
    }
}
