const { Observable, Subject } = require('rxjs')

function getObservable(){
    return new Observable(subscriber => {
        setTimeout(() => {
            console.log("#1 Observable")
            subscriber.next(Math.random())
        }, 1000);
    })
}

const obs = getObservable()
obs.subscribe(console.log)
obs.subscribe(console.log)


function getSubject(){
    const sub = new Subject()
    setTimeout(() => {
        console.log("#1 Subject")
        sub.next(Math.random())
    }, 1000);
    return sub;
}

const sub = getSubject()
sub.subscribe(console.log)
sub.subscribe(console.log)