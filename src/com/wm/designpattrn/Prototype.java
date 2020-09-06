package com.wm.designpattrn;

public class Prototype {
    public class PrototypeClass implements Cloneable{

        @Override
        public PrototypeClass clone(){
            PrototypeClass prototypeClass = null;
            try {
                prototypeClass = (PrototypeClass) super.clone();
            }catch (CloneNotSupportedException e){
                e.printStackTrace();
            }
            return prototypeClass;
        }
    }
}
