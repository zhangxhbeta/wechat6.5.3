package com.tencent.mm.modelsearch;

import android.database.Cursor;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public interface q {

    public static class a {
        public long cWQ;
        public int cWt;
        public String cWv;
        public int type;
    }

    public static class b extends h {
        public final b a(Cursor cursor, int[] iArr, boolean z) {
            int i;
            int i2;
            this.type = cursor.getInt(0);
            this.cWt = cursor.getInt(1);
            this.cWu = cursor.getLong(2);
            this.cWv = cursor.getString(3);
            this.timestamp = cursor.getLong(4);
            this.content = cursor.getString(5);
            if (z) {
                this.cWw = d.cVD.split(this.content);
                this.cWx = new int[this.cWw.length];
                i = 0;
                for (i2 = 0; i2 < this.cWx.length; i2++) {
                    this.cWx[i2] = i;
                    i += this.cWw[i2].length() + 1;
                }
            }
            if (cursor.getColumnCount() >= 7 && iArr != null) {
                this.cWy = new List[iArr.length];
                if (iArr.length != 0) {
                    int i3;
                    com.tencent.mm.modelsearch.p.h.a aVar;
                    String[] split = d.cVC.split(cursor.getString(6));
                    int length = split.length;
                    for (i = 0; length - i >= 4; i += 4) {
                        i2 = be.getInt(split[i + 1], 0);
                        int i4 = be.getInt(split[i + 2], 0);
                        i3 = be.getInt(split[i + 3], 0) + i4;
                        i2 = Arrays.binarySearch(iArr, i2);
                        if (i2 < 0) {
                            i2 = (-i2) - 2;
                        }
                        if (this.cWy[i2] == null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new com.tencent.mm.modelsearch.p.h.a(i4, i3));
                            this.cWy[i2] = arrayList;
                        } else {
                            List list = this.cWy[i2];
                            aVar = (com.tencent.mm.modelsearch.p.h.a) list.get(list.size() - 1);
                            if (aVar.end >= i4) {
                                aVar.end = i3;
                            } else {
                                list.add(new com.tencent.mm.modelsearch.p.h.a(i4, i3));
                            }
                        }
                    }
                    byte[] bytes = this.content.getBytes();
                    for (List<com.tencent.mm.modelsearch.p.h.a> it : this.cWy) {
                        for (com.tencent.mm.modelsearch.p.h.a aVar2 : it) {
                            i = new String(bytes, 0, aVar2.start).length();
                            int length2 = new String(bytes, aVar2.start, aVar2.end - aVar2.start).length();
                            aVar2.start = i;
                            aVar2.end = i + length2;
                            if (z) {
                                i = Arrays.binarySearch(this.cWx, aVar2.start);
                                if (i < 0) {
                                    i = (-i) - 2;
                                }
                                aVar2.cWD = i;
                                i = this.cWx[i];
                                aVar2.cWE = aVar2.start - i;
                                aVar2.cWF = aVar2.end - i;
                            }
                        }
                    }
                }
            }
            return this;
        }

        public final void j(int[] iArr) {
            HashMap hashMap = new HashMap();
            int length = iArr.length;
            for (int i = 0; i < this.cWy.length; i++) {
                for (com.tencent.mm.modelsearch.p.h.a aVar : this.cWy[i]) {
                    int i2 = aVar.cWD / length;
                    int i3 = iArr[aVar.cWD % length];
                    i iVar = new i(i2, i, i3, this.cWw[aVar.cWD], aVar.cWE, aVar.cWF);
                    i iVar2 = (i) hashMap.get(Integer.valueOf(i2));
                    if (iVar2 == null) {
                        hashMap.put(Integer.valueOf(i2), iVar);
                    } else {
                        if (FTSUtils.b(d.cVz, i3, iVar2.cWt) < 0) {
                            hashMap.put(Integer.valueOf(i2), iVar);
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(hashMap.values());
            this.userData = arrayList;
        }

        public final void a(String[] strArr, String str, int[] iArr) {
            if (strArr.length > 1) {
                this.cWA = 1;
            } else {
                this.cWA = 0;
            }
            if (this.type == 131075) {
                if (System.currentTimeMillis() - this.timestamp < 604800000) {
                    this.cWz += 10;
                    String xF = k.xF();
                    if (this.cWt == 38 && iArr != null) {
                        HashSet hashSet = new HashSet();
                        if (this.cWy != null) {
                            for (List<com.tencent.mm.modelsearch.p.h.a> list : this.cWy) {
                                if (list != null) {
                                    for (com.tencent.mm.modelsearch.p.h.a aVar : list) {
                                        int length = aVar.cWD / iArr.length;
                                        if (!this.cWw[length].equals(xF)) {
                                            hashSet.add(Integer.valueOf(length));
                                        }
                                    }
                                }
                            }
                        }
                        v.i("MicroMsg.FTS.MatchInfo", "totalSubMatches=%d originMemberSize=%d", new Object[]{Integer.valueOf(hashSet.size()), Long.valueOf(this.cWu)});
                        if (((long) hashSet.size()) >= this.cWu - 1) {
                            this.cWz += 20;
                            this.cWB = true;
                        }
                        if (strArr.length > 1 && this.content.contains(str)) {
                            this.cWA = 2;
                            this.cWz += 5;
                        }
                    }
                    if ((this.cWt == 5 || this.cWt == 1) && this.content.contains(str)) {
                        if (strArr.length > 1) {
                            this.cWA = 2;
                        }
                        this.cWz += 10;
                    }
                }
            } else if ((this.cWt == 5 || this.cWt == 1) && this.content.contains(str)) {
                if (strArr.length > 1) {
                    this.cWA = 2;
                }
                this.cWz += 10;
            }
        }
    }
}
