public class NewTimer {
    private int seconds = 0;
    static int createdTimers = 0;

    private class TimeDate {
        public int hours;
        public int minutes;
        public int seconds;
        public TimeDate(int s) {
            hours = s / 3600 % 24;
            minutes = (s / 60) % 60;
            seconds = s % 60;
        }
    }

    NewTimer() {
        createdTimers++;
        System.out.print("make new Timer with ");
        seconds = 0;

        System.out.println(this);
    }

    NewTimer(int h, int m, int s) {
        createdTimers++;
        System.out.print("make new Timer with ");
        setSeconds(s + 60 * m + 3600 * h);

        System.out.println(this);
    }

    private void setSeconds(int s) {
        seconds = s % (60 * 60 * 24); // limit to one day

        // roll-back prevention. Emulates a modulo operator because the % in Java is a remainder operator.
        if(seconds < 0)
            seconds = (60 * 60 * 24) + seconds;
    }


    public String toString() {
        TimeDate td = new TimeDate(seconds);

        return "time : " + td.hours + ":" + td.minutes + ":" + td.seconds;
    }

    boolean equals(int h, int m, int s) {
        System.out.print(this + " is equal to " + h + ":" + m + ":" + s + " ? ");

        TimeDate td = new TimeDate(seconds);

        return h == td.hours && m == td.minutes && s == td.seconds;
    }

    void hoursIncrement() {
        System.out.println("hours increment ...");

        seconds += 3600;
    }

    void hoursDecrement() {
        System.out.println("hours decrement ...");

        seconds -= 3600;
    }

    void secondsIncrement() {
        seconds += 1;
    }

    void secondsIncrement(int n) {
        if(n >= 60) {
            System.out.println("zle dane");
            return;
        }

        System.out.println("seconds increment " + n + " times");

        while(n > 0) {
            secondsIncrement();
            n--;
        }
    }

    int compare(int h, int m, int s) {
        System.out.println(this + " compare with " + h + ":" + m + ":" + s);

        System.out.println("1 > , -1 <, 0 ==");

        int otherSeconds = 3600 * h + 60 * m + s;

        int difference = seconds - otherSeconds;

        if(difference < -1)
            difference = -1;
        else if(difference > 1)
            difference = 1;

        return difference;
    }
}
