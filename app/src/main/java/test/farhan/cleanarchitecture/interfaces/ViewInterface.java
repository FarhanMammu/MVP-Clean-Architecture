package test.farhan.cleanarchitecture.interfaces;


public interface ViewInterface<T> {
    void showprogress();
    void onerror(String type);
    void Showitems(T model);
    void onServerError(String s);
    void onNointernet();
    void hideprogress();
}
