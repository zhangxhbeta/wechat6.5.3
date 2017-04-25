package com.tencent.mm.q;

import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.pb.common.c.c;

public final class e {

    public static class a {
        public int cqN = 3;
        public int cqO;
        public int cqP = -1;
        public int cqQ = -1;
        public long cqR = -1;

        public a(int i, int i2, int i3) {
            this.cqO = i;
            this.cqP = i2;
            this.cqQ = i3;
        }

        public a(int i, long j) {
            this.cqO = i;
            this.cqR = j;
        }
    }

    public static a c(com.tencent.mm.q.a.a aVar) {
        String xF = k.xF();
        if (aVar.cpT == 2 || aVar.cpT == 3) {
            String[] split;
            if (!be.bP(aVar.cpX)) {
                for (String split2 : aVar.cpX) {
                    split = split2.split(",");
                    if (split.length == 4 && split[0].equals(xF)) {
                        return new a(be.getInt(split[1], -1), be.getInt(split[2], -1), be.getInt(split[3], -1));
                    }
                }
            }
            if (!be.bP(aVar.cpZ)) {
                for (String split22 : aVar.cpZ) {
                    split = split22.split(",");
                    if (split.length == 3 && split[0].equals(xF)) {
                        return new a(be.getInt(split[2], -1), be.getLong(split[1], -1));
                    }
                }
            }
        }
        return new a();
    }

    public static int a(com.tencent.mm.q.a.a aVar, boolean z) {
        a c = c(aVar);
        switch (aVar.cpT) {
            case 2:
            case 3:
                if (z || c.cqN == 1) {
                    if (c.cqO > 0 && c.cqP >= 0 && c.cqQ >= 0) {
                        switch (c.cqO) {
                            case 1:
                            case 2:
                                return 2131165355;
                            case 3:
                                return 2131165353;
                            case 4:
                                return 2131165354;
                            default:
                                break;
                        }
                    }
                } else if (c.cqN == 2) {
                    if (c.cqO > 0 && c.cqR >= 0) {
                        switch (c.cqO) {
                            case 1:
                                return 2131165355;
                            case 2:
                            case 3:
                                return 2131165353;
                            case 4:
                                return 2131165354;
                            default:
                                break;
                        }
                    }
                } else {
                    return 2131165353;
                }
                break;
        }
        return 2131165353;
    }

    public static String b(com.tencent.mm.q.a.a aVar, boolean z) {
        try {
            int i;
            Object obj;
            int i2;
            Object obj2;
            String xF = k.xF();
            Object obj3 = null;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            long j = -1;
            if (aVar.cpT == 2 || aVar.cpT == 3) {
                String[] split;
                if (!be.bP(aVar.cpX)) {
                    for (String split2 : aVar.cpX) {
                        split = split2.split(",");
                        if (split.length == 4 && split[0].equals(xF)) {
                            i3 = be.getInt(split[1], -1);
                            i4 = be.getInt(split[2], -1);
                            i5 = be.getInt(split[3], -1);
                            obj3 = 1;
                            break;
                        }
                    }
                }
                if (!be.bP(aVar.cpZ)) {
                    for (String split22 : aVar.cpZ) {
                        split = split22.split(",");
                        if (split.length == 3 && split[0].equals(xF)) {
                            j = be.getLong(split[1], -1);
                            i = be.getInt(split[2], -1);
                            obj = 1;
                            i2 = i5;
                            i5 = i4;
                            i4 = i3;
                            obj2 = obj3;
                            break;
                        }
                    }
                }
            }
            i = -1;
            obj = null;
            i2 = i5;
            i5 = i4;
            i4 = i3;
            obj2 = obj3;
            switch (aVar.cpT) {
                case 1:
                    return z ? aVar.cpF : aVar.cpG;
                case 2:
                case 3:
                    if (xF.equals(aVar.cqc) || z || r7 != null) {
                        if (i4 > 0 && i5 >= 0 && i2 >= 0) {
                            switch (i4) {
                                case 1:
                                    return aa.getContext().getString(2131230775);
                                case 2:
                                    return aa.getContext().getString(2131230773, new Object[]{Integer.valueOf(i5 - i2)});
                                case 3:
                                    return aa.getContext().getString(2131230772);
                                case 4:
                                    return aa.getContext().getString(2131230774);
                                default:
                                    break;
                            }
                        }
                    } else if (obj != null) {
                        if (i > 0 && j >= 0) {
                            switch (i) {
                                case 1:
                                    return aa.getContext().getString(2131230769, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                case 2:
                                    return aa.getContext().getString(2131230768, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                case 3:
                                    return aa.getContext().getString(2131230771, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                case 4:
                                    return aa.getContext().getString(2131230770);
                                default:
                                    break;
                            }
                        }
                    } else {
                        return aa.getContext().getString(2131230770);
                    }
                    break;
            }
        } catch (Exception e) {
            c.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", e.getMessage());
        }
        if (z) {
            return aVar.cpF;
        }
        return aVar.cpG;
    }
}
