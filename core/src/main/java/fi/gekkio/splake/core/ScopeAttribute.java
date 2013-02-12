package fi.gekkio.splake.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import org.zkoss.zk.ui.ext.Scope;

import com.google.common.base.Preconditions;

import fi.gekkio.drumfish.lang.Option;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class ScopeAttribute<T> {

    public final String name;

    public static <T> ScopeAttribute<T> create(String name) {
        Preconditions.checkNotNull(name, "name cannot be null");
        return new ScopeAttribute<T>(name);
    }

    public static <T> ScopeAttribute<T> create(Class<?> namespace, String name) {
        Preconditions.checkNotNull(namespace, "namespace cannot be null");
        Preconditions.checkNotNull(name, "name cannot be null");
        return create(namespace.getName() + "." + name);
    }

    public static <T> ScopeAttribute<T> create(String name, Class<T> clazz) {
        return create(name);
    }

    public static <T> ScopeAttribute<T> create(Class<?> namespace, String name, Class<T> clazz) {
        return create(namespace, name);
    }

    @SuppressWarnings("unchecked")
    public Option<T> getValue(Scope s) {
        Preconditions.checkNotNull(s, "scope cannot be null");
        return Option.option((T) s.getAttribute(name));
    }

    public void setValue(Scope s, T value) {
        Preconditions.checkNotNull(s, "scope cannot be null");
        s.setAttribute(name, value);
    }

    public void clear(Scope s) {
        Preconditions.checkNotNull(s, "scope cannot be null");
        s.removeAttribute(name);
    }

}