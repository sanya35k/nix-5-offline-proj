package ua.com.alevel.lib;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CrudFactory {

    private static CrudFactory instance;
    private static final String ROOT_PACKAGE = "ua.com.alevel.lib";

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

    public CrudService getCrudProcess() {

        for (Class<? extends CrudService> aClass : crudServiceList) {
            if (!aClass.isAnnotationPresent(Deprecated.class)) {
                try {
                    return aClass.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("something ");
    }
}
