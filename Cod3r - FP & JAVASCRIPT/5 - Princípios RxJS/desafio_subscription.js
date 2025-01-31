const { timer, interval, noop } = require('rxjs')

const intervalConst = interval(500);
const timerConst = timer(3000).subscribe(
    n => console.log('Timer: ', n), 
    noop, 
    () => {
        const subscription = intervalConst.subscribe(n => console.log('Interval:', n));
        timer(10000).subscribe(() => {subscription.unsubscribe()});
    });
