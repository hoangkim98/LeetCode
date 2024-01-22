public interface MockA {

    default void foo() {
        System.out.println("abc");
    }

    void dumb();

}
