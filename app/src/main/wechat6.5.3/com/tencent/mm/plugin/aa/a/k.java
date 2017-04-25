package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.aa.a.a.f;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.protocal.c.w;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import java.util.List;
import java.util.Map;

public final class k implements e {
    public static String dsA = "chatRoomName";
    public static String dsB = "launchScene";
    public static String dsC = "payerlist";
    private static int dsD = 131100026;
    public static String dsw = "title";
    public static String dsx = "totalPayAmount";
    public static String dsy = "totalUserNumber";
    public static String dsz = "perAmount";
    private b czg;
    private boolean dsE = false;
    private Map<String, Object> dsF;
    private int mode = 0;

    public final boolean c(int i, Map<String, Object> map) {
        int i2 = 13;
        this.czg = g.bKJ();
        if (this.dsE) {
            v.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.czg.bo(Boolean.valueOf(false));
            return false;
        } else if (map == null || map.size() == 0) {
            this.czg.bo(Boolean.valueOf(false));
            return false;
        } else {
            v.i("MicroMsg.LaunchAALogic", "launchAAByMoney, data.keySet: %s", new Object[]{map.keySet()});
            this.dsE = true;
            this.dsF = map;
            this.mode = i;
            String str;
            if (i != a.drC) {
                if (i == a.drD) {
                    if (this.dsF.containsKey(dsw) && this.dsF.containsKey(dsz) && this.dsF.containsKey(dsC) && this.dsF.containsKey(dsB) && this.dsF.containsKey(dsA)) {
                        try {
                            str = (String) this.dsF.get(dsw);
                            List list = (List) this.dsF.get(dsC);
                            ak.vy().a(new com.tencent.mm.plugin.aa.a.a.e(((Long) this.dsF.get(dsz)).longValue(), str, list, ((Integer) this.dsF.get(dsB)).intValue(), (String) this.dsF.get(dsA)), 0);
                            int size = list.size();
                            if (size > 0 && size <= 10) {
                                size = 13;
                            } else if (size > 10 && size <= 20) {
                                size = 14;
                            } else if (size <= 20 || size > 50) {
                                size = 16;
                            } else {
                                size = 15;
                            }
                            com.tencent.mm.plugin.report.service.g.iuh.a(407, (long) size, 1, false);
                            this.czg.bKI();
                            return true;
                        } catch (Exception e) {
                            v.e("MicroMsg.LaunchAALogic", "launchAAByMoney, specific user error: %", new Object[]{e.getMessage()});
                            this.czg.bo(Boolean.valueOf(false));
                            this.dsE = false;
                            return false;
                        }
                    }
                    this.czg.bo(Boolean.valueOf(false));
                    this.dsE = false;
                    return false;
                }
                return false;
            } else if (this.dsF.containsKey(dsw) && this.dsF.containsKey(dsz) && this.dsF.containsKey(dsy) && this.dsF.containsKey(dsB) && this.dsF.containsKey(dsA)) {
                try {
                    str = (String) this.dsF.get(dsw);
                    long longValue = ((Long) this.dsF.get(dsz)).longValue();
                    int intValue = ((Integer) this.dsF.get(dsy)).intValue();
                    int intValue2 = ((Integer) this.dsF.get(dsB)).intValue();
                    String str2 = (String) this.dsF.get(dsA);
                    v.i("MicroMsg.LaunchAALogic", "launchAAByMoney");
                    ak.vy().a(new com.tencent.mm.plugin.aa.a.a.e(longValue, str, intValue, intValue2, str2), 0);
                    if (intValue <= 0 || intValue > 10) {
                        if (intValue > 10 && intValue <= 20) {
                            i2 = 14;
                        } else if (intValue <= 20 || intValue > 50) {
                            i2 = 16;
                        } else {
                            i2 = 15;
                        }
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.a(407, (long) i2, 1, false);
                    this.czg.bKI();
                    return true;
                } catch (Exception e2) {
                    v.e("MicroMsg.LaunchAALogic", "launchAAByMoney, without specific user error: %s", new Object[]{e2.getMessage()});
                }
            } else {
                this.czg.bo(Boolean.valueOf(false));
                this.dsE = false;
                return false;
            }
        }
    }

    public final boolean m(Map<String, Object> map) {
        this.czg = g.bKJ();
        v.i("MicroMsg.LaunchAALogic", "launchAAByPerson");
        if (this.dsE) {
            v.e("MicroMsg.LaunchAALogic", "launchAA, isLaunching!!! ignore it");
            this.czg.bo(Boolean.valueOf(false));
            return false;
        } else if (map == null || map.size() == 0) {
            this.czg.bo(Boolean.valueOf(false));
            return false;
        } else {
            this.dsE = true;
            this.dsF = map;
            this.mode = a.drE;
            if (this.mode != a.drE) {
                this.czg.bo(Boolean.valueOf(false));
                return false;
            } else if (this.dsF.containsKey(dsw) && this.dsF.containsKey(dsx) && this.dsF.containsKey(dsC) && this.dsF.containsKey(dsB) && this.dsF.containsKey(dsA)) {
                try {
                    List list = (List) this.dsF.get(dsC);
                    ak.vy().a(new f((String) this.dsF.get(dsw), ((Long) this.dsF.get(dsx)).longValue(), list, ((Integer) this.dsF.get(dsB)).intValue(), (String) this.dsF.get(dsA)), 0);
                    int size = list.size();
                    size = (size <= 0 || size > 10) ? (size <= 10 || size > 20) ? (size <= 20 || size > 50) ? 20 : 19 : 18 : 17;
                    com.tencent.mm.plugin.report.service.g.iuh.a(407, (long) size, 1, false);
                    this.czg.bKI();
                    return true;
                } catch (Exception e) {
                    v.e("MicroMsg.LaunchAALogic", "launchAAByPerson error: %s", new Object[]{e.getMessage()});
                    this.czg.bo(Boolean.valueOf(false));
                    this.dsE = false;
                    this.dsE = false;
                    return false;
                }
            } else {
                this.czg.bo(Boolean.valueOf(false));
                return false;
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.LaunchAALogic", "onSceneEnd, errType: %s, errCode: %s, scene: %s, mode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), kVar, Integer.valueOf(this.mode)});
        String str2;
        String str3;
        Object[] objArr;
        w wVar;
        if (kVar.getType() == 1624) {
            this.dsE = false;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.aa.a.a.e eVar = (com.tencent.mm.plugin.aa.a.a.e) kVar;
                com.tencent.mm.protocal.c.g gVar = eVar.dsO;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByMoney, onSceneEnd, retCode: %s, retmsg: %s, msgXml==null: %s, billNo: %s";
                objArr = new Object[4];
                objArr[0] = Integer.valueOf(gVar.hKq);
                objArr[1] = gVar.hKr;
                objArr[2] = Boolean.valueOf(gVar.lYy == null);
                objArr[3] = gVar.lYw;
                v.i(str2, str3, objArr);
                if (gVar.hKq == 0) {
                    if (gVar.lYy != null) {
                        h.p(gVar.lYw, eVar.biB, gVar.lYy);
                        g.a(this.czg, new Object[]{Boolean.valueOf(true)});
                    } else {
                        h.a(gVar.lYw, false, 0);
                        g.a(this.czg, new Object[]{Boolean.valueOf(true)});
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.a(407, 0, 1, false);
                    return;
                }
                if (this.czg != null) {
                    if (gVar.hKq > 0) {
                        wVar = gVar.lYD;
                        if (wVar != null && wVar.lZi > 0) {
                            this.czg.bo(wVar);
                        } else if (be.kS(gVar.hKr)) {
                            this.czg.bo(Boolean.valueOf(false));
                        } else {
                            this.czg.bo(gVar.hKr);
                        }
                    } else {
                        this.czg.bo(Boolean.valueOf(false));
                    }
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(407, 2, 1, false);
                return;
            }
            if (this.czg != null) {
                this.czg.bo(Boolean.valueOf(false));
            }
            com.tencent.mm.plugin.report.service.g.iuh.a(407, 1, 1, false);
        } else if (kVar.getType() == 1655) {
            this.dsE = false;
            if (i == 0 && i2 == 0) {
                f fVar = (f) kVar;
                i iVar = fVar.dsQ;
                str2 = "MicroMsg.LaunchAALogic";
                str3 = "launchAAByPerson, onSceneEnd, retCode: %s, retmsg: %s, msgxml==null: %s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(iVar.hKq);
                objArr[1] = iVar.hKr;
                objArr[2] = Boolean.valueOf(iVar.lYy == null);
                v.i(str2, str3, objArr);
                v.d("MicroMsg.LaunchAALogic", "launchAAByPerson, onSceneEnd, retMsg: %s, billNo: %s", new Object[]{iVar.hKr, iVar.lYw});
                if (iVar.hKq == 0) {
                    if (iVar.lYy != null) {
                        h.p(iVar.lYw, fVar.biB, iVar.lYy);
                        g.a(this.czg, new Object[]{Boolean.valueOf(true), iVar.lYw});
                    } else {
                        h.a(iVar.lYw, false, 0);
                        g.a(this.czg, new Object[]{Boolean.valueOf(true), iVar.lYw});
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.a(407, 3, 1, false);
                    return;
                }
                if (iVar.hKq > 0) {
                    wVar = iVar.lYD;
                    if (wVar != null && wVar.lZi > 0) {
                        this.czg.bo(wVar);
                    } else if (be.kS(iVar.hKr)) {
                        this.czg.bo(Boolean.valueOf(false));
                    } else {
                        this.czg.bo(iVar.hKr);
                    }
                } else {
                    this.czg.bo(Boolean.valueOf(false));
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(407, 5, 1, false);
                return;
            }
            if (this.czg != null) {
                this.czg.bo(Boolean.valueOf(false));
            }
            com.tencent.mm.plugin.report.service.g.iuh.a(407, 4, 1, false);
        }
    }
}
