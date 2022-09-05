package com.study.asm.transform;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * change all class version , via java agent
 * usage:
 * 1. package agent jar: mvn clean package
 * 2. java -javaagent:learn-asm-1.0.0.jar -jar  someTarget.jar
 */
public class TransformClassAgent {
    public static void premain(String agentArgs, Instrumentation instrumentation){
        System.out.println(" agent premain...agentArgs:"+agentArgs);
        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                ClassReader cr = new ClassReader(classfileBuffer);
                ClassWriter cw = new ClassWriter(cr, 0);
                ClassVisitor cv = new ChangeVersionAdapter(Opcodes.ASM4,cw);
                cr.accept(cv, 0);
                return cw.toByteArray();
            }
        });

    }
}
