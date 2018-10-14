package app.comp.config;

import app.comp.util.Logging;
import javafx.util.Pair;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerAnotationBeanPostProcessor implements BeanPostProcessor {


    private static final String INFO = "Run method : %s";

    private Map<String, Pair<Class, List<Method>>> savedClasses = new HashMap<>();


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class<?> currentClass = bean.getClass();
        List<Method> methods = null;
        for (Method currentMethod : currentClass.getMethods()) {
            if (currentMethod.getAnnotation(Logging.class) != null) {
                if (methods == null) {
                    methods = new ArrayList<>();
                }
                methods.add(currentMethod);
                savedClasses.put(beanName, new Pair<>(currentClass, methods));
            }
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Pair<Class, List<Method>> currentPair = savedClasses.get(beanName);
        Class clazz = currentPair.getKey();
        if (currentPair != null) {
            Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    if (currentPair.getValue().stream().anyMatch(m -> m.getName().equals(method.getName()))) {
                        LoggerFactory.getLogger(clazz.getName()).info(String.format(INFO, method.getName()));
                        return method.invoke(bean, objects);
                    }
                    return method.invoke(bean, objects);
                }
            });
        }
        return bean;
    }
}
