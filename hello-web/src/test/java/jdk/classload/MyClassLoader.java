package jdk.classload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyClassLoader extends ClassLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyClassLoader.class);

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        LOGGER.info("this is myClassLoader");
        return super.findClass(name);
    }

    public MyClassLoader() {
    }

    protected MyClassLoader(ClassLoader parent) {
        super(parent);
    }
}
