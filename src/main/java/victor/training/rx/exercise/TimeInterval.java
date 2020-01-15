package victor.training.rx.exercise;

import lombok.extern.slf4j.Slf4j;
import rx.Single;
import rx.schedulers.Schedulers;
import victor.training.rx.ConcurrencyUtil;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TimeInterval
{
    public static void main(String[] args) {

        Single.just("b")
                .subscribe(v -> log.debug(v));




        Single.just("a")

                .delay(1, TimeUnit.SECONDS, Schedulers.io())
                .doOnEach(v -> log.debug("v: " + v))
                .delay(1, TimeUnit.SECONDS)
                .doOnEach(v -> log.debug("v: " + v))
                .delay(1, TimeUnit.SECONDS)
                .doOnEach(v -> log.debug("v: " + v))
//                .timeout(500, TimeUnit.MILLISECONDS)
//                .doOnEach(bou -> ThreadUtils.sleep(2000))
                .onErrorReturn(t -> "error")
                .map(s -> {
                    log.debug("Rulez");
                    return s.toUpperCase();
                })
                .subscribe(System.out::println, t -> log.error(t.getMessage(),t));

        ConcurrencyUtil.sleep(4000);
    }
}
