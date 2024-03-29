package com.study.annotation.process;

import com.google.auto.service.AutoService;
import com.google.common.base.Strings;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static javax.lang.model.element.ElementKind.FIELD;
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_11)
@SupportedAnnotationTypes("com.study.annotation.process.Builder")
public class BuilderProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        annotations.forEach(annotation->{
            roundEnv.getElementsAnnotatedWith(annotation).forEach(this::generateBuilderFile);
        });
        return true;
    }

    private void generateBuilderFile(Element element){
        String className = element.getSimpleName().toString();
        String packageName = element.getEnclosingElement().toString();
        String builderName = className + "com.study.annotation.process.Buidler";
        String builderFullName = packageName + "." + builderName;
        List<? extends Element> fields = element.getEnclosedElements()
            .stream().filter(e -> FIELD.equals(e.getKind())).collect(Collectors.toList());
        try (PrintWriter writer = new PrintWriter(
            processingEnv.getFiler().createSourceFile(builderFullName).openWriter())) {
            writer.println(Strings.lenientFormat(
                "package %s;"
                + "public class %s{"
                + "",packageName,builderName));
            fields.forEach(field->{
                writer.print(Strings.lenientFormat("private %s %s;",
                    field.asType().toString(),
                    field.getSimpleName()));
            });
            writer.println();
            fields.forEach(field -> {
                writer.println(Strings.lenientFormat("public %s %s(%s value) { %s = value; return this;}",
                    builderName, field.getSimpleName(),
                    field.asType().toString(),
                    field.getSimpleName()));
            });
            writer.println( Strings.lenientFormat("public %s build() {return new %s(%s);}",
                className,
                className,
                fields.stream().map(Element::getSimpleName).collect(joining(", "))));
            writer.println("}");

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
