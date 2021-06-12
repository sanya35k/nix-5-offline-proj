package ua.practice.unit4.lib;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CrudFactory {

    private static CrudFactory instance;
    private static final String ROOT_PACKAGE = "ua.practice.unit4.lib";
    private final Set<Class<? extends CrudService>> crudServiceList;

    private CrudFactory() {
        Reflections reflections = new Reflections(ROOT_PACKAGE);
        crudServiceList = reflections.getSubTypesOf(CrudService.class);
    }

    public static CrudFactory getInstance() {
        if (instance == null) {
            instance = new CrudFactory();
        }
        return instance;
    }

    public CrudService getCurrent(String implementationName) {
        for (Class<? extends CrudService> aClass : crudServiceList) {
            if (!aClass.isAnnotationPresent(Deprecated.class) && aClass.getSimpleName().equalsIgnoreCase(implementationName)) {
                try {
                    System.out.println(aClass.getSimpleName());
                    return aClass.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("something ");
    }
}
