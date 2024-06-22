package org.choongang.global.config.containers;

import org.choongang.global.config.annotations.Component;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RestController;
import org.choongang.global.config.annotations.Service;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanContainer {
    public static BeanContainer instance;

    private Map<String, Object> beans;

    public BeanContainer() {
        beans = new HashMap<>();
    }

    public void loadBeans() {

        try{
            String rootPath = new File(getClass().getResource("../../../").getPath()).getCanonicalPath();
            String packageName = getClass().getPackageName().replace(".global.config.containers", "");

            List<Class> classNames = getClassNames(rootPath, packageName);

            for(Class clazz : classNames){
                if(clazz.isInterface()) {
                    continue;
                }
                String key = clazz.getName();
                if(beans.containsKey(key)) continue;

                Annotation[] annotations = clazz.getDeclaredAnnotations();
                boolean isBean = false;
                for (Annotation anno : annotations) {
                    if(anno instanceof Controller || anno instanceof RestController || anno instanceof Service
                    || anno instanceof Component){
                        isBean = true;
                        break;
                    }
                }
                if(isBean) {
                    Constructor con = clazz.getDeclaredConstructors()[0];
                    List<Object> objs = resolveDependencies(key, con);
                    if(!beans.containsKey(key)) {
                        Object obj = con.getParameterTypes().length == 0 ?
                                con.newInstance() : con.newInstance(objs.toArray());
                        beans.put(key,obj);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static BeanContainer getInstance() {
        if (instance == null) {
            instance = new BeanContainer();
        }
        return instance;
    }

    public <T> T getBean(Class clazz) {
        return (T)beans.get(clazz.getName());
    }

    public void addBean(String key, Object obj) {
        beans.put(key, obj);
    }

    public Map<String, Object> getBeans() {
        return beans;
    }

    private List<Object> resolveDependencies(String key, Constructor con) throws Exception {
        List<Object>  dependencies = new ArrayList<>();
        if(beans.containsKey(key)) {
            dependencies.add(beans.get(key));
            return dependencies;
        }
        Class[] parameters = con.getParameterTypes();
        if(parameters.length == 0) {
            Object obj = con.newInstance();
            dependencies.add(obj);
        } else {
            for(Class clazz : parameters) {
                Object obj = beans.get(clazz.getName());
                if (obj == null) {
                    Constructor _con = clazz.getDeclaredConstructors()[0];
                    if(_con.getParameterTypes().length == 0) {
                        obj = _con.newInstance();
                    } else {
                        List<Object> deps = resolveDependencies(clazz.getName(), _con);
                        obj = _con.newInstance(deps.toArray());
                    }
                }
                dependencies.add(obj);
                }
            }
        return dependencies;
        }

        private List<Class> getClassNames(String rootPath, String packageName) {
        List<Class> classes = new ArrayList<>();
        List<File> files = getFiles(rootPath);
        for(File file : files) {
            String path = file.getAbsolutePath();
            String className = packageName + "." + path.replace(rootPath + File.separator, "")
                    .replace(".class", "").replace(File.separator, ".");
            try{
                Class cls = Class.forName(className);
                classes.add(cls);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classes;
        }

        private List<File> getFiles(String rootPath) {
            List<File> items = new ArrayList<>();
            File[] files = new File(rootPath).listFiles();
            if(files == null) return items;
            for(File file : files) {
                if(file.isDirectory()) {
                    List<File> _files = getFiles(file.getAbsolutePath());
                    if(!_files.isEmpty()) items.addAll(_files);
                } else{
                    items.add(file);
                }
            }
            return items;
        }
    }



