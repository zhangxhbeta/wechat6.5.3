package com.tencent.mm.plugin.game.c;

import com.tencent.mm.plugin.game.d.bm;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public final class aa {
    public String dzg = "";
    public List<a> gju = new LinkedList();

    public static class a implements Serializable {
        public String ble;
        public long cWZ;
        public int gjv;
        public int gjw;
        public boolean gjx;
        public String gjy;
        public String tag;
    }

    public aa(String str) {
        if (!be.kS(str)) {
            this.dzg = str;
            this.gju.addAll(arJ());
        }
    }

    public aa(String str, List<bm> list) {
        if (!be.kS(str) && list != null && !list.isEmpty()) {
            this.dzg = str;
            this.gju.clear();
            for (bm bmVar : list) {
                a aVar = new a();
                aVar.gjv = bmVar.gnx;
                aVar.ble = bmVar.gln;
                aVar.tag = bmVar.gnz;
                aVar.cWZ = bmVar.gny;
                aVar.gjx = bmVar.gnA;
                aVar.gjw = bmVar.gnB;
                aVar.gjy = bmVar.gnC;
                this.gju.add(aVar);
            }
            arK();
        }
    }

    private List<a> arJ() {
        ObjectInput objectInputStream;
        Throwable e;
        String str = this.dzg + "_ranks";
        List<a> linkedList = new LinkedList();
        byte[] uf = au.asg().uf(str);
        if (uf == null) {
            return linkedList;
        }
        InputStream byteArrayInputStream = new ByteArrayInputStream(uf);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                linkedList.addAll((List) objectInputStream.readObject());
                try {
                    byteArrayInputStream.close();
                } catch (IOException e2) {
                }
                try {
                    objectInputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    v.a("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e5) {
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    return linkedList;
                } catch (Throwable th) {
                    e = th;
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e7) {
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e9) {
            e = e9;
            objectInputStream = null;
            v.a("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            return linkedList;
        } catch (Throwable th2) {
            e = th2;
            objectInputStream = null;
            byteArrayInputStream.close();
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw e;
        }
        return linkedList;
    }

    public final void arK() {
        ObjectOutput objectOutputStream;
        Throwable e;
        String str = this.dzg + "_ranks";
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(this.gju);
                au.asg().n(str, byteArrayOutputStream.toByteArray());
                try {
                    objectOutputStream.close();
                } catch (IOException e2) {
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    v.a("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                    }
                } catch (Throwable th) {
                    e = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e7) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                    }
                    throw e;
                }
            }
        } catch (Exception e9) {
            e = e9;
            objectOutputStream = null;
            v.a("MicroMsg.GamePBDataDetailRank", e, "", new Object[0]);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            e = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw e;
        }
    }
}
