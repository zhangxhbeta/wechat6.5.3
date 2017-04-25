package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.be;
import java.util.List;

public final class n {
    public static n iwT;
    public String aGX;
    public String bCc;
    public b iwA;
    public String iwB;
    c iwC;
    public c iwD;
    c iwE;
    public String iwF;
    public a iwG;
    public a iwH;
    public a iwI;
    public a iwJ;
    public List<String> iwK;
    public List<String> iwL;
    public List<String> iwM;
    public List<String> iwN;
    public List<String> iwO;
    public String iwP;
    public String iwQ;
    public String iwR;
    public String iwS;
    public String title;
    public String url;

    public static class a {
        private String cJg;
        private String cJi;
        private String dan;
        private String iwU;
        private String iwV;
        private String iwW;
        private String iwX;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            if (str == null) {
                str = "";
            }
            this.iwU = str;
            if (str2 == null) {
                str2 = "";
            }
            this.iwV = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.iwW = str3;
            if (str4 == null) {
                str4 = "";
            }
            this.cJi = str4;
            if (str5 == null) {
                str5 = "";
            }
            this.dan = str5;
            if (str6 == null) {
                str6 = "";
            }
            this.iwX = str6;
            if (str7 == null) {
                str7 = "";
            }
            this.cJg = str7;
        }

        public final String aKW() {
            StringBuilder stringBuilder;
            if (be.Ku(this.iwU) || be.Ku(this.iwV) || be.Ku(this.iwW) || be.Ku(this.cJi) || be.Ku(this.dan) || be.Ku(this.cJg)) {
                stringBuilder = new StringBuilder();
                if (this.cJg.length() > 0) {
                    stringBuilder.append(this.cJg);
                    stringBuilder.append("\n");
                }
                if (this.dan.length() > 0) {
                    stringBuilder.append(this.dan + " ");
                }
                if (this.cJi.length() > 0) {
                    stringBuilder.append(this.cJi);
                }
                if (this.dan.length() > 0 || this.cJi.length() > 0) {
                    stringBuilder.append("\n");
                }
                if (this.iwW.length() > 0) {
                    stringBuilder.append(this.iwW + " ");
                    stringBuilder.append("\n");
                }
                if (this.iwV.length() > 0) {
                    stringBuilder.append(this.iwV);
                    stringBuilder.append("\n");
                }
                if (this.iwU.length() > 0) {
                    stringBuilder.append(this.iwU);
                    stringBuilder.append("\n");
                }
                if (this.iwX.length() > 0) {
                    stringBuilder.append(this.iwX);
                }
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            if (this.iwU.length() > 0) {
                stringBuilder.append(this.iwU);
                stringBuilder.append("\n");
            }
            if (this.iwV.length() > 0) {
                stringBuilder.append(this.iwV);
                stringBuilder.append("\n");
            }
            if (this.iwW.length() > 0) {
                stringBuilder.append(this.iwW);
                stringBuilder.append("\n");
            }
            if (this.cJi.length() > 0) {
                stringBuilder.append(this.cJi + " ");
            }
            if (this.dan.length() > 0) {
                stringBuilder.append(this.dan + " ");
            }
            if (this.iwX.length() > 0) {
                stringBuilder.append(this.iwX);
            }
            if (this.cJi.length() > 0 || this.dan.length() > 0) {
                stringBuilder.append("\n");
            }
            if (this.cJg.length() > 0) {
                stringBuilder.append(this.cJg);
            }
            return stringBuilder.toString();
        }
    }

    public static class b {
        private String iwY;
        private String iwZ;
        private String ixa;

        public b(String str, String str2, String str3) {
            if (str == null) {
                str = "";
            }
            this.iwY = str;
            if (str2 == null) {
                str2 = "";
            }
            this.iwZ = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.ixa = str3;
        }

        public final String aKW() {
            StringBuilder stringBuilder = new StringBuilder();
            if (be.Ku(this.iwY) || be.Ku(this.iwZ) || be.Ku(this.ixa)) {
                if (this.ixa.trim().length() > 0) {
                    stringBuilder.append(this.ixa);
                }
                if (this.iwZ.trim().length() > 0) {
                    stringBuilder.append(this.iwZ);
                }
                if (this.iwY.trim().length() > 0) {
                    stringBuilder.append(this.iwY);
                }
            } else {
                if (this.iwY.trim().length() > 0) {
                    stringBuilder.append(this.iwY);
                }
                if (this.iwZ.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.iwZ);
                }
                if (this.ixa.trim().length() > 0) {
                    stringBuilder.append(" ");
                    stringBuilder.append(this.ixa);
                }
            }
            return stringBuilder.toString();
        }
    }

    public static class c {
        public String ixb;
        public String ixc;

        public c(String str, String str2) {
            this.ixb = str;
            this.ixc = str2;
        }
    }
}
