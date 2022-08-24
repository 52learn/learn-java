package com.study.asm.generate;

import org.apache.commons.io.FileUtils;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.File;

public class ClassGenerate {

    static class MyClassLoader extends ClassLoader{
        public Class defineClass(String name,byte[] bytes){
            return defineClass(name,bytes,0, bytes.length);
        }
    }
    public static void generate() throws Exception {
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V11,Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT+Opcodes.ACC_INTERFACE,
            "com/study/asm/generate/Comparable",
            null,
            "java/lang/Object",
            new String[]{"com/study/asm/generate/Mesurable"});
        cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,
            "LESS","I",null,Integer.valueOf(-1))
            .visitEnd();
        cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,
            "EQUAL","I",null,Integer.valueOf(0))
            .visitEnd();
        cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,
            "GREATER","I",null,Integer.valueOf(1))
            .visitEnd();
        cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT,
            "compareTo","(Ljava/lang/Object;)I",null,null)
        .visitEnd();
        byte[] bytes = cw.toByteArray();

        MyClassLoader classLoader = new MyClassLoader();
        Class comparableClass = classLoader.defineClass("com.study.asm.generate.Comparable",bytes);

        FileUtils.writeByteArrayToFile(new File("/learn/learn-java/learn-asm/target/classes/com/study/asm/generate/Comparable.class"), bytes);

    }

    public static void main(String[] args)  throws Exception{
        generate();
    }
}
