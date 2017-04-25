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
import com.tencent.tinker.a.b.b.a;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

public final class d {
    private final g pCb;

    public d(g gVar) {
        this.pCb = gVar;
    }

    public final void a(e eVar) {
        a aVar = this.pCb;
        aVar.pBX.hO = 0;
        aVar.pBY = 0;
        while (true) {
            aVar = this.pCb;
            if ((aVar.pBY < aVar.pCg.length ? 1 : null) != null) {
                int i = this.pCb.pBY;
                int read = this.pCb.read();
                int i2 = read & 255;
                if (i2 == 0 || i2 == 255) {
                    i2 = read;
                }
                int i3;
                int i4;
                int read2;
                int i5;
                int i6;
                int zg;
                int readInt;
                int[] iArr;
                switch (i2) {
                    case -1:
                        eVar.a(i, read, 0, 1, 0, 0);
                        break;
                    case 0:
                    case an.CTRL_INDEX /*14*/:
                        eVar.a(i, read & 255, 0, 1, 0, (long) b.zd(read));
                        break;
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
                    case com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX /*134*/:
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
                        eVar.a(i, read & 255, 0, 1, 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 2:
                    case 5:
                    case 8:
                        eVar.a(i, read & 255, 0, 1, 0, 0, b.zd(read), this.pCb.read());
                        break;
                    case 3:
                    case 6:
                    case 9:
                        eVar.a(i, read & 255, 0, 1, 0, (long) b.zd(read), this.pCb.read(), this.pCb.read());
                        break;
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
                        eVar.a(i, read & 255, 0, 1, 0, 0, b.zd(read));
                        break;
                    case 18:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((((read >> 12) & 15) << 28) >> 28), (read >> 8) & 15);
                        break;
                    case 19:
                    case bf.CTRL_INDEX /*22*/:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((short) this.pCb.read()), b.zd(read));
                        break;
                    case 20:
                    case 23:
                        eVar.a(i, read & 255, 0, 1, 0, (long) this.pCb.readInt(), b.zd(read));
                        break;
                    case 21:
                    case 25:
                        i3 = read & 255;
                        eVar.a(i, i3, 0, 1, 0, ((long) ((short) this.pCb.read())) << (i3 == 21 ? 16 : 48), b.zd(read));
                        break;
                    case 24:
                        eVar.a(i, read & 255, 0, 1, 0, this.pCb.readLong(), b.zd(read));
                        break;
                    case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
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
                        i3 = read & 255;
                        eVar.a(i, i3, this.pCb.read(), b.zg(i3), 0, 0, b.zd(read));
                        break;
                    case bv.CTRL_INDEX /*27*/:
                        i3 = read & 255;
                        eVar.a(i, i3, this.pCb.readInt(), b.zg(i3), 0, 0, b.zd(read));
                        break;
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
                        i4 = read & 255;
                        eVar.a(i, i4, this.pCb.read(), b.zg(i4), 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case JsApiChooseVideo.CTRL_INDEX /*36*/:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                        int i7 = read & 255;
                        int i8 = (read >> 8) & 15;
                        i2 = (read >> 12) & 15;
                        read2 = this.pCb.read();
                        read = this.pCb.read();
                        i5 = read & 15;
                        i3 = (read >> 4) & 15;
                        i4 = (read >> 8) & 15;
                        i6 = (read >> 12) & 15;
                        zg = b.zg(i7);
                        switch (i2) {
                            case 0:
                                eVar.a(i, i7, read2, zg, 0, 0);
                                break;
                            case 1:
                                eVar.a(i, i7, read2, zg, 0, 0, i5);
                                break;
                            case 2:
                                eVar.a(i, i7, read2, zg, 0, 0, i5, i3);
                                break;
                            case 3:
                                eVar.a(i, i7, read2, zg, 0, 0, i5, i3, i4);
                                break;
                            case 4:
                                eVar.a(i, i7, read2, zg, 0, 0, i5, i3, i4, i6);
                                break;
                            case 5:
                                eVar.a(i, i7, read2, zg, 0, 0, i5, i3, i4, i6, i8);
                                break;
                            default:
                                throw new j("bogus registerCount: " + new String(new char[]{Character.forDigit(i2 & 15, 16)}));
                        }
                    case JsApiGetLocation.CTRL_INDEX /*37*/:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                        i4 = read & 255;
                        eVar.b(i, i4, this.pCb.read(), b.zg(i4), 0, 0, this.pCb.read(), b.zd(read));
                        break;
                    case aq.CTRL_INDEX /*38*/:
                    case 43:
                    case 44:
                        i3 = read & 255;
                        i5 = b.zd(read);
                        readInt = i + this.pCb.readInt();
                        switch (i3) {
                            case 43:
                            case 44:
                                this.pCb.dM(readInt + 1, i);
                                break;
                        }
                        eVar.a(i, i3, 0, 1, readInt, 0, i5);
                        break;
                    case 40:
                        eVar.a(i, read & 255, 0, 1, i + ((byte) b.zd(read)), 0);
                        break;
                    case 41:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.pCb.read()), (long) b.zd(read));
                        break;
                    case 42:
                        eVar.a(i, read & 255, 0, 1, i + this.pCb.readInt(), (long) b.zd(read));
                        break;
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
                        i6 = read & 255;
                        i5 = b.zd(read);
                        i2 = this.pCb.read();
                        eVar.a(i, i6, 0, 1, 0, 0, i5, i2 & 255, b.zd(i2));
                        break;
                    case 50:
                    case com.tencent.mm.plugin.appbrand.jsapi.file.d.CTRL_INDEX /*51*/:
                    case JsApiLogin.CTRL_INDEX /*52*/:
                    case 53:
                    case 54:
                    case 55:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.pCb.read()), 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case EncrptType.VERIFY_CODE /*60*/:
                    case 61:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.pCb.read()), 0, b.zd(read));
                        break;
                    case 208:
                    case 209:
                    case 210:
                    case 211:
                    case 212:
                    case 213:
                    case 214:
                    case 215:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((short) this.pCb.read()), (read >> 8) & 15, (read >> 12) & 15);
                        break;
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
                        i4 = read & 255;
                        i5 = b.zd(read);
                        i2 = this.pCb.read();
                        eVar.a(i, i4, 0, 1, 0, (long) ((byte) b.zd(i2)), i5, i2 & 255);
                        break;
                    case 256:
                        read2 = this.pCb.bOQ();
                        zg = this.pCb.read();
                        readInt = this.pCb.readInt();
                        iArr = new int[zg];
                        for (i2 = 0; i2 < zg; i2++) {
                            iArr[i2] = this.pCb.readInt() + read2;
                        }
                        eVar.b(i, read, readInt, iArr);
                        break;
                    case 512:
                        read2 = this.pCb.bOQ();
                        zg = this.pCb.read();
                        int[] iArr2 = new int[zg];
                        iArr = new int[zg];
                        for (i2 = 0; i2 < zg; i2++) {
                            iArr2[i2] = this.pCb.readInt();
                        }
                        for (i2 = 0; i2 < zg; i2++) {
                            iArr[i2] = this.pCb.readInt() + read2;
                        }
                        eVar.a(i, read, iArr2, iArr);
                        break;
                    case 768:
                        i2 = this.pCb.read();
                        int readInt2 = this.pCb.readInt();
                        Object obj;
                        switch (i2) {
                            case 1:
                                obj = new byte[readInt2];
                                i2 = 0;
                                int i9 = 0;
                                Object obj2 = 1;
                                while (i9 < readInt2) {
                                    if (obj2 != null) {
                                        i2 = this.pCb.read();
                                    }
                                    obj[i9] = (byte) (i2 & 255);
                                    i9++;
                                    obj2 = obj2 == null ? 1 : null;
                                    i2 >>= 8;
                                }
                                eVar.a(i, read, obj, obj.length, 1);
                                break;
                            case 2:
                                obj = new short[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = (short) this.pCb.read();
                                }
                                eVar.a(i, read, obj, obj.length, 2);
                                break;
                            case 4:
                                obj = new int[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = this.pCb.readInt();
                                }
                                eVar.a(i, read, obj, obj.length, 4);
                                break;
                            case 8:
                                obj = new long[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = this.pCb.readLong();
                                }
                                eVar.a(i, read, obj, obj.length, 8);
                                break;
                            default:
                                throw new j("bogus element_width: " + a.zk(i2));
                        }
                    default:
                        throw new IllegalStateException("Unknown opcode: " + a.zj(i2));
                }
            }
            return;
        }
    }
}
