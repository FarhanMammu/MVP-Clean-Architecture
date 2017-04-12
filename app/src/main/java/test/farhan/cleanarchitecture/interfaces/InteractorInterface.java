package test.farhan.cleanarchitecture.interfaces;


public interface InteractorInterface {
    interface DatafromServer<T> {
        void onSetData(T data);
        void setError(String message);
        void Nointerneterror();
    }

    void getItems(DatafromServer datafromServer);

}
