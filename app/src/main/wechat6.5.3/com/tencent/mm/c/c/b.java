package com.tencent.mm.c.c;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b {
    public String aVL;
    DataOutputStream aVM;
    int aVN;

    public b(String str, int i, int i2) {
        this.aVL = str;
        File file = new File(str);
        try {
            file.createNewFile();
            this.aVM = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            ByteBuffer allocate = ByteBuffer.allocate(44);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(1179011410);
            allocate.putInt(0);
            allocate.putInt(1163280727);
            allocate.putInt(544501094);
            allocate.putInt(16);
            allocate.putShort((short) 1);
            allocate.putShort((short) i);
            allocate.putInt(i2);
            allocate.putInt((i2 * i) * 2);
            allocate.putShort((short) (i * 2));
            allocate.putShort((short) 16);
            allocate.putInt(1635017060);
            allocate.putInt(0);
            this.aVN = 44;
            this.aVM.write(allocate.array());
        } catch (IOException e) {
            v.e("MicroMsg.PcmWriter", "create file failed: " + e.getMessage());
        }
    }

    public final boolean h(byte[] bArr, int i) {
        if (this.aVM == null) {
            return false;
        }
        try {
            this.aVM.write(bArr, 0, i);
            this.aVN += i;
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.PcmWriter", "write to file failed: " + e.getMessage());
            return false;
        }
    }

    public final void pw() {
        RandomAccessFile randomAccessFile;
        Throwable e;
        try {
            this.aVM.close();
        } catch (IOException e2) {
            v.e("MicroMsg.PcmWriter", "close file failed: " + e2.getMessage());
        }
        try {
            randomAccessFile = new RandomAccessFile(this.aVL, "rw");
            try {
                randomAccessFile.seek(4);
                ByteBuffer allocate = ByteBuffer.allocate(4);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                allocate.putInt(this.aVN - 8);
                randomAccessFile.write(allocate.array());
                allocate.rewind();
                allocate.putInt(this.aVN - 42);
                randomAccessFile.seek(40);
                randomAccessFile.write(allocate.array());
                try {
                    randomAccessFile.close();
                } catch (Throwable e3) {
                    v.a("MicroMsg.PcmWriter", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            } catch (FileNotFoundException e4) {
                e3 = e4;
                try {
                    v.a("MicroMsg.PcmWriter", e3, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e32) {
                            v.a("MicroMsg.PcmWriter", e32, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                } catch (Throwable th) {
                    e32 = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e5) {
                            v.a("MicroMsg.PcmWriter", e5, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    throw e32;
                }
            } catch (IOException e6) {
                e32 = e6;
                v.a("MicroMsg.PcmWriter", e32, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e322) {
                        v.a("MicroMsg.PcmWriter", e322, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
        } catch (FileNotFoundException e7) {
            e322 = e7;
            randomAccessFile = null;
            v.a("MicroMsg.PcmWriter", e322, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (IOException e8) {
            e322 = e8;
            randomAccessFile = null;
            v.a("MicroMsg.PcmWriter", e322, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Throwable th2) {
            e322 = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e322;
        }
    }
}
