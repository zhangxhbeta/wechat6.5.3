package com.tencent.mm.modelbiz;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.e.b.x;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class BizInfo extends x {
    public static int cBp = 1;
    public static int cBq = 0;
    public static int cBr = 1;
    private static int cBu = 0;
    private static ExtInfo cBv = null;
    protected static com.tencent.mm.sdk.h.c.a chq;
    private List<a> cBs;
    public ExtInfo cBt;

    public static class ExtInfo {
        public boolean cBA = false;
        public boolean cBB = false;
        private String cBC;
        private String cBD;
        private List<e> cBE = null;
        private c cBF = null;
        private b cBG = null;
        private d cBH = null;
        b cBI = null;
        private boolean cBJ = false;
        boolean cBK = false;
        int cBL;
        public boolean cBM = false;
        public int cBN = 0;
        private int cBO = 0;
        private String cBP;
        private a cBQ = null;
        private int cBR = 0;
        private int cBS = BizInfo.cBq;
        private String cBT;
        private boolean cBU = false;
        public int cBV;
        private f cBW;
        private String cBX;
        private String cBY;
        private boolean cBZ = false;
        public JSONObject cBx = null;
        private boolean cBy = true;
        public boolean cBz = false;
        private List<WxaEntryInfo> cCa;

        public static class WxaEntryInfo implements Parcelable {
            public static final Creator<WxaEntryInfo> CREATOR = new Creator<WxaEntryInfo>() {
                public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$WxaEntryInfo;
                    r0.<init>(r2);
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.1.createFromParcel(android.os.Parcel):java.lang.Object");
                }

                public final /* bridge */ /* synthetic */ java.lang.Object[] newArray(int r2) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = this;
                    r0 = new com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo[r2];
                    return r0;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.1.newArray(int):java.lang.Object[]");
                }
            };
            public String cCE;
            public String iconUrl;
            public String title;
            public String username;

            protected WxaEntryInfo(android.os.Parcel r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r1.<init>();
                r0 = r2.readString();
                r1.username = r0;
                r0 = r2.readString();
                r1.title = r0;
                r0 = r2.readString();
                r1.cCE = r0;
                r0 = r2.readString();
                r1.iconUrl = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.<init>(android.os.Parcel):void");
            }

            public void writeToParcel(android.os.Parcel r2, int r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.username;
                r2.writeString(r0);
                r0 = r1.title;
                r2.writeString(r0);
                r0 = r1.cCE;
                r2.writeString(r0);
                r0 = r1.iconUrl;
                r2.writeString(r0);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.writeToParcel(android.os.Parcel, int):void");
            }

            public int describeContents() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = 0;
                return r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo.describeContents():int");
            }
        }

        public static class a {
            public int cCb;
            public int cCc;
            public int cCd;

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.a hi(java.lang.String r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = "MicroMsg.BizInfo";
                r1 = new java.lang.StringBuilder;
                r2 = "HardwareBizInfo = ";
                r1.<init>(r2);
                r1 = r1.append(r6);
                r1 = r1.toString();
                com.tencent.mm.sdk.platformtools.v.i(r0, r1);
                r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$a;
                r0.<init>();
                if (r6 == 0) goto L_0x0023;
            L_0x001d:
                r1 = r6.length();
                if (r1 > 0) goto L_0x0024;
            L_0x0023:
                return r0;
            L_0x0024:
                r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0045 }
                r1.<init>(r6);	 Catch:{ JSONException -> 0x0045 }
                r2 = "hardware_flag";	 Catch:{ JSONException -> 0x0045 }
                r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0045 }
                r0.cCb = r2;	 Catch:{ JSONException -> 0x0045 }
                r2 = "connect_status_display_mode";	 Catch:{ JSONException -> 0x0045 }
                r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0045 }
                r0.cCc = r2;	 Catch:{ JSONException -> 0x0045 }
                r2 = "special_internal_brand_type";	 Catch:{ JSONException -> 0x0045 }
                r1 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0045 }
                r0.cCd = r1;	 Catch:{ JSONException -> 0x0045 }
                goto L_0x0023;
            L_0x0045:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
                goto L_0x0023;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.a.hi(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$a");
            }

            public final boolean Da() {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.cCb;
                r0 = r0 & 1;
                if (r0 <= 0) goto L_0x0008;
            L_0x0006:
                r0 = 1;
            L_0x0007:
                return r0;
            L_0x0008:
                r0 = 0;
                goto L_0x0007;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.a.Da():boolean");
            }
        }

        public static class b {
            public int cCe;
            public List<a> cCf = null;

            public static class a {
                public static String cCg = "menu_click";
                public static String cCh = "menu_action_start";
                public static String cCi = "menu_action_success";
                public String apU;
                public String cCj;
                public List<a> cCk = null;
                public String cCl;
                public int cCm;
                public String content;
                public int id;
                public String name;
                public int type;
                public String value;

                public final void f(java.util.ArrayList<java.lang.String> r6) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = this;
                    r0 = r6.size();
                    if (r0 != 0) goto L_0x0010;
                L_0x0006:
                    r0 = "MicroMsg.BizInfo";
                    r1 = "value null!";
                    com.tencent.mm.sdk.platformtools.v.e(r0, r1);
                L_0x000f:
                    return;
                L_0x0010:
                    r1 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0034 }
                    r1.<init>();	 Catch:{ JSONException -> 0x0034 }
                    r2 = r6.iterator();	 Catch:{ JSONException -> 0x0034 }
                L_0x0019:
                    r0 = r2.hasNext();	 Catch:{ JSONException -> 0x0034 }
                    if (r0 == 0) goto L_0x0040;	 Catch:{ JSONException -> 0x0034 }
                L_0x001f:
                    r0 = r2.next();	 Catch:{ JSONException -> 0x0034 }
                    r0 = (java.lang.String) r0;	 Catch:{ JSONException -> 0x0034 }
                    r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0034 }
                    r3.<init>();	 Catch:{ JSONException -> 0x0034 }
                    r4 = "pic_md5";	 Catch:{ JSONException -> 0x0034 }
                    r3.put(r4, r0);	 Catch:{ JSONException -> 0x0034 }
                    r1.put(r3);	 Catch:{ JSONException -> 0x0034 }
                    goto L_0x0019;
                L_0x0034:
                    r0 = move-exception;
                    r1 = "MicroMsg.BizInfo";
                    r0 = r0.toString();
                    com.tencent.mm.sdk.platformtools.v.e(r1, r0);
                    goto L_0x000f;
                L_0x0040:
                    r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0034 }
                    r0.<init>();	 Catch:{ JSONException -> 0x0034 }
                    r2 = "pics";	 Catch:{ JSONException -> 0x0034 }
                    r0.put(r2, r1);	 Catch:{ JSONException -> 0x0034 }
                    r0 = r0.toString();	 Catch:{ JSONException -> 0x0034 }
                    r5.content = r0;	 Catch:{ JSONException -> 0x0034 }
                    r0 = "MicroMsg.BizInfo";	 Catch:{ JSONException -> 0x0034 }
                    r1 = r5.content;	 Catch:{ JSONException -> 0x0034 }
                    com.tencent.mm.sdk.platformtools.v.v(r0, r1);	 Catch:{ JSONException -> 0x0034 }
                    goto L_0x000f;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.f(java.util.ArrayList):void");
                }

                public final java.lang.String getInfo() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r5 = this;
                    r4 = 4;
                    r0 = r5.content;
                    if (r0 != 0) goto L_0x000a;
                L_0x0005:
                    r0 = "";
                    r5.content = r0;
                L_0x000a:
                    r0 = r5.cCl;
                    if (r0 != 0) goto L_0x0016;
                L_0x000e:
                    r0 = r5.type;
                    if (r0 != r4) goto L_0x003e;
                L_0x0012:
                    r0 = cCh;
                    r5.cCl = r0;
                L_0x0016:
                    r0 = "%s<info><id><![CDATA[%d]]></id><key><![CDATA[%s]]></key><status><![CDATA[%s]]></status><content><![CDATA[%s]]></content></info>";
                    r1 = 5;
                    r1 = new java.lang.Object[r1];
                    r2 = 0;
                    r3 = "#bizmenu#";
                    r1[r2] = r3;
                    r2 = 1;
                    r3 = r5.id;
                    r3 = java.lang.Integer.valueOf(r3);
                    r1[r2] = r3;
                    r2 = 2;
                    r3 = r5.apU;
                    r1[r2] = r3;
                    r2 = 3;
                    r3 = r5.cCl;
                    r1[r2] = r3;
                    r2 = r5.content;
                    r1[r4] = r2;
                    r0 = java.lang.String.format(r0, r1);
                    return r0;
                L_0x003e:
                    r0 = cCg;
                    r5.cCl = r0;
                    goto L_0x0016;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.getInfo():java.lang.String");
                }

                public final java.lang.String toString() {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r4 = this;
                    r1 = "id:%d, type:%d, acttype:%s, name:%s, key:%s, value:%s, content:%s";
                    r0 = 7;
                    r2 = new java.lang.Object[r0];
                    r0 = 0;
                    r3 = r4.id;
                    r3 = java.lang.Integer.valueOf(r3);
                    r2[r0] = r3;
                    r0 = 1;
                    r3 = r4.cCm;
                    r3 = java.lang.Integer.valueOf(r3);
                    r2[r0] = r3;
                    r0 = 2;
                    r3 = r4.type;
                    r3 = java.lang.Integer.valueOf(r3);
                    r2[r0] = r3;
                    r3 = 3;
                    r0 = r4.name;
                    if (r0 != 0) goto L_0x004e;
                L_0x0026:
                    r0 = "";
                L_0x0029:
                    r2[r3] = r0;
                    r3 = 4;
                    r0 = r4.apU;
                    if (r0 != 0) goto L_0x0051;
                L_0x0030:
                    r0 = "";
                L_0x0033:
                    r2[r3] = r0;
                    r3 = 5;
                    r0 = r4.value;
                    if (r0 != 0) goto L_0x0054;
                L_0x003a:
                    r0 = "";
                L_0x003d:
                    r2[r3] = r0;
                    r3 = 6;
                    r0 = r4.content;
                    if (r0 != 0) goto L_0x0057;
                L_0x0044:
                    r0 = "";
                L_0x0047:
                    r2[r3] = r0;
                    r0 = java.lang.String.format(r1, r2);
                    return r0;
                L_0x004e:
                    r0 = r4.name;
                    goto L_0x0029;
                L_0x0051:
                    r0 = r4.apU;
                    goto L_0x0033;
                L_0x0054:
                    r0 = r4.value;
                    goto L_0x003d;
                L_0x0057:
                    r0 = r4.content;
                    goto L_0x0047;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.toString():java.lang.String");
                }

                public static java.util.List<com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a> b(org.json.JSONArray r10) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = 0;
                    r3 = 0;
                    if (r10 == 0) goto L_0x0097;
                L_0x0004:
                    r0 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x0083 }
                    r0.<init>();	 Catch:{ JSONException -> 0x0083 }
                    r4 = r10.length();	 Catch:{ JSONException -> 0x0083 }
                    r2 = r3;	 Catch:{ JSONException -> 0x0083 }
                L_0x000e:
                    if (r2 >= r4) goto L_0x0098;	 Catch:{ JSONException -> 0x0083 }
                L_0x0010:
                    r5 = r10.getJSONObject(r2);	 Catch:{ JSONException -> 0x0083 }
                    r6 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$a;	 Catch:{ JSONException -> 0x0083 }
                    r6.<init>();	 Catch:{ JSONException -> 0x0083 }
                    r7 = "id";	 Catch:{ JSONException -> 0x0083 }
                    r7 = r5.getInt(r7);	 Catch:{ JSONException -> 0x0083 }
                    r6.id = r7;	 Catch:{ JSONException -> 0x0083 }
                    r7 = "type";	 Catch:{ JSONException -> 0x0083 }
                    r7 = r5.getInt(r7);	 Catch:{ JSONException -> 0x0083 }
                    r6.type = r7;	 Catch:{ JSONException -> 0x0083 }
                    r7 = "name";	 Catch:{ JSONException -> 0x0083 }
                    r7 = r5.getString(r7);	 Catch:{ JSONException -> 0x0083 }
                    r6.name = r7;	 Catch:{ JSONException -> 0x0083 }
                    r7 = "key";	 Catch:{ JSONException -> 0x0083 }
                    r7 = r5.getString(r7);	 Catch:{ JSONException -> 0x0083 }
                    r6.apU = r7;	 Catch:{ JSONException -> 0x0083 }
                    r7 = "value";	 Catch:{ JSONException -> 0x0083 }
                    r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x0083 }
                    r6.value = r7;	 Catch:{ JSONException -> 0x0083 }
                    r7 = "native_url";	 Catch:{ JSONException -> 0x0083 }
                    r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x0083 }
                    r6.cCj = r7;	 Catch:{ JSONException -> 0x0083 }
                    r7 = "MicroMsg.BizInfo";	 Catch:{ JSONException -> 0x0083 }
                    r8 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0083 }
                    r9 = "menuItem.nativeurl : ";	 Catch:{ JSONException -> 0x0083 }
                    r8.<init>(r9);	 Catch:{ JSONException -> 0x0083 }
                    r9 = r6.cCj;	 Catch:{ JSONException -> 0x0083 }
                    r8 = r8.append(r9);	 Catch:{ JSONException -> 0x0083 }
                    r8 = r8.toString();	 Catch:{ JSONException -> 0x0083 }
                    com.tencent.mm.sdk.platformtools.v.d(r7, r8);	 Catch:{ JSONException -> 0x0083 }
                    r7 = "sub_button_list";	 Catch:{ JSONException -> 0x0083 }
                    r7 = r5.optJSONArray(r7);	 Catch:{ JSONException -> 0x0083 }
                    r7 = b(r7);	 Catch:{ JSONException -> 0x0083 }
                    r6.cCk = r7;	 Catch:{ JSONException -> 0x0083 }
                    r7 = "acttype";	 Catch:{ JSONException -> 0x0083 }
                    r5 = r5.optInt(r7);	 Catch:{ JSONException -> 0x0083 }
                    r6.cCm = r5;	 Catch:{ JSONException -> 0x0083 }
                    r0.add(r6);	 Catch:{ JSONException -> 0x0083 }
                    r2 = r2 + 1;
                    goto L_0x000e;
                L_0x0083:
                    r0 = move-exception;
                    r2 = "MicroMsg.BizInfo";
                    r4 = "exception:%s";
                    r5 = 1;
                    r5 = new java.lang.Object[r5];
                    r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
                    r5[r3] = r0;
                    com.tencent.mm.sdk.platformtools.v.e(r2, r4, r5);
                L_0x0096:
                    return r1;
                L_0x0097:
                    r0 = r1;
                L_0x0098:
                    r1 = r0;
                    goto L_0x0096;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.b(org.json.JSONArray):java.util.List<com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$a>");
                }

                public static java.util.LinkedList<com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a> k(java.util.Map<java.lang.String, java.lang.String> r9) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r1 = 0;
                    r4 = 0;
                    if (r9 != 0) goto L_0x0006;
                L_0x0004:
                    r0 = r1;
                L_0x0005:
                    return r0;
                L_0x0006:
                    r0 = ".msg.appmsg.buttonlist.$count";
                    r0 = r9.get(r0);
                    r0 = (java.lang.String) r0;
                    r5 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r4);
                    if (r5 <= 0) goto L_0x012b;
                L_0x0015:
                    r2 = new java.util.LinkedList;	 Catch:{ Exception -> 0x0115 }
                    r2.<init>();	 Catch:{ Exception -> 0x0115 }
                    r0 = "MicroMsg.BizInfo";	 Catch:{ Exception -> 0x0115 }
                    r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0115 }
                    r6 = "menuItem.jsonArray.length : ";	 Catch:{ Exception -> 0x0115 }
                    r3.<init>(r6);	 Catch:{ Exception -> 0x0115 }
                    r3 = r3.append(r5);	 Catch:{ Exception -> 0x0115 }
                    r3 = r3.toString();	 Catch:{ Exception -> 0x0115 }
                    com.tencent.mm.sdk.platformtools.v.v(r0, r3);	 Catch:{ Exception -> 0x0115 }
                    r3 = r4;	 Catch:{ Exception -> 0x0115 }
                L_0x0031:
                    if (r3 >= r5) goto L_0x0112;	 Catch:{ Exception -> 0x0115 }
                L_0x0033:
                    r6 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$a;	 Catch:{ Exception -> 0x0115 }
                    r6.<init>();	 Catch:{ Exception -> 0x0115 }
                    r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0115 }
                    r0 = ".msg.appmsg.buttonlist.button";	 Catch:{ Exception -> 0x0115 }
                    r7.<init>(r0);	 Catch:{ Exception -> 0x0115 }
                    if (r3 != 0) goto L_0x010c;	 Catch:{ Exception -> 0x0115 }
                L_0x0042:
                    r0 = "";	 Catch:{ Exception -> 0x0115 }
                L_0x0045:
                    r0 = r7.append(r0);	 Catch:{ Exception -> 0x0115 }
                    r7 = r0.toString();	 Catch:{ Exception -> 0x0115 }
                    r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0115 }
                    r0.<init>();	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r7);	 Catch:{ Exception -> 0x0115 }
                    r8 = ".id";	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r8);	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.toString();	 Catch:{ Exception -> 0x0115 }
                    r0 = r9.get(r0);	 Catch:{ Exception -> 0x0115 }
                    r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0115 }
                    r8 = 0;	 Catch:{ Exception -> 0x0115 }
                    r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r8);	 Catch:{ Exception -> 0x0115 }
                    r6.id = r0;	 Catch:{ Exception -> 0x0115 }
                    r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0115 }
                    r0.<init>();	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r7);	 Catch:{ Exception -> 0x0115 }
                    r8 = ".type";	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r8);	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.toString();	 Catch:{ Exception -> 0x0115 }
                    r0 = r9.get(r0);	 Catch:{ Exception -> 0x0115 }
                    r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0115 }
                    r8 = 0;	 Catch:{ Exception -> 0x0115 }
                    r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r8);	 Catch:{ Exception -> 0x0115 }
                    r6.type = r0;	 Catch:{ Exception -> 0x0115 }
                    r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0115 }
                    r0.<init>();	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r7);	 Catch:{ Exception -> 0x0115 }
                    r8 = ".name";	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r8);	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.toString();	 Catch:{ Exception -> 0x0115 }
                    r0 = r9.get(r0);	 Catch:{ Exception -> 0x0115 }
                    r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0115 }
                    r6.name = r0;	 Catch:{ Exception -> 0x0115 }
                    r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0115 }
                    r0.<init>();	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r7);	 Catch:{ Exception -> 0x0115 }
                    r8 = ".key";	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r8);	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.toString();	 Catch:{ Exception -> 0x0115 }
                    r0 = r9.get(r0);	 Catch:{ Exception -> 0x0115 }
                    r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0115 }
                    r6.apU = r0;	 Catch:{ Exception -> 0x0115 }
                    r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0115 }
                    r0.<init>();	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r7);	 Catch:{ Exception -> 0x0115 }
                    r8 = ".value";	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r8);	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.toString();	 Catch:{ Exception -> 0x0115 }
                    r0 = r9.get(r0);	 Catch:{ Exception -> 0x0115 }
                    r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0115 }
                    r6.value = r0;	 Catch:{ Exception -> 0x0115 }
                    r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0115 }
                    r0.<init>();	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r7);	 Catch:{ Exception -> 0x0115 }
                    r7 = ".acttype";	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.append(r7);	 Catch:{ Exception -> 0x0115 }
                    r0 = r0.toString();	 Catch:{ Exception -> 0x0115 }
                    r0 = r9.get(r0);	 Catch:{ Exception -> 0x0115 }
                    r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0115 }
                    r7 = 0;	 Catch:{ Exception -> 0x0115 }
                    r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r7);	 Catch:{ Exception -> 0x0115 }
                    r6.cCm = r0;	 Catch:{ Exception -> 0x0115 }
                    r2.add(r6);	 Catch:{ Exception -> 0x0115 }
                    r0 = r3 + 1;	 Catch:{ Exception -> 0x0115 }
                    r3 = r0;	 Catch:{ Exception -> 0x0115 }
                    goto L_0x0031;	 Catch:{ Exception -> 0x0115 }
                L_0x010c:
                    r0 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0115 }
                    goto L_0x0045;
                L_0x0112:
                    r0 = r2;
                    goto L_0x0005;
                L_0x0115:
                    r0 = move-exception;
                    r2 = "MicroMsg.BizInfo";
                    r3 = "exception:%s";
                    r5 = 1;
                    r5 = new java.lang.Object[r5];
                    r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
                    r5[r4] = r0;
                    com.tencent.mm.sdk.platformtools.v.e(r2, r3, r5);
                    r0 = r1;
                    goto L_0x0005;
                L_0x012b:
                    r0 = r1;
                    goto L_0x0005;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.k(java.util.Map):java.util.LinkedList<com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$a>");
                }
            }

            public static class b {
                public String cCn;
                public String cCo;
                public int cCp;
                public String cCq;
                public String cCr;

                public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.b hk(java.lang.String r6) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = "MicroMsg.BizInfo";
                    r1 = new java.lang.StringBuilder;
                    r2 = "EnterpriseBizInfo = ";
                    r1.<init>(r2);
                    r1 = r1.append(r6);
                    r1 = r1.toString();
                    com.tencent.mm.sdk.platformtools.v.i(r0, r1);
                    r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$b;
                    r0.<init>();
                    if (r6 == 0) goto L_0x0023;
                L_0x001d:
                    r1 = r6.length();
                    if (r1 > 0) goto L_0x0024;
                L_0x0023:
                    return r0;
                L_0x0024:
                    r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005e }
                    r1.<init>(r6);	 Catch:{ JSONException -> 0x005e }
                    r2 = "belong";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.cCn = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "freeze_wording";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.cCo = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "child_type";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.cCp = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "home_url";	 Catch:{ JSONException -> 0x005e }
                    r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r0.cCq = r2;	 Catch:{ JSONException -> 0x005e }
                    r2 = "exattr";	 Catch:{ JSONException -> 0x005e }
                    r1 = r1.optString(r2);	 Catch:{ JSONException -> 0x005e }
                    r2 = com.tencent.mm.sdk.platformtools.be.kS(r1);	 Catch:{ JSONException -> 0x005e }
                    if (r2 == 0) goto L_0x0073;	 Catch:{ JSONException -> 0x005e }
                L_0x005a:
                    r1 = 0;	 Catch:{ JSONException -> 0x005e }
                    r0.cCr = r1;	 Catch:{ JSONException -> 0x005e }
                    goto L_0x0023;
                L_0x005e:
                    r1 = move-exception;
                    r2 = "MicroMsg.BizInfo";
                    r3 = "exception:%s";
                    r4 = 1;
                    r4 = new java.lang.Object[r4];
                    r5 = 0;
                    r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
                    r4[r5] = r1;
                    com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
                    goto L_0x0023;
                L_0x0073:
                    r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x005e }
                    r2.<init>(r1);	 Catch:{ JSONException -> 0x005e }
                    r1 = "chat_extension_url";	 Catch:{ JSONException -> 0x005e }
                    r1 = r2.optString(r1);	 Catch:{ JSONException -> 0x005e }
                    r0.cCr = r1;	 Catch:{ JSONException -> 0x005e }
                    goto L_0x0023;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.b.hk(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$b");
                }
            }

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.b hj(java.lang.String r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = "MicroMsg.BizInfo";
                r1 = new java.lang.StringBuilder;
                r2 = "MenuInfo = ";
                r1.<init>(r2);
                r1 = r1.append(r6);
                r1 = r1.toString();
                com.tencent.mm.sdk.platformtools.v.i(r0, r1);
                r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$b;
                r0.<init>();
                if (r6 == 0) goto L_0x0023;
            L_0x001d:
                r1 = r6.length();
                if (r1 > 0) goto L_0x0024;
            L_0x0023:
                return r0;
            L_0x0024:
                r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0040 }
                r1.<init>(r6);	 Catch:{ JSONException -> 0x0040 }
                r2 = "update_time";	 Catch:{ JSONException -> 0x0040 }
                r2 = r1.optInt(r2);	 Catch:{ JSONException -> 0x0040 }
                r0.cCe = r2;	 Catch:{ JSONException -> 0x0040 }
                r2 = "button_list";	 Catch:{ JSONException -> 0x0040 }
                r1 = r1.optJSONArray(r2);	 Catch:{ JSONException -> 0x0040 }
                r1 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a.b(r1);	 Catch:{ JSONException -> 0x0040 }
                r0.cCf = r1;	 Catch:{ JSONException -> 0x0040 }
                goto L_0x0023;
            L_0x0040:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception:%s";
                r4 = 1;
                r4 = new java.lang.Object[r4];
                r5 = 0;
                r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
                goto L_0x0023;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.hj(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$b");
            }
        }

        public static class c {
            public int cCs = 0;
            public String cCt;
            public String cCu;
            public String cCv;
            public String cCw;

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.c hl(java.lang.String r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r6 = 1;
                r5 = 0;
                r0 = com.tencent.mm.sdk.platformtools.be.kS(r7);
                if (r0 == 0) goto L_0x000a;
            L_0x0008:
                r0 = 0;
            L_0x0009:
                return r0;
            L_0x000a:
                r0 = "MicroMsg.BizInfo";
                r1 = "biz verify info is [%s]";
                r2 = new java.lang.Object[r6];
                r2[r5] = r7;
                com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
                r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$c;
                r0.<init>();
                r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0071 }
                r1.<init>(r7);	 Catch:{ Exception -> 0x0071 }
                r2 = "Type";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optInt(r2);	 Catch:{ Exception -> 0x0071 }
                r0.cCs = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "Description";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.cCt = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "Name";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.cCu = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "IntroUrl";	 Catch:{ Exception -> 0x0071 }
                r2 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.cCv = r2;	 Catch:{ Exception -> 0x0071 }
                r2 = "VerifySubTitle";	 Catch:{ Exception -> 0x0071 }
                r1 = r1.optString(r2);	 Catch:{ Exception -> 0x0071 }
                r0.cCw = r1;	 Catch:{ Exception -> 0x0071 }
            L_0x004e:
                r1 = "MicroMsg.BizInfo";
                r2 = "type[%d],desc[%s],name[%s],url[%s]";
                r3 = 4;
                r3 = new java.lang.Object[r3];
                r4 = r0.cCs;
                r4 = java.lang.Integer.valueOf(r4);
                r3[r5] = r4;
                r4 = r0.cCt;
                r3[r6] = r4;
                r4 = 2;
                r5 = r0.cCu;
                r3[r4] = r5;
                r4 = 3;
                r5 = r0.cCv;
                r3[r4] = r5;
                com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
                goto L_0x0009;
            L_0x0071:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception:%s";
                r4 = new java.lang.Object[r6];
                r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
                goto L_0x004e;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.c.hl(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$c");
            }
        }

        public static class d {
            public String cCA;
            public int cCx;
            public String cCy;
            public List<String> cCz;

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.d hm(java.lang.String r8) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = 0;
                r3 = 0;
                r1 = com.tencent.mm.sdk.platformtools.be.kS(r8);
                if (r1 == 0) goto L_0x0009;
            L_0x0008:
                return r0;
            L_0x0009:
                r1 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$d;	 Catch:{ Exception -> 0x005c }
                r1.<init>();	 Catch:{ Exception -> 0x005c }
                r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x005c }
                r2.<init>(r8);	 Catch:{ Exception -> 0x005c }
                r4 = "reputation_level";	 Catch:{ Exception -> 0x005c }
                r5 = -1;	 Catch:{ Exception -> 0x005c }
                r4 = r2.optInt(r4, r5);	 Catch:{ Exception -> 0x005c }
                r1.cCx = r4;	 Catch:{ Exception -> 0x005c }
                r4 = "scope_of_business";	 Catch:{ Exception -> 0x005c }
                r4 = r2.optString(r4);	 Catch:{ Exception -> 0x005c }
                r1.cCy = r4;	 Catch:{ Exception -> 0x005c }
                r4 = "guarantee_detail_h5_url";	 Catch:{ Exception -> 0x005c }
                r4 = r2.optString(r4);	 Catch:{ Exception -> 0x005c }
                r1.cCA = r4;	 Catch:{ Exception -> 0x005c }
                r4 = "guarantee_info";	 Catch:{ Exception -> 0x005c }
                r4 = r2.optJSONArray(r4);	 Catch:{ Exception -> 0x005c }
                if (r4 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x005c }
            L_0x0038:
                r5 = r4.length();	 Catch:{ Exception -> 0x005c }
                if (r5 <= 0) goto L_0x005a;	 Catch:{ Exception -> 0x005c }
            L_0x003e:
                r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x005c }
                r2.<init>();	 Catch:{ Exception -> 0x005c }
                r1.cCz = r2;	 Catch:{ Exception -> 0x005c }
                r2 = r3;	 Catch:{ Exception -> 0x005c }
            L_0x0046:
                if (r2 >= r5) goto L_0x005a;	 Catch:{ Exception -> 0x005c }
            L_0x0048:
                r6 = r4.getString(r2);	 Catch:{ Exception -> 0x005c }
                r7 = com.tencent.mm.sdk.platformtools.be.kS(r6);	 Catch:{ Exception -> 0x005c }
                if (r7 != 0) goto L_0x0057;	 Catch:{ Exception -> 0x005c }
            L_0x0052:
                r7 = r1.cCz;	 Catch:{ Exception -> 0x005c }
                r7.add(r6);	 Catch:{ Exception -> 0x005c }
            L_0x0057:
                r2 = r2 + 1;
                goto L_0x0046;
            L_0x005a:
                r0 = r1;
                goto L_0x0008;
            L_0x005c:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r4 = "exception:%s";
                r5 = 1;
                r5 = new java.lang.Object[r5];
                r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
                r5[r3] = r1;
                com.tencent.mm.sdk.platformtools.v.e(r2, r4, r5);
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.d.hm(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$d");
            }
        }

        public static class e {
            public String cCB;
            public String description;
            public String iconUrl;

            public static java.util.List<com.tencent.mm.modelbiz.BizInfo.ExtInfo.e> c(org.json.JSONArray r7) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r2 = 0;
                r0 = new java.util.LinkedList;
                r0.<init>();
                if (r7 != 0) goto L_0x0009;
            L_0x0008:
                return r0;
            L_0x0009:
                r3 = r7.length();	 Catch:{ Exception -> 0x003a }
                r1 = r2;	 Catch:{ Exception -> 0x003a }
            L_0x000e:
                if (r1 >= r3) goto L_0x0008;	 Catch:{ Exception -> 0x003a }
            L_0x0010:
                r4 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$e;	 Catch:{ Exception -> 0x003a }
                r4.<init>();	 Catch:{ Exception -> 0x003a }
                r5 = r7.optJSONObject(r1);	 Catch:{ Exception -> 0x003a }
                r6 = "icon";	 Catch:{ Exception -> 0x003a }
                r6 = r5.optString(r6);	 Catch:{ Exception -> 0x003a }
                r4.iconUrl = r6;	 Catch:{ Exception -> 0x003a }
                r6 = "description";	 Catch:{ Exception -> 0x003a }
                r6 = r5.optString(r6);	 Catch:{ Exception -> 0x003a }
                r4.description = r6;	 Catch:{ Exception -> 0x003a }
                r6 = "description_key";	 Catch:{ Exception -> 0x003a }
                r5 = r5.optString(r6);	 Catch:{ Exception -> 0x003a }
                r4.cCB = r5;	 Catch:{ Exception -> 0x003a }
                r0.add(r4);	 Catch:{ Exception -> 0x003a }
                r1 = r1 + 1;
                goto L_0x000e;
            L_0x003a:
                r1 = move-exception;
                r3 = "MicroMsg.BizInfo";
                r4 = "exception:%s";
                r5 = 1;
                r5 = new java.lang.Object[r5];
                r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
                r5[r2] = r1;
                com.tencent.mm.sdk.platformtools.v.e(r3, r4, r5);
                goto L_0x0008;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.e.c(org.json.JSONArray):java.util.List<com.tencent.mm.modelbiz.BizInfo$ExtInfo$e>");
            }
        }

        public static class f {
            public String cCC;
            public String cCD;

            public static com.tencent.mm.modelbiz.BizInfo.ExtInfo.f hn(java.lang.String r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = 1;
                r5 = 0;
                r0 = "MicroMsg.BizInfo";
                r1 = "RegisterSource = %s";
                r2 = new java.lang.Object[r4];
                r2[r5] = r6;
                com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
                r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$f;
                r0.<init>();
                if (r6 == 0) goto L_0x001c;
            L_0x0016:
                r1 = r6.length();
                if (r1 > 0) goto L_0x001d;
            L_0x001c:
                return r0;
            L_0x001d:
                r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0035 }
                r1.<init>(r6);	 Catch:{ JSONException -> 0x0035 }
                r2 = "RegisterBody";	 Catch:{ JSONException -> 0x0035 }
                r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x0035 }
                r0.cCC = r2;	 Catch:{ JSONException -> 0x0035 }
                r2 = "IntroUrl";	 Catch:{ JSONException -> 0x0035 }
                r1 = r1.optString(r2);	 Catch:{ JSONException -> 0x0035 }
                r0.cCD = r1;	 Catch:{ JSONException -> 0x0035 }
                goto L_0x001c;
            L_0x0035:
                r1 = move-exception;
                r2 = "MicroMsg.BizInfo";
                r3 = "exception in RegisterSource:%s";
                r4 = new java.lang.Object[r4];
                r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
                r4[r5] = r1;
                com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
                goto L_0x001c;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.f.hn(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo$f");
            }
        }

        public final java.util.List<com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo> CH() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r7 = this;
            r0 = 0;
            r1 = r7.cCa;
            if (r1 != 0) goto L_0x0083;
        L_0x0005:
            r1 = new java.util.LinkedList;
            r1.<init>();
            r7.cCa = r1;
            r1 = r7.cBx;
            if (r1 == 0) goto L_0x0083;
        L_0x0010:
            r1 = r7.cBx;
            r2 = "BindWxaInfo";
            r2 = r1.optString(r2);
            r1 = android.text.TextUtils.isEmpty(r2);
            if (r1 != 0) goto L_0x0081;
        L_0x001f:
            r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0080 }
            r1.<init>(r2);	 Catch:{ JSONException -> 0x0080 }
        L_0x0024:
            if (r1 == 0) goto L_0x0086;
        L_0x0026:
            r0 = "wxaEntryInfo";
            r0 = r1.optJSONArray(r0);
            r1 = r0;
        L_0x002e:
            if (r1 == 0) goto L_0x0083;
        L_0x0030:
            r0 = 0;
        L_0x0031:
            r2 = r1.length();
            if (r0 >= r2) goto L_0x0083;
        L_0x0037:
            r2 = r1.optJSONObject(r0);
            if (r2 == 0) goto L_0x007d;
        L_0x003d:
            r3 = "username";
            r3 = r2.optString(r3);
            r4 = "title";
            r4 = r2.optString(r4);
            r5 = "title_key";
            r5 = r2.optString(r5);
            r6 = "icon_url";
            r2 = r2.optString(r6);
            r6 = android.text.TextUtils.isEmpty(r3);
            if (r6 != 0) goto L_0x007d;
        L_0x005f:
            r6 = android.text.TextUtils.isEmpty(r4);
            if (r6 == 0) goto L_0x006b;
        L_0x0065:
            r6 = android.text.TextUtils.isEmpty(r5);
            if (r6 != 0) goto L_0x007d;
        L_0x006b:
            r6 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo$WxaEntryInfo;
            r6.<init>();
            r6.username = r3;
            r6.title = r4;
            r6.cCE = r5;
            r6.iconUrl = r2;
            r2 = r7.cCa;
            r2.add(r6);
        L_0x007d:
            r0 = r0 + 1;
            goto L_0x0031;
        L_0x0080:
            r1 = move-exception;
        L_0x0081:
            r1 = r0;
            goto L_0x0024;
        L_0x0083:
            r0 = r7.cCa;
            return r0;
        L_0x0086:
            r1 = r0;
            goto L_0x002e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CH():java.util.List<com.tencent.mm.modelbiz.BizInfo$ExtInfo$WxaEntryInfo>");
        }

        public final boolean CI() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r2 = 1;
            r0 = r3.cBx;
            if (r0 == 0) goto L_0x0024;
        L_0x0005:
            r0 = r3.cBx;
            r1 = "WifiBizInfo";
            r0 = r0.optJSONObject(r1);
            if (r0 == 0) goto L_0x0024;
        L_0x0010:
            r0 = r3.cBx;
            r1 = "WifiBizInfo";
            r0 = r0.optJSONObject(r1);
            r1 = "IsWXWiFi";
            r0 = r0.optInt(r1);
            if (r0 != r2) goto L_0x0024;
        L_0x0022:
            r3.cBZ = r2;
        L_0x0024:
            r0 = r3.cBZ;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CI():boolean");
        }

        public final boolean CJ() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x0015;
        L_0x0004:
            r0 = r2.cBx;
            r1 = "NotifyManage";
            r0 = r0.optString(r1);
            r1 = com.tencent.mm.modelbiz.BizInfo.cBq;
            r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r1);
            r2.cBS = r0;
        L_0x0015:
            r0 = r2.cBS;
            r1 = com.tencent.mm.modelbiz.BizInfo.cBp;
            if (r0 != r1) goto L_0x001d;
        L_0x001b:
            r0 = 1;
        L_0x001c:
            return r0;
        L_0x001d:
            r0 = 0;
            goto L_0x001c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CJ():boolean");
        }

        public final java.lang.String CK() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.cBx;
            r1 = "VerifyContactPromptTitle";
            r0 = r0.optString(r1);
            r2.cBC = r0;
        L_0x000f:
            r0 = r2.cBC;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CK():java.lang.String");
        }

        public final java.lang.String CL() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.cBx;
            r1 = "TrademarkUrl";
            r0 = r0.optString(r1);
            r2.cBX = r0;
        L_0x000f:
            r0 = r2.cBX;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CL():java.lang.String");
        }

        public final java.lang.String CM() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.cBx;
            r1 = "TrademarkName";
            r0 = r0.optString(r1);
            r2.cBY = r0;
        L_0x000f:
            r0 = r2.cBY;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CM():java.lang.String");
        }

        public final java.lang.String CN() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.cBx;
            r1 = "ConferenceContactExpireTime";
            r0 = r0.optString(r1);
            r2.cBD = r0;
        L_0x000f:
            r0 = r2.cBD;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CN():java.lang.String");
        }

        public final java.util.List<com.tencent.mm.modelbiz.BizInfo.ExtInfo.e> CO() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r2.cBE;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r2.cBx;
            r1 = "Privilege";
            r0 = r0.optJSONArray(r1);
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.e.c(r0);
            r2.cBE = r0;
        L_0x0017:
            r0 = r2.cBE;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CO():java.util.List<com.tencent.mm.modelbiz.BizInfo$ExtInfo$e>");
        }

        public final int CP() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.cBx;
            r1 = "InteractiveMode";
            r0 = r0.optInt(r1);
            r2.cBR = r0;
        L_0x000f:
            r0 = r2.cBR;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CP():int");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.d CQ() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r2.cBH;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r2.cBx;
            r1 = "PayShowInfo";
            r0 = r0.optString(r1);
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.d.hm(r0);
            r2.cBH = r0;
        L_0x0017:
            r0 = r2.cBH;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CQ():com.tencent.mm.modelbiz.BizInfo$ExtInfo$d");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.a CR() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.cBQ;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.cBx;
            r1 = "HardwareBizInfo";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.a.hi(r0);
            r2.cBQ = r0;
        L_0x0019:
            r0 = r2.cBQ;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CR():com.tencent.mm.modelbiz.BizInfo$ExtInfo$a");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.c CS() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x0017;
        L_0x0004:
            r0 = r2.cBF;
            if (r0 != 0) goto L_0x0017;
        L_0x0008:
            r0 = r2.cBx;
            r1 = "VerifySource";
            r0 = r0.optString(r1);
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.c.hl(r0);
            r2.cBF = r0;
        L_0x0017:
            r0 = r2.cBF;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CS():com.tencent.mm.modelbiz.BizInfo$ExtInfo$c");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.f CT() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.cBW;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.cBx;
            r1 = "RegisterSource";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.f.hn(r0);
            r2.cBW = r0;
        L_0x0019:
            r0 = r2.cBW;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CT():com.tencent.mm.modelbiz.BizInfo$ExtInfo$f");
        }

        public final boolean Cv() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = 0;
            r1 = r3.cBx;
            if (r1 == 0) goto L_0x0017;
        L_0x0005:
            r1 = r3.cBx;
            r2 = "ReportLocationType";
            r1 = r1.optString(r2);
            r1 = com.tencent.mm.sdk.platformtools.be.getInt(r1, r0);
            if (r1 <= 0) goto L_0x0015;
        L_0x0014:
            r0 = 1;
        L_0x0015:
            r3.cBJ = r0;
        L_0x0017:
            r0 = r3.cBJ;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.Cv():boolean");
        }

        public final boolean CU() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r4 = this;
            r0 = 1;
            r1 = 0;
            r2 = r4.cBx;
            if (r2 == 0) goto L_0x0017;
        L_0x0006:
            r2 = r4.cBx;
            r3 = "IsTrademarkProtection";
            r2 = r2.optString(r3);
            r2 = com.tencent.mm.sdk.platformtools.be.getInt(r2, r1);
            if (r2 != r0) goto L_0x001a;
        L_0x0015:
            r4.cBU = r0;
        L_0x0017:
            r0 = r4.cBU;
            return r0;
        L_0x001a:
            r0 = r1;
            goto L_0x0015;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CU():boolean");
        }

        public final int CV() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r0 = r3.cBx;
            if (r0 == 0) goto L_0x0010;
        L_0x0004:
            r0 = r3.cBx;
            r1 = "ServiceType";
            r2 = 0;
            r0 = r0.optInt(r1, r2);
            r3.cBO = r0;
        L_0x0010:
            r0 = r3.cBO;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CV():int");
        }

        public final java.lang.String CW() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.cBx;
            r1 = "SupportEmoticonLinkPrefix";
            r0 = r0.optString(r1);
            r2.cBP = r0;
        L_0x000f:
            r0 = r2.cBP;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CW():java.lang.String");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.b CX() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.cBG;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.cBx;
            r1 = "MMBizMenu";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.hj(r0);
            r2.cBG = r0;
        L_0x0019:
            r0 = r2.cBG;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CX():com.tencent.mm.modelbiz.BizInfo$ExtInfo$b");
        }

        public final java.lang.String CY() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x000f;
        L_0x0004:
            r0 = r2.cBx;
            r1 = "ServicePhone";
            r0 = r0.optString(r1);
            r2.cBT = r0;
        L_0x000f:
            r0 = r2.cBT;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CY():java.lang.String");
        }

        private ExtInfo() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r3 = this;
            r2 = 0;
            r1 = 0;
            r3.<init>();
            r3.cBx = r2;
            r0 = 1;
            r3.cBy = r0;
            r3.cBz = r1;
            r3.cBA = r1;
            r3.cBB = r1;
            r3.cBE = r2;
            r3.cBF = r2;
            r3.cBG = r2;
            r3.cBH = r2;
            r3.cBI = r2;
            r3.cBJ = r1;
            r3.cBK = r1;
            r3.cBM = r1;
            r3.cBN = r1;
            r3.cBO = r1;
            r3.cBQ = r2;
            r3.cBR = r1;
            r0 = com.tencent.mm.modelbiz.BizInfo.cBq;
            r3.cBS = r0;
            r3.cBU = r1;
            r3.cBZ = r1;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.<init>():void");
        }

        static com.tencent.mm.modelbiz.BizInfo.ExtInfo hh(java.lang.String r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = new com.tencent.mm.modelbiz.BizInfo$ExtInfo;
            r0.<init>();
            r1 = com.tencent.mm.sdk.platformtools.be.kS(r6);
            if (r1 == 0) goto L_0x000c;
        L_0x000b:
            return r0;
        L_0x000c:
            java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0017 }
            r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0017 }
            r1.<init>(r6);	 Catch:{ Exception -> 0x0017 }
            r0.cBx = r1;	 Catch:{ Exception -> 0x0017 }
            goto L_0x000b;
        L_0x0017:
            r1 = move-exception;
            r2 = "MicroMsg.BizInfo";
            r3 = "exception:%s";
            r4 = 1;
            r4 = new java.lang.Object[r4];
            r5 = 0;
            r1 = com.tencent.mm.sdk.platformtools.be.e(r1);
            r4[r5] = r1;
            com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
            goto L_0x000b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.hh(java.lang.String):com.tencent.mm.modelbiz.BizInfo$ExtInfo");
        }

        public final com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.b CZ() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r2 = this;
            r0 = r2.cBx;
            if (r0 == 0) goto L_0x0019;
        L_0x0004:
            r0 = r2.cBI;
            if (r0 != 0) goto L_0x0019;
        L_0x0008:
            r0 = r2.cBx;
            r1 = "EnterpriseBizInfo";
            r0 = r0.optString(r1);
            if (r0 == 0) goto L_0x0019;
        L_0x0013:
            r0 = com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.b.hk(r0);
            r2.cBI = r0;
        L_0x0019:
            r0 = r2.cBI;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelbiz.BizInfo.ExtInfo.CZ():com.tencent.mm.modelbiz.BizInfo$ExtInfo$b$b");
        }
    }

    public static class a {
        public String cBw;
        public String description;
        public String title;
        public String url;
    }

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[19];
        aVar.bXK = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "username";
        aVar.nmd.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "username";
        aVar.bXK[1] = "brandList";
        aVar.nmd.put("brandList", "TEXT default '' ");
        stringBuilder.append(" brandList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.bXK[2] = "brandListVersion";
        aVar.nmd.put("brandListVersion", "TEXT");
        stringBuilder.append(" brandListVersion TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "brandListContent";
        aVar.nmd.put("brandListContent", "TEXT");
        stringBuilder.append(" brandListContent TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "brandFlag";
        aVar.nmd.put("brandFlag", "INTEGER");
        stringBuilder.append(" brandFlag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[5] = "extInfo";
        aVar.nmd.put("extInfo", "TEXT");
        stringBuilder.append(" extInfo TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "brandInfo";
        aVar.nmd.put("brandInfo", "TEXT");
        stringBuilder.append(" brandInfo TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "brandIconURL";
        aVar.nmd.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "updateTime";
        aVar.nmd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[9] = "hadAlert";
        aVar.nmd.put("hadAlert", "INTEGER");
        stringBuilder.append(" hadAlert INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "acceptType";
        aVar.nmd.put("acceptType", "INTEGER default '0' ");
        stringBuilder.append(" acceptType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[11] = "type";
        aVar.nmd.put("type", "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[12] = "status";
        aVar.nmd.put("status", "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[13] = "enterpriseFather";
        aVar.nmd.put("enterpriseFather", "TEXT");
        stringBuilder.append(" enterpriseFather TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "kfWorkerId";
        aVar.nmd.put("kfWorkerId", "TEXT");
        stringBuilder.append(" kfWorkerId TEXT");
        stringBuilder.append(", ");
        aVar.bXK[15] = "specialType";
        aVar.nmd.put("specialType", "INTEGER");
        stringBuilder.append(" specialType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[16] = "attrSyncVersion";
        aVar.nmd.put("attrSyncVersion", "TEXT");
        stringBuilder.append(" attrSyncVersion TEXT");
        stringBuilder.append(", ");
        aVar.bXK[17] = "incrementUpdateTime";
        aVar.nmd.put("incrementUpdateTime", "LONG");
        stringBuilder.append(" incrementUpdateTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[18] = "bitFlag";
        aVar.nmd.put("bitFlag", "INTEGER default '0' ");
        stringBuilder.append(" bitFlag INTEGER default '0' ");
        aVar.bXK[19] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }

    public final ExtInfo aX(boolean z) {
        if (this.cBt == null || z) {
            System.currentTimeMillis();
            if (be.kS(this.field_extInfo) || cBu != this.field_extInfo.hashCode()) {
                ExtInfo hh = ExtInfo.hh(this.field_extInfo);
                this.cBt = hh;
                cBv = hh;
                cBu = be.ma(this.field_extInfo).hashCode();
            } else {
                this.cBt = cBv;
            }
        }
        return this.cBt;
    }

    public final boolean Cr() {
        return (this.field_brandFlag & 1) == 0;
    }

    public final boolean Cs() {
        return (this.field_brandFlag & 4) != 0;
    }

    public final boolean Ct() {
        if (System.currentTimeMillis() - this.field_updateTime > 86400000) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        if (this.field_updateTime >= instance.getTimeInMillis()) {
            return false;
        }
        return true;
    }

    public final void Cu() {
        aX(false);
        ExtInfo extInfo = this.cBt;
        if (extInfo.cBx != null) {
            extInfo.cBL = extInfo.cBx.optInt("ConnectorMsgType");
        }
        this.field_acceptType = extInfo.cBL;
        this.field_type = aX(false).CV();
        if (CB()) {
            ff(1);
        } else {
            this.field_bitFlag &= -2;
        }
    }

    public final boolean Cv() {
        aX(false);
        v.i("MicroMsg.BizInfo", "is report location, user %s %B", this.field_username, Boolean.valueOf(this.cBt.Cv()));
        return this.cBt.Cv();
    }

    public final boolean Cw() {
        aX(false);
        if (this.field_type == 1) {
            return true;
        }
        return false;
    }

    public final boolean Cx() {
        aX(false);
        if (this.field_type == 0) {
            return true;
        }
        return false;
    }

    public final boolean Cy() {
        aX(false);
        if (this.field_type == 2 || this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean Cz() {
        aX(false);
        if (this.field_type == 2) {
            return true;
        }
        return false;
    }

    public final boolean CA() {
        aX(false);
        if (this.field_type == 3) {
            return true;
        }
        return false;
    }

    public final boolean CB() {
        aX(false);
        if (this.cBt == null || this.cBt.CZ() == null) {
            return false;
        }
        boolean z = this.cBt.cBI.cCp == 1;
        if (z && !fe(1)) {
            ff(1);
            u.Dy().e(this);
        }
        if (!z) {
            return z;
        }
        v.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", this.field_username);
        return z;
    }

    public final boolean CC() {
        aX(false);
        if (this.cBt == null || this.cBt.CZ() == null) {
            return false;
        }
        boolean z = this.cBt.cBI.cCp == 2;
        if (z && !fe(2)) {
            ff(2);
            u.Dy().e(this);
        }
        if (!z) {
            return z;
        }
        v.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", this.field_username);
        return z;
    }

    public final String CD() {
        aX(false);
        if (this.cBt != null) {
            b CZ = this.cBt.CZ();
            if (!(CZ == null || CZ.cCq == null || CZ.cCq.isEmpty())) {
                return CZ.cCq;
            }
        }
        return null;
    }

    public final String CE() {
        aX(false);
        if (this.cBt != null) {
            b CZ = this.cBt.CZ();
            if (CZ != null) {
                return CZ.cCr;
            }
        }
        return null;
    }

    public final String CF() {
        String str = aX(false).CZ().cCn;
        if (be.kS(str)) {
            v.e("MicroMsg.BizInfo", "check father: %s, %s", this.field_username, str);
        }
        return str;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }

    public final ContentValues py() {
        return super.py();
    }

    public final List<a> CG() {
        if (this.cBs != null) {
            return this.cBs;
        }
        this.cBs = new LinkedList();
        if (this.field_brandInfo == null || this.field_brandInfo.length() == 0) {
            return this.cBs;
        }
        try {
            JSONArray optJSONArray = new JSONObject(this.field_brandInfo).optJSONArray("urls");
            for (int i = 0; i < optJSONArray.length(); i++) {
                a aVar = new a();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                aVar.title = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
                aVar.url = optJSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                aVar.cBw = optJSONObject.optString("title_key");
                aVar.description = optJSONObject.optString("description");
                this.cBs.add(aVar);
            }
        } catch (Throwable e) {
            v.e("MicroMsg.BizInfo", "exception:%s", be.e(e));
        }
        return this.cBs;
    }

    private boolean fe(int i) {
        return (this.field_bitFlag & i) != 0;
    }

    private void ff(int i) {
        this.field_bitFlag |= i;
    }
}
