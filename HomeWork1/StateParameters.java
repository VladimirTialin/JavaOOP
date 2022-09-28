

public abstract class StateParameters {
    private boolean work;
    protected String msg;
    public void open(String label){
        this.work=false;
        System.out.println(label);
    }
    public void close(String label){
        this.work=true;
        System.out.println(label);

    }
    public void start(){
        this.work=true;
        System.out.println(msg);
    }
    public void stop(){
        this.work=false;
        System.out.println(msg);
    }
    public boolean getStatus() {
        return work;
    }
    public void warning(){
        System.out.println("Внимание (!)");
    }
}
