public interface Interf<T> {
    default void method() {
        System.out.println(this.getClass().getName());
        Class<T> tClass = (Class<T>) this.getClass();
    }
}
