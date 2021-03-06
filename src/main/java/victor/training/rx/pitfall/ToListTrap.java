package victor.training.rx.pitfall;

import rx.subjects.PublishSubject;

import java.util.ArrayList;

public class ToListTrap {
    public static void main(String[] args) {

        PublishSubject<String> p = PublishSubject.create();
        p/*.toList()*/.subscribe(System.out::println);

        p.onNext("a");
        p.onNext("b");

        p.onCompleted(); // what if...
    }
}
