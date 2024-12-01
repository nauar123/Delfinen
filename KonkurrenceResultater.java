import java.util.ArrayList;

public class KonkurrenceResultater {

        protected int tid;
        protected String svoemmeDiciplin;
        protected String distance;
        protected ArrayList<Konkurrence> konkurrence = new ArrayList();

        public KonkurrenceResultater(){}

        public KonkurrenceResultater(int tid, String svoemmeDiciplin, String distance)
        {
            this.tid = tid;
            this.svoemmeDiciplin = svoemmeDiciplin;
            this.distance = distance;
        }

        public int getTid()
        {
            return tid;
        }

        public String getSvoemmeDiciplin()
        {
            return svoemmeDiciplin;
        }
        public String getDistance()
        {
            return distance;
        }
        public ArrayList<Konkurrence> getKonkurrence()
        {
            return konkurrence;
        }


}
