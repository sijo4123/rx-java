package victor.training.rx;

import rx.Observable;

import java.util.concurrent.TimeUnit;

public class StartWith {
    public static void main(String[] args) {

        Observable<Long> time = Observable.interval(100, TimeUnit.MILLISECONDS);

        Observable<Long> a = Observable.just(100L, 200L, 300L);

        time.startWith(a)
                .take(10)
                .toBlocking()
                .subscribe(System.out::println);


        vmChangedObs()
                .flatMap(tick -> httpVrajeala(1L))
                .map(x -> false)
                .startWith(true)
                .toBlocking()
                .subscribe(x -> uiBlock(x));

        // TODO cursu viitor: gpsObs().startWith(GPSacum()).subscribe(handleLocation)


    }

    private static Observable<Long> vmChangedObs() {
        return Observable.timer(1000, TimeUnit.MILLISECONDS);
    }

    public static void uiBlock(boolean enabled) {
        System.out.println("UI block: " + enabled);
    }

    public static Observable<String> httpVrajeala(long movieId) {
        return Observable.just("a","b")
                .delay(3, TimeUnit.SECONDS);
    }
}
