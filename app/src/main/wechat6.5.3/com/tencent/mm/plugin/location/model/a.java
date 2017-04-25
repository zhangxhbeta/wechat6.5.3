package com.tencent.mm.plugin.location.model;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.Set;

public final class a {

    public static class a {
        Set<Long> gRQ;
        private com.tencent.mm.modelgeo.b.a gRR = new com.tencent.mm.modelgeo.b.a(this) {
            final /* synthetic */ a gRS;

            {
                this.gRS = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void b(com.tencent.mm.modelgeo.Addr r11) {
                /*
                r10 = this;
                r1 = 0;
                r7 = -1;
                r3 = r10.gRS;
                r0 = r11.tag;
                if (r0 == 0) goto L_0x0198;
            L_0x0008:
                r0 = r11.tag;
                r0 = r0 instanceof java.lang.Long;
                if (r0 == 0) goto L_0x0198;
            L_0x000e:
                r0 = r11.tag;
                r0 = (java.lang.Long) r0;
                r4 = r0.longValue();
                com.tencent.mm.model.ak.yW();
                r0 = com.tencent.mm.model.c.wJ();
                r4 = r0.ek(r4);
                r0 = r11.cJf;
                r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
                if (r0 != 0) goto L_0x0198;
            L_0x0029:
                r2 = r4.field_content;
                r0 = r4.field_isSend;
                if (r0 != 0) goto L_0x0199;
            L_0x002f:
                r0 = 1;
            L_0x0030:
                r5 = r4.field_talker;
                r5 = com.tencent.mm.model.m.dE(r5);
                if (r5 == 0) goto L_0x004a;
            L_0x0038:
                if (r0 == 0) goto L_0x004a;
            L_0x003a:
                r6 = com.tencent.mm.model.aw.fK(r2);
                if (r6 == r7) goto L_0x004a;
            L_0x0040:
                r6 = r6 + 1;
                r2 = r2.substring(r6);
                r2 = r2.trim();
            L_0x004a:
                r6 = com.tencent.mm.storage.at.b.Mz(r2);
                r2 = r11.FV();
                r6.label = r2;
                r2 = "";
                if (r5 == 0) goto L_0x019e;
            L_0x0059:
                if (r0 == 0) goto L_0x019e;
            L_0x005b:
                r0 = r4.field_content;
                r0 = com.tencent.mm.model.aw.fK(r0);
                if (r0 == r7) goto L_0x019e;
            L_0x0063:
                r7 = r4.field_content;
                r0 = r7.substring(r1, r0);
                r0 = r0.trim();
                r1 = r0.length();
                if (r1 <= 0) goto L_0x019e;
            L_0x0073:
                r1 = r6.nvN;
                if (r1 == 0) goto L_0x0082;
            L_0x0077:
                r1 = r6.nvN;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x0087;
            L_0x0082:
                r1 = "";
                r6.nvN = r1;
            L_0x0087:
                r1 = r6.nvM;
                if (r1 == 0) goto L_0x0096;
            L_0x008b:
                r1 = r6.nvM;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x009b;
            L_0x0096:
                r1 = "";
                r6.nvN = r1;
            L_0x009b:
                r1 = r6.nvL;
                if (r1 == 0) goto L_0x00aa;
            L_0x009f:
                r1 = r6.nvL;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00af;
            L_0x00aa:
                r1 = "";
                r6.nvL = r1;
            L_0x00af:
                r1 = r6.lct;
                if (r1 == 0) goto L_0x00be;
            L_0x00b3:
                r1 = r6.lct;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00c3;
            L_0x00be:
                r1 = "";
                r6.lct = r1;
            L_0x00c3:
                r1 = r6.label;
                if (r1 == 0) goto L_0x00d2;
            L_0x00c7:
                r1 = r6.label;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00d7;
            L_0x00d2:
                r1 = "";
                r6.label = r1;
            L_0x00d7:
                r1 = r6.nvK;
                if (r1 == 0) goto L_0x00e6;
            L_0x00db:
                r1 = r6.nvK;
                r2 = "";
                r1 = r1.equals(r2);
                if (r1 == 0) goto L_0x00eb;
            L_0x00e6:
                r1 = "";
                r6.nvK = r1;
            L_0x00eb:
                r1 = new java.lang.StringBuilder;
                r2 = "<msg><location x=\"";
                r1.<init>(r2);
                r8 = r6.gRK;
                r1 = r1.append(r8);
                r2 = "\" y=\"";
                r1 = r1.append(r2);
                r8 = r6.gRL;
                r1 = r1.append(r8);
                r2 = "\" scale=\"";
                r1 = r1.append(r2);
                r2 = r6.bhu;
                r1 = r1.append(r2);
                r2 = "\" label=\"";
                r1 = r1.append(r2);
                r2 = r6.label;
                r1 = r1.append(r2);
                r2 = "\" maptype=\"";
                r1 = r1.append(r2);
                r2 = r6.nvK;
                r1 = r1.append(r2);
                r2 = "\"  fromusername=\"";
                r1 = r1.append(r2);
                r2 = r6.lct;
                r1 = r1.append(r2);
                r2 = "\" /></msg>";
                r1 = r1.append(r2);
                r1 = r1.toString();
                if (r5 == 0) goto L_0x019c;
            L_0x0147:
                r2 = "";
                r2 = r0.equals(r2);
                if (r2 != 0) goto L_0x019c;
            L_0x0150:
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r0 = r2.append(r0);
                r2 = ":\n";
                r0 = r0.append(r2);
                r0 = r0.append(r1);
                r0 = r0.toString();
            L_0x0168:
                r1 = "MicroMsg.LocationServer";
                r2 = new java.lang.StringBuilder;
                r5 = "xml: ";
                r2.<init>(r5);
                r2 = r2.append(r0);
                r2 = r2.toString();
                com.tencent.mm.sdk.platformtools.v.d(r1, r2);
                r4.setContent(r0);
                com.tencent.mm.model.ak.yW();
                r0 = com.tencent.mm.model.c.wJ();
                r6 = r4.field_msgId;
                r0.a(r6, r4);
                r0 = r3.gRQ;
                r2 = r4.field_msgId;
                r1 = java.lang.Long.valueOf(r2);
                r0.remove(r1);
            L_0x0198:
                return;
            L_0x0199:
                r0 = r1;
                goto L_0x0030;
            L_0x019c:
                r0 = r1;
                goto L_0x0168;
            L_0x019e:
                r0 = r2;
                goto L_0x0073;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.location.model.a.a.1.b(com.tencent.mm.modelgeo.Addr):void");
            }
        };

        public final void awa() {
            if (this.gRQ != null) {
                this.gRQ.clear();
            }
            b.FW().a(this.gRR);
        }

        public final String[] E(at atVar) {
            int i = 1;
            String[] strArr = new String[2];
            String str = atVar.field_content;
            if (be.kS(str)) {
                strArr[0] = "";
                strArr[1] = "";
                return strArr;
            }
            String trim;
            at.b MV;
            long j;
            at.b Mz;
            int i2 = atVar.field_isSend == 0 ? 1 : 0;
            if (m.dE(atVar.field_talker) && i2 != 0) {
                i2 = aw.fK(str);
                if (i2 != -1) {
                    trim = str.substring(i2 + 1).trim();
                    ak.yW();
                    MV = c.wJ().MV(trim);
                    i2 = (MV.gUr != null || MV.gUr.equals("")) ? 0 : 1;
                    if (i2 == 0) {
                        trim = MV.label;
                        str = MV.gUr;
                        strArr[0] = trim;
                        strArr[1] = str;
                    } else {
                        strArr[0] = MV.label;
                        strArr[1] = "";
                    }
                    if (be.kS(strArr[0]) && be.kS(strArr[1])) {
                        v.i("MicroMsg.LocationServer", "pull from sever");
                        j = atVar.field_msgId;
                        if (!(this.gRQ == null || this.gRQ.contains(Long.valueOf(j)))) {
                            trim = atVar.field_content;
                            if (atVar.field_isSend != 0) {
                                i = 0;
                            }
                            if (m.dE(atVar.field_talker) && r1 != 0) {
                                i = aw.fK(trim);
                                if (i != -1) {
                                    trim = trim.substring(i + 1).trim();
                                }
                            }
                            Mz = at.b.Mz(trim);
                            this.gRQ.add(Long.valueOf(j));
                            b.FW().a(Mz.gRK, Mz.gRL, this.gRR, Long.valueOf(atVar.field_msgId));
                        }
                    }
                    return strArr;
                }
            }
            trim = str;
            ak.yW();
            MV = c.wJ().MV(trim);
            if (MV.gUr != null) {
            }
            if (i2 == 0) {
                strArr[0] = MV.label;
                strArr[1] = "";
            } else {
                trim = MV.label;
                str = MV.gUr;
                strArr[0] = trim;
                strArr[1] = str;
            }
            v.i("MicroMsg.LocationServer", "pull from sever");
            j = atVar.field_msgId;
            trim = atVar.field_content;
            if (atVar.field_isSend != 0) {
                i = 0;
            }
            i = aw.fK(trim);
            if (i != -1) {
                trim = trim.substring(i + 1).trim();
            }
            Mz = at.b.Mz(trim);
            this.gRQ.add(Long.valueOf(j));
            b.FW().a(Mz.gRK, Mz.gRL, this.gRR, Long.valueOf(atVar.field_msgId));
            return strArr;
        }
    }
}
