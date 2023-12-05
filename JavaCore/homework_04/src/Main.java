
import MVP.Presenter;

public class Main {
    public static void main(String[] args) {

        Presenter trustBank = Presenter.createPresenter();
        trustBank.init();
    }


}