package ru.geekbrains.mvp;

public class Presenter {

    private final Model model;

    private final View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void execute() {
        model.setFirst(view.getValue("Введите первое число "));
        model.setSecond(view.getValue("Введите второе число "));
        int operation =view.getOperation("Введите операцию: ");
        switch (operation){
            case 1:{
                view.print(model.getFirst()+" + "+model.getSecond()+" = "+ model.getSum());
                break;
            }
            case 2:{
                view.print(model.getFirst()+" - "+model.getSecond()+" = "+ model.getSub());
                break;
            }
            case 3:{
                view.print(model.getFirst()+" * "+model.getSecond()+" = "+model.getMulti());
                break;
            }
            case 4:{
                view.print(model.getFirst()+" / "+model.getSecond()+" = ");
                view.printDiv(model.getDiv());
                break;
            }
            default:
                System.out.println("Неверная операция!");
        }
    }

    private static class MockView implements View {

        private int count = 0;
        private int operation;

        public MockView(int operation) {
            this.operation=operation;
        }

        @Override
        public int getValue(String message) {
            count++;
            return operation;
        }

        @Override
        public void print(String message) {
            switch (this.operation) {
                case 1:
                    if (!message.equals("Сумма = 2")) throw new AssertionError("Incorrect sum");
                    break;
                case 2:
                    if (!message.equals("Разность = 0")) throw new AssertionError("Incorrect sub");
                    break;
                case 3:
                    if (!message.equals("Умножение = 9")) throw new AssertionError("Incorrect multi");
                    break;
                case 4:
                    if (!message.equals("Деление = 1.0")) throw new AssertionError("Incorrect div");
                    break;
            }
        }

        @Override
        public int getOperation(String message) {
            return operation;
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        MockView mockViewSum = new MockView(1);
        MockView mockViewSub = new MockView(2);
        MockView mockViewMulti = new MockView(3);
        MockView mockViewDiv = new MockView(4);
        Presenter presenterSum = new Presenter(model, mockViewSum);
        Presenter presenterSub = new Presenter(model, mockViewSub);
        Presenter presenterMulti = new Presenter(model, mockViewMulti);
        Presenter presenterDiv = new Presenter(model, mockViewDiv);
        presenterSum.execute();
        presenterSub.execute();
        presenterMulti.execute();
        presenterDiv.execute();
        if (mockViewSum.getCount() != 2 || mockViewSub.getCount() != 2 ||
                mockViewMulti.getCount() != 2 || mockViewDiv.getCount() != 2) {
            throw new AssertionError("Incorrect call of getValue()");
        }
    }
}