public class MockImpl implements MockA, MockB {

    @Override
    public void foo() {
        MockB.super.foo();
    }

    @Override
    public void dumb() {

    }
}
