package com.study.basic;

/**
 *
 * 将hsdis-amd64.dll，hsdis-amd64.lib 拷贝到 {JDK_HOME}\bin\server目录下；
 * 运行命令：
 * java -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp -XX:CompileCommand=compileonly,com/study/basic/SynchronizedExample.decrease > run.log
 */
public class SynchronizedExample {
    static volatile int count = 1;
    public synchronized static void increment(){
        count++;
    }

    public static void decrease(){
        synchronized (SynchronizedExample.class){
            count--;
        }
    }

    public static void main(String[] args) {
        decrease();
    }
}
