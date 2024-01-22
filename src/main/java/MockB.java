public interface MockB {

    default void foo() {
        System.out.println("xyz");
    }

    void dumb();

}
