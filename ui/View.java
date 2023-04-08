package ui;
import java.io.IOException;
import presenter.Presenter;
import tree.Tree;
public interface View<T> {
    int start() throws ClassNotFoundException, IOException;

    void print(Tree<T> answer);

    void setPresenter(Presenter<T> presenter);

}
