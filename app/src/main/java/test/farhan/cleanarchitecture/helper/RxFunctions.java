package test.farhan.cleanarchitecture.helper;

import android.content.Context;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class RxFunctions {
    private static final String TAG = "RxFunctions";

    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    private static Observable<String> booleanObservable(String acces_token) {
        return Observable.just(acces_token);
    }


}
