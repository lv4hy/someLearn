package com.szx.netty.copy;

public class DeepCopy {

    public Grade deepCopyGrade(Grade orignal) throws CloneNotSupportedException {
        if(orignal == null){
            return null;
        }
        Grade grade = orignal.deepCopy(orignal);
        return grade;
    }

    public Grade shadowCopy(Grade orignal) throws CloneNotSupportedException {
        return orignal.shadowCopy();
    }
}
