package br.com.diegocordeiro.studies.mapper;

import br.com.diegocordeiro.studies.exceptions.MapperException;
import br.com.diegocordeiro.studies.models.Role;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModelMapper {

    public static <T, R> R fromTo(T source, Class<R> target) {

        Class<?> classSource =  source.getClass();

        Map<String, Object> methods = Arrays.stream(classSource.getMethods())
                .filter(method -> method.getName().contains("get"))
                .filter(method -> !method.getName().contains("Class"))
                .collect(Collectors.toMap(Method::getName, method -> {
                    try {
                        Object value = method.invoke(source);
                        return Objects.requireNonNullElseGet(value, dictionaryNonNull(method.getReturnType()));
                    } catch (Exception exception) {
                            throw new MapperException(exception.getMessage());
                    }
                }));

        R classTarget = constructInstance(target);

        return map(methods, classTarget);
    }

    private static <R> R map(Map<String, Object> parametersSource, R target){

        Class<?> classTarget =  target.getClass();

        List<Method> targetMethods = Arrays.stream(classTarget.getMethods())
                .filter(method -> method.getName().contains("set"))
                .filter(method -> !method.getName().contains("Class"))
                .collect(Collectors.toList());


        for(String key: parametersSource.keySet()) {

            String keyReplaced = key.replace("get", "");

            targetMethods.forEach(targetMethod -> {
                try {
                    if(targetMethod.getName().contains(keyReplaced)) {
                        targetMethod.invoke(target, parametersSource.get(key));
                    }
                } catch (Exception exception) {
                    throw new MapperException(exception.getMessage());
                }
            });
        }

        return target;
    }

    private static Supplier<Object> dictionaryNonNull(Class<?> typeParameter) {

        return () -> {
            if(typeParameter.equals(Character.class)){
                return Character.MIN_VALUE;
            } else if(typeParameter.equals(Integer.class)){
                return 0;
            } else if(typeParameter.equals(String.class)){
                return "*";
            } else if(typeParameter.equals(Double.class)){
                return 0.0;
            } else if(typeParameter.equals(Float.class)){
                return 0.0f;
            } else if (typeParameter.equals(Role.class)) {
                return Role.DEFAULT;
            }

            return new Object();
        };
    }

    private static <R> R constructInstance(Class<R> target) {

        try {
            return target.getConstructor().newInstance();
        } catch (Exception ex) {
            throw new MapperException("{ 'error': 'Erro ao criar instacia da classe.', 'originally': "
                    +  ex.getMessage() + "}");
        }
    }
}
