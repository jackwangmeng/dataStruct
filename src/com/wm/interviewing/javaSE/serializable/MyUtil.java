package com.wm.interviewing.javaSE.serializable;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import com.wm.thread.MyCall;

import java.io.*;

/**
 * @author wm
 * @Package com.wm.interviewing.javaSE
 * @date 2021/1/14 17:21
 */
public class MyUtil {
    public MyUtil(){
        throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
    }
}
