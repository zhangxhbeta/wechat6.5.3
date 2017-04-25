package com.tencent.mm.plugin.qqmail.b;

import a.a.a.b;
import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends com.tencent.mm.ba.a {
    String iaj;
    private boolean iak;
    LinkedList<i> ial = new LinkedList();
    private boolean iam;

    protected final /* synthetic */ com.tencent.mm.ba.a aHs() {
        return aHq();
    }

    public final /* synthetic */ com.tencent.mm.ba.a az(byte[] bArr) {
        return ay(bArr);
    }

    public final a xV(String str) {
        this.iaj = str;
        this.iak = true;
        return this;
    }

    public final a ov(int i) {
        boolean z = false;
        if (i >= 0 && i < this.ial.size()) {
            if (i >= 10) {
                this.ial.remove(i);
            } else {
                this.ial.remove(i);
                Iterator it = this.ial.iterator();
                int i2 = -1;
                int i3 = Integer.MIN_VALUE;
                int i4 = 0;
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    int i5 = i4 + 1;
                    if (i4 >= 10) {
                        int i6;
                        if (i3 < iVar.iaN) {
                            i2 = iVar.iaN;
                            i6 = i5;
                        } else {
                            i6 = i2;
                            i2 = i3;
                        }
                        i3 = i2;
                        i4 = i5;
                        i2 = i6;
                    } else {
                        i4 = i5;
                    }
                }
                if (i2 != -1 && i2 < this.ial.size()) {
                    try {
                        a((i) this.ial.remove(i2));
                    } catch (Throwable e) {
                        v.a("MicroMsg.AddrBook", e, "size:%d, idx:%d", new Object[]{Integer.valueOf(this.ial.size()), Integer.valueOf(i2)});
                    }
                }
            }
            if (this.ial.size() > 0) {
                z = true;
            }
            this.iam = z;
        }
        return this;
    }

    public final a a(i iVar) {
        int i = 0;
        if (!this.iam) {
            this.iam = true;
        }
        Iterator it = this.ial.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i iVar2 = (i) it.next();
            if (i2 >= 10) {
                if (a(iVar, iVar2)) {
                    break;
                }
            } else if (iVar.iaN > iVar2.iaN) {
                break;
            }
            i2++;
        }
        if (i2 >= this.ial.size()) {
            this.ial.add(iVar);
        } else {
            this.ial.add(i2, iVar);
            if (i2 < 10 && this.ial.size() > 10) {
                iVar2 = (i) this.ial.remove(10);
                it = this.ial.iterator();
                while (it.hasNext()) {
                    i iVar3 = (i) it.next();
                    if (i >= 10 && a(iVar2, iVar3)) {
                        break;
                    }
                    i++;
                }
                if (i >= this.ial.size()) {
                    this.ial.add(iVar2);
                } else {
                    this.ial.add(i, iVar2);
                }
            }
        }
        return this;
    }

    private static boolean a(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return false;
        }
        int compareTo = b(iVar).compareTo(b(iVar2));
        if (compareTo == 0) {
            if (iVar.gRG.compareTo(iVar2.gRG) > 0) {
                return false;
            }
            return true;
        } else if (compareTo >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String b(i iVar) {
        String str = iVar.iaO;
        if (str == null || "".equals(str)) {
            str = xW(c.lT(iVar.name.trim()).toLowerCase());
        } else {
            str = xW(str);
        }
        iVar.iaO = str;
        return str;
    }

    public static String xW(String str) {
        if (str == null || str.length() <= 0) {
            v.d("MicroMsg.getAdjustFullSpell", "%s", new Object[]{"srcName is null or empty, adjust full spell = ~"});
            return "~";
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            char c = toCharArray[i];
            if (c >= '0' && c <= '9') {
                return String.format("{%c%s", new Object[]{Character.valueOf(c), str});
            } else if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                if (c == '{' && i == 0 && toCharArray.length > 1 && toCharArray[i + 1] >= '0' && toCharArray[i + 1] <= '9') {
                    return str;
                }
                i++;
            } else if (i == 0) {
                return str;
            } else {
                return String.format("%c%s", new Object[]{Character.valueOf(c), str});
            }
        }
        v.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", new Object[]{str});
        return "~";
    }

    public final String toString() {
        return ((("" + getClass().getName() + "(") + "syncInfo = " + this.iaj + "   ") + "addrs = " + this.ial + "   ") + ")";
    }

    private a aHq() {
        if (this.iak) {
            return this;
        }
        throw new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.iak);
    }

    public final int aHr() {
        return (a.a.a.b.b.a.f(1, this.iaj) + 0) + (a.a.a.a.c(2, 8, this.ial) + 0);
    }

    public final byte[] toByteArray() {
        aHq();
        return super.toByteArray();
    }

    public final void a(a.a.a.c.a aVar) {
        aVar.e(1, this.iaj);
        aVar.d(2, 8, this.ial);
    }

    public final a ay(byte[] bArr) {
        a.a.a.a.a aVar = new a.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a(aVar); a > 0; a = a(aVar)) {
            boolean z;
            switch (a) {
                case 1:
                    xV(aVar.pMj.readString());
                    z = true;
                    break;
                case 2:
                    int i;
                    LinkedList zQ = aVar.zQ(2);
                    for (i = 0; i < zQ.size(); i++) {
                        byte[] bArr2 = (byte[]) zQ.get(i);
                        i iVar = new i();
                        a.a.a.a.a aVar2 = new a.a.a.a.a(bArr2, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar2, iVar, a(aVar2))) {
                        }
                        if (!this.iam) {
                            this.iam = true;
                        }
                        this.ial.add(iVar);
                    }
                    i[] iVarArr = (i[]) this.ial.toArray(new i[1]);
                    Arrays.sort(iVarArr, new Comparator<i>(this) {
                        final /* synthetic */ a ian;

                        {
                            this.ian = r1;
                        }

                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            return ((i) obj2).iaN - ((i) obj).iaN;
                        }
                    });
                    if (10 <= iVarArr.length) {
                        Arrays.sort(iVarArr, 10, iVarArr.length, new Comparator<i>(this) {
                            final /* synthetic */ a ian;

                            {
                                this.ian = r1;
                            }

                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                i iVar = (i) obj;
                                i iVar2 = (i) obj2;
                                int compareTo = a.b(iVar).compareTo(a.b(iVar2));
                                return compareTo == 0 ? iVar.gRG.compareTo(iVar2.gRG) : compareTo;
                            }
                        });
                    }
                    this.ial.clear();
                    for (Object add : iVarArr) {
                        this.ial.add(add);
                    }
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                aVar.bQL();
            }
        }
        return aHq();
    }
}
