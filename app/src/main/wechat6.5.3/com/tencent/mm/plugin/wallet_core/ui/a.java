package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class a {
    public c kRH = null;
    private Map<String, l> kRI = null;
    Map<String, e> kRJ = null;

    public static final class a {
        public String hNe;
        public e kRK;
        public double kRL;
        public String kRM;
    }

    public a(c cVar) {
        Assert.assertNotNull(cVar);
        this.kRH = cVar;
        NH();
    }

    private void NH() {
        int i = 0;
        this.kRI = new HashMap();
        List list = this.kRH.kHC;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                l lVar = (l) list.get(i2);
                this.kRI.put(lVar.kHv, lVar);
            }
        } else {
            v.w("MicroMsg.FavorLogicHelper", "func[initData] favorList null");
        }
        this.kRJ = new HashMap();
        if (this.kRH.kHD == null || this.kRH.kHD.kHM == null) {
            v.w("MicroMsg.FavorLogicHelper", "func[initData] favorComposeList null");
            return;
        }
        List list2 = this.kRH.kHD.kHM;
        while (i < list2.size()) {
            e eVar = (e) list2.get(i);
            this.kRJ.put(eVar.kHO, eVar);
            i++;
        }
    }

    public final Map<String, a> Dl(String str) {
        return at(str, false);
    }

    public final Map<String, a> at(String str, boolean z) {
        Map<String, a> hashMap = new HashMap();
        if (this.kRH.kHD == null || this.kRH.kHD.kHM == null) {
            v.w("MicroMsg.FavorLogicHelper", "favorComposeList null or favorComposeList.favorComposeInfo null");
        } else {
            double d;
            List list = this.kRH.kHD.kHM;
            if (this.kRJ.containsKey(str)) {
                d = ((e) this.kRJ.get(str)).kHP;
            } else {
                d = 0.0d;
            }
            for (int i = 0; i < list.size(); i++) {
                e eVar = (e) list.get(i);
                String str2 = null;
                if (str.equals("0") && !eVar.equals("0")) {
                    str2 = eVar.kHO;
                } else if (eVar.kHO.startsWith(str) && !str.equals(eVar.kHO)) {
                    str2 = eVar.kHO.replace(str + "-", "");
                }
                String[] Do = Do(str2);
                if (Do != null && Do.length > 0) {
                    l lVar = (l) this.kRI.get(Do[0]);
                    if (lVar != null) {
                        if (!((lVar.kIk != 0 ? 1 : null) == null || be.kS(lVar.kIl) || (!z && lVar.kIl.equalsIgnoreCase("CFT")))) {
                            a aVar = (a) hashMap.get(lVar.kIl);
                            if (aVar == null || eVar.kHP > aVar.kRK.kHP) {
                                aVar = new a();
                                aVar.kRK = eVar;
                                aVar.hNe = lVar.hNe;
                                aVar.kRL = eVar.kHP - d;
                                aVar.kRM = lVar.kIl;
                                hashMap.put(lVar.kIl, aVar);
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public final List<l> Dm(String str) {
        List<l> linkedList = new LinkedList();
        if (this.kRH.kHC != null) {
            Map Dl = Dl(str);
            for (int i = 0; i < this.kRH.kHC.size(); i++) {
                l lVar = (l) this.kRH.kHC.get(i);
                if (lVar != null) {
                    Object obj;
                    if (lVar.kIk != 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && Dl.containsKey(lVar.kIl)) {
                        linkedList.add(lVar);
                    }
                }
            }
        } else {
            v.w("MicroMsg.FavorLogicHelper", "fucn[getBankFavorListWithSelectedCompId] mFavorInfo.tradeFavList null");
        }
        return linkedList;
    }

    public final e Dn(String str) {
        return (e) this.kRJ.get(str);
    }

    public static String[] Do(String str) {
        if (be.kS(str)) {
            return null;
        }
        return str.split("-");
    }

    public final String Dp(String str) {
        return au(str, false);
    }

    public final String au(String str, boolean z) {
        String[] Do = Do(str);
        if (Do == null) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < Do.length; i++) {
            l lVar = (l) this.kRI.get(Do[i]);
            if (lVar != null) {
                Object obj;
                if (lVar.kIk != 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null || (be.kS(lVar.kIl) && !z)) {
                    stringBuilder.append(Do[i]);
                    stringBuilder.append("-");
                }
            }
        }
        if (stringBuilder.length() == 0) {
            return "0";
        }
        return stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()).toString();
    }

    public final FavorPayInfo Dq(String str) {
        FavorPayInfo favorPayInfo = new FavorPayInfo();
        if (this.kRJ.get(str) == null) {
            favorPayInfo.kOv = "0";
            if (this.kRH != null) {
                favorPayInfo.kOy = this.kRH.kHB;
            }
            favorPayInfo.kOw = 0;
            return favorPayInfo;
        }
        favorPayInfo.kOv = str;
        if (this.kRH != null) {
            favorPayInfo.kOy = this.kRH.kHB;
        }
        favorPayInfo.kOw = 0;
        String[] Do = Do(str);
        if (Do == null) {
            return favorPayInfo;
        }
        for (int length = Do.length - 1; length >= 0; length--) {
            l lVar = (l) this.kRI.get(Do[length]);
            if (lVar != null) {
                if ((lVar.kIk != 0 ? 1 : 0) == 0) {
                    break;
                }
                favorPayInfo.kOw = 1;
                if (!be.kS(lVar.kIl)) {
                    favorPayInfo.kOx = lVar.kIl;
                    break;
                }
            }
        }
        return favorPayInfo;
    }

    public static boolean a(FavorPayInfo favorPayInfo, Bankcard bankcard) {
        if (bankcard == null) {
            v.w("MicroMsg.FavorLogicHelper", "curBankcard null");
            return true;
        }
        if (!(favorPayInfo == null || be.kS(favorPayInfo.kOv))) {
            if (favorPayInfo.kOw != 0) {
                if (!be.kS(favorPayInfo.kOx) && !bankcard.field_bankcardType.equals(favorPayInfo.kOx)) {
                    return true;
                }
                if (be.kS(favorPayInfo.kOx) && bankcard.field_bankcardType.equals("CFT")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String bD(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(((String) list.get(i)));
            if (i < list.size() - 1) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

    public final String Dr(String str) {
        ArrayList hk = k.bga().hk(true);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (int i = 0; i < hk.size(); i++) {
            hashMap.put(((Bankcard) hk.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        String[] Do = Do(str);
        if (Do != null) {
            for (Object obj : Do) {
                l lVar = (l) this.kRI.get(obj);
                if (lVar != null) {
                    boolean z;
                    if (lVar.kIk != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(lVar.kIl) || be.kS(lVar.kIl)) {
                            arrayList.add(obj);
                        } else {
                        }
                    }
                }
                arrayList.add(obj);
            }
        }
        if (arrayList.size() == 0) {
            return "0";
        }
        return bD(arrayList);
    }

    public final List<l> bgU() {
        int i;
        ArrayList hk = k.bga().hk(true);
        Map hashMap = new HashMap();
        for (i = 0; i < hk.size(); i++) {
            hashMap.put(((Bankcard) hk.get(i)).field_bankcardType, Integer.valueOf(0));
        }
        List<l> linkedList = new LinkedList();
        List list = this.kRH.kHC;
        if (list != null) {
            for (i = 0; i < list.size(); i++) {
                l lVar = (l) list.get(i);
                if (lVar != null) {
                    boolean z;
                    if (lVar.kIk != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (hashMap.containsKey(lVar.kIl) || be.kS(lVar.kIl)) {
                            linkedList.add(lVar);
                        } else {
                        }
                    }
                }
                linkedList.add(lVar);
            }
        }
        return linkedList;
    }
}
