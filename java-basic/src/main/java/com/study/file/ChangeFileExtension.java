package com.study.file;

import java.io.File;

public class ChangeFileExtension {
    public static void main(String[] args) {
        File dir = new File("D:\\work\\huayun\\sourcecode\\caiwu\\fmp-base-core"); // 替换为你的目录路径
        renameFiles(dir, ".txt", ".java");
    }

    private static void renameFiles(File dir, String oldExtension, String newExtension) {
        if (!dir.exists()) {
            System.out.println("目录不存在: " + dir.getName());
            return;
        }

        if (!dir.isDirectory()) {
            System.out.println("不是一个目录: " + dir.getName());
            return;
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    renameFiles(file, oldExtension, newExtension); // 递归调用
                } else if (file.getName().endsWith(oldExtension)) {
                    String newName = file.getName().replace(oldExtension, newExtension);
                    File newFile = new File(dir, newName);
                    try {
                        if (!newFile.exists() || !newFile.isFile()) {
                            if(dir.getAbsolutePath().contains("\\src\\")){
                                file.renameTo(newFile);
                                System.out.println("文件已重命名: " + file.getName() + " -> " + newName);
                            }
                        } else {
                            System.out.println("无法重命名文件，因为目标文件已存在: " + newName);
                        }
                    } catch (Exception e) {
                        System.out.println("无法重命名文件: " + file.getName() + " -> " + newName);
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("目录为空: " + dir.getName());
        }
    }
}