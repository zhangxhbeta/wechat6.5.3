package com.tencent.mm.wallet_core.b;

import android.text.TextUtils;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collection;

public final class n {
    public static int kWZ = 1;
    public static int kXa = 2;
    public static long piG = 0;

    public static void bLg() {
        piG = System.currentTimeMillis();
    }

    public static int bLh() {
        return (int) ((System.currentTimeMillis() - piG) / 1000);
    }

    public static void b(String str, String str2, String str3, int i, String str4) {
        Exception e;
        if (str3 != null && str3.length() > 0) {
            String str5;
            String str6;
            try {
                int i2;
                char charAt;
                if (Character.isDigit(str3.charAt(0))) {
                    i2 = 0;
                    str5 = null;
                    str6 = str3;
                    while (i2 < str6.length()) {
                        try {
                            charAt = str6.charAt(i2);
                            if (!(Character.isDigit(charAt) || ".".equalsIgnoreCase(String.valueOf(charAt)))) {
                                str5 = str6.substring(i2).trim();
                                str6 = str6.substring(0, i2 - 1).trim();
                            }
                            i2++;
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                } else {
                    str5 = null;
                    str6 = str3;
                    for (i2 = 0; i2 < str6.length(); i2++) {
                        charAt = str6.charAt(i2);
                        if (Character.isDigit(charAt) || ".".equalsIgnoreCase(String.valueOf(charAt))) {
                            str5 = str6.substring(0, i2 - 1).trim();
                            str6 = str6.substring(i2).trim();
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                str5 = null;
                str6 = str3;
                v.e("MicroMsg.WalletReportUtil", "", new Object[]{e});
                g.iuh.h(10756, new Object[]{str, str2, str6, str5, Integer.valueOf(i), str4});
            }
            g.iuh.h(10756, new Object[]{str, str2, str6, str5, Integer.valueOf(i), str4});
        }
    }

    public static void dB(int i, int i2) {
        g.iuh.h(12097, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis())});
    }

    public static void a(int i, int i2, int i3, int i4, long j, int i5, String str) {
        IDKey iDKey;
        if (dC(i, i2) || dD(i, i2) || dE(i, i2) || yy(i) || dF(i, i2)) {
            v.i("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the cmdType is for idkey report cmdType:" + i + " cmdid:" + i2);
            int i6 = -1;
            if (i5 == 4) {
                i6 = 132;
            } else if (i5 == 1) {
                i6 = 163;
            } else if (i5 == 2 || i5 == 36) {
                i6 = 131;
            } else if (i5 == 3) {
                i6 = 130;
            } else if (i5 == 5) {
                i6 = 153;
            } else if (i5 == 100) {
                i6 = e.CTRL_INDEX;
            } else if (i5 == 6 || i5 == 1001) {
                i6 = com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX;
            } else if (i5 == 11) {
                i6 = d.CTRL_INDEX;
            } else if (i5 == 21) {
                i6 = 139;
            } else if (i5 == 31 || i5 == 33 || i5 == 32) {
                i6 = 118;
            } else if (i5 == 37) {
                i6 = 117;
            } else if (i5 == 39) {
                i6 = 298;
            }
            if (i6 == -1) {
                v.e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay get ID by scene is -1, the scene is " + i5);
                i6 = -1;
                if (i == 385 && i2 == 74) {
                    i6 = d.CTRL_INDEX;
                }
                if (i == 385 && i2 == 75) {
                    i6 = 139;
                } else if (yy(i)) {
                    i6 = 117;
                } else if (dF(i, i2)) {
                    i6 = t.CTRL_INDEX;
                } else if (i == 397) {
                    i6 = 131;
                } else if (i == 398) {
                    i6 = 130;
                } else if (i == 422) {
                    i6 = 153;
                } else if (i == 556) {
                    i6 = com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX;
                } else if (i == 498) {
                    i6 = e.CTRL_INDEX;
                } else if (i == 1544 || i == 1582) {
                    i6 = 118;
                } else if (i == 1575) {
                    i6 = 117;
                }
            }
            if (i6 == -1) {
                v.e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the cmdType is for idkey report cmdType:" + i + " cmdid:" + i2 + " , ID is -1");
                i6 = -1;
                if (TextUtils.isEmpty(str)) {
                    i6 = -1;
                } else if (str.equals("BalanceFetchProcess")) {
                    i6 = 139;
                } else if (str.equals("BalanceSaveProcess")) {
                    i6 = d.CTRL_INDEX;
                }
            }
            if (i6 == -1) {
                v.e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the processName is for idkey report processName:" + str + " , ID is -1");
                return;
            }
            iDKey = new IDKey();
            iDKey.SetID(i6);
            iDKey.SetValue(1);
            if (dC(i, i2)) {
                iDKey.SetKey(26);
            } else if (dD(i, i2)) {
                iDKey.SetKey(45);
            } else if (yy(i)) {
                if (i == 1581) {
                    iDKey.SetKey(64);
                } else {
                    iDKey.SetKey(83);
                }
            } else if (dF(i, i2)) {
                if (i2 == 0) {
                    iDKey.SetKey(7);
                } else {
                    iDKey.SetKey(26);
                }
            } else if (dE(i, i2)) {
                iDKey.SetKey(7);
            } else {
                v.e("MicroMsg.WalletReportUtil", "reportIDKeyWalletPay the cmdType is for idkey report cmdType:" + i + " cmdid:" + i2 + " , ID is -1");
                return;
            }
            ArrayList arrayList = new ArrayList();
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(i6);
            iDKey2.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i6);
            iDKey3.SetValue(1);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(i6);
            iDKey4.SetValue((int) j);
            if (dC(i, i2)) {
                iDKey2.SetKey(19);
                if (j <= 1000) {
                    iDKey3.SetKey(20);
                    iDKey4.SetKey(23);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(21);
                    iDKey4.SetKey(24);
                } else if (j > 3000) {
                    iDKey3.SetKey(22);
                    iDKey4.SetKey(25);
                }
            } else if (dD(i, i2)) {
                iDKey2.SetKey(38);
                if (j <= 1000) {
                    iDKey3.SetKey(39);
                    iDKey4.SetKey(42);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(40);
                    iDKey4.SetKey(43);
                } else if (j > 3000) {
                    iDKey3.SetKey(41);
                    iDKey4.SetKey(44);
                }
            } else if (i == 1581) {
                iDKey2.SetKey(57);
                if (j <= 1000) {
                    iDKey3.SetKey(58);
                    iDKey4.SetKey(61);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(59);
                    iDKey4.SetKey(62);
                } else if (j > 3000) {
                    iDKey3.SetKey(60);
                    iDKey4.SetKey(63);
                }
            } else if (i == 1685) {
                iDKey2.SetKey(76);
                if (j <= 1000) {
                    iDKey3.SetKey(77);
                    iDKey4.SetKey(80);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(78);
                    iDKey4.SetKey(81);
                } else if (j > 3000) {
                    iDKey3.SetKey(79);
                    iDKey4.SetKey(82);
                }
            } else if (i == 1558 && i2 == 0) {
                iDKey2.SetKey(0);
                if (j <= 1000) {
                    iDKey3.SetKey(1);
                    iDKey4.SetKey(4);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(2);
                    iDKey4.SetKey(5);
                } else if (j > 3000) {
                    iDKey3.SetKey(3);
                    iDKey4.SetKey(6);
                }
            } else if (i == 1558 && i2 == 1) {
                iDKey2.SetKey(19);
                if (j <= 1000) {
                    iDKey3.SetKey(20);
                    iDKey4.SetKey(23);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(21);
                    iDKey4.SetKey(24);
                } else if (j > 3000) {
                    iDKey3.SetKey(22);
                    iDKey4.SetKey(25);
                }
            } else {
                iDKey2.SetKey(0);
                if (j <= 1000) {
                    iDKey3.SetKey(1);
                    iDKey4.SetKey(4);
                } else if (j > 1000 && j <= 3000) {
                    iDKey3.SetKey(2);
                    iDKey4.SetKey(5);
                } else if (j > 3000) {
                    iDKey3.SetKey(3);
                    iDKey4.SetKey(6);
                }
            }
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            g gVar = g.iuh;
            g.d(arrayList, true);
            arrayList = new ArrayList();
            if (!(i3 == 0 && i4 == 0)) {
                Collection arrayList2 = new ArrayList();
                iDKey3 = new IDKey();
                iDKey3.SetID(i6);
                iDKey3.SetValue(1);
                iDKey4 = new IDKey();
                iDKey4.SetID(i6);
                iDKey4.SetValue(1);
                if (dC(i, i2)) {
                    iDKey3.SetKey(27);
                    if (i4 < 0) {
                        iDKey4.SetKey(28);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(29);
                    }
                } else if (dD(i, i2)) {
                    iDKey3.SetKey(46);
                    if (i4 < 0) {
                        iDKey4.SetKey(47);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(48);
                    }
                } else if (i == 1581) {
                    iDKey3.SetKey(65);
                    if (i4 < 0) {
                        iDKey4.SetKey(66);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(67);
                    }
                } else if (i == 1685) {
                    iDKey3.SetKey(84);
                    if (i4 < 0) {
                        iDKey4.SetKey(85);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(86);
                    }
                } else if (i == 1558 && i2 == 0) {
                    iDKey3.SetKey(8);
                    if (i4 < 0) {
                        iDKey4.SetKey(9);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(10);
                    }
                } else if (i == 1558 && i2 == 1) {
                    iDKey3.SetKey(27);
                    if (i4 < 0) {
                        iDKey4.SetKey(28);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(29);
                    }
                } else {
                    iDKey3.SetKey(8);
                    if (i4 < 0) {
                        iDKey4.SetKey(9);
                    } else if (i4 > 0) {
                        iDKey4.SetKey(10);
                    }
                }
                arrayList2.add(iDKey3);
                arrayList2.add(iDKey4);
                arrayList.addAll(arrayList2);
            }
            arrayList.add(iDKey);
            g gVar2 = g.iuh;
            g.d(arrayList, true);
            return;
        }
        Object obj = (i == 385 && i2 == 19) ? 1 : null;
        if (obj != null) {
            ArrayList arrayList3 = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.g.CTRL_INDEX);
            iDKey.SetValue(1);
            iDKey.SetKey(0);
            arrayList3.add(iDKey);
            if (!(i3 == 0 && i4 == 0)) {
                iDKey = new IDKey();
                iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.map.g.CTRL_INDEX);
                iDKey.SetValue(1);
                iDKey.SetKey(1);
                arrayList3.add(iDKey);
            }
            g gVar3 = g.iuh;
            g.d(arrayList3, true);
        }
    }

    private static boolean dC(int i, int i2) {
        return i == 385 && i2 == 112;
    }

    private static boolean dD(int i, int i2) {
        return i == 385 && (i2 == 0 || i2 == 1 || i2 == 16);
    }

    private static boolean dE(int i, int i2) {
        return i == 398 || ((i == 385 && (i2 == 74 || i2 == 75)) || i == 1544 || i == 1582 || i == 498 || i == 397 || i == 1575 || i == 1639 || i == 556 || i == 422);
    }

    private static boolean yy(int i) {
        return i == 1581 || i == 1685;
    }

    private static boolean dF(int i, int i2) {
        return i == 1558 && (i2 == 0 || i2 == 1);
    }
}
