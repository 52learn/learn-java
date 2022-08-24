package com.study.asm.transform;

import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;

public class TransformClass {

    public static void changeClassVersion(){
        try {
            ClassReader cr = new ClassReader("java.lang.Runnable");
            ClassWriter cw = new ClassWriter(0);
            ClassVisitor cv = new ChangeVersionAdapter(Opcodes.ASM4,cw);
            cr.accept(cv,0);
            byte[] b2 = cw.toByteArray();
            FileUtils.writeByteArrayToFile(new File("/learn/learn-java/learn-asm/target/classes/com/study/asm/transform/Runnable.class"), b2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        changeClassVersion();
    }
}
