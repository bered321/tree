package presenter;


import java.io.IOException;
import service.Service;
import tree.Tree;
import ui.View;
public class Presenter<T> {
    private View<T> view;
    private Service<T> service;

    public Presenter(View<T> view, Service<T> service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public Tree<T> task(int num, String st) throws ClassNotFoundException, IOException {
        Tree<T> answer = service.get(num, st);
        return answer;
    }
}
