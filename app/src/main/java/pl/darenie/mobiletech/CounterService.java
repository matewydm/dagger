package pl.darenie.mobiletech;

public class CounterService {
    private Long count;


    public CounterService() {
        count=0L;
    }

    public void add(){
        count++;
    }

    public void subtract(){
        count --;
    }

    public Long getCount() {
        return count;
    }
}
